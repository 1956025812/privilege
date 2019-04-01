package com.authorization.privilege.mapper.dsprivilegeread.role;


import com.authorization.privilege.entity.dsprivelege.role.SysRole;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 菜单读MAPPER接口
 */
public interface SysRoleReadMapper {

    /**
     * 根据主键查询角色对象
     *
     * @param rid
     * @return SysRole
     * @throws Exception
     */
    SysRole selectByPrimaryKey(String rid) throws Exception;

}