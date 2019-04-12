package com.authorization.privilege.mapper.dsprivilegewrite.role;


import com.authorization.privilege.entity.dsprivelege.role.RoleMenu;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 角色菜单关联写MAPPER接口
 */
public interface RoleMenuWriteMapper {


    /**
     * 新增角色菜单关联对象
     *
     * @param roleMenu
     * @throws Exception
     */
    void insertSelective(RoleMenu roleMenu) throws Exception;


    /**
     * 修改角色菜单关联对象(可选)
     *
     * @param roleMenu
     * @throws Exception
     */
    void updateByPrimaryKeySelective(RoleMenu roleMenu) throws Exception;


    /**
     * 修改角色菜单关联对象
     *
     * @param roleMenu
     * @throws Exception
     */
    void updateByPrimaryKey(RoleMenu roleMenu) throws Exception;
}