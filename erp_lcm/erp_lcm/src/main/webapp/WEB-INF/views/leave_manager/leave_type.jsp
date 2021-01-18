<%@page import="com.spcl.erp.model.Leave_type"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String contextPath = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />

<div class="page-body">
	
	<div class="row">
	   	<div class="col-sm-12">
	       	<!-- Basic Inputs Validation start -->
	   		<div class="card">
	         	<div class="card-header">
	                   <h5>${opr_mode=="save"?"New Leave Type":"Edit Leave Type"}</h5>
	             </div>
            	<div class="card-block">
            		<form id="add_leave" method="post" action="<%=contextPath%>/leave/save_leave_type" modelAttribute="leave_type">
					<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
					<input type=hidden class="form-control" id="lt_id"name="lt_id" value="${leave_type.lt_id}" />
						<div class="row">
							<div class="col-sm-2">
								<label for="confirm-2" class="block">Name</label>
							</div>
							<div class="form-group col-sm-5">
	                			<input type="text" class="form-control" id="lt_name"name="lt_name" required data-bv-notempty-message="Please enter leave type name.">
		                 	</div>
						</div>
						
						<div class="row">
							<div class="col-sm-2">
								<label for="confirm-2" class="block">Is Unpaid</label>
							</div>
							<div class="form-group col-sm-10">
						        <div class="checkbox-fade fade-in-primary">
                                    <label>
                                        <input type="checkbox" class="form_control" name="lt_is_unpaid" id="lt_is_unpaid" value="1">
                                        <span class="cr">
                                            <i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                        </span>
                                    </label>
                                </div>
						    </div>
						</div>              	
	              	
	              	
						<div class="row">
							<div class="col-sm-2">
								<label for="confirm-2" class="block">Take Leave</label>
							</div>
							<div class=" form-group form-radio col-sm-10">
						        <div class="radio radio-inline">
						            <label>
						                <input type="radio" class="form_control" name="lt_take_leave" id="lt_take_leave_1" value="1">
						                <i class="helper"></i>Day
						            </label>
						        </div>
						        <div class="radio radio-inline">
						            <label>
						                <input type="radio" class="form_control" name="lt_take_leave" id="lt_take_leave_2" value="2">
						                <i class="helper"></i>Hours
						            </label>
						        </div>
						    </div>
						</div>
	
						<div class="row">
							<div class="col-sm-2">
								<label for="confirm-2" class="block">Allocation Mode</label>
							</div>
							<div class="form-group form-radio col-sm-10">
		                       <div class="radio radio-inline">
		                           <label>
		                               <input type="radio" class="form_control" name="lt_allc_mode" id="lt_allc_mode_1" value="1">
		                               <i class="helper"></i>Fixed by HR
		                           </label>
		                       </div>
		                       <div class="radio radio-inline">
		                           <label>
		                               <input type="radio" class="form_control" name="lt_allc_mode" id="lt_allc_mode_2" value="2">
		                               <i class="helper"></i>Allocation Request
		                           </label>
		                       </div>
		                       <div class="radio radio-inline">
		                           <label>
		                               <input type="radio" class="form_control" name="lt_allc_mode" id="lt_allc_mode_3" value="3">
		                               <i class="helper"></i>No Allocation
		                           </label>
		                       </div>
		                   </div>
						</div>
	                      
	                    <div class="row">
							<div class="col-sm-2">
	                        	<label for="confirm-2" class="block">Validation</label>
	                       	</div>
	                        <div class="form-group form-radio col-sm-10">
	                       		<div class="radio radio-inline">
		                           	<label>
		                               	<input type="radio" class="form_control" name="lt_valid_by" id="lt_valid_by_1" value="1">
		                               	<i class="helper"></i>Human Resource Officer
		                           	</label>
		                       	</div>
		                       	<div class="radio radio-inline">
		                           	<label>
		                               	<input type="radio" class="form_control" name="lt_valid_by" id="lt_valid_by_2" value="2">
		                               <i class="helper"></i>Employee Manager
		                           </label>
		                       	</div>
		                       	<div class="radio radio-inline">
		                           	<label>
		                               	<input type="radio" class="form_control" name="lt_valid_by" id="lt_valid_by_3" value="3">
		                               	<i class="helper"></i>Double Validations
		                           	</label>
		                       	</div>
	                   		</div>
						</div>
	                    
	                    <div class="row">
	                    	<label class="col-sm-2 col-form-label">Description</label>
	                        <div class="form-group col-sm-5">
	                        	<textarea rows="5" cols="5" class="form-control" id="lt_description" name="lt_description" placeholder=""></textarea>
	                     	</div>
	                 	</div>
						
						<div class="row">
							<div class="col-sm-2">
	                        	<label for="date" class="block">Start Date</label>
	                   		</div>
							<div class="form-group col-sm-5">
								<input id="lt_start_date" name="lt_start_date" type="text" class="form-control ">
	              			</div>
	               		</div>
	                   	
	                   	<div class="row">
	                      	<label class="col-sm-2 col-form-label">End Date</label>
	                   		<div class="form-group col-sm-5">
	                			<input type="text" class="form-control" id="lt_end_date"name="lt_end_date">
		                 	</div>
	                 	</div>
	
						<div class="row">
	                    	<div class="form-group  col-sm-12">
	                         	<input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         	<button rel="<%=contextPath %>/leave/mng_leave_type" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	                     	</div>
						</div>
					</form>
	           	</div>
	           	
	           	
	           	
	           	<c:choose>
					<c:when test = '${opr_mode=="update"}'>
					
						<% 	Leave_type leave_type=(Leave_type)request.getAttribute("leave_type");
			           		if(leave_type!=null){
			           	
			           	%>	
			           		<script type="text/javascript">
									$(document).ready(function() {
										$('#lt_name').val('<%=leave_type.getLt_name()%>');
										<% if(leave_type.getLt_is_unpaid()==1){ %>
											$('#lt_is_unpaid').prop('checked', true);
										<%	} %>
										
										<% if(leave_type.getLt_take_leave()!=null){ %>
											$('#lt_take_leave_'+<%=leave_type.getLt_take_leave()%>).prop('checked', true);
										<%	} %>
										
										<% if(leave_type.getLt_allc_mode()!=null){ %>
											$('#lt_allc_mode_'+<%=leave_type.getLt_allc_mode()%>).prop('checked', true);
										<%	} %>
										
										<% if(leave_type.getLt_valid_by()!=null){ %>
											$('#lt_valid_by_'+<%=leave_type.getLt_valid_by()%>).prop('checked', true);
										<%	} %>
										
										$('#lt_description').val('<%=leave_type.getLt_description()%>');
										$('#lt_start_date').val("<%=request.getAttribute("lt_start_date")%>");
										$('#lt_end_date').val("<%=request.getAttribute("lt_end_date")%>");
																		
									});
								
								</script>
			           	
			           	
			           	<% }%>
						
					</c:when>
				</c:choose>
				
				<c:choose>
					<c:when test = '${opr_mode=="view"}'>
					
						<% 	Leave_type leave_type=(Leave_type)request.getAttribute("leave_type");
			           		if(leave_type!=null){
			           	
			           	%>	
			           		<script type="text/javascript">
									$(document).ready(function() {
										$('#lt_name').replaceWith($("<span>", {text: '<%=leave_type.getLt_name()%>'}));
										<% if(leave_type.getLt_is_unpaid()==1){ %>
												$('#lt_is_unpaid').prop('checked', true);
												$('#lt_is_unpaid').attr('readonly', true);
										<%	} %>
										
										$('#lt_take_leave_1').parents("label").replaceWith($("<span>", {text:'<%=request.getAttribute("lt_take_leave")%>'}));
										$('#lt_take_leave_2').parents("label").replaceWith('');
										
										$('#lt_allc_mode_1').parents("label").replaceWith($("<span>", {text:'<%=request.getAttribute("lt_allc_mode")%>'}));
										$('#lt_allc_mode_2').parents("label").replaceWith('');
										$('#lt_allc_mode_3').parents("label").replaceWith('');
										
										$('#lt_valid_by_1').parents("label").replaceWith($("<span>", {text:'<%=request.getAttribute("lt_valid_by")%>'}));
										$('#lt_valid_by_2').parents("label").replaceWith('');
										$('#lt_valid_by_3').parents("label").replaceWith('');
										
										$('#lt_description').replaceWith($("<span>", {text:'<%=leave_type.getLt_description()%>'}));
										$('#lt_start_date').replaceWith($("<span>", {text:'<%=request.getAttribute("lt_start_date")%>'}));
										$('#lt_end_date').replaceWith($("<span>", {text:'<%=request.getAttribute("lt_end_date")%>'}));
										
										$('input[type="submit"]').replaceWith('');
										$('input[type="reset"]').replaceWith('');
									
									
									});
								
								</script>
			           	
			           	
			           	<% }%>
						
					</c:when>
				</c:choose>
	           	
	           	
	     	</div>
		</div>
	</div>
</div>  


<!-- Date-range picker js -->
	<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/moment/js/moment.min.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
	<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	$('#lt_start_date').daterangepicker({
            singleDatePicker: true,
            showDropdowns: true
        });

        $('#lt_end_date').daterangepicker({
            singleDatePicker: true,
            showDropdowns: true
        });
        
        $('#add_leave').bootstrapValidator();
        
        $('#btn-cancel').on('click', function() {
            var loc=$(this).attr('rel');
           location.href=loc;
 		});
    });
</script>
