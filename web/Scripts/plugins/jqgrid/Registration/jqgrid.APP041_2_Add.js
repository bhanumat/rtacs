/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrlAddAPP041_2 = urlListAPP041_2_Add;
var gridNameAddAPP041_2 = '#gridData_APP041_2_Add_jqGrid_List';
var gridPagerAddAPP041_2 = '#gridPager_APP041_2_Add_jqGrid_List';
var gridSortNameAddAPP041_2 = 'm.citizen_id';
var gridSortOrderAddAPP041_2 = 'asc';
var gridCaptionAddAPP041_2 = 'รายการผู้สมัครเป็นสมาชิก';
var gridColNamesAddAPP041_2 = ['ลำดับ', '', 'เลขประจำตัวประชาชน', 'ยศ - คำนำหน้า', 'ชื่อ', 'สกุล', '', 'ประเภทสมาชิก', 'หน่วยต้นสังกัด', 'วันที่สมัคร', '', 'ประเภทการสมัคร'];
var gridColModelAddAPP041_2 = [
    {name: 'memberId', index: 'm.member_id', hidden: true, align: 'left'},
    {name: 'memberCode', index: 'm.member_code', hidden: true, align: 'left'},
    {name: 'citizenId', index: 'm.citizen_id', align: 'left', sortable: true, width: 170},
    {name: 'rankOrTitleName', index: 'rankOrTitleName', align: 'left', sortable: false, width: 100},
    {name: 'name', index: 'm.name', align: 'left', sortable: true, width: 100},
    {name: 'surname', index: 'm.surname', align: 'left', sortable: true, width: 100},
    {name: 'memberGroupCode', index: 'm.member_group_code', align: 'left', hidden: true},
    {name: 'memberGroupCodeText', index: 'm.member_group_code', align: 'left', sortable: false, width: 100},
    {name: 'militaryName', index: 'm.military_name', align: 'left', sortable: false, width: 140},
    {name: 'applyDate', index: 'm.apply_date', align: 'left', sortable: true, width: 100,
        formatoptions: {newformat: 'd/m/Y'},
        formatter: function (cellval, opts, rowObject, action) {
            return $.fn.fmatter.call(
                    this,
                    "date",
                    new Date(cellval),
                    $.extend({}, $.jgrid.formatter.date, opts),
                    rowObject,
                    action);
        }},
    {name: 'memberTypeCode', index: 'm.member_type_code', align: 'left', hidden: true},
    {name: 'memberTypeCodeText', index: 'm.member_type_code', align: 'left', sortable: false, width: 120}];
var gridJsonReaderAddAPP041_2 = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "memberId"           //the unique id of the row
};
var updatePagerIcons = function (table) {
    var replacement =
            {
                'ui-icon-seek-first': 'ace-icon fa fa-angle-double-left bigger-140',
                'ui-icon-seek-prev': 'ace-icon fa fa-angle-left bigger-140',
                'ui-icon-seek-next': 'ace-icon fa fa-angle-right bigger-140',
                'ui-icon-seek-end': 'ace-icon fa fa-angle-double-right bigger-140'
            };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if ($class in replacement)
            icon.attr('class', 'ui-icon ' + replacement[$class]);
    });
};

//it causes some flicker when reloading or navigating grid
//it may be possible to have some custom formatter to do this as the grid is being created to prevent this
//or go back to default browser checkbox styles for the grid
var styleCheckbox = function (table) {
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

var enableTooltips = function (table) {
    $('.navtable .ui-pg-button').tooltip({container: 'body'});
    $(table).find('.ui-pg-div').tooltip({container: 'body'});
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridNameAddAPP041_2).jqGrid({
        //datastr: myStringList,
        //datatype: 'jsonstring',
        mtype: 'POST',
        url: gridUrlAddAPP041_2,
        datatype: 'json',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaptionAddAPP041_2,
        colNames: gridColNamesAddAPP041_2,
        colModel: gridColModelAddAPP041_2,
        jsonReader: gridJsonReaderAddAPP041_2,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPagerAddAPP041_2,
        height: 200,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortNameAddAPP041_2,
        sortorder: gridSortOrderAddAPP041_2,
        viewrecords: true,
        multiselect: true,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridNameAddAPP041_2).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function (id, e) {

        },
        ondblClickRow: function (id, rowid, colid, e) {
        },
        beforeSelectRow: function (rowid, e) {
            var radio = $(e.target).closest('tr').find('input[type="radio"]');
            radio.attr('checked', 'checked');
            return true; // allow row selection
        },
        loadComplete: function () {
            var ids = $(gridNameAddAPP041_2).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var memberGroupCode = '';
                var memberTypeCode = '';
                if ('10' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ข้าราชการ';
                } else if ('20' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ลูกจ้าง';
                } else if ('30' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ครอบครัว';
                } else if ('40' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'พลทหารกองประจำการ';
                } else {
                    memberGroupCode = 'ไม่ได้ระบุ';
                }

                if ('10' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครด้วยตัวเอง';
                } else if ('20' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านหน่วยต้นสังกัด';
                } else if ('30' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านชุดรับสมัคร';
                } else if ('40' === $(gridNameAddAPP041_2).jqGrid('getCell', ids[i], 'memberTypeCode')) {
                    memberTypeCode = 'สมัครผ่านกรณีพิเศษ';
                } else {
                    memberTypeCode = 'สมัครผ่านกรณีอื่นๆ';
                }

                $(gridNameAddAPP041_2).setRowData(ids[i], {memberGroupCodeText: memberGroupCode, memberTypeCodeText: memberTypeCode});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridNameAddAPP041_2).jqGrid('navGrid', gridPagerAddAPP041_2, {edit: false, add: false, del: false, search: false, refresh: false},
    {}, // edit options  
            {}, // add options  
            {}, //del options  
            {
                closeOnEscape: true,
                multipleSearch: true,
                closeAfterSearch: true
            }
    );
    $("#btnSearch").click(function (event) {
        event.preventDefault();
        onActionSearch();
    });

    $("#btnReload").click(function (event) {
        event.preventDefault();
        onActionSearch();
    });
});

