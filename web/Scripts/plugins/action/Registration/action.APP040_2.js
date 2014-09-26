$(function() {
    $('#txtApplyDateFromSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtApplyDateFromSearch").datepicker("setDate", new Date());
    $('#txtApplyDateEndSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $("#txtApplyDateEndSearch").datepicker("setDate", new Date());

    $("#btnBack").click(function(event) {
        event.preventDefault();
        $("#Dialog-Confirm").html("คุณต้องการยกเลิกข้อมูลนี้ใช่หรือไม่?");
        $("#Dialog-Confirm").dialog({
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-undo bigger-110'></i>&nbsp; Cancel all items",
                    "class": "btn btn-danger btn-xs",
                    click: function() {
                        var typeAction = 'GET';
                        var urlAction = urlActionListAPP040;
                        var objDataAction = {};
                        var dataTypeAction = 'html';
                        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
                        $(this).dialog("close");
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
    });

    $("#btnRegisterNo").click(function(event) {
        if ($("#txtRegisterMemberCode").val() == "") {
            alert("กรุณากำหนดเลขทะเบียนเริ่มต้น");
        }
        else {
            event.preventDefault();
            var registerMemberCode = $('#txtRegisterMemberCode').val();
            var data = $("#gridData_APP040_2_Grid_List").jqGrid('getRowData');
            for (var i = 0; i < data.length; i++) {
                $('#txtMemberCode_' + data[i].memberId).val(registerMemberCode);
                registerMemberCode++;
            }
        }

    });

    onActionSaveNew = function(thisDialog, objData) {
        var data = {};
        data.DataSource = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlSaveNew,
            data: data,
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

    $("#btnRegisterSave").click(function(event) {
        event.preventDefault();
        listAPP040_2 = new Array();
        var data = $("#gridData_APP040_2_Grid_List").jqGrid('getRowData');
        for (var i = 0; i < data.length; i++) {
            var dataRegisterNo = {};
            dataRegisterNo.memberId = data[i].memberId;
            dataRegisterNo.memberCode = $('#txtMemberCode_' + data[i].memberId).val();
            listAPP040_2.push(dataRegisterNo);
        }
        if (data.length != 0) {
            $("#Dialog-Confirm").html("คุณต้องการบันทึกข้อมูลนี้ใช่หรือไม่?");
            $("#Dialog-Confirm").dialog({
                buttons: [
                    {
                        html: "<i class='ace-icon fa fa-floppy-o bigger-110'></i>&nbsp; บันทึก",
                        "class": "btn btn-danger btn-xs",
                        click: function() {
                            var objData = {};
                            objData.RegisterNo = listAPP040_2;
                            onActionSaveNew(this, objData);
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
            $("#Dialog-Warning").html("ไม่พบข้อมูล");
            $("#Dialog-Warning").dialog("open");
        }
    });

    onActionSearch = function() {
        var search = {};
        var statussearch = 0; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var search1 = {'groupOp': '', 'field': 'm.citizen_id', 'op': 'cn', 'data': $('#txtCitizenIdSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search1);

        var search2 = {'groupOp': 'and', 'field': 'm.name', 'op': 'cn', 'data': $('#txtNameSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search2);

        var search3 = {'groupOp': 'and', 'field': 'm.surname', 'op': 'cn', 'data': $('#txtSurnameSearch').val(), 'dataType': 'varchar'};
        requestSearch.push(search3);

        if ($('#txtApplyDateFromSearch').val().length !== 0 && $('#txtApplyDateEndSearch').val().length !== 0) {
            var search4 = {'groupOp': 'and', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#date_end').val(), 'dataType': 'date'};
            requestSearch.push(search1);
            statussearch = 1;
        } else {
            if ($('#txtApplyDateFromSearch').val().length !== 0) {
                var search1 = {'groupOp': 'and', 'field': 'm.apply_date', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val(), 'dataType': 'date'};
                requestSearch.push(search1);
                statussearch = 1;
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
            var search6 = {'groupOp': 'and', 'field': 'm.military_id', 'op': 'cn', 'data': $('#slMilitaryDepartmentSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search6);
        }

        if ('%' !== $('#slApplyTypeSearch').val()) {
            var search7 = {'groupOp': 'and', 'field': 'm.member_group_code', 'op': 'cn', 'data': $('#slApplyTypeSearch').val(), 'dataType': 'integer'};
            requestSearch.push(search7);
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

////////////////////////////////////////////////////////////

    onInit = function() {
        onActionLoadMilitaryDepartment();
        onActionLoadSearchMilitaryDepartment();
    };


    onInit();
});