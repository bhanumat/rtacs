$(document).ready(function() {
    //$.datepicker.setDefaults({ dateFormat: 'dd/mm/yy' });

    $.ajaxSetup({
        cache: false,
        async: false
    });

    //gotoURL = function (url) {
    //    divClear();
    //    window.location.replace(url);
    //};

    var utils = {};
// Could create a utility function to do this
    utils.inArray = function(searchFor, property) {
        var retVal = -1;
        var self = this;
        for (var index = 0; index < self.length; index++) {
            var item = self[index];
            if (item.hasOwnProperty(property)) {
                if (item[property].toLowerCase() === searchFor.toLowerCase()) {
                    retVal = index;
                    return retVal;
                }
            }
        }
        ;
        return retVal;
    };

// or we could create a function on the Array prototype indirectly
    Array.prototype.inArray = utils.inArray;
});