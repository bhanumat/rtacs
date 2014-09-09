<%-- 
    Document   : MAS040
    Created on : Aug 2, 2014, 11:27:14 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/MasterData/getListMAS010.json';
    var urlDelete = rootPath + '/Plugins/MasterData/setDeleteMAS010.json';
    var urlNew = rootPath + '/Plugins/MasterData/setSaveNewMAS010.json';
    var urlEdit = rootPath + '/Plugins/MasterData/setSaveEditMAS010.json';
    var urlLoad = rootPath + '/Plugins/MasterData/getLoadMAS010.json';
    var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';
    var urlListJsonBankBranch = rootPath + '/Plugins/MasterData/getListInJSONBankBranch.json';
    var urlListJsonBankAccountType = rootPath + '/Plugins/MasterData/getListInJSONBankAccountType.json';
    var urlListJsonProvince = rootPath + '/Plugins/MasterData/getListInJSONProvince.json';

    var objectDefault = {};
////////////////////////////////////////New////////////////////////////////////////////////////////////
    var inputToMergeNew = ['#txtMildeptIdNew', '#txtNameNew', '#txtFullnameNew', '#txtAddress1New', '#txtAddress2New', '#txtSubdistrictNew', '#txtDistrictNew', '#slProvinceCodeNew', '#txtZipCodeNew', '#txtTelephoneNew', '#txtFaxNew', '#slBankCodeNew', '#slBankBranchNew', '#txtBankAccountNameNew', '#txtBankAccountNoNew', '#slBankAccountTypeNew', 'input[id=chkStatusNew]:checked'];

    var inputToChangeNew = ['mildeptId', 'name', 'fullname', 'address1', 'address2', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'bankCode', 'branchId', 'bankAccName', 'bankAccNo', 'bankAccTypeId', 'status'];
////////////////////////////////////////Edit////////////////////////////////////////////////////////////
    var inputToMergeEdit = ['#hidMilitaryIdEdit', '#txtMildeptIdEdit', '#txtNameEdit', '#txtFullnameEdit', '#txtAddress1Edit', '#txtAddress2Edit', '#txtSubdistrictEdit', '#txtDistrictEdit', '#slProvinceCodeEdit', '#txtZipCodeEdit', '#txtTelephoneEdit', '#txtFaxEdit', '#slBankCodeEdit', '#slBankBranchEdit', '#txtBankAccountNameEdit', '#txtBankAccountNoEdit', '#slBankAccountTypeEdit', 'input[id=chkStatusEdit]:checked'];

    var inputToChangeEdit = ['militaryId', 'mildeptId', 'name', 'fullname', 'address1', 'address2', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'bankCode', 'branchId', 'bankAccName', 'bankAccNo', 'bankAccTypeId', 'status'];

    var objIdKeyEdit = 'militaryId';

    var listBank = {};
    var listBankBranch = {};
    var listBankAccountType = {};
    var listProvince = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/MasterData/action.MAS010.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/MasterData/jqgrid.MAS010.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลพื้นฐาน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลหน่วยต้นสังกัด
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div id="ListView" class="row">
            <div class="col-lg-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">                          
                        <div class="form-group">
                            <label for="lbMildeptId" class="col-lg-4 control-label"> รหัสหน่วยต้นสังกัด : </label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtMildeptId" name="txtMildeptId" placeholder="Search">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbName" class="col-lg-4 control-label"> ชื่อหน่วยต้นสังกัด    : </label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Search">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatus" class="col-lg-4 control-label"> สถานะใช้งาน : </label>
                            <div class="col-lg-4">
                                <select class="col-xs-10 col-sm-4" id="slStatus" name="slStatus">
                                    <option value="%">ทั้งหมด</option>
                                    <option value="E">ใช้งาน</option>
                                    <option value="D">ไม่ใช้งาน</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-12 col-lg-offset-4">
                                <button type="button" id="btnSearch" name="btnSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>&nbsp;ค้นหา</button>
                                <button type="reset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้าง</button>
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;สร้างใหม่</button>
                        <button id="btnReload"  type="button" class="btn btn-sm btn-grey" style="font-size: 14px;"><i class="glyphicon glyphicon-repeat"></i>&nbsp;รีโหลด</button>
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_MilitaryDepartmentGrid_List"></table>
                        <div id="gridPager_MilitaryDepartmentGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>

        <div id="dialogFormNew" class="hide">
            <div class="bs-component">
                <form class="form-horizontal" name="frmNew" id="frmNew">
                    <fieldset>
                        <div class="form-group" style="height: 40px;">
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbMildeptIdNew"> รหัสหน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <input type="text" class="col-xs-10 col-sm-5" id="txtMildeptIdNew" name="txtMildeptIdNew">
                            </div>
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbNameNew"> หน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <input type="text"  class="col-xs-10" id="txtNameNew" name="txtNameNew">
                            </div>
                        </div>                        
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbFullnameNew"> ชื่อเต็มหน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <input type="text"  class="col-xs-10" id="txtFullnameNew" name="txtFullnameNew">
                            </div>
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbAddress1New"> ที่อยู่ 1</label>
                            <div class="col-sm-9">
                                <input type="text" id="txtAddress1New" name="txtAddress1New" class="col-xs-10">
                            </div>
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbAddress2New"> ที่อยู่ 2</label>
                            <div class="col-sm-9">
                                <input type="text" id="txtAddress2New" name="txtAddress2New" class="col-xs-10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label" for="lbSubdistrictNew"> ตำบล </label>
                            <div class="col-lg-2">
                                <input type="text" id="txtSubdistrictNew" name="txtSubdistrictNew">
                            </div>
                            <label for="lbDistrictNew" class="col-lg-3 control-label">อำเภอ</label>
                            <div></div>
                            <div class="col-lg-2">
                                <input type="text" id="txtDistrictNew" name="txtDistrictNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbProvinceCodeNew" class="col-sm-3 control-label no-padding-right">จังหวัด</label>
                            <div class="col-lg-2">
                                <select id="slProvinceCodeNew" name="slProvinceCodeNew">
                                </select>
                            </div>
                            <label for="lbPostalCodeNew" class="col-lg-3 control-label ">รหัสไปรษณีย์</label>
                            <div class="col-lg-2">
                                <input type="text"  class="form-control" id="txtZipCodeNew" name="txtZipCodeNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbTelephoneNew" class="col-lg-3 control-label">โทรศัพท์</label>
                            <div></div>
                            <div class="col-lg-3">
                                <input type="text"  class="form-control" id="txtTelephoneNew" name="txtTelephoneNew">
                            </div>
                            <label for="lbFaxNew" class="col-lg-2 control-label">โทรสาร</label>
                            <div></div>
                            <div class="col-lg-3">
                                <input type="text"  class="form-control" id="txtFaxNew" name="txtFax">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankCodeNew" class="col-lg-4 control-label">บัญชัเงินฝากธนาคาร</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slBankCodeNew" name="slBankCodeNew">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankAccountNameNew" class="col-lg-4 control-label">ชื่อบัญชี</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text" id="txtBankAccountNameNew" name="txtBankAccountNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankAccountNoNew" class="col-lg-4 control-label">เลขที่บัญชี</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text" id="txtBankAccountNoNew" name="txtBankAccountNoNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankBranchNew" class="col-lg-4 control-label">สาขาธนาคาร</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slBankBranchNew" name="slBankBranchNew">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankAccountTypeNew" class="col-lg-4 control-label">ประเภทบัญชี</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slBankAccountTypeNew" name="slBankAccountTypeNew">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusNew" class="col-lg-4 control-label">สถานะใช้งาน</label>
                            <div class="col-lg-5">
                                <input type="checkbox" id="chkStatusNew" name="chkStatusNew" value="Y">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>

        <div id="dialogFormEdit" class="hide">
            <div class="bs-component">
                <form class="form-horizontal" name="frmEdit" id="frmEdit">
                    <fieldset>
                        <div class="form-group" style="height: 40px;">
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbMildeptIdEdit"> รหัสหน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <input type="hidden" id="hidMilitaryIdEdit" name="hidMilitaryIdEdit">
                                <input type="text" class="col-xs-10 col-sm-5" id="txtMildeptIdEdit" name="txtMildeptIdEdit">
                            </div>
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbNameEdit"> หน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <input type="text"  class="col-xs-10" id="txtNameEdit" name="txtNameEdit">
                            </div>
                        </div>                        
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbFullnameEdit"> ชื่อเต็มหน่วยต้นสังกัด </label>
                            <div class="col-sm-9">
                                <input type="text"  class="col-xs-10" id="txtFullnameEdit" name="txtFullnameEdit">
                            </div>
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbAddress1Edit"> ที่อยู่ 1</label>
                            <div class="col-sm-9">
                                <input type="text" id="txtAddress1Edit" name="txtAddress1Edit" class="col-xs-10">
                            </div>
                        </div>
                        <div style="margin-bottom:5px" class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="lbAddress2Edit"> ที่อยู่ 2</label>
                            <div class="col-sm-9">
                                <input type="text" id="txtAddress2Edit" name="txtAddress2Edit" class="col-xs-10">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label" for="lbSubdistrictEdit"> ตำบล </label>
                            <div class="col-lg-2">
                                <input type="text" id="txtSubdistrictEdit" name="txtSubdistrictEdit">
                            </div>
                            <label for="lbDistrictEdit" class="col-lg-3 control-label">อำเภอ</label>
                            <div></div>
                            <div class="col-lg-2">
                                <input type="text" id="txtDistrictEdit" name="txtDistrictEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbProvinceCodeEdit" class="col-sm-3 control-label no-padding-right">จังหวัด</label>
                            <div class="col-lg-2">
                                <select id="slProvinceCodeEdit" name="slProvinceCodeEdit">
                                </select>
                            </div>
                            <label for="lbPostalCodeEdit" class="col-lg-3 control-label ">รหัสไปรษณีย์</label>
                            <div class="col-lg-2">
                                <input type="text"  class="form-control" id="txtZipCodeEdit" name="txtZipCodeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbTelephoneEdit" class="col-lg-3 control-label">โทรศัพท์</label>
                            <div></div>
                            <div class="col-lg-3">
                                <input type="text"  class="form-control" id="txtTelephoneEdit" name="txtTelephoneEdit">
                            </div>
                            <label for="lbFaxEdit" class="col-lg-2 control-label">โทรสาร</label>
                            <div></div>
                            <div class="col-lg-3">
                                <input type="text"  class="form-control" id="txtFaxEdit" name="txtFax">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankCodeEdit" class="col-lg-4 control-label">บัญชัเงินฝากธนาคาร</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slBankCodeEdit" name="slBankCodeEdit">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankAccountNameEdit" class="col-lg-4 control-label">ชื่อบัญชี</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text" id="txtBankAccountNameEdit" name="txtBankAccountNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankAccountNoEdit" class="col-lg-4 control-label">เลขที่บัญชี</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text" id="txtBankAccountNoEdit" name="txtBankAccountNoEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankBranchEdit" class="col-lg-4 control-label">สาขาธนาคาร</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slBankBranchEdit" name="slBankBranchEdit">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBankAccountTypeEdit" class="col-lg-4 control-label">ประเภทบัญชี</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slBankAccountTypeEdit" name="slBankAccountTypeEdit">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusEdit" class="col-lg-4 control-label">สถานะใช้งาน</label>
                            <div class="col-lg-5">
                                <input type="checkbox" id="chkStatusEdit" name="chkStatusEdit" value="Y">
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->