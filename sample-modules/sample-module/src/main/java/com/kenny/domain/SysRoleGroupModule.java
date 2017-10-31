package com.kenny.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @author ZengGuoyu
* @date 2017-10-24 19:28:28
* @description 本文件自动生成，请勿修改
*/
public class SysRoleGroupModule implements Serializable {
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
     * VARCHAR(50) 必填<br>
     * 
     */
    private String moduleUuid;

    /**
     * DATE(10)<br>
     * 
     */
    private Date expiredTime;

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
     * VARCHAR(50) 必填<br>
     * 获得 
     */
    public String getModuleUuid() {
        return moduleUuid;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 
     */
    public void setModuleUuid(String moduleUuid) {
        this.moduleUuid = moduleUuid == null ? null : moduleUuid.trim();
    }

    /**
     * DATE(10)<br>
     * 获得 
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * DATE(10)<br>
     * 设置 
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleGroupUuid=").append(roleGroupUuid);
        sb.append(", moduleUuid=").append(moduleUuid);
        sb.append(", expiredTime=").append(expiredTime);
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
        SysRoleGroupModule other = (SysRoleGroupModule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleGroupUuid() == null ? other.getRoleGroupUuid() == null : this.getRoleGroupUuid().equals(other.getRoleGroupUuid()))
            && (this.getModuleUuid() == null ? other.getModuleUuid() == null : this.getModuleUuid().equals(other.getModuleUuid()))
            && (this.getExpiredTime() == null ? other.getExpiredTime() == null : this.getExpiredTime().equals(other.getExpiredTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleGroupUuid() == null) ? 0 : getRoleGroupUuid().hashCode());
        result = prime * result + ((getModuleUuid() == null) ? 0 : getModuleUuid().hashCode());
        result = prime * result + ((getExpiredTime() == null) ? 0 : getExpiredTime().hashCode());
        return result;
    }
}