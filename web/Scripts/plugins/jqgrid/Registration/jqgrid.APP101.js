/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl = urlList;
var gridName = '#gridData_ExjqGrid_List';
var gridPager = '#gridPager_ExjqGrid_List';
var gridSortName = 'memberCode';
var gridSortOrder = 'asc';
var gridCaption = ' รายงานสรุปผู้สมัครสมาชิก';
var gridColNames = ['', 'วันที่สมัคร', 'ชื่อผู้สมัคร', 'หน่วยต้นสังกัด', 'สถานะภาพ', 'อายุ', 'ความเกี่ยวพัน', 'หมายเหตุ'];
var gridColModel = [
    {name: 'memberId', index: 'memberId', hidden: true, align: 'center'},
    {name: 'applyDate', index: 'applyDate', align: 'center', sortable: true, width: 90,
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
    {name: 'name', index: 'name', align: 'left', sortable: true, width: 110},
    //{name: 'name', index: 'name', align: 'left', sortable: true, width: 105},
    //{name: 'surname', index: 'surname', align: 'left', sortable: true, width: 105},
    {name: 'militaryName', index: 'militaryName', align: 'left', sortable: true},
    {name: 'memberStatusCode', index: 'memberStatusCode', align: 'center', sortable: true, width: 180},
    {name: '40', index: '40', align: 'center', sortable: true, width: 60},
    {name: 'referrerRelationshipCode', index: 'referrerRelationshipCode', align: 'center', sortable: true, width: 120},
    {name: 'remark', index: 'remark', align: 'left', sortable: true}];
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
                var memberStatusCode = '';
                var referrerRelationshipCode = '';
                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    memberStatusCode = ' ยื่นใบสมัคร';
                } else if ('11' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    memberStatusCode = 'ชำระเงินค่าสมัคร';
                } else if ('13' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    memberStatusCode = 'อนุมัติเห็นชอบ';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    memberStatusCode = ' กำหนดเลขทะเบียนสมาชิก';
                } else if ('25' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    memberStatusCode = 'ดำเนินการขออนุมัติขึ้นทะเบียน';
                } else if ('105' === $(gridName).jqGrid('getCell', ids[i], 'memberStatusCode')) {
                    memberStatusCode = 'อนุมัติขึ้นทะเบียนเป็นสมาชิก';
                } else {
                    memberStatusCode = '';
                }

                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'คู่สมรส';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'บุตร/ธิดา';
                } else if ('30' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'บิดา';
                } else if ('31' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'มารดา';
                } else if ('40' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'บิดาคู่สมรส';
                } else if ('41' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'มารดาคู่สมรส';
                } else if ('50' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'มารดาคู่สมรส';
                } else if ('60' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'มารดาคู่สมรส';
                } else if ('70' === $(gridName).jqGrid('getCell', ids[i], 'referrerRelationshipCode')) {
                    referrerRelationshipCode = 'เพื่อน';
                } else {
                    referrerRelationshipCode = '';
                }

                $(gridName).setRowData(ids[i], {memberStatusCode: memberStatusCode, referrerRelationshipCode: referrerRelationshipCode});
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

