$(document).ready(function () {
    //override dialog's title function to allow for HTML titles
    $.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
        _title: function (title) {
            var $title = this.options.title || '&nbsp;';
            if (("title_html" in this.options) && this.options.title_html === true)
                title.html($title);
            else
                title.text($title);
        }
    }));

    $.fn.MessageError = function (XMLHttpRequest, textStatus, errorThrown) {
        if (XMLHttpRequest.status === 400) {
            $.fn.ValidateAjaxRequired(XMLHttpRequest.responseJSON);
        } else if (XMLHttpRequest.status === 500) {
            $.fn.DialogDanger("Sorry, an error occurred while processing your request.");
        } else {
            if (typeof (XMLHttpRequest.status) !== 'undefined' || typeof (XMLHttpRequest.statusText)) {
                var msg = XMLHttpRequest.status + " : " + XMLHttpRequest.statusText;
                $.fn.DialogDanger(msg);
            } else {
                $.fn.DialogDanger("Sorry, Not processing your request.");
            }
        }
    };

    $.fn.ValidateAjaxRequired = function (message) {
        var msg = "";
        var msgKey = "";
        var msgError = "";
        $.each(message, function (index, object) {
            msgKey = object.key;
            $.each(object.errors, function (index2, objectError) {
                if (msgError === "") {
                    msgError += objectError;
                } else {
                    msgError += ", " + objectError;
                }
            });
            msg += msgKey + " : " + msgError + "<br />";
            msgKey = "";
            msgError = "";
        });
        $.fn.DialogDanger(msg);
    };

    $.fn.DialogDanger = function (msg) {
        $("#Dialog-Danger").empty();
        $("#Dialog-Danger").html(msg);
        $("#Dialog-Danger").dialog("open");
    };

    $.fn.DialogSuccess = function (msg) {
        $("#Dialog-Success").empty();
        $("#Dialog-Success").html(msg);
        $("#Dialog-Success").dialog("open");
    };

    $.fn.DialogInfo = function (msg) {
        $("#Dialog-Info").empty();
        $("#Dialog-Info").html(msg);
        $("#Dialog-Info").dialog("open");
    };

    $.fn.DialogWarning = function (msg) {
        $("#Dialog-Warning").empty();
        $("#Dialog-Warning").html(msg);
        $("#Dialog-Warning").dialog("open");
    };

    $.fn.DialogMessage = function (msg) {
        if (msg.checkSuccess) {
            $.fn.DialogSuccess(msg.message);
        } else {
            $.fn.DialogDanger(msg.message);
        }
    };

    $.fn.DialogMessageResponse = function (msg) {
        if (!msg.checkSuccess) {
            $.fn.DialogDanger(msg.message);
        }
    };

    $.fn.onGetTagHtml = function (typeAction, urlAction, objDataAction, dataTypeAction, responseId) {
        $.ajax({
            type: typeAction,
            url: urlAction,
            data: objDataAction,
            dataType: dataTypeAction,
            cache: false,
            //timeout: 1000,
            async: false,
            beforeSend: function (jqXHR) {
            },
            success: function (response) {
                $('[aria-describedby="dialogFormNew"]').remove();
                $('[aria-describedby="dialogFormEdit"]').remove();
                $(responseId).html(response);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            }
        });
    };

    $.fn.onRedirect = function (urlAction) {
        // similar behavior as clicking on a link
        window.location.href = urlAction;
    };

    $("#Dialog-Confirm").removeClass('hide').dialog({
        autoOpen: false,
        minHeight: 200,
        minWidth: 500,
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon fa fa-exclamation-triangle red'></i> Confirm message?</h4></div>",
        title_html: true
    });

    $("#Dialog-Warning").removeClass('hide').dialog({
        autoOpen: false,
        minHeight: 200,
        minWidth: 500,
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-exclamation-sign red'></i> Warning</h4></div>",
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon glyphicon glyphicon-ok bigger-110'></i>&nbsp; Ok",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#Dialog-Danger").removeClass('hide').dialog({
        autoOpen: false,
        minHeight: 200,
        minWidth: 500,
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-remove-sign orange'></i> Danger</h4></div>",
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon glyphicon glyphicon-ok bigger-110'></i>&nbsp; Ok",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#Dialog-Info").removeClass('hide').dialog({
        autoOpen: false,
        minHeight: 200,
        minWidth: 500,
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-info-sign blue'></i> Info</h4></div>",
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon glyphicon glyphicon-ok bigger-110'></i>&nbsp; Ok",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });

    $("#Dialog-Success").removeClass('hide').dialog({
        autoOpen: false,
        minHeight: 200,
        minWidth: 500,
        resizable: false,
        modal: true,
        title: "<div class='widget-header'><h4 class='smaller'><i class='ace-icon glyphicon glyphicon-info-sign lime'></i> Success</h4></div>",
        title_html: true,
        buttons: [
            {
                html: "<i class='ace-icon glyphicon glyphicon-ok bigger-110'></i>&nbsp; Ok",
                "class": "btn btn-xs",
                click: function () {
                    $(this).dialog("close");
                }
            }
        ]
    });
});