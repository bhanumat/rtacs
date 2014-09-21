
$(function () {
    //Declaration variables for cover all in this scope
    var responseId = '#main-page-content-loading';
    
    onActionSearch = function () {
        var search = {};
        var statusSearch = false; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var condition = '';
        var paymentDateStart = $('#paymentDateStart').val();
        var paymentDateEnd = $('#paymentDateEnd').val();
        var memberCode = $('#memberCode').val();
        var citizenId = $('#citizenId').val();
        var name = $('#name').val();
        var surname = $('#surname').val();
        var militaryId = $('#militaryId').val();
        var memberTypeCode = $('#memberTypeCode').val();
        var memberGroupCode = $('#memberGroupCode').val();
        var paymentStatusCode = $('#paymentStatusCode').val();

        if (memberCode) {
            requestSearch.push({'groupOp': condition, 'field': 'memberCode', 'op': 'eq', 'data': memberCode, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        if (paymentDateStart && paymentDateEnd) {
            requestSearch.push({'groupOp': condition, 'field': 'paymentDate', 'op': 'bw', 'data': paymentDateStart + ',' + paymentDateEnd, 'dataType': 'date'});
            statusSearch = true;
            condition = 'and';
        } else if (paymentDateStart) {
            requestSearch.push({'groupOp': condition, 'field': 'paymentDate', 'op': 'bw', 'data': paymentDateStart, 'dataType': 'date'});
            statusSearch = true;
            condition = 'and';
        } else if (paymentDateEnd) {
            $.fn.DialogWarning('กรุณากรอกข้อมูล วันที่ชำระเงิน');
            return;
        }

        if (citizenId) {
            if (citizenId.length === 13) {
                requestSearch.push({'groupOp': condition, 'field': 'citizenId', 'op': 'eq', 'data': citizenId, 'dataType': 'varchar'});
                condition = 'and';
                statusSearch = true;
            } else {
                $.fn.DialogWarning('กรุณากรอกรหัสประชาชนเป็น 13 หลักเท่านั้น');
                return;
            }
        }

        if (name) {
            requestSearch.push({'groupOp': condition, 'field': 'name', 'op': 'cn', 'data': name, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }

        if (surname) {
            requestSearch.push({'groupOp': condition, 'field': 'surname', 'op': 'cn', 'data': surname, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }

        if (militaryId) {
            requestSearch.push({'groupOp': condition, 'field': 'militaryId', 'op': 'eq', 'data': militaryId, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        if (memberTypeCode) {
            requestSearch.push({'groupOp': condition, 'field': 'memberTypeCode', 'op': 'eq', 'data': memberTypeCode, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        if (memberGroupCode) {
            requestSearch.push({'groupOp': condition, 'field': 'memberGroupCode', 'op': 'eq', 'data': memberGroupCode, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        if (paymentStatusCode) {
            requestSearch.push({'groupOp': condition, 'field': 'memberStatusCode', 'op': 'eq', 'data': paymentStatusCode, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        search.conditions = requestSearch;
        $(gridName).jqGrid('setGridParam', {
            search: statusSearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(gridName).trigger("reloadGrid", [{page: 1}]);

    };

    onActionLoadMilitaryDepartment = function () {
        var objData = {};
        $.ajax({
            type: 'POST',
            url: urlListJsonMilitaryDepartment,
            cache: false,
            //timeout: 1000,
            async: false,
            data: objData,
            dataType: 'json',
            success: function (json) {
                listMilitaryDepartment = json;
                onActionLoadNewMilitaryDepartment();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onActionClearNewMilitaryDepartment = function () {
        $('#militaryId').empty();
    };

    onActionLoadNewMilitaryDepartment = function () {
        onActionClearNewMilitaryDepartment();
        $('#militaryId').append('<option value="">ทั้งหมด</option>');
        for (var item in listMilitaryDepartment) {
            var itemData = listMilitaryDepartment[item];
            $('#militaryId').append('<option value="' + itemData.militaryId + '">' + itemData.name + '</option>');
        }
    };

    onDialogDelete = function (id) {
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
                    click: function () {
                        var objData = {};
                        objData.ItemSelect = id;//JSON.stringify(ids);
                        onActionDelete(this, objData);
                    }
                }
                ,
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ยกเลิก",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                    }
                }
            ]
        });
    };

    onActionDelete = function (thisDialog, objData) {
        $.ajax({
            type: 'POST',
            url: urlDeleteMemberPayment,
            data: objData,
            dataType: 'json',
            async: true,
            success: function (msg) {
                $.fn.DialogMessage(msg);
                if (msg.checkSuccess === true) {
                    onActionSearch();
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });

        $(thisDialog).dialog("close");
    };


    //immediately-invoked
    (function () {
        console.log("initialize action.PAY010.js ...");
        $.fn.datepicker.defaults.format = "dd/mm/yyyy";
        $.fn.datepicker.defaults.language = 'th';
        $.fn.datepicker.defaults.todayHighlight = true;

        var paymentDateStartPicker = $('#paymentDateStart').datepicker({endDate: new Date()});
        var paymentDateEndPicker = $('#paymentDateEnd').datepicker({endDate: new Date()});

        paymentDateStartPicker.on('changeDate', function (ev) {
            var endDate = paymentDateEndPicker.data('datepicker').getDate();
            if (endDate && ev.date.valueOf() > endDate.valueOf()) {
                var newDate = new Date(ev.date);
                newDate.setDate(newDate.getDate() + 1);
                paymentDateEndPicker.data('datepicker').setDate(newDate);
            }
            //Auto focus
            $(this).data('datepicker').hide();
            $('#paymentDateEnd')[0].focus();
        }).data('datepicker');

        paymentDateEndPicker.on('changeDate', function (ev) {
            var startDate = paymentDateStartPicker.data('datepicker').getDate();
            if (startDate && ev.date.valueOf() < startDate.valueOf()) {
                var newDate = new Date(ev.date);
                newDate.setDate(newDate.getDate() - 1);
                paymentDateStartPicker.data('datepicker').setDate(newDate);
            }
        }).data('datepicker');

        $('#frmCriterionSearch').submit(function (event) {
            event.preventDefault();
            onActionSearch();
        });

        $('#btnAdd').click(function (event) {
            var typeAction = 'GET';
            var urlAction = urlAddMemberPayment;
            var objDataAction = {};
            var dataTypeAction = 'html';
            $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
            e.preventDefault();
        });

        $("#Dialog-Warning").dialog({
            width: '300px',
            resizable: false,
            modal: true,
            title: "<div class='widget-header'><h4 class='smaller'> แจ้งเตือน</h4></div>",
            title_html: true,
            autoOpen: false,
            buttons: [
                {
                    html: "<i class='ace-icon fa fa-times bigger-110'></i>&nbsp; ปิด",
                    "class": "btn btn-xs",
                    click: function () {
                        $(this).dialog("close");
                    }
                }
            ]
        });

        onActionLoadMilitaryDepartment();
    }());

});