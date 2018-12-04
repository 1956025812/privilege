package com.authorization.privilege.controller.system;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.system.SysSystemReadService;
import com.authorization.privilege.vo.PageVO;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.system.SysSystemVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

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


    @ApiOperation("查询系统分页列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "currentPage", value = "当前页码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "Long", name = "pageSize", value = "每页记录数", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemName", value = "系统名称", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "systemKey", value = "系统标识", required = false)
    })
    @GetMapping(value = "/page")
    public ResultVO<PageVO<SysSystemVO>> selectSysSystemPage(@ApiIgnore SysSystemVO sysSystemVO) throws Exception {
        return this.sysSystemReadService.selectSysSystemPage(sysSystemVO);
    }


}
