package com.authorization.privilege.mapper.dsprivilegeread.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.authorization.privilege.vo.system.SysSystemVO;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.List;

/**
 * 系统读MAPPER接口
 */
public interface SysSystemReadMapper {

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


    /**
     * 查询系统对象详情
     *
     * @param sysSystemVO
     * @return SysSystemVO
     * @throws Exception
     */
    SysSystemVO selectSysSystemVODetail(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 查询系统KEY和系统VO对象MAP
     *
     * @param sysSystemVO
     * @return 系统KEY和系统VO对象MAP
     * @throws Exception
     */
    @MapKey("systemKey")
    HashMap<String, SysSystemVO> selectSystemKeyAndSystemVOMap(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 查询系统VO对象列表
     *
     * @param sysSystemVO
     * @return SysSystemVO集合
     * @throws Exception
     */
    List<SysSystemVO> selectSysSystemVOList(SysSystemVO sysSystemVO) throws Exception;


    /**
     * 查询系统VO对象列表数量
     *
     * @param sysSystemVO
     * @return VO对象列表数量
     * @throws Exception
     */
    Integer selectCountSysSystemVOList(SysSystemVO sysSystemVO) throws Exception;
}