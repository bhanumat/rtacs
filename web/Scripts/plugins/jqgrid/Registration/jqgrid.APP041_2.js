/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var gridUrl = urlLoad041_2;
var gridName = '#gridData_APP041_2jqGrid_List';
var gridPager = '#gridPager_APP041_2jqGrid_List';
var gridSortName = 'm.member_id'; //***
var gridSortOrder = 'asc';
var gridCaption = 'รายการขอความเห็นชอบสมาชิกใหม่ ';
var gridColNames = ['ลำดับ', 'เลขทะเบียนสมาชิก', 'เลขประจำตัวประชาชน', 'ยศ - คำนำหน้า', 'ชื่อ', 'สกุล', 'ประเภทสมาชิก', 'หน่วยต้นสังกัด', 'วันที่สมัคร', 'ประเภทการสมัคร', ''];
var gridColModel = [
    {name: 'memberId', index: 'm.member_id', hidden: true, align: 'left'},
    {name: 'memberCode', index: 'm.member_code', hidden: true, align: 'left'},
    {name: 'citizenId', index: 'm.citizen_id', align: 'left', sortable: true, width: 170},
    {name: 'rankOrTitleName', index: 'rankOrTitleName', align: 'left', sortable: false, width: 100},
    {name: 'name', index: 'm.name', align: 'left', sortable: true, width: 100},
    {name: 'surname', index: 'm.surname', align: 'left', sortable: true, width: 100},
    {name: 'memberGroupCode', index: 'memberGroupCode', align: 'left', sortable: true, width: 130},
    {name: 'militaryName', index: 'm.military_name', align: 'left', sortable: true, width: 140},
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
    {name: 'action', index: 'action', width: 80, align: 'center', search: false, sortable: false}];
var gridJsonReader = {
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
$(document).ready(function () {
    $(gridName).jqGrid({
        datastr: myStringList,
        datatype: 'jsonstring',
        mtype: 'POST',
        //datatype: 'local',
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
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridName).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {
                //$(gridName).jqGrid('delRowData',rowid);
            }
        },
        onSelectRow: function (id, event) {

        },
        ondblClickRow: function (id, rowid, colid, e) {
            //alert("id : " + id + " rowid : " + rowid + " colid : " + colid);

            //$(gridName).jqGrid('delRowData',rowid);
        },
        loadComplete: function () {
            var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var memberTypeCode = '';
                var memberGroupCode = '';
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDeleteRow(\'' + i + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';

                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ข้าราชการ';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ลูกจ้าง';
                } else if ('30' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'ครอบครัว';
                } else if ('40' === $(gridName).jqGrid('getCell', ids[i], 'memberGroupCode')) {
                    memberGroupCode = 'พลทหารกองประจำการ';
                } else {
                    memberGroupCode = '';
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
                    memberTypeCode = '';
                }
                if ($('#operationId').val() === null || $('#operationId').val() === "") {
                    $(gridName).setRowData(ids[i], {action: buttonDelete, memberTypeCode: memberTypeCode, memberGroupCode: memberGroupCode});
                } else {
                    $(gridName).setRowData(ids[i], {memberTypeCode: memberTypeCode, memberGroupCode: memberGroupCode});
                }
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
});
