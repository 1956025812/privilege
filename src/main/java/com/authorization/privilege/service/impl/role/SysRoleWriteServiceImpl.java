package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.constant.role.SysRoleEnumsInterface;
import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.mapper.dsprivilegeread.role.SysRoleReadMapper;
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
 * @date 2019/4/1
 * @description 角色写SERVICE接口实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysRoleWriteServiceImpl implements SysRoleWriteService {

    @Autowired
    private SysRoleWriteMapper sysRoleWriteMapper;

    @Autowired
    private SysRoleReadMapper sysRoleReadMapper;


    @Override
    public ResultVO<Void> saveSysRole(SysRoleVO sysRoleVO) throws Exception {

        SysRole sysRole = new SysRole();
        sysRole.setRid(CommonUtil.generatorId());
        sysRole.setSystemKey(sysRoleVO.getSystemKey());
        sysRole.setParentRid(sysRoleVO.getParentRid());
        sysRole.setRoleName(sysRoleVO.getRoleName());
        sysRole.setDescription(sysRoleVO.getDescription());
        sysRole.setLevel(sysRoleVO.getLevel());
        sysRole.setState(SysRoleEnumsInterface.State.START.getIntIndex());
        sysRole.setCreateUid(sysRoleVO.getLoginUid());
        sysRole.setCreateTime(LocalDateTime.now());
        this.sysRoleWriteMapper.insertSelective(sysRole);

        return ResultVO.getSuccess("新增角色成功");
    }


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


    @Override
    public ResultVO<Void> delRole(SysRoleVO sysRoleVO) throws Exception {

        // 如果角色有子角色，则不允许删除
        SysRoleVO newSysRoleVO = new SysRoleVO();
        newSysRoleVO.setParentRid(sysRoleVO.getRid());
        Integer childrenRoleCount = this.sysRoleReadMapper.selectCountOfSysRoleList(newSysRoleVO);
        if (childrenRoleCount > 0) {
            return ResultVO.getFailed("该角色有子角色，不允许删除");
        }

        // 删除角色
        SysRole sysRole = new SysRole();
        sysRole.setRid(sysRoleVO.getRid());
        sysRole.setState(SysRoleEnumsInterface.State.DEL.getIntIndex());
        sysRole.setUpdateUid(sysRoleVO.getLoginUid());
        sysRole.setUpdateTime(LocalDateTime.now());
        this.sysRoleWriteMapper.updateByPrimaryKeySelective(sysRole);

        return ResultVO.getSuccess("删除角色成功");
    }
}
