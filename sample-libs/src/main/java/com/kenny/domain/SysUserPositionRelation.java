package com.kenny.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @author ZengGuoyu
* @date 2017-10-24 21:05:20
* @description 本文件自动生成，请勿修改
*/
public class SysUserPositionRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer id;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String positionUuid;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer userId;

    /**
     * TIMESTAMP(19)<br>
     * 
     */
    private Date createTime;

    /**
     * TIMESTAMP(19)<br>
     * 
     */
    private Date disableTime;

    /**
     * INTEGER(10) 必填<br>
     * 获得 
     */
    public Integer getId() {
        return id;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 获得 
     */
    public String getPositionUuid() {
        return positionUuid;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 
     */
    public void setPositionUuid(String positionUuid) {
        this.positionUuid = positionUuid == null ? null : positionUuid.trim();
    }

    /**
     * INTEGER(10) 必填<br>
     * 获得 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * TIMESTAMP(19)<br>
     * 获得 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 设置 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 获得 
     */
    public Date getDisableTime() {
        return disableTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 设置 
     */
    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", positionUuid=").append(positionUuid);
        sb.append(", userId=").append(userId);
        sb.append(", createTime=").append(createTime);
        sb.append(", disableTime=").append(disableTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUserPositionRelation other = (SysUserPositionRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPositionUuid() == null ? other.getPositionUuid() == null : this.getPositionUuid().equals(other.getPositionUuid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getDisableTime() == null ? other.getDisableTime() == null : this.getDisableTime().equals(other.getDisableTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPositionUuid() == null) ? 0 : getPositionUuid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getDisableTime() == null) ? 0 : getDisableTime().hashCode());
        return result;
    }
}