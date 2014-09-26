/*
 * Author Date : 2014-08-02 00:25:00
 */

//================================== Parameter jqGrid ========================================
var gridUrl_CHT010 = urlList_CHT010;
var gridName_CHT010 = '#gridData_CHT010Grid_List';
var gridPager_CHT010 = '#gridPager_CHT010Grid_List';
var gridSortName_CHT010 = 'm.name, m.surname';
var gridSortOrder_CHT010 = 'asc';
var gridCaption_CHT010 = 'รายชื่อสมาชิก';
var gridColNames_CHT010 = ['', '', '', '', '', '', '', 'วันที่ขอเปลี่ยนแปลง', 'หน่วยต้นสังกัด', 'เลขทะเบียนสมาชิก','ยศ-คำนำหน้า ชื่อ สกุล เดิม','ยศ-คำนำหน้า ชื่อ สกุล ใหม่','ประเภทการเปลี่ยนแปลง','สถานะ','หมายเหตุ'];
var gridColModel_CHT010 = [
    {name: "checked", width: 30, align: 'center', editable:true, edittype:'checkbox',formatter: 'checkbox', 
     editoptions: {value:"True:False"},formatoptions: { disabled: false},frozen:true},
    {name: 'memberId', index: 'memberId', hidden: true, align: 'left'},
    {name: 'titleameHistoryId', index: 'titleameHistoryId', hidden: true, align: 'left'},
    {name: 'titleId', index: 'titleId', hidden: true, align: 'left'},
    {name: 'rankId', index: 'rankId', hidden: true, align: 'left'},
    {name: 'nameHidden', index: 'nameHidden', hidden: true, align: 'left'},
    {name: 'surnameHidden', index: 'surnameHidden', hidden: true, align: 'left'},
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
    {name: 'militaryName',  index: 'militaryName', align: 'left', sortable: true, width: 150},
    {name: 'memberCode',    index: 'memberCode',   align: 'left', sortable: true, width: 130},
    {name: 'oldName',       index: 'oldName',      align: 'left', sortable: true, width: 200},
    {name: 'newName',       index: 'newName',      align: 'left', sortable: true, width: 200},
    {name: 'fileTypeCode',  index: 'fileTypeCode', align: 'left', sortable: true, width: 150},
    {name: 'approved',      index: 'approved',     align: 'left', sortable: true, width: 120},
    {name: 'remark',        index: 'remark',       align: 'left',  sortable: true, width: 200}];
var gridJsonReader_CHT010 = {
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
    $(gridName_CHT010).jqGrid({
        url: gridUrl_CHT010,
        datatype: 'json',
        mtype: 'POST',
        //datatype: "local",
        //================================ Field Data ========================================
        caption: gridCaption_CHT010,
        colNames: gridColNames_CHT010,
        colModel: gridColModel_CHT010,
        jsonReader: gridJsonReader_CHT010,
        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager_CHT010,
        height: 350,
        width: 'auto',
        rowNum: 10,
        sortname: gridSortName_CHT010,
        sortorder: gridSortOrder_CHT010,
        viewrecords: true,
        multiselect: false,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function(rowid, iCol, cellcontent, e) {
            var cm = $(gridName_CHT010).jqGrid("getGridParam", "colModel");
            if ("cb" !== cm[iCol].name && "action" !== cm[iCol].name) {

            }
        },
        onSelectRow: function(id, event) {

        },
        ondblClickRow: function(id, rowid, colid, e) {
        },
        loadComplete: function() {
            
            var ids = $(gridName_CHT010).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var approved = '';
                var fileTypeCode = '';
                //alert("memberId : " + memberId + "\napproved:>>" + $(gridName_CHT010).jqGrid('getCell', ids[i], 'approved') + "<<");
                if ('0' === $(gridName_CHT010).jqGrid('getCell', ids[i], 'approved')) {
                    approved = 'อยู่ระหว่างดำเนินการ';
                } else if ('1' === $(gridName_CHT010).jqGrid('getCell', ids[i], 'approved')) {
                    approved = 'ได้รับอนุมัติแล้ว';
                    $(gridName_CHT010).jqGrid('setCell', ids[i], 'checked', '','',{style:"visibility: hidden"});
                } else if ('2' === $(gridName_CHT010).jqGrid('getCell', ids[i], 'approved')) {
                    approved = 'ไม่ผ่านการอนุมัติ';    
                    $(gridName_CHT010).jqGrid('setCell', ids[i], 'checked', '','',{style:"visibility: hidden"});
                } 
                
                if ('10' === $(gridName_CHT010).jqGrid('getCell', ids[i], 'fileTypeCode')) {
                    fileTypeCode = 'แจ้งด้วยตนเอง';
                } else if ('20' === $(gridName_CHT010).jqGrid('getCell', ids[i], 'fileTypeCode')) {
                    fileTypeCode = 'แจ้งผ่านหน่วยต้นสังกัด';
                }else if ('90' === $(gridName_CHT010).jqGrid('getCell', ids[i], 'fileTypeCode')) {
                    fileTypeCode = 'กาก';
                }

                $(gridName_CHT010).setRowData(ids[i], { approved: approved , fileTypeCode:fileTypeCode});
            }
            enableTooltips(this);
            //styleCheckbox(this);
            updatePagerIcons(this);
        }
    });
    $(gridName_CHT010).jqGrid('navGrid', gridPager_CHT010, {edit: false, add: false, del: false, search: false, refresh: false},
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

