$(function () {

    onActionSearch = function () {
        $.ajax({
            type: 'POST',
            url: urlMember,
            data: req,
            dataType: 'json',
            async: false,
            success: function(object) {
                if (object.memberId === 0) {
                    $.fn.DialogWarning('ไม่พบข้อมูล');
                } else {
                    $("#hdnMemberId").val(object.memberId);
                    $("#lblMemberCode").text(object.memberCode);
                    $("#lblCitizenId").text(object.citizenId);
                    $("#lblName").text(object.rankOrTitleName + object.name + "  " + object.surname);
                    $("#lblMilitaryName").text(object.militaryName);
                    $("#lblMemberStatus").html(getHtmlMemberStatus(object.memberStatusName));
                    $("#paymentTypeCode20").attr("checked", "checked");
                    changePaymentTypeCode(20);
                    loadMemberPaymentGridByMemberId(object.memberId);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                $.fn.MessageError(XMLHttpRequest, textStatus, errorThrown);
            }
        });
    };
    
    gotoPrevious = function() {
        var typeAction = 'GET';
        var urlAction = urlMilitaryPayments;
        var objDataAction = {};
        var dataTypeAction = 'html';
        var responseId = '#main-page-content-loading';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    };

    //immediately-invoked
    (function () {
        init();
    }());

});