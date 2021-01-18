<%@page import="java.util.Map"%>
<%@page import="com.spcl.erp.model.HIRA"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 	String contextPath = request.getContextPath(); 
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
	<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<style>
 .btn-warning
{
border-color:#01a9ac;
}
.btn-sm
{
background-color: #01a9ac;
}
</style>
		
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
<div class="pcoded-content" Style="background-color:#FFFF">
<div class="pcoded-inner-content">
    <div class="main-body">
        <div class="page-wrapper">
            <!-- Add pagebody here -->
            <div id="page_body" >
            	<div class="page-body invoice-list-page">
				    <div class="row">
				        <div class="col-xl-12 col-lg-12 filter-bar">
							<!-- Navigation start -->
							<nav class="navbar navbar-light bg-faded m-b-30 p-10" style="background-color:#f3f3f3">
						        <div class="card-block">
		                        	<div class=" waves-effect waves-light m-r-10 v-middle issue-btn-group">
		                            	<button rel="<%=contextPath %>/ehs/new_hira" id="new_hira_page" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Create</span></button>
		                            	<div class="btn-group m-b-5 m-t-5">
		                                </div>
		                                <div class="btn-group m-b-5 m-t-5">
												 <button type="button" id="import_hira" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-file-excel"></i> Import Data</button>
										</div>
		                                 <div class="btn-group m-b-5 m-t-5">
                                			<button  id="export_hira" href="javscript:void(0);" rel="<%=contextPath %>/ehs/export_HIRA" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-file-excel"></i>Export Data</button>
                               	 		</div>
		                    		</div>
		                		</div>
						        
					            <div class="nav-item nav-grid">
					                <span class="m-r-15">View Mode: </span>
					                <button type="button" class="btn btn-sm btn-primary waves-effect waves-light m-r-10" data-toggle="tooltip" data-placement="top" title="list view"  id="list_view">
					                    <i class="icofont icofont-listine-dots"></i>
					                </button>
					            </div>
					       
							</nav>
					        <!-- Navigation end  -->
					    
			            <div id="list">
			              	<div class="col-xl-12 card"  style="background-color:#f3f3f3">
			                	<div class="">
			                    	<!-- bug list card start -->
			                		<div>
					                    <div class="card-header">
					                        <h5></h5>
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
														    <th>Activity</th>
														    <th>Impact on Land</th>
														    <th>Impact on Air</th>
														    <th>Impact on Water</th>
														    <th>Impact on Human</th>
														    <th>Impact on Resource</th>
														    <th>Total Rating</th>
														    <!-- <th>Legal Exposure</th>
														    <th>frequency of occurrence</th>
														     <th>Overall Impact Rating</th> -->
														      </tr>
														      </thead>
													    <tbody class="text-left">
													    <% 
						                                	List<HIRA> hiralist =(List<HIRA>)request.getAttribute("hira_list");
						                                		if(hiralist!=null&&!hiralist.isEmpty()){
						                                			int idx_num=1;
						                                			for (HIRA hira : hiralist ) {
						                                	%>
						                                	<tr>
					                                		 <td class="txt-primary"><%=idx_num++ %></td>
											                 <td><%=hira.getActivity() %></td>
											                 <td><%=hira.getLand1() %></td>
											                 <td><%=hira.getAir1()%></td>
											                 <td><%=hira.getWater1() %></td>
											                 <td><%=hira.getHuman1() %></td>
											                 <td><%=hira.getResource1()%></td>
											                 <td><%=hira.getTotal_rating()%></td>
											                  <%--  <td><%=hira.getLegal() %></td>
											                   <td><%=hira.getFrequency() %></td>
											                 <td><%=hira.getImpact_rating()%></td> --%>
											               
											                <td class="center text-center">
				                                          	 </td> 
															</tr>
									                        <%} } else{ %>
									                        <tr>
									                            <td class="align-middle" colspan="12" >No Records Found</td>
									                        </tr>
										                    <% } %>
						                                	
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
					
<%-- <div id="grid" >
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
</div> --%>
			            
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


	<div class="modal fade show" id="import_file" tabindex="-1"
		role="dialog" style="z-index: 1050; display: none;">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Import Excel File</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<form id="con" method="GET" enctype="multipart/form-data">
					<div class="modal-body">
						<h5>Import new Hira by excel sheet</h5>
						<p>Please choose only excel file..</p>

						<input class="from_control" type="file" name="excel_file" />

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default waves-effect "
							data-dismiss="modal">Close</button>
						<button type="submit"
							class="btn btn-primary waves-effect waves-light ">Import</button>
					</div>
				</form>
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
		<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
   
<script>
		    
		    $(document).ready(function() {
		    	$('[data-toggle="tooltip"]').tooltip();
		        //Alert confirm
		        //${pageContext.request.contextPath}/ehs/importhira
		         $('#import_hira').on('click',function(){
		        	$('#import_file').modal();
		        	$('#con').bootstrapValidator()
		        	.on("success.form.bv", function() {
			        	var form = new FormData($('#con')[0]);
			        	$.ajax({
		                    url: "${pageContext.request.contextPath}/ehs/importhira",
		                     type: 'POST',
		                     dataType :'json',
		                     success: function (data) {
		                    	 if (data.status=='1') {
		                      		
		                     		swal("Success!", data.success, "success");
		                    	 }else 
		                    		 {
		                    		 swal("Failed!", data.error, "cancelled");
	                    		 }
		                     },
		                     error: function(xhr) {
		                    	 alert("Error while importing");
		                     },
		                     data : form,	                     
		                     cache: false,
		                     contentType: false,
		                     processData: false
		             	}); 
		        	});
		       	});
		        
		        
		      	 
		        
		         //script to export contractor file
	        	$('#export_hira').on('click',function(){
	        	var loc=$(this).attr('rel');
	        	location.href=loc;
	        	 });
		        
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
		        
		        $('#new_hira_page').on('click', function() {
		           var loc=$(this).attr('rel');
		           $("#page_body").load(loc);
				});
		        
		        $('#btn-cancel').on('click', function() {
		        	var loc=$(this).attr('rel');
		        	location.href=loc;
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
</html>