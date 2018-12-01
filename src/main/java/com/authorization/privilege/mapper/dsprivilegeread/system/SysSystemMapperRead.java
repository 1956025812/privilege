package com.authorization.privilege.mapper.dsprivilegeread.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.authorization.privilege.vo.system.SysSystemVO;

import java.util.List;

/**
 * 系统类读接口
 */
public interface SysSystemMapperRead {

    /**
     * 根据主键查询系统对象
     *
     * @param sid
     * @return SysSystem
     * @throws Exception
     */
    SysSystem selectByPrimaryKey(String sid) throws Exception;


    /**
     * 查询系统分页列表
     *
     * @param sysSystemVO
     * @return SysSystemVO对象集合
     * @throws Exception
     */
    List<SysSystemVO> selectSysSystemPage(SysSystemVO sysSystemVO) throws Exception;


}