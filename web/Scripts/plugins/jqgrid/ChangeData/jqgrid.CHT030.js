/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
// TAB4
var gridUrl_TAB4_CHT030 = urlList_TAB4_CHT030;
var gridName_TAB4_CHT030 = '#gridData_TAB4_CHT030Grid_List';
var gridPager_TAB4_CHT030 = '#gridPager_TAB4_CHT030Grid_List';
var gridSortName_TAB4_CHT030 = 'm.name, m.surname';
var gridSortOrder_TAB4_CHT030 = 'asc';
var gridCaption_TAB4_CHT030 = 'รายชื่อสมาชิก';
var gridColNames_TAB4_CHT030 = ['', 'งวดเดือน', 'ศพที่', 'จำนวนเงิน', 'วันที่ชำระ', 'วิธีการชำระ', 'ชำระแล้ว', 'ชำระเกิน', 'ชำระที่หน่วย', 'เลขที่อ้างอิง','ผู้บันทึก','หมายเหตุ'];
var gridColModel_TAB4_CHT030 = [
    {name: 'memberId', index: 'memberId', hidden: true, align: 'left'},
    {name: 'titleameHistoryId', index: 'titleameHistoryId', align: 'left', sortable: true, width: 80},
    {name: 'titleId', index: 'titleId', align: 'left', sortable: true, width: 80},
    {name: 'createdDate',       index: 'createdDate',       align: 'center', sortable: true, width: 130,
        formatoptions: {newformat: 'd/m/Y'},
        formatter: function(cellval, opts, rowObject, action) {
            return $.fn.fmatter.call(
                    this,
                    "date",
                    new Date(cellval),
                    $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject,
                    action);
        }},
    {name: 'rankId', index: 'rankId', align: 'left', sortable: true, width: 80},
    {name: 'nameHidden', index: 'nameHidden', align: 'left', sortable: true, width: 80},
    {name: 'surnameHidden', index: 'surnameHidden', align: 'left', sortable: true, width: 80},
    {name: 'militaryName',  index: 'militaryName', align: 'left', sortable: true, width: 80},
    {name: 'memberCode',    index: 'memberCode',   align: 'left', sortable: true, width: 80},
    {name: 'oldName',       index: 'oldName',      align: 'left', sortable: true, width: 80},
    {name: 'newName',       index: 'newName',      align: 'left', sortable: true, width: 80},
    {name: 'remark',        index: 'remark',       align: 'left',  sortable: true, width: 200}];
var gridJsonReader_TAB4_CHT030 = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "titleameHistoryId"           //the unique id of the row
};

//  TAB 5
var gridUrl_TAB5_CHT030 = urlList_TAB4_CHT030;
var gridName_TAB5_CHT030 = '#gridData_TAB5_CHT030Grid_List';
var gridPager_TAB5_CHT030 = '#gridPager_TAB5_CHT030Grid_List';
var gridSortName_TAB5_CHT030 = 'm.name, m.surname';
var gridSortOrder_TAB5_CHT030 = 'asc';
var gridCaption_TAB5_CHT030 = 'รายชื่อสมาชิก';
var gridColNames_TAB5_CHT030 = ['', 'วันที่ชำระ', 'สถานภาพสมาชิก', 'ผู้บันทึก'];
var gridColModel_TAB5_CHT030 = [
    {name: 'memberId', index: 'memberId', hidden: true, align: 'left'},
    {name: 'createdDate',       index: 'createdDate',       align: 'center', sortable: true, width: 130,
        formatoptions: {newformat: 'd/m/Y'},
        formatter: function(cellval, opts, rowObject, action) {
            return $.fn.fmatter.call(
                    this,
                    "date",
                    new Date(cellval),
                    $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject,
                    action);
        }},
    {name: 'newName',       index: 'newName',      align: 'left', sortable: true, width: 150},
    {name: 'remark',        index: 'remark',       align: 'left',  sortable: true, width: 80}];
var gridJsonReader_TAB5_CHT030 = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "titleameHistoryId"           //the unique id of the row
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
    //TAB4
    $(gridName_TAB4_CHT030).jqGrid({
        url: gridUrl_TAB4_CHT030,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaption_TAB4_CHT030,
        colNames: gridColNames_TAB4_CHT030,
        colModel: gridColModel_TAB4_CHT030,
        jsonReader: gridJsonReader_TAB4_CHT030,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager_TAB4_CHT030,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName_TAB4_CHT030,
        sortorder: gridSortOrder_TAB4_CHT030,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridName_TAB4_CHT030).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            
            var ids = $(gridName_TAB4_CHT030).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridName_TAB4_CHT030).jqGrid('navGrid', gridPager_TAB4_CHT030, {edit: false, add: false, del: false, search: false, refresh: false},
    {}, // edit options  
            {}, // add options  
            {}, //del options  
            {
                closeOnEscape: true,
                multipleSearch: true,
                closeAfterSearch: true
            }
    );
    
    //TAB5
   $(gridName_TAB5_CHT030).jqGrid({
        url: gridUrl_TAB5_CHT030,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaption_TAB5_CHT030,
        colNames: gridColNames_TAB5_CHT030,
        colModel: gridColModel_TAB5_CHT030,
        jsonReader: gridJsonReader_TAB5_CHT030,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager_TAB5_CHT030,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName_TAB5_CHT030,
        sortorder: gridSortOrder_TAB5_CHT030,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridName_TAB5_CHT030).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            
            var ids = $(gridName_TAB5_CHT030).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridName_TAB5_CHT030).jqGrid('navGrid', gridPager_TAB5_CHT030, {edit: false, add: false, del: false, search: false, refresh: false},
    {}, // edit options  
            {}, // add options  
            {}, //del options  
            {
                closeOnEscape: true,
                multipleSearch: true,
                closeAfterSearch: true
            }
    );
});

