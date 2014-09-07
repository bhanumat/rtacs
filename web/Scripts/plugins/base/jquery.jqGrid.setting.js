$(document).ready(function() {
    JqGridDisplay.SiteMaster.setDefaults();
});

var JqGridDisplay = {
    Home: {
        JqGridDisplay: {}
    },
    SiteMaster: {
        setDefaults: function () {
            $.jgrid.defaults = $.extend($.jgrid.defaults, {
                datatype: 'json',
                height: 'auto',
                imgpath: '/Content/Images',
                jsonReader: {
                    root: "rows",
                    page: "page",
                    total: "totalPages",
                    records: "records",
                    repeatitems: false,
                    userdata: "userData",
                    id: "id",
                    search: "_search"
                },
                ajaxGridOptions: {
                    cache: false,
                    async: false,
                    timeout: 10000
                },
                loadui: "block",
                mtype: 'POST',
                multiboxonly: true,
                rowNum: 10,
                rowList: [10, 20, 40, 50, 100],
                viewrecords: true
            });

            $.jgrid.search = $.extend($.jgrid.search, {
                caption: "Search",
                Find: "Find",
                Reset: "Reset",
                odata: ['equal', 'contains'],
                sopt: ['eq', 'cn'],
                groupOps: [{ op: "OR", text: "any" }, { op: "AND", text: "all"}],
                matchText: " match",
                rulesText: " rules",
                search: "_search"
            });
        }
    }
};


function afterSubmit(r, data, action) {
    if (r.responseText !== "") { // If an error message is returned
        alert(r.responseText);
        return [false, r.responseText]; // Don't remove this!
    }
    return true; // Don't remove this!
}
