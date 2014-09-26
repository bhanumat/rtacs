/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlForSearch = urlListQRY010_Search;
var gridNameForSearch = '#gridData_QRY010_For_Search_jqGrid_List';
var gridPagerForSearch = '#gridPager_QRY010_For_Search_jqGrid_List';
var gridSortNameForSearch = 'm.citizen_id';
var gridSortOrderForSearch = 'asc';
var gridCaptionForSearch = 'รายการผู้สมัครเป็นสมาชิก';
var gridColNamesForSearch = ['', 'เลิอก', 'หน่วยต้นสังกัด', 'เลขทะเบียนสมาชิก' , 'เลขประจำตัวประชาชน', 'ยศ - คำนำหน้า', 'ชื่อ', 'สกุล', '', 'สถานะใช้งาน'];
var gridColModelForSearch = [
    {name: 'memberId', index: 'm.member_id', hidden: true, align: 'left'},
    {name: 'myradio', index: 'm.member_id', align: 'center', width: 40, resizable: false, sortable: false, formatter: function(cellValue, option) {
            return '<input type="radio" name="rd_' + option.gid + '" />';
        }},
    {name: 'militaryName', index: 'm.military_name', align: 'left', sortable: true, width: 130},
    {name: 'memberCode', index: 'm.member_code', align: 'left', sortable: true, width: 130},
    {name: 'citizenId', index: 'm.citizen_id', align: 'left', sortable: true, width: 150},
    {name: 'rankOrTitleName', index: 'rankOrTitleName', align: 'left', sortable: false, width: 110},
    {name: 'name', index: 'm.name', align: 'left', sortable: true, width: 100},
    {name: 'surname', index: 'm.surname', align: 'left', sortable: true, width: 100},
    {name: 'memberStatusCode', index: 'm.member_status_code', hidden: true, align: 'left'},
    {name: 'status', index: 'status', align: 'center', sortable: false, width: 180}];
var gridJsonReaderForSearch = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "memberId"           //the unique id of the row
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
    $(gridNameForSearch).jqGrid({
        url: gridUrlForSearch,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaptionForSearch,
        colNames: gridColNamesForSearch,
        colModel: gridColModelForSearch,
        jsonReader: gridJsonReaderForSearch,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPagerForSearch,
        height: 310,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortNameForSearch,
        sortorder: gridSortOrderForSearch,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridNameForSearch).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, e) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        beforeSelectRow: function(rowid, e) {
            var radio = $(e.target).closest('tr').find('input[type="radio"]');
            radio.attr('checked', 'checked');
            return true; // allow row selection
        },
        loadComplete: function() {
            var ids = $(gridNameForSearch).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var buttonStatus = '';
                if ('105' === $(gridNameForSearch).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<button class="btn btn-xs btn-success"> อนุมัติขึ้นทะเบียนเป็นสมาชิก </button>';
                } else {
                    buttonStatus = '';
                }

                $(gridNameForSearch).setRowData(ids[i], {status: buttonStatus});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridNameForSearch).jqGrid('navGrid', gridPagerForSearch, {edit: false, add: false, del: false, search: false, refresh: false},
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

