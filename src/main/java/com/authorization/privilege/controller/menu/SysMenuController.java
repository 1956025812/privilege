package com.authorization.privilege.controller.menu;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.menu.SysMenuReadService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.menu.SysMenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 菜单控制类
 */
@Api(tags = {"SysMenuController"}, description = "菜单Controller")
@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController {


    @Autowired
    private SysMenuReadService sysMenuReadService;


    @ApiOperation("查询菜单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "type", value = "类型: 1：菜单; 2：按钮", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统KEY", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "parentMid", value = "父菜单ID", required = false),
    })
    @GetMapping("/list")
    public ResultVO<List<SysMenuVO>> selectSysMenuVOList(@ApiIgnore SysMenuVO sysMenuVO) throws Exception {
        return this.sysMenuReadService.selectSysMenuVOList(sysMenuVO);
    }


    @ApiOperation("查询菜单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "mid", value = "菜单ID", required = true)
    })
    @GetMapping("/detail")
    public ResultVO<SysMenuVO> selectSysMenuVODetail(@ApiIgnore SysMenuVO sysMenuVO) throws Exception {
        return this.sysMenuReadService.selectSysMenuVODetail(sysMenuVO);
    }


}
