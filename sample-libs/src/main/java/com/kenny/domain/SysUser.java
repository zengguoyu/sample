package com.kenny.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @author ZengGuoyu
* @date 2017-10-24 21:05:20
* @description 本文件自动生成，请勿修改
*/
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer id;

    /**
     * VARCHAR(10)<br>
     * 
     */
    private String name;

    /**
     * VARCHAR(60)<br>
     * 
     */
    private String loginName;

    /**
     * VARCHAR(60)<br>
     * 
     */
    private String loginPassword;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String enterpriseUuid;

    /**
     * VARCHAR(50)<br>
     * 
     */
    private String departmentId;

    /**
     * VARCHAR(11)<br>
     * 
     */
    private String phoneNumber;

    /**
     * VARCHAR(10)<br>
     * 
     */
    private String number;

    /**
     * TINYINT(3)<br>
     * 1：男；2：女
     */
    private Byte sex;

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP] 必填<br>
     * 
     */
    private Date createDate;

    /**
     * VARCHAR(20)<br>
     * 
     */
    private String nickname;

    /**
     * DATE(10)<br>
     * 
     */
    private Date lastUpdateTime;

    /**
     * DATE(10)<br>
     * 
     */
    private Date accountExpiredTime;

    /**
     * TINYINT(3)<br>
     * 
     */
    private Byte isLock;

    /**
     * TINYINT(3) 默认值[1]<br>
     * 
     */
    private Byte isValid;

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
     * VARCHAR(10)<br>
     * 获得 
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * VARCHAR(60)<br>
     * 获得 
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * VARCHAR(60)<br>
     * 设置 
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 
     */
    public String getEnterpriseUuid() {
        return enterpriseUuid;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 
     */
    public void setEnterpriseUuid(String enterpriseUuid) {
        this.enterpriseUuid = enterpriseUuid == null ? null : enterpriseUuid.trim();
    }

    /**
     * VARCHAR(50)<br>
     * 获得 
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * VARCHAR(50)<br>
     * 设置 
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    /**
     * VARCHAR(11)<br>
     * 获得 
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * VARCHAR(11)<br>
     * 设置 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * VARCHAR(10)<br>
     * 获得 
     */
    public String getNumber() {
        return number;
    }

    /**
     * VARCHAR(10)<br>
     * 设置 
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * TINYINT(3)<br>
     * 获得 1：男；2：女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * TINYINT(3)<br>
     * 设置 1：男；2：女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP] 必填<br>
     * 获得 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP] 必填<br>
     * 设置 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * VARCHAR(20)<br>
     * 获得 
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * VARCHAR(20)<br>
     * 设置 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * DATE(10)<br>
     * 获得 
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * DATE(10)<br>
     * 设置 
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * DATE(10)<br>
     * 获得 
     */
    public Date getAccountExpiredTime() {
        return accountExpiredTime;
    }

    /**
     * DATE(10)<br>
     * 设置 
     */
    public void setAccountExpiredTime(Date accountExpiredTime) {
        this.accountExpiredTime = accountExpiredTime;
    }

    /**
     * TINYINT(3)<br>
     * 获得 
     */
    public Byte getIsLock() {
        return isLock;
    }

    /**
     * TINYINT(3)<br>
     * 设置 
     */
    public void setIsLock(Byte isLock) {
        this.isLock = isLock;
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
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", loginName=").append(loginName);
        sb.append(", loginPassword=").append(loginPassword);
        sb.append(", enterpriseUuid=").append(enterpriseUuid);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", number=").append(number);
        sb.append(", sex=").append(sex);
        sb.append(", createDate=").append(createDate);
        sb.append(", nickname=").append(nickname);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", accountExpiredTime=").append(accountExpiredTime);
        sb.append(", isLock=").append(isLock);
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getLoginPassword() == null ? other.getLoginPassword() == null : this.getLoginPassword().equals(other.getLoginPassword()))
            && (this.getEnterpriseUuid() == null ? other.getEnterpriseUuid() == null : this.getEnterpriseUuid().equals(other.getEnterpriseUuid()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getAccountExpiredTime() == null ? other.getAccountExpiredTime() == null : this.getAccountExpiredTime().equals(other.getAccountExpiredTime()))
            && (this.getIsLock() == null ? other.getIsLock() == null : this.getIsLock().equals(other.getIsLock()))
            && (this.getIsValid() == null ? other.getIsValid() == null : this.getIsValid().equals(other.getIsValid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getLoginPassword() == null) ? 0 : getLoginPassword().hashCode());
        result = prime * result + ((getEnterpriseUuid() == null) ? 0 : getEnterpriseUuid().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getAccountExpiredTime() == null) ? 0 : getAccountExpiredTime().hashCode());
        result = prime * result + ((getIsLock() == null) ? 0 : getIsLock().hashCode());
        result = prime * result + ((getIsValid() == null) ? 0 : getIsValid().hashCode());
        return result;
    }
}