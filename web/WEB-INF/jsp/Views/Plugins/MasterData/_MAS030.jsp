<%-- 
    Document   : MAS040
    Created on : Aug 2, 2014, 11:27:14 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/MasterData/getListMAS030.json';
    var urlDelete = rootPath + '/Plugins/MasterData/setDeleteMAS030.json';
    var urlNew = rootPath + '/Plugins/MasterData/setSaveNewMAS030.json';
    var urlEdit = rootPath + '/Plugins/MasterData/setSaveEditMAS030.json';
    var urlLoad = rootPath + '/Plugins/MasterData/getLoadMAS030.json';

    var objectDefault = {};
    var inputToMergeNew = ['#txtRankNameNew', '#slRankClassCodeNew', '#txtRankFullnameNew', '#txtRankOrderNew', 'input[id=chkStatusNew]:checked'];
    var inputToChangeNew = ['rankName', 'rankClassCode', 'rankFullname', 'rankOrder', 'status'];

    var inputToMergeEdit = ['#hidRankIdEdit', '#txtRankNameEdit', '#slRankClassCodeEdit', '#txtRankFullnameEdit', '#txtRankOrderEdit', 'input[id=chkStatusEdit]:checked'];
    var inputToChangeEdit = ['rankId', 'rankName', 'rankClassCode', 'rankFullname', 'rankOrder', 'status'];

    var objIdKeyEdit = 'rankId';

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/MasterData/action.MAS030.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/MasterData/jqgrid.MAS030.js"></script>
<div class="page-header">
    <h1>
        ข้อมูลพื้นฐาน
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
                            <label for="lbRankName" class="col-sm-3 control-label no-padding-right"> ชื่อย่อยศ </label>
                            <div class="col-sm-6">
                                <input type="text" class="col-xs-10 col-sm-4" id="txtRankName" name="txtRankName" placeholder="Search"/>
                                <label for="lbRankFullname" class="col-sm-3 control-label no-padding-right">  	ชื่อย่อยศแบบเต็ม &nbsp;&nbsp;</label>
                                <input type="text" class="col-xs-10 col-sm-4" id="txtRankFullname" name="txtRankFullname" placeholder="Search"/>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="lbRankClassCode"> ลำดับขั้น </label>
                            <div class="col-sm-6">
                                <select class="col-xs-10 col-sm-4" id="slRankClassCode" name="slRankClassCode">
                                    <option value="%">ทั้งหมด</option>
                                    <option value="10">ต่ำกว่าสัญญาบัตร</option>
                                    <option value="20">สัญญาบัตร</option>
                                </select>
                                </select>
                                <label class="col-sm-3 control-label no-padding-right" for="lbStatus"> สถานะใช้งาน&nbsp;&nbsp;</label>
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
                
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;สร้างใหม่</button>
                        <button id="btnReload"  type="button" class="btn btn-sm btn-grey" style="font-size: 14px;"><i class="glyphicon glyphicon-repeat"></i>&nbsp;รีโหลด</button>
                    </div>
                </div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_RankjqGrid_List"></table>
                        <div id="gridPager_RankjqGrid_List"></div>
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
                            <label for="lbRankNameNew" class="col-lg-4 control-label">ชื่อย่อยศ*</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control validate[required]" id="txtRankNameNew" name="txtRankNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbRankFullnameNew" class="col-lg-4 control-label">ชื่อยศแบบเต็ม</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control validate[required]" id="txtRankFullnameNew" name="txtRankFullnameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbslRankClassCodeNew" class="col-lg-4 control-label">ลำดับขั้น</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slRankClassCodeNew" name="slRankClassCodeNew" class="validate[required]">
                                    <option value="">เลือก</option>
                                    <option value="10">ต่ำกว่าสัญญาบัตร</option>
                                    <option value="20">สัญญาบัตร</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbRankOrderNew" class="col-lg-4 control-label">ลำดับยศ</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control validate[required]" id="txtRankOrderNew" name="txtRankOrderNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusNew" class="col-lg-4 control-label">สถานะใช้งาน</label>
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
                            <label for="lbRankNameEdit" class="col-lg-4 control-label">ชื่อย่อยศ*</label>
                            <div class="col-lg-4">
                                <input type="hidden" id="hidRankIdEdit" name="hidRankIdEdit">
                                <input type="text" class="form-control validate[required]" id="txtRankNameEdit" name="txtRankNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbRankFullnameEdit" class="col-lg-4 control-label">ชื่อยศแบบเต็ม</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control validate[required]" id="txtRankFullnameEdit" name="txtRankFullnameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbRankClassCodEdit" class="col-lg-4 control-label">ลำดับขั้น</label>
                            <div></div>
                            <div class="col-lg-5">
                                <select id="slRankClassCodeEdit" name="slRankClassCodeEdit" class="validate[required]">
                                    <option value="">เลือก</option>
                                    <option value="10">ต่ำกว่าสัญญาบัตร</option>
                                    <option value="20">สัญญาบัตร</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbRankClassCodeEdit" class="col-lg-4 control-label">ลำดับยศ</label>
                            <div></div>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control validate[required]" id="txtRankOrderEdit" name="txtRankOrderEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lbStatusEdit" class="col-lg-4 control-label">สถานะใช้งาน</label>
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