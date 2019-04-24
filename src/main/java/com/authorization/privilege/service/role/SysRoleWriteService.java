package com.authorization.privilege.service.role;

import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色写SERVICE接口
 */
public interface SysRoleWriteService {


    /**
     * 新增角色
     *
     * @param sysRoleVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> saveSysRole(SysRoleVO sysRoleVO) throws Exception;


    /**
     * 修改角色
     *
     * @param sysRoleVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> updateSysRole(SysRoleVO sysRoleVO) throws Exception;


    /**
     * 删除角色
     *
     * @param sysRoleVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> delRole(SysRoleVO sysRoleVO) throws Exception;



}
