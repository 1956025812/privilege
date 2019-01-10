package com.authorization.privilege.mapper.dsprivilegewrite.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;


/**
 * 系统类写接口
 */
public interface SysSystemWriteMapper {


    /**
     * 新增系统对象
     *
     * @param sysSystem
     * @throws Exception
     */
    void insertSelective(SysSystem sysSystem) throws Exception;


    /**
     * 修改系统对象
     *
     * @param sysSystem
     * @throws Exception
     */
    void updateByPrimaryKey(SysSystem sysSystem) throws Exception;


    /**
     * 修改系统对象(可选)
     *
     * @param sysSystem
     * @throws Exception
     */
    void updateByPrimaryKeySelective(SysSystem sysSystem) throws Exception;



}