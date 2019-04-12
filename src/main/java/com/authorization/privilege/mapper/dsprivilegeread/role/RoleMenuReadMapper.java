package com.authorization.privilege.mapper.dsprivilegeread.role;


import com.authorization.privilege.entity.dsprivelege.role.RoleMenu;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 角色菜单关联读MAPPER接口
 */
public interface RoleMenuReadMapper {


    /**
     * 根据主键查询角色菜单对象
     *
     * @param rmid
     * @return RoleMenu
     * @throws Exception
     */
    RoleMenu selectByPrimaryKey(String rmid) throws Exception;

}