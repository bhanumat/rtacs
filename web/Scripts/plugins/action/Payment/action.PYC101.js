
$(function () {
    //Declaration variables for cover all in this scope
    var responseId = '#main-page-content-loading';

    onActionSearch = function () {
        var search = {};
        var statusSearch = false; //0 is not in condition, 1 is in condition
        var requestSearch = new Array();
        var condition = '';
        var monthCode = $('#monthCode').val();
        var militaryId = $('#militaryId').val();

        if (monthCode) {
            requestSearch.push({'groupOp': condition, 'field': 'monthCode', 'op': 'eq', 'data': monthCode, 'dataType': 'varchar'});
            condition = 'and';
            statusSearch = true;
        }

        if (militaryId) {
            requestSearch.push({'groupOp': condition, 'field': 'mildeptId', 'op': 'eq', 'data': militaryId, 'dataType': 'integer'});
            condition = 'and';
            statusSearch = true;
        }

        search.conditions = requestSearch;
        $(pyc101GridName).jqGrid('setGridParam', {
            search: statusSearch,
            postData: {
                searchCommand: $.toJSON(search)
            }
        });
        $(pyc101GridName).trigger("reloadGrid", [{page: 1}]);

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


                for (var item in listControlPaymentMonthCodes) {
                    var itemData = listControlPaymentMonthCodes[item];
                    if (itemData) {
                        if (itemData.monthCode && itemData.budgetMonth) {
                            var budgetMonthDisplay = moment(new Date(itemData.budgetMonth)).add(543, 'years').format('MMM YYYY');
                            $monthCode.append('<option value="' + itemData.monthCode + '">' + budgetMonthDisplay + '</option>');
                        } else {
                            console.log("Item Data is invalid monthCode:" + itemData + ", budgetMonth:" + itemData.budgetMonth);
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