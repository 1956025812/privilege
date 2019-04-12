package com.authorization.privilege.entity.dsprivelege.role;

import com.authorization.privilege.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author qjwyss
 * @date 2018/12/4
 * @description 角色菜单类对象
 */
public class RoleMenu extends BaseVO implements Serializable {

    @ApiModelProperty("角色菜单关联ID")
    private String rmid;

    @ApiModelProperty("角色ID")
    private String rid;

    @ApiModelProperty("菜单ID")
    private String mid;

    @ApiModelProperty("创建人ID")
    private String creatorId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    public String getRmid() {
        return rmid;
    }

    public void setRmid(String rmid) {
        this.rmid = rmid == null ? null : rmid.trim();
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid == null ? null : rid.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}