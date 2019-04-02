package com.authorization.privilege.controller.role;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.role.SysRoleReadService;
import com.authorization.privilege.service.role.SysRoleWriteService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.role.SysRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色控制类
 */
@Api(tags = {"SysRoleController"}, description = "角色Controller")
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleReadService sysRoleReadService;

    @Autowired
    private SysRoleWriteService sysRoleWriteService;


    @ApiOperation("查询角色分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "currentPage", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "pageSize", value = "每页记录数", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "parentRid", value = "父角色ID", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "roleName", value = "角色名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "startTime", value = "创建开始时间", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "endTime", value = "创建结束时间", required = false)
    })
    @GetMapping("/page")
    public ResultVO<PageVO<SysRoleVO>> selectSysRoleVOPage(@ApiIgnore SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleReadService.selectSysRoleVOPage(sysRoleVO);
    }



}