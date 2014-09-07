<%-- 
    Document   : APP010_2_Edit
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">

    var urlEdit = rootPath + '/Plugins/Registration/setSaveEditAPP010.json';
    var urlLoad = rootPath + '/Plugins/Registration/getLoadAPP010.json';
    var urlLoadMemberBeneficiary = rootPath + '/Plugins/Registration/getListMemberBeneficiaryAPP010.json';
    var urlListJsonRank = rootPath + '/Plugins/MasterData/getListInJSONRank.json';
    var urlListJsonTitle = rootPath + '/Plugins/MasterData/getListInJSONTitle.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';
    var urlListJsonBankBranch = rootPath + '/Plugins/MasterData/getListInJSONBankBranch.json';
    var urlListJsonBankAccountType = rootPath + '/Plugins/MasterData/getListInJSONBankAccountType.json';
    var urlListJsonProvince = rootPath + '/Plugins/MasterData/getListInJSONProvince.json';
    var urlListMAS010_2 = rootPath + '/Plugins/Registration/getListAPP010.json';

    var objectDefault = {};
    var inputToMergeEdit = ['#hidMemberIdEdit', '#slMemberGroupCodeEdit', '#txtApplyDateEdit', '#txtCitizenIdEdit', '#slMilitaryIdEdit', '#slRankIdEdit', '#slTitleIdEdit', '#txtNameEdit', '#txtSurnameEdit', '#slGenderEdit', '#txtBirthDateEdit', '#slMemberTypeCodeEdit', '#slPaymentTypeEdit', '#hidReferrerIdEdit', '#slReferrerRelationshipCodeEdit', '#slMarryStatusCodeEdit', '#txtWifehusbandFullnameEdit', '#txtRemarkEdit', '#slPaymentTypeCodeEdit', '#txtPaymentRemarkEdit', '#txtBankAccNameEdit', '#slBankCodeEdit', '#slBankBranchIdEdit', '#txtBankAccNoEdit', '#slAccTypeIdEdit', '#txtPermanentAddressEdit', '#txtPermanentMooEdit', '#txtPermanentRoadEdit', '#txtPermanentSoiEdit', '#txtPermanentSubdistrictEdit', '#txtPermanentDistrictEdit', '#slPermanentProvinceCodeEdit', '#txtPermanentZipcodeEdit', '#txtPermanentTelEdit', '#txtPermanentFaxEdit', '#txtPermanentMobileEdit', '#txtAddressEdit', '#txtMooEdit', '#txtRoadEdit', '#txtSoiEdit', '#txtSubdistrictEdit', '#txtDistrictEdit', '#slProvinceCodeEdit', '#txtZipcodeEdit', '#txtTelEdit', '#txtFaxEdit', '#txtMobileEdit', 'input:radio[name=rdAddressPrimaryEdit]:checked'];
    var inputToChangeEdit = ['memberId', 'memberGroupCode', 'applyDate', 'citizenId', 'militaryId', 'rankId', 'titleId', 'name', 'surname', 'gender', 'birthDate', 'memberTypeCode', 'paymentType', 'referrerId', 'referrerRelationshipCode', 'marryStatusCode', 'wifehusbandFullname', 'remark', 'paymentTypeCode', 'paymentRemark', 'bankAccName', 'bankCode', 'bankBranchId', 'bankAccNo', 'accTypeId', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentProvinceCode', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'mobile', 'addressPrimary'];

    var inputToMergeMemberBeneficiaryEdit = ['#txtCitizenIdMemberBeneficiaryEdit', '#slRankIdMemberBeneficiaryEdit', '#slTitleIdMemberBeneficiaryEdit', '#txtNameMemberBeneficiaryEdit', '#txtSurnameMemberBeneficiaryEdit', '#slMemberRelationshipCodeMemberBeneficiaryEdit', '#txtPermanentAddressEdit', '#txtPermanentMooMemberBeneficiaryEdit', '#txtPermanentRoadMemberBeneficiaryEdit', '#txtPermanentSoiMemberBeneficiaryEdit', '#txtPermanentSubdistrictMemberBeneficiaryEdit', '#txtPermanentDistrictMemberBeneficiaryEdit', '#txtPermanentZipcodeMemberBeneficiaryEdit', '#txtPermanentTelMemberBeneficiaryEdit', '#txtPermanentFaxMemberBeneficiaryEdit', '#txtPermanentMobileMemberBeneficiaryEdit', '#txtAddressMemberBeneficiaryEdit', '#txtMooMemberBeneficiaryEdit', '#txtRoadMemberBeneficiaryEdit', '#txtSoiMemberBeneficiaryEdit', '#txtSubdistrictMemberBeneficiaryEdit', '#txtDistrictMemberBeneficiaryEdit', '#txtZipcodeMemberBeneficiaryEdit', '#txtTelMemberBeneficiaryEdit', '#txtFaxMemberBeneficiaryEdit', '#txtMobileMemberBeneficiaryEdit', '#slPermanentProvinceCodeMemberBeneficiaryEdit', '#slProvinceCodeMemberBeneficiaryEdit'];
    var inputToChangeMemberBeneficiaryEdit = ['citizenId', 'rankId', 'titleId', 'name', 'surname', 'memberRelationshipCode', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'zipcode', 'tel', 'fax', 'mobile', 'permanentProvinceCode', 'provinceCode'];

    var inputToMergeMemberBeneficiaryEditForEdit = ['#hidBeneficiaryIdMemberBeneficiaryEditForEdit', '#hidIdMemberBeneficiaryEditForEdit', '#txtCitizenIdMemberBeneficiaryEditForEdit', '#slRankIdMemberBeneficiaryEditForEdit', '#slTitleIdMemberBeneficiaryEditForEdit', '#txtNameMemberBeneficiaryEditForEdit', '#txtSurnameMemberBeneficiaryEditForEdit', '#slMemberRelationshipCodeMemberBeneficiaryEditForEdit', '#txtPermanentAddressEditForEdit', '#txtPermanentMooMemberBeneficiaryEditForEdit', '#txtPermanentRoadMemberBeneficiaryEditForEdit', '#txtPermanentSoiMemberBeneficiaryEditForEdit', '#txtPermanentSubdistrictMemberBeneficiaryEditForEdit', '#txtPermanentDistrictMemberBeneficiaryEditForEdit', '#txtPermanentZipcodeMemberBeneficiaryEditForEdit', '#txtPermanentTelMemberBeneficiaryEditForEdit', '#txtPermanentFaxMemberBeneficiaryEditForEdit', '#txtPermanentMobileMemberBeneficiaryEditForEdit', '#txtAddressMemberBeneficiaryEditForEdit', '#txtMooMemberBeneficiaryEditForEdit', '#txtRoadMemberBeneficiaryEditForEdit', '#txtSoiMemberBeneficiaryEditForEdit', '#txtSubdistrictMemberBeneficiaryEditForEdit', '#txtDistrictMemberBeneficiaryEditForEdit', '#txtZipcodeMemberBeneficiaryEditForEdit', '#txtTelMemberBeneficiaryEditForEdit', '#txtFaxMemberBeneficiaryEditForEdit', '#txtMobileMemberBeneficiaryEditForEdit', '#slPermanentProvinceCodeMemberBeneficiaryEditForEdit', '#slProvinceCodeMemberBeneficiaryEditForEdit'];
    var inputToChangeMemberBeneficiaryEditForEdit = ['beneficiaryId', 'id', 'citizenId', 'rankId', 'titleId', 'name', 'surname', 'memberRelationshipCode', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'zipcode', 'tel', 'fax', 'mobile', 'permanentProvinceCode', 'provinceCode'];

    var objIdKeyEdit = 'memberId';
    var listRank = {};
    var listTitle = {};
    var listMilitaryDepartment = {};
    var listBank = {};
    var listBankBranch = {};
    var listBankAccountType = {};
    var listProvince = {};
    var myStringListAPP010 = {};
    var listAPP010 = [];
    var listAPP010Delete = [];

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP010_2_Edit.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP010_2_Edit_Select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP010_2_Edit.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            แก้ไขผู้สมัครเป็นสมาชิก
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <form class="form-horizontal" name="frmEdit" id="frmEdit">
            <div id="ListView" class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <div id="frmCriterionSearch" class="form-horizontal">                         
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2">
                                    <label class="control-label no-padding-right" for="lbMemberGroupCodeEdit">ประเภทสมาชิก <span style="color:red;">*</span></label>
                                </div>
                                <div class="col-md-3">
                                    <input type="hidden" name="hidMemberIdEdit" id="hidMemberIdEdit" value="${memberId}"/>
                                    <select name="slMemberGroupCodeEdit" id="slMemberGroupCodeEdit" class="form-control select2">
                                        <option value="0">เลือกประเภทสมาชิก</option>
                                        <option value="10">ข้าราชการ</option>
                                        <option value="20">ลูกจ้าง</option>
                                        <option value="30">ครอบครัว</option>
                                        <option value="40">พลทหารกองประจำการ</option>
                                    </select>                                
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2">
                                    <label class="control-label no-padding-right" for="lbCitizenIdEdit">เลขประจำตัวประชาชน <span style="color:red;">*</span></label>
                                </div>
                                <div class="col-md-3">
                                    <input type="text" maxlength="13" id="txtCitizenIdEdit" name="txtCitizenIdEdit" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2"></div>
                                <div class="col-md-3">
                                    <button type="button" id="bootbox-options" class="btn btn-success"><i class="ace-icon fa fa-check-square-o bigger-110"></i> ตรวจสอบ </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- #section:elements.tab.option -->
                    <div class="row">
                        <div id="tabMainMember">
                            <ul>
                                <li> <a data-toggle="tab" href="#tabMember">ข้อมูลสมาชิก</a> </li>
                                <li> <a data-toggle="tab" href="#tabAddress">ที่อยู่</a> </li>
                                <li> <a data-toggle="tab" href="#tabMemberBeneficiary">ผู้รับเงินสงเคราห์</a> </li>
                                <li> <a data-toggle="tab" href="#tabPayment">ประเภทการชำระเงิน</a> </li>
                            </ul>
                            <div class="tab-content">
                                <div id="tabMember">
                                    <div class="row">
                                        <div class="col-xs-10">
                                            <div class="form-horizontal">
                                                <!-- #section:elements.form -->
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbApplyDateEdit" class="control-label no-padding-left">วันที่สมัคร<span style="color:red;">*</span> </label>
                                                    </div>                                                    
                                                    <div class="col-md-3">
                                                        <div class="input-group input-group-sm">
                                                            <input type="text" id="txtApplyDateEdit" name="txtApplyDateEdit" class="form-control"/>
                                                            <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbMemberTypeCodeEdit" class="control-label no-padding-right">ประเภทการสมัคร<span style="color:red;">*</span></label>
                                                    </div>

                                                    <div class="col-md-3">
                                                        <select id="slMemberTypeCodeEdit" name="slMemberTypeCodeEdit" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="10">สมัครด้วยตนเอง</option>
                                                            <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                                            <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                                            <option value="40">สมัครผ่านกรณีพิเศษ</option>						  
                                                        </select>
                                                    </div>
                                                </div>		  

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbRankIdEdit" class="control-label no-padding-right">ยศ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slRankIdEdit" name="slRankIdEdit" class="form-control select2">				  
                                                        </select>					
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbTitleIdEdit" class="control-label no-padding-right">คำนำหน้า</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slTitleIdEdit" name="slTitleIdEdit" class="form-control select2">				  
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbNameEdit" class="control-label no-padding-right">ชื่อ<span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtNameEdit" name="txtNameEdit" type="text" class="form-control"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label class="control-label no-padding-right" for="lbSurnameEdit">สกุล<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSurnameEdit" name="txtSurnameEdit" type="text" class="form-control"/>
                                                    </div>
                                                </div>		  

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBirthDateEdit" class="control-label no-padding-right">วันเดือนปีเกิด<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">            
                                                        <div class="input-group input-group-sm">
                                                            <input id="txtBirthDateEdit" name="txtBirthDateEdit" type="text" class="form-control"/>
                                                            <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i> </span> </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <label for="lbAgeEdit" class="control-label no-padding-right">อายุ</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="col-lg-12">
                                                            <div class="col-md-6">
                                                                <input id="txtAgeEdit" name="txtAgeEdit" type="text" class="form-control" />
                                                            </div>
                                                            <div class="col-md-3">
                                                                <label for="lbAgeYearEdit" class="control-label no-padding-right">ปี</label>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <label class="control-label no-padding-right">เพศ<span style="color:red;">*</span></label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select id="slGenderEdit" name="slGenderEdit" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="M">ชาย</option>
                                                            <option value="F">หญิง</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMilitaryIdEdit" class="control-label no-padding-right">หน่วยต้นสังกัด </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slMilitaryIdEdit" name="slMilitaryIdEdit" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPaymentTypeEdit" class="control-label no-padding-right">ประเภทการชำระเงิน <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPaymentTypeEdit" name="slPaymentTypeEdit" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="10">ชำระผ่านหน่วยต้นสังกัด</option>
                                                            <option value="20">ชำระด้วยตนเอง</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbReferrerIdEdit" class="control-label no-padding-right">รหัสผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-3">
                                                        <div class="input-group">
                                                            <input id="hidReferrerIdEdit" name="hidReferrerIdEdit" type="hidden" value="0">
                                                            <input id="txtReferrerCodeEdit" name="txtReferrerCodeEdit" type="text" class="form-control search-query">

                                                            <span class="input-group-btn"><a href="#modal-form" role="button" class="blue" data-toggle="modal">
                                                                    <button id="btnReferrerEdit" name="btnReferrerEdit" class="btn btn-purple btn-sm" type="button" > เลือกสมาชิก <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
                                                                </a> </span> </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">                                                   
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbReferrerFullnameEdit" class="control-label no-padding-right">ชื่อผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtReferrerFullnameEdit" name="txtReferrerFullnameEdit" type="text"  class="form-control" readonly="readonly">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-3">
                                                        <label for="lbReferrerRelationshipCodeEdit" class="control-label no-padding-right">ความเกี่ยวพันกับผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slReferrerRelationshipCodeEdit" name="slReferrerRelationshipCodeEdit" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="10">บุตร/ธิดา</option>
                                                            <option value="20">บิดา</option>
                                                            <option value="30">มารดา</option>
                                                            <option value="40">มารดาคู่สมรส</option>
                                                            <option value="50">บิดาคู่สมรส</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMarryStatusCodeC" class="control-label no-padding-right">สถานภาพสมรส </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slMarryStatusCodeEdit" name="slMarryStatusCodeEdit" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="10">โสด</option>
                                                            <option value="20">มีสามี</option>
                                                            <option value="30">มีภรรยา</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbWifehusbandFullnameEdit" class="control-label no-padding-right">ชื่อคู่สมรส </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtWifehusbandFullnameEdit" name="txtWifehusbandFullnameEdit" type="text" class="form-control" >
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbRemarkEdit" class="control-label no-padding-right" > หมายเหตุ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <textarea id="txtRemarkEdit" name="txtRemarkEdit" class="form-control limited"  maxlength="50" style="width: 400px"></textarea>
                                                    </div>
                                                </div>
                                                <!-- /section:elements.form -->
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div id="tabAddress">
                                    <div class="row">
                                        <div class="col-xs-10">
                                            <div class="form-horizontal">
                                                <!-- #section:elements.form -->
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"></div>
                                                    <div class="col-md-3">
                                                        <label class="control-label no-padding-right" for="lbRegisteredAddress"><strong>ที่อยู่ตามทะเบียนบ้าน</strong></label>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentAddressEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                                                    </div>                                                    
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentAddressEdit" name="txtPermanentAddressEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentMooEdit" class="control-label no-padding-right">หมู่ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentMooEdit" name="txtPermanentMooEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentRoadEdit" class="control-label no-padding-right">ถนน </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentRoadEdit" name="txtPermanentRoadEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentSoiEdit" class="control-label no-padding-right">ซอย </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentSoiEdit" name="txtPermanentSoiEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentSubdistrictEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentSubdistrictEdit" name="txtPermanentSubdistrictEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentDistrictEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentDistrictEdit" name="txtPermanentDistrictEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentProvinceCodeEdit" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPermanentProvinceCodeEdit" name="slPermanentProvinceCodeEdit" class="form-control select2">
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentZipcodeEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentZipcodeEdit" name="txtPermanentZipcodeEdit" class="form-control" type="text">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentTelEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentTelEdit" name="txtPermanentTelEdit" type="text" class="form-control">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentFaxEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentFaxEdit" name="txtPermanentFaxEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentMobileEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentMobileEdit" name="txtPermanentMobileEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <br/>
                                                <div class="page-header"> </div>
                                                <br/>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"></div>
                                                    <div class="col-md-3">
                                                        <label for="lbAsRegisteredAddressEdit" class="control-label no-padding-right"><strong>ที่อยู่ที่ติดต่อได้</strong></label>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"></div>
                                                    <div class="col-md-3">
                                                        <input id="chkAsRegisteredAddressEdit" name="chkAsRegisteredAddressEdit" type="checkbox" value="E"> เหมือนที่อยู่ตามทะเบียนบ้าน</div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbAddressEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtAddressEdit" name="txtAddressEdit" type="text" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMooEdit" class="control-label no-padding-right">หมู่ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtMooEdit" name="txtMooEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbRoadEdit" class="control-label no-padding-right">ถนน </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtRoadEdit" name="txtRoadEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbSoiEdit" class="control-label no-padding-right">ซอย </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSoiEdit" name="txtSoiEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbSubdistrictEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSubdistrictEdit" name="txtSubdistrictEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbDistrictEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtDistrictEdit" name="txtDistrictEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbProvinceCodeEdit" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slProvinceCodeEdit" name="slProvinceCodeEdit" class="form-control select2">
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbZipcodeEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtZipcodeEdit" name="txtZipcodeEdit" type="text" class="control-label">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbTelEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtTelEdit" name="txtTelEdit" type="text" class="form-control">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbFaxEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtFaxEdit" name="txtFaxEdit" type="text" class="control-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMobileEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtMobileEdit" name="txtMobileEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <br/>
                                                <div class="form-group">
                                                    <div class="col-md-3">
                                                        <label class="control-label no-padding-right" for="lbAddressPrimaryEdit"><strong>ที่อยู่ในการจัดส่งเอกสาร</strong></label>
                                                    </div>
                                                    <div class="col-md-8" style="padding-top: 8px;">
                                                        <div class="col-md-4 no-padding-left">
                                                            <input type="radio" value="1" name="rdAddressPrimaryEdit" class="ace" checked><span class="lbl"> ที่อยู่หน่วยต้นสังกัด</span>  
                                                        </div>
                                                        <div class="col-md-4 no-padding-left">
                                                            <input type="radio" value="2" name="rdAddressPrimaryEdit" class="ace"><span class="lbl"> ที่อยู่ปัจจุบัน</span>
                                                        </div>
                                                        <div class="col-md-4 no-padding-left">
                                                            <input type="radio" value="3" name="rdAddressPrimaryEdit" class="ace"><span class="lbl"> ที่อยู่ตามทะเบียนบ้าน</span>								  
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /section:elements.form -->
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div id="tabMemberBeneficiary">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="row">
                                                <div class="col-md-5">
                                                    <div class="col-md-5 no-padding-left">
                                                        <button id="btnAddMemberBeneficiaryEdit" name="btnAddMemberBeneficiaryEdit" type="button" class="btn btn-sm btn-primary"><i class="ace-icon fa glyphicon-plus bigger-110"></i>&nbsp;เพิ่มผู้รับเงินสงเคราห์</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="jqGridContainer" class="row">
                                                <div class="col-xs-12">
                                                    <table id="gridData_APP010_2_Edit_Grid_List"></table>
                                                    <div id="gridPager_APP010_2_Edit_jqGrid_List"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div id="tabPayment">
                                    <div class="row">
                                        <div class="col-xs-10">
                                            <div class="form-horizontal">
                                                <!-- #section:elements.form -->
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPaymentTypeCodeEdit" class="control-label no-padding-right">ประเภทการชำระเงิน <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPaymentTypeCodeEdit" name="slPaymentTypeCodeEdit" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="10">ชำระผ่านหน่วยต้นสังกัด</option>
                                                            <option value="20">ชำระด้วยตนเอง - เงินสด</option>
                                                            <option value="30">ชำระด้วยตนเอง - ธนาณัติ</option>
                                                            <option value="40">ชำระด้วยตนเอง - ผ่านบัญชีธนาคาร</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPaymentRemarkEdit" class="control-label no-padding-right">หมายเหตุ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <textarea id="txtPaymentRemarkEdit" name="txtPaymentRemarkEdit" class="form-control limited" maxlength="50" style="width: 400px"></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankAccNameEdit" class="control-label no-padding-right">ชื่อบัญชี </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtBankAccNameEdit" name="txtBankAccNameEdit" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-3">
                                                        <label for="lbBankCodeEdit" class="control-label no-padding-right">บัญชีเงินฝากของธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankCodeEdit" name="slBankCodeEdit" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankBranchIdEdit" class="control-label no-padding-right">สาขาธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankBranchIdEdit" name="slBankBranchIdEdit" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankAccNoEdit" class="control-label no-padding-right">เลขบัญชี </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbAccTypeIdEdit" class="control-label no-padding-right">ประเภทบัญชี </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slAccTypeIdEdit" name="slAccTypeIdEdit" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <!-- /section:elements.form -->
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /section:elements.tab.option -->
                        </div>
                    </div>

                    <!-- PAGE CONTENT ENDS -->
                </div>
                <div class="row">
                    <br />
                    <div class="col-xs-6 col-sm-3"></div>
                    <div class="col-xs-6 col-sm-1">
                        <button type="button" id="btnSaveEdit" name="btnSaveEdit" class="btn btn-info"><i class="ace-icon fa fa-floppy-o bigger-110"></i> บันทึก </button>
                    </div>
                    <div class="col-xs-6 col-sm-1">
                        <button type="reset" class="btn"><i class="ace-icon fa fa-undo bigger-110"></i> ยกเลิก </button>
                    </div>
                    <div class="col-xs-6 col-sm-1">
                        <button class="btn btn-pink"><i class="ace-icon fa fa-print align-top bigger-125"></i> พิมพ์ใบสมัคร  </button>
                    </div>
                </div>
            </div>
            <!-- /.col -->
        </form>

        <div id="dialogFormReferrerEdit" class="hide">
            <div class="bs-component">
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbMemberRegistrationReferrerEdit" class="control-label no-padding-right">เลขทะเบียนสมาชิก</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbIdentificationNumberReferrerEdit" class="control-label no-padding-right">เลขประจำตัวประชาชน</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbNameReferrerEdit" class="control-label no-padding-right">ชื่อ</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbCurrencyReferrerEdit" class="control-label no-padding-right">สกุล</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbGovernmentAgencyReferrerEdit" class="control-label no-padding-right">หน่วยต้นสังกัด</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbStatusReferrerEdit" class="control-label no-padding-right">สถานะ</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoEdit" name="txtBankAccNoEdit" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_MAS010_2_Edit_Select_jqGrid_List"></table>
                        <div id="gridPager_MAS010_2_Edit_Select_jqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>

        <div id="dialogFormMemberBeneficiaryEdit" class="hide">
            <div class="col-xs-12">
                <form class="form-horizontal" name="frmMemberBeneficiaryEdit" id="frmMemberBeneficiaryEdit">
                    <div class="form-horizontal">
                        <!-- #section:elements.form -->
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbCitizenIdMemberBeneficiaryEdit" class="control-label no-padding-right">เลขประจำตัวประชาชน <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtCitizenIdMemberBeneficiaryEdit" name="txtCitizenIdMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbRankIdMemberBeneficiaryEdit" class="control-label no-padding-right">ยศ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slRankIdMemberBeneficiaryEdit" name="slRankIdMemberBeneficiaryEdit" class="form-control select2">				  
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbTitleIdMemberBeneficiaryEdit" class="control-label no-padding-right">คำนำหน้า <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slTitleIdMemberBeneficiaryEdit" name="slTitleIdMemberBeneficiaryEdit" class="form-control select2">				  
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbNameMemberBeneficiaryEdit" class="control-label no-padding-right">ชื่อผู้รับผลประโยชน์ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtNameMemberBeneficiaryEdit" name="txtNameMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbSurnameMemberBeneficiaryEdit" class="control-label no-padding-right">สกุล <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtSurnameMemberBeneficiaryEdit" name="txtSurnameMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMemberRelationshipCodeMemberBeneficiaryEdit" class="control-label no-padding-right">ความเกี่ยวพันกับสมาชิก <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slMemberRelationshipCodeMemberBeneficiaryEdit" name="slMemberRelationshipCodeMemberBeneficiaryEdit" class="form-control select2">				  
                                    <option value="1">คู่สมรส</option>
                                    <option value="2">บุตร/ธิดา</option>
                                    <option value="3">บิดา</option>
                                    <option value="4">มารดา</option>
                                    <option value="5">มารดาคู่สมรส</option>
                                </select>
                            </div>
                        </div>
                        <br/>
                        <div class="page-header"> </div>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-3">
                                <label class="control-label no-padding-right" for="lbRegisteredAddressMemberBeneficiaryEdit"><strong>ที่อยู่ตามทะเบียนบ้าน</strong></label>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentAddressMemberBeneficiaryEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtPermanentAddressEdit" name="txtPermanentAddressMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMooMemberBeneficiaryEdit" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMooMemberBeneficiaryEdit" name="txtPermanentMooMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentRoadMemberBeneficiaryEdit" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentRoadMemberBeneficiaryEdit" name="txtPermanentRoadMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSoiMemberBeneficiaryEdit" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSoiMemberBeneficiaryEdit" name="txtPermanentSoiMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSubdistrictMemberBeneficiaryEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSubdistrictMemberBeneficiaryEdit" name="txtPermanentSubdistrictMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentDistrictMemberBeneficiaryEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentDistrictMemberBeneficiaryEdit" name="txtPermanentDistrictMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentProvinceCodeMemberBeneficiaryEdit" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slPermanentProvinceCodeMemberBeneficiaryEdit" name="slPermanentProvinceCodeMemberBeneficiaryEdit" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentZipcodeMemberBeneficiaryEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentZipcodeMemberBeneficiaryEdit" name="txtPermanentZipcodeMemberBeneficiaryEdit" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentTelMemberBeneficiaryEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentTelMemberBeneficiaryEdit" name="txtPermanentTelMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentFaxMemberBeneficiaryEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentFaxMemberBeneficiaryEdit" name="txtPermanentFaxMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMobileMemberBeneficiaryEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMobileMemberBeneficiaryEdit" name="txtPermanentMobileMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <br/>
                        <div class="page-header"> </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-3">
                                <label for="lbAsRegisteredAddressMemberBeneficiaryEdit" class="control-label no-padding-right"><strong>ที่อยู่ที่ติดต่อได้</strong></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-4">
                                <input id="chkAsRegisteredAddressMemberBeneficiaryEdit" name="chkAsRegisteredAddressMemberBeneficiaryEdit" type="checkbox" value="E"> เหมือนที่อยู่ตามทะเบียนบ้าน</div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbAddressMemberBeneficiaryEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtAddressMemberBeneficiaryEdit" name="txtAddressMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMooMemberBeneficiaryEdit" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMooMemberBeneficiaryEdit" name="txtMooMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbRoadMemberBeneficiaryEdit" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtRoadMemberBeneficiaryEdit" name="txtRoadMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSoiMemberBeneficiaryEdit" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSoiMemberBeneficiaryEdit" name="txtSoiMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSubdistrictMemberBeneficiaryEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSubdistrictMemberBeneficiaryEdit" name="txtSubdistrictMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbDistrictMemberBeneficiaryEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtDistrictMemberBeneficiaryEdit" name="txtDistrictMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbProvinceCodeMemberBeneficiaryEdit" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slProvinceCodeMemberBeneficiaryEdit" name="slProvinceCodeMemberBeneficiaryEdit" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbZipcodeMemberBeneficiaryEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtZipcodeMemberBeneficiaryEdit" name="txtZipcodeMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbTelMemberBeneficiaryEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtTelMemberBeneficiaryEdit" name="txtTelMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbFaxMemberBeneficiaryEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtFaxMemberBeneficiaryEdit" name="txtFaxMemberBeneficiaryEdit" type="text" class="control-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMobileMemberBeneficiaryEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMobileMemberBeneficiaryEdit" name="txtMobileMemberBeneficiaryEdit" type="text" class="form-control">
                            </div>
                        </div>                    
                        <!-- /section:elements.form -->
                    </div>
                </form>
            </div>
        </div>

        <div id="dialogFormMemberBeneficiaryEditForEdit" class="hide">
            <div class="col-xs-12">
                <form class="form-horizontal" name="frmMemberBeneficiaryEditForEdit" id="frmMemberBeneficiaryEditForEdit">
                    <div class="form-horizontal">
                        <!-- #section:elements.form -->
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbCitizenIdMemberBeneficiaryEditForEdit" class="control-label no-padding-right">เลขประจำตัวประชาชน <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3"><input id="hidBeneficiaryIdMemberBeneficiaryEditForEdit" name="hidBeneficiaryIdMemberBeneficiaryEditForEdit" type="hidden">
                                <input id="hidIdMemberBeneficiaryEditForEdit" name="hidIdMemberBeneficiaryEditForEdit" type="hidden">
                                <input id="txtCitizenIdMemberBeneficiaryEditForEdit" name="txtCitizenIdMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbRankIdMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ยศ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slRankIdMemberBeneficiaryEditForEdit" name="slRankIdMemberBeneficiaryEditForEdit" class="form-control select2">				  
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbTitleIdMemberBeneficiaryEditForEdit" class="control-label no-padding-right">คำนำหน้า <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slTitleIdMemberBeneficiaryEditForEdit" name="slTitleIdMemberBeneficiaryEditForEdit" class="form-control select2">				  
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbNameMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ชื่อผู้รับผลประโยชน์ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtNameMemberBeneficiaryEditForEdit" name="txtNameMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbSurnameMemberBeneficiaryEditForEdit" class="control-label no-padding-right">สกุล <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtSurnameMemberBeneficiaryEditForEdit" name="txtSurnameMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMemberRelationshipCodeMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ความเกี่ยวพันกับสมาชิก <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slMemberRelationshipCodeMemberBeneficiaryEditForEdit" name="slMemberRelationshipCodeMemberBeneficiaryEditForEdit" class="form-control select2">				  
                                    <option value="1">คู่สมรส</option>
                                    <option value="2">บุตร/ธิดา</option>
                                    <option value="3">บิดา</option>
                                    <option value="4">มารดา</option>
                                    <option value="5">มารดาคู่สมรส</option>
                                </select>
                            </div>
                        </div>
                        <br/>
                        <div class="page-header"> </div>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-3">
                                <label class="control-label no-padding-right" for="lbRegisteredAddressMemberBeneficiaryEditForEdit"><strong>ที่อยู่ตามทะเบียนบ้าน</strong></label>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentAddressMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtPermanentAddressEditForEdit" name="txtPermanentAddressMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMooMemberBeneficiaryEditForEdit" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMooMemberBeneficiaryEditForEdit" name="txtPermanentMooMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentRoadMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentRoadMemberBeneficiaryEditForEdit" name="txtPermanentRoadMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSoiMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSoiMemberBeneficiaryEditForEdit" name="txtPermanentSoiMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSubdistrictMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSubdistrictMemberBeneficiaryEditForEdit" name="txtPermanentSubdistrictMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentDistrictMemberBeneficiaryEditForEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentDistrictMemberBeneficiaryEditForEdit" name="txtPermanentDistrictMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentProvinceCodeMemberBeneficiaryEditForEdit" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slPermanentProvinceCodeMemberBeneficiaryEditForEdit" name="slPermanentProvinceCodeMemberBeneficiaryEditForEdit" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentZipcodeMemberBeneficiaryEditForEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentZipcodeMemberBeneficiaryEditForEdit" name="txtPermanentZipcodeMemberBeneficiaryEditForEdit" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentTelMemberBeneficiaryEditForEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentTelMemberBeneficiaryEditForEdit" name="txtPermanentTelMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentFaxMemberBeneficiaryEditForEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentFaxMemberBeneficiaryEditForEdit" name="txtPermanentFaxMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMobileMemberBeneficiaryEditForEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMobileMemberBeneficiaryEditForEdit" name="txtPermanentMobileMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <br/>
                        <div class="page-header"> </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-3">
                                <label for="lbAsRegisteredAddressMemberBeneficiaryEditForEdit" class="control-label no-padding-right"><strong>ที่อยู่ที่ติดต่อได้</strong></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-4">
                                <input id="chkAsRegisteredAddressMemberBeneficiaryEditForEdit" name="chkAsRegisteredAddressMemberBeneficiaryEditForEdit" type="checkbox" value="E"> เหมือนที่อยู่ตามทะเบียนบ้าน</div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbAddressMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtAddressMemberBeneficiaryEditForEdit" name="txtAddressMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMooMemberBeneficiaryEditForEdit" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMooMemberBeneficiaryEditForEdit" name="txtMooMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbRoadMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtRoadMemberBeneficiaryEditForEdit" name="txtRoadMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSoiMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSoiMemberBeneficiaryEditForEdit" name="txtSoiMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSubdistrictMemberBeneficiaryEditForEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSubdistrictMemberBeneficiaryEditForEdit" name="txtSubdistrictMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbDistrictMemberBeneficiaryEditForEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtDistrictMemberBeneficiaryEditForEdit" name="txtDistrictMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbProvinceCodeMemberBeneficiaryEditForEdit" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slProvinceCodeMemberBeneficiaryEditForEdit" name="slProvinceCodeMemberBeneficiaryEditForEdit" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbZipcodeMemberBeneficiaryEditForEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtZipcodeMemberBeneficiaryEditForEdit" name="txtZipcodeMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbTelMemberBeneficiaryEditForEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtTelMemberBeneficiaryEditForEdit" name="txtTelMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbFaxMemberBeneficiaryEditForEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtFaxMemberBeneficiaryEditForEdit" name="txtFaxMemberBeneficiaryEditForEdit" type="text" class="control-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMobileMemberBeneficiaryEditForEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMobileMemberBeneficiaryEditForEdit" name="txtMobileMemberBeneficiaryEditForEdit" type="text" class="form-control">
                            </div>
                        </div>                    
                        <!-- /section:elements.form -->
                    </div>
                </form>
            </div>
        </div>
    </div><!-- /.row -->
</div>
<!-- basic scripts -->

<!-- inline scripts related to this page -->
