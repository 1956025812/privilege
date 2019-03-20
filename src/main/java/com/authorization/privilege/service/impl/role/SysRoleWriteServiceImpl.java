package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.mapper.dsprivilegewrite.role.SysRoleWriteMapper;
import com.authorization.privilege.service.role.SysRoleWriteService;
import com.authorization.privilege.util.CommonUtil;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author duxuebo
 * @date 2019/3/20
 * @description 角色写SERVICE实现类
 */
@Service
public class SysRoleWriteServiceImpl implements SysRoleWriteService {

    @Autowired
    private SysRoleWriteMapper sysRoleWriteMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResultVO<Void> saveSysRole(SysRoleVO sysRoleVO) throws Exception {

        SysRole sysRole = new SysRole();
        sysRole.setRid(CommonUtil.generatorId());
        sysRole.setRoleName(sysRoleVO.getRoleName());
        sysRole.setDescription(sysRoleVO.getDescription());
        sysRole.setSid(sysRoleVO.getSid());
        sysRole.setSystemKey(sysRoleVO.getSystemKey());
        sysRole.setParentRid(sysRoleVO.getParentRid());
        sysRole.setState(1);
        sysRole.setCreateUid(sysRoleVO.getLoginUid());
        sysRole.setCreateTime(LocalDateTime.now());

        this.sysRoleWriteMapper.insertSelective(sysRole);

        return ResultVO.getSuccess("新增角色成功");
    }
}
