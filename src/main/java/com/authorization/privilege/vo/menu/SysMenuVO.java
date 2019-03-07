package com.authorization.privilege.vo.menu;

import com.authorization.privilege.entity.dsprivelege.menu.SysMenu;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duxuebo
 * @date 2019/1/26
 * @description 菜单VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysMenuVO extends SysMenu {

    @ApiModelProperty("系统名称")
    private String systemName;

    @ApiModelProperty("上级菜单名称")
    private String parentMenuName;


    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getParentMenuName() {
        return parentMenuName;
    }

    public void setParentMenuName(String parentMenuName) {
        this.parentMenuName = parentMenuName;
    }
}
