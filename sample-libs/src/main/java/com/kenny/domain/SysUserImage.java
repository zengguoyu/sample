package com.kenny.domain;

import java.io.Serializable;
import java.util.Arrays;

/**
* @author ZengGuoyu
* @date 2017-10-24 21:05:20
* @description 本文件自动生成，请勿修改
*/
public class SysUserImage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer id;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer userId;

    /**
     * LONGVARBINARY(16777215)<br>
     * 
     */
    private byte[] img;

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
     * LONGVARBINARY(16777215)<br>
     * 获得 
     */
    public byte[] getImg() {
        return img;
    }

    /**
     * LONGVARBINARY(16777215)<br>
     * 设置 
     */
    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", img=").append(img);
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
        SysUserImage other = (SysUserImage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (Arrays.equals(this.getImg(), other.getImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + (Arrays.hashCode(getImg()));
        return result;
    }
}