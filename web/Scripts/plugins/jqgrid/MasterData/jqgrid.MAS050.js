/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl = urlList;
var gridName = '#gridData_BankAccountTypejqGrid_List';
var gridPager = '#gridPager_BankAccountTypejqGrid_List';
var gridSortName = 'bank.bankCode';
var gridSortOrder = 'asc';
var gridCaption = 'ข้อมูลประเภทบัญชีธนาคาร';
var gridColNames = ['ลำดับ', 'ธนาคาร', 'ชื่อประเภทบัญชีธนาคาร', 'สถานะใช้งาน', ''];
var gridColModel = [
    {name: 'accTypeId', index: 'accTypeId', hidden: true, align: 'left'},
    {name: 'bankName', index: 'bankCode', align: 'left', sortable: true, width: 400},
    {name: 'accTypeName', index: 'accTypeName', align: 'left', sortable: true, width: 400},
    {name: 'status', index: 'status', align: 'center', sortable: false, width: 200},
    {name: 'action', index: 'action', width: 200, align: 'center', search: false, sortable: false}];
var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "accTypeId"           //the unique id of the row
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
        multiselect: false,
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
                var buttonStatus = '';
                var buttonEdit = '<button type="button" class="btn btn-xs btn-info" alt="Edit" onclick="onDialogEdit(\'' + id + '\');"><i class="ace-icon fa fa-pencil bigger-120"></i> </button>';
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDialogDelete(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                if ('E' === $(gridName).jqGrid('getCell', ids[i], 'status')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> ใช้งาน </button>';
                } else {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-danger"> <i class="ace-icon fa fa-ban bigger-120"></i> ไม่ใช้งาน </button>';
                }
                $(gridName).setRowData(ids[i], {action: buttonEdit + '&nbsp;' + buttonDelete, status: buttonStatus});
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

