package com.kenny.domain;

import java.io.Serializable;

/**
* @author ZengGuoyu
* @date 2017-10-24 21:05:20
* @description 本文件自动生成，请勿修改
*/
public class SysUserPosition implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String uuid;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String name;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String departmentUuid;

    /**
     * TINYINT(3) 默认值[1]<br>
     * 
     */
    private Byte isValid;

    /**
     * VARCHAR(50) 必填<br>
     * 获得 
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 
     */
    public String getDepartmentUuid() {
        return departmentUuid;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 
     */
    public void setDepartmentUuid(String departmentUuid) {
        this.departmentUuid = departmentUuid == null ? null : departmentUuid.trim();
    }

    /**
     * TINYINT(3) 默认值[1]<br>
     * 获得 
     */
    public Byte getIsValid() {
        return isValid;
    }

    /**
     * TINYINT(3) 默认值[1]<br>
     * 设置 
     */
    public void setIsValid(Byte isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", departmentUuid=").append(departmentUuid);
        sb.append(", isValid=").append(isValid);
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
        SysUserPosition other = (SysUserPosition) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepartmentUuid() == null ? other.getDepartmentUuid() == null : this.getDepartmentUuid().equals(other.getDepartmentUuid()))
            && (this.getIsValid() == null ? other.getIsValid() == null : this.getIsValid().equals(other.getIsValid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartmentUuid() == null) ? 0 : getDepartmentUuid().hashCode());
        result = prime * result + ((getIsValid() == null) ? 0 : getIsValid().hashCode());
        return result;
    }
}