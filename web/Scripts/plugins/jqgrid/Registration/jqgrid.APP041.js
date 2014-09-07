/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var gridUrl = urlList;
var gridName = '#gridData_APP041jqGrid_List';
var gridPager = '#gridPager_APP041jqGrid_List';
var gridSortName = 'operationId'; //***
var gridSortOrder = 'asc';
var gridCaption = 'รายการขออนุมัติขึ้นทะเบียนสมาชิกใหม่ ';
var gridColNames = ['ลำดับที่', 'วันที่ขออนุมัติ', 'เลขที่อ้างอิงขออนุมัติ', 'จำนวนสมาชิก', 'สถานะ', ''];
var gridColModel = [
    {name: 'operationId', index: 'operationId', hidden: true, align: 'center', sortable: true},
    {name: 'docDate', index: 'docDate', align: 'left', sortable: true, width: 200,
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
    {name: 'docCode', index: 'docCode', align: 'left', sortable: true, width: 200},
    {name: 'amount', index: 'amount', align: 'left', sortable: true, width: 200},
    {name: 'operationTypeCode', index: 'operationTypeCode', align: 'left', sortable: true, width: 200},
    {name: 'action', index: 'action', width: 150, align: 'center', search: false, sortable: false}];
var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "operationId"           //the unique id of the row
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
                var operationTypeCode = '';
                var buttonView = '<button type="button" class="btn btn-xs btn-search" alt=View" onclick="onDialogView(\'' + id + '\');"><i class="ace-icon fa fa-search bigger-120"></i> </button>';

                if ('10' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'ยื่นใบสมัคร';
                } else if ('11' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'ชำระเงินค่าสมัคร';
                } else if ('12' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'บันทึกข้อมูลเพิ่มเติม';
                } else if ('13' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'อนุมัติเห็นชอบ';
                } else if ('20' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'กำหนดเลขทะเบียนสมาชิก';
                } else if ('25' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'ดำเนินการขออนุมัติขึ้นทะเบียน';
                } else if ('105' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'อนุมัติขึ้นทะเบียนเป็นสมาชิก';
                } else if ('232' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'ไม่อนุมััติขอความเห็นชอบ';
                } else if ('234' === $(gridName).jqGrid('getCell', ids[i], 'operationTypeCode')) {
                    operationTypeCode = 'ไม่อนุมัติขึ้นทะเบียน';
                }
                else {
                    operationTypeCode = '';
                }

                $(gridName).setRowData(ids[i], {action: buttonView, operationTypeCode: operationTypeCode});
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
});
