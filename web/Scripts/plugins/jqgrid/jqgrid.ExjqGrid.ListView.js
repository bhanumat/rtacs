/*
* Author Date : 2014-05-18 22:00:00
*/

//================================== Parameter jqGrid ========================================
var gridUrl = urlList;
var gridName = '#gridData_ExjqGrid_List';
var gridPager = '#gridPager_ExjqGrid_List';
var gridSortName = 'id';
var gridSortOrder = 'desc';
var gridCaption = '<div style="height:40px;">' +
                    '<button type="button" id="btnAdd" type="button" class="btn btn-primary" style="font-size: 14px;"><i class="glyphicon glyphicon-plus"></i>&nbsp; Add</button>&nbsp;' +
                    '<button type="button" id="btnDelete"  type="button" class="btn btn-primary" style="font-size: 14px;"><i class="glyphicon glyphicon-minus"></i>&nbsp;Delete</button>&nbsp;' +
                    '<button type="button" id="btnReload"  type="button" class="btn btn-primary" style="font-size: 14px;"><i class="glyphicon glyphicon-repeat"></i>&nbsp;Reload</button>&nbsp;' +
                  '</div>';
var gridColNames = ['', 'Id', 'Client', 'Date', 'Amount', 'Tax', 'Total', 'Closed', 'Shipped via', 'Notes'];
var gridColModel = [
          { name: 'action', index: 'action', width: 30, align: 'center', search: false, sortable: false },
          { name: 'id', index: 'id', hidden: true, align: 'left' },
          { name: 'name', index: 'name', align: 'left' },
          { name: 'invdate', index: 'invdate', align: 'center', sortable: true },
          { name: 'amount', index: 'amount', align: 'left', sortable: false },
          { name: 'tax', index: 'tax', align: 'left', sortable: false },
          { name: 'total', index: 'total', align: 'left', sortable: true },
          { name: 'closed', index: 'closed', align: 'left', sortable: true },
          { name: 'ship_via', index: 'ship_via', align: 'center', sortable: false },
          { name: 'note', index: 'note', align: 'center', sortable: false }];
var gridJsonReader = {
    records: "Records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function () {
    $(gridName).jqGrid({
        /*url: gridUrl,
        datatype: 'json',
        mtype: 'POST',*/
		datatype: "local",
        data: mydata,
        //================================ Field Data ========================================
        caption: gridCaption,
        colNames: gridColNames,
        colModel: gridColModel,
        jsonReader: gridJsonReader,

        //================================ End Field Data ====================================
        autowidth: true,
        shrinkToFit: false,
        pager: gridPager,
        height: 300,
        width: 'auto',
        rowNum: 10,
        rowList: [10, 20, 40, 50, 100],
        sortname: gridSortName,
        sortorder: gridSortOrder,
        viewrecords: true,
        multiselect: true,
        rownumbers: true,
        gridview: true,
        hidegrid: false,
        onCellSelect: function (rowid, iCol, cellcontent, e) {
            var cm = $(gridName).jqGrid("getGridParam", "colModel");
            if ("cb" != cm[iCol].name && "action" != cm[iCol].name) {
                
            }
        },
        onSelectRow: function (id, event) {

        },
        ondblClickRow: function (id, rowid, colid, e) {
        },
        loadComplete: function () {
			var ids = $(gridName).jqGrid('getDataIDs');
            for (var i = 0; i < ids.length; i++) {
                var id = ids[i];
                var div = "<div style=\"margin-left:5px;\">";
                var buttonEdit = "<div onmouseout=\"$(this).removeClass('ui-state-hover')\""
                + " onmouseover=\"$(this).addClass('ui-state-hover');\" class=\"ui-pg-div ui-inline-edit\""
                + " onclick=\"onEdit('" + id + "');\" style=\"float:left;cursor:pointer;\"><i title=\"Edit\" class=\"glyphicon glyphicon-edit\">"
                + "</i></div>";
                var endDiv = "</div>";
                $(gridName).setRowData(ids[i], { action: div + buttonEdit + endDiv });
            }
        }
    });

    $(gridName).jqGrid('navGrid', gridPager, { edit: false, add: false, del: false, search: false, refresh: false },
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

