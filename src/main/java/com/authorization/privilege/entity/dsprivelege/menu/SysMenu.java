package com.authorization.privilege.entity.dsprivelege.menu;

import com.authorization.privilege.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author duxuebo
 * @date 2018/12/4
 * @description 菜单类对象
 */
public class SysMenu extends BaseVO implements Serializable {

    @ApiModelProperty("菜单ID")
    private String mid;

    @ApiModelProperty("系统ID")
    private String systemId;

    @ApiModelProperty("系统标识")
    private String systemKey;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("类型:   1：菜单， 2：按钮")
    private Integer type;

    @ApiModelProperty("菜单级别 从1开始")
    private Integer level;

    @ApiModelProperty("菜单链接")
    private String url;

    @ApiModelProperty("父菜单ID")
    private String parentMid;

    @ApiModelProperty("排序  从1开始")
    private Integer sort;

    @ApiModelProperty("状态:   0：删除， 1：正常")
    private Integer state;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("创建人ID")
    private String createUid;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改人ID")
    private String updateUid;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey == null ? null : systemKey.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentMid() {
        return parentMid;
    }

    public void setParentMid(String parentMid) {
        this.parentMid = parentMid == null ? null : parentMid.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}