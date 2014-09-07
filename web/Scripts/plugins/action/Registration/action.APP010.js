$(function() {
    $('#txtApplyDateFromSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#txtApplyDateEndSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});

    $("#btnAdd").click(function(event) {
        var typeAction = 'GET';
        var urlAction = urlActionOpenNew;
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    });

    onEdit = function(id) {
        var typeAction = 'GET';
        var urlAction = urlActionOpenEdit;
        var objDataAction = {};
        objDataAction.memberId = id;
        var req = {};
        req.data2Json = $.toJSON(objDataAction);
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, req, dataTypeAction, responseId);
    };

    $('#btnDelete').click(function(event) {
        event.preventDefault();
        var ids = $(gridName).jqGrid('getGridParam', 'selarrrow');
        if (ids.length > 0) {
            $("#Dialog-Confirm").html("คุณต้องการลบข้อมูลนี้ใช่หรือไม่?");
            $("#Dialog-Confirm").dialog({
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-trash-o bigger-110'></i>&nbsp; Delete all items",
                        "class": "btn btn-danger btn-xs",
                        click: function() {
                            var objData = {};
                            objData.ItemSelect = ids.toString();//JSON.stringify(ids);
                            onActionDelete(this, objData);
                        }
                    },
                    {
                        html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; Cancel",
                        "class": "btn btn-xs",
                        click: function() {
                            $(this).dialog("close");
                        }
                    }
                ]
            });
            $("#Dialog-Confirm").dialog("open");
        } else {
            $("#Dialog-Warning").html("กรุณาทำการเลือกเพื่อทำการลบข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    });

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

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        if ($('#txtApplyDateFromSearch').val().length !== 0 && $('#txtApplyDateEndSearch').val().length !== 0) {
            var search1 = {'groupOp': '', 'field': 'applyDate', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#date_end').val(), 'dataType': 'date'};
            requestSearch.push(search1);
        } else {
            if ($('#txtApplyDateFromSearch').val().length !== 0) {
                var search1 = {'groupOp': '', 'field': 'applyDate', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val(), 'dataType': 'date'};
                requestSearch.push(search1);
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
        if ($('#txtCitizenIdSearch').val().length !== 0) {
            var search3 = {'groupOp': '', 'field': 'txtCitizenIdSearch', 'op': 'eq', 'data': $('#txtCitizenIdSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }
        if ($('#txtNumberMember').val().length !== 0) {
            var search4 = {'groupOp': '', 'field': 'name', 'op': 'eq', 'data': $('#txtNumberMember').val(), 'dataType': 'varchar'};
            requestSearch.push(search4);
        }
        if ($('#txtSurnameSearch').val().length !== 0) {
            var search5 = {'groupOp': '', 'field': 'surname', 'op': 'eq', 'data': $('#txtSurnameSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search5);
        }
        if ($('#slMilitaryDepartmentSearch').val().length !== 0) {
            var search8 = {'groupOp': '', 'field': 'militaryId', 'op': 'eq', 'data': $('#slMilitaryDepartmentSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search8);
        }
        if ($('#slApplyTypeSearch').val().length !== 0) {
            var search6 = {'groupOp': '', 'field': 'memberGroupCode', 'op': 'eq', 'data': $('#slApplyTypeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }
        if ($('#slMemberTypeCodeSearch').val().length !== 0) {
            var search7 = {'groupOp': '', 'field': 'memberTypeCode', 'op': 'eq', 'data': $('#slMemberTypeCodeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }
        if ($('#slMemberStatusCodeSearch').val().length !== 0) {
            var search8 = {'groupOp': '', 'field': 'memberStatusCode', 'op': 'eq', 'data': $('#slMemberStatusCodeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search8);
        }
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

    onActionClearEditMilitaryDepartment = function() {
        $('#slMilitaryDepartmentSearch').empty();
        $('#slMilitaryDepartmentSearch').append('<option value="">ทั้งหมด</option>');
    };

    onActionLoadSearchMilitaryDepartment = function() {
        onActionClearEditMilitaryDepartment();
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#slMilitaryDepartmentSearch').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };

    onInit = function() {
        onActionLoadMilitaryDepartment();
        onActionLoadSearchMilitaryDepartment();
    };


    onInit();
});