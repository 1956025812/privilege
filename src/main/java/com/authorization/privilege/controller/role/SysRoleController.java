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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

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


    @ApiOperation("修改角色")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "rid", value = "角色ID", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "roleName", value = "角色名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "description", value = "角色描述", required = false)
    })
    @PostMapping("/update")
    public ResultVO<Void> updateSysRole(@ApiIgnore @RequestBody SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleWriteService.updateSysRole(sysRoleVO);
    }



    @ApiOperation("删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "rid", value = "角色ID", required = false)
    })
    @PostMapping("/del")
    public ResultVO<Void> delRole(@ApiIgnore @RequestBody SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleWriteService.delRole(sysRoleVO);
    }



    @ApiOperation("查询角色分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "currentPage", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "pageSize", value = "每页记录数", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "level", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "parentRid", value = "父角色ID", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "roleName", value = "角色名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "startTime", value = "创建开始时间", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "endTime", value = "创建结束时间", required = false)
    })
    @GetMapping("/page")
    public ResultVO<PageVO<SysRoleVO>> selectSysRoleVOPage(@ApiIgnore SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleReadService.selectSysRoleVOPage(sysRoleVO);
    }



    @ApiOperation("查询角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "parentRid", value = "父角色ID", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "level", value = "角色级别", required = false)
    })
    @GetMapping("/list")
    public ResultVO<List<SysRoleVO>> selectSysRoleVOList(@ApiIgnore SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleReadService.selectSysRoleVOList(sysRoleVO);
    }


    @ApiOperation("查询角色详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "rid", value = "角色ID", required = true)
    })
    @GetMapping("/detail")
    public ResultVO<SysRoleVO> selectSysRoleVODetail(@ApiIgnore SysRoleVO sysRoleVO) throws Exception {
        return this.sysRoleReadService.selectSysRoleVODetail(sysRoleVO);
    }



}
