package com.authorization.privilege.mapper.dsprivilegeread.menu;

import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;
import com.authorization.privilege.vo.menu.SysMenuVO;

import java.util.List;

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


    /**
     * 查询菜单VO对象集合
     *
     * @param sysMenuVO
     * @return SysMenuVO集合
     * @throws Exception
     */
    List<SysMenuVO> selectSysMenuVOList(SysMenuVO sysMenuVO) throws Exception;



    /**
     * 查询菜单详情
     *
     * @param sysMenuVO
     * @return SysMenuVO
     * @throws Exception
     */
    SysMenuVO selectSysMenuVODetail(SysMenuVO sysMenuVO) throws Exception;
}