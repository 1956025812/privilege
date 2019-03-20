package com.authorization.privilege.entity.dsprivelege.role;

import com.authorization.privilege.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 角色类对象
 */
public class SysRole extends BaseVO implements Serializable {

    @ApiModelProperty("角色ID")
    private String rid;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("系统ID")
    private String sid;

    @ApiModelProperty("系统标识")
    private String systemKey;

    @ApiModelProperty("父角色ID")
    private String parentRid;

    @ApiModelProperty("状态：0：删除；1：启用；2：禁用")
    private Integer state;

    @ApiModelProperty("创建人ID")
    private String createUid;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("修改人ID")
    private String updateUid;

    @ApiModelProperty("修改时间")
    private LocalDateTime updateTime;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey == null ? null : systemKey.trim();
    }

    public String getParentRid() {
        return parentRid;
    }

    public void setParentRid(String parentRid) {
        this.parentRid = parentRid == null ? null : parentRid.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid == null ? null : createUid.trim();
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid == null ? null : updateUid.trim();
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}