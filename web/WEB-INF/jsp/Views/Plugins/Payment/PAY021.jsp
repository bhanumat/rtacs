<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlPAY021List     = rootPath + '/Plugins/Payment/getPAY021List.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Payment/action.PAY021.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Payment/jqgrid.PAY021.js"></script>
<div class="page-header">
    <h1>ชำระเงิน<small>
        <i class="ace-icon fa fa-angle-double-right"></i>
        ชำระเงินค่าสมัครสมาชิก(สมัครผ่านหน่วย) </small>
    </h1>
</div><!-- /.page-header -->

<div class="row">                  
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->		
        <input type="hidden" name="militaryId" id="militaryId" />
        <input type="hidden" name="militaryName" id="militaryName" />
        <input type="hidden" name="militaryDate" id="militaryDate" />
        <input type="hidden" name="militaryMember" id="militaryMember" />
        <input type="hidden" name="militarySumAmount" id="militarySumAmount" />
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่รับสมัคร</label>
                <div class="col-sm-5">
                    <div class="row">
                        <div class="col-xs-5">
                            <div class="input-group input-group-sm">
                                <input type="text" id="date_begin" class="form-control"/>
                                <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> 
                            </div>
                        </div>
                        <div class="col-xs-6">
                        <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ถึง&nbsp;&nbsp;</label>
                            <div class="input-group input-group-sm">
                                <input type="text" id="date_end" class="form-control" />
                                <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>	
            <div class="form-group">
                <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> หน่วยต้นสังกัด </label>
                <div class="col-sm-9">
                    <select id="military" name="military" style="width: 150px">
                        <option value="">ทั้งหมด</option>
                    </select>
                </div>
            </div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button type="button" id="btnSearch" name="btnSearch" class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>ค้นหา</button>
                    <button type="reset" id="btnReset" name="btnReset" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ล้าง</button>
                </div>
            </div>
            <div id="jqGridContainer" class="row">
                <div>
                    <table id="gridData_PAY021_Grid_List"></table>
                    <div id="gridPager_PAY021_Grid_List"></div>
                </div>
            </div>
        </form>
    </div><!-- /.col -->
</div>