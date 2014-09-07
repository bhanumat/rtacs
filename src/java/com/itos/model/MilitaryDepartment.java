package com.itos.model;
// Generated Aug 27, 2014 11:11:07 PM by Hibernate Tools 3.6.0

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
import javax.persistence.Transient;
import org.hibernate.annotations.Formula;

/**
 * MilitaryDepartment generated by hbm2java
 */
@Entity
@Table(name = "MilitaryDepartment", schema = "dbo", catalog = "rtacs"
)
public class MilitaryDepartment implements java.io.Serializable {

    private int militaryId;
    private BankAccountType bankAccountType;
    private BankBranch bankBranch;
    private Bank bank;
    private int mildeptId;
    private String name;
    private String fullname;
    private Integer controlLine;
    private String address1;
    private String address2;
    private String subdistrict;
    private String district;
    private String provinceCode;
    private String zipcode;
    private String tel;
    private String fax;
    private String bankAccName;
    private String bankAccNo;
    private Integer mildeptIdForSend;
    private Integer hidden;
    private Character status;
    private Set<Member> members = new HashSet<Member>(0);
    private String bankCode;
    private String bankName;
    private int branchId;
    private String branchCode;
    private String branchName;
    private int bankAccTypeId;
    private String bankAccTypeName;

    public MilitaryDepartment() {
    }

    public MilitaryDepartment(int militaryId, int mildeptId) {
        this.militaryId = militaryId;
        this.mildeptId = mildeptId;
    }

    public MilitaryDepartment(int militaryId, BankAccountType bankAccountType, BankBranch bankBranch, Bank bank, int mildeptId, String name, String fullname, Integer controlLine, String address1, String address2, String subdistrict, String district, String provinceCode, String zipcode, String tel, String fax, String bankAccName, String bankAccNo, Integer mildeptIdForSend, Integer hidden, Character status, Set members) {
        this.militaryId = militaryId;
        this.bankAccountType = bankAccountType;
        this.bankBranch = bankBranch;
        this.bank = bank;
        this.mildeptId = mildeptId;
        this.name = name;
        this.fullname = fullname;
        this.controlLine = controlLine;
        this.address1 = address1;
        this.address2 = address2;
        this.subdistrict = subdistrict;
        this.district = district;
        this.provinceCode = provinceCode;
        this.zipcode = zipcode;
        this.tel = tel;
        this.fax = fax;
        this.bankAccName = bankAccName;
        this.bankAccNo = bankAccNo;
        this.mildeptIdForSend = mildeptIdForSend;
        this.hidden = hidden;
        this.status = status;
        this.members = members;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "military_id", unique = true, nullable = false)
    public int getMilitaryId() {
        return this.militaryId;
    }

    public void setMilitaryId(int militaryId) {
        this.militaryId = militaryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_acc_type_id")
    public BankAccountType getBankAccountType() {
        return this.bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    public BankBranch getBankBranch() {
        return this.bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_code")
    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Column(name = "mildept_id", nullable = false)
    public int getMildeptId() {
        return this.mildeptId;
    }

    public void setMildeptId(int mildeptId) {
        this.mildeptId = mildeptId;
    }

    @Column(name = "name", length = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "fullname", length = 100)
    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Column(name = "control_line")
    public Integer getControlLine() {
        return this.controlLine;
    }

    public void setControlLine(Integer controlLine) {
        this.controlLine = controlLine;
    }

    @Column(name = "address1", length = 100)
    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "address2", length = 100)
    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
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

    @Column(name = "province_code", length = 2)
    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    @Column(name = "zipcode", length = 10)
    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Column(name = "tel", length = 30)
    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "fax", length = 30)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "bank_acc_name", length = 256)
    public String getBankAccName() {
        return this.bankAccName;
    }

    public void setBankAccName(String bankAccName) {
        this.bankAccName = bankAccName;
    }

    @Column(name = "bank_acc_no", length = 15)
    public String getBankAccNo() {
        return this.bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    @Column(name = "mildept_id_for_send")
    public Integer getMildeptIdForSend() {
        return this.mildeptIdForSend;
    }

    public void setMildeptIdForSend(Integer mildeptIdForSend) {
        this.mildeptIdForSend = mildeptIdForSend;
    }

    @Column(name = "hidden")
    public Integer getHidden() {
        return this.hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

    @Column(name = "status", length = 1)
    public Character getStatus() {
        return this.status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "militaryDepartment")
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
    //@Formula("(SELECT M.bank_code FROM MilitaryDepartment M INNER JOIN Bank B ON M.bank_code = B.bank_code WHERE B.bank_code=bank_code)")
    //@Transient
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
     * @return the branchId
     */
    @Formula("(SELECT ISNULL(branch_id, 0))")
    //@Transient
    public int getBranchId() {
        return branchId;
    }

    /**
     * @param branchId the branchId to set
     */
    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    /**
     * @return the branchCode
     */
    @Formula("(SELECT B.branch_code FROM BankBranch B WHERE B.branch_id=branch_id)")
    public String getBranchCode() {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    /**
     * @return the branchName
     */
    @Formula("(SELECT B.branch_name FROM BankBranch B WHERE B.branch_id=branch_id)")
    public String getBranchName() {
        return branchName;
    }

    /**
     * @param branchName the branchName to set
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * @return the bankAccTypeId
     */
    @Formula("(SELECT ISNULL(bank_acc_type_id, 0))")
    public int getBankAccTypeId() {
        return bankAccTypeId;
    }

    /**
     * @param bankAccTypeId the bankAccTypeId to set
     */
    public void setBankAccTypeId(int bankAccTypeId) {
        this.bankAccTypeId = bankAccTypeId;
    }

    /**
     * @return the bankAccTypeName
     */
    @Formula("(SELECT B.acc_type_name FROM BankAccountType B WHERE B.acc_type_id=bank_acc_type_id)")
    public String getBankAccTypeName() {
        return bankAccTypeName;
    }

    /**
     * @param bankAccTypeName the bankAccTypeName to set
     */
    public void setBankAccTypeName(String bankAccTypeName) {
        this.bankAccTypeName = bankAccTypeName;
    }

}
