package com.vote.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class VoteResult {
    private Integer id;

    private String voteName;

    private String pkNames;

    private String pkTickets;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoteName() {
        return voteName;
    }

    public void setVoteName(String voteName) {
        this.voteName = voteName == null ? null : voteName.trim();
    }

    public String getPkNames() {
        return pkNames;
    }

    public void setPkNames(String pkNames) {
        this.pkNames = pkNames == null ? null : pkNames.trim();
    }

    public String getPkTickets() {
        return pkTickets;
    }

    public void setPkTickets(String pkTickets) {
        this.pkTickets = pkTickets == null ? null : pkTickets.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}