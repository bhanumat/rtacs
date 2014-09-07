$(document).ready(function () {
    add_commas = function (numStr) {
        numStr += '';
        var x = numStr.split('.');
        var x1 = x[0];
        var x2 = x.length > 1 ? '.' + x[1] : '';
        return x1.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,") + x2;
    };

    SetCursorToTextEnd = function (textControlID) {
        var text = document.getElementById(textControlID);
        if (text !== null && text.value.length > 0) {
            if (text.createTextRange) {
                var FieldRange = text.createTextRange();
                FieldRange.moveStart('character', text.value.length);
                FieldRange.collapse();
                FieldRange.select();
            }
        }
    };

    CustomCurrencyFormatValue = function (inpValue, min_digit, max_digit) {
        var number = parseFloat(inpValue.replace(/[^\d.]/g, ""));
        var retNumber = '';
        var numDigit = min_digit;
        if (number > 0) {
            var arrNum = number.toString().split('.');
            if (arrNum.length > 1) {
                if (arrNum[1].length > min_digit) {
                    numDigit = arrNum[1].length;
                    if (numDigit > max_digit) {
                        numDigit = max_digit;
                    }
                }
            }
            retNumber = add_commas(parseFloat(number).toFixed(numDigit));
        }
        return retNumber;
    };

    CustomCurrencyFormatValueDefault0 = function (inpValue, min_digit, max_digit) {
        var number = parseFloat(inpValue.replace(/[^\d.]/g, ""));

        var retNumber = parseFloat('0').toFixed(min_digit);
        var numDigit = min_digit;
        if (number > 0) {
            var arrNum = number.toString().split('.');
            if (arrNum.length > 1) {
                if (arrNum[1].length > min_digit) {
                    numDigit = arrNum[1].length;
                    if (numDigit > max_digit) {
                        numDigit = max_digit;
                    }
                }
            }
            if (numDigit == min_digit) {
                retNumber = add_commas(parseFloat(number).toFixed(numDigit));
            }
            else {
                var tmbNum = parseFloat(number).toFixed(numDigit);
                retNumber = add_commas(tmbNum.replace(/0+$/, ''));
            }
        }
        return retNumber;
    };

    CustomCurrencyFormat = function (obj, min_digit, max_digit) {
        if ((obj != null) && (obj != undefined)) {
            var number = $("#" + obj.id).val();
            $("#" + obj.id).val(CustomCurrencyFormatValue(number, min_digit, max_digit));
        }
    };

    CustomCurrencyFormatDefault0 = function (obj, min_digit, max_digit) {
        if ((obj != null) && (obj != undefined)) {
            var number = $("#" + obj.id).val();
            $("#" + obj.id).val(CustomCurrencyFormatValueDefault0(number, min_digit, max_digit));
        }
    };

    CustomCurrencyReal = function (obj) {
        if ((obj != null) && (obj != undefined)) {
            var number = $("#" + obj.id).val().replace(/[^\d.]/g, "");
            $("#" + obj.id).val('');
            if (parseFloat(number) > 0) {
                $("#" + obj.id).val(parseFloat(number));
                SetCursorToTextEnd(obj.id);
            }
        }
    };

    replace2NumberWithFormat = function (obj, min_digit, max_digit) {
        CustomCurrencyFormatDefault0(obj, min_digit, max_digit);
        var valueData = $("#" + obj.id).val();
        return valueData.replace(/,/g, '');
    };

    ValueFormatNumber3DE = function (id) {
        $(id).val(replace2Number($(id).val()));
        $(id).formatNumber({ format: "#,##0.000", locale: "en" });
    };

    ValueFormatNumber2DE = function (id) {
        $(id).val(replace2Number($(id).val()));
        $(id).formatNumber({ format: "#,##0.00", locale: "en" });
    };

    replace2Number = function (valueData) {
        return valueData.replace(/,/g, '');
    };
});