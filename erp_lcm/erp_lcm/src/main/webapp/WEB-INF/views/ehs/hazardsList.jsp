<%@page import="java.util.Map"%>
<%@page import="com.spcl.erp.model.Hazardous_Chemicals"%>
<%@page import="com.spcl.erp.services.EHSService"%>
<%@page import="com.spcl.erp.model.Ehs_Action"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.BankService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 	String contextPath = request.getContextPath(); 
	EHSService ehsService=(EHSService)request.getAttribute("ehsService");
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
		                            	<button rel="<%=contextPath %>/ehs/new_hazardous" id="new_hazardous" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Create</span></button>
										<button  rel="<%=contextPath %>/ehs/mail_ehs" id="mail" class='btn-sm btn-warning btn-icon edit_item' data-toggle='tooltip' data-placement='top' title='mail'><i class='icofont icofont-mail'></i>Email</button>
		                            	
		                            	<div class="btn-group m-b-5 m-t-5">
			                               <!--  <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-ui-user"></i></button>
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-edit-alt"></i></button>
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-reply"></i></button>
			                                <button type="button" class="btn btn-primary btn-sm waves-effect waves-light"><i class="icofont icofont-printer"></i></button> -->
		                                </div>
		                    		</div>
		                    		<form id="search_hazard" method="post" action="<%=contextPath%>/ehs/mng_hazardous">
			                    		<div class="card-block p-t-10">
			                    			<input type="hidden" name="search_hazard" value="true"/>
						                    <div class="input-group">
						                    	<lable><font size="3"><b>Chemical Name&nbsp</b></font>  </lable>
						                        <input type="text" class="form-control" id="chemical_name" name="chemical_name" placeholder="enter chemical name">
						                    </div>
						                 
						                   
																<div class="input-group">
																	<Button type="submit"
																		class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"
																		id="btn" style='margin-right: 16px'>
																		<font size="3">Search</font>
																	</button>
																	<Button type="reset"
																		class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"
																		id="btn1" style='margin-right: 16px'>
																		<font size="3">Cancel</font>
																	</button>
																</div>
						                </div>
					                </form>
					                 <script>
					                <% 
				                	Map<String, String> search_field =(Map<String, String>)request.getAttribute("search_field");
								    	if( search_field!=null&&! search_field.isEmpty()){
								    		for(Map.Entry<String, String> entry : search_field.entrySet()) {
												String value = entry.getValue();
												if (value!=null&&!value.isEmpty()) {
													String key = entry.getKey();
													%>
													
													<%="$('#"+key+"').val('"+value+"');" %>
													
													<%
													
												}
											}
								    			
								    	}
							    	%>
								   </script> 
		                		</div>
						        
						        
					            
					            <div class="nav-item nav-grid">
					                <span class="m-r-15">View Mode: </span>
					                <button type="button" class="btn btn-sm btn-primary waves-effect waves-light m-r-10" data-toggle="tooltip" data-placement="top" title="list view"  id="list_view">
					                    <i class="icofont icofont-listine-dots"></i>
					                </button>
					               <!--  <button type="button" class="btn btn-sm btn-primary waves-effect waves-light" data-toggle="tooltip" data-placement="top" title="grid view" id="grid_view">
					                    <i class="icofont icofont-table"></i>
					                </button> -->
					            </div>
					       
							</nav>
					        <!-- Navigation end  -->
					    
			            <div id="list">
			              	<div class="col-xl-12 card"  style="background-color:#f3f3f3">
			                	<div class="">
			                    	<!-- bug list card start -->
			                		<div>
					                    <div class="card-header">
					                        <h5>Incident Reports</h5>
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
														    <th>Chemical Name</th>
														    <th>Product Code </th>
														    <th>Formula</th>
														 	<th>Supplier Name</th>
														 	<th>Action</th>
														      </tr>
														      </thead>
													    <tbody class="text-left">
						                                	<% 
						                                	List<Hazardous_Chemicals> chemicalList =(List<Hazardous_Chemicals>)request.getAttribute("chemical_list");
						                                		if(chemicalList !=null&&!chemicalList.isEmpty()){
						                                			int idx_num=1;
						                                			for (Hazardous_Chemicals chemical : chemicalList ) {
						                                							                                			
						                                	%>
						                                	<tr>
					                                		 <td class="txt-primary"><%=idx_num++ %></td>
											                 <td><%=chemical.getChemical_name() %></td>
											                 <td><%=chemical.getProd_code()%></td>
											                  <td><%=chemical.getFormula() %></td>
											                  <td><%=chemical.getSupplier_name() %></td>
											                <td class="center text-center">
																 <button href="javscript:void(0);" rel="<%=contextPath %>/ehs/view_hazardous?hazard_id=<%=chemical.getHazard_id()%>" class="btn-sm btn-info btn-icon view_item" data-toggle="tooltip" data-placement="top" title="View" ><i class="icofont icofont-eye-alt"></i></button>
				                                             	 <button href="jacvscript:void(0);" rel="<%=contextPath %>/ehs/edit_hazardous?hazard_id=<%=chemical.getHazard_id()%>" class="btn-sm btn-warning btn-icon edit_item" data-toggle="tooltip" data-placement="top" title="Edit"><i class="icofont icofont-edit"></i></button>
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
		        
		        $('#new_hazardous').on('click', function() {
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
</html>