$(function() {
    $('#txtApplyDateFromSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtApplyDateFromSearch").datepicker("setDate", new Date());
    $('#txtApplyDateEndSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtApplyDateEndSearch").datepicker("setDate", new Date());

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
        var statussearch = true; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var condition = 'and';
        if ($('#txtCitizenIdSearch').val().length !== 0) {
            var search1 = {'groupOp': condition, 'field': 'm.citizen_id', 'op': 'cn', 'data': $('#txtCitizenIdSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search1);
        }
        if ($('#txtNameSearch').val().length !== 0) {
            var search2 = {'groupOp': condition, 'field': 'm.name', 'op': 'cn', 'data': $('#txtNameSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search2);
        }
        if ($('#txtSurnameSearch').val().length !== 0) {
            var search3 = {'groupOp': condition, 'field': 'm.surname', 'op': 'cn', 'data': $('#txtSurnameSearch').val(), 'dataType': 'varchar'};
            requestSearch.push(search3);
        }

        if ($('#txtApplyDateFromSearch').val().length !== 0 && $('#txtApplyDateEndSearch').val().length !== 0) {
            var search4 = {'groupOp': condition, 'field': 'm.apply_date', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#txtApplyDateEndSearch').val(), 'dataType': 'date'};
            requestSearch.push(search4);
        } else {
            if ($('#txtApplyDateFromSearch').val().length !== 0) {
                var search5 = {'groupOp': condition, 'field': 'm.apply_date', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#txtApplyDateFromSearch').val(), 'dataType': 'date'};
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
            var search6 = {'groupOp': condition, 'field': 'm.military_id', 'op': 'eq', 'data': $('#slMilitaryDepartmentSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }

        if ('%' !== $('#slApplyTypeSearch').val()) {
            var search7 = {'groupOp': condition, 'field': 'm.member_type_code', 'op': 'eq', 'data': $('#slApplyTypeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
        }

        if ('%' !== $('#slMemberTypeCodeSearch').val()) {
            var search8 = {'groupOp': condition, 'field': 'm.member_group_code', 'op': 'eq', 'data': $('#slMemberTypeCodeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search8);
        }

        if ('%' !== $('#slMemberStatusCodeSearch').val()) {
            var search9 = {'groupOp': condition, 'field': 'm.member_status_code', 'op': 'eq', 'data': $('#slMemberStatusCodeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search9);
        }
        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: statussearch,
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

    onActionClearSearchMilitaryDepartment = function() {
        $('#slMilitaryDepartmentSearch').empty();
        $('#slMilitaryDepartmentSearch').append('<option value="%">ทั้งหมด</option>');
    };

    onActionLoadSearchMilitaryDepartment = function() {
        onActionClearSearchMilitaryDepartment();
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