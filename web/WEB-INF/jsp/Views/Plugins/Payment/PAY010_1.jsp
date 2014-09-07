<%-- 
    Document   : PAY010_1 รับชำระเงินค่าบำรุงศพ 
    Created on : Sep 7, 2014, 6:04:15 PM
    Author     : bhanumat.w
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="page-header">
    <h1>
        รับชำระเงินค่าบำรุงศพ 

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
        <div class="row">
            <div class="col-sm-12">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">เรียกค้นข้อมูลสมาชิก</h4>
                    </div>
                    <div class="widget-body">
                        <div class="widget-body">
                            <div class="widget-main">
                                <form class="form-search">
                                    <div class="row" style="margin-bottom:5px">
                                        <div class="col-xs-12 col-sm-3" align="right">
                                            <div class="bigger-110" >
                                                <label class="position-relative">
                                                    <input type="radio" class="ace" name="select-name">
                                                    <span class="lbl"></span> เลขประจำตัวประชาชน </label>
                                                &nbsp;&nbsp;
                                                <input type="radio" class="ace" name="select-name">
                                                <span class="lbl"></span> เลขทะเบียนสมาชิก
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-2">
                                            <div class="input-group">
                                                <input type="text" class="form-control search-query" placeholder="">
                                                <span class="input-group-btn">
                                                    <button type="button" class="btn btn-info btn-sm"> แสดง <i class="ace-icon fa fa-check icon-on-right bigger-110"></i> </button>
                                                </span> </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-2"> <a href="#modal-form" role="button" class="blue" data-toggle="modal">
                                                <button type="button" class="btn btn-purple btn-sm"> ค้นหา <i class="ace-icon fa fa-search icon-on-right bigger-110"></i> </button>
                                            </a> </div>
                                    </div>
                                </form>
                                <form class="form-horizontal" role="form">
                                    <!-- #section:elements.form -->

                                    <!-- /section:elements.form -->
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>						
        <!-- PAGE CONTENT BEGINS -->						

        <form role="form" class="form-horizontal">
            <div class="profile-user-info profile-user-info-striped">
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> สถานะสมาชิก</div>
                    <div class="profile-info-value"> <span id="username" class="editable"><span class="label label-xlg label-yellow arrowed arrowed-right">ค้างชำระ 1 เดือน</span></span> </div>

                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> เลขทะเบียนสมาชิก </div>
                    <div class="profile-info-value"> <span id="username" class="editable"> 	5450012551</span> </div>
                    <div class="profile-info-name" style="width:170px;"> เลขประจำตัวประชาชน </div>
                    <div class="profile-info-value"> <span id="username" class="editable">3-3411-01241-39-1</span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> ชื่อ-สกุล</div>
                    <div class="profile-info-value"> <span id="username" class="editable"> ส.อ.นาย มงคล พลพิทักษ์</span> </div>
                    <div class="profile-info-name" style="width:170px;">หน่วยต้นสังกัด </div>
                    <div class="profile-info-value"> <span id="username" class="editable">กกส.กห.</span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;">ชำระโดย</div>
                    <div class="profile-info-value"> <span id="username" class="editable"> 																		<label>
                                <input type="radio" name="form-field-radio" class="ace">
                                <span class="lbl"> เงินสด</span>
                            </label>
                            <span class="middle"></span>
                            <label>
                                <input type="radio" name="form-field-radio" class="ace">
                                <span style="padding-left:10px;" class="lbl"> ธนาณัติ</span>
                            </label></span> </div>
                    <div class="profile-info-name" style="width:170px;">หมายเลขธนาณัติ </div>
                    <div class="profile-info-value"> <span id="username" class="editable"><input type="text"></span> </div>
                </div>
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> วันที่ชำระ</div>
                    <div class="profile-info-value"> <span id="username" class="editable"> <input type="text" id="date_register" /></span> </div>
                    <div class="profile-info-name" style="width:170px;">หน่วยต้นสังกัด </div>
                    <div class="profile-info-value"> <span id="username" class="editable">กกส.กห.</span> </div>
                </div>		
                <div class="profile-info-row">
                    <div class="profile-info-name" style="width:170px;"> เลขที่ใบเสร็จ</div>
                    <div class="profile-info-value"> <span id="username" class="editable"> <input type="text" id="date_register" value="ฬ0011375" readonly /></span> </div>
                    <div class="profile-info-name" style="width:170px;"> สถานะการชำระเงิน</div>
                    <div class="profile-info-value"> <span id="username" class="editable"><span class="label label-xlg label-success arrowed arrowed-right">พิมพ์ใบเสร็จ</span></span> </div>

                </div>									

            </div>									

        </form>

        <div tabindex="-1" class="modal" id="modal-form-cancel" style="display: none;" aria-hidden="true">
            <div style="width: 800px;" class="modal-dialog">
                <div class="modal-content">
                    <div style="padding:5px" class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">×</button>
                        <h4 class="blue bigger">ยกเลิกใบเสร็จ</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <form class="form-horizontal" role="form">
                                <!-- #section:elements.form -->

                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-2 control-label no-padding-right" for="form-field-1"> เหตุผลในการยกเลิก </label>
                                    <div class="col-sm-9">
                                        <input type="text" style="width: 400px;">
                                    </div>
                                </div>

                                <!-- /section:elements.form -->
                            </form>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-sm"> <i class="ace-icon fa fa-times"></i> ยกเลิก </button>
                        <button data-dismiss="modal"  class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i>บันทึก </button>
                    </div>
                </div>
            </div>
        </div><!-- PAGE CONTENT ENDS -->


        <div aria-hidden="true" style="display: none;" id="modal-form" class="modal" tabindex="-1">
            <div class="modal-dialog" style="width: 900px;">
                <div class="modal-content">
                    <div class="modal-header" style="padding:5px">
                        <button type="button" class="close" data-dismiss="modal">×</button>
                        <h4 class="blue bigger">เรียกค้นข้อมูลสมาชิก </h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <form role="form" class="form-horizontal">
                                <!-- #section:elements.form -->
                                <div class="form-group" style="margin-bottom:5px">
                                    <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> เลขทะเบียนสมาชิก </label>
                                    <div class="col-sm-9">
                                        <input type="text" >
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;เลขประจำตัวประชาชน
                                        <input type="text"  >
                                    </div>
                                </div>
                                <div class="form-group" style="margin-bottom:5px">
                                    <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> ชื่อ </label>
                                    <div class="col-sm-9">
                                        <input type="text" >
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;สกุล
                                        <input type="text"  >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="form-field-1" class="col-sm-2 control-label no-padding-right"> หน่วยต้นสังกัด </label>
                                    <div class="col-sm-6">
                                        <select class="col-xs-10 col-sm-4" id="form-field-3" name="xx2">
                                            <option>ทั้งหมด</option>
                                            <option>รอ. 1</option>
                                            <option>พัน. 153</option>
                                            <option>สกทบ.</option>
                                        </select>
                                        <label for="form-field-2" class="col-sm-3 control-label no-padding-right"> สถานะ &nbsp;&nbsp;</label>
                                        <select class="col-xs-10 col-sm-4" id="form-field-4" name="xx3">
                                            <option>ทั้งหมด</option>
                                            <option>สมาชิกปกติ</option>
                                            <option>สมาชิกถอนสภาพชั่วคราว</option>
                                            <option>สมาชิกถอนสภาพถาวร</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-offset-3 col-md-9">
                                    <button class="fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset btn btn-sm btn-purple" id="fbox_grid-table_search"><span class="ace-icon fa fa-search"></span>ค้นหา</button>
                                    <button id="fbox_grid-table_reset" class="fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search btn btn-sm btn-info"><span class="ace-icon fa fa-retweet"></span>ล้าง</button>
                                </div>
                                <!-- /section:elements.form -->
                            </form>
                            <div class="col-xs-12">
                                <div style="padding:1px"></div>
                                <div class="table-header">ข้อมูลสมาชิก</div>
                                <table class="table table-striped table-bordered table-hover" id="sample-table-1">
                                    <thead>
                                        <tr>
                                            <th> เลือก</th>
                                            <th> หน่วยต้นสังกัด</th>
                                            <th>เลขทะเบียนสมาชิก </th>
                                            <th>เลขประจำตัวประชาชน </th>
                                            <th> ยศ - คำนำหน้า </th>
                                            <th>ชื่อ</th>
                                            <th> สกุล </th>
                                            <th> สถานะ</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="center"><label class="position-relative">
                                                    <input type="radio" class="ace" name="select1">
                                                    <span class="lbl"></span> </label></td>
                                            <td>รอ.</td>
                                            <td>5450012551</td>
                                            <td>3-3411-01241-39-1</td>
                                            <td>ส.อ.นาย</td>
                                            <td>มงคล</td>
                                            <td>พลพิทักษ์</td>
                                            <td><button class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> สมาชิกปกติ </button></td>
                                        </tr>
                                        <tr>
                                            <td class="center"><label class="position-relative">
                                                    <input type="radio" class="ace" name="select1">
                                                    <span class="lbl"></span> </label></td>
                                            <td>รพ. อานันทมหิดล</td>
                                            <td>5450012552</td>
                                            <td>3-6005-00123-60-7</td>
                                            <td>นาย </td>
                                            <td>กิตติพัฒน์</td>
                                            <td>ศิริชู</td>
                                            <td><button class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> สมาชิกปกติ </button></td>
                                        </tr>
                                        <tr>
                                            <td class="center"><label class="position-relative">
                                                    <input type="radio" class="ace" name="select1">
                                                    <span class="lbl"></span> </label></td>
                                            <td>ศสพ. </td>
                                            <td>5450012553</td>
                                            <td>1-6005-00123-60-7</td>
                                            <td>ส.ท. </td>
                                            <td>ณรงค์ชัย </td>
                                            <td>สุดใจ</td>
                                            <td><button class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> สมาชิกปกติ </button></td>
                                        </tr>
                                        <tr>
                                            <td class="center"><label class="position-relative">
                                                    <input type="radio" class="ace" name="select1">
                                                    <span class="lbl"></span> </label></td>
                                            <td>รอ.</td>
                                            <td>5450012554</td>
                                            <td>2-6005-00123-60-8</td>
                                            <td>น.ส. </td>
                                            <td>วาสนา </td>
                                            <td>เจริญสุข</td>
                                            <td><button class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> สมาชิกปกติ </button></td>
                                        </tr>
                                        <tr>
                                            <td class="center"><label class="position-relative">
                                                    <input type="radio" class="ace" name="select1">
                                                    <span class="lbl"></span> </label></td>
                                            <td>ส.พัน.24 </td>
                                            <td>5450012555</td>
                                            <td>4-6005-00123-60-9</td>
                                            <td>ส.ต. </td>
                                            <td>สมโภชน์ </td>
                                            <td>สีดำอ่อน</td>
                                            <td><button class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> สมาชิกปกติ </button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-sm" data-dismiss="modal"> <i class="ace-icon fa fa-times"></i> ไม่เลือก </button>
                        <button class="btn btn-sm btn-primary"> <i class="ace-icon fa fa-check"></i> เลือก </button>
                    </div>
                </div>
            </div>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div><!-- /.col -->

</div>
<div class="row">

    <div class="col-xs-12">
        <div style="padding:1px"></div>
        <div class="table-header">ข้อมูลสมาชิก</div>
        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th> ลำดับ</th>
                    <th>รายการ </th>
                    <th>จำนวนศพ </th>
                    <th> จำนวนเงิน</th>
                    <th>ชำระ ?</th>

                    <th> หมายเหตุ</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="center">1</td>
                    <td>ค่าบำรุงศพประจำเดือน พ.ค. 2557 ตั้งแต่ศพที่ 1,321/57 ถึงศพที่ 1,720/57 </td>
                    <td>400</td>
                    <td>200.00</td>
                    <td class="center"><input type="checkbox" name="checkbox2" id="checkbox2"></td>

                    <td><input type="text" name="checkbox2" id="checkbox2"></td>

                </tr>
                <tr>
                    <td class="center">2</td>
                    <td>ค่าบำรุงศพประจำเดือน มิ. ย. 2557 ตั้งแต่ศพที่ 1,321/57 ถึงศพที่ 1,720/57 </td>
                    <td>440</td>
                    <td>220.00</td>
                    <td class="center"><input type="checkbox" name="checkbox2" id="checkbox2"></td>

                    <td><input type="text" name="checkbox2" id="checkbox2"></td>

                </tr>


            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="col-xs-12">



        <div class="clearfix form-actions">
            <div class="col-md-offset-3 col-md-9">
                <button type="button" id="bootbox-submit" class="btn btn-info">
                    <i class="ace-icon fa fa-floppy-o bigger-110"></i>
                    รับชำระ
                </button>

                &nbsp; &nbsp; &nbsp;
                <button type="reset" class="btn">
                    <i class="ace-icon fa fa-undo bigger-110"></i>
                    ยกเลิก

                </button>
                &nbsp; &nbsp; &nbsp;
                <button type="button" id="bootbox-submit" class="btn btn-success">
                    <i class="ace-icon fa fa-print bigger-110"></i>
                    พิมพ์ใบเสร็จ
                </button>
                &nbsp; &nbsp; &nbsp;
                <a href="#modal-form-cancel" role="button" class="blue" data-toggle="modal">
                    <button type="button" id="bootbox-submit" class="btn btn-danger">
                        <i class="ace-icon fa fa-times bigger-110"></i>
                        ยกเลิกใบเสร็จ
                    </button>
                </a>								


            </div>
        </div>
    </div>
    <!-- /.col -->
</div>