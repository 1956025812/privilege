package com.authorization.privilege.service.role;

import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色读SERVICE接口
 */
public interface SysRoleReadService {

    /**
     * 查询角色分页列表
     *
     * @param sysRoleVO
     * @return PageVO
     * @throws Exception
     */
    ResultVO<PageVO<SysRoleVO>> selectSysRoleVOPage(SysRoleVO sysRoleVO) throws Exception;
}
