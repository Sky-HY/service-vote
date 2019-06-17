package com.vote.pojo;

import java.util.Date;

public class VoteResult {
    private Integer id;

    private String voteName;

    private String pk1Name;

    private String pk2Name;

    private Integer pk1Ticket;

    private Integer pk2Ticket;

    private Integer pkResult;

    private Date startTime;

    private Date endTime;

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

    public String getPk1Name() {
        return pk1Name;
    }

    public void setPk1Name(String pk1Name) {
        this.pk1Name = pk1Name == null ? null : pk1Name.trim();
    }

    public String getPk2Name() {
        return pk2Name;
    }

    public void setPk2Name(String pk2Name) {
        this.pk2Name = pk2Name == null ? null : pk2Name.trim();
    }

    public Integer getPk1Ticket() {
        return pk1Ticket;
    }

    public void setPk1Ticket(Integer pk1Ticket) {
        this.pk1Ticket = pk1Ticket;
    }

    public Integer getPk2Ticket() {
        return pk2Ticket;
    }

    public void setPk2Ticket(Integer pk2Ticket) {
        this.pk2Ticket = pk2Ticket;
    }

    public Integer getPkResult() {
        return pkResult;
    }

    public void setPkResult(Integer pkResult) {
        this.pkResult = pkResult;
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
}