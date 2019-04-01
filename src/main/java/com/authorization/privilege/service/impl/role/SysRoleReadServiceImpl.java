package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.authorization.privilege.mapper.dsprivilegeread.role.SysRoleReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色读SERVICE接口实现类
 */
@Service
public class SysRoleReadServiceImpl implements SysRoleReadMapper {

    @Autowired
    private SysRoleReadMapper sysRoleReadMapper;



    @Override
    public SysRole selectByPrimaryKey(String rid) throws Exception {
        return null;
    }
}
