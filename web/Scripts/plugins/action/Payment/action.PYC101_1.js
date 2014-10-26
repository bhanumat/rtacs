$(function () {
    gotoPrevious = function() {
        var typeAction = 'GET';
        var urlAction = urlMilitaryPayments;
        var objDataAction = {};
        var dataTypeAction = 'html';
        var responseId = '#main-page-content-loading';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    };
});