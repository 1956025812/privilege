package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.constant.role.SysRoleEnumsInterface;
import com.authorization.privilege.mapper.dsprivilegeread.role.SysRoleReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.system.SysSystemReadMapper;
import com.authorization.privilege.mapper.dsprivilegeread.user.UserReadMapper;
import com.authorization.privilege.service.role.SysRoleReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import com.authorization.privilege.vo.user.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色读SERVICE接口实现类
 */
@Service
public class SysRoleReadServiceImpl implements SysRoleReadService {

    @Autowired
    private SysRoleReadMapper sysRoleReadMapper;

    @Autowired
    private SysSystemReadMapper sysSystemReadMapper;

    @Autowired
    private UserReadMapper userReadMapper;


    @Override
    public ResultVO<PageVO<SysRoleVO>> selectSysRoleVOPage(SysRoleVO sysRoleVO) throws Exception {

        PageHelper.startPage(sysRoleVO.getCurrentPage(), sysRoleVO.getPageSize());
        List<SysRoleVO> sysRoleVOList = this.sysRoleReadMapper.selectSysRoleList(sysRoleVO);

        if (!CollectionUtils.isEmpty(sysRoleVOList)) {

            HashMap<String, SysSystemVO> systemKeyAndSystemVOMap = this.sysSystemReadMapper.selectSystemKeyAndSystemVOMap(new SysSystemVO());
            HashMap<String, UserVO> userIdAndUserVOMap = this.userReadMapper.selectUserIdAndUserVOMap(new UserVO());

            sysRoleVOList.forEach(eachSysRoleVO -> {

                // 处理所属系统冗余字段
                eachSysRoleVO.setSystemName(CollectionUtils.isEmpty(systemKeyAndSystemVOMap) ? null :
                        (systemKeyAndSystemVOMap.get(eachSysRoleVO.getSystemKey()) == null ? null :
                                systemKeyAndSystemVOMap.get(eachSysRoleVO.getSystemKey()).getSystemName())
                );

                // 处理创建人冗余字段
                eachSysRoleVO.setCreateName(CollectionUtils.isEmpty(userIdAndUserVOMap) ? null :
                        (userIdAndUserVOMap.get(eachSysRoleVO.getCreateUid()) == null ? null :
                                userIdAndUserVOMap.get(eachSysRoleVO.getCreateUid()).getNickname()));

                // 处理状态名称冗余字段
                eachSysRoleVO.setRoleStateName(SysRoleEnumsInterface.State.getName(eachSysRoleVO.getState()));

            });
        }

        PageInfo<SysRoleVO> pageInfo = new PageInfo<>(sysRoleVOList);
        PageVO<SysRoleVO> pageVO = new PageVO<>(
                pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal(),
                pageInfo.getPages(), pageInfo.getList()
        );

        return ResultVO.getSuccess("查询角色分页列表成功", pageVO);
    }
}
