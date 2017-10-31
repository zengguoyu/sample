package com.kenny.domain;

import java.io.Serializable;

/**
* @author ZengGuoyu
* @date 2017-10-24 19:28:26
* @description 本文件自动生成，请勿修改
*/
public class SysRoleGroupUser implements Serializable {
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
    private String roleGroupUuid;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer userId;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String appId;

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
    public String getRoleGroupUuid() {
        return roleGroupUuid;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 
     */
    public void setRoleGroupUuid(String roleGroupUuid) {
        this.roleGroupUuid = roleGroupUuid == null ? null : roleGroupUuid.trim();
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
     * VARCHAR(50)<br>
     * 获得 
     */
    public String getAppId() {
        return appId;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleGroupUuid=").append(roleGroupUuid);
        sb.append(", userId=").append(userId);
        sb.append(", appId=").append(appId);
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
        SysRoleGroupUser other = (SysRoleGroupUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleGroupUuid() == null ? other.getRoleGroupUuid() == null : this.getRoleGroupUuid().equals(other.getRoleGroupUuid()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleGroupUuid() == null) ? 0 : getRoleGroupUuid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        return result;
    }
}