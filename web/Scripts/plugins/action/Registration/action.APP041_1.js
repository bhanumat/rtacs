/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {

    $("#btnBack").click(function (event) {
        event.preventDefault();
        onBackAPP041();
    });

    onBackAPP041 = function () {
        var typeAction = 'GET';
        var urlAction = urlAPP041;
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    };

    onActionLoad = function () {
        var objData = {};
        objData.operationId = $('#operationId').val();
        var req = {};
        req.data2Json = $.toJSON(objData);
        $.ajax({
            type: 'POST',
            url: urlLoad,
            cache: false,
            //timeout: 1000,
            async: false,
            data: req,
            dataType: 'json',
            success: function (json) {
                $('#txtDocDate').val($.formatDateTime('dd/mm/yy', new Date(json.docDate)));
                $('#txtDocCode').val(json.docCode);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            beforeSend: function (jqXHR) {
            }
        });
    };

    onInit = function () {
        onActionLoad();
        document.getElementById("txtDocDate").disabled = true;
        document.getElementById("txtDocCode").disabled = true;
    };

    onInit();
});
