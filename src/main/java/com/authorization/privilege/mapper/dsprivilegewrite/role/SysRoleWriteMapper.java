package com.authorization.privilege.mapper.dsprivilegewrite.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;

/**
 * @author duxuebo
 * @date 2019/3/20
 * @description 角色写MAPPER
 */
public interface SysRoleWriteMapper {


    /**
     * 新增角色接口
     *
     * @param sysRole
     * @throws Exception
     */
    void insertSelective(SysRole sysRole) throws Exception;


    /**
     * 修改角色接口可选字段
     *
     * @param sysRole
     * @throws Exception
     */
    void updateByPrimaryKeySelective(SysRole sysRole) throws Exception;


    /**
     * 修改角色接口
     *
     * @param sysRole
     * @throws Exception
     */
    void updateByPrimaryKey(SysRole sysRole) throws Exception;


}
