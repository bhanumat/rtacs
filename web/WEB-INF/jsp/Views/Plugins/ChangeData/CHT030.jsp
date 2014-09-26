<%-- 
    Document   : CHT030
    Created on : Sep 21, 2014, 5:20:18 PM
    Author     : TeTe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlCHT030Search = rootPath + '/Plugins/ChangeData/searchCHT030.json';
    var urlList_TAB4_CHT030  = rootPath + '/Plugins/ChangeData/gridTab4CHT030.json';
    var urlListJsonTitle = rootPath + '/Plugins/MasterData/getListInJSONTitle.json';
    var urlListJsonRank = rootPath + '/Plugins/MasterData/getListInJSONRank.json';
    
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/ChangeData/action.CHT030.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/ChangeData/jqgrid.CHT030.js"></script>
<div class="page-header">
    <h1>เปลี่ยนแปลงข้อมูล
        <small> 
            <i class="ace-icon fa fa-angle-double-right"></i>
                เปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล
            <i class="ace-icon fa fa-angle-double-right"></i>
                บันทึกการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล
        </small>
    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
          <div class="row">
            <div class="col-sm-12">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">บันทึกการเปลี่ยนแปลงข้อมูลคำหน้า-ยศ-ชื่อ-ชื่อสกุล</h4>
                    </div>
                    <div class="widget-body">
                        <div class="widget-body">
                            <div class="widget-main">
                                <form class="form-search">
                                    <div class="row" style="margin-bottom:5px">
                                        <div class="col-xs-12 col-sm-3" align="right">
                                            <div class="bigger-110" >
                                                <label class="position-relative">
                                                    <input type="radio" name="idRadio" id="idRadio" value="1" checked="true" onClick="radioAction('1')" />
                                                    <span class="lbl"></span> เลขประจำตัวประชาชน
                                                    &nbsp;&nbsp;
                                                    <input type="radio" name="idRadio" id="idRadio" value="2" onClick="radioAction('2')" />
                                                    <span class="lbl"></span> เลขทะเบียนสมาชิก
                                                </label>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-2">
                                            <div class="input-group">
                                                <input type="text" id="searchId" name="searchId" class="form-control search-query" >
                                                <span class="input-group-btn"> 
                                                    <a href="#modal-form2" role="button" class="blue" data-toggle="modal">
                                                        <button type="button" class="btn btn-purple btn-sm"> ค้นหา <i class="ace-icon fa fa-search icon-on-right bigger-110"></i></button>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-2">
                                            <button type="button" class="btn btn-info" id="btnShow"> <i class="ace-icon fa fa-check bigger-110"></i> แสดง </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tabbable">
            <ul class="nav nav-tabs padding-12 tab-color-blue background-blue" id="tabCHT030">
                <li> <a data-toggle="tab" href="#tab1">ข้อมูลสมาชิก</a> </li>    
                <li> <a data-toggle="tab" href="#tab2">ที่อยู่</a> </li>
                <li> <a data-toggle="tab" href="#tab3">ผู้รับเงินสงเคราห์</a> </li>
                <li> <a data-toggle="tab" href="#tab4">การชำระเงิน</a> </li>
                <li> <a data-toggle="tab" href="#tab5">สถานะภาพสมาชิก</a> </li>
                <li class="active"> <a data-toggle="tab" href="#tab6">บันทึกเปลี่ยนแปลงข้อมูลสมาชิก</a> </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane"  id="tab1">
                    <div class="row">
                        <div class="col-xs-10">
                        <!-- PAGE CONTENT BEGINS JACK-->
                            <form class="form-horizontal" role="form">
                                <div class="profile-user-info profile-user-info-striped">
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> เลขทะเบียนสมาชิก </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_memberCode" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> วันที่ขึ้นทะเบียน </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_registerDate" class="editable"></span>
                                        </div>								
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> เลขประจำตัวประชาชน </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_citizenId" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> เริ่มชำระศพที่ </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_beginSop" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ยศ - คำนำหน้า </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_preName" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;">เพศ </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_sex" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ชื่อ </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_name" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> สกุล </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_surname" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> วันเดือนปีเกิด </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_birthDate" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> อายุ  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_age" class="editable"></span>ปี
                                        </div>
                                    </div>	
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ประเภทสมาชิก  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_memberType" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> ประเภทการสมัคร  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_registerType" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ประเภทการชำระเงิน   </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_paymentType" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> หน่วยต้นสังกัด  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_military" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> รหัสผู้นำเข้า  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_referenceCode" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> ชื่อผู้นำเข้า  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_referenceName" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ความเกี่ยวพันกับผู้นำเข้า  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_wifehusband" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;">   </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_blank" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> สถานะภาพสมรส  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_marryStatus" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> ชื่อคู่สมรส  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_marryName" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> หมายเหตุ  </div>
                                        <div class="profile-info-value">
                                            <span id="tab1_remark" class="editable"></span>
                                        </div>
                                        <div class="profile-info-name" style="width:170px;"> <b>สถานะ  </b></div>
                                        <div class="profile-info-value">
                                            <span id="tab1_memberStatus" class="editable"><b></b></span>
                                        </div>
                                    </div>								
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane"  id="tab2">
                    <div class="row">
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <h3>ที่อยู่ตามทะเบียนบ้าน</h3>
                            </div>
                        </div>
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <form class="form-horizontal" role="form">
                                    <div class="profile-user-info profile-user-info-striped">
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ที่อยู่ </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentAddress" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> หมู่</div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentMoo" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ถนน </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentRoad" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ซอย</div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentSoi" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ตำบล/แขวง </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentSubdistrict" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> อำเภอ/เขต </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentDistrict" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> จังหวัด </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentProvince" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> รหัสไปรษณีย์ </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentZipCode" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> โทรศัพท์ </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentTel" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> มือถือ </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentMobile" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> Fax </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_permanentFax" class="editable"></span>
                                            </div>
                                        </div>
                                    </div>
                                </form>	
                            </div>
			</div>
                        <br>
                        <br>
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <h3>ที่อยู่ที่ติดต่อได้</h3>
                            </div>
                        </div>
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <form class="form-horizontal" role="form">
                                    <div class="profile-user-info profile-user-info-striped">
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ที่อยู่ </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_address" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> หมู่</div>
                                            <div class="profile-info-value">
                                                <span id="tab2_moo" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ถนน </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_road" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ซอย</div>
                                            <div class="profile-info-value">
                                                <span id="tab2_soi" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ตำบล/แขวง </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_subdistrict" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> อำเภอ/เขต </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_district" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> จังหวัด  </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_province" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> รหัสไปรษณีย์    </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_zipCode" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> โทรศัพท์  </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_tel" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> มือถือ  </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_moblie" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> Fax  </div>
                                            <div class="profile-info-value">
                                                <span id="tab2_fax" class="editable"></span>
                                            </div>
                                        </div>
                                    </div>
                                </form>	
                            </div>
                        </div>
                    </div>
                </div>
            
                <div class="tab-pane"  id="tab3">
                    <div class="col-xs-10">
			<div class="col-sm-8">
                            <form class="form-horizontal" role="form">
                                <div class="profile-user-info profile-user-info-striped">
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> เลขประจำตัวประชาชน </div>
                                        <div class="profile-info-value">
                                            <span id="tab3_citizenId" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ยศ - คำนำหน้า </div>
                                        <div class="profile-info-value">
                                            <span id="tab3_preName" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ชื่อผู้รับผลประโยชน์ </div>
                                        <div class="profile-info-value">
                                            <span id="tab3_name" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> สกุล </div>
                                        <div class="profile-info-value">
                                            <span id="tab3_surname" class="editable"></span>
                                        </div>
                                    </div>
                                    <div class="profile-info-row">
                                        <div class="profile-info-name" style="width:170px;"> ความเกี่ยวพันกับสมาชิก </div>
                                        <div class="profile-info-value">
                                            <span id="tab3_relation" class="editable"></span>
                                        </div>
                                    </div>
                                </div>
                            </form>	
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="row">
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <h3>ที่อยู่ตามทะเบียนบ้าน</h3>
                            </div>
                        </div>
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <form class="form-horizontal" role="form">
                                    <div class="profile-user-info profile-user-info-striped">
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ที่อยู่ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentAddress" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> หมู่</div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentMoo" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ถนน </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentRoad" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ซอย</div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentSoi" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ตำบล/แขวง </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentSubdistrict" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> อำเภอ/เขต </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentDistrict" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> จังหวัด </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentProvince" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> รหัสไปรษณีย์ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentZipCode" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> โทรศัพท์ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentTel" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> มือถือ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentMobile" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> Fax </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_permanentFax" class="editable"></span>
                                            </div>
                                        </div>
                                    </div>
                                </form>	
                            </div>
			</div>
                        <br>
                        <br>
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <h3>ที่อยู่ที่ติดต่อได้</h3>
                            </div>
                        </div>
                        <div class="col-xs-10">
                            <div class="col-sm-8">
                                <form class="form-horizontal" role="form">
                                    <div class="profile-user-info profile-user-info-striped">
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ที่อยู่ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_address" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> หมู่</div>
                                            <div class="profile-info-value">
                                                <span id="tab3_moo" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ถนน </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_road" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ซอย</div>
                                            <div class="profile-info-value">
                                                <span id="tab3_soi" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> ตำบล/แขวง </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_subdistrict" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> อำเภอ/เขต </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_district" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> จังหวัด </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_province" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> รหัสไปรษณีย์ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_zipCode" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> โทรศัพท์ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_tel" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> มือถือ </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_mobile" class="editable"></span>
                                            </div>
                                        </div>
                                        <div class="profile-info-row">
                                            <div class="profile-info-name" style="width:170px;"> Fax </div>
                                            <div class="profile-info-value">
                                                <span id="tab3_fax" class="editable"></span>
                                            </div>
                                        </div>
                                    </div>
                                </form>	
                            </div>
                        </div>
                    </div>		
                </div>
                
                <div class="tab-pane" id="tab4">
                    <div class="row">
                        <div class="col-xs-10">
                            <form class="form-horizontal" role="form">
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ประเภทการชำระเงิน </label>
                                    <div class="col-sm-9">
                                        <input type="text" class="col-xs-10 col-sm-5" id="tab4_paymentType" value="ชำระผ่านหน่วยต้นสังกัด" readonly="true">
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group"></div>
                            </form>
                        </div>
                    </div>
                    <div id="jqGridContainer_TAB4" class="row">
                        <div>
                            <table id="gridData_TAB4_CHT030Grid_List"></table>
                            <div id="gridPager_TAB4_CHT030Grid_List"></div>
                        </div>
                    </div>
                </div>
                
                <div class="tab-pane" id="tab5">										
                    <div class="row">
                        <div class="col-xs-10"> 
                            <a data-toggle="modal" class="blue" role="button" href="#modal-form"></a>
                        </div>
                    </div>
                    <div id="jqGridContainer_TAB5" class="row">
                        <div>
                            <table id="gridData_TAB5_CHT030Grid_List"></table>
                            <div id="gridPager_TAB5_CHT030Grid_List"></div>
                        </div>
                    </div>
                </div>
            
                <div class="tab-pane active" id="tab6">												
                    <div class="row">
                        <div class="col-xs-10">    
                            <form class="form-horizontal" role="form">
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่ขอเปลี่ยนแปลง </label>
                                    <div class="col-sm-3">
                                        <div class="input-group input-group-sm">
                                            <input type="text" class="form-control hasDatepicker" id="tab6_changeDate">
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> 
                                        </div>
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ประเภทการเปลี่ยนแปลง </label>
                                    <div class="col-sm-9">
                                        <select name="tab6_changeType" id="tab6_changeType" class="col-xs-8 col-sm-3">
                                            <option value="" selected="selected">-เลือก-&nbsp;</option>
                                            <option value="1">แจ้งด้วยตนเอง</option>
                                            <option value="2">แจ้งผ่านหน่วยต้นสังกัด</option>
                                        </select>
                                    </div>
                                </div>                     
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ขอเปลี่ยนแปลงข้อมูล </label>
                                    <div class="col-sm-9">
                                        <input name="tab6_rank_checkbox" id="tab6_rank_checkbox" type="checkbox" value="" onclick="rankChecked()">
                                            <span class="bigger-110">ยศ</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input name="tab6_title_checkbox" id="tab6_title_checkbox" type="checkbox" value="" onclick="titleChecked()">
                                            <span class="bigger-110">คำนำหน้า</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                        <input name="tab6_name_checkbox" id="tab6_name_checkbox" type="checkbox" value="" onclick="nameChecked()">
                                            <span class="bigger-110">ชื่อ</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                        <input name="tab6_surname_checkbox" id="tab6_surname_checkbox" type="checkbox" value="" onclick="surnameChecked()">
                                            <span class="bigger-110">สกุล</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ยศ </label>
                                    <div class="col-sm-9">
                                        <select name="tab6_rankId" id="tab6_rankId" class="col-xs-8 col-sm-3" disabled="true">
                                            <option value="" selected="selected">--เลือก--</option>
                                        </select>
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> คำนำหน้า </label>
                                    <div class="col-sm-9">
                                        <select name="tab6_titleId" id="tab6_titleId" class="col-xs-8 col-sm-3" disabled="true">
                                            <option value="" selected="selected">--เลือก--</option>
                                        </select>
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ชื่อ </label>
                                    <div class="col-sm-9">
                                        <input type="text" id="tab6_name" class="col-xs-10 col-sm-3" value="" disabled="true">
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> ชื่อสกุล </label>
                                    <div class="col-sm-9">
                                        <input type="text" id="tab6_surname" class="col-xs-10 col-sm-3" value="" disabled="true">
                                    </div>
                                </div>
                                <div style="margin-bottom:5px" class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> หมายเหตุ </label>
                                    <div class="col-sm-9">
                                        <textarea maxlength="200" id="tab6_ramark" class="form-control limited"></textarea>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="clearfix form-actions">
                <div class="col-md-offset-3 col-md-9">
                    <a href="#modal-form" role="button" class="blue" data-toggle="modal">
                        <button class="btn btn-white btn-info btn-bold" id="btn_CHT030_submit"> <i class="ace-icon fa fa-floppy-o bigger-120 blue"></i> ยืนยันการเปลี่ยนแปลง </button>
                    </a>&nbsp; &nbsp; &nbsp;
                    <button type="button" id="btn_CHT030_save" class="btn btn-info"> <i class="ace-icon fa fa-floppy-o bigger-110"></i> บันทึก </button>
                    &nbsp; &nbsp; &nbsp;
                    <button type="reset" class="btn"> <i class="ace-icon fa fa-undo bigger-110"></i> ยกเลิก </button>
                </div>
            </div>
        </div>
    </div>
</div>
