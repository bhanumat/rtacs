<%-- 
    Document   : APP010_2
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
    var urlListMAS010_2 = rootPath + '/Plugins/Registration/getListAPP010.json';

    var objectDefault = {};
    var inputToMergeNew = ['#slMemberGroupCodeNew', '#txtApplyDateNew', '#txtCitizenIdNew', '#slMilitaryIdNew', '#slRankIdNew', '#slTitleIdNew', '#txtNameNew', '#txtSurnameNew', '#slGenderNew', '#txtBirthDateNew', '#slMemberTypeCodeNew', '#slPaymentTypeNew', '#hidReferrerIdNew', '#slReferrerRelationshipCodeNew', '#slMarryStatusCodeNew', '#txtWifehusbandFullnameNew', '#txtRemarkNew', '#slPaymentTypeCodeNew', '#txtPaymentRemarkNew', '#txtBankAccNameNew', '#slBankCodeNew', '#slBankBranchIdNew', '#txtBankAccNoNew', '#slAccTypeIdNew', '#txtPermanentAddressNew', '#txtPermanentMooNew', '#txtPermanentRoadNew', '#txtPermanentSoiNew', '#txtPermanentSubdistrictNew', '#txtPermanentDistrictNew', '#slPermanentProvinceCodeNew', '#txtPermanentZipcodeNew', '#txtPermanentTelNew', '#txtPermanentFaxNew', '#txtPermanentMobileNew', '#txtAddressNew', '#txtMooNew', '#txtRoadNew', '#txtSoiNew', '#txtSubdistrictNew', '#txtDistrictNew', '#slProvinceCodeNew', '#txtZipcodeNew', '#txtTelNew', '#txtFaxNew', '#txtMobileNew', 'input:radio[name=rdAddressPrimaryNew]:checked'];
    var inputToChangeNew = ['memberGroupCode', 'applyDate', 'citizenId', 'militaryId', 'rankId', 'titleId', 'name', 'surname', 'gender', 'birthDate', 'memberTypeCode', 'paymentType', 'referrerId', 'referrerRelationshipCode', 'marryStatusCode', 'wifehusbandFullname', 'remark', 'paymentTypeCode', 'paymentRemark', 'bankAccName', 'bankCode', 'bankBranchId', 'bankAccNo', 'accTypeId', 'permanentAddress', 'permanentMoo', 'permanentRoad', 'permanentSoi', 'permanentSubdistrict', 'permanentDistrict', 'permanentProvinceCode', 'permanentZipcode', 'permanentTel', 'permanentFax', 'permanentMobile', 'address', 'moo', 'road', 'soi', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'mobile', 'addressPrimary'];

    var inputToMergeEdit = ['#txtBankCodeEdit', '#txtBankNameEdit', 'input[id=chkStatusEdit]:checked'];
    var inputToChangeEdit = ['bankCode', 'bankName', 'status'];

    var objIdKeyEdit = 'memberId';
    var listRank = {};
    var listTitle = {};
    var listMilitaryDepartment = {};
    var listBank = {};
    var listBankBranch = {};
    var listBankAccountType = {};
    var listProvince = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP010_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP010_2.js"></script>
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
                                    <select name="slMemberGroupCodeNew" id="slMemberGroupCodeNew" class="select2-container form-control select2">
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
                                <li> <a data-toggle="tab" href="#tab3">ผู้รับเงินสงเคราห์</a> </li>
                                <li> <a data-toggle="tab" href="#tabPayment">ประเภทการชำระเงิน</a> </li>
                            </ul>
                            <div class="tab-content">
                                <div id="tabMember">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <div class="form-horizontal">
                                                <!-- #section:elements.form -->
                                                                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankCodeNew" class="control-label no-padding-right">บัญชีเงินฝากของธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankCodeNew" name="slBankCodeNew" class="select2-container form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
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
                                                        <select id="slMemberTypeCodeNew" name="slMemberTypeCodeNew" class="select2-container form-control select2">
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
                                                        <select id="slRankIdNew" name="slRankIdNew" class="select2-container form-control select2">				  
                                                        </select>					
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbTitleIdNew" class="control-label no-padding-right">คำนำหน้า</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slTitleIdNew" name="slTitleIdNew" class="select2-container form-control select2">				  
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
                                                        <select id="slGenderNew" name="slGenderNew" class="select2-container form-control select2">
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
                                                        <select id="slMilitaryIdNew" name="slMilitaryIdNew" class="select2-container form-control select2">
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPaymentTypeNew" class="control-label no-padding-right">ประเภทการชำระเงิน <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPaymentTypeNew" name="slPaymentTypeNew" class="select2-container form-control select2">
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
                                                                    <button id="btnReferrer" name="btnReferrer" class="btn btn-purple btn-sm" type="button" > เลือกสมาชิก <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
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
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbReferrerRelationshipCodeNew" class="control-label no-padding-right">ความเกี่ยวพันกับผู้นำเข้า </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slReferrerRelationshipCodeNew" name="slReferrerRelationshipCodeNew" class="select2-container form-control select2">
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
                                                        <select id="slMarryStatusCodeNew" name="slMarryStatusCodeNew" class="select2-container form-control select2">
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
                                                        <input id="txtPermanentAddressNew" name="txtPermanentAddressNew" type="text" class="form-control" value="92/1">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentMooNew" class="control-label no-padding-right">หมู่ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentMooNew" name="txtPermanentMooNew" type="text" class="form-control" value="10">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentRoadNew" class="control-label no-padding-right">ถนน </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentRoadNew" name="txtPermanentRoadNew" type="text" class="form-control" value="พหลโยธิน">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentSoiNew" class="control-label no-padding-right">ซอย </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentSoiNew" name="txtPermanentSoiNew" type="text" class="form-control" value="พหลโยธิน">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentSubdistrictNew" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentSubdistrictNew" name="txtPermanentSubdistrictNew" type="text" class="form-control" value="สามเสนใน">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentDistrict" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentDistrictNew" name="txtPermanentDistrictNew" type="text" class="form-control" value="พญาไท">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentProvinceCodeNew" class="control-label no-padding-right">จังหวัด<span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slPermanentProvinceCodeNew" name="slPermanentProvinceCodeNew" class="select2-container form-control select2">
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentZipcodeNew" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentZipcodeNew" name="txtPermanentZipcodeNew" class="form-control" type="text" value="10400">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentTelNew" class="control-label no-padding-right">โทรศัพท์ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentTelNew" name="txtPermanentTelNew" type="text" class="form-control" value="0212345678">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentFaxNew" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentFaxNew" name="txtPermanentFaxNew" type="text" class="form-control" value="0211223344">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbPermanentMobileNew" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtPermanentMobileNew" name="txtPermanentMobileNew" type="text" class="form-control" value="0909628880">
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
                                                        <input id="txtAddressNew" name="txtAddressNew" type="text" class="form-control" value="92/1">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMooNew" class="control-label no-padding-right">หมู่ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtMooNew" name="txtMooNew" type="text" class="form-control" value="10">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbRoadNew" class="control-label no-padding-right">ถนน </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtRoadNew" name="txtRoadNew" type="text" class="form-control" value="พหลโยธิน">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbSoiNew" class="control-label no-padding-right">ซอย </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSoiNew" name="txtSoiNew" type="text" class="form-control" value="พหลโยธิน">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbSubdistrictNew" class="control-label no-padding-right">ตำบล/แขวง<span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtSubdistrictNew" name="txtSubdistrictNew" type="text" class="form-control" value="สามเสนใน">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbDistrictNew" class="control-label no-padding-right">อำเภอ/เขต <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtDistrictNew" name="txtDistrictNew" type="text" class="form-control" value="พญาไท">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbProvinceCodeNew" class="control-label no-padding-right">จังหวัด <span style="color:red;">*</span> </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slProvinceCodeNew" name="slProvinceCodeNew" class="select2-container form-control select2">
                                                        </select>
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbZipcodeNew" class="control-label no-padding-right">รหัสไปรษณีย์ <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtZipcodeNew" name="txtZipcodeNew" type="text" class="control-label" value="10400">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbTelNew" class="control-label no-padding-right">โทรศัพท์ </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtTelNew" name="txtTelNew" type="text" class="form-control" value="0212345678">
                                                    </div>
                                                    <div class="col-md-2">
                                                        <label for="lbFaxNew" class="control-label no-padding-right">โทรสาร <span style="color:red;">*</span></label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtFaxNew" name="txtFaxNew" type="text" class="control-label" value="0211223344">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbMobileNew" class="control-label no-padding-right">โทรศัพท์มือถือ</label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <input id="txtMobileNew" name="txtMobileNew" type="text" class="form-control" value="0909628880">
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

                                <div id="tab3">
                                    <a data-toggle="modal" class="blue" role="button" href="#modal-form3">
                                        <button class="btn btn-sm btn-primary" type="button" > <i class="ace-icon fa glyphicon-plus bigger-110"></i>เพิ่มผู้รับเงินสงเคราห์ </button>
                                    </a>
                                    <div class="row">
                                        <div class="col-xs-10"><a href="#modal-form" role="button" class="blue" data-toggle="modal"></a>
                                            <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th class="center">ลำดับที่ </th>
                                                        <th>เลขประจำตัวประชาชน</th>
                                                        <th>ยศ</th>
                                                        <th>คำนำหน้า </th>
                                                        <th> ชื่อ</th>
                                                        <th> สกุล</th>
                                                        <th> ความเกี่ยวพันกับสมาชิก</th>
                                                        <th> </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="center">1</td>
                                                        <td>1512233445566 </td>
                                                        <td>ส.ท.</td>
                                                        <td>นาย</td>
                                                        <td> บุญส่ง</td>
                                                        <td> กองเกิด</td>
                                                        <td> บิดา</td>
                                                        <td><div class="hidden-sm hidden-xs btn-group"><a href="#" role="button" class="blue" data-toggle="modal">
                                                                    <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                                                                </a> <a href="" role="button" class="blue" data-toggle="modal">
                                                                    <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                                                                </a></div>
                                                            <div class="hidden-md hidden-lg">
                                                                <div class="inline position-relative">
                                                                    <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto"><i class="ace-icon fa fa-cog icon-only bigger-110"></i></button>
                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                        <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"><span class="blue"><i class="ace-icon fa fa-search-plus bigger-120"></i></span></a></li>
                                                                        <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"><span class="green"><i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li>
                                                                        <li> <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"><span class="red"><i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li>
                                                                    </ul>
                                                                </div>
                                                            </div></td>
                                                    </tr>
                                                    <tr>
                                                        <td class="center">2</td>
                                                        <td>1512233445577 </td>
                                                        <td></td>
                                                        <td>นาง</td>
                                                        <td> บุญเลี้ยง</td>
                                                        <td> กองเกิด</td>
                                                        <td> มารดา</td>
                                                        <td><div class="hidden-sm hidden-xs btn-group"><a href="#" role="button" class="blue" data-toggle="modal">
                                                                    <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                                                                </a> <a href="" role="button" class="blue" data-toggle="modal">
                                                                    <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                                                                </a></div>
                                                            <div class="hidden-md hidden-lg">
                                                                <div class="inline position-relative">
                                                                    <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown" data-position="auto"><i class="ace-icon fa fa-cog icon-only bigger-110"></i></button>
                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                        <li> <a href="#" class="tooltip-info" data-rel="tooltip" title="View"><span class="blue"><i class="ace-icon fa fa-search-plus bigger-120"></i></span></a></li>
                                                                        <li> <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit"><span class="green"><i class="ace-icon fa fa-pencil-square-o bigger-120"></i></span></a></li>
                                                                        <li> <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete"><span class="red"><i class="ace-icon fa fa-trash-o bigger-120"></i></span></a></li>
                                                                    </ul>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <!-- /.row -->
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
                                                        <select id="slPaymentTypeCodeNew" name="slPaymentTypeCodeNew" class="select2-container form-control select2">
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
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankCodeNew" class="control-label no-padding-right">บัญชีเงินฝากของธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankCodeNew" name="slBankCodeNew" class="select2-container form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-md-1"></div>
                                                    <div class="col-md-2">
                                                        <label for="lbBankBranchIdNew" class="control-label no-padding-right">สาขาธนาคาร </label>
                                                    </div>
                                                    <div class="col-md-3">
                                                        <select id="slBankBranchIdNew" name="slBankBranchIdNew" class="select2-container form-control select2">
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
                                                        <select id="slAccTypeIdNew" name="slAccTypeIdNew" class="select2-container form-control select2">
                                                        </select>
                                                    </div>
                                                </div>
                                                <!-- /section:elements.form -->
                                            </div>
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
            <!-- /.col -->
        </form>

        <div id="dialogFormReferrerNew" class="hide">
            <div class="bs-component">
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbMemberRegistrationReferrerNew" class="control-label no-padding-right">เลขทะเบียนสมาชิก</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbIdentificationNumberReferrerNew" class="control-label no-padding-right">เลขประจำตัวประชาชน</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbNameReferrerNew" class="control-label no-padding-right">ชื่อ</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbCurrencyReferrerNew" class="control-label no-padding-right">สกุล</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-2">
                        <label for="lbGovernmentAgencyReferrerNew" class="control-label no-padding-right">หน่วยต้นสังกัด</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                    <div class="col-md-2">
                        <label for="lbStatusReferrerNew" class="control-label no-padding-right">สถานะ</label>
                    </div>
                    <div class="col-md-3">
                        <input id="txtBankAccNoNew" name="txtBankAccNoNew" type="text" class="form-control" maxlength="10" >
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_MAS010_2jqGrid_List"></table>
                        <div id="gridPager_MAS010_2jqGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
    </div><!-- /.row -->
</div>
<!-- basic scripts -->

<!-- inline scripts related to this page -->
