package com.authorization.privilege.mapper.dsprivilegeread.role;


import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.vo.role.SysRoleVO;
import org.apache.ibatis.annotations.MapKey;

import java.util.HashMap;
import java.util.List;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 菜单读MAPPER接口
 */
public interface SysRoleReadMapper {

    /**
     * 根据主键查询角色对象
     *
     * @param rid
     * @return SysRole
     * @throws Exception
     */
    SysRole selectByPrimaryKey(String rid) throws Exception;


    /**
     * 查询角色列表
     *
     * @param sysRoleVO
     * @return SysRoleVO集合
     * @throws Exception
     */
    List<SysRoleVO> selectSysRoleList(SysRoleVO sysRoleVO) throws Exception;


    /**
     * 查询角色ID和角色VO对象MAP
     *
     * @param sysRoleVO
     * @return 角色ID和角色VO对象MAP
     * @throws Exception
     */
    @MapKey("rid")
    HashMap<String, SysRoleVO> selectRoleIdAndRoleVOMap(SysRoleVO sysRoleVO) throws Exception;
}