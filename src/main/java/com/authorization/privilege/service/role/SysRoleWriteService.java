package com.authorization.privilege.service.role;

import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;

/**
 * @author duxuebo
 * @date 2019/3/20
 * @description 角色写SERVICE
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
}
