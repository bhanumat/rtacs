<%-- 
    Document   : PAY010.jsp รายการรับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 5:22:26 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getMilitaryDepartments.json';
    var urlListJsonControlPaymentMonthCodes = rootPath + '/Plugins/MasterData/getControlPaymentMonthCodes.json';
    var urlListMilitaryPayment = rootPath + '/Plugins/Payment/getListMilitaryPayment.json';
    var urlMilitaryPayment = rootPath + '/Plugins/Payment/PYC101_1.htm';
    var urlListDeptMemberPayment = rootPath + '/Plugins/Payment/getListDeptMemberPayment.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PYC101.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PYC101.js"></script>
<div class="page-header">
    <h1>
        แสดงรายการการชำระเงินของหน่วย
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->						
        <form role="form" class="form-horizontal" id="frmCriterionSearch" name="frmCriterionSearch">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="monthCode"> งวดเดือน </label>
                <div class="col-sm-6">
                    <select name="monthCode" id="monthCode" class="col-xs-10 col-sm-4">
                        <option>ทั้งหมด</option>
                    </select>
                    <label class="col-sm-3 control-label no-padding-right" for="militaryId"> หน่วยต้นสังกัด &nbsp;&nbsp;</label>
                    <select name="militaryId" id="militaryId" class="col-xs-10 col-sm-4">
                        <option>ทั้งหมด</option>
                    </select>
                </div>
            </div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button type="submit" id="btnSearch" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>แสดงรายการ</button>
                    <button type="reset" id="btnReset" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ยกเลิก</button>
                </div>
            </div>
        </form>
    </div><!-- /.col -->

</div>
<div class="row">
    <div class="col-xs-12" align="left">
        <button class="btn btn-pink "><i class="ace-icon fa fa-print  align-top bigger-125 icon-on-right"></i> พิมพ์รายการ</button>
        <div style="padding:1px"></div>
        <!-- Grid View -->
        <div id="jqGridContainer" class="row">
            <div>
                <table id="gridData_PYC101"></table>
                <div id="gridPager_PYC101"></div>
            </div>
        </div>
    </div>
    <!-- /.col -->
</div>