package com.authorization.privilege.service.menu;

import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;

import java.util.List;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单读SERVICE接口
 */
public interface SysMenuReadService {


    /**
     * 查询菜单列表
     *
     * @param sysMenuVO
     * @return SysMenuVO集合
     * @throws Exception
     */
    ResultVO<List<SysMenuVO>> selectSysMenuVOList(SysMenuVO sysMenuVO) throws Exception;
}
