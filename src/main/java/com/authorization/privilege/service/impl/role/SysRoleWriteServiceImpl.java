package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.mapper.dsprivilegewrite.role.SysRoleWriteMapper;
import com.authorization.privilege.service.role.SysRoleWriteService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色写SERVICE接口实现类
 */
@Service
public class SysRoleWriteServiceImpl implements SysRoleWriteService {

    @Autowired
    private SysRoleWriteMapper sysRoleWriteMapper;


    @Override
    public ResultVO<Void> updateSysRole(SysRoleVO sysRoleVO) throws Exception {

        SysRole sysRole = new SysRole();
        sysRole.setRid(sysRoleVO.getRid());
        sysRole.setRoleName(sysRoleVO.getRoleName());
        sysRole.setDescription(sysRoleVO.getDescription());
        sysRole.setUpdateUid(sysRoleVO.getLoginUid());
        sysRole.setUpdateTime(LocalDateTime.now());

        this.sysRoleWriteMapper.updateByPrimaryKeySelective(sysRole);

        return ResultVO.getSuccess("修改角色成功");
    }
}
