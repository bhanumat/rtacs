<%-- 
    Document   : MAS040
    Created on : Aug 2, 2014, 11:27:14 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Registration/getListAPP010.json';
    var urlSaveNew = rootPath + '/Plugins/Registration/setSaveNewAPP040MemberOperation.json';
    //var urlDelete = rootPath + '/Plugins/Registration/setDeleteMAS010.json';
    // var urlNew = rootPath + '/Plugins/Registration/setSaveNewMAS010.json';
    //var urlEdit = rootPath + '/Plugins/Registration/setSaveEditMAS010.json';
    //var urlLoad = rootPath + '/Plugins/Registration/getLoadMAS010.json';
    //var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';
    //var urlListJsonBankBranch = rootPath + '/Plugins/MasterData/getListInJSONBankBranch.json';
    //var urlListJsonBankAccountType = rootPath + '/Plugins/MasterData/getListInJSONBankAccountType.json';
    //var urlListJsonProvince = rootPath + '/Plugins/MasterData/getListInJSONProvince.json';

    //var objectDefault = {};
////////////////////////////////////////New////////////////////////////////////////////////////////////
    // var inputToMergeNew = ['#txtMildeptIdNew', '#txtNameNew', '#txtFullnameNew', '#txtAddress1New', '#txtAddress2New', '#txtSubdistrictNew', '#txtDistrictNew', '#slProvinceCodeNew', '#txtZipCodeNew', '#txtTelephoneNew', '#txtFaxNew', '#slBankCodeNew', '#slBankBranchNew', '#txtBankAccountNameNew', '#txtBankAccountNoNew', '#slBankAccountTypeNew', 'input[id=chkStatusNew]:checked'];

    //var inputToChangeNew = ['mildeptId', 'name', 'fullname', 'address1', 'address2', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'bankCode', 'branchId', 'bankAccName', 'bankAccNo', 'bankAccTypeId', 'status'];
////////////////////////////////////////Edit////////////////////////////////////////////////////////////
    // var inputToMergeEdit = ['#hidMilitaryIdEdit', '#txtMildeptIdEdit', '#txtNameEdit', '#txtFullnameEdit', '#txtAddress1Edit', '#txtAddress2Edit', '#txtSubdistrictEdit', '#txtDistrictEdit', '#slProvinceCodeEdit', '#txtZipCodeEdit', '#txtTelephoneEdit', '#txtFaxEdit', '#slBankCodeEdit', '#slBankBranchEdit', '#txtBankAccountNameEdit', '#txtBankAccountNoEdit', '#slBankAccountTypeEdit', 'input[id=chkStatusEdit]:checked'];

    //var inputToChangeEdit = ['militaryId', 'mildeptId', 'name', 'fullname', 'address1', 'address2', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'bankCode', 'branchId', 'bankAccName', 'bankAccNo', 'bankAccTypeId', 'status'];

    // var objIdKeyEdit = 'militaryId';

    // var listBank = {};
    //var listBankBranch = {};
    //var listBankAccountType = {};
    //var listProvince = {};
    var listAPP040 = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP040_2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP040_2.js"></script>
<div class="page-header">
    <h1>
        กำหนดเลขทะเบียนสมาชิก  
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            บันทึกกำหนดเลขทะเบียนสมาชิก
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
                            <div class="col-lg-1">

                            </div>
                            <label for="lbMildeptId" class="col-lg-3 control-label">วันที่ขอถอนชื่อ ตั้งแต่ : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtMildeptId" name="txtMildeptId" placeholder="Search">
                            </div>
                            <label for="lbName" class="col-lg-2 control-label"> ถึง : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Search">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbName" class="col-lg-4 control-label"> เลขที่บัตรประชาชน   : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Search">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-1">

                            </div>
                            <label for="lbMildeptId" class="col-lg-3 control-label">ชื่อ : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtMildeptId" name="txtMildeptId" placeholder="Search">
                            </div>
                            <label for="lbName" class="col-lg-2 control-label"> นามสกุล : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Search">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-1">

                            </div>
                            <label for="lbMildeptId" class="col-lg-3 control-label">หน่วยต้นสังกัด : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtMildeptId" name="txtMildeptId" placeholder="Search">
                            </div>
                            <label for="lbName" class="col-lg-2 control-label"> ประเภทการสมัคร : </label>
                            <div class="col-lg-2">
                                <input type="text" class="form-control" id="txtName" name="txtName" placeholder="Search">
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
                    <label for="lbMildeptId" align="right">เลือกสมาชิกใหม่&nbsp;&nbsp;</label>
                    <input type="text" id="txtRegisterMemberCode" name="txtRegisterMemberCode" placeholder="Search">
                    <button type="button" id="btnRegisterNo" name="btnSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>กำหนดเลขทะเบียน</button>
                    <button type="reset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>ยกเลิก</button>
                    <button type="button" id="btnSave" name="btnSave" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>บันทึก</button>
                    <!--<div class="col-lg-12 col-lg-offset-0" align="left">
                        <label for="lbMildeptId" class="col-lg-2 control-label" align="right">เลขทะเบียนเริ่มต้น : </label>
                        <input type="text" class="col-lg-2" id="txtRegisterMemberCode" name="txtRegisterMemberCode" placeholder="Search">
                        <div align="left" class="col-lg-1"></div>
                        <button type="button" id="btnRegisterNo" name="btnSearch" class="btn btn-sm btn-purple col-lg-2"><i class="ace-icon fa fa-search"></i>กำหนดเลขทะเบียน</button>
                        <div align="left" class="col-lg-1"></div>
                        <button type="reset" class="btn btn-sm btn-primary col-lg-1"><i class="ace-icon fa fa-retweet"></i>ยกเลิก</button>
                        <div align="left" class="col-lg-1"></div>
                        <button type="button" id="btnSave" name="btnSave" class="btn btn-sm btn-purple col-lg-1"><i class="ace-icon fa fa-search"></i>บันทึก</button>
                    </div>-->
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_MemberGrid_List"></table>
                        <div id="gridPager_MemberGrid_List"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->