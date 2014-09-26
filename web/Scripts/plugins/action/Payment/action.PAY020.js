$(function() {
    var responseId = '#main-page-content-loading';
    var operationMemberIdList = {};
    $('#date_begin').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#date_end').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    var controlButton = function(element) {
        $('ul li').each(function(i)
        {
            $(this).removeClass();
            $(this).addClass('hover');
            //$(this).attr('rel'); // This is your rel value
        });
        $('#'+element).addClass('active open');
    };
    
    var controlEditButton = function(element) {
        $('ul li').each(function(i)
        {
            $(this).removeClass();
            $(this).addClass('hover');
            $(this).attr('rel'); // This is your rel value
        });
        $('#'+element).addClass('active open');
    };
    
    $("#dialogFormReason").removeClass('hide').dialog({
        width: '600px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> ยกเลิกใบเสร็จ</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึก",
                "class": "btn btn-primary btn-xs",
                click: function() {
                    $(this).dialog("close");
                    onDialogCancel(operationMemberIdList);
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    $(this).dialog("close");
                }
            }
        ]
    });
    
    onDialogEdit = function(id) {
        //alert("id : >>" + id + "<<");
        $('#operationMemberId').val(id);
        //alert("operationMemberId : >>" + $('#operationMemberId').val() + "<<");
        //controlEditButton('menuPayment');
        var typeAction = 'POST';
        var urlAction = rootPath + '/Plugins/Payment/TOPAY020_1.htm';
        var objDataAction = {operationMemberId:$('#operationMemberId').val()};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        //e.preventDefault();
    };
    
    onActionLoad = function(id) {
        var iArray = 0;
        var objData = {};
        objData[objIdKeyEdit] = id;
        $.ajax({
            type: 'POST',
            url: urlLoad,
            data: objData,
            dataType: 'json',
            async: false,
            success: function(objectResponse) {
                objectDefault = objectResponse;
                $.map(inputToChangeEdit, function(getData) {
                    //console.info("" + getData + ":" + objectResponse[getData]);
                    if (inputToMergeEdit[iArray].toLowerCase().indexOf(':checked') >= 0) {
                        if (objectResponse[getData] === 'E') {
                            $(inputToMergeEdit[iArray].replace(/:checked/g, '')).prop('checked', true);
                        } else {
                            $(inputToMergeEdit[iArray].replace(/:checked/g, '')).prop('checked', false);
                        }
                    } else {
                        $(inputToMergeEdit[iArray]).val(objectResponse[getData]);
                    }
                    iArray++;
                });
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

    };

    onActionSearch = function() {
        //alert("military >>" + $('#military').val() + "<<");
        //alert("memberTypeCode >>" + $('#memberTypeCode').val() + "<<");
        var search = {};
        var requestSearch = new Array();
        if ($('#date_begin').val().length !== 0 && $('#date_end').val().length !== 0) {
            var search1 = {'groupOp': '', 'field': 'docDate', 'op': 'bw', 'data': $('#date_begin').val() +","+ $('#date_end').val(), 'dataType': 'date' };
            requestSearch.push(search1);
        }else{
            if ($('#date_begin').val().length !== 0) {
                var search1 = {'groupOp': '', 'field': 'docDate', 'op': 'bw', 'data': $('#date_begin').val(), 'dataType': 'date' };
                requestSearch.push(search1);
            }else{
                if ($('#date_end').val().length !== 0) {
                        $("#Dialog-Confirm").html("กรุณากรอกข้อมูลค้นหาวันที่ชำระเงิน");
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
        
        if ($('#citizenId').val().length !== 0) {
            if($('#citizenId').val().length === 13){
                var search3 = {'groupOp': '', 'field': 'citizenId', 'op': 'eq', 'data': $('#citizenId').val(), 'dataType': 'varchar'};
                requestSearch.push(search3);
            }else{
                alert("กรุณากรอกเลขประจำตัวประชาชนให้ครบ 13 หลัก");
            }
        }
        if ($('#name').val().length !== 0) {
            var search4 = {'groupOp': '', 'field': 'name', 'op': 'eq', 'data': $('#name').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#surname').val().length !== 0) {
            var search5 = {'groupOp': '', 'field': 'surname', 'op': 'eq', 'data': $('#surname').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#memberTypeCode').val().length !== 0) {
            var search6 = {'groupOp': '', 'field': 'memberTypeCode', 'op': 'eq', 'data': $('#memberTypeCode').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }
        if ($('#memberGroupCode').val().length !== 0) {
            var search7 = {'groupOp': '', 'field': 'memberGroupCode', 'op': 'eq', 'data': $('#memberGroupCode').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }
        if ($('#printedStatus').val().length !== 0) {
            var search8 = {'groupOp': '', 'field': 'printedStatus', 'op': 'eq', 'data': $('#printedStatus').val(), 'dataType': 'char'};
            requestSearch.push(search8);
        }
        if ($('#military').val().length !== 0) {
            var search8 = {'groupOp': '', 'field': 'militaryId', 'op': 'eq', 'data': $('#military').val(), 'dataType': 'integer'};
            requestSearch.push(search8);
        }
        
        search.conditions = requestSearch;
       
        $(gridName).jqGrid('setGridParam', {
            search: true,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
    };

    onDialogDelete = function(id) {
        $("#Dialog-Confirm").html("คุณต้องการลบข้อมูลนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").removeClass('hide').dialog({
            width: '300px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> ลบข้อมูล</h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ลบข้อมูล",
                    "class": "btn btn-primary btn-xs",
                    click: function() {
                        var objData = {};
                        objData.ItemSelect = id;//JSON.stringify(ids);
                        onActionDelete(this, objData);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function() {
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionDelete = function(thisDialog, objData) {
        $.ajax({
            type: 'POST',
            url: urlDelete,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                $.fn.DialogMessage(msg);
                if (msg.checkSuccess === true) {
                    onActionSearch();
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

        $(thisDialog).dialog("close");
    };
    
    onDialogCancel = function(id) {
        $("#Dialog-Confirm").html("คุณต้องการยกเลิกใบเสร็จนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").removeClass('hide').dialog({
            width: '500px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-trash'></i> ยกเลิกใบเสร็จ</h4></div>",
            title_html: true,
            autoOpen: true,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; ยกเลิกใบเสร็จ",
                    "class": "btn btn-primary btn-xs",
                    click: function() {
                        var objData = {};
                        objData.ItemSelect = id;
                        objData.dataSource = $("#cancelReason").val();
                        //alert("reason : >>" + $("#cancelReason").val() + "<<");
                        onActionCancel(this, objData);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ไม่ยกเลิกใบเสร็จ",
                    "class": "btn btn-xs",
                    click: function() {
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };
    
    onActionCancel = function(thisDialog, objData) {
        $.ajax({
            type: 'POST',
            url: urlCancel,
            data: objData,
            dataType: 'json',
            async: true,
            success: function(msg) {
                $.fn.DialogMessage(msg);
                if (msg.checkSuccess === true) {
                    onActionSearch();
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

        $(thisDialog).dialog("close");
    };
    
//    $("#military").select2({
//        //placeholder: '-เลือก-',
//        allowClear: true
//        //minimumInputLength: 1
//    });
//    
//    $("#memberTypeCode").select2({
//        //placeholder: '-เลือก-',
//        allowClear: true
//        //minimumInputLength: 1
//    });
//    
//    $("#memberGroupCode").select2({
//        //placeholder: '-เลือก-',
//        allowClear: true
//        //minimumInputLength: 1
//    });
//    
//    $("#printedStatus").select2({
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
        $('#military').empty();
    };
    
    onActionClearNewMemberTypeCode = function() {
        $('#memberTypeCode').empty();
    };

    onActionLoadNewMilitaryDepartment = function() {
        onActionClearNewMilitaryDepartment();
        $('#military').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#military').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };
    
    onDialogReasonForm = function(e) {
        e.preventDefault();
        
        var ids = $(gridName).jqGrid('getDataIDs');
        var result = "";
        var flag = "";
        var operationMemberId = {};
        var index = 0;
        for (var i = 0; i < ids.length; i++) {
            var id = ids[i];
            var c = $(gridName).jqGrid('getCell', ids[i], 'checked');
            result = result + " , " + id;
            flag = flag + " , " + c;
            if(c === "True"){
                operationMemberId[index] = id;
                index = index+1;
            }
        }
        var temp = "";
        for(var i = 0;i<index;i++){
            temp = temp + " ," + operationMemberId[i];
        }
        if(index>0){
            //alert("operationMemberId : >>" + temp + "<<");
            operationMemberIdList = operationMemberId;
            $("#dialogFormReason").dialog("open");
            //onDialogCancel(operationMemberId);
        }
        else{
            $("#Dialog-Confirm").html("กรุณาเลือกอย่างน้อย 1 รายการ");
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
    };
    
    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });

    $("#btnCancel").click(function(event) {
        event.preventDefault();
        $('#cancelReason').val('');
        //$("#dialogFormReason").dialog("open");
        onDialogReasonForm(event);
    });
    
    $("#btnAdd").click(function(e) {
        
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PAY020_1.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });
    
    $("#btnReset").click(function(e) {
        //window.location.reload();
    });
    
    onInit = function() {
        onActionLoadMilitaryDepartment();
        onActionLoadNewMilitaryDepartment();

    };

    onInit();
});