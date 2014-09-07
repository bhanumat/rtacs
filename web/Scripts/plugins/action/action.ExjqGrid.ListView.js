$(document).ready(function() {
    $("#txtDateStart").datepicker({
        numberOfMonths: 2,
        onSelect: function(selected) {
            $("#txtDateEnd").datepicker("option", "minDate", selected);
        }
    });

    $("#txtDateEnd").datepicker({
        numberOfMonths: 2,
        onSelect: function(selected) {
            $("#txtDateStart").datepicker("option", "maxDate", selected);
        }
    });

    onNew = function() {
        bootbox.dialog({
            message: $("#dialogFormNew").html(), //กำหนดเนื้อหาที่ต้องการแสดงที่อยู่ใน tag id dialogFormEdit
            title: '<span class="titleDialog">New<span>',
            buttons: [{
                    label: ' Save',
                    className: "glyphicon glyphicon-floppy-disk btn-primary",
                    action: function(dialogRef) {
                        dialogRef.setClosable(true);
                    }
                }, {
                    label: ' Cancel',
                    className: "glyphicon glyphicon-remove btn-default",
                    action: function(dialogRef) {
                        dialogRef.close();
                    }
                }]
        }).find("div.modal-dialog").addClass("class-with-800");
    };

    onEdit = function(id) {
        bootbox.dialog({
            message: $("#dialogFormEdit").html(), //กำหนดเนื้อหาที่ต้องการแสดงที่อยู่ใน tag id dialogFormEdit
            title: '<span class="titleDialog">Edit<span>',
            buttons: [{
                    label: ' Save',
                    className: "glyphicon glyphicon-floppy-disk btn-primary",
                    action: function(dialogRef) {
                        dialogRef.setClosable(true);
                    }
                }, {
                    label: ' Cancel',
                    className: "glyphicon glyphicon-remove btn-default",
                    action: function(dialogRef) {
                        dialogRef.close();
                    }
                }]
        }).find("div.modal-dialog").addClass("class-with-800");
    };

    $("#btnAdd").click(function() {
        onNew();
    });

    $('#btnDelete').click(function(event) {
        event.preventDefault();
        var ids = $(gridName).jqGrid('getGridParam', 'selarrrow');
        if (ids.length > 0) {
            bootbox.dialog({
                message: "ต้องการลบข้อมูลนี้หรือไม่",
                title: '<span class="titleConfirm"><i class="glyphicon glyphicon-question-sign"></i>&nbsp;Confirm<span>',
                buttons: {
                    main: {
                        label: " Delete",
                        className: "glyphicon glyphicon-minus btn-primary",
                        callback: function() {

                        }
                    },
                    default: {
                        label: " Cancel",
                        className: "glyphicon glyphicon-remove btn-default",
                        callback: function() {
                        }
                    }
                }
            });
        } else {
            $.fn.DialogWarning("กรุณาทำการเลือกเพื่อทำการลบข้อมูล");
        }
    });

    $("#txtTaskDateAdd").datepicker();
    $("#txtTaskDateEdit").datepicker();
    $("#dialogFormNew").hide();
    $("#dialogFormEdit").hide();
});