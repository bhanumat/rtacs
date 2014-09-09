<%-- 
    Document   : MAS060
    Created on : Aug 3, 2014, 10:36:14 AM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/MasterData/getListMAS060.json';
    var urlDelete = rootPath + '/Plugins/MasterData/setDeleteMAS060.json';
    var urlNew = rootPath + '/Plugins/MasterData/setSaveNewMAS060.json';
    var urlEdit = rootPath + '/Plugins/MasterData/setSaveEditMAS060.json';
    var urlLoad = rootPath + '/Plugins/MasterData/getLoadMAS060.json';
    var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';
    var urlListJsonProvince = rootPath + '/Plugins/MasterData/getListInJSONProvince.json';

    var objectDefault = {};
    var inputToMergeNew = ['#slBankCodeNew', '#txtBranchCodeNew', '#txtBranchNameNew', '#txtBranchShortNew', '#txtAddressNew', '#txtSubdistrictNew', '#txtDistrictNew', '#slProvinceCodeNew', '#txtZipcodeNew', '#txtTelNew', '#txtFaxNew', 'input[id=chkStatusNew]:checked'];
    var inputToChangeNew = ['bankCode', 'branchCode', 'branchName', 'branchShort', 'address', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'status'];

    var inputToMergeEdit = ['#hidBranchIdEdit', '#slBankCodeEdit', '#txtBranchCodeEdit', '#txtBranchNameEdit', '#txtBranchShortEdit', '#txtAddressEdit', '#txtSubdistrictEdit', '#txtDistrictEdit', '#slProvinceCodeEdit', '#txtZipcodeEdit', '#txtTelEdit', '#txtFaxEdit', 'input[id=chkStatusEdit]:checked'];
    var inputToChangeEdit = ['branchId', 'bankCode', 'branchCode', 'branchName', 'branchShort', 'address', 'subdistrict', 'district', 'provinceCode', 'zipcode', 'tel', 'fax', 'status'];

    var objIdKeyEdit = 'branchId';
    
    var listBank = {};
    var listProvince = {};

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/MasterData/action.MAS060.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/MasterData/jqgrid.MAS060.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลพื้นฐาน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลสาขาธนาคาร
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
                            <label for="lbBranchCode" class="col-sm-3 control-label no-padding-right"> รหัสสาขาธนาคาร : </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchCodeSearch" name="txtBranchCode" placeholder="Search">
                            </div>
                            <br />
                            <br />
                            <label for="lbBranchName" class="col-sm-3 control-label no-padding-right"> ชื่อสาขาธนาคาร : </label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchNameSearch" name="txtBranchNameSearch" placeholder="Search">
                            </div>
                            <br />
                            <br />
                            <label class="col-sm-3 control-label no-padding-right" for="lbBankCodeSearch"> ธนาคาร : </label>
                            <div class="col-sm-9">
                                <div class="col-sm-4 no-padding-left">
                                    <select class="col-xs-10" id="slBankCodeSearch" name="slBankCodeSearch">
                                    </select>
                                </div>
                                <label class="col-sm-2 control-label no-padding-right" for="lbStatus"> สถานะใช้งาน : </label>
                                <div class="col-sm-2 no-padding-right">
                                    <select name="slStatusSearch" id="slStatusSearch" class="col-xs-10">
                                        <option value="%">ทั้งหมด</option>
                                        <option value="E">ใช้งาน</option>
                                        <option value="D">ไม่ใช้งาน</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-3">
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
                        <table id="gridData_BankBranchGrid_List"></table>
                        <div id="gridPager_BankBranchGrid_List"></div>
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
                        <div class="form-group">
                            <label for="lbslBankCodeNew" class="col-sm-4 control-label">รหัสธนาคาร *</label>
                            <div class="col-sm-6">
                                <select name="slBankCodeNew" id="slBankCodeNew">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBranchCodeNew" class="col-sm-4 control-label">รหัสสาขาธนาคาร</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchCodeNew" name="txtBranchCodeNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBranchNameNew" class="col-sm-4 control-label">ชื่อสาขาธนาคาร</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchNameNew" name="txtBranchNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBranchShortNew" class="col-sm-4 control-label">ชื่อสาขาธนาคารแบบย่อ</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchShortNew" name="txtBranchShortNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbAddressNew" class="col-sm-4 control-label">ที่อยู่</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtAddressNew" name="txtAddressNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbSubdistrictNew" class="col-sm-4 control-label">ตำบล</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtSubdistrictNew" name="txtSubdistrictNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbDistrictNew" class="col-sm-4 control-label">อำเภอ</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtDistrictNew" name="txtDistrictNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbProvinceCodeNew" class="col-sm-4 control-label">จังหวัด *</label>
                            <div class="col-sm-6">
                                <select name="slProvinceCodeNew" id="slProvinceCodeNew">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbZipcodeNew" class="col-sm-4 control-label">รหัสไปรษณีย์</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtZipcodeNew" name="txtZipcodeNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbTelNew" class="col-sm-4 control-label">เบอร์โทรศัพท์</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtTelNew" name="txtTelNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbFaxNew" class="col-sm-4 control-label">เบอร์แฟกซ์</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtFaxNew" name="txtFaxNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusNew" class="col-sm-4 control-label">สถานะใช้งาน</label>
                            <div class="col-sm-6">
                                <input type="checkbox" id="chkStatusNew" name="chkStatusNew" value="E">
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
                        <div class="form-group">
                            <label for="lbslBankCodeEdit" class="col-sm-4 control-label">รหัสธนาคาร *</label>
                            <div class="col-sm-6">
                                <input type="hidden" id="hidBranchIdEdit" name="hidBranchIdEdit">
                                <select name="slBankCodeEdit" id="slBankCodeEdit">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBranchCodeEdit" class="col-sm-4 control-label">รหัสสาขาธนาคาร</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchCodeEdit" name="txtBranchCodeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBranchNameEdit" class="col-sm-4 control-label">ชื่อสาขาธนาคาร</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchNameEdit" name="txtBranchNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbBranchShortEdit" class="col-sm-4 control-label">ชื่อสาขาธนาคารแบบย่อ</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtBranchShortEdit" name="txtBranchShortEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbAddressEdit" class="col-sm-4 control-label">ที่อยู่</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtAddressEdit" name="txtAddressEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbSubdistrictEdit" class="col-sm-4 control-label">ตำบล</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtSubdistrictEdit" name="txtSubdistrictEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbDistrictEdit" class="col-sm-4 control-label">อำเภอ</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtDistrictEdit" name="txtDistrictEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbProvinceCodeEdit" class="col-sm-4 control-label">จังหวัด *</label>
                            <div class="col-sm-6">
                                <select name="slProvinceCodeEdit" id="slProvinceCodeEdit">
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbZipcodeEdit" class="col-sm-4 control-label">รหัสไปรษณีย์</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtZipcodeEdit" name="txtZipcodeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbTelEdit" class="col-sm-4 control-label">เบอร์โทรศัพท์</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtTelEdit" name="txtTelEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbFaxEdit" class="col-sm-4 control-label">เบอร์แฟกซ์</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="txtFaxEdit" name="txtFaxEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusEdit" class="col-sm-4 control-label">สถานะใช้งาน</label>
                            <div class="col-sm-6">
                                <input type="checkbox" id="chkStatusEdit" name="chkStatusEdit" value="E">
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