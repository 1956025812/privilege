package com.authorization.privilege.vo.system;

import com.authorization.privilege.entity.dsprivelege.system.SysSystem;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 系统对象VO类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SysSystemVO extends SysSystem {

    @ApiModelProperty("当前页码")
    private Integer currentPage;

    @ApiModelProperty("每页条数")
    private Integer pageSize;

    @ApiModelProperty("创建人名称")
    private String createName;

    @ApiModelProperty("修改人名称")
    private String updateName;


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
}
