<%-- 
    Document   : APP010
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlActionOpenNew = rootPath + '/Plugins/Registration/APP010_2_New.htm';
    var urlActionOpenEdit = rootPath + '/Plugins/Registration/APP010_2_Edit.htm';
    var urlListJsonBank = rootPath + '/Plugins/MasterData/getListInJSONBank.json';
    var urlListJsonMilitaryDepartment = rootPath + '/Plugins/MasterData/getListInJSONMilitaryDepartment.json';
    var urlList = rootPath + '/Plugins/Registration/getListAPP010.json';
    var responseId = '#main-page-content-loading';
    var listMilitaryDepartment = {};
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP010.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP010.js"></script>
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            รายการผู้สมัครเป็นสมาชิก
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
                            <div class="col-md-1"></div>
                            <!--div class="col-md-2"-->
                            <label for="lbApplyDateFromSearch" class="col-md-2 control-label no-padding-right">วันที่สมัคร</label>
                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtApplyDateFromSearch" name="txtApplyDateFromSearch" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                            <div class="col-md-2">
                            </div> 
                            <label for="lbApplyDateEndSearch" class="col-md-1 control-label no-padding-right"> ถึง </label>

                            <div class="col-md-2">
                                <div class="input-group input-group-sm">
                                    <input type="text" id="txtApplyDateEndSearch" name="txtApplyDateEndSearch" class="form-control"/>
                                    <span class="input-group-addon"><i class="ace-icon fa fa-calendar"></i></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbCitizenIdSearch" class="col-md-2 control-label no-padding-right">เลขประจำตัวประชาชน</label>
                            <div class="col-md-3">
                                <input id="txtReferNumber" name="txtCitizenIdSearch" type="text"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbNameSearch" class="col-md-2 control-label no-padding-right">ชื่อ</label>
                            <div class="col-md-3">
                                <input id="txtNameSearch" name="txtNameSearch" type="text"  class="form-control">
                            </div>
                            <label for="lbSurnameSearch" class="col-md-2 control-label no-padding-right">สกุล</label>
                            <div class="col-md-3">
                                <input id="txtSurnameSearch" name="txtSurnameSearch" type="text"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbMilitaryDepartmentSearch" class="col-md-2 control-label no-padding-right">หน่วยต้นสังกัด</label>
                            <div class="col-md-3">
                                <select id="slMilitaryDepartmentSearch" name="slMilitaryDepartmentSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                </select>
                            </div>
                            <label for="lbApplyTypeSearch" class="col-md-2 control-label no-padding-right">ประเภทการสมัคร</label>
                            <div class="col-md-3">
                                <select id="slApplyTypeSearch" name="slApplyTypeSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                    <option value="10">สมัครด้วยตนเอง</option>
                                    <option value="20">สมัครผ่านหน่วยต้นสังกัด</option>
                                    <option value="30">สมัครผ่านชุดรับสมัคร</option>
                                    <option value="40">สมัครผ่านกรณีพิเศษ</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <label for="lbMemberTypeCodeSearch" class="col-md-2 control-label no-padding-right">ประเภทสมาชิก</label>
                            <div class="col-md-3">
                                <select id="slMemberTypeCodeSearch" name="slMemberTypeCodeSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                    <option value="10">ข้าราชการ</option>
                                    <option value="20">ลูกจ้าง</option>
                                    <option value="30">ครอบครัว</option>
                                    <option value="40">พลทหารกองประจำการ</option>
                                </select>
                            </div>
                            <label for="lbMemberStatusCodeSearch" class="col-md-2 control-label no-padding-right">สถานะ</label>
                            <div class="col-md-3">
                                <select id="slMemberStatusCodeSearch" name="slMemberStatusCodeSearch" class="form-control select2">
                                    <option value="%">ทั้งหมด</option>
                                    <option value="10">ยื่นใบสมัคร</option>
                                    <option value="11">ชำระเงินค่าสมัคร</option>
                                    <option value="12">บันทึกข้อมูลเพิ่มเติม</option>
                                    <option value="13">อนุมัติเห็นชอบ</option>
                                    <option value="20">กำหนดเลขทะเบียนสมาชิก</option>
                                    <option value="25">ดำเนินการขออนุมัติขึ้นทะเบียน</option>
                                    <option value="100">สมาชิกปกติ</option>
                                    <option value="101">ค้างชำระ 1 เดือน</option>					
                                    <option value="102">ค้างชำระ 2 เดือน</option>
                                    <option value="103">ค้างชำระ 3 เดือน และได้ดำเนินการทวงถาม</option>
                                    <option value="105">อนุมัติขึ้นทะเบียนเป็นสมาชิก</option>
                                    <option value="109">ดำเนินการถอนสภาพชั่วคราว</option>
                                    <option value="110">ถูกถอนสภาพชั่วคราว</option>
                                    <option value="115">บันทึำกขอคืนสภาพ</option>
                                    <option value="116">ชำระเงินค้างชำระ</option>
                                    <option value="119">ดำเนินการคืนสภาพ</option>
                                    <option value="120">คืนสภาพเป็นสมาชิกปกติ</option>
                                    <option value="130">คืนสภาพเป็นสมาชิกปกติกรณีพิเศษ</option>
                                    <option value="199">ดำเนินการถอนสภาพถาวร</option>
                                    <option value="200">ถูกถอนสภาพถาวร</option> 
                                    <option value="205">บันทึกแจ้งถึงแก่กรรม</option>  
                                    <option value="206">บันทึกการจ่ายค่าจัดการศพ</option>
                                    <option value="207">ขออนุมัติจ่ายค่าจัดการศพ</option>
                                    <option value="210">ถึงแก่กรรม</option>
                                    <option value="220">ลาออก</option>
                                    <option value="231">เสียชีวิตก่อนขึ้นทะเบียน</option>
                                    <option value="232">ไม่อนุมััติขอความเห็นชอบ</option>
                                    <option value="234">ไม่อนุมัติขึ้นทะเบียน</option>
                                </select>
                            </div>                                
                        </div>  
                        <div class="form-group">
                            <div class="col-md-1"></div>
                            <div class="col-md-2"></div>
                            <div class="col-md-3">
                                <button type="button" id="btnSearch" name="btnSearch" class="btn btn-search"><i class="ace-icon fa fa-check-square-o bigger-110"></i>ค้นหา</button>
                                <button type="reset" class="btn btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้าง</button>
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
                        <table id="gridData_APP010Grid_List"></table>
                        <div id="gridPager_APP010Grid_List"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->
</div><!-- /.row -->

<!-- basic scripts -->

<!-- inline scripts related to this page -->