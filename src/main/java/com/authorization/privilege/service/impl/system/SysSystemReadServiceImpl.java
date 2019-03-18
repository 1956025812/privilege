package com.authorization.privilege.service.impl.system;

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


    @Override
    public ResultVO<Void> exportSysSystemExcel(SysSystemVO sysSystemVO) throws Exception {




        return ResultVO.getSuccess("导出系统列表EXCEL成功");
    }
}




