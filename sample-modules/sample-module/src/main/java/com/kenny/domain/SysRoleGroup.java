package com.kenny.domain;

import java.io.Serializable;

/**
* @author ZengGuoyu
* @date 2017-10-24 19:28:28
* @description 本文件自动生成，请勿修改
*/
public class SysRoleGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String uuid;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String code;

    /**
     * VARCHAR(200)<br>
     * 
     */
    private String description;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String appId;

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
     * VARCHAR(50) 必填<br>
     * 获得 
     */
    public String getCode() {
        return code;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 
     */
    public String getDescription() {
        return description;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * VARCHAR(50) 必填<br>
     * 获得 
     */
    public String getAppId() {
        return appId;
    }

    /**
     * VARCHAR(50) 必填<br>
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
        sb.append(", uuid=").append(uuid);
        sb.append(", code=").append(code);
        sb.append(", description=").append(description);
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
        SysRoleGroup other = (SysRoleGroup) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        return result;
    }
}