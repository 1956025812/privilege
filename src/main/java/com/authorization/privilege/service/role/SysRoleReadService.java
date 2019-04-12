package com.authorization.privilege.service.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;

import java.util.List;

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


    /**
     * 查询角色列表
     *
     * @param sysRoleVO
     * @return SysRoleVO集合
     * @throws Exception
     */
    ResultVO<List<SysRoleVO>> selectSysRoleVOList(SysRoleVO sysRoleVO) throws Exception;


    /**
     * 查询角色详情
     *
     * @param sysRoleVO
     * @return SysRoleVO
     * @throws Exception
     */
    ResultVO<SysRoleVO> selectSysRoleVODetail(SysRoleVO sysRoleVO) throws Exception;
}
