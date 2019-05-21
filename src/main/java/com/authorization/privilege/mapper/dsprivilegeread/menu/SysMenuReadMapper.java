package com.authorization.privilege.mapper.dsprivilegeread.menu;

import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;
import com.authorization.privilege.vo.menu.SysMenuVO;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
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


    /**
     * 查询菜单列表数量
     *
     * @param newSysMenuVO
     * @return 菜单列表数量
     * @throws Exception
     */
    Integer selectCountOfSysMenuList(SysMenuVO newSysMenuVO) throws Exception;


    /**
     * 单表查询菜单列表
     *
     * @param sysMenuVO
     * @return SysMenuVO集合
     * @throws Exception
     */
    List<SysMenuVO> selectSysMenuList(SysMenuVO sysMenuVO) throws Exception;


    /**
     * 查询菜单ID和菜单VO对象MAP集合
     *
     * @param sysMenuVO
     * @return 菜单ID和菜单VO对象MAP集合
     * @throws Exception
     */
    @MapKey("mid")
    HashMap<String, SysMenuVO> selectMenuIdAndSysMenuVOMap(SysMenuVO sysMenuVO) throws Exception;
}