$(document).ready(function () {
    var responseId = '#main-page-content-loading';
    var controlButton = function (element) {
        $('ul li').each(function (i)
        {
            $(this).removeClass();
            $(this).addClass('hover');
            //$(this).attr('rel'); // This is your rel value
        });
        $('#' + element).addClass('active open');
    };

    /*==============================Security==================================*/
    $("#menuGroups").click(function (e) {
        controlButton('menuAdministrator');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Security/Groups.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    /*=============================/Security==================================*/

    $("#menuMembershipCard").click(function (e) {
        var typeAction = 'GET';
        var urlAction = 'Home.html';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuChangeName").click(function () {
        var typeAction = 'GET';
        var urlAction = '../Plugins/ChangeName.html';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });
    /*=============================End /Security==================================*/


    /*=============================/QRY==================================*/
    $("#menuQRY010").click(function (e) {
        controlButton('menuQueryData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/QueryData/QRY010.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuQRY020").click(function (e) {
        controlButton('menuQueryData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/QueryData/QRY020.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });
    /*=============================End /QRY==================================*/

    /*=============================/App==================================*/

    $("#menuAPP010").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP010.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP010_2").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP010_2_New.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP031").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP031.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP040").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP040.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP041").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP041.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP043").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP043.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP044").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP044.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP045").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP045.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP051").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP051.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP052").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP052.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuAPP101").click(function (e) {
        controlButton('menuRegistration');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Registration/APP101.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    /*=============================End /App==================================*/

    /*=============================/Pay==================================*/
    $("#menuPAY010").click(function (e) {
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PAY010.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuPAY010_1").click(function (e) {
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PAY010_1.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });


    $("#menuPAY020").click(function (e) {
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PAY020.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuPAY020_1").click(function (e) {
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PAY020_1.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuPAY021").click(function (e) {
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PAY021.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuPYC101").click(function (e) {
        controlButton('menuPayment');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/Payment/PYC101.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });


    /*=============================End /Pay==================================*/

    /*=============================/MasterData==================================*/

    $("#menuMAS010").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS010.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuMAS020").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS020.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuMAS030").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS030.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuMAS040").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS040.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuMAS050").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS050.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuMAS060").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS060.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuMAS080").click(function (e) {
        controlButton('menuMasterData');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/MasterData/MAS080.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    /*=============================End /MasterData==================================*/

    /*=============================/ChangeData==================================*/

    $("#menuCHT010").click(function (e) {
        controlButton('menuChanges');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/ChangeData/CHT010.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    $("#menuCHT030").click(function (e) {
        controlButton('menuChanges');
        var typeAction = 'GET';
        var urlAction = rootPath + '/Plugins/ChangeData/CHT030.htm';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    /*=============================End /ChangeData==================================*/

    $("#menufmViewUserMember").click(function (e) {
        var typeAction = 'GET';
        var urlAction = '../Plugins/fmViewUserMember.html';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
        e.preventDefault();
    });

    var init = function () {
        var typeAction = 'GET';
        var urlAction = 'Home.html';
        var objDataAction = {};
        var dataTypeAction = 'html';
        $.fn.onGetTagHtml(typeAction, urlAction, objDataAction, dataTypeAction, responseId);
    };

    //init();
});