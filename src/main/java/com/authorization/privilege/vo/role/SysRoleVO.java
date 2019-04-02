package com.authorization.privilege.vo.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRoleVO extends SysRole {

    @ApiModelProperty("系统名称")
    private String systemName;

    @ApiModelProperty("角色状态名称")
    private String roleStateName;


    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getRoleStateName() {
        return roleStateName;
    }

    public void setRoleStateName(String roleStateName) {
        this.roleStateName = roleStateName;
    }
}
