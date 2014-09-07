/*
 * Author Date : 2014-05-18 22:00:00
 */

//================================== Parameter jqGrid ========================================
        var gridUrl = '';
var gridName = '#gridData_Menu_List';
var gridPager = '#gridPager_Menu_List';
var gridSortName = 'id';
var gridSortOrder = 'desc';
var gridCaption = '';
var gridColNames = ['id', 'Name', 'MenuId', 'Menu Name'];
var gridColModel = [
    {name: 'id', index: 'id', width: 100, hidden: true},
    {name: 'Name', index: 'Name'},
    {name: 'MenuId', index: 'MenuId', width: 100, hidden: true},
    {name: 'MenuName', index: 'MenuName', width: 100, hidden: true}];
var gridJsonReader = {
    records: "Records", //total number of records for the query
    repeatitems: false,
    id: "id"           //the unique id of the row
};

//================================== End Parameter jqGrid ====================================

$(document).ready(function() {
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
        //jsonReader: gridJsonReader,
        //================================ End Field Data ====================================
        autowidth: true,
        //shrinkToFit: false,
        height: 'auto',
        width: 'auto',
        rowNum: 9999,
        //rowList: [10, 20, 40, 50, 100],
        sortname: gridSortName,
        sortorder: gridSortOrder,
        //viewrecords: true,
        //multiselect: false,
        //rownumbers: false,
        //gridview: true,
        //hidegrid: false,
        treeGrid: true,
        treeGridModel: 'adjacency',
        treedatatype: "local",
        ExpandColumn: 'Name'
    });
    $(gridName)[0].addJSONData({
        total: 1,
        page: 1,
        records: mydata.length,
        rows: mydata
    });

});

