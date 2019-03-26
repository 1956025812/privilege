package com.authorization.privilege.service.menu;

import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单写SERVICE接口
 */
public interface SysMenuWriteService {


    /**
     * 新增菜单
     *
     * @param sysMenuVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> saveSysMenuVO(SysMenuVO sysMenuVO) throws Exception;


    /**
     * 修改菜单
     *
     * @param sysMenuVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> updateSysMenuVO(SysMenuVO sysMenuVO) throws Exception;


    /**
     * 删除菜单
     *
     * @param sysMenuVO
     * @return VOID
     * @throws Exception
     */
    ResultVO<Void> delSysMenuVO(SysMenuVO sysMenuVO) throws Exception;
}
