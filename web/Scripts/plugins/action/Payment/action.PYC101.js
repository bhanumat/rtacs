
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
        var printStatus = $('#printStatus').val();

        if (memberCode) {
            requestSearch.push({'groupOp': condition, 'field': 'memberCode', 'op': 'eq', 'data': memberCode, 'dataType': 'varchar'});
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
            requestSearch.push({'groupOp': condition, 'field': 'mildeptId', 'op': 'eq', 'data': militaryId, 'dataType': 'integer'});
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

        if (printStatus) {
            requestSearch.push({'groupOp': condition, 'field': 'printedStatus', 'op': 'eq', 'data': printStatus, 'dataType': 'char'});
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
                var listMilitaryDepartment = json;
                $('#militaryId').empty();
                $('#militaryId').append('<option value="">ทั้งหมด</option>');
                for (var item in listMilitaryDepartment) {
                    var itemData = listMilitaryDepartment[item];
                    $('#militaryId').append('<option value="' + itemData.mildeptId + '">' + itemData.name + '</option>');
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            },
            beforeSend: function (jqXHR) {
            }
        });
    };


    onActionLoadControlPaymentMonthCodes = function () {
        $.ajax({
            type: 'GET',
            url: urlListJsonControlPaymentMonthCodes,
            cache: false,
            //timeout: 1000,
            async: true,
            data: {},
            dataType: 'json',
            success: function (json) {
                var listControlPaymentMonthCodes = json;
                var $monthCode = $('#monthCode');
                $monthCode.empty();
                $monthCode.append('<option value="">ทั้งหมด</option>');
                debugger;
                for (var item in listControlPaymentMonthCodes) {
                    var itemData = listControlPaymentMonthCodes[item];
                    if( itemData ) {
                        if( itemData.monthCode && itemData.budgetMonth) {
                            $monthCode.append('<option value="' + itemData.monthCode + '">' + itemData.budgetMonth + '</option>');
                        } else {
                            console.log("Item Data is invalid monthCode:" + itemData+", budgetMonth:"+ itemData.budgetMonth);
                        }
                    } else {
                        console.log("Item Data is invalid" + itemData);
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    //immediately-invoked
    (function () {
        console.log("initialize action.PYC101.js ...");

        $('#frmCriterionSearch').submit(function (event) {
            event.preventDefault();
            onActionSearch();
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

        onActionLoadControlPaymentMonthCodes();
        onActionLoadMilitaryDepartment();
    }());

});