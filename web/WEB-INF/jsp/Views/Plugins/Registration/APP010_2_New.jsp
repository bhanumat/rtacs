<%-- 
    Document   : APP010_2_New
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">

    var urlNew = rootPath + '/Plugins/Registration/setSaveNewAPP010.json';
    var urlListJsonRank = rootPath + '/Plugins/MasterData/getListInJSONRank.json';
    var urlListJsonTitle = rootPath + '/Plugins/MasterData/getListInJSONTitle.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';
    var urlListJsonBankBranch = rootPath + '/Plugins/MasterData/getListInJSONBankBranch.json';
    var urlListJsonBankAccountType = rootPath + '/Plugins/MasterData/getListInJSONBankAccountType.json';
    var urlListJsonProvince = rootPath + '/Plugins/MasterData/getListInJSONProvince.json';
    var urlListAPP010_2_New_Select = rootPath + '/Plugins/Registration/getListAPP010_FOR_REFERRER.json';

    var objectDefault = {};
    var inputToMergeNew = ['#slMemberGroupCodeNew', '#txtApplyDateNew', '#txtCitizenIdNew', '#slMilitaryIdNew', '#slRankIdNew', '#slTitleIdNew', '#txtNameNew', '#txtSurnameNew', '#slGenderNew', '#txtBirthDateNew', '#slMemberTypeCodeNew', '#slPaymentTypeNew', '#hidReferrerIdNew', '#slReferrerRelationshipCodeNew', '#slMarryStatusCodeNew', '#txtWifehusbandFullnameNew', '#txtRemarkNew', '#slPaymentTypeCodeNew', '#txtPaymentRemarkNew', '#txtBankAccNameNew', '#slBankCodeNew', '#slBankBranchIdNew', '#txtBankAccNoNew', '#slAccTypeIdNew', '#txtPermanentAddressNew', '#txtPermanentMooNew', '#txtPermanentRoadNew', '#txtPermanentSoiNew', '#txtPermanentSubdistrictNew', '#txtPermanentDistrictNew', '#slPermanentProvinceCodeNew', '#txtPermanentZipcodeNew', '#txtPermanentTelNew', '#txtPermanentFaxNew', '#txtPermanentMobileNew', '#txtAddressNew', '#txtMooNew', '#txtRoadNew', '#txtSoiNew', '#txtSubdistrictNew', '#txtDistrictNew', '#slProvinceCodeNew', '#txtZipcodeNew', '#txtTelNew', '#txtFaxNew', '#txtMobileNew', 'input:radio[name=rdAddressPrimaryNew]:checked'];
    var inputToChangeNew = ['memberGroupCode', 'applyDate', 'citizenId', 'militaryId', 'rankId', 'titleId', 'name', 'surname', 'gender', 'birthDate', 'memberTypeCode', 'paymentType', 'referrerId', 'referrerRelationshipCode', 'marryStatusCode', 'wifehusbandFullname', 'remark', 'paymentTypeCode', 'paymentRemark', 'bankAccName', 'bankCode', 'bankBranchId', 'bankAccNo', 'accTypeId', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentProvinceCode', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'mobile', 'addressPrimary'];

    var inputToMergeMemberBeneficiaryNew = ['#txtCitizenIdMemberBeneficiaryNew', '#slRankIdMemberBeneficiaryNew', '#slTitleIdMemberBeneficiaryNew', '#txtNameMemberBeneficiaryNew', '#txtSurnameMemberBeneficiaryNew', '#slMemberRelationshipCodeMemberBeneficiaryNew', '#txtPermanentAddressNew', '#txtPermanentMooMemberBeneficiaryNew', '#txtPermanentRoadMemberBeneficiaryNew', '#txtPermanentSoiMemberBeneficiaryNew', '#txtPermanentSubdistrictMemberBeneficiaryNew', '#txtPermanentDistrictMemberBeneficiaryNew', '#txtPermanentZipcodeMemberBeneficiaryNew', '#txtPermanentTelMemberBeneficiaryNew', '#txtPermanentFaxMemberBeneficiaryNew', '#txtPermanentMobileMemberBeneficiaryNew', '#txtAddressMemberBeneficiaryNew', '#txtMooMemberBeneficiaryNew', '#txtRoadMemberBeneficiaryNew', '#txtSoiMemberBeneficiaryNew', '#txtSubdistrictMemberBeneficiaryNew', '#txtDistrictMemberBeneficiaryNew', '#txtZipcodeMemberBeneficiaryNew', '#txtTelMemberBeneficiaryNew', '#txtFaxMemberBeneficiaryNew', '#txtMobileMemberBeneficiaryNew', '#slPermanentProvinceCodeMemberBeneficiaryNew', '#slProvinceCodeMemberBeneficiaryNew'];
    var inputToChangeMemberBeneficiaryNew = ['citizenId', 'rankId', 'titleId', 'name', 'surname', 'memberRelationshipCode', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'zipcode', 'tel', 'fax', 'mobile', 'permanentProvinceCode', 'provinceCode'];

    var inputToMergeMemberBeneficiaryNewForEdit = ['#hidBeneficiaryIdMemberBeneficiaryNewForEdit', '#txtCitizenIdMemberBeneficiaryNewForEdit', '#slRankIdMemberBeneficiaryNewForEdit', '#slTitleIdMemberBeneficiaryNewForEdit', '#txtNameMemberBeneficiaryNewForEdit', '#txtSurnameMemberBeneficiaryNewForEdit', '#slMemberRelationshipCodeMemberBeneficiaryNewForEdit', '#txtPermanentAddressNewForEdit', '#txtPermanentMooMemberBeneficiaryNewForEdit', '#txtPermanentRoadMemberBeneficiaryNewForEdit', '#txtPermanentSoiMemberBeneficiaryNewForEdit', '#txtPermanentSubdistrictMemberBeneficiaryNewForEdit', '#txtPermanentDistrictMemberBeneficiaryNewForEdit', '#txtPermanentZipcodeMemberBeneficiaryNewForEdit', '#txtPermanentTelMemberBeneficiaryNewForEdit', '#txtPermanentFaxMemberBeneficiaryNewForEdit', '#txtPermanentMobileMemberBeneficiaryNewForEdit', '#txtAddressMemberBeneficiaryNewForEdit', '#txtMooMemberBeneficiaryNewForEdit', '#txtRoadMemberBeneficiaryNewForEdit', '#txtSoiMemberBeneficiaryNewForEdit', '#txtSubdistrictMemberBeneficiaryNewForEdit', '#txtDistrictMemberBeneficiaryNewForEdit', '#txtZipcodeMemberBeneficiaryNewForEdit', '#txtTelMemberBeneficiaryNewForEdit', '#txtFaxMemberBeneficiaryNewForEdit', '#txtMobileMemberBeneficiaryNewForEdit', '#slPermanentProvinceCodeMemberBeneficiaryNewForEdit', '#slProvinceCodeMemberBeneficiaryNewForEdit'];
    var inputToChangeMemberBeneficiaryNewForEdit = ['beneficiaryId', 'citizenId', 'rankId', 'titleId', 'name', 'surname', 'memberRelationshipCode', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'zipcode', 'tel', 'fax', 'mobile', 'permanentProvinceCode', 'provinceCode'];

    var objIdKeyEdit = 'beneficiaryId';
    var listRank = {};
    var listTitle = {};
    var listMilitaryDepartment = {};
    var listBank = {};
    var listBankBranch = {};
    var listBankAccountType = {};
    var listProvince = {};
    var myStringListAPP010 = {};
    var listAPP010 = [];
    var urlActionListAPP010 = rootPath + '/Plugins/Registration/APP010.htm';
    var responseId = '#main-page-content-loading';

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP010_2_New.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP010_2_New_Select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP010_2_New.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            บันทึกผู้สมัครเป็นสมาชิก
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <form class="form-horizontal" name="frmNew" id="frmNew">
            <div id="ListView" class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <div id="frmCriterionSearch" class="form-horizontal">                         
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2">
                                    <label class="control-label no-padding-right" for="lbMemberGroupCodeNew">ประเภทสมาชิก <span style="color:red;">*</span></label>
                                </div>
                                <div class="col-md-3">
                                    <select name="slMemberGroupCodeNew" id="slMemberGroupCodeNew" class="form-control select2">
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
                                    <label class="control-label no-padding-right" for="lbCitizenIdNew">เลขประจำตัวประชาชน <span style="color:red;">*</span></label>
                                </div>
                                <div class="col-md-3">
                                    <input type="text" maxlength="13" id="txtCitizenIdNew" name="txtCitizenIdNew" class="form-control">
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
                                                        <label for="lbApplyDateNew" class="control-label no-padding-left">วันที่สมัคร<span style="color:red;">*</span> </label>
                                                    </div>                                                    
                                                    <div class="col-md-3">
                                                        <div class="input-group input-group-sm">
                                                            <input type="text" id="txtApplyDateNew" name="txtApplyDateNew" class="form-control"/>
                                                            <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbMemberTypeCodeNew" class="control-label no-padding-right">ประเภทการสมัคร<span style="color:red;">*</span></label>
                                                    </div>

                                                    <div class="col-md-3">
                                                        <select id="slMemberTypeCodeNew" name="slMemberTypeCodeNew" class="form-control select2">
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
                                                        <label for="lbRankIdNew" class="control-label no-padding-right">ยศ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slRankIdNew" name="slRankIdNew" class="form-control select2">				  
                                                        </select>					
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbTitleIdNew" class="control-label no-padding-right">คำนำหน้า</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slTitleIdNew" name="slTitleIdNew" class="form-control select2">				  
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbNameNew" class="control-label no-padding-right">ชื่อ<span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtNameNew" name="txtNameNew" type="text" class="form-control"/>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label class="control-label no-padding-right" for="lbSurnameNew">สกุล<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSurnameNew" name="txtSurnameNew" type="text" class="form-control"/>
                                                    </div>
                                                </div>		  

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBirthDateNew" class="control-label no-padding-right">วันเดือนปีเกิด<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">            
                                                        <div class="input-group input-group-sm">
                                                            <input id="txtBirthDateNew" name="txtBirthDateNew" type="text" class="form-control"/>
                                                            <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i> </span> </div>
                                                    </div>
                                                    <div class="col-md-1">
                                                        <label for="lbAgeNew" class="control-label no-padding-right">อายุ</label>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <div class="col-lg-12">
                                                            <div class="col-md-6">
                                                                <input id="txtAgeNew" name="txtAgeNew" type="text" class="form-control" />
                                                            </div>
                                                            <div class="col-md-3">
                                                                <label for="lbAgeYearNew" class="control-label no-padding-right">ปี</label>
                                                            </div>
                                                            <div class="col-md-3">
                                                                <label class="control-label no-padding-right">เพศ<span style="color:red;">*</span></label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <select id="slGenderNew" name="slGenderNew" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="M">ชาย</option>
                                                            <option value="F">หญิง</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMilitaryIdNew" class="control-label no-padding-right">หน่วยต้นสังกัด </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slMilitaryIdNew" name="slMilitaryIdNew" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPaymentTypeNew" class="control-label no-padding-right">ประเภทการชำระเงิน <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPaymentTypeNew" name="slPaymentTypeNew" class="form-control select2">
                                                            <option value="">-เลือก-</option>
                                                            <option value="10">ชำระผ่านหน่วยต้นสังกัด</option>
                                                            <option value="20">ชำระด้วยตนเอง</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbReferrerIdNew" class="control-label no-padding-right">รหัสผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-xs-12 col-sm-3">
                                                        <div class="input-group">
                                                            <input id="hidReferrerIdNew" name="hidReferrerIdNew" type="hidden" value="0">
                                                            <input id="txtReferrerCodeNew" name="txtReferrerCodeNew" type="text" class="form-control search-query">

                                                            <span class="input-group-btn"><a href="#modal-form" role="button" class="blue" data-toggle="modal">
                                                                    <button id="btnReferrerNew" name="btnReferrerNew" class="btn btn-purple btn-sm" type="button" > เลือกสมาชิก <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
                                                                </a> </span> </div>
                                                    </div>
                                                </div>

                                                <div class="form-group">                                                   
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbReferrerFullnameNew" class="control-label no-padding-right">ชื่อผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtReferrerFullnameNew" name="txtReferrerFullnameNew" type="text"  class="form-control" readonly="readonly">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-3">
                                                        <label for="lbReferrerRelationshipCodeNew" class="control-label no-padding-right">ความเกี่ยวพันกับผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slReferrerRelationshipCodeNew" name="slReferrerRelationshipCodeNew" class="form-control select2">
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
                                                        <select id="slMarryStatusCodeNew" name="slMarryStatusCodeNew" class="form-control select2">
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
                                                        <label for="lbWifehusbandFullnameNew" class="control-label no-padding-right">ชื่อคู่สมรส </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtWifehusbandFullnameNew" name="txtWifehusbandFullnameNew" type="text" class="form-control" >
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbRemarkNew" class="control-label no-padding-right" > หมายเหตุ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <textarea id="txtRemarkNew" name="txtRemarkNew" class="form-control limited"  maxlength="50" style="width: 400px"></textarea>
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
                                                        <label for="lbPermanentAddressNew" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                                                    </div>                                                    
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentAddressNew" name="txtPermanentAddressNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentMooNew" class="control-label no-padding-right">หมู่ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentMooNew" name="txtPermanentMooNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentRoadNew" class="control-label no-padding-right">ถนน </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentRoadNew" name="txtPermanentRoadNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentSoiNew" class="control-label no-padding-right">ซอย </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentSoiNew" name="txtPermanentSoiNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentSubdistrictNew" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentSubdistrictNew" name="txtPermanentSubdistrictNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentDistrictNew" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentDistrictNew" name="txtPermanentDistrictNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentProvinceCodeNew" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPermanentProvinceCodeNew" name="slPermanentProvinceCodeNew" class="form-control select2">
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentZipcodeNew" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentZipcodeNew" name="txtPermanentZipcodeNew" class="form-control" type="text">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentTelNew" class="control-label no-padding-right">โทรศัพท์ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentTelNew" name="txtPermanentTelNew" type="text" class="form-control">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentFaxNew" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentFaxNew" name="txtPermanentFaxNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentMobileNew" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentMobileNew" name="txtPermanentMobileNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <br/>
                                                <div class="page-header"> </div>
                                                <br/>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"></div>
                                                    <div class="col-md-3">
                                                        <label for="lbAsRegisteredAddressNew" class="control-label no-padding-right"><strong>ที่อยู่ที่ติดต่อได้</strong></label>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2"></div>
                                                    <div class="col-md-3">
                                                        <input id="chkAsRegisteredAddressNew" name="chkAsRegisteredAddressNew" type="checkbox" value="E"> เหมือนที่อยู่ตามทะเบียนบ้าน</div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbAddressNew" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtAddressNew" name="txtAddressNew" type="text" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMooNew" class="control-label no-padding-right">หมู่ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtMooNew" name="txtMooNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbRoadNew" class="control-label no-padding-right">ถนน </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtRoadNew" name="txtRoadNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbSoiNew" class="control-label no-padding-right">ซอย </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSoiNew" name="txtSoiNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbSubdistrictNew" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSubdistrictNew" name="txtSubdistrictNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbDistrictNew" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtDistrictNew" name="txtDistrictNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbProvinceCodeNew" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slProvinceCodeNew" name="slProvinceCodeNew" class="form-control select2">
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbZipcodeNew" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtZipcodeNew" name="txtZipcodeNew" type="text" class="control-label">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbTelNew" class="control-label no-padding-right">โทรศัพท์ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtTelNew" name="txtTelNew" type="text" class="form-control">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbFaxNew" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtFaxNew" name="txtFaxNew" type="text" class="control-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMobileNew" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtMobileNew" name="txtMobileNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <br/>
                                                <div class="form-group">
                                                    <div class="col-md-3">
                                                        <label class="control-label no-padding-right" for="lbAddressPrimaryNew"><strong>ที่อยู่ในการจัดส่งเอกสาร</strong></label>
                                                    </div>
                                                    <div class="col-md-8" style="padding-top: 8px;">
                                                        <div class="col-md-4 no-padding-left">
                                                            <input type="radio" value="1" name="rdAddressPrimaryNew" class="ace" checked><span class="lbl"> ที่อยู่หน่วยต้นสังกัด</span>  
                                                        </div>
                                                        <div class="col-md-4 no-padding-left">
                                                            <input type="radio" value="2" name="rdAddressPrimaryNew" class="ace"><span class="lbl"> ที่อยู่ปัจจุบัน</span>
                                                        </div>
                                                        <div class="col-md-4 no-padding-left">
                                                            <input type="radio" value="3" name="rdAddressPrimaryNew" class="ace"><span class="lbl"> ที่อยู่ตามทะเบียนบ้าน</span>								  
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
                                                        <button id="btnAddMemberBeneficiaryNew" name="btnAddMemberBeneficiaryNew" type="button" class="btn btn-sm btn-primary"><i class="ace-icon fa glyphicon-plus bigger-110"></i>&nbsp;เพิ่มผู้รับเงินสงเคราห์</button>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="jqGridContainer" class="row">
                                                <div class="col-xs-12">
                                                    <table id="gridData_APP010_2_New_Grid_List"></table>
                                                    <div id="gridPager_APP010_2_New_jqGrid_List"></div>
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
                                                        <label for="lbPaymentTypeCodeNew" class="control-label no-padding-right">ประเภทการชำระเงิน <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPaymentTypeCodeNew" name="slPaymentTypeCodeNew" class="form-control select2">
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
                                                        <label for="lbPaymentRemarkNew" class="control-label no-padding-right">หมายเหตุ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <textarea id="txtPaymentRemarkNew" name="txtPaymentRemarkNew" class="form-control limited" maxlength="50" style="width: 400px"></textarea>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankAccNameNew" class="control-label no-padding-right">ชื่อบัญชี </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtBankAccNameNew" name="txtBankAccNameNew" type="text" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-3">
                                                        <label for="lbBankCodeNew" class="control-label no-padding-right">บัญชีเงินฝากของธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankCodeNew" name="slBankCodeNew" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankBranchIdNew" class="control-label no-padding-right">สาขาธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankBranchIdNew" name="slBankBranchIdNew" class="form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankAccNoNew" class="control-label no-padding-right">เลขบัญชี </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbAccTypeIdNew" class="control-label no-padding-right">ประเภทบัญชี </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slAccTypeIdNew" name="slAccTypeIdNew" class="form-control select2">
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
                        <button type="button" id="btnSaveNew" name="btnSaveNew" class="btn btn-info"><i class="ace-icon fa fa-floppy-o bigger-110"></i> บันทึก </button>
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

        <div id="dialogFormReferrerNew" class="hide">
            <div class="bs-component">
                <div class="row" >
                    <form role="form" class="form-horizontal">
                        <div class="form-group" style="margin-bottom:5px">
                          <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> เลขทะเบียนสมาชิก </label>
                          <div class="col-sm-9">
                              <input type="text" id="memberCodeForNew" name="memberCodeForNew" >
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;เลขประจำตัวประชาชน
                            <input type="text" id="citizenIdForNew" name="citizenIdForNew" >
                          </div>
                        </div>
                        <div class="form-group" style="margin-bottom:5px">
                          <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> ชื่อ </label>
                          <div class="col-sm-9">
                            <input type="text" id="memberNameForNew" name="memberNameForNew" >
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;สกุล
                            <input type="text" id="memberSurnameForNew" name="memberSurnameForNew" >
                          </div>
                        </div>
                        <div class="form-group">
                          <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> หน่วยต้นสังกัด </label>
                          <div class="col-sm-6">
                            <select id="militaryIdNew" name="militaryIdNew" class="col-xs-10 col-sm-4" id="form-field-3"></select>
<!--                            <label for="form-field-2" class="col-sm-3 control-label no-padding-right">สถานะ &nbsp;&nbsp;</label>
                            <select class="col-xs-10 col-sm-4" id="statusNew" name="statusNew">
                              <option>ทั้งหมด</option>
                              <option>สมาชิกปกติ</option>
                              <option>สมาชิกถอนสภาพชั่วคราว</option>
                              <option>สมาชิกถอนสภาพถาวร</option>
                            </select>-->
                          </div>
                        </div>
                        <div class="col-md-offset-3 col-md-9">
                          <button type="button" id="btnNewSearch" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>ค้นหา</button>
                          <button type="button" id="btnNewReset"  class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ล้าง</button>
                        </div>
                    </form>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP010_2_New_Select_jqGrid_List"></table>
                        <div id="gridPager_APP010_2_New_Select_jqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>

        <div id="dialogFormMemberBeneficiaryNew" class="hide">
            <div class="col-xs-12">
                <form class="form-horizontal" name="frmMemberBeneficiaryNew" id="frmMemberBeneficiaryNew">
                    <div class="form-horizontal">
                        <!-- #section:elements.form -->
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbCitizenIdMemberBeneficiaryNew" class="control-label no-padding-right">เลขประจำตัวประชาชน <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtCitizenIdMemberBeneficiaryNew" name="txtCitizenIdMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbRankIdMemberBeneficiaryNew" class="control-label no-padding-right">ยศ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slRankIdMemberBeneficiaryNew" name="slRankIdMemberBeneficiaryNew" class="form-control select2">				  
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbTitleIdMemberBeneficiaryNew" class="control-label no-padding-right">คำนำหน้า <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slTitleIdMemberBeneficiaryNew" name="slTitleIdMemberBeneficiaryNew" class="form-control select2">				  
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbNameMemberBeneficiaryNew" class="control-label no-padding-right">ชื่อผู้รับผลประโยชน์ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtNameMemberBeneficiaryNew" name="txtNameMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbSurnameMemberBeneficiaryNew" class="control-label no-padding-right">สกุล <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtSurnameMemberBeneficiaryNew" name="txtSurnameMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMemberRelationshipCodeMemberBeneficiaryNew" class="control-label no-padding-right">ความเกี่ยวพันกับสมาชิก <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slMemberRelationshipCodeMemberBeneficiaryNew" name="slMemberRelationshipCodeMemberBeneficiaryNew" class="form-control select2">				  
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
                                <label class="control-label no-padding-right" for="lbRegisteredAddressMemberBeneficiaryNew"><strong>ที่อยู่ตามทะเบียนบ้าน</strong></label>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentAddressMemberBeneficiaryNew" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtPermanentAddressNew" name="txtPermanentAddressMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMooMemberBeneficiaryNew" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMooMemberBeneficiaryNew" name="txtPermanentMooMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentRoadMemberBeneficiaryNew" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentRoadMemberBeneficiaryNew" name="txtPermanentRoadMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSoiMemberBeneficiaryNew" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSoiMemberBeneficiaryNew" name="txtPermanentSoiMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSubdistrictMemberBeneficiaryNew" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSubdistrictMemberBeneficiaryNew" name="txtPermanentSubdistrictMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentDistrictMemberBeneficiaryNew" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentDistrictMemberBeneficiaryNew" name="txtPermanentDistrictMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentProvinceCodeMemberBeneficiaryNew" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slPermanentProvinceCodeMemberBeneficiaryNew" name="slPermanentProvinceCodeMemberBeneficiaryNew" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentZipcodeMemberBeneficiaryNew" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentZipcodeMemberBeneficiaryNew" name="txtPermanentZipcodeMemberBeneficiaryNew" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentTelMemberBeneficiaryNew" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentTelMemberBeneficiaryNew" name="txtPermanentTelMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentFaxMemberBeneficiaryNew" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentFaxMemberBeneficiaryNew" name="txtPermanentFaxMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMobileMemberBeneficiaryNew" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMobileMemberBeneficiaryNew" name="txtPermanentMobileMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <br/>
                        <div class="page-header"> </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-3">
                                <label for="lbAsRegisteredAddressMemberBeneficiaryNew" class="control-label no-padding-right"><strong>ที่อยู่ที่ติดต่อได้</strong></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-4">
                                <input id="chkAsRegisteredAddressMemberBeneficiaryNew" name="chkAsRegisteredAddressMemberBeneficiaryNew" type="checkbox" value="E"> เหมือนที่อยู่ตามทะเบียนบ้าน</div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbAddressMemberBeneficiaryNew" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtAddressMemberBeneficiaryNew" name="txtAddressMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMooMemberBeneficiaryNew" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMooMemberBeneficiaryNew" name="txtMooMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbRoadMemberBeneficiaryNew" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtRoadMemberBeneficiaryNew" name="txtRoadMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSoiMemberBeneficiaryNew" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSoiMemberBeneficiaryNew" name="txtSoiMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSubdistrictMemberBeneficiaryNew" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSubdistrictMemberBeneficiaryNew" name="txtSubdistrictMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbDistrictMemberBeneficiaryNew" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtDistrictMemberBeneficiaryNew" name="txtDistrictMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbProvinceCodeMemberBeneficiaryNew" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slProvinceCodeMemberBeneficiaryNew" name="slProvinceCodeMemberBeneficiaryNew" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbZipcodeMemberBeneficiaryNew" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtZipcodeMemberBeneficiaryNew" name="txtZipcodeMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbTelMemberBeneficiaryNew" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtTelMemberBeneficiaryNew" name="txtTelMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbFaxMemberBeneficiaryNew" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtFaxMemberBeneficiaryNew" name="txtFaxMemberBeneficiaryNew" type="text" class="control-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMobileMemberBeneficiaryNew" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMobileMemberBeneficiaryNew" name="txtMobileMemberBeneficiaryNew" type="text" class="form-control">
                            </div>
                        </div>                    
                        <!-- /section:elements.form -->
                    </div>
                </form>
            </div>
        </div>

        <div id="dialogFormMemberBeneficiaryNewForEdit" class="hide">
            <div class="col-xs-12">
                <form class="form-horizontal" name="frmMemberBeneficiaryNewForEdit" id="frmMemberBeneficiaryNewForEdit">
                    <div class="form-horizontal">
                        <!-- #section:elements.form -->
                        <br/>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbCitizenIdMemberBeneficiaryNewForEdit" class="control-label no-padding-right">เลขประจำตัวประชาชน <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3"><input id="hidBeneficiaryIdMemberBeneficiaryNewForEdit" name="hidBeneficiaryIdMemberBeneficiaryNewForEdit" type="hidden">
                                <input id="txtCitizenIdMemberBeneficiaryNewForEdit" name="txtCitizenIdMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbRankIdMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ยศ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slRankIdMemberBeneficiaryNewForEdit" name="slRankIdMemberBeneficiaryNewForEdit" class="form-control select2">				  
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbTitleIdMemberBeneficiaryNewForEdit" class="control-label no-padding-right">คำนำหน้า <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slTitleIdMemberBeneficiaryNewForEdit" name="slTitleIdMemberBeneficiaryNewForEdit" class="form-control select2">				  
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbNameMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ชื่อผู้รับผลประโยชน์ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtNameMemberBeneficiaryNewForEdit" name="txtNameMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbSurnameMemberBeneficiaryNewForEdit" class="control-label no-padding-right">สกุล <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtSurnameMemberBeneficiaryNewForEdit" name="txtSurnameMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMemberRelationshipCodeMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ความเกี่ยวพันกับสมาชิก <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <select id="slMemberRelationshipCodeMemberBeneficiaryNewForEdit" name="slMemberRelationshipCodeMemberBeneficiaryNewForEdit" class="form-control select2">				  
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
                                <label class="control-label no-padding-right" for="lbRegisteredAddressMemberBeneficiaryNewForEdit"><strong>ที่อยู่ตามทะเบียนบ้าน</strong></label>
                            </div>
                        </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentAddressMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>                                                    
                            <div class="col-md-3">
                                <input id="txtPermanentAddressNewForEdit" name="txtPermanentAddressMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMooMemberBeneficiaryNewForEdit" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMooMemberBeneficiaryNewForEdit" name="txtPermanentMooMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentRoadMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentRoadMemberBeneficiaryNewForEdit" name="txtPermanentRoadMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSoiMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSoiMemberBeneficiaryNewForEdit" name="txtPermanentSoiMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentSubdistrictMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentSubdistrictMemberBeneficiaryNewForEdit" name="txtPermanentSubdistrictMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentDistrictMemberBeneficiaryNewForEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentDistrictMemberBeneficiaryNewForEdit" name="txtPermanentDistrictMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentProvinceCodeMemberBeneficiaryNewForEdit" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slPermanentProvinceCodeMemberBeneficiaryNewForEdit" name="slPermanentProvinceCodeMemberBeneficiaryNewForEdit" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentZipcodeMemberBeneficiaryNewForEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentZipcodeMemberBeneficiaryNewForEdit" name="txtPermanentZipcodeMemberBeneficiaryNewForEdit" class="form-control" type="text">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentTelMemberBeneficiaryNewForEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentTelMemberBeneficiaryNewForEdit" name="txtPermanentTelMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbPermanentFaxMemberBeneficiaryNewForEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentFaxMemberBeneficiaryNewForEdit" name="txtPermanentFaxMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbPermanentMobileMemberBeneficiaryNewForEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtPermanentMobileMemberBeneficiaryNewForEdit" name="txtPermanentMobileMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <br/>
                        <div class="page-header"> </div>
                        <br/>
                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-3">
                                <label for="lbAsRegisteredAddressMemberBeneficiaryNewForEdit" class="control-label no-padding-right"><strong>ที่อยู่ที่ติดต่อได้</strong></label>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3"></div>
                            <div class="col-md-4">
                                <input id="chkAsRegisteredAddressMemberBeneficiaryNewForEdit" name="chkAsRegisteredAddressMemberBeneficiaryNewForEdit" type="checkbox" value="E"> เหมือนที่อยู่ตามทะเบียนบ้าน</div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbAddressMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ที่อยู่ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtAddressMemberBeneficiaryNewForEdit" name="txtAddressMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMooMemberBeneficiaryNewForEdit" class="control-label no-padding-right">หมู่ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMooMemberBeneficiaryNewForEdit" name="txtMooMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbRoadMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ถนน </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtRoadMemberBeneficiaryNewForEdit" name="txtRoadMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSoiMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ซอย </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSoiMemberBeneficiaryNewForEdit" name="txtSoiMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbSubdistrictMemberBeneficiaryNewForEdit" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtSubdistrictMemberBeneficiaryNewForEdit" name="txtSubdistrictMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbDistrictMemberBeneficiaryNewForEdit" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtDistrictMemberBeneficiaryNewForEdit" name="txtDistrictMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbProvinceCodeMemberBeneficiaryNewForEdit" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                            </div>
                            <div class="col-md-3">
                                <select id="slProvinceCodeMemberBeneficiaryNewForEdit" name="slProvinceCodeMemberBeneficiaryNewForEdit" class="form-control select2">
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label for="lbZipcodeMemberBeneficiaryNewForEdit" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtZipcodeMemberBeneficiaryNewForEdit" name="txtZipcodeMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbTelMemberBeneficiaryNewForEdit" class="control-label no-padding-right">โทรศัพท์ </label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtTelMemberBeneficiaryNewForEdit" name="txtTelMemberBeneficiaryNewForEdit" type="text" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <label for="lbFaxMemberBeneficiaryNewForEdit" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtFaxMemberBeneficiaryNewForEdit" name="txtFaxMemberBeneficiaryNewForEdit" type="text" class="control-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="lbMobileMemberBeneficiaryNewForEdit" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                            </div>
                            <div class="col-md-3">
                                <input id="txtMobileMemberBeneficiaryNewForEdit" name="txtMobileMemberBeneficiaryNewForEdit" type="text" class="form-control">
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
