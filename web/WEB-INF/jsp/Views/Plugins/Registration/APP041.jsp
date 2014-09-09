<%-- 
    Document   : APP041
    Created on : Aug 16, 2014, 1:31:08 PM
    Author     : ITOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var urlList = rootPath + '/Plugins/Registration/getListAPP041.json';
    var responseId = '#main-page-content-loading';

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/action/Registration/action.APP041.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/Scripts/plugins/jqgrid/Registration/jqgrid.APP041.js"></script> 
<div class="page-header">
    <h1>
        รับสมัคร
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            ขออนุมัติขึ้นทะเบียนสมาชิกใหม่ 
        </small>
    </h1>
</div><!-- /.page-header -->


<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <input type="hidden" name="operationId" id="operationId" />
        <div id="ListView" class="row">
            <div class="col-xs-12">
                <div class="row">
                    <form id="frmCriterionSearch" class="form-horizontal">                          
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> วันที่ขออนุมัติ</label>
                            <div class="col-sm-5">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="date_begin" class="form-control"/>
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                                    </div>
                                    <div class="col-xs-5">
                                        <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> ถึง&nbsp;&nbsp;</label>
                                        <div class="input-group input-group-sm">
                                            <input type="text" id="date_end" class="form-control" />
                                            <span class="input-group-addon"> <i class="ace-icon fa fa-calendar"></i> </span> </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <br>
                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> เลขที่อ้างอิงขออนุมัติ  </label>
                            <div class="col-sm-6">
                                <input type="text" id="docCode" class="col-xs-8 col-sm-3"/>    
                            </div>                                

                        </div>
                        <div class="row">
                            <div class="form-group" >

                                <div class="col-sm-3"></div>
                                <div class="col-sm-3">
                                    <button type="button" id="btnSearch" name="btnSearch" class="btn btn-sm btn-purple"><i class="ace-icon fa fa-search"></i>&nbsp;ค้นหา</button>
                                    <button type="reset" class="btn btn-sm btn-primary"><i class="ace-icon fa fa-retweet"></i>&nbsp;ล้าง</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <br/>
                <div class="row">
                    <div>
                        <button id="btnAdd" type="button" class="btn btn-sm btn-success" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp;เพิ่มรายการใหม่</button>

                    </div>
                </div>
                <div style="padding:1px"></div>
                
                <div id="jqGridContainer" class="row">
                    <div>
                        <table id="gridData_APP041jqGrid_List"></table>
                        <div id="gridPager_APP041jqGrid_List"></div>
                    </div>
                </div>
                
<!--                <div class="row">
                    
                    <table id="sample-table-1" class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th class="center"><input type="checkbox" name="checkbox" id="checkbox">
                                    <label for="checkbox"></label></th>
                                <th class="center">ลำดับที่</th>
                                <th>วันที่ขออนุมัติ</th>
                                <th>เลขที่อ้างอิง</th>
                                <th>จำนวนสมาชิก</th>
                                <th>สถานะ</th>
                                <th>วันที่ยืนยันอนุมัติ</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="center"><input type="checkbox" name="checkbox2" id="checkbox2"></td>
                                <td class="center">1</td>
                                <td>20 มิ.ย. 57</td>
                                <td>ขอ.20/06/57</td>
                                <td>7</td>
                                <td>ยื่นอนุมัติขึ้นทะเบียนสมาชิก</td>
                                <td></td>
                                <td class="center"><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                            <button class="btn btn-xs btn-info" id="btnDialog"><i class="ace-icon fa fa-pencil bigger-120"></i></button>
                                        </a> <a href="" role="button" class="blue" data-toggle="modal">
                                            <button class="btn btn-xs btn-danger" id="btnDialog"><i class="ace-icon fa fa-trash-o bigger-120"></i></button>
                                        </a></div>
                                </td>
                            </tr>
                            <tr>
                                <td class="center"><input type="checkbox" name="checkbox3" id="checkbox3"></td>
                                <td class="center">2</td>
                                <td>18 มิ.ย. 57</td>
                                <td>ขอ.18/06/57</td>
                                <td>18</td>
                                <td>ยื่นอนุมัติขึ้นทะเบียนสมาชิก</td>
                                <td></td>
                                <td class="center"><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                            <button class="btn btn-xs btn-search" id="btnDialog"><i class="ace-icon fa fa-search bigger-120"></i></button>
                                        </a> </div>
                                </td>	
                            </tr>
                            <tr>
                                <td class="center"><input type="checkbox" name="checkbox4" id="checkbox4"></td>
                                <td class="center">3</td>
                                <td>10 มิ.ย. 57</td>
                                <td>ขอ.10/06/57</td>
                                <td>30</td>
                                <td>อนุมัติขึ้นทะเบียนสมาชิก</td>
                                <td>20 มิ.ย. 57</td>
                                <td class="center"><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                            <button class="btn btn-xs btn-search" id="btnDialog"><i class="ace-icon fa fa-search bigger-120"></i></button>
                                        </a> </div>
                                </td>	
                            </tr>
                            <tr>
                                <td class="center"><input type="checkbox" name="checkbox5" id="checkbox5"></td>
                                <td class="center">4</td>
                                <td>8 มิ.ย. 57</td>
                                <td>ขอ.8/06/57</td>
                                <td>9</td>
                                <td>อนุมัติขึ้นทะเบียนสมาชิก</td>
                                <td>20 มิ.ย. 57</td>
                                <td class="center"><div class="hidden-sm hidden-xs btn-group"> <a href="#" role="button" class="blue" data-toggle="modal">
                                            <button class="btn btn-xs btn-search" id="btnDialog"><i class="ace-icon fa fa-search bigger-120"></i></button>
                                        </a> </div>
                                </td>	
                            </tr>
                        </tbody>
                    </table>
                </div>-->
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