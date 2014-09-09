/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    $('#txtDocDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#date_begin').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#date_end').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    
    $("#dialogFormAdd").removeClass('hide').dialog({
        width: '1000px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> เรียกค้นข้อมูลสมาชิก </h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-check'></i>&nbsp; เลือก",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    onSelectData();
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ไม่เลือก",
                "class": "btn btn-xs",
                click: function() {
                    $(this).dialog("close");
                }
            }
        ]
    });
    
   onAddActionSearch = function(){
       //alert("onAddActionSearch");
        var search = {};
        var requestSearch = new Array();
        if ($('#date_begin').val().length != 0 && $('#date_end').val().length != 0) {
            var search1 = {'groupOp': '', 'field': 'apply_date', 'op': 'bw', 'data': $('#date_begin').val() +","+ $('#date_end').val(), 'dataType': 'date' };
            requestSearch.push(search1);
        }else{
            if ($('#date_begin').val().length != 0) {
                var search1 = {'groupOp': '', 'field': 'apply_date', 'op': 'bw', 'data': $('#date_begin').val(), 'dataType': 'date' };
                requestSearch.push(search1);
            }else{
                if ($('#date_end').val().length != 0) {
                        $("#Dialog-Confirm").html("กรุณากรอกข้อมูลค้นหาวันที่สมัคร");
                        $("#Dialog-Confirm").removeClass('hide').dialog({
                            width: '300px',
                            resizable: false,
                            modal: true,
                            title: "<div class='widget-header'><h4 class='smaller'> แจ้งเตือน</h4></div>",
                            title_html: true,
                            autoOpen: true,
                            buttons: [
                                {
                                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ปิด",
                                    "class": "btn btn-xs",
                                    click: function() {
                                        $(this).dialog("close");
                                    }
                                }
                            ]
                        });
                }
            }
        }
        if ($('#subMemberCode').val().length != 0) {
            var search2 = {'groupOp': '', 'field': 'member_code', 'op': 'eq', 'data': $('#subMemberCode').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        }
        if ($('#subCitizenId').val().length != 0) {
            var search3 = {'groupOp': '', 'field': 'citizen_id', 'op': 'eq', 'data': $('#subCitizenId').val(), 'dataType': 'integer'};
            requestSearch.push(search3);
        }
        if ($('#subName').val().length != 0) {
            var search4 = {'groupOp': '', 'field': 'name', 'op': 'eq', 'data': $('#subName').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#subSurname').val().length != 0) {
            var search5 = {'groupOp': '', 'field': 'surname', 'op': 'eq', 'data': $('#subSurname').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#subMilitary').val().length != 0) {
            var search6 = {'groupOp': '', 'field': 'military_id', 'op': 'eq', 'data': $('#subMilitary').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }
        if ($('#subMemberTypeCode').val().length != 0) {
            var search7 = {'groupOp': '', 'field': 'member_type_code', 'op': 'eq', 'data': $('#subMemberTypeCode').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }
        
        search.conditions = requestSearch;
       
        $(gridNameAdd).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridNameAdd).trigger("reloadGrid", [{page: 1}]);
    };
    
    $("#btnSubSearch").click(function(e) {
        e.preventDefault();
        onAddActionSearch();
    });
    
    $("#btnSubReset").click(function(e) {
        e.preventDefault();
        $("#date_begin").val("");
        $("#date_end").val("");
        $("#subMemberCode").val("");
        $("#subCitizenId").val("");
        $("#subName").val("");
        $("#subSurname").val("");
        $("#subMilitary").val("");
        $("#subMemberTypeCode").val("");
    });
    
    $("#btnAdd").click(function(e) {
        $("#dialogFormAdd").dialog("open");
    });

    $("#btnCancel").click(function(e) {
        $("#Dialog-Confirm").html("คุณต้องการยกเลิกข้อมูลนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").dialog({
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; ทำการยกเลิก",
                    "class": "btn btn-danger btn-xs",
                    click: function() {
                        //onClearGrid();
                        //onRefreshGrid();
                        $(this).dialog("close");
                    }
                },
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; หยุดการยกเลิก",
                    "class": "btn btn-xs",
                    click: function() {
                        $(this).dialog("close");
                    }
                }
            ]
        });
        $("#Dialog-Confirm").dialog("open");
    });

    $("#btnBack").click(function(e) {
        
        onClearGrid();
        $('#gridData_APP031_2_Add_jqGrid_List').jqGrid("clearGridData", true).trigger("reloadGrid");
        //onDialogNew(event);
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP031.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    onRefreshGrid = function() {
        $('#gridData_APP031_2jqGrid_List').setGridParam({
            datatype: 'jsonstring',
            datastr: myStringList
        }).trigger("reloadGrid");
    };

    onClearGrid = function() {
        listAPP031 = [];
        myStringList = {};
    };

    onDeleteRow = function(rowid) {
        listAPP031.splice(rowid,1);
        var tempJqGridData = {};
        tempJqGridData.total = 1;
        tempJqGridData.page = 1;
        tempJqGridData.records = listAPP031.length;
        tempJqGridData.rows = listAPP031;
        myStringList = $.toJSON(tempJqGridData);
        onRefreshGrid();
    };
    

    onSelectData = function() {
        var dialogForm = '#dialogFormAdd';
        var myGrid = $('#gridData_APP031_2_Add_jqGrid_List');
        var ids = myGrid.jqGrid('getGridParam', 'selarrrow');
        //listAPP031 = [];
        if (ids.length > 0) {
            for (var i = 0, il = ids.length; i < il; i++) {
                var rowObject = myGrid.getRowData(ids[i]);
                // let's use the prototype for now
                var i = listAPP031.inArray(rowObject.memberId, "memberId");
                if (i === -1) {
                    listAPP031.push(rowObject);
                }
            }
            var jqGridData = {};
            jqGridData.total = 1;
            jqGridData.page = 1;
            jqGridData.records = listAPP031.length;
            jqGridData.rows = listAPP031;
            myStringList = $.toJSON(jqGridData);
            onRefreshGrid();
            $(dialogForm).dialog("close");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    };

    onActionSaveNew = function(thisDialog, objData, ids) {
        var data = {};
        data.dataSource = $.toJSON(objData);
        data.ItemSelect = ids;
        //console.info(data);
        $.ajax({
            type: 'POST',
            url: urlSaveNew,
            data: data,
            dataType: 'json',
            async: true,
            success: function(msg) {
                $.fn.DialogMessage(msg);
                if (msg.checkSuccess === true) {
                    $("#operationId").val(msg.id);
                    onActionSearch();
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

        $(thisDialog).dialog("close");
    };

    $("#btnSave").click(function(event) {
        event.preventDefault();
        var ids = {};
        if($('#txtDocDate').val().length > 0 && $('#txtDocCode').val().length > 0){
            if (listAPP031.length > 0) {
                $("#Dialog-Confirm").html("คุณต้องการบันทึกข้อมูลนี้ใช่หรือไม่?");
                $("#Dialog-Confirm").dialog({
                    buttons: [
                        {
                            html: "<i class='ace-icon fa fa-floppy-o bigger-110'></i>&nbsp; บันทึก",
                            "class": "btn btn-danger btn-xs",
                            click: function() {
                                var i = 0;
                                for (var item in listAPP031) {
                                    var itemData = listAPP031[item];
                                    //alert("memberId : >>" + itemData.memberId + "<<");
                                    ids[i] = itemData.memberId;
                                    i++;
                                    if(i >= listAPP031.length)break;
                                }
                                var objData = {};
                                objData.docDate = $('#txtDocDate').val();
                                objData.docCode = $('#txtDocCode').val();
                                onActionSaveNew(this, objData, ids);
                            }
                        },
                        {
                            html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                            "class": "btn btn-xs",
                            click: function() {
                                $(this).dialog("close");
                            }
                        }
                    ]
                });
                $("#Dialog-Confirm").dialog("open");
            } else {
                $("#Dialog-Warning").html("กรุณาทำการเลือกสมาชิกใหม่");
                $("#Dialog-Warning").dialog("open");
            }
        }else{
            $("#Dialog-Warning").html("กรุณาทำการกรอกข้อมูลให้ครบถ้วน");
                $("#Dialog-Warning").dialog("open");
        }
    });
    
    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        
        if ($('#operationId').val().length != 0) {
            var search1 = {'groupOp': '', 'field': 'operationId', 'op': 'eq', 'data': $('#operationId').val(), 'dataType': 'integer'};
            requestSearch.push(search1);
        }
        
        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
        var objData = {};
        objData.ItemSelect = $('#operationId').val();
        $.ajax({
            type: 'POST',
            url: urlSearchOperationId,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                if (msg.checkSuccess === true && msg.obj!=null) {
                    var object = msg.obj;
                    $("#txtDocCode").val(object.docCode);
                    $("#txtDocDate").val(object.dateString);
                    document.getElementById("txtDocDate").disabled = true;
                    document.getElementById("txtDocCode").disabled = true;
                    $('#btnAdd').hide();
                    $('#btnSave').hide();
                    $('#btnCancel').hide();
                    
                    $('#btnPrintRegister').show();
                    $('#btnPrintSummary').show();
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };
    
//    $("#subMilitary").select2({
//        //placeholder: '-เลือก-',
//        allowClear: true
//        //minimumInputLength: 1
//    });
//    
//    $("#subMemberTypeCode").select2({
//        //placeholder: '-เลือก-',
//        allowClear: true
//        //minimumInputLength: 1
//    });
    
    onActionLoadMilitaryDepartment = function() {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonMilitaryDepartment,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function(json) {
                listMilitaryDepartment = json;
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function(jqXHR) {
            }
        });
    };

    onActionClearNewMilitaryDepartment = function() {
        $('#subMilitary').empty();
    };
    
    onActionClearNewMemberTypeCode = function() {
        $('#subMemberTypeCode').empty();
    };

    onActionLoadNewMilitaryDepartment = function() {
        onActionClearNewMilitaryDepartment();
        $('#subMilitary').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#subMilitary').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };
    
    onInit = function() {
        if($('#operationId').val()!=null && $('#operationId').val() !=""){
            document.getElementById("txtDocDate").disabled = true;
            document.getElementById("txtDocCode").disabled = true;
            $('#btnAdd').hide();
            $('#btnSave').hide();
            $('#btnCancel').hide();
        }else{
            onActionLoadMilitaryDepartment();
            onActionLoadNewMilitaryDepartment();
            $('#btnPrintRegister').hide();
            $('#btnPrintSummary').hide();
        }
    };

    onInit();
});
