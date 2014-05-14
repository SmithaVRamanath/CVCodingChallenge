<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="csss/ui.jqgrid.css" />
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/jquery.jqGrid.src.js" type="text/javascript"></script>
	<script type="text/javascript">
		jQuery("#schoolsList").jqGrid(
				{
					url : 'schools_numeracy_list.json',
					datatype : "json",
					colNames : [ 'Subject', 'Year 3' ],
					colModel : [ {
						name : 'subject',
						index : 'subject',
						width : 90
					}, {
						name : 'latestY3',
						index : 'latestY3',
						width : 100
					}],
					rowNum : 10,
					rowList : [ 10, 20, 30 ],
					pager : '#pager',
					sortname : 'id',
					viewrecords : true,
					sortorder : "subject",
					caption : "School Results"
				});
		jQuery("#list2").jqGrid('navGrid', '#pager', {
			edit : false,
			add : false,
			del : false
		});
	</script>
</head>
<body>
	<table id="schoolsList"></table>
	<div id="pager"></div>
</body>
</html>