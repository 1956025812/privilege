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

    @ApiModelProperty("菜单类型名称")
    private String menuTypeName;

    @ApiModelProperty("状态名称： 0：删除， 1：正常")
    private String menuStateName;

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

    public String getMenuTypeName() {
        return menuTypeName;
    }

    public void setMenuTypeName(String menuTypeName) {
        this.menuTypeName = menuTypeName;
    }

    public String getMenuStateName() {
        return menuStateName;
    }

    public void setMenuStateName(String menuStateName) {
        this.menuStateName = menuStateName;
    }
}
