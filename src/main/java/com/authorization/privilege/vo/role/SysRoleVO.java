package com.authorization.privilege.vo.role;

import com.authorization.privilege.entity.dsprivelege.role.SysRole;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author duxuebo
 * @date 2019/4/1
 * @description 角色VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysRoleVO extends SysRole {
}
