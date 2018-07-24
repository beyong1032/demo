package com.ep98.employee.domain;

import java.io.Serializable;
import java.util.Date;

public class Ka implements Serializable {
    private Integer id;

    private String kaName;

    private String kaCode;

    private String kaLoginnames;

    private Integer score;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    private Byte enable;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKaName() {
        return kaName;
    }

    public void setKaName(String kaName) {
        this.kaName = kaName == null ? null : kaName.trim();
    }

    public String getKaCode() {
        return kaCode;
    }

    public void setKaCode(String kaCode) {
        this.kaCode = kaCode == null ? null : kaCode.trim();
    }

    public String getKaLoginnames() {
        return kaLoginnames;
    }

    public void setKaLoginnames(String kaLoginnames) {
        this.kaLoginnames = kaLoginnames == null ? null : kaLoginnames.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }
}