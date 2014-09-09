/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlAdd = urlListAPP031_2_Add;
var gridNameAdd = '#gridData_APP031_2_Add_jqGrid_List';
var gridPagerAdd = '#gridPager_APP031_2_Add_jqGrid_List';
var gridSortNameAdd = 'citizenId';
var gridSortOrderAdd = 'asc';
var gridCaptionAdd = 'รายการผู้สมัครเป็นสมาชิก';
var gridColNamesAdd = ['ลำดับ','', 'เลขประจำตัวประชาชน', 'ยศ - คำนำหน้า', 'ชื่อ', 'สกุล', '', 'ประเภทสมาชิก', 'หน่วยต้นสังกัด', 'วันที่สมัคร', '', 'ประเภทการสมัคร'];
var gridColModelAdd = [
    {name: 'memberId', index: 'memberId', hidden: true, align: 'left'},
    {name: 'memberCode', index: 'memberCode', hidden: true, align: 'left'},
    {name: 'citizenId', index: 'citizenId', align: 'left', sortable: true, width: 170},
    {name: 'rankOrTitleName', index: 'rankOrTitleName', align: 'left', sortable: true, width: 100},
    {name: 'name', index: 'name', align: 'left', sortable: true, width: 100},
    {name: 'surname', index: 'surname', align: 'left', sortable: true, width: 100},
    {name: 'memberGroupCode', index: 'memberGroupCode', align: 'left', hidden: true},
    {name: 'memberGroupCodeText', index: 'memberGroupCodeText', align: 'left', sortable: true, width: 100},
    {name: 'militaryName', index: 'militaryName', align: 'left', sortable: true, width: 140},
    {name: 'applyDate', index: 'applyDate', align: 'left', sortable: true, width: 100,
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
    {name: 'memberTypeCode', index: 'memberTypeCode', align: 'left', hidden: true},
    {name: 'memberTypeCodeText', index: 'memberTypeCodeText', align: 'left', sortable: true, width: 120}];
var gridJsonReaderAdd = {
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
    $(gridNameAdd).jqGrid({
        //datastr: myStringList,
        //datatype: 'jsonstring',
        mtype: 'POST',
        url: urlAddLoad,
        datatype: 'json',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaptionAdd,
        colNames: gridColNamesAdd,
        colModel: gridColModelAdd,
        jsonReader: gridJsonReaderAdd,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPagerAdd,
        height: 200,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortNameAdd,
        sortorder: gridSortOrderAdd,
        viewrecords: true,
        multiselect: true,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridNameAdd).jqGrid("getGridParam", "colModel");
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
            var ids = $(gridNameAdd).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var memberGroupCode = '';
                var memberTypeCode = '';
                if ('10' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ข้าราชการ';
                } else if ('20' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ลูกจ้าง';
                } else if ('30' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ครอบครัว';
                } else if ('40' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'พลทหารกองประจำการ';
                } else {
                    memberGroupCode = 'ไม่ได้ระบุ';
                }

                if ('10' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครด้วยตัวเอง';
                } else if ('20' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านหน่วยต้นสังกัด';
                } else if ('30' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านชุดรับสมัคร';
                } else if ('40' === $(gridNameAdd).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านกรณีพิเศษ';
                } else {
                    memberTypeCode = 'สมัครผ่านกรณีอื่นๆ';
                }

                $(gridNameAdd).setRowData(ids[i], {memberGroupCodeText: memberGroupCode, memberTypeCodeText: memberTypeCode});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridNameAdd).jqGrid('navGrid', gridPagerAdd, {edit: false, add: false, del: false, search: false, refresh: false},
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

