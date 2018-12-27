package com.authorization.privilege.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author duxuebo
 * @date 2018/12/5
 * @description 基础VO对象
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseVO {

    @ApiModelProperty("当前登录用户ID")
    private String loginUid;

    @ApiModelProperty("当前页码")
    private Integer currentPage;

    @ApiModelProperty("每页条数")
    private Integer pageSize;

    @ApiModelProperty("创建人名称")
    private String createName;

    @ApiModelProperty("修改人名称")
    private String updateName;

    @ApiModelProperty("开始时间 格式：yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("结束时间 格式：yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty("开始日期 格式：yyyy-MM-dd")
    private Date startDate;

    @ApiModelProperty("结束日期 格式：yyyy-MM-dd")
    private Date endDate;

    @ApiModelProperty("开始月份 格式：yyyy-MM")
    private Date startMonth;

    @ApiModelProperty("结束月份 格式：yyyy-MM")
    private Date endMonth;


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

    public String getLoginUid() {
        return loginUid;
    }

    public void setLoginUid(String loginUid) {
        this.loginUid = loginUid;
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getStartTime() {
        return startTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getEndTime() {
        return endTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getStartDate() {
        return startDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getEndDate() {
        return endDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    public Date getStartMonth() {
        return startMonth;
    }

    @DateTimeFormat(pattern = "yyyy-MM")
    public void setStartMonth(Date startMonth) {
        this.startMonth = startMonth;
    }

    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    public Date getEndMonth() {
        return endMonth;
    }

    @DateTimeFormat(pattern = "yyyy-MM")
    public void setEndMonth(Date endMonth) {
        this.endMonth = endMonth;
    }
}
