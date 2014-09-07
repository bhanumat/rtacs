<%-- 
    Document   : MAS080
    Created on : Aug 5, 2014, 03:20:55 AM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/MasterData/getListMAS080.json';
    var urlDelete = rootPath + '/Plugins/MasterData/setDeleteMAS080.json';
    var urlNew = rootPath + '/Plugins/MasterData/setSaveNewMAS080.json';
    var urlEdit = rootPath + '/Plugins/MasterData/setSaveEditMAS080.json';
    var urlLoad = rootPath + '/Plugins/MasterData/getLoadMAS080.json';

    var objectDefault = {};
    var inputToMergeNew = ['#txtProvinceCodeNew', '#txtProvinceNameNew', 'input[id=chkStatusNew]:checked'];
    var inputToChangeNew = ['provinceCode', 'provinceName', 'status'];

    var inputToMergeEdit = ['#txtProvinceCodeEdit', '#txtProvinceNameEdit', 'input[id=chkStatusEdit]:checked'];
    var inputToChangeEdit = ['provinceCode', 'provinceName', 'status'];

    var objIdKeyEdit = 'provinceCode';

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/MasterData/action.MAS080.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/MasterData/jqgrid.MAS080.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลพื้นฐาน
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ข้อมูลจังหวัด
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
                            <label for="lbProvinceName" class="col-lg-4 control-label"> ชื่อจังหวัด : </label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtProvinceName" name="txtProvinceName" placeholder="Search">
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
                        <table id="gridData_ExjqGrid_List"></table>
                        <div id="gridPager_ExjqGrid_List"></div>
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
                            <label for="lbProvinceCodeNew" class="col-lg-3 control-label">รหัสจังหวัด *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtProvinceCodeNew" name="txtProvinceCodeNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbProvinceNameNew" class="col-lg-3 control-label">ชื่อจังหวัด </label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtProvinceNameNew" name="txtProvinceNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusNew" class="col-lg-3 control-label">สถานะใช้งาน</label>
                            <div class="col-lg-5">
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
                            <label for="lbProvinceCodeEdit" class="col-lg-3 control-label">รหัสจังหวัด *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtProvinceCodeEdit" name="txtProvinceCodeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbProvinceNameEdit" class="col-lg-3 control-label">ชื่อจังหวัด </label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtProvinceNameEdit" name="txtProvinceNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusEdit" class="col-lg-3 control-label">สถานะใช้งาน</label>
                            <div class="col-lg-5">
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