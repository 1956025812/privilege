package com.authorization.privilege.mapper.dsprivilegewrite.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;


/**
 * 系统类写接口
 */
public interface SysSystemMapperWrite {


    /**
     * 新增系统对象
     *
     * @param record
     * @throws Exception
     */
    void insertSelective(SysSystem record) throws Exception;


    /**
     * 修改系统对象
     *
     * @param record
     * @throws Exception
     */
    void updateByPrimaryKeySelective(SysSystem record) throws Exception;

}