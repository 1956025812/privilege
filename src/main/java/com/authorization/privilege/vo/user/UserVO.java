package com.authorization.privilege.vo.user;

import com.authorization.privilege.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duxuebo
 * @date 2018/12/22
 * @description 用户VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVO extends BaseVO {

    @ApiModelProperty("用户ID")
    private String uid;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
