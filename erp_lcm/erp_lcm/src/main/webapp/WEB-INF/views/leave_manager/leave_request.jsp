<%@page import="com.spcl.erp.model.Leave_Request"%>
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
	                   <h5>${opr_mode=="save"?"New Leave Request":"Edit Leave Request"}</h5>
	             </div>
            	<div class="card-block">
            		<form id="add_leave_request" method="post" action="<%=contextPath%>/leave/save_leave_request" modelAttribute="leave_request">
					<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
					<input type=hidden class="form-control" id="lr_id"name="lr_id" value="${leave_request.lr_id}" />
             						 <div class="form-group row">
                                    	  <label class="col-sm-2 col-form-label">Leave Type</label>
                                      		 <div class="col-sm-3">
	                                     		<select id="lr_leave_type" name="lr_leave_type" class="form-control">
	                                          		 <option value=""></option>
	                                          		 <option value="Legal Leaves 2019 (0 remaining out of 0)">Legal Leaves 2019 (0 remaining out of 0)</option>
	                                          		  <option value="Compensatory Days (0 remaining out of 0)">Compensatory Days (0 remaining out of 0)</option>
	                                          		   <option value="Unpaid (0 remaining out of 0)">Unpaid (0 remaining out of 0)</option>
	                                          		    <option value="Sick Leaves">Sick Leaves</option>
	                                          	 </select>
	                                  		 </div>
                                		</div>
										       <div class="row">
	                    					<label class="col-sm-2 col-form-label">Description</label>
	                       						 <div class="form-group col-sm-3">
	                        						<textarea rows="3" cols="4" class="form-control" id="lr_description" name="lr_description" placeholder=""></textarea>
	                     						</div>
	                 						</div>
	                 						<div class="row">
												<!-- <div class="col-sm-2">
	                        						<label for="date" class="block">From</label>
	                   							</div>
												<div class="form-group col-sm-3">
												<input id="lr_from_date" name="lr_from_date" type="text" class="form-control ">
	              							</div> -->
	              							
					                            <div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
					                                <label for="lab_date" class="block">From</label>
					                            </div>
					                            <div class="form-group col-sm-6 col-md-6 col-lg-6 col-xl-6">
					                                <input id="lr_from_date" name="lr_from_date" type="text" class="form-control "
					                                    placeholder="select  Date "/>
						              			</div>
						               		
	               						</div>
	               						
	               						<div class="row">
												<div class="col-sm-2">
	                        						<label for="date" class="block">To</label>
	                   							</div>
												<div class="form-group col-sm-3">
												<input id="lr_to_date" name="lr_to_date" type="text" class="form-control ">
	              							</div>
	               						</div>
	                   	
                                     <div class=" row">
                                                  <label class="col-sm-2 col-form-label">Duration</label>
                                                   <div class="form-group col-sm-3">
                                                <input id="lr_duration" class="form-control"  name="lr_duration" readonly>
                                                  <span class="messages"></span>
                                                 </div>
                                              </div>
	              			                 
						<div class="row">
	                    	<div class="form-group  col-sm-12">
	                         	<input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         		<button rel="<%=contextPath%>/leave/mng_leave_request" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	                     	</div>
						</div>
					</form>
					</div>
	           	</div>
	           	
	           	
	           	
	            <c:choose>
					<c:when test = '${opr_mode=="update"}'>
					<% 	Leave_Request leave_request=(Leave_Request)request.getAttribute("leave_request");
						if(leave_request!=null){
					%>
					<script type="text/javascript">
						$(document).ready(function() {
							
							$('#lr_leave_type').val('<%=leave_request.getLr_leave_type()%>');
							$('#lr_description').val('<%=leave_request.getLr_description()%>');
							$('#lr_from_date').val('<%=leave_request.getLr_from_date()%>');
							$('#lr_to_date').val('<%=leave_request.getLr_to_date()%>');
							$('#lr_duration').val('<%=leave_request.getLr_duration()%>');																			
						});
							
					</script>
					<% }%>
				</c:when>
			</c:choose>
				<c:choose>
					<c:when test = '${opr_mode=="view"}'>
					
						<% 	Leave_Request leave_request=(Leave_Request)request.getAttribute("leave_request");
			           		if(leave_request!=null){
			           	
			           	%>	
			           		<script type="text/javascript">
									$(document).ready(function() {
										$('#lr_leave_type').replaceWith($("<span>", {text: '<%=leave_request.getLr_leave_type()%>'}));
										$('#lr_description').replaceWith($("<span>", {text:'<%=leave_request.getLr_description()%>'}));
										$('#lr_duration').replaceWith($("<span>", {text:'<%=leave_request.getLr_duration()%>'}));
										$('#lr_from_date').replaceWith($("<span>", {text:'<%=leave_request.getLr_from_date()%>'}));
										$('#lr_to_date').replaceWith($("<span>", {text:'<%=leave_request.getLr_to_date()%>'}));
										$('#lr_duration').replaceWith($("<span>", {text:'<%=leave_request.getLr_duration()%>'}));
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
$(document).ready(function() {
	$('#add_leave_request').bootstrapValidator()
	.on("success.form.bv", function() {
    	$('#file_error').html("").hide();
   		var form = new FormData($('#add_leave_request')[0]);
	    $.ajax({
	        url: '<%=contextPath %>/leave/save_leave_request',
	        type: 'POST',
	        dataType :"json",
	        complete: function() {}, 
	        success: function (data) {
	        	if(data.status == 1) {
	        		location.href='<%=contextPath %>/leave/mng_leave_request';
	            } else if(data.status == 0) { 
	            	$('#file_error').append(data.error).show();
	                $("#submit-btn").prop("disabled",false);
	            }
	        },
	        error: function(xhr, textStatus, thrownError) {
	        	console.log("ERROR: ", thrownError);
	            alert("Somthing went wrong....");
	        },
	        data: form,
	        cache: false,
	        contentType: false,
	        processData: false
	    });
    
   		return false;
	});

	$('.btn_radio').on("click", function() {
	    var btn_val=$(this).val();
	    
	    if (btn_val==0) {
	        $('#hide_address').hide();
	    }else{
	        $('#hide_address').show();
	    }       
	    
	});

	$('.leave_request').on("click", function() {
	    var btn_val=$(this).val();
	    
	    if (btn_val==1) {
	        $('.hide_lr_leave_type').show();
	        $('#hide_lr_description').hide();
	        $('.hide_lr_duration').show();
	        $('.hide_lr_from_date').show();
	        $('.hide_lr_to_date').show();
	
	    }else{
	        $('.hide_lr_leave_type').hide();
	        $('#hide_lr_description').show();
	        $('.hide_lr_from_date').hide();
	        $('.hide_lr_to_date').hide();
	        $('.hide_lr_duration').hide();
		    
	        
	    }       
	    
	});

	$('#btn-cancel').on('click', function() {
	    var loc=$(this).attr('rel');
	   	location.href=loc;
	});
	
    $("#w").datepicker({
        onSelect: function(selected) {
          $("#lr_to_date").datepicker("option","minDate", selected)
        }
    });
    $("#lr_to_date").datepicker({
        onSelect: function(selected) {
           $("#lr_from_date").datepicker("option","maxDate", selected)
            var date2 =  new Date($("#lr_to_date").val());
           if(date2!=null){
        	   var date1 = new Date($("#lr_from_date").val());
        	   var date2 =  new Date($("#lr_to_date").val());
        	   var timeDiff = Math.abs(date2.getTime() - date1.getTime());
        	   var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
        	    document.getElementById("lr_duration").value= diffDays; 
        	 /*   $("#lr_duration").text(diffDays); */
        	  
           }
        }
    });

    





});

</script>