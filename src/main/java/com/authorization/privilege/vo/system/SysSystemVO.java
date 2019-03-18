package com.authorization.privilege.vo.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象VO类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysSystemVO extends SysSystem {

    @ApiModelProperty("系统ID集合")
    private List<String> sids;

    @ApiModelProperty("状态名称：0:删除, 1:正常")
    private String stateName;


    public List<String> getSids() {
        return sids;
    }

    public void setSids(List<String> sids) {
        this.sids = sids;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
