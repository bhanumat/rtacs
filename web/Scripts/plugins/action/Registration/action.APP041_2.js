/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    $('#txtDocDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtDocDate").datepicker("setDate", new Date());
    $('#subDateBegin').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#subDateEnd').datepicker({language: 'th', format: 'dd/mm/yyyy'});

    $("#btnBack").click(function(event) {
        onBackAPP041();
    });

    onBackAPP041 = function() {
        var typeAction = 'GET';
        var urlAction = urlAPP041;
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    };

    $("#dialogFormAddAPP041_2").removeClass('hide').dialog({
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

    onAddActionSearch = function() {
        //alert("onAddActionSearch");
        var search = {};
        var requestSearch = new Array();
        if ($('#subMemberCode').val().length != 0 && '' != $('#subMemberCode').val()) {
            var search2 = {'groupOp': 'and', 'field': 'm.member_code', 'op': 'cn', 'data': $('#subMemberCode').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        }
        if ($('#subCitizenId').val().length != 0 && '' != $('#subCitizenId').val()) {
            var search3 = {'groupOp': 'and', 'field': 'm.citizen_id', 'op': 'cn', 'data': $('#subCitizenId').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }
        if ($('#subName').val().length != 0 && '' != $('#subName').val()) {
            var search4 = {'groupOp': 'and', 'field': 'm.name', 'op': 'cn', 'data': $('#subName').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#subSurname').val().length != 0 && '' != $('#subSurname').val()) {
            var search5 = {'groupOp': 'and', 'field': 'm.surname', 'op': 'cn', 'data': $('#subSurname').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#subDateBegin').val().length != 0 && $('#subDateEnd').val().length != 0) {
            var search1 = {'groupOp': 'and', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#subDateBegin').val() + "," + $('#subDateEnd').val(), 'dataType': 'date'};
            requestSearch.push(search1);
        } else {
            if ($('#subDateBegin').val().length != 0) {
                var search1 = {'groupOp': 'and', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#subDateBegin').val() + "," + $('#subDateBegin').val(), 'dataType': 'date'};
                requestSearch.push(search1);
            } else {
                if ($('#subDateEnd').val().length != 0) {
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

        if ($('#subMilitary').val().length != 0) {
            var search6 = {'groupOp': 'and', 'field': 'm.military_id', 'op': 'eq', 'data': $('#subMilitary').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }
        if ($('#subMemberTypeCode').val().length != 0) {
            var search7 = {'groupOp': 'and', 'field': 'm.member_type_code', 'op': 'eq', 'data': $('#subMemberTypeCode').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }

        search.conditions = requestSearch;

        $(gridNameAddAPP041_2).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridNameAddAPP041_2).trigger("reloadGrid", [{page: 1}]);
    };

    $("#btnSubSearch").click(function(e) {
        e.preventDefault();
        onAddActionSearch();
    });

    $("#btnSubReset").click(function(e) {
        e.preventDefault();
        $("#subDateBegin").val("");
        $("#subDateEnd").val("");
        $("#subMemberCode").val("");
        $("#subCitizenId").val("");
        $("#subName").val("");
        $("#subSurname").val("");
        $("#subMilitary").val("");
        $("#subMemberTypeCode").val("");
    });

    $("#btnAdd").click(function(e) {
        $("#dialogFormAddAPP041_2").dialog("open");
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

    onRefreshGrid = function() {
        $('#gridData_APP041_2jqGrid_List').setGridParam({
            datatype: 'jsonstring',
            datastr: myStringList
        }).trigger("reloadGrid");
    };

    onClearGrid = function() {
        listAPP041 = [];
        myStringList = {};
    };

    onDeleteRow = function(rowid) {
        listAPP041.splice(rowid, 1);
        var tempJqGridData = {};
        tempJqGridData.total = 1;
        tempJqGridData.page = 1;
        tempJqGridData.records = listAPP041.length;
        tempJqGridData.rows = listAPP041;
        myStringList = $.toJSON(tempJqGridData);
        onRefreshGrid();
    };


    onSelectData = function() {
        var dialogForm = '#dialogFormAddAPP041_2';
        var myGrid = $('#gridData_APP041_2_Add_jqGrid_List');
        var ids = myGrid.jqGrid('getGridParam', 'selarrrow');
        listAPP041 = [];
        if (ids.length > 0) {
            for (var i = 0, il = ids.length; i < il; i++) {
                var rowObject = myGrid.getRowData(ids[i]);
                // let's use the prototype for now
                var i = listAPP041.inArray(rowObject.memberId, "memberId");
                if (i === -1) {
                    listAPP041.push(rowObject);
                }
            }
            var jqGridData = {};
            jqGridData.total = 1;
            jqGridData.page = 1;
            jqGridData.records = listAPP041.length;
            jqGridData.rows = listAPP041;
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
                    onBackAPP041();
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
        if ($('#txtDocDate').val().length > 0 && $('#txtDocCode').val().length > 0) {
            if (listAPP041.length > 0) {
                $("#Dialog-Confirm").html("คุณต้องการบันทึกข้อมูลนี้ใช่หรือไม่?");
                $("#Dialog-Confirm").dialog({
                    buttons: [
                        {
                            html: "<i class='ace-icon fa fa-floppy-o bigger-110'></i>&nbsp; บันทึก",
                            "class": "btn btn-danger btn-xs",
                            click: function() {
                                var i = 0;
                                for (var item in listAPP041) {
                                    var itemData = listAPP041[item];
                                    //alert("memberId : >>" + itemData.memberId + "<<");
                                    ids[i] = itemData.memberId;
                                    i++;
                                    if (i >= listAPP041.length)
                                        break;
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
        } else {
            $("#Dialog-Warning").html("กรุณาทำการกรอกข้อมูลให้ครบถ้วน");
            $("#Dialog-Warning").dialog("open");
        }
    });

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();


        var search1 = {'groupOp': '', 'field': 'm.name', 'op': 'cn', 'data': $('#txtNameSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search1);

        if ($('#txtCitizenIdSearch').val().length !== 0) {
            if ($('#txtCitizenIdSearch').val().length === 13) {
                var search2 = {'groupOp': 'and', 'field': 'm.citizen_id', 'op': 'eq', 'data': $('#txtCitizenIdSearch').val(), 'dataType': 'varchar'};
                requestSearch.push(search2);
            } else {
                $("#Dialog-Confirm").html("กรุณากรอกรหัสประชาชนเป็น 13 หลักเท่านั้น");
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
                return;
            }
        }

        var search3 = {'groupOp': 'and', 'field': 'm.surname', 'op': 'cn', 'data': $('#txtSurnameSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search3);

        if ($('#txtApplyDateFromSearch').val().length !== 0 && $('#txtApplyDateEndSearch').val().length !== 0) {
            var search4 = {'groupOp': 'and', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#txtApplyDateEndSearch').val(), 'dataType': 'date'};
            requestSearch.push(search4);
        } else {
            if ($('#txtApplyDateFromSearch').val().length !== 0) {
                var search5 = {'groupOp': 'and', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#txtApplyDateFromSearch').val(), 'dataType': 'date'};
                requestSearch.push(search5);
            } else {
                if ($('#txtApplyDateEndSearch').val().length !== 0) {
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

        if ('%' !== $('#slMilitaryDepartmentSearch').val()) {
            var search6 = {'groupOp': 'and', 'field': 'm.military_id', 'op': 'eq', 'data': $('#slMilitaryDepartmentSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }

        if ('%' !== $('#slApplyTypeSearch').val()) {
            var search7 = {'groupOp': 'and', 'field': 'm.member_type_code', 'op': 'eq', 'data': $('#slApplyTypeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }

        if ('%' !== $('#slMemberTypeCodeSearch').val()) {
            var search8 = {'groupOp': 'and', 'field': 'm.member_group_code', 'op': 'eq', 'data': $('#slMemberTypeCodeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search8);
        }

        if ('%' !== $('#slMemberStatusCodeSearch').val()) {
            var search9 = {'groupOp': 'and', 'field': 'm.member_status_code', 'op': 'eq', 'data': $('#slMemberStatusCodeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search9);
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
                if (msg.checkSuccess === true && msg.obj != null) {
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
        if ($('#operationId').val() != null && $('#operationId').val() != "") {
            document.getElementById("txtDocDate").disabled = true;
            document.getElementById("txtDocCode").disabled = true;
            $('#btnAdd').hide();
            $('#btnSave').hide();
            $('#btnCancel').hide();
        } else {
            onActionLoadMilitaryDepartment();
            onActionLoadNewMilitaryDepartment();
            $('#btnPrintRegister').hide();
            $('#btnPrintSummary').hide();
        }
    };

    onInit();
});
