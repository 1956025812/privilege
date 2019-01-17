package com.authorization.privilege.vo.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.authorization.privilege.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
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


    public List<String> getSids() {
        return sids;
    }

    public void setSids(List<String> sids) {
        this.sids = sids;
    }
}
