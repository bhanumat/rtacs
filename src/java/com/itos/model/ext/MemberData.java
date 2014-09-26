package com.itos.model.ext;
// Generated Aug 27, 2014 11:11:07 PM by Hibernate Tools 3.6.0

import com.itos.model.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Transient;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "Member", schema = "dbo", catalog = "rtacs"
)
public class MemberData implements java.io.Serializable {

    private int memberId;
    private Province provinceByPermanentProvinceCode;
    private Rank rank;
    private BankAccountType bankAccountType;
    private Title title;
    private Province provinceByProvinceCode;
    private MilitaryDepartment militaryDepartment;
    private Bank bank;
    private BankBranch bankBranch;
    private Integer memberGroupCode;
    private String memberCode;
    private Date applyDate;
    private String citizenId;
    private String name;
    private String surname;
    private Character gender;
    private Date birthDate;
    private Integer memberTypeCode;
    private Integer paymentType;
    private Integer referrerId;
    private Integer referrerRelationshipCode;
    private Integer marryStatusCode;
    private String wifehusbandFullname;
    private String remark;
    private String paymentTypeCode;
    private String paymentRemark;
    private String bankAccName;
    private String bankAccNo;
    private String permanentAddress;
    private String permanentMoo;
    private String permanentRoad;
    private String permanentSoi;
    private String permanentSubdistrict;
    private String permanentDistrict;
    private String permanentZipcode;
    private String permanentTel;
    private String permanentFax;
    private String permanentMobile;
    private String address;
    private String moo;
    private String road;
    private String soi;
    private String subdistrict;
    private String district;
    private String zipcode;
    private String tel;
    private String fax;
    private String mobile;
    private Character addressPrimary;
    private Integer memberStatusCode;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private Set<OperationMember> operationMembers = new HashSet<OperationMember>(0);
    private Set<MemberBeneficiary> memberBeneficiaries = new HashSet<MemberBeneficiary>(0);
    private List<String> deleteBeneficiaryId;
    private List<MemberBeneficiary> listMemberBeneficiary;
    private Integer bankBranchId;
    private String branchCode;
    private String branchName;
    private String branchShort;
    private Integer accTypeId;
    private String accTypeName;
    private Integer militaryId;
    private String militaryName;
    private Integer rankId;
    private String rankName;
    private Integer titleId;
    private String titleName;
    private String bankCode;
    private String bankName;
    private String permanentProvinceCode;
    private String permanentProvinceName;
    private String provinceCode;
    private String provinceName;
    private String rankOrTitleName;
    private Integer operationId;
    private String memberCodeOld;
    private Integer mildeptId;
    private Integer officerTypeCode;
    private String position;
    private Integer payerId;
    private Integer microfilmStatusCode;
    private Date approvedDate;
    private Date memberDate;
    private String startMonthCode;
    private String beginSop;
    private Integer stationId;
    private Integer officerId;
    private String rankAndTitleName;

    public MemberData() {
    }

    public MemberData(int memberId) {
        this.memberId = memberId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "member_id", unique = true, nullable = false)
    public int getMemberId() {
        return this.memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permanent_province_code")
    @JsonBackReference
    public Province getProvinceByPermanentProvinceCode() {
        return this.provinceByPermanentProvinceCode;
    }

    public void setProvinceByPermanentProvinceCode(Province provinceByPermanentProvinceCode) {
        this.provinceByPermanentProvinceCode = provinceByPermanentProvinceCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id")
    @JsonBackReference
    public Rank getRank() {
        return this.rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acc_type_id")
    @JsonBackReference
    public BankAccountType getBankAccountType() {
        return this.bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    @JsonBackReference
    public Title getTitle() {
        return this.title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_code")
    @JsonBackReference
    public Province getProvinceByProvinceCode() {
        return this.provinceByProvinceCode;
    }

    public void setProvinceByProvinceCode(Province provinceByProvinceCode) {
        this.provinceByProvinceCode = provinceByProvinceCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "military_id")
    @JsonBackReference
    public MilitaryDepartment getMilitaryDepartment() {
        return this.militaryDepartment;
    }

    public void setMilitaryDepartment(MilitaryDepartment militaryDepartment) {
        this.militaryDepartment = militaryDepartment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_code")
    @JsonBackReference
    public Bank getBank() {
        return this.bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_branch_id")
    @JsonBackReference
    public BankBranch getBankBranch() {
        return this.bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    @Column(name = "member_group_code")
    public Integer getMemberGroupCode() {
        return this.memberGroupCode;
    }

    public void setMemberGroupCode(Integer memberGroupCode) {
        this.memberGroupCode = memberGroupCode;
    }

    @Column(name = "member_code", length = 20)
    public String getMemberCode() {
        return this.memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "apply_date", length = 23)
    public Date getApplyDate() {
        return this.applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "citizen_id", length = 13)
    public String getCitizenId() {
        return this.citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    @Column(name = "name", length = 256)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", length = 256)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "gender", length = 1)
    public Character getGender() {
        return this.gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date", length = 23)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "member_type_code")
    public Integer getMemberTypeCode() {
        return this.memberTypeCode;
    }

    public void setMemberTypeCode(Integer memberTypeCode) {
        this.memberTypeCode = memberTypeCode;
    }

    @Column(name = "payment_type")
    public Integer getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @Column(name = "referrer_id")
    public Integer getReferrerId() {
        return this.referrerId;
    }

    public void setReferrerId(Integer referrerId) {
        this.referrerId = referrerId;
    }

    @Column(name = "referrer_relationship_code")
    public Integer getReferrerRelationshipCode() {
        return this.referrerRelationshipCode;
    }

    public void setReferrerRelationshipCode(Integer referrerRelationshipCode) {
        this.referrerRelationshipCode = referrerRelationshipCode;
    }

    @Column(name = "marry_status_code")
    public Integer getMarryStatusCode() {
        return this.marryStatusCode;
    }

    public void setMarryStatusCode(Integer marryStatusCode) {
        this.marryStatusCode = marryStatusCode;
    }

    @Column(name = "wifehusband_fullname", length = 256)
    public String getWifehusbandFullname() {
        return this.wifehusbandFullname;
    }

    public void setWifehusbandFullname(String wifehusbandFullname) {
        this.wifehusbandFullname = wifehusbandFullname;
    }

    @Column(name = "remark")
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "payment_type_code", length = 10)
    public String getPaymentTypeCode() {
        return this.paymentTypeCode;
    }

    public void setPaymentTypeCode(String paymentTypeCode) {
        this.paymentTypeCode = paymentTypeCode;
    }

    @Column(name = "payment_remark")
    public String getPaymentRemark() {
        return this.paymentRemark;
    }

    public void setPaymentRemark(String paymentRemark) {
        this.paymentRemark = paymentRemark;
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

    @Column(name = "permanent_address", length = 100)
    public String getPermanentAddress() {
        return this.permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Column(name = "permanent_moo", length = 100)
    public String getPermanentMoo() {
        return this.permanentMoo;
    }

    public void setPermanentMoo(String permanentMoo) {
        this.permanentMoo = permanentMoo;
    }

    @Column(name = "permanent_road", length = 100)
    public String getPermanentRoad() {
        return this.permanentRoad;
    }

    public void setPermanentRoad(String permanentRoad) {
        this.permanentRoad = permanentRoad;
    }

    @Column(name = "permanent_soi", length = 100)
    public String getPermanentSoi() {
        return this.permanentSoi;
    }

    public void setPermanentSoi(String permanentSoi) {
        this.permanentSoi = permanentSoi;
    }

    @Column(name = "permanent_subdistrict", length = 100)
    public String getPermanentSubdistrict() {
        return this.permanentSubdistrict;
    }

    public void setPermanentSubdistrict(String permanentSubdistrict) {
        this.permanentSubdistrict = permanentSubdistrict;
    }

    @Column(name = "permanent_district", length = 100)
    public String getPermanentDistrict() {
        return this.permanentDistrict;
    }

    public void setPermanentDistrict(String permanentDistrict) {
        this.permanentDistrict = permanentDistrict;
    }

    @Column(name = "permanent_zipcode", length = 10)
    public String getPermanentZipcode() {
        return this.permanentZipcode;
    }

    public void setPermanentZipcode(String permanentZipcode) {
        this.permanentZipcode = permanentZipcode;
    }

    @Column(name = "permanent_tel", length = 100)
    public String getPermanentTel() {
        return this.permanentTel;
    }

    public void setPermanentTel(String permanentTel) {
        this.permanentTel = permanentTel;
    }

    @Column(name = "permanent_fax", length = 100)
    public String getPermanentFax() {
        return this.permanentFax;
    }

    public void setPermanentFax(String permanentFax) {
        this.permanentFax = permanentFax;
    }

    @Column(name = "permanent_mobile", length = 50)
    public String getPermanentMobile() {
        return this.permanentMobile;
    }

    public void setPermanentMobile(String permanentMobile) {
        this.permanentMobile = permanentMobile;
    }

    @Column(name = "address", length = 100)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "moo", length = 100)
    public String getMoo() {
        return this.moo;
    }

    public void setMoo(String moo) {
        this.moo = moo;
    }

    @Column(name = "road", length = 100)
    public String getRoad() {
        return this.road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    @Column(name = "soi", length = 100)
    public String getSoi() {
        return this.soi;
    }

    public void setSoi(String soi) {
        this.soi = soi;
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

    @Column(name = "mobile", length = 50)
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Column(name = "address_primary", length = 1)
    public Character getAddressPrimary() {
        return this.addressPrimary;
    }

    public void setAddressPrimary(Character addressPrimary) {
        this.addressPrimary = addressPrimary;
    }

    @Column(name = "member_status_code")
    public Integer getMemberStatusCode() {
        return this.memberStatusCode;
    }

    public void setMemberStatusCode(Integer memberStatusCode) {
        this.memberStatusCode = memberStatusCode;
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

    @Transient
    public Set<OperationMember> getOperationMembers() {
        return this.operationMembers;
    }

    public void setOperationMembers(Set<OperationMember> operationMembers) {
        this.operationMembers = operationMembers;
    }

    @Transient
    public Set<MemberBeneficiary> getMemberBeneficiaries() {
        return this.memberBeneficiaries;
    }

    public void setMemberBeneficiaries(Set<MemberBeneficiary> memberBeneficiaries) {
        this.memberBeneficiaries = memberBeneficiaries;
    }

    /**
     * @return the deleteBeneficiaryId
     */
    @Transient
    public List<String> getDeleteBeneficiaryId() {
        return deleteBeneficiaryId;
    }

    /**
     * @param deleteBeneficiaryId the deleteBeneficiaryId to set
     */
    public void setDeleteBeneficiaryId(List<String> deleteBeneficiaryId) {
        this.deleteBeneficiaryId = deleteBeneficiaryId;
    }

    /**
     * @return the listMemberBeneficiary
     */
    @Transient
    public List<MemberBeneficiary> getListMemberBeneficiary() {
        return listMemberBeneficiary;
    }

    /**
     * @param listMemberBeneficiary the listMemberBeneficiary to set
     */
    public void setListMemberBeneficiary(List<MemberBeneficiary> listMemberBeneficiary) {
        this.listMemberBeneficiary = listMemberBeneficiary;
    }

    /**
     * @return the bankBranchId
     */
    @Column(name = "bankBranchId")
    public Integer getBankBranchId() {
        return bankBranchId;
    }

    /**
     * @param bankBranchId the bankBranchId to set
     */
    public void setBankBranchId(Integer bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    /**
     * @return the accTypeIid
     */
    @Column(name = "accTypeId")
    public Integer getAccTypeId() {
        return accTypeId;
    }

    /**
     * @param accTypeId the accTypeId to set
     */
    public void setAccTypeId(Integer accTypeId) {
        this.accTypeId = accTypeId;
    }

    /**
     * @return the militaryId
     */
    ////@Formula("(SELECT M.military_id FROM MilitaryDepartment M WHERE M.military_id=military_id)")
    @Transient
    ////@Formula("(SELECT military_id)")
    //@Column(name = "mi.military_id")
    public Integer getMilitaryId() {
        return militaryId;
    }

    /**
     * @param militaryId the militaryId to set
     */
    public void setMilitaryId(Integer militaryId) {
        this.militaryId = militaryId;
    }

    /**
     * @return the rankId
     */
    @Column(name = "rankId")
    public Integer getRankId() {
        return rankId;
    }

    /**
     * @param rankId the rankId to set
     */
    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    /**
     * @return the titleId
     */
    @Column(name = "titleId")
    public Integer getTitleId() {
        return titleId;
    }

    /**
     * @param titleId the titleId to set
     */
    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    /**
     * @return the bankCode
     */
    @Column(name = "bankCode")
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
     * @return the permanentProvinceCode
     */
    @Column(name = "permanentProvinceCode")
    public String getPermanentProvinceCode() {
        return permanentProvinceCode;
    }

    /**
     * @param permanentProvinceCode the permanentProvinceCode to set
     */
    public void setPermanentProvinceCode(String permanentProvinceCode) {
        this.permanentProvinceCode = permanentProvinceCode;
    }

    /**
     * @return the provinceCode
     */
    @Column(name = "provinceCode")
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
     * @return the militaryName
     */
    ////@Formula("(SELECT M.name FROM MilitaryDepartment M WHERE M.military_id=military_id)")
    @Column(name = "militaryName")
    public String getMilitaryName() {
        return militaryName;
    }

    /**
     * @param militaryName the militaryName to set
     */
    public void setMilitaryName(String militaryName) {
        this.militaryName = militaryName;
    }

    /**
     * @return the branchCode
     */
    @Column(name = "branchCode")
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
    @Transient
    //@Formula("(SELECT B.branch_name FROM BankBranch B WHERE B.branch_id=bank_branch_id)")
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
     * @return the branchShort
     */
    @Transient
    //@Formula("(SELECT B.branch_short FROM BankBranch B WHERE B.branch_id=bank_branch_id)")
    public String getBranchShort() {
        return branchShort;
    }

    /**
     * @param branchShort the branchShort to set
     */
    public void setBranchShort(String branchShort) {
        this.branchShort = branchShort;
    }

    /**
     * @return the accTypeName
     */
    @Transient
    //@Formula("(SELECT B.acc_type_name FROM BankAccountType B WHERE B.acc_type_id=acc_type_id)")
    public String getAccTypeName() {
        return accTypeName;
    }

    /**
     * @param accTypeName the accTypeName to set
     */
    public void setAccTypeName(String accTypeName) {
        this.accTypeName = accTypeName;
    }

    /**
     * @return the rankName
     */
    //
    ////@Formula("(SELECT R.rank_name FROM Rank R WHERE R.rank_id=rank_id)")
    @Column(name = "rankName")
    public String getRankName() {
        return rankName;
    }

    /**
     * @param rankName the rankName to set
     */
    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    /**
     * @return the titleName
     */
    //@Transient
    ////@Formula("(SELECT T.title FROM Title T WHERE T.title_id=title_id)")
    @Column(name = "titleName")
    public String getTitleName() {
        return titleName;
    }

    /**
     * @param titleName the titleName to set
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    /**
     * @return the bankName
     */
    //@Transient
    //@Formula("(SELECT B.bank_name FROM Bank B WHERE B.bank_code=bank_code)")
    @Transient
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
     * @return the permanentProvinceName
     */
    @Column(name = "permanentProvinceName")
    public String getPermanentProvinceName() {
        return permanentProvinceName;
    }

    /**
     * @param permanentProvinceName the permanentProvinceName to set
     */
    public void setPermanentProvinceName(String permanentProvinceName) {
        this.permanentProvinceName = permanentProvinceName;
    }

    /**
     * @return the provinceName
     */
    @Column(name = "provinceName")
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * @param provinceName the provinceName to set
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * @return the rankOrTitleName
     */
    @Transient
    public String getRankOrTitleName() {
        return rankOrTitleName;
    }

    /**
     * @param rankOrTitleName the rankOrTitleName to set
     */
    public void setRankOrTitleName(String rankOrTitleName) {
        this.rankOrTitleName = rankOrTitleName;
    }

    /**
     * @return the rankAndTitleName
     */
    @Transient
    public String getRankAndTitleName() {
        return rankAndTitleName;
    }

    /**
     * @param rankAndTitleName the rankAndTitleName to set
     */
    public void setRankAndTitleName(String rankAndTitleName) {
        this.rankAndTitleName = rankAndTitleName;
    }
    
    /**
     * @return the operationId
     */
    ////@Formula("(SELECT TOP(1) O.operation_id FROM Operation O INNER JOIN OperationMember OM ON O.operation_id = OM.operation_id WHERE OM.member_id=member_id ORDER BY O.operation_id, OM.operation_member_id DESC)")
    @Transient
    public Integer getOperationId() {
        return operationId;
    }

    /**
     * @param operationId the operationId to set
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    /**
     * @return the memberCodeOld
     */
    @Column(name = "member_code_old", length = 20)
    public String getMemberCodeOld() {
        return memberCodeOld;
    }

    /**
     * @param memberCodeOld the memberCodeOld to set
     */
    public void setMemberCodeOld(String memberCodeOld) {
        this.memberCodeOld = memberCodeOld;
    }

    /**
     * @return the mildeptId
     */
    @Column(name = "mildept_id")
    public Integer getMildeptId() {
        return mildeptId;
    }

    /**
     * @param mildeptId the mildeptId to set
     */
    public void setMildeptId(Integer mildeptId) {
        this.mildeptId = mildeptId;
    }

    /**
     * @return the officerTypeCode
     */
    @Column(name = "officer_type_code")
    public Integer getOfficerTypeCode() {
        return officerTypeCode;
    }

    /**
     * @param officerTypeCode the officerTypeCode to set
     */
    public void setOfficerTypeCode(Integer officerTypeCode) {
        this.officerTypeCode = officerTypeCode;
    }

    /**
     * @return the position
     */
    @Column(name = "position", length = 256)
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the payerId
     */
    @Column(name = "payer_id")
    public Integer getPayerId() {
        return payerId;
    }

    /**
     * @param payerId the payerId to set
     */
    public void setPayerId(Integer payerId) {
        this.payerId = payerId;
    }

    /**
     * @return the microfilmStatusCode
     */
    @Column(name = "microfilm_status_code")
    public Integer getMicrofilmStatusCode() {
        return microfilmStatusCode;
    }

    /**
     * @param microfilmStatusCode the microfilmStatusCode to set
     */
    public void setMicrofilmStatusCode(Integer microfilmStatusCode) {
        this.microfilmStatusCode = microfilmStatusCode;
    }

    /**
     * @return the approvedDate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "approved_date", length = 23)
    public Date getApprovedDate() {
        return approvedDate;
    }

    /**
     * @param approvedDate the approvedDate to set
     */
    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    /**
     * @return the memberDate
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "member_date", length = 23)
    public Date getMemberDate() {
        return memberDate;
    }

    /**
     * @param memberDate the memberDate to set
     */
    public void setMemberDate(Date memberDate) {
        this.memberDate = memberDate;
    }

    /**
     * @return the startMonthCode
     */
    @Column(name = "start_month_code", length = 5)
    public String getStartMonthCode() {
        return startMonthCode;
    }

    /**
     * @param startMonthCode the startMonthCode to set
     */
    public void setStartMonthCode(String startMonthCode) {
        this.startMonthCode = startMonthCode;
    }

    /**
     * @return the beginSop
     */
    @Column(name = "begin_sop", length = 15)
    public String getBeginSop() {
        return beginSop;
    }

    /**
     * @param beginSop the beginSop to set
     */
    public void setBeginSop(String beginSop) {
        this.beginSop = beginSop;
    }

    /**
     * @return the stationId
     */
    @Column(name = "station_id")
    public Integer getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the officerId
     */
    @Column(name = "officer_id")
    public Integer getOfficerId() {
        return officerId;
    }

    /**
     * @param officerId the officerId to set
     */
    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }
}
