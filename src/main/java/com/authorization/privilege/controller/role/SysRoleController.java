package com.authorization.privilege.controller.role;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.role.SysRoleReadService;
import com.authorization.privilege.service.role.SysRoleWriteService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色控制类
 */
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleReadService sysRoleReadService;

    @Autowired
    private SysRoleWriteService sysRoleWriteService;








}
