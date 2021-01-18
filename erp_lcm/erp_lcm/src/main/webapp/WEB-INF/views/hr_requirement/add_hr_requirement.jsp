<%@page import="com.spcl.erp.services.HrRequirementService"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.model.HrRequirement"%>
<%-- <%@page import="com.spcl.erp.model.City "%>
<%@page import="com.spcl.erp.helper.Helper"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%
	 	String contextPath = request.getContextPath();
	 	 	 	Helper helper = (Helper)request.getAttribute("helper");
	 	 	 	HrRequirementService hr_requirementService=(HrRequirementService)request.getAttribute("Hr_RequirementService");
	 %> 
<link rel="stylesheet" type="text/css" href="<%=contextPath%>>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Job Position</h4>
                    <span>Create new Hr Requirement/Hr Requirement System.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Hr Requirement</a>
                    </li>
                     <li class="breadcrumb-item"><a href="#!">New</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Page-header end -->

<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>

<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
          <div class="card">
                <div class="card-header">
                    <h5>${opr_mode=="save"?"New Hr Requirement":"Edit Hr Requirement"}</h5>
                    </div>
                            <div class="card-block">
                            <form id="from_add_hr_requirement" method="post" action="<%=contextPath%>/hr_requirement/save_hr_requirement" modelAttribute="hrrequirement">
                            <input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
                            <input type=hidden class="form-control" id="hr_req_id"name="hr_req_id" value="${job_position_type.jp_id}" />
										 <div class="form-group row">
                                    	  <label class="col-sm-2 col-form-label">Department</label>
                                      		 <div class="col-sm-3">
	                                     		<select id="hr_department" name="hr_department" class="form-control" required data-bv-notempty-message="Please select department.">
	                                          		 <option value="">---Department---</option>
	                                          		<%=helper.getDepartmentDropDown1() %>
	                                          	 </select>
	                                  		 </div>
                                		</div>
                                				 <div class="form-group row">
                                    	  <label class="col-sm-2 col-form-label">Shifts</label>
                                      		 <div class="col-sm-3">
	                                     		<select id="hr_shifts" name="hr_shifts" class="form-control" required data-bv-notempty-message="Please select department.">
	                                          		 <option value="">---Shift---</option>
	                                          		 <option value="">---Select Shift Time---</option>
														<option value="7-3.30">7-3.30</option>
														<option value="3.30-12">3.30-12</option>
														<option value="12-7">12-7</option>
	                                          		 
	                                          	 </select>
	                                  		 </div>
                                		</div>
                                       <div class="form-group row">
                                               <label class="col-sm-2 col-form-label">Required Labours</label>
                                                     <div class="col-sm-3">
                                            <input type="text" id="labour_required" name="labour_required" class="form-control"required data-bv-notempty-message="Please select description
                                                   .">
                                                 </div>
                                             </div>
                                           
                              <div class="row">
                            <div class="col-sm-12">
                               	<input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         	<button rel="<%=contextPath%>/hr_requirement/mng_hr_requirement" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	                     	
                            	</div>
                       		</div>
                      	</form>
                  	</div>
               </div>
               </div>
               </div>
               </div>
                <c:choose>
					<c:when test = '${opr_mode=="update"}'>
					<%
						HrRequirement hrrequirement=(HrRequirement)request.getAttribute("hr_requirement");
									if(hrrequirement!=null){
					%>
					<script type="text/javascript">
						$(document).ready(function() {
							
							$('#hr_department').val('<%=hrrequirement.getHr_department()%>');
							$('#hr_shift').val('<%=hrrequirement.getHr_shifts()%>');
							$('#labour_required').val('<%=hrrequirement.getLabour_required ()%>');																				
						});
							
					</script>
					<%
						}
					%>
				</c:when>
			</c:choose>
			
	<c:choose>
	<c:when test = '${opr_mode=="view"}'>
		<% HrRequirement hrrequirement=(HrRequirement)request.getAttribute("hr_requirement");
			if(hrrequirement!=null){
		%>
		<script type="text/javascript">
			$(document).ready(function() {
			
		
				$('#hr_department').closest("div"). replaceWith($("<span>", {text: '<%=hrrequirement.getHr_department()%>'}));
				
				
				$('#hr_shift').replaceWith($("<span>", {text: '<%=hrrequirement.getHr_shifts() %>'}));
				$('#labour_required').replaceWith($("<span>", {text: '<%=hrrequirement.getLabour_required()%>'}));
				$('input[type="submit"]').replaceWith('');
				 
				$('input[type="reset"]').replaceWith('');
			
			
			});
			
		</script>
		<% }%>
	</c:when>
</c:choose>		
			
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#from_add_hr_requirement').bootstrapValidator()
	.on("success.form.bv", function() {
    	$('#file_error').html("").hide();
   		var form = new FormData($('#from_add_hr_requirement')[0]);
	    $.ajax({
	        url: '<%=contextPath %>/hr_requirement/save_hr_requirement',
	        type: 'POST',
	        dataType :"json",
	        complete: function() {}, 
	        success: function (data) {
	        	if(data.status == 1) {
	        		location.href='<%=contextPath %>/hr_requirement/mng_hr_requirement';
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

	$('.cust_type').on("click", function() {
	    var btn_val=$(this).val();
	    
	    if (btn_val==1) {
	        $('.hide_hr_department').show();
	        $('#hide_hr_shift').hide();
	        $('.hide_labour_required').show();
	
	    }else{
	        $('.hide_hr_department').hide();
	        $('#hide_hr_shift').show();
	        $('.hide_labour_required').hide();
	        
	    }       
	    
	});

	$('#btn-cancel').on('click', function() {
	    var loc=$(this).attr('rel');
	   	location.href=loc;
	});

});

</script>