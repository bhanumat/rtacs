/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl = urlList;
var gridName = '#gridData_PaymentMemberGrid_List';
var gridPager = '#gridPager_PaymentMemberGrid_List';
var gridSortName = 'operationMemberId';
var gridSortOrder = 'asc';
var gridCaption = 'รายชื่อสมาชิก';
var gridColNames = ['','ลำดับ', 'วันที่ขำระเงิน', 'เลขที่ใบเสร็จ', 'หน่วยต้นสังกัด','เลขประจำตัวประชาชน','ยศ-คำนำหน้า','ชื่อ','นามสกุล','จำนวนเงิน','สถานะ', ''];
var gridColModel = [
    {name: "checked", width: 30, align: 'center', editable:true, edittype:'checkbox',formatter: 'checkbox', 
     editoptions: {value:"True:False"},formatoptions: { disabled: false},frozen:true},
    //{name: "checked", width: 30, align: 'center',formatter: 'checkbox',editoptions: {value:"True:False"} },
    {name: 'operationMemberId', index: 'operationMemberId', hidden: true, align: 'left'},
    {name: 'docDate',       index: 'docDate',       align: 'center', sortable: true, width: 100,
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
    {name: 'docCode',       index: 'docCode',       align: 'center', sortable: true, width: 100},
    {name: 'militaryName',  index: 'militaryName',  align: 'center', sortable: true, width: 150},
    {name: 'citizenID',     index: 'citizenID',     align: 'center', sortable: true, width: 150},
    {name: 'title',         index: 'title',         align: 'center', sortable: true, width: 100},
    {name: 'name',          index: 'name',          align: 'center', sortable: true, width: 150},
    {name: 'surname',       index: 'surname',       align: 'center', sortable: true, width: 150},
    {name: 'amount',        index: 'amount',        align: 'right',  sortable: true, width: 100},
    {name: 'printedStatus', index: 'printedStatus', align: 'center', sortable: true, width: 150},
    {name: 'action',        index: 'action',        align: 'center', sortable: false,width: 100,  search: false}];
var gridJsonReader = {
    records: "records", //total number of records for the query
    repeatitems: false,
    id: "operationMemberId"           //the unique id of the row
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
        url: urlList,
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
                var operationMemberId = $(gridName).jqGrid('getCell', ids[i], 'operationMemberId');
                var buttonStatus = '';
                var buttonEdit = '<button type="button" class="btn btn-xs btn-info" alt="Edit" onclick="onDialogEdit(\'' + operationMemberId + '\');"><i class="ace-icon fa fa-pencil bigger-120"></i> </button>';
                var buttonDelete = '<button type="button" class="btn btn-xs btn-danger" alt="Delete" onclick="onDialogDelete(\'' + id + '\');"><i class="ace-icon fa fa-trash-o bigger-120"></i> </button>';
                if ('Y' === $(gridName).jqGrid('getCell', ids[i], 'printedStatus')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> พิมพ์ใบเสร็จ </button>';
                } else if ('N' === $(gridName).jqGrid('getCell', ids[i], 'printedStatus')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-success"> <i class="ace-icon fa fa-check bigger-120"></i> ยังไม่พิมพ์ใบเสร็จ </button>';
                } else if ('C' === $(gridName).jqGrid('getCell', ids[i], 'printedStatus')) {
                    buttonStatus = '<button type="button" class="btn btn-xs btn-danger"> <i class="ace-icon fa fa-ban bigger-120"></i> ยกเลิกใบเสร็จ </button>';
                    $(gridName).jqGrid('setCell', ids[i], 'checked', '','',{style:"visibility: hidden"});
                    
                } 
                $(gridName).setRowData(ids[i], { action: buttonEdit + '&nbsp;' + buttonDelete, printedStatus: buttonStatus});
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

