package com.authorization.privilege.vo.system;

import com.authorization.privilege.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象VO类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysSystemVO extends BaseVO {

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

    @ApiModelProperty("创建人名称")
    private String createName;

    @ApiModelProperty("修改人名称")
    private String updateName;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUid() {
        return updateUid;
    }

    public void setUpdateUid(String updateUid) {
        this.updateUid = updateUid;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getCreateName() {
        return createName;
    }

    @Override
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    @Override
    public String getUpdateName() {
        return updateName;
    }

    @Override
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
}
