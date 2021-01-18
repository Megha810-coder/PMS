<%@page import="com.spcl.erp.services.TransferService"%>
<%@page import="com.spcl.erp.model.Transfer"%>
<%@page import="java.util.List"%>
<%@page import="com.spcl.erp.helper.Helper"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<% 	String contextPath = request.getContextPath(); 
TransferService transferService=(TransferService)request.getAttribute("transferService");
Transfer transfer_lable=new Transfer();
Helper helper = (Helper)request.getAttribute("helper");
/* String lable=transfer_lable.getTra_lable(); */

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<!-- Data Table Css -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/pages/data-table/css/buttons.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/css/component.css">
<!-- sweet alert framework -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/sweetalert/css/sweetalert.css">

<body>
<%-- <jsp:include page="/WEB-INF/includes/loader.jsp"></jsp:include> --%>

<div id="pcoded" class="pcoded">
<div class="pcoded-overlay-box"></div>
<div class="pcoded-container navbar-wrapper">
<!-- Add horizantal menu here -->
<jsp:include page="/WEB-INF/includes/horizantal_nav_menu.jsp"></jsp:include>

<div class="pcoded-main-container">
<div class="pcoded-wrapper">
<!-- Add vertical menu here -->
<jsp:include page="/WEB-INF/includes/vertical_nav_menu.jsp"></jsp:include>
<div class="pcoded-content">
<div class="pcoded-inner-content">
<div class="main-body">
<div class="page-wrapper">
<!-- Add pagebody here -->
<div id="page_body" >
<div class="page-body invoice-list-page">
<div class="row">
<div class="col-xl-12 col-lg-12 filter-bar">
<!-- Navigation start -->
<nav class="navbar navbar-light bg-faded m-b-30 p-10">
    <div class="card-block">
    	<div class=" waves-effect waves-light m-r-10 v-middle issue-btn-group">
        	<button rel="<%=contextPath %>/transfer/create_transfer" id="create_transfer" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Create</span></button>
        	<div class="btn-group m-b-5 m-t-5">
                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-ui-user"></i></button>
                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-edit-alt"></i></button>
                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-reply"></i></button>
                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-printer"></i></button>
            </div>
		</div>
		<div class="card-block p-t-10">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search here...">
                <span class="input-group-addon" id="basic-addon1"><i class="icofont icofont-search"></i></span>
            </div>
        </div>
		
	</div>
    
   
    
    <div class="nav-item nav-grid">
        <span class="m-r-15">View Mode: </span>
        <button type="button" class="btn btn-sm btn-primary waves-effect waves-light m-r-10" data-toggle="tooltip" data-placement="top" title="list view"  id="list_view">
            <i class="icofont icofont-listine-dots"></i>
        </button>
        <button type="button" class="btn btn-sm btn-primary waves-effect waves-light" data-toggle="tooltip" data-placement="top" title="grid view" id="grid_view">
            <i class="icofont icofont-table"></i>
        </button>
    </div>

</nav>
<!-- Navigation end  -->

<div id="list">
  	<div class="col-xl-12 card">
    	<div class="">
        	<!-- bug list card start -->
    		<div>
                <div class="card-header">
                    <h5>Transfer List</h5>
                    <div class="card-header-right">
                        <i class="icofont icofont-spinner-alt-5"></i>
                    </div>
                </div>
                <div class="card-block">
                    <div class="table-responsive">
                        <table id="issue-list-table" class="table dt-responsive width-100">
                            <thead class="text-left">
                                <tr>
                                    <th>Sr no</th>
                                    <th>Operation Type</th>
                                    <th>Source</th>
                                  	<th>Status</th>
                                    <th>Action</th>
                                  </tr>
                            </thead>
                        	<tbody class="text-left">
                            	<% 
                            	List<Transfer> transferList=(List<Transfer>)request.getAttribute("TRANSFERLIST");
                            		if(transferList!=null&&!transferList.isEmpty()){
                            			int idx_num=1;
                            			int index=1;
                            			for (Transfer transfer : transferList) {
                            	%>
                        		<tr>
									<td class="txt-primary"><%=index++%></td>
	                                <td><%=transfer.getErp_operation().getOperation()%></td>
	                                <td><%=transfer.getTra_source() %></td>
	                                <td><%=helper.getStatusLable(transfer) %></td>
							        <td>
							        	<%=transferService.getAllButton(transfer,contextPath).toString() %>
							        	<%-- <button href="javscript:void(0);" rel="<%=contextPath %>/transfer/view_transfer?tra_id=<%=transfer.getTra_id() %>" class="btn btn-info btn-mini b-none view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
                           				<button href="javscript:void(0);" rel="<%=contextPath %>/transfer/edit_transfer?tra_id=<%=transfer.getTra_id() %>" class="btn btn-warning btn-mini b-none edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
                          				<button href="javscript:void(0);" rel="<%=contextPath %>/transfer/delete_transfer?tra_id=<%=transfer.getTra_id() %>" class="btn btn-danger btn-mini b-none alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
                          				<button href="javscript:void(0);" id="draft_id" rel="<%=contextPath %>/transfer/mark_ready?tra_id=<%=transfer.getTra_id() %>" class="btn btn-info btn-mini b-none alert-confirm change_ready" data-toggle="tooltip" data-placement="top" title="Status">Mark Ready</button>
                          				<button href="javscript:void(0);" id="hidden" rel="<%=contextPath %>/transfer/edit_validation?tra_id=<%=transfer.getTra_id() %>" class="btn btn-info btn-mini b-none edit_validate" data-toggle="tooltip" data-placement="top" title="Validation">Validate</button> --%>
                                  	</td>	
								</tr>
		                        <%} }else{ %>
				                        <tr>
				                            <td class="align-middle" colspan="12" >No Records Found</td>
				                        </tr>
			                    <%} %>
                            </tbody>
                        </table>
                    </div>
                    <!-- end of table -->
                </div>
            </div>
    		<!-- bug list card end -->
			</div>
		</div>
	</div>


<div id="grid" >
 	<div class="row">
 	<% 
    	if(transferList!=null&&!transferList.isEmpty()){
    			int idx_num=0;
    			for (Transfer transfer : transferList) {
    	%>
    	<!-- Invoice list card start -->
                <div class="col-sm-6">
                    <div class="card card-border-primary">
                        <div class="card-header">
                            <h5><%=transfer.getTra_partner_id() %></h5>
                        </div>
                        <div class="card-block">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list list-unstyled">
                                        <li>Operation Type: &nbsp;<%=transfer.getErp_operation().getOperation() %></li>
                                        <li>Source: <span class="text-semibold"><%=transfer.getTra_source()%></span></li>
                                        <li>Created By: <span class="text-semibold"><%=transfer.getTra_create_by()%></span></li>
                                        <li>Status: <span class="text-semibold"><%=helper.getStatusLable(transfer) %></span></li>
                                       
                                    </ul>
                                </div>
                                <%-- <div class="col-sm-6">
                                    <ul class="list list-unstyled text-right">
                                        <li>Start Date: <span class="text-semibold"><%=leave_type.getLt_start_date()%></span></li>
                                        <li>End Date: <span class="text-semibold"><%=leave_type.getLt_end_date() %></li>
                                    </ul>
                                </div> --%>
                            </div>
                        </div>
                        <div class="card-footer">
                            
                            <div class="task-board m-0">
                                <button href="javscript:void(0);" rel="<%=contextPath %>/transfer/view_transfer?tra_id=<%=transfer.getTra_id() %>" class="btn btn-info btn-mini b-none view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
                           		<button href="javscript:void(0);" rel="<%=contextPath %>/transfer/edit_transfer?tra_id=<%=transfer.getTra_id() %>" class="btn btn-warning btn-mini b-none edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
                          		<button href="javscript:void(0);" rel="<%=contextPath %>/transfer/delete_transfer?tra_id=<%=transfer.getTra_id() %>" class="btn btn-danger btn-mini b-none alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
                                  	
                               
                            </div>
                            <!-- end of pull-right class -->
                        </div>
                        <!-- end of card-footer -->
                    </div>
                </div>
                <!-- Invoice list card end -->
            <%} }else{ %>
            <div class="col-sm-12">
            	<div class="card">
            		<div class="card-border-primary">
                		<h4 class="sub-title">No Records Found</h4>
                	</div>
                </div>
            </div>
     <%} %>
    </div>
</div>

</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>

<!-- <div id="styleSelector">
</div> -->
</div>

<!-- add footer page here -->
<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>

<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"></script>

<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/sparkline/jquery.sparkline.js"></script>
<!-- task board js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/task-board/task-board.js"></script>
<!-- custom js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/data-table/js/data-table-custom.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/issue-list/issue-list.js"></script>
<!-- sweet alert js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/sweetalert/js/sweetalert.min.js"></script>
<!-- sweet alert modal.js intialize js -->

<script>

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
	//Alert confirm
	
		$('.remove_item').on('click',function(){
			var loc=$(this).attr('rel');
			var parent=$(this);
			swal({
				title: "Are you sure?",
				text: "Your will not be able to recover this transfer!",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				confirmButtonText: "Yes, change it!",
				closeOnConfirm: false
			},
			function(){
				/*Write delete code here*/
				$.ajax({
					url: loc,
					type: 'GET',
					dataType :'text',
					success: function (data) {
						if (data=='true') {
							parent.parents("tr").remove();
							swal("Deleted!", "Transfer has been deleted.", "success");
						} 
					},
					error: function(xhr, textStatus, thrownError) {
						alert("Error while deleting");
					},
					cache: false,
					contentType: false,
					processData: false
				});
		});
	});
	
	
	$('.change_ready').on('click',function(){
		var loc=$(this).attr('rel');
			swal({
				title: "Are you sure to mark as ready transfer?",
				text: "Your will not be able to edit transfer rk as edit after mark as done!",
				type: "warning",
				showCancelButton: true,
				confirmButtonClass: "btn-danger",
				confirmButtonText: "Yes, mark it!",
				closeOnConfirm: false
			},function(){
				/*Write delete code here*/
				$.ajax({
					url: loc,
					type: 'GET',
					dataType :'json',
					success: function (data) {
					if (data.status==1) {
						/* swal("Deleted!", "Leave type has been deleted.", "success"); */
						location.href='<%=contextPath %>/transfer/invent_transfer';
					}
				},
				error: function(xhr, textStatus, thrownError) {
					alert("Error while deleting");
				},
				cache: false,
				contentType: false,
				processData: false
			});
				
		});
	});
	
	
	
	$('.edit_item').on('click', function() {
		var loc=$(this).attr('rel');
		$("#page_body").load(loc);
	});
	
	$('.edit_validate').on('click', function() {
		var loc=$(this).attr('rel');
		$("#page_body").load(loc);
	});


	$('.view_item').on('click', function() {
		var loc=$(this).attr('rel');
		$("#page_body").load(loc);
	});

	$('#create_transfer').on('click', function() {
		var loc=$(this).attr('rel');
		$("#page_body").load(loc);
	});


	$('#grid_view').on('click', function() {
		$('#grid').show();
		$('#list').hide();
	});


	$('#list_view').on('click', function() {
		$('#grid').hide();
		$('#list').show();
	});


	$('#grid').hide();
	$('#list').show();
});
</script>


</body>




































