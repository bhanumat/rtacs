/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl = urlListMAS010_2;
var gridName = '#gridData_MAS010_2_Edit_Select_jqGrid_List';
var gridPager = '#gridPager_MAS010_2_Edit_Select_jqGrid_List';
var gridSortName = 'citizenId';
var gridSortOrder = 'asc';
var gridCaption = 'รายการผู้สมัครเป็นสมาชิก';
var gridColNames = ['', 'ลำดับ', 'เลขประจำตัวประชาชน', 'ยส - คำนำหน้า', 'ชื่อ', 'สกุล', 'ประเภทสมาชิก', 'หน่วยต้นสังกัด', 'วันที่สมัคร', 'ประเภทการสมัคร', 'สถานะใช้งาน'];
var gridColModel = [
    {name: 'myradio', index: 'memberId', align: 'center', width: 30, resizable: false, sortable: false, formatter: function(cellValue, option) {
            return '<input type="radio" name="rd_' + option.gid + '" />';
        }},
    {name: 'memberId', index: 'memberId', hidden: true, align: 'left'},
    {name: 'citizenId', index: 'citizenId', align: 'left', sortable: true, width: 150},
    {name: 'rankOrTitleName', index: 'rankOrTitleName', align: 'left', sortable: true, width: 50},
    {name: 'name', index: 'name', align: 'left', sortable: true, width: 100},
    {name: 'surname', index: 'surname', align: 'left', sortable: true, width: 100},
    {name: 'memberTypeCode', index: 'memberTypeCode', align: 'left', sortable: true, width: 100},
    {name: 'militaryName', index: 'militaryName', align: 'left', sortable: true, width: 100},
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
    {name: 'memberCode', index: 'memberCode', align: 'left', sortable: true, width: 100},
    {name: 'status', index: 'status', align: 'center', sortable: false, width: 200}];
var gridJsonReader = {
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
            var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var buttonStatus = '';
                var memberGroupCode = '';
                var memberTypeCode = '';
                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<span class="label label-yellow "> ยื่นใบสมัคร </span>';
                } else if ('11' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<span class="label label-success ">ชำระเงินค่าสมัคร</span>';
                } else if ('13' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<span class="label label-yellow "> อนุมัติเห็นชอบ </span>';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<span class="label label-yellow ">  กำหนดเลขทะเบียนสมาชิก </span>';
                } else if ('25' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<span class="label label-pink  ">  ดำเนินการขออนุมัติขึ้นทะเบียน </span>';
                } else if ('105' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    buttonStatus = '<span class="label label-success ">  อนุมัติขึ้นทะเบียนเป็นสมาชิก </span>';
                } else {
                    buttonStatus = '';
                }
                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ข้าราชการ';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ลูกจ้าง';
                } else if ('30' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ครอบครัว';
                } else if ('40' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'พลทหารกองประจำการ';
                } else {
                    memberGroupCode = 'ไม่ได้ระบุ';
                }

                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครด้วยตัวเอง';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านหน่วยต้นสังกัด';
                } else if ('30' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านชุดรับสมัคร';
                } else if ('40' === $(gridName).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านกรณีพิเศษ';
                } else {
                    memberTypeCode = 'สมัครผ่านกรณีอื่นๆ';
                }

                $(gridName).setRowData(ids[i], {memberStatusCode: buttonStatus, memberGroupCode: memberGroupCode, memberTypeCode: memberTypeCode});
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

