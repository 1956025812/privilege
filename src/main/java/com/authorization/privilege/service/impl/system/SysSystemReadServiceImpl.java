package com.authorization.privilege.service.impl.system;

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
import org.springframework.util.StringUtils;

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

        // 查询用户ID和名称列表
        UserVO userVO = new UserVO();
        Map<String, String> userIdAndNameMap = this.userReadMapper.selectUserIdAndNameMap(userVO);

        // 查询系统分页列表
        PageHelper.startPage(sysSystemVO.getCurrentPage(), sysSystemVO.getPageSize());
        List<SysSystemVO> sysSystemVOList = this.sysSystemReadMapper.selectSysSystemPage(sysSystemVO);


        // 处理列表冗余字段
        if (!CollectionUtils.isEmpty(sysSystemVOList)) {
            sysSystemVOList.forEach(eachSysSystemVO -> {

                // 处理创建人名称
                if (!CollectionUtils.isEmpty(userIdAndNameMap)) {
                    eachSysSystemVO.setCreateName(userIdAndNameMap.get(eachSysSystemVO.getCreateUid()) == null ?
                            null : userIdAndNameMap.get(eachSysSystemVO.getCreateUid()));
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
            Map<String, String> userIdAndNameMap = this.userReadMapper.selectUserIdAndNameMap(userVO);
            if (!CollectionUtils.isEmpty(userIdAndNameMap)) {
                detailSysSystemVO.setCreateName(userIdAndNameMap.get(detailSysSystemVO.getCreateUid()) == null ?
                        null : userIdAndNameMap.get(detailSysSystemVO.getCreateUid()));
                detailSysSystemVO.setUpdateName(userIdAndNameMap.get(detailSysSystemVO.getUpdateUid()) == null ?
                        null : userIdAndNameMap.get(detailSysSystemVO.getUpdateUid()));
            }
        }

        return ResultVO.getSuccess("查询系统对象详情成功", detailSysSystemVO);
    }
}




