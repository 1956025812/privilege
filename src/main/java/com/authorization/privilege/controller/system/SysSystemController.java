package com.authorization.privilege.controller.system;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.system.SysSystemReadService;
import com.authorization.privilege.service.system.SysSystemWriteService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统控制类
 */
@Api(tags = {"SystemController"}, description = "系统Controller")
@RestController
@RequestMapping("/system")
public class SysSystemController extends BaseController {

    @Autowired
    private SysSystemReadService sysSystemReadService;
    @Autowired
    private SysSystemWriteService sysSystemWriteService;


    @ApiOperation("新增系统对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "systemName", value = "系统名称", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "description", value = "系统描述", required = false)
    })
    @PostMapping("/save")
    public ResultVO<Void> saveSysSystem(@RequestBody @ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemWriteService.saveSysSystem(sysSystemVO);
    }


    @ApiOperation("修改系统对象")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "sid", value = "系统ID", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "systemName", value = "系统名称", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "description", value = "系统描述", required = false)
    })
    @PostMapping("/update")
    public ResultVO<Void> updateSysSystem(@RequestBody @ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemWriteService.updateSysSystem(sysSystemVO);
    }


    @ApiOperation("删除系统")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "sid", value = "系统对象ID", required = false),
            @ApiImplicitParam(paramType = "body", dataType = "String", name = "sids", value = "系统对象ID集合", required = false)
    })
    @PostMapping("/del")
    public ResultVO<Void> delSysSystem(@RequestBody @ApiIgnore SysSystemVO sysSystemVO) throws Exception {

        if (StringUtils.isEmpty(sysSystemVO.getSid()) && CollectionUtils.isEmpty(sysSystemVO.getSids())) {
            return ResultVO.getFailed("请先选中记录后再进行删除操作");
        }

        return this.sysSystemWriteService.delSysSystem(sysSystemVO);
    }


    @ApiOperation("查询系统分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "currentPage", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "pageSize", value = "每页记录数", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemName", value = "系统名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "startTime", value = "创建开始时间", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "endTime", value = "创建结束时间", required = false)
    })
    @GetMapping("/page")
    public ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(@ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemReadService.selectSysSystemPage(sysSystemVO);
    }


    @ApiOperation("查询系统对象详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "sid", value = "系统对象ID", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false),
    })
    @GetMapping("/detail")
    public ResultVO<SysSystemVO> selectSysSystemVODetail(@ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemReadService.selectSysSystemVODetail(sysSystemVO);
    }


    @ApiOperation("查询系统列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true)
    })
    @GetMapping("/list")
    public ResultVO<List<SysSystemVO>> selectSysSystemVOList(@ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemReadService.selectSysSystemVOList(sysSystemVO);
    }


    @ApiOperation("导出系统列表EXCEL")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "loginUid", value = "登录用户ID", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemName", value = "系统名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "startTime", value = "创建开始时间", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "endTime", value = "创建结束时间", required = false)
    })
    @GetMapping("/export")
    public ResultVO<Void> exportSysSystemExcel(@ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemReadService.exportSysSystemExcel(sysSystemVO);
    }


}
