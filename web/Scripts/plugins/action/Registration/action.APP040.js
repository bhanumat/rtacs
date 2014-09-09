$(function() {
    $('#txtApplyDateFromSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    $('#txtApplyDateEndSearch').datepicker({language: 'th', format: 'dd/mm/yyyy'});
    
    $("#btnAdd").click(function(event) {
        event.preventDefault();
        var typeAction = 'GET';
        var urlAction = urlActionOpenNew;
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    });

    onDialogView = function(id) {
        var typeAction = 'GET';
        var urlAction = urlActionOpenView;
        var objDataAction = {};
        objDataAction.operationId = id;
        var req = {};
        req.data2Json = $.toJSON(objDataAction);
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, req, dataTypeAction, responseId);
    };

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        if ($('#txtApplyDateFromSearch').val().length !== 0 && $('#txtApplyDateFromSearch').val().length !== 0) {
            var search1 = {'groupOp': '', 'field': 'docDate', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val() + "," + $('#txtApplyDateEndSearch').val(), 'dataType': 'date'};
            requestSearch.push(search1);
        } else {
            if ($('#txtApplyDateFromSearch').val().length !== 0) {
                var search1 = {'groupOp': '', 'field': 'docDate', 'op': 'bw', 'data': $('#txtApplyDateFromSearch').val(), 'dataType': 'date'};
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

////////////////////////////////////////////////////////////

    onInit = function() {

    };


    onInit();
});