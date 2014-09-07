$(function() {
//    var tabMainName = '#tabMainMember';
//    $(tabMainName).tabs();
//    $('.ui-tabs-panel').removeClass();
//    $(tabMainName).tabs("option", "active", 0);
//    
    $("#btnCummit").click(function(event) {
        var selRowIds = $(gridName).jqGrid('getGridParam', 'selarrrow');
        //var myGrid = $('#gridData_ExjqGrid_List');
        //var $selRadio = $('input[name=jqg_gridData_ExjqGrid_List_' + myGrid[0].id + ']:radio:checked'), $tr;
        if (selRowIds.length > 0) {   //alert(selRowIds[0].toString());         
            onDialogNew(event);            
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกข้อมูล");
            $("#Dialog-Warning").dialog("open");
        } 
    });

    $("#dialogFormNew").removeClass('hide').dialog({
        width: '600px',
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-file'></i> ยืนยันการอนุมัติขึ้นทะเบียนสมาชิกใหม่</h4></div>",
        title_html: true,
        autoOpen: false,
        buttons: [
            {
                html: "<i class='ace-icon fa fa-floppy-o'></i>&nbsp; บันทึก",
                "class": "btn btn-primary btn-xs",
                click: function() {      
                    var operId = "";
                    var memId = "";
                    selId = $(gridName).jqGrid('getGridParam','selarrrow');
                    for(var i = 0; i < selId.length; i++){
                        var data = $(gridName).jqGrid('getRowData',selId[i]);
                        operId += data.operationId;
                        operId += ",";
                        memId += data.memberId;
                        memId += ",";
                    }                    
                    //alert("Status ->"+operId);
                    onActionSaveNew(operId, memId);
                }
            }
            ,
            {
                html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                "class": "btn btn-xs",
                click: function() {
                    var formId = '#frmNew';
                    var formName = $(formId);
                    $(formName)[0].reset();
                    $(this).dialog("close");
                }
            }
        ]
    });

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
        $('#slMilitaryIdSearch').empty();
        $('#slMilitaryIdSearch').append('<option value="%">ทั้งหมด</option>');
    };

    onActionLoadSearchMilitaryDepartment = function() {
        onActionClearNewMilitaryDepartment();
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#slMilitaryIdSearch').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        var search1 = {'groupOp': '', 'field': 'docCode', 'op': 'cn', 'data': $('#txtReferNumber').val(), 'dataType': 'varchar'};
        requestSearch.push(search1);
        var search2 = {'groupOp': 'and', 'field': 'memberCode', 'op': 'cn', 'data': $('#txtNumberMember').val(), 'dataType': 'varchar'};
        requestSearch.push(search2);
        var search3 = {'groupOp': 'and', 'field': 'citizenId', 'op': 'cn', 'data': $('#txtCardID').val(), 'dataType': 'varchar'};
        requestSearch.push(search3);
        var search4 = {'groupOp': 'and', 'field': 'name', 'op': 'cn', 'data': $('#txtFirstName').val(), 'dataType': 'varchar'};
        requestSearch.push(search4);
        var search5 = {'groupOp': 'and', 'field': 'surname', 'op': 'cn', 'data': $('#txtLastName').val(), 'dataType': 'varchar'};
        requestSearch.push(search5);
        if ('%' !== $('#slMilitaryIdSearch').val()) {
            var search6 = {'groupOp': 'and', 'field': 'militaryId', 'op': 'cn', 'data': $('#slMilitaryIdSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }
        if ('%' !== $('#slTypeApplySearch').val()) {
            var search7 = {'groupOp': 'and', 'field': 'memberTypeCode', 'op': 'cn', 'data': $('#slTypeApplySearch').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }
        /*
        var search8 = {'groupOp': 'and', 'field': 'operationTypeCode', 'op': 'eq', 'data': 25, 'dataType': 'integer'};
        requestSearch.push(search8);
        */
        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: true,
            postData: {
                /*searchField: "bankName",
                 searchOper: "cn",
                 searchString: $('#txtBankName').val(),*/

                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);
    };
    
    onActionSaveNew = function(operId, memId) {
        var formId = '#frmNew';
        var formName = $(formId);
        var iArray = 0;
        var objData = {};
        var objId = {};
        //var ids = $(gridName).jqGrid('getGridParam', 'selarrrow');
                        
        if ($(formId).validationEngine('validate'))
        {
            $.map(inputToMergeEdit, function(inputData) {
                var valueData = $(inputData).val();
                //console.info("inputData:" + inputData);
                if (inputData.toLowerCase().indexOf(":checked") >= 0) {
                    if (inputData.indexOf("chkStatusNew") >= 0) {
                        if ($('#chkStatusNew').is(':checked')) {
                            valueData = 'E';
                        } else {
                            valueData = 'D';
                        }
                    } else {
                        valueData = 'D';
                    }
                }
                //console.info("value:" + valueData);                
                objData[inputToChangeEdit[iArray]] = valueData;
                iArray++;
            });
//            for (num = 0; num < ids.length; num++){
//                objData["operationMemberId" + num] = ids[num].toString();
//            }
            objData["operationId"] = operId;
            objData["memberId"] = memId;
            //console.info(objData);
            var req = {};
            req.data2Json = $.toJSON(objData);

            $.ajax({
                type: 'POST',
                url: urlNew,
                data: req,
                dataType: 'json',
                async: false,
                success: function(msg) {
                    $.fn.DialogMessage(msg);
                    if (msg.checkSuccess === true) {
                        $(formName)[0].reset();
                        $("#dialogFormNew").dialog("close");
                    }
                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
                }
            });
            $(gridName).trigger("reloadGrid", [{page: 1}]);
        }
    };

    $('#txtStartDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#txtEndDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#txDocDate').datepicker({language: 'th', format: 'dd/mm/yyyy'});

    $("#slTypeApplySearch").select2({
        allowClear: true
    });

    $("#slMilitaryIdSearch").select2({
        placeholder: '-เลือก-',
        allowClear: true,
        minimumInputLength: 1
    });

    onDialogNew = function(e) {
        e.preventDefault();
        $("#dialogFormNew").dialog("open");
    };

    onInit = function() {
        onActionLoadMilitaryDepartment();

        onActionLoadSearchMilitaryDepartment();
    };

    onInit();
});