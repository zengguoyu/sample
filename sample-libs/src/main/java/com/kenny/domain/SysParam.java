package com.kenny.domain;

import java.io.Serializable;

/**
* @author ZengGuoyu
* @date 2017-11-03 22:29:06
* @description 本文件自动生成，请勿修改
*/
public class SysParam implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer id;

    /**
     * VARCHAR(100) 必填<br>
     * 
     */
    private String paramName;

    /**
     * VARCHAR(100)<br>
     * 
     */
    private String paramValue;

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
     * VARCHAR(100) 必填<br>
     * 获得 
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * VARCHAR(100) 必填<br>
     * 设置 
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    /**
     * VARCHAR(100)<br>
     * 获得 
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * VARCHAR(100)<br>
     * 设置 
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramValue=").append(paramValue);
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
        SysParam other = (SysParam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getParamValue() == null ? other.getParamValue() == null : this.getParamValue().equals(other.getParamValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getParamValue() == null) ? 0 : getParamValue().hashCode());
        return result;
    }
}