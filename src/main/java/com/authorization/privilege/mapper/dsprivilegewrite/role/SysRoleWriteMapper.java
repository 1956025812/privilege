package com.authorization.privilege.mapper.dsprivilegewrite.role;


import com.authorization.privilege.entity.dsprivelege.role.SysRole;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 角色写MAPPER接口
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
     * 修改角色接口(可选)
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