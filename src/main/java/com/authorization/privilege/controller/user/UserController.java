package com.authorization.privilege.controller.user;

import com.authorization.privilege.controller.BaseController;
import com.authorization.privilege.service.user.UserReadService;
import com.authorization.privilege.vo.ResultVO;
import com.authorization.privilege.vo.user.UserVO;
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
 * @date 2018/12/22
 * @description 用户控制类
 */
@Api(tags = {"UserController"}, description = "用户Controller")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserReadService userReadService;


    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "username", value = "账号", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "password", value = "密码", required = true)
    })
    @GetMapping("/denglu")
    public ResultVO<UserVO> login(@ApiIgnore UserVO userVO) throws Exception {
        return this.userReadService.denglu(userVO);
    }


}
