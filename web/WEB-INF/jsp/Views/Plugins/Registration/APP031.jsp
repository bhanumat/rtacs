<%-- 
    Document   : APP031
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Registration/getListAPP031.json';
    var responseId = '#main-page-content-loading';
    
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP031.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP031.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ขอความเห็นชอบสมาชิกใหม่
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->

        <div id="ListView" class="row">
            <div class="col-xs-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal"> 
                        <div class="form-group">                         
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2" align="right">
                                    <label class="control-label no-padding-right" for="lbMemberGroupCodeNew">วันที่ขอความเห็นชอบ</label>
                                </div>
                                <div class="col-md-2">
                                    <div class="input-group input-group-sm">
                                        <input type="text" id="txtApplyDateNew" name="txtApplyDateNew" class="form-control"/>
                                        <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                    </div>                               
                                </div>
                                <div class="col-md-1" align="right">
                                    <label class="control-label no-padding-right" for="lbMemberGroupCodeNew">ถึง</label>
                                </div>
                                <div class="col-md-2">
                                    <div class="input-group input-group-sm">
                                        <input type="text" id="txtApplyDateNew" name="txtApplyDateNew" class="form-control"/>
                                        <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                    </div>                               
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2" align="right">
                                    <label class="control-label no-padding-right" for="lbCitizenIdNew">เลขที่อ้างอิง</label>
                                </div>
                                <div class="col-md-2">
                                    <input type="text" maxlength="13" id="txtCitizenIdNew" name="txtCitizenIdNew" class="form-control">
                                </div>
                                <div class="col-md-1" align="right">
                                    <label class="control-label no-padding-right" for="lbMemberGroupCodeNew">สถานะ</label>
                                </div>
                                <div class="col-md-2">
                                    <div class="input-group input-group-sm">
                                        <select name="select3"  style="width: 202px">
                                            <option value="" selected="selected">ทั้งหมด</option>
                                            <option value="1">ยื่นขออนุมัติเห็นชอบ</option>
                                            <option value="2">อนุมัติเห็นชอบ</option>
                                        </select>
                                    </div>                               
                                </div>
                            </div> 
                            <div class="form-group">
                                <div class="col-md-1"></div>
                                <div class="col-md-2"></div>
                                <div class="col-md-3">
                                    <button type="button" id="btnSearch" name="btnSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>&nbsp;ค้นหา</button>
                                    <button type="reset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้าง</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>    
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;เพิ่มรายการใหม่</button>
                        <button class="btn btn-white btn-info btn-bold"> <i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> ยืนยันขอความเห็นชอบ </button>
                    </div>
                </div>
                <div style="padding:1px"></div>
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP031jqGrid_List"></table>
                        <div id="gridPager_APP031jqGrid_List"></div>
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
                            <label for="txtBankCodeNew" class="col-lg-3 control-label">รหัสธนาคาร *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtBankCodeNew" name="txtBankCodeNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtBankNameNew" class="col-lg-3 control-label">ชื่อธนาคาร </label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtBankNameNew" name="txtBankNameNew">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="chkStatusNew" class="col-lg-3 control-label">สถานะใช้งาน</label>
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
                            <label for="txtBankCodeEdit" class="col-lg-3 control-label">รหัสธนาคาร *</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="txtBankCodeEdit" name="txtBankCodeEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtBankNameEdit" class="col-lg-3 control-label">ชื่อธนาคาร </label>
                            <div class="col-lg-5">
                                <input type="text"  class="form-control" id="txtBankNameEdit" name="txtBankNameEdit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="chkStatusEdit" class="col-lg-3 control-label">สถานะใช้งาน</label>
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