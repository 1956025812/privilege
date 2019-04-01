package com.authorization.privilege.service.impl.role;

import com.authorization.privilege.mapper.dsprivilegewrite.role.SysRoleWriteMapper;
import com.authorization.privilege.service.role.SysRoleWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色写SERVICE接口实现类
 */
@Service
public class SysRoleWriteServiceImpl implements SysRoleWriteService {

    @Autowired
    private SysRoleWriteMapper sysRoleWriteMapper;





}
