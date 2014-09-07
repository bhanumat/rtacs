$.extend($.validator.defaults, {
    errorClass: "error",
    validClass: "success",
    errorElement: "div"
});

$(function () {
    $('form').on('reset', function () {
        var $form = $(this);
        $form.find('.has-error,.has-success').removeClass('has-error').removeClass('has-success');
        $form.find('div.error').remove();
    });
});