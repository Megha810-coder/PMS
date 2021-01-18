<%@page import="com.spcl.erp.model.Com_Enquiry"%>
<%@page import="com.spcl.erp.services.LeaveService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 	String contextPath = request.getContextPath(); 
	String suc_msg=request.getParameter("suc_msg")!=null?request.getParameter("suc_msg"):"";
	String err_msg=request.getParameter("err_msg")!=null?request.getParameter("err_msg"):"";
	LeaveService leaveService=(LeaveService)request.getAttribute("leaveService");

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
	                                	<!-- Page-header start -->
										<div class="page-header">
										    <div class="row align-items-end">
										        <div class="col-lg-8">
										            <div class="page-header-title">
										                <div class="d-inline">
										                    <h4>Enquiry List</h4>
										                    <span>.</span>
										                </div>
										            </div>
										        </div>
										        <div class="col-lg-4">
										            <div class="page-header-breadcrumb">
										                <ul class="breadcrumb-title">
										                    <li class="breadcrumb-item">
										                        <a href="<%=contextPath%>/user_dashboard"> <i class="feather icon-home"></i> </a>
										                    </li>
										                    <li class="breadcrumb-item"><a href="#!">Enquiry List</a>
										                    </li>
										                </ul>
										            </div>
										        </div>
										    </div>
										</div>
										<!-- Page-header end -->
	                                    
	                                    
	                                    
	                                    <!-- Add pagebody here -->
	                                    <div id="page_body" >
	                                    	<div class="page-body invoice-list-page">
											    <div class="row">
											        <div class="col-xl-12 col-lg-12 filter-bar">
														<!-- Navigation start -->
														<nav class="navbar navbar-light bg-faded m-b-20 p-10">
													        <div class="card-block">
									                        	
									                    		<div class="card-block p-t-10">
												                    <div class="input-group">
												                        <input type="text" class="form-control" placeholder="Search here...">
												                        <span class="input-group-addon" id="basic-addon1"><i class="icofont icofont-search"></i></span>
												                    </div>
												                </div>
									                    		
									                		</div>
													    </nav>
												        <!-- Navigation end  -->
												        	
											            
											            <% if(!suc_msg.equals("")){ %>
											            	<script>
												            	$(document).ready(function() {
																	 notify('top', 'right', null, 'success', 'animated bounceInRight', 'animated bounceOutRight','Success:   ', '<%=request.getParameter("suc_msg")%>');
																});
												            </script>
											            <% } %>
											            
											            <% if(!err_msg.equals("")){ %>
											            	<script>
												            	$(document).ready(function() {
																	 notify('top', 'right', null, 'danger', 'animated bounceInRight', 'animated bounceOutRight','Error:   ', '<%=request.getParameter("err_msg")%>');
																});
												            </script>
											            <% } %>
											            
											            <div id="list">
											              	<div class="col-xl-12 card">
											                	<div class="">
											                    	<!-- bug list card start -->
											                		<div>
													                    <div class="card-header">
													                        <h5>Enquiry List</h5>
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
													                                        <th>Enquirer Name</th>
													                                        <th>Company</th>
													                                        <th>Email id</th>
													                                        <th>Designation</th>
													                                        <th>Country</th>
													                                        <th>Action</th>
													                                        <th>Description</th>
													                                        
													                                    </tr>
													                                </thead>
												                                	<tbody class="text-left">
													                                	<% 
													                                	List<Com_Enquiry> enqList=(List<Com_Enquiry>)request.getAttribute("enqList");
													                                		if(enqList!=null&&!enqList.isEmpty()){
													                                			int idx_num=1;
													                                			for (Com_Enquiry enquiry : enqList) {
													                                			
													                                	%>
												                                		<tr>
																							<td class="txt-primary"><%=idx_num %></td>
															                                <td><%=enquiry.getEnq_name() %></td>
															                                <td><%=enquiry.getEnq_company_name() %></td>
															                                <td><%=enquiry.getEnq_email() %></td>
															                                <td><%=enquiry.getEnq_post_id()%></td>
															                                <td><%=enquiry.getEnq_cuntry().getCntry_name()%></td>
																					        <td class="center text-center">
																								<button href="javscript:void(0);" rel="<%=contextPath %>/leave/view_leave_type?lt_id=<%=enquiry.getEnq_id() %>" class="btn btn-info btn-mini b-none view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
										                                                   		<button href="javscript:void(0);" rel="<%=contextPath %>/company/allow_module?enq_id=<%=enquiry.getEnq_id() %>" class="btn btn-warning btn-mini b-none edit_item" data-toggle="tooltip" data-placement="top" title="Add Modules to Commpany"><i class="icofont icofont-edit"></i></button>
										                                                  		<button href="javscript:void(0);" rel="<%=contextPath %>/leave/delete_leave_type?lt_id=<%=enquiry.getEnq_id() %>" class="btn btn-danger btn-mini b-none alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
										                                                  	
										                                                  	</td>
										                                                  	
										                                                  	<td><%=enquiry.getEnq_description() %></td>
																						</tr>
																                        <% idx_num++; } }else{ %>
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
		                 text: "Your will not be able to recover this enquiry request!",
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
		                     		swal("Deleted!", "Leave type has been deleted.", "success");
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
		        
		        $('.view_item').on('click', function() {
		            var loc=$(this).attr('rel');
		            $("#page_body").load(loc);
		 		});
		        
		        $('#new_leave_type').on('click', function() {
		           var loc=$(this).attr('rel');
		           $("#page_body").load(loc);
				});
		       
		    });
		</script>
	   	
	    
	</body>
</html>