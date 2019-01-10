package com.authorization.privilege.entity.dsprivelege.system;

import com.authorization.privilege.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象类
 */
public class SysSystem extends BaseVO implements Serializable {

    @ApiModelProperty("系统ID")
    private String sid;

    @ApiModelProperty("系统名称")
    private String systemName;

    @ApiModelProperty("系统标识")
    private String systemKey;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("状态：0删除 1正常")
    private Integer state;

    @ApiModelProperty("创建人ID")
    private String createUid;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改人ID")
    private String updateUid;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey == null ? null : systemKey.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        this.createUid = createUid;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}