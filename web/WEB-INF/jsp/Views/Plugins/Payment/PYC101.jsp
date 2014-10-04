<%-- 
    Document   : PAY010.jsp รายการรับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 5:22:26 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="page-header">
    <h1>ชำระเงิน
        <small><i class="ace-icon fa fa-angle-double-right"></i>แสดงรายการการชำระเงินของหน่วย</small>
    </h1>
</div><!-- /.page-header -->
<div class="row">
    <div id="track-changes" class="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">&nbsp;</h4>
                </div>
                <form>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-6">
                                <h4>
                                    สมัครซ้ำ
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>                    
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->						
        <form role="form" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> งวดเดือน </label>
                <div class="col-sm-6">
                    <select name="xx3" id="form-field-4" class="col-xs-10 col-sm-4">
                        <option>ทั้งหมด</option>
                        <option value="1">มิ.ย. 2557</option>
                        <option value="2">พ.ค. 2557</option>
                        <option value="3">เม.ย. 2557</option>
                    </select>
                    <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> หน่วยต้นสังกัด &nbsp;&nbsp;</label>
                    <select name="xx3" id="form-field-4" class="col-xs-10 col-sm-4">
                        <option>ทั้งหมด</option>
                        <option value="1">กกส.กห.</option>
                        <option value="2">กคช.กช</option>
                        <option value="3">กง.กห.</option>
                    </select>
                </div>
            </div>
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <button class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple"><span class="ace-icon fa fa-search"></span>แสดงรายการ</button>
                    <button class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ยกเลิก</button>
                </div>
            </div>
        </form>
        <div id="modal-form" class="modal" tabindex="-1">
            <div class="modal-dialog" style="width: 700px">
                <div class="modal-content">
                    <div class="modal-header" style="padding: 6px;">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="blue bigger">กรุณาระบุเลขที่อ้างอิงการถอนสภาพ</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-xs-12">
                                <!-- PAGE CONTENT BEGINS JACK-->
                                <form role="form" class="form-horizontal">
                                    <!-- #section:elements.form -->
                                    <div class="form-group" style="margin-bottom:5px">
                                        <label for="form-field-1" class="col-sm-3 control-label no-padding-right"> เลขที่อ้างอิงการถอนสภาพ </label>
                                        <div class="col-sm-9">
                                            <input type="text" class="col-xs-10 col-sm-5" id="form-field-1">
                                        </div>
                                    </div>
                                    <div class="form-group" style="margin-bottom:5px"></div>
                                    <div class="form-group" style="margin-bottom:5px"> </div>
                                    <div class="form-group" style="margin-bottom:5px"></div>
                                    <div class="form-group" style="margin-bottom:5px"> </div>
                                    <!-- /section:elements.form -->
                                </form>
                                <div tabindex="-1" class="modal" id="modal-form" style="display: none;" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button data-dismiss="modal" class="close" type="button">×</button>
                                                <h4 class="blue bigger">ข้อมูลหน่วยต้นสังกัด</h4>
                                            </div>
                                            <div class="modal-body">
                                                <div class="row">
                                                    <form class="form-horizontal" role="form">
                                                        <!-- #section:elements.form -->
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> หน่วยต้นสังกัด </label>
                                                            <div class="col-sm-9">
                                                                <input type="text" id="form-field-1" class="col-xs-10 col-sm-5">
                                                            </div>
                                                        </div>
                                                        <!-- /section:elements.form -->
                                                        <div class="clearfix form-actions" >
                                                            <div class="col-md-offset-3 col-md-9">
                                                                <button class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple" id="fbox_grid-table_search"><span class="ace-icon fa fa-search"></span>ค้นหา</button>
                                                                <button id="fbox_grid-table_reset" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ยกเลิก</button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> Cancel </button>
                                                <button class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i> Save </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- PAGE CONTENT ENDS JACK-->
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-sm" data-dismiss="modal"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
                        <button class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i> บันทึก </button>
                    </div>
                </div>
            </div>
        </div><!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->

</div>
<div class="row">
    <div class="col-xs-12" align="left">
        <button class="btn btn-pink "><i class="ace-icon fa fa-print  align-top bigger-125 icon-on-right"></i> พิมพ์รายการ</button>
        <div style="padding:1px"></div>
        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th class="center">ลำดับที่</th>
                    <th>วันที่ชำระ</th>
                    <th>งวดเดือน</th>
                    <th>หน่วยต้นสังกัด</th>
                    <th>จำนวนสมาชิก</th>
                    <th>จำนวนเงิน</th>
                    <th>เพิ่ม</th>
                    <th>ลด</th>
                    <th>วันที่บันทึก</th>
                    <th>ผู้บันทึก</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="center">1</td>
                    <td>21 มิ.ย 2557</td>
                    <td>มิ.ย 2557</td>
                    <td>มทบ. 15</td>
                    <td>143</td>
                    <td>30,030.00</td>
                    <td>0</td>
                    <td>2</td>
                    <td>21 มิ.ย 2557</td>
                    <td>ผู้ดูแลระบบ</td>
                    <td class="center"><div class="hidden-sm hidden-xs btn-group"> <a href="PYC101-1.html" role="button" class="blue">
                                <button class="btn btn-xs btn-search" id="btnDialog"><i class="ace-icon fa fa-search bigger-120"></i></button>
                            </a> </div>
                    </td>	
                </tr>
                <tr>
                    <td class="center">2</td>
                    <td>21 มิ.ย 2557</td>
                    <td>มิ.ย 2557</td>
                    <td>ร.11 พัน.3 รอ.</td>
                    <td>143</td>
                    <td>50,030.00</td>
                    <td>0</td>
                    <td>0</td>
                    <td>21 มิ.ย 2557</td>
                    <td>ผู้ดูแลระบบ</td>
                    <td class="center">
                        <div class="hidden-sm hidden-xs btn-group">
                            <a href="PYC101-1.html" role="button" class="blue">
                                <button class="btn btn-xs btn-search" id="btnDialog"><i class="ace-icon fa fa-search bigger-120"></i></button>
                            </a>
                        </div>
                    </td>	
                </tr>
                <tr>
                    <td class="center">3</td>
                    <td>21 มิ.ย 2557</td>
                    <td>มิ.ย 2557</td>
                    <td>มทบ. 30</td>
                    <td>120</td>
                    <td>20,030.00</td>
                    <td>0</td>
                    <td>0</td>
                    <td>21 มิ.ย 2557</td>
                    <td>ผู้ดูแลระบบ</td>
                    <td class="center">
                        <div class="hidden-sm hidden-xs btn-group"> 
                            <a href="PYC101-1.html" role="button" class="blue">
                                <button class="btn btn-xs btn-search" id="btnDialog"><i class="ace-icon fa fa-search bigger-120"></i></button>
                            </a>
                        </div>
                    </td>	
                </tr>
            </tbody>
        </table>
    </div>
    <!-- /.col -->
</div>