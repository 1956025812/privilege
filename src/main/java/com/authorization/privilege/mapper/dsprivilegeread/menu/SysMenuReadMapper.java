package com.authorization.privilege.mapper.dsprivilegeread.menu;

import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;

/**
 * 菜单读MAPPER接口
 */
public interface SysMenuReadMapper {

    /**
     * 根据主键查询菜单
     *
     * @param mid
     * @return SysMenu
     * @throws Exception
     */
    SysMenu selectByPrimaryKey(String mid) throws Exception;

}