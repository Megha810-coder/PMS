<%@ page
	import="com.spcl.erp.model.LabourCheck,com.spcl.erp.model.Labour"%>
<%@ page import="com.spcl.erp.helper.Helper"%>
<%@ page import="com.spcl.erp.services.LabourService"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
  	String contextPath = request.getContextPath(); 
  	LabourService labourService=(LabourService)request.getAttribute("labourService");
Labour labour=(Labour)request.getAttribute("labour");
  	Helper helper = (Helper)request.getAttribute("helper");
  	Integer total_salary_list=(Integer)request.getAttribute("total_salary_list");
 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />

<!-- Data Table Css -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/pages/data-table/css/buttons.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/css/component.css">
<!-- sweet alert framework -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/sweetalert/css/sweetalert.css">

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
				<div id="page_body">
					<div class="page-body invoice-list-page">
						<div class="row">
							<div class="col-xl-12 col-lg-12 filter-bar">
								<!-- Navigation start -->
								<nav class="navbar navbar-light bg-faded m-b-30 p-10">
								<div class="card-block">
									<div
										class=" waves-effect waves-light m-r-10 v-middle issue-btn-group">
										<%-- <button rel="<%=contextPath%>/labour/new_labour_check"
											id="new_labour_details" type="button"
											class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5">
											<i class="icofont icofont-paper-plane"></i><span
												class="m-l-10">Create</span>
										</button> --%>
									</div>
									<div class="card-block p-t-10">
										<div class="input-group">
											<form id="search_lab" method="post" action="<%=contextPath%>/labour/mng_attendance">
			                    				<div class="card-block p-t-10">
					                    			<input type="hidden" name="search_Labour" value="true"/>
					                    			<div class="row">
					                    				<div class="col-sm-4 col-md-4">
										                    <div class="input-group">
										                    <div class="col-sm-4">Date:  </div>
										                    	<!-- <label>Date : </label> -->
										                        <input type="text" class="form-control" id="Check_in_time" name="Check_in_time" placeholder="Date">
										                    </div>
								                   		 </div>
								                    	<div class="col-sm-4 col-md-4">
										                    <div class="input-group">
										                       <div class="col-sm-4">Shift Time:  </div>
										                    	<!-- <label>Shift Time : </label> -->
										                        <select type="text" class="form-control" id="shift_id" name="shift_id" placeholder="Shift Id">
										                        <option value="">---Select Time---</option>
					                                    		<option value="7-3.30">Morning</option>
					                                      		<option value="3.30-12">Evening</option> 
					                                      		<option value="12-7">Night</option>
										                        </select>
										                    </div>
								                 	   </div>
								                    	<div class="col-sm-4 col-md-4">
										                    <div class="input-group">
										                      <div class="col-sm-4">Department:  </div>
										                    	<!-- <label>Department : </label> -->
										                       <select type="text" class="form-control" id="dt_department_name" name="dt_department_name" placeholder="Department Name">
										                        <option value="">---Select Department---</option>
																<%=helper.getDepartmentDropDown1() %>
																</select>
										                    </div>
								                   		 </div>
								                    </div>
						                    
						                    <div class="input-group">
						                    	<button type="submit" class="input-group-addon" id="btn">
						                        	Search&nbsp<i class="icofont icofont-search"></i>
					                        	</button>
					                        	
						                    </div>
						                </div>
					                </form>
					                
					                 <script>
					                <% 
				                	Map<String, String> search =(Map<String, String>)request.getAttribute("search");
								    	if( search!=null&&! search.isEmpty()){
								    		for(Map.Entry<String, String> entry : search.entrySet()) {
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
									</div>

								</div>


								<div class="nav-item nav-grid">
									<span class="m-r-15">View Mode: </span>
									<button type="button"
										class="btn btn-sm btn-primary waves-effect waves-light m-r-10"
										data-toggle="tooltip" data-placement="top"
										title="list view" id="list_view">
										<i class="icofont icofont-listine-dots"></i>
									</button>
									<button type="button"
										class="btn btn-sm btn-primary waves-effect waves-light"
										data-toggle="tooltip" data-placement="top"
										title="grid view" id="grid_view">
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
													<h5>Job Position List</h5>
													<div class="card-header-right">
														<i class="icofont icofont-spinner-alt-5"></i>
													</div>
													 <button href="javscript:void(0);"
																			rel="<%=contextPath%>/labour/monthly_salary_all"
																			class="btn btn-info btn-mini b-none generate_salary"
																			data-toggle="tooltip" data-placement="top"
																			title="Salary">Generate Salary</button> 
												</div>
												<div class="card-block">
													<div class="table-responsive">
														<table id="issue-list-table"
															class="table dt-responsive width-100">
															<thead class="text-left">
																<tr>
																	<th>Labour id</th>
																	<th>Labour Name</th>
																	<th>Salary</th>
																	<th>Action</th>

																</tr>
															</thead>
															<tbody class="text-left">
																<%
                               							List<LabourCheck> check_list =(List<LabourCheck>)request.getAttribute("check_list");
                    					          			if(check_list!=null&&!check_list.isEmpty()){
                    					                    	int idx_num=1;
                    					                    	for (LabourCheck labourCheck :check_list) {
                    					                    	
                              						 	%>
																<tr>
																	<td class="txt-primary"><%=idx_num++%></td>
																	<%--     <td><%=labourService.getLabourByNameID(labourCheck)%><td> --%>
																	<td><%=labourCheck.getLabour().getLab_fname()%>&nbsp;<%=labourCheck.getLabour().getLab_mname()%>&nbsp;<%=labourCheck.getLabour().getLab_lname()%></td>
																	<td><%=labourCheck.getLabour().getLab_salary() %>
																	
																	<td class="center text-center">
																		<button href="javscript:void(0);" rel="<%=contextPath%>/labour/view_checkInList?labour_lab_id=<%=labourCheck.getLabour().getLab_id()%>" class="btn btn-info btn-mini b-none view_list" data-toggle="tooltip" data-placement="top" title="View Attendance" ><i class="icofont icofont-eye-alt"></i></button>
																		<%-- <button href="javscript:void(0);"
																			rel="<%=contextPath%>/labour/salary?lab_check_id=<%=labourCheck.getLab_check_id()%>"
																			class="btn btn-info btn-mini b-none view_item"
																			data-toggle="tooltip" data-placement="top"
																			title="Salary">Salary</button> --%>
																	</td>

																</tr>
																<%
										                        	} }else{
										                        %>
																<tr>
																	<td class="align-middle" colspan="12">No
																		Records Found</td>
																</tr>
																<%
											                    	}
											                    %>
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
        					if(check_list!=null&&!check_list.isEmpty()){
    							  int idx_num=1;
    							    for (LabourCheck labourCheck: check_list) {
						           	%><!-- Invoice list card start -->
               	 <div class="col-sm-6">
                    <div class="card card-border-primary">
                        <div class="card-header">
                            <h5>Labour Id:&nbsp;<%=idx_num++%></h5>
                        </div>
                        <div class="card-block">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list list-unstyled">
                                        <li>Labour Name: &nbsp;<%=labourCheck.getLabour().getLab_fname()%>&nbsp;<%=labourCheck.getLabour().getLab_mname()%>&nbsp;<%=labourCheck.getLabour().getLab_lname()%></li>
                                        <li>Department: <span class="text-semibold"><%=labourCheck.getDepartment().getDept_id()%></span></li>
                                       <li>Check In: <span class="text-semibold"><%=labourCheck.getCheck_in() %></span></li>
                                        <li>Check out: <span class="text-semibold"><%=labourCheck.getCheck_out() %></span></li>
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
						         <button href="javscript:void(0);" rel="<%=contextPath%>/labour/check_out?lab_check_id=<%=labourCheck.getLab_check_id()%>" class="btn btn-warning btn-mini b-none edit_item " data-toggle="tooltip" data-placement="top" title="Check_Out">Check Out</button>
								<button href="javscript:void(0);" rel="<%=contextPath%>/labour/salary?lab_check_id=<%=labourCheck.getLab_check_id()%>" class="btn btn-info btn-mini b-none view_item" data-toggle="tooltip" data-placement="top" title="Salary">Salary</button>
                            <div class="task-board m-0">
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


<!-- <div id="styleSelector">
</div> -->
<!-- add footer page here -->
<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/moment/js/moment.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>

<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"></script>

<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/pages/sparkline/jquery.sparkline.js"></script>
<!-- task board js -->
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/pages/task-board/task-board.js"></script>
<!-- custom js -->
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/pages/data-table/js/data-table-custom.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/pages/issue-list/issue-list.js"></script>
<!-- sweet alert js -->
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/sweetalert/js/sweetalert.min.js"></script>
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
               text: "Your will not be able to recover this job position type!",
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
                   		swal("Deleted!", "job position has been deleted.", "success");
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
          location.href=loc;
	});
      
      $('.view_item').on('click', function() {
          var loc=$(this).attr('rel');
          $("#page_body").load(loc);
	});
      $('.view_list').on('click', function() {
          var loc=$(this).attr('rel');
          location.href=loc;
	});
      $('#new_labour_details').on('click', function() {
         var loc=$(this).attr('rel');
         $("#page_body").load(loc);
});
      
      $('.generate_salary').on('click', function() {
          var loc=$(this).attr('rel');
          location.href=loc;
 });
      
      $('#Check_in_time').daterangepicker({
          singleDatePicker: true,
          showDropdowns: true
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