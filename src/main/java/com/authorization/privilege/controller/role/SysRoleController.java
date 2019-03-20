package com.authorization.privilege.controller.role;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.role.SysRoleWriteService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author duxuebo
 * @date 2019/3/20
 * @description 角色控制类
 */
@Api(tags = {"SysRoleController"}, description = "角色Controller")
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleWriteService sysRoleWriteService;


    @ApiOperation("新增系统对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "roleName", value = "系统名称", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "description", value = "描述", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "sid", value = "系统ID", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "parentRid", value = "父角色ID", required = false)
    })
    @PostMapping("/save")
    public ResultVO<Void> saveSysRole(@RequestBody @ApiIgnore SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleWriteService.saveSysRole(sysRoleVO);
    }


}
