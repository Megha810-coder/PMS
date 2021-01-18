<%@page import="com.spcl.erp.model.Leave_Request"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.LeaveService"%>
<%@page import="java.util.List"%>
<%@page import="com.spcl.erp.model.Leave_Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 	String contextPath = request.getContextPath(); 
	String suc_msg=request.getParameter("suc_msg")!=null?request.getParameter("suc_msg"):"";
	String err_msg=request.getParameter("err_msg")!=null?request.getParameter("err_msg"):"";
	LeaveService leaveService=(LeaveService)request.getAttribute("leaveService");
	Helper helper = (Helper)request.getAttribute("helper"); 
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
									                            	<button rel="<%=contextPath %>/leave/new_leave_request" id="new_leave_request"button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Create</span></button>
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
													        
													        <!-- <ul class="nav navbar-nav">
													            <li class="nav-item active">
													                <a class="nav-link" href="#!">Filter: <span class="sr-only">(current)</span></a>
													            </li>
													            <li class="nav-item dropdown">
													                <a class="nav-link dropdown-toggle" href="#!" id="bydate" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icofont icofont-clock-time"></i> By Date</a>
													                <div class="dropdown-menu" aria-labelledby="bydate">
													                    <a class="dropdown-item" href="#!">Show all</a>
													                    <div class="dropdown-divider"></div>
													                    <a class="dropdown-item" href="#!">Today</a>
													                    <a class="dropdown-item" href="#!">Yesterday</a>
													                    <a class="dropdown-item" href="#!">This week</a>
													                    <a class="dropdown-item" href="#!">This month</a>
													                    <a class="dropdown-item" href="#!">This year</a>
													                </div>
													            </li>
													            end of by date dropdown
													            <li class="nav-item dropdown">
													                <a class="nav-link dropdown-toggle" href="#!" id="bystatus" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icofont icofont-chart-histogram-alt"></i> By Status</a>
													                <div class="dropdown-menu" aria-labelledby="bystatus">
													                    <a class="dropdown-item" href="#!">Show all</a>
													                    <div class="dropdown-divider"></div>
													                    <a class="dropdown-item" href="#!">Open</a>
													                    <a class="dropdown-item" href="#!">On hold</a>
													                    <a class="dropdown-item" href="#!">Resolved</a>
													                    <a class="dropdown-item" href="#!">Closed</a>
													                    <a class="dropdown-item" href="#!">Dublicate</a>
													                    <a class="dropdown-item" href="#!">Wontfix</a>
													                </div>
													            </li>
													            end of by status dropdown
													            <li class="nav-item dropdown">
													                <a class="nav-link dropdown-toggle" href="#!" id="bypriority" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icofont icofont-sub-listing"></i> By Priority</a>
													                <div class="dropdown-menu" aria-labelledby="bypriority">
													                    <a class="dropdown-item" href="#!">Show all</a>
													                    <div class="dropdown-divider"></div>
													                    <a class="dropdown-item" href="#!">Highest</a>
													                    <a class="dropdown-item" href="#!">High</a>
													                    <a class="dropdown-item" href="#!">Normal</a>
													                    <a class="dropdown-item" href="#!">Low</a>
													                </div>
													            </li>
													        </ul>
												                    
												             -->
												            
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
						   <div id="list">
			              	<div class="col-xl-12 card">
			                	<div class="">
			                    	<!-- bug list card start -->
			                		<div>
					                    <div class="card-header">
					                        <h5>Leave Request</h5>
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
														    <th>Employee Name</th>
														    <th>Department</th>
														    <th>position</th>
														    <th>Leave Type</th>
														    <th>Duration</th>
														     <th>Status</th>
														    <th>Action</th>
														    <th>Description</th>
														    <th>From Date</th>
														    <th>To Date</th>
														    
														      </tr>
														      </thead>
													    <tbody class="text-left">
						                                	<% 
						                                	List<Leave_Request> leave_request_list=(List<Leave_Request>)request.getAttribute("leave_request_list");
						                                		if(leave_request_list!=null&&!leave_request_list.isEmpty()){
						                                			int idx_num=1;
						                                			for (Leave_Request leave_request : leave_request_list) {
						                                							                                			
						                                	%>
					                                		<tr>
					                                		 <td class="txt-primary"><%=idx_num++ %></td>
					                            			<td></td>
					                            			<td></td>
					                            			<td></td>
												             <td><%=leave_request.getLr_leave_type() %></td>
												             <td><%=leave_request.getLr_duration()%></td>
												             <td><%=helper.getStatusLable(leave_request)%></td>
												             <td><%=leaveService.getAllButton(leave_request, contextPath).toString()%></td>
											                 <td><%=leave_request.getLr_description()%></td>
											                 <td><%=leave_request.getLr_from_date()%></td>
											                 <td><%=leave_request.getLr_to_date()%></td>
											                 
											                 
											                  
											                <%--  <td class="center text-center">
																<button href="javscript:void(0);" rel="<%=contextPath %>/leave/view_leave_request?lr_id=<%=leave_request.getLr_id() %>" class="btn-sm btn-info btn-icon view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
				                                             	<button href="jacvscript:void(0);" rel="<%=contextPath %>/leave/edit_leave_request?lr_id=<%=leave_request.getLr_id() %>" class="btn-sm btn-warning btn-icon edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
				                                             	<button href="javscript:void(0);" rel="<%=contextPath %>/leave/delete_leave_request?lr_id=<%=leave_request.getLr_id() %>" class="btn-sm btn-danger btn-icon alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
				                                              	
				                                          	 </td>
				 	 --%>
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
								if(leave_request_list!=null&&!leave_request_list.isEmpty()){
								  int idx_num=1;
								    for (Leave_Request leave_request : leave_request_list) {
								                            				
							%><!-- Invoice list card start -->
						                <div class="col-sm-6">
						                    <div class="card card-border-primary">
						                        <div class="card-header">
						                            <h5>Leave Request</h5>
						                        </div>
						              
					                        <div class="card-block">
						                            <div class="col-sm-12">
							                            <div class="row">
					                                    <div class="col-sm-3">Leave Type:</div><div class="col-sm-9"><%=leave_request.getLr_leave_type() %></div>
						                                    <div class="col-sm-3">Description.:</div><div class="col-sm-9"><%=leave_request.getLr_description() %></div>
						                                    <div class="col-sm-3">From.:</div><div class="col-sm-9"><%=leave_request.getLr_from_date() %></div>
						                                    <div class="col-sm-3">To.:</div><div class="col-sm-9"><%=leave_request.getLr_to_date() %></div>
					                                        <div class="col-sm-3">Duration.:</div><div class="col-sm-9"><%=leave_request.getLr_duration() %></div>
					                                        <div class="col-sm-3">status.:</div><div class="col-sm-9"><%=helper.getStatusLable(leave_request)%></div>
					                                        
					                                      </div>
						                            </div> 
						                        </div>
						                        <div class="card-footer">
						                            
						                            <div class="task-board m-0">
						                                <button href="javscript:void(0);" rel="<%=contextPath %>/leave/view_leave_request?lr_id=<%=leave_request.getLr_id() %>" class="btn btn-info btn-mini b-none view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
                                                   		<button href="javscript:void(0);" rel="<%=contextPath %>/leave/edit_leave_request?lr_id=<%=leave_request.getLr_id() %>" class="btn btn-warning btn-mini b-none edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
                                                  		<button href="javscript:void(0);" rel="<%=contextPath %>/leave/delete_leave_request?lr_id=<%=leave_request.getLr_id() %>" class="btn btn-danger btn-mini b-none alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
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
		                 text: "Your will not be able to recover this leave type!",
		                 type: "warning",
		                 showCancelButton: true,
		                 confirmButtonClass: "btn-danger",
		                 confirmButtonText: "Yes, delete it!",
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
		                     		swal("Deleted!", "Leave request has been deleted.", "success");
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
		            $("#page_body").load
		            (loc);
		 		});
		        
		        $('.view_item').on('click', function() {
		            var loc=$(this).attr('rel');
		            $("#page_body").load(loc);
		 		});
		        
		        $('#new_leave_request').on('click', function(){
		          	var loc=$(this).attr('rel');
		           	console.log(loc);
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
		        
		        
		        $('#grid').show();
		        $('#list').hide();
		    });
	
		    $('.approve_leave').on('click',function(){
	        	var loc=$(this).attr('rel');
	        	
	            swal({
	                 title: "Are you sure?",
	                 text: "are yout sure to approved this leave request?",
	                 type: "warning",
	                 showCancelButton: true,
	                 confirmButtonClass: "btn-danger",
	                 confirmButtonText: "Yes, Approved",
	                 closeOnConfirm: false
	             },
	             function(){
	                 /*Write delete code here*/
	                 $.ajax({
	                     url: loc,
	                     type: 'GET',
	                     dataType :'json',
	                     success: function (data) {
	                    	 if (data.status==1) {
	                    	 location.href='<%=contextPath %>/leave/mng_leave_request';
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
			 <%--   $('.refuse_leave').on('click',function(){
		        	var loc=$(this).attr('rel');
		        	
		            swal({
		                 title: "Are you sure?",
		                 text: "are yout sure to approved this leave request?",
		                 type: "warning",
		                 showCancelButton: true,
		                 confirmButtonClass: "btn-danger",
		                 confirmButtonText: "Yes, Approved",
		                 closeOnConfirm: false
		             },
		             function(){
		                 /*Write delete code here*/
		                 $.ajax({
		                     url: loc,
		                     type: 'GET',
		                     dataType :'json',
		                     success: function (data) {
		                    	 if (data.status==1) {
		                    	 location.href='<%=contextPath %>/leave/mng_leave_request';
								 } 
		                     },
		                     error: function(xhr, textStatus, thrownError) {
		                         alert("Error while deleting");
		                     },
		                     cache: false,
		                     contentType: false,
		                     processData: false
		             	});--%>
		             });
	        
		</script>
	   	
	    
	</body>
</html>