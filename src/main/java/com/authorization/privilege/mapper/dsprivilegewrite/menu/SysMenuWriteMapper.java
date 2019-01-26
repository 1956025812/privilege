package com.authorization.privilege.mapper.dsprivilegewrite.menu;

import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;

/**
 * 菜单写接口
 */
public interface SysMenuWriteMapper {


    /**
     * 新增菜单
     *
     * @param sysMenu
     * @throws Exception
     */
    void insertSelective(SysMenu sysMenu) throws Exception;


    /**
     * 修改菜单（字段可选）
     *
     * @param sysMenu
     * @throws Exception
     */
    void updateByPrimaryKeySelective(SysMenu sysMenu) throws Exception;


    /**
     * 修改菜单
     *
     * @param sysMenu
     * @throws Exception
     */
    void updateByPrimaryKey(SysMenu sysMenu) throws Exception;
}