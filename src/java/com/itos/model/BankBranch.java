package com.itos.model;
// Generated Aug 27, 2014 11:11:07 PM by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Formula;

/**
 * BankBranch generated by hbm2java
 */
@Entity
@Table(name = "BankBranch", schema = "dbo", catalog = "rtacs"
)
public class BankBranch implements java.io.Serializable {

    private int branchId;
    private Province province;
    private Bank bank;
    private String branchCode;
    private String branchName;
    private String branchShort;
    private String address;
    private String subdistrict;
    private String district;
    private String zipcode;
    private String tel;
    private String fax;
    private char status;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Set<MilitaryDepartment> militaryDepartments = new HashSet<MilitaryDepartment>(0);
    private Set<Member> members = new HashSet<Member>(0);
    private String bankCode;
    private String bankName;
    private String provinceCode;
    private String provinceName;

    public BankBranch() {
    }

    public BankBranch(int branchId, Bank bank, String branchCode, String branchName, char status) {
        this.branchId = branchId;
        this.bank = bank;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.status = status;
    }

    public BankBranch(int branchId, Province province, Bank bank, String branchCode, String branchName, String branchShort, String address, String subdistrict, String district, String zipcode, String tel, String fax, char status, String createBy, Date createDate, String updateBy, Date updateDate, Set militaryDepartments, Set members) {
        this.branchId = branchId;
        this.province = province;
        this.bank = bank;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.branchShort = branchShort;
        this.address = address;
        this.subdistrict = subdistrict;
        this.district = district;
        this.zipcode = zipcode;
        this.tel = tel;
        this.fax = fax;
        this.status = status;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.militaryDepartments = militaryDepartments;
        this.members = members;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_id", unique = true, nullable = false)
    public int getBranchId() {
        return this.branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_code")
    public Province getProvince() {
        return this.province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_code", nullable = false)
    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Column(name = "branch_code", nullable = false, length = 5)
    public String getBranchCode() {
        return this.branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    @Column(name = "branch_name", nullable = false, length = 256)
    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Column(name = "branch_short", length = 50)
    public String getBranchShort() {
        return this.branchShort;
    }

    public void setBranchShort(String branchShort) {
        this.branchShort = branchShort;
    }

    @Column(name = "address", length = 256)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "subdistrict", length = 100)
    public String getSubdistrict() {
        return this.subdistrict;
    }

    public void setSubdistrict(String subdistrict) {
        this.subdistrict = subdistrict;
    }

    @Column(name = "district", length = 100)
    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "zipcode", length = 10)
    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Column(name = "tel", length = 100)
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "fax", length = 100)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "status", nullable = false, length = 1)
    public char getStatus() {
        return this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Column(name = "create_by", length = 50)
    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 23)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "update_by", length = 50)
    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date", length = 23)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bankBranch")
    public Set<MilitaryDepartment> getMilitaryDepartments() {
        return this.militaryDepartments;
    }

    public void setMilitaryDepartments(Set<MilitaryDepartment> militaryDepartments) {
        this.militaryDepartments = militaryDepartments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bankBranch")
    public Set<Member> getMembers() {
        return this.members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    /**
     * @return the bankCode
     */
    @Formula("(SELECT bank_code)")
    public String getBankCode() {
        return bankCode;
    }

    /**
     * @param bankCode the bankCode to set
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * @return the bankName
     */
    @Formula("(SELECT B.bank_name FROM Bank B WHERE B.bank_code=bank_code)")
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the provinceCode
     */
    @Formula("(SELECT province_code)")
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * @param provinceCode the provinceCode to set
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * @return the provinceName
     */
    @Formula("(SELECT P.province_name FROM Province P WHERE P.province_code=province_code)")
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

}