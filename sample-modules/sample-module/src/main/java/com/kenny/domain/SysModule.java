package com.kenny.domain;

import java.io.Serializable;

/**
* @author ZengGuoyu
* @date 2017-10-24 19:28:29
* @description 本文件自动生成，请勿修改
*/
public class SysModule implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String uuid;

    /**
     * VARCHAR(60) 必填<br>
     * 
     */
    private String name;

    /**
     * TINYINT(3) 默认值[0] 必填<br>
     * 1.菜单
            2.按钮
            3.uri
     */
    private Byte moduleType;

    /**
     * VARCHAR(500)<br>
     * 
     */
    private String url;

    /**
     * SMALLINT(5) 默认值[0] 必填<br>
     * 
     */
    private Short sort;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String parentUuid;

    /**
     * VARCHAR(200)<br>
     * 
     */
    private String perms;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String icon;

    /**
     * VARCHAR(50)<br>
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
     * VARCHAR(60) 必填<br>
     * 获得 
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(60) 必填<br>
     * 设置 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * TINYINT(3) 默认值[0] 必填<br>
     * 获得 1.菜单
            2.按钮
            3.uri
     */
    public Byte getModuleType() {
        return moduleType;
    }

    /**
     * TINYINT(3) 默认值[0] 必填<br>
     * 设置 1.菜单
            2.按钮
            3.uri
     */
    public void setModuleType(Byte moduleType) {
        this.moduleType = moduleType;
    }

    /**
     * VARCHAR(500)<br>
     * 获得 
     */
    public String getUrl() {
        return url;
    }

    /**
     * VARCHAR(500)<br>
     * 设置 
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * SMALLINT(5) 默认值[0] 必填<br>
     * 获得 
     */
    public Short getSort() {
        return sort;
    }

    /**
     * SMALLINT(5) 默认值[0] 必填<br>
     * 设置 
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * VARCHAR(50)<br>
     * 获得 
     */
    public String getParentUuid() {
        return parentUuid;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 
     */
    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid == null ? null : parentUuid.trim();
    }

    /**
     * VARCHAR(200)<br>
     * 获得 
     */
    public String getPerms() {
        return perms;
    }

    /**
     * VARCHAR(200)<br>
     * 设置 
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 
     */
    public String getIcon() {
        return icon;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
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
        sb.append(", uuid=").append(uuid);
        sb.append(", name=").append(name);
        sb.append(", moduleType=").append(moduleType);
        sb.append(", url=").append(url);
        sb.append(", sort=").append(sort);
        sb.append(", parentUuid=").append(parentUuid);
        sb.append(", perms=").append(perms);
        sb.append(", icon=").append(icon);
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
        SysModule other = (SysModule) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getModuleType() == null ? other.getModuleType() == null : this.getModuleType().equals(other.getModuleType()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getParentUuid() == null ? other.getParentUuid() == null : this.getParentUuid().equals(other.getParentUuid()))
            && (this.getPerms() == null ? other.getPerms() == null : this.getPerms().equals(other.getPerms()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getModuleType() == null) ? 0 : getModuleType().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getParentUuid() == null) ? 0 : getParentUuid().hashCode());
        result = prime * result + ((getPerms() == null) ? 0 : getPerms().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        return result;
    }
}