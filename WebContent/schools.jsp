<html>
<head>
<link rel="stylesheet" type="text/css"
	href="css/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css"
	href="css/smoothness/jquery-ui-1.10.4.custom.css" />

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.src.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		jQuery("#schoolsList").jqGrid({
			url : 'schoolList',
			datatype : 'json',
			colNames : [  'School','Subject','Year 3','Year 5' ,'Year 7','Year 9'],
			colModel : [ {
				name : 'school.schoolName',
				index : 'school.schoolName',
				width : 200
			}, {
				name : 'subject',
				index : 'subject',
				width : 100
			},
			{
				name : 'latestY3',
				index : 'latestY3',
				width : 100
			},
			{
				name : 'latestY5',
				index : 'latestY5',
				width : 100
			},{
				name : 'latestY7',
				index : 'latestY7',
				width : 100
			},{
				name : 'latestY9',
				index : 'latestY9',
				width : 100
			} ],
			rowNum : 10,
			rowList : [ 10, 20, 30 ],
			pager : '#pager',
			sortname : 'subject',
			viewrecords : true,
			sortorder : 'subject',
			caption : 'School Results'
		});
		jQuery("#schoolsList").jqGrid('navGrid', '#pager', {
			edit : false,
			add : false,
			del : false
		});
	});
</script>
</head>
<body>
	<table id="schoolsList"></table>
	<div id="pager"></div>
</body>
</html>