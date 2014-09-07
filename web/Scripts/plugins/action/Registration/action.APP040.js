$(function() {

    $("#btnAdd").click(function(event) {
        var typeAction = 'GET';
        var urlAction = urlActionOpenNew;
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    });

    onActionSearch = function() {
        var search = {};
        var requestSearch = new Array();
        var search1 = {'groupOp': '', 'field': 'docCode', 'op': 'cn', 'data': $('#txtName').val(), 'dataType': 'varchar'};
        requestSearch.push(search1);
        var search3 = {'groupOp': 'and', 'field': 'status', 'op': 'cn', 'data': $('#slStatus').val(), 'dataType': 'char'};
        requestSearch.push(search3);
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