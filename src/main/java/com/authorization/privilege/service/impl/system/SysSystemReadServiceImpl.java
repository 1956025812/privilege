package com.authorization.privilege.service.impl.system;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.authorization.privilege.constant.ExcelConstant;
import com.authorization.privilege.constant.system.SysSystemEnum;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.user.UserReadMapper;
import com.authorization.privilege.service.system.SysSystemReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import com.authorization.privilege.vo.user.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象读接口实现类
 */
@Service
public class SysSystemReadServiceImpl implements SysSystemReadService {

    @Autowired
    private SysSystemReadMapper sysSystemReadMapper;

    @Autowired
    private UserReadMapper userReadMapper;


    @Override
    public ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(SysSystemVO sysSystemVO) throws Exception {

        // 查询用户ID和用户VO对象MAP
        UserVO userVO = new UserVO();
        Map<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(userVO);

        // 查询系统分页列表
        PageHelper.startPage(sysSystemVO.getCurrentPage(), sysSystemVO.getPageSize());
        List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemPage(sysSystemVO);


        // 处理列表冗余字段
        if (!CollectionUtils.isEmpty(sysSystemVOList)) {
            sysSystemVOList.forEach(eachSysSystemVO -> {

                // 处理创建人名称
                if (!CollectionUtils.isEmpty(userIdAndUserVOMap)) {
                    UserVO createUserVO = userIdAndUserVOMap.get(eachSysSystemVO.getCreateUid());
                    eachSysSystemVO.setCreateName(createUserVO == null ? null : createUserVO.getNickname());
                }
            });
        }


        // 封装返回分页对象
        PageInfo<SysSystemVO> pageInfo = new PageInfo<>(sysSystemVOList);
        PageVO<SysSystemVO> pageVO = new PageVO<>(
                pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),
                pageInfo.getPages(), pageInfo.getList()
        );

        return ResultVO.getSuccess("查询系统分页列表成功", pageVO);
    }


    @Override
    public ResultVO<SysSystemVO> selectSysSystemVODetail(SysSystemVO sysSystemVO) throws Exception {

        // 查询系统对象
        SysSystemVO detailSysSystemVO = this.sysSystemReadMapper.selectSysSystemVODetail(sysSystemVO);

        if (null != detailSysSystemVO) {

            // 处理创建人昵称和修改人昵称字段
            UserVO userVO = new UserVO();
            Map<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(userVO);
            if (!CollectionUtils.isEmpty(userIdAndUserVOMap)) {

                UserVO createUserVO = userIdAndUserVOMap.get(detailSysSystemVO.getCreateUid());
                detailSysSystemVO.setCreateName(createUserVO == null ? null : createUserVO.getNickname());
                UserVO updateUserVO = userIdAndUserVOMap.get(detailSysSystemVO.getUpdateUid());
                detailSysSystemVO.setUpdateName(updateUserVO == null ? null :
                        (updateUserVO.getNickname() == null ? null : updateUserVO.getNickname()));
            }
        }

        return ResultVO.getSuccess("查询系统对象详情成功", detailSysSystemVO);
    }


    @Override
    public ResultVO<List<SysSystemVO>> selectSysSystemVOList(SysSystemVO sysSystemVO) throws Exception {

        List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemVOList(sysSystemVO);

        return ResultVO.getSuccess("查询系统列表成功", sysSystemVOList);
    }



    /**
     * 方式1： 一次性查询所有的数据进行导出下载，适用于数据量小的情况并且一次查询出来的数据量不会内存溢出
     *
     * @param sysSystemVO
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    public ResultVO<Void> exportSysSystemExcel(SysSystemVO sysSystemVO, HttpServletResponse response) throws Exception {

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            // 设置EXCEL名称
            String fileName = new String(("SystemExcel").getBytes(), "UTF-8");

            // 设置SHEET名称
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("系统列表sheet1");

            // 设置标题
            Table table = new Table(1);
            List<List<String>> titles = new ArrayList<List<String>>();
            titles.add(Arrays.asList("系统名称"));
            titles.add(Arrays.asList("系统标识"));
            titles.add(Arrays.asList("描述"));
            titles.add(Arrays.asList("状态"));
            titles.add(Arrays.asList("创建人"));
            titles.add(Arrays.asList("创建时间"));
            table.setHead(titles);

            // 准备冗余字段
            HashMap<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(new UserVO());

            // 查数据写EXCEL
            List<List<String>> dataList = new ArrayList<>();
            List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemVOList(sysSystemVO);
            if (!CollectionUtils.isEmpty(sysSystemVOList)) {
                sysSystemVOList.forEach(eachSysSystemVO -> {
                    dataList.add(Arrays.asList(
                            eachSysSystemVO.getSystemName(),
                            eachSysSystemVO.getSystemKey(),
                            eachSysSystemVO.getDescription(),
                            SysSystemEnum.getName(eachSysSystemVO.getState()),
                            CollectionUtils.isEmpty(userIdAndUserVOMap) ? null :
                                    (userIdAndUserVOMap.get(eachSysSystemVO.getCreateUid()) == null ? null :
                                            userIdAndUserVOMap.get(eachSysSystemVO.getCreateUid()).getNickname()),
                            eachSysSystemVO.getCreateTime().toString()
                    ));
                });
            }
            writer.write0(dataList, sheet, table);

            // 下载EXCEL
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            writer.finish();
            out.flush();

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return ResultVO.getSuccess("导出系统列表EXCEL成功");
    }



    /**
     * 方式2： 分批查询所有的数据进行导出下载，适用于数据量适中在100W以下的情况并且一次查询出来的数据量不会内存溢出
     *
     * @param sysSystemVO
     * @param response
     * @return
     * @throws Exception
     */
    /*@Override
    public ResultVO<Void> exportSysSystemExcel(SysSystemVO sysSystemVO, HttpServletResponse response) throws Exception {

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            // 设置EXCEL名称
            String fileName = new String(("SystemExcel").getBytes(), "UTF-8");

            // 设置SHEET名称
            Sheet sheet = new Sheet(1, 0);
            sheet.setSheetName("系统列表sheet1");

            // 设置标题
            Table table = new Table(1);
            List<List<String>> titles = new ArrayList<List<String>>();
            titles.add(Arrays.asList("系统名称"));
            titles.add(Arrays.asList("系统标识"));
            titles.add(Arrays.asList("描述"));
            titles.add(Arrays.asList("状态"));
            titles.add(Arrays.asList("创建人"));
            titles.add(Arrays.asList("创建时间"));
            table.setHead(titles);

            // 查数据写EXCEL
            Integer totalRowCount = this.sysSystemReadMapper.selectCountSysSystemVOList(sysSystemVO);
            Integer pageSize = ExcelConstant.PER_WRITE_ROW_COUNT;
            Integer writeCount = totalRowCount % pageSize == 0 ? (totalRowCount / pageSize) : (totalRowCount / pageSize + 1);
            for (int i = 0; i < writeCount; i++) {
                List<List<String>> dataList = new ArrayList<>();

                // 此处查询并封装数据即可 currentPage, pageSize这个变量封装好的 不要改动
                PageHelper.startPage(i + 1, pageSize);
                List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemVOList(sysSystemVO);
                if (!CollectionUtils.isEmpty(sysSystemVOList)) {
                    sysSystemVOList.forEach(eachSysSystemVO -> {
                        dataList.add(Arrays.asList(
                                eachSysSystemVO.getSystemName(),
                                eachSysSystemVO.getSystemKey(),
                                eachSysSystemVO.getDescription(),
                                eachSysSystemVO.getState().toString(),
                                eachSysSystemVO.getCreateUid(),
                                eachSysSystemVO.getCreateTime().toString()
                        ));
                    });
                }
                writer.write0(dataList, sheet, table);
            }

            // 下载EXCEL
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            writer.finish();
            out.flush();

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return ResultVO.getSuccess("导出系统列表EXCEL成功");
    }*/


    /**
     * 方式3： 分批查询所有的数据进行分SHEET导出下载，适用于数据量适中在百万级别的情况并且一次查询出来的数据量不会内存溢出
     *
     * @param sysSystemVO
     * @param response
     * @return VOID
     * @throws Exception
     */
    /*@Override
    public ResultVO<Void> exportSysSystemExcel(SysSystemVO sysSystemVO, HttpServletResponse response) throws Exception {

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);

            // 设置EXCEL名称
            String fileName = new String(("SystemExcel").getBytes(), "UTF-8");

            // 设置SHEET名称
            String sheetName = "系统列表sheet";

            // 设置标题
            Table table = new Table(1);
            List<List<String>> titles = new ArrayList<List<String>>();
            titles.add(Arrays.asList("系统名称"));
            titles.add(Arrays.asList("系统标识"));
            titles.add(Arrays.asList("描述"));
            titles.add(Arrays.asList("状态"));
            titles.add(Arrays.asList("创建人"));
            titles.add(Arrays.asList("创建时间"));
            table.setHead(titles);

            // 查询总数并封装相关变量(这块直接拷贝就行了不要改)
            Integer totalRowCount = this.sysSystemReadMapper.selectCountSysSystemVOList(sysSystemVO);
            Integer perSheetRowCount = ExcelConstant.PER_SHEET_ROW_COUNT;
            Integer pageSize = ExcelConstant.PER_WRITE_ROW_COUNT;
            Integer sheetCount = totalRowCount % perSheetRowCount == 0 ? (totalRowCount / perSheetRowCount) : (totalRowCount / perSheetRowCount + 1);
            Integer previousSheetWriteCount = perSheetRowCount / pageSize;
            Integer lastSheetWriteCount = totalRowCount % perSheetRowCount == 0 ?
                    previousSheetWriteCount :
                    (totalRowCount % perSheetRowCount % pageSize == 0 ? totalRowCount % perSheetRowCount / pageSize : (totalRowCount % perSheetRowCount / pageSize + 1));


            for (int i = 0; i < sheetCount; i++) {

                // 创建SHEET
                Sheet sheet = new Sheet(i, 0);
                sheet.setSheetName(sheetName + i);

                // 写数据 这个j的最大值判断直接拷贝就行了，不要改动
                for (int j = 0; j < (i != sheetCount - 1 ? previousSheetWriteCount : lastSheetWriteCount); j++) {
                    List<List<String>> dataList = new ArrayList<>();

                    // 此处查询并封装数据即可 currentPage, pageSize这俩个变量封装好的 不要改动
                    PageHelper.startPage(j + 1 + previousSheetWriteCount * i, pageSize);
                    List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemVOList(sysSystemVO);
                    if (!CollectionUtils.isEmpty(sysSystemVOList)) {
                        sysSystemVOList.forEach(eachSysSystemVO -> {
                            dataList.add(Arrays.asList(
                                    eachSysSystemVO.getSystemName(),
                                    eachSysSystemVO.getSystemKey(),
                                    eachSysSystemVO.getDescription(),
                                    eachSysSystemVO.getState().toString(),
                                    eachSysSystemVO.getCreateUid(),
                                    eachSysSystemVO.getCreateTime().toString()
                            ));
                        });
                    }
                    writer.write0(dataList, sheet, table);
                }
            }

            // 下载EXCEL
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            writer.finish();
            out.flush();

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return ResultVO.getSuccess("导出系统列表EXCEL成功");
    }*/
}




