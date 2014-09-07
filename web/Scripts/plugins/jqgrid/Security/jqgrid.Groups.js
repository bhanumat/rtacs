/*
 * Author Date : 2014-05-18 22:00:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl = urlList;
var gridName = '#gridData_ExjqGrid_List';
var gridPager = '#gridPager_ExjqGrid_List';
var gridSortName = 'groupsName';
var gridSortOrder = 'asc';
var gridCaption = 'ข้อมูลหน่วยต้นสังกัด';
var gridColNames = ['', 'Id', 'ชื่อกลุ่ม', 'คำอธิบายเพิ่มเติม', 'สถานะการใช้งาน', 'สายควบคุม', 'ขึ้นกับหน่วยส่งเงิน', 'ชื่อหน่วยส่งเงิน', 'สถานะใช้งาน'];
var gridColModel = [
    {name: 'action', index: 'action', width: 30, align: 'center', search: false, sortable: false},
    {name: 'groupsId', index: 'groupsId', hidden: true, align: 'left'},
    {name: 'groupsName', index: 'groupsName', align: 'left', sortable: true, width: 100},
    {name: 'groupsDescription', index: 'groupsDescription', align: 'left', sortable: true, width: 300},
    {name: 'flag', index: 'flag', align: 'left', sortable: false, width: 200},
    {name: 'note', index: 'tax', align: 'left', sortable: false, width: 100},
    {name: 'tax', index: 'tax', align: 'left', sortable: false},
    {name: 'total', index: 'total', align: 'left', sortable: true},
    {name: 'closed', index: 'closed', align: 'left', sortable: true, width: 100}];
var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "groupsId"           //the unique id of the row
};
var updatePagerIcons = function(table) {
    var replacement =
            {
                'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
                'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
                'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
                'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
            };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function() {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement)
            icon.attr('class', 'ui-icon ' + replacement[$class]);
    });
};

//it causes some flicker when reloading or navigating grid
//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
//or go back to default browser checkbox styles for the grid
var styleCheckbox = function(table) {
    $(table).find('input:checkbox').addClass('ace')
            .wrap('<label />')
            .after('<span class="lbl align-top" />');

    $("input[id^='cb_']").addClass('ace')
            .wrap('<label />')
            .after('<span class="lbl align-top" />');
    /*
     $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
     .find('input.cbox[type=checkbox]').addClass('ace')
     .wrap('<label />').after('<span class="lbl align-top" />');
     */

};


var enableTooltips = function(table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function() {
    $(gridName).jqGrid({
        url: gridUrl,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaption,
        colNames: gridColNames,
        colModel: gridColModel,
        jsonReader: gridJsonReader,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName,
        sortorder: gridSortOrder,
        viewrecords: true,
        multiselect: true,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridName).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var div = "<div style=\"margin-left:5px;\">";
                var buttonEdit = "<div onmouseout=\"$(this).removeClass('ui-state-hover')\""
                        + " onmouseover=\"$(this).addClass('ui-state-hover');\" class=\"ui-pg-div ui-inline-edit\""
                        + " onclick=\"onDialogEdit('" + id + "');\" style=\"float:left;cursor:pointer;\"><i title=\"Edit\" class=\"glyphicon glyphicon-edit\">"
                        + "</i></div>";
                var endDiv = "</div>";
                $(gridName).setRowData(ids[i], {action: div + buttonEdit + endDiv});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridName).jqGrid('navGrid', gridPager, {edit: false, add: false, del: false, search: false, refresh: false},
    {}, // edit options  
            {}, // add options  
            {}, //del options  
            {
                closeOnEscape: true,
                multipleSearch: true,
                closeAfterSearch: true
            }
    );
    $("#btnSearch").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });   

    $("#btnReload").click(function(event) {
        event.preventDefault();
        onActionSearch();
    });
});

