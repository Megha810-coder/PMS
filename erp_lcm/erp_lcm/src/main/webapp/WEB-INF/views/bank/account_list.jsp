<%@page import="com.spcl.erp.model.Account"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.BankService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 	String contextPath = request.getContextPath(); 
	BankService bankService=(BankService)request.getAttribute("BankService");
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
		                            	<button rel="<%=contextPath %>/bank/new_account" id="new_account" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Create</span></button>
		                            	<div class="btn-group m-b-5 m-t-5">
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-ui-user"></i></button>
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-edit-alt"></i></button>
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-reply"></i></button>
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-printer"></i></button>
		                                </div>
		                    		</div>
		                    		<div class="card-block p-t-10">
					                    <div class="input-group">
					                        <input type="text" class="form-control" id="filter1" name="filter" placeholder="Filter"  value="${filter}">
					                        <button type="button" class="input-group-addon"
					                 			data-toggle="tooltip" data-placement="top" title="filter"  id="filter">
					                   			 <i class="icofont icofont-search"></i>
					               			 </button>
					                       <!-- <span class="input-group-addon" id="basic-addon1"><i class="icofont icofont-search"></i></span>  -->
					                    </div>
					                </div>
		                    		
		                		</div>
						        
						       
					            
					            <div class="nav-item nav-grid">
					                <span class="m-r-15">View Mode: </span>
					                <button type="button" class="btn btn-sm btn-primary waves-effect waves-light m-r-10"
					                 data-toggle="tooltip" data-placement="top" title="list view"  id="list_view">
					                    <i class="icofont icofont-listine-dots"></i>
					                </button>
					                <button type="button" class="btn btn-sm btn-primary waves-effect waves-light" 
					                data-toggle="tooltip" data-placement="top" title="grid view" id="grid_view">
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
					                        <h5>Account holder Details</h5>
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
														    <th>Account number</th>
														    <th>Account Type</th>
														 	<th>Account Holder</th>
														     <th>Bank</th>
														     <th>Account Holder Name</th>
														     <th>Action</th>
														                                        
														      </tr>
														      </thead>
													    <tbody class="text-left">
						                                	<% 
						                                	List<Account> accountList =(List<Account>)request.getAttribute("account_list");
						                                		if(accountList !=null&&!accountList.isEmpty()){
						                                			int idx_num=1;
						                                			for (Account account : accountList ) {
						                                							                                			
						                                	%>
					                                		<tr>
					                                		 <td class="txt-primary"><%=idx_num++ %></td>
											                
											                 	<td><%=account.getAcc_number() %></td>
											                 	<td><%=account.getAcc_type()%></td>
											           			<td><%=account.getAcc_holder()%></td>
																<td><%=account.getBank().getBnk_name()%></td>
																<td><%=account.getAcc_holder1()%></td>
																								                
											                
											                 
											                 <td class="center text-center">
																<button href="javscript:void(0);" rel="<%=contextPath %>/bank/view_account?acc_id=<%=account.getAcc_id() %>" class="btn-sm btn-info btn-icon view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
				                                             	<button href="jacvscript:void(0);" rel="<%=contextPath %>/bank/edit_account?acc_id=<%=account.getAcc_id() %>" class="btn-sm btn-warning btn-icon edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
				                                             	<button href="javscript:void(0);" rel="<%=contextPath %>/bank/delete_account?acc_id=<%=account.getAcc_id() %>" class="btn-sm btn-danger btn-icon alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
				                                              	
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
    	if( accountList!=null&&! accountList.isEmpty()){
    			int idx_num=1;
    			for (Account account :  accountList) {
    	%>
    	<!-- Invoice list card start -->
                <div class="col-sm-6">
                    <div class="card card-border-primary">
                        <div class="card-header">
                        </div>
                        <div class="card-block">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list list-unstyled">
                                        <li>Account Number: &nbsp;<%=account.getAcc_number()%></li>
                                        <li>Type: <span class="text-semibold"><%=account.getAcc_type()%></span></li>
                             			<li>Account Holder : &nbsp;<%=account.getAcc_holder()%></li>
                             			<li>Bank : &nbsp;<%=account.getBank().getBnk_name()%></li>           
                                        <li>Account Holder: <span class="text-semibold"><%=account.getAcc_holder1() %></span></li>
                                       
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            
                            <div class="task-board m-0">
                                <button href="javscript:void(0);" rel="<%=contextPath %>/bank/view_account?acc_id=<%=account.getAcc_id() %>" class="btn btn-info btn-mini b-none view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
                           		<button href="javscript:void(0);" rel="<%=contextPath %>/bank/edit_account?acc_id=<%=account.getAcc_id() %>" class="btn btn-warning btn-mini b-none edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
                          		<button href="javscript:void(0);" rel="<%=contextPath %>/bank/delete_account?acc_id=<%=account.getAcc_id() %>" class="btn btn-danger btn-mini b-none alert-confirm remove_item" data-toggle="tooltip" data-placement="top" title="Delete/Remove"><i class="icofont icofont-archive"></i></button>
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
		                 text: "Your will not be able to recover this Account details!",
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
		                     		swal("Deleted!", "Account details has been deleted.", "success");
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
		        
		        $('#new_account').on('click', function() {
		           var loc=$(this).attr('rel');
		           $("#page_body").load(loc);
				});
		       
		        
		        $('#grid_view').on('click', function() {
		            $('#grid').show();
		            $('#list').hide();
		        });
		        
		        $('#filter').on('click', function() {
		       		var filter = $('#filter1').val();
		       		
		       		
		       		
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
</html>