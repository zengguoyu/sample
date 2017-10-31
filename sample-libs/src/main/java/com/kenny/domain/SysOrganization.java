package com.kenny.domain;

import java.io.Serializable;

/**
* @author ZengGuoyu
* @date 2017-10-24 21:05:20
* @description 本文件自动生成，请勿修改
*/
public class SysOrganization implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * VARCHAR(50) 必填<br>
     * 
     */
    private String uuid;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String parentUuid;

    /**
     * VARCHAR(100) 必填<br>
     * 
     */
    private String name;

    /**
     * VARCHAR(10) 必填<br>
     * 
     */
    private String number;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer depth;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer treeRight;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer treeLeft;

    /**
     * TINYINT(3) 默认值[0] 必填<br>
     * 0：默认值，表示有效数据
            1：表示已经删除，这里使用伪删除
     */
    private Byte isDeleted;

    /**
     * TINYINT(3) 默认值[1] 必填<br>
     * 
     */
    private Byte isVisiable;

    /**
     * INTEGER(10) 默认值[0] 必填<br>
     * 
     */
    private Integer sort;

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
     * VARCHAR(100) 必填<br>
     * 获得 
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(10) 必填<br>
     * 获得 
     */
    public String getNumber() {
        return number;
    }

    /**
     * VARCHAR(10) 必填<br>
     * 设置 
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * INTEGER(10) 必填<br>
     * 获得 
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 
     */
    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    /**
     * INTEGER(10) 必填<br>
     * 获得 
     */
    public Integer getTreeRight() {
        return treeRight;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 
     */
    public void setTreeRight(Integer treeRight) {
        this.treeRight = treeRight;
    }

    /**
     * INTEGER(10) 必填<br>
     * 获得 
     */
    public Integer getTreeLeft() {
        return treeLeft;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 
     */
    public void setTreeLeft(Integer treeLeft) {
        this.treeLeft = treeLeft;
    }

    /**
     * TINYINT(3) 默认值[0] 必填<br>
     * 获得 0：默认值，表示有效数据
            1：表示已经删除，这里使用伪删除
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * TINYINT(3) 默认值[0] 必填<br>
     * 设置 0：默认值，表示有效数据
            1：表示已经删除，这里使用伪删除
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * TINYINT(3) 默认值[1] 必填<br>
     * 获得 
     */
    public Byte getIsVisiable() {
        return isVisiable;
    }

    /**
     * TINYINT(3) 默认值[1] 必填<br>
     * 设置 
     */
    public void setIsVisiable(Byte isVisiable) {
        this.isVisiable = isVisiable;
    }

    /**
     * INTEGER(10) 默认值[0] 必填<br>
     * 获得 
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * INTEGER(10) 默认值[0] 必填<br>
     * 设置 
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uuid=").append(uuid);
        sb.append(", parentUuid=").append(parentUuid);
        sb.append(", name=").append(name);
        sb.append(", number=").append(number);
        sb.append(", depth=").append(depth);
        sb.append(", treeRight=").append(treeRight);
        sb.append(", treeLeft=").append(treeLeft);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", isVisiable=").append(isVisiable);
        sb.append(", sort=").append(sort);
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
        SysOrganization other = (SysOrganization) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getParentUuid() == null ? other.getParentUuid() == null : this.getParentUuid().equals(other.getParentUuid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getDepth() == null ? other.getDepth() == null : this.getDepth().equals(other.getDepth()))
            && (this.getTreeRight() == null ? other.getTreeRight() == null : this.getTreeRight().equals(other.getTreeRight()))
            && (this.getTreeLeft() == null ? other.getTreeLeft() == null : this.getTreeLeft().equals(other.getTreeLeft()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getIsVisiable() == null ? other.getIsVisiable() == null : this.getIsVisiable().equals(other.getIsVisiable()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getParentUuid() == null) ? 0 : getParentUuid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getDepth() == null) ? 0 : getDepth().hashCode());
        result = prime * result + ((getTreeRight() == null) ? 0 : getTreeRight().hashCode());
        result = prime * result + ((getTreeLeft() == null) ? 0 : getTreeLeft().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getIsVisiable() == null) ? 0 : getIsVisiable().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }
}