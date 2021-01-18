<%@page import="com.spcl.erp.model.Leave_Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
         	<!-- Basic Inputs Validation start -->
          	<div class="card">
                <div class="card-header">
                  	<h5>${opr_mode=="save"?"New Leave Department":"Edit Leave Department"}</h5>
          		</div>
                                <div class="card-block">
                               		<form id="add_leave_department" method="post" action="<%=contextPath%>/leave/save_leave_department" modelAttribute="leave_department">
								<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
									<input type=hidden class="form-control" id="ld-id"name="ld_id" value="${leave_department.ld_id}" />
					
                                <div class="row">
                                        <div class="col-sm-6">
                                     <div class="row">
                                        <label class="col-sm-3 col-form-label">Leave Type</label>
                                            <div class="form-group col-sm-5">
                                          <select name="ld_leave_type" class="form-control" required data-bv-notempty-message="Please select title.">
                                                 
                                                   <option value="compensatory days">Compensatory Days</option>
                                                    <option value="unpaid">Unpaid</option>
                                                    <option value="sick leave">Sick Leaves</option>
                                                    <option value="create and edit">Create and Edit</option>
                                                    </select>
                                                  </div>
                                           </div>
                                         </div>
                                         <div class="col-sm-6">
                                       <div class="row">
                                            <label class="col-sm-3 col-form-label">Duration</label>
                                              <div class="form-group col-sm-5">
                                                <input type="text" class="form-control" id="ld_duration" name="ld_duration" placeholder="Duration" required data-bv-notempty-message="Please select title.">
                                                 <span class="messages"></span>
                                                  </div>
                                                 </div>
                                               </div>
                                             </div>
                                             <div class="row">
                                        <div class="col-sm-6">
                                                     <div class=" row">
                                                 <label class="col-sm-3 col-form-label">Display Name</label>
                                                   <div class="form-group col-sm-5">
                                             <input type="text" class="form-control" id="ld_display_name" name="ld_display_name" placeholder="display_name" required data-bv-notempty-message="Please enter first name.">
                                                <span class="messages"></span>
                                                  </div>
                                               </div>
                                             </div>
                                             <div class="col-sm-6">
                                                <div class=" row">
                                                  <label class="col-sm-3 col-form-label">Manager</label>
                                                   <div class="form-group col-sm-5">
                                                <input type="text" class="form-control" id="ld_manager" name="ld_manager" placeholder="manager" required data-bv-notempty-message="Please enter first manager.">
                                                  <span class="messages"></span>
                                                 </div>
                                              </div>
                                            </div>
                                          </div>
                                           <div class="row">
                                        <div class="col-sm-6">
                                    
                                        <div class="row">
                                             <label class="col-sm-3 col-form-label">Parent Department</label>
                                             <div class="form-group  col-sm-5">
                                         <input type="text" class="form-control" id="ld_parent_department" name="ld_parent_department" placeholder="Duration" required data-bv-notempty-message="Please enter first parent department.">
                                                 <span class="messages"></span>
                                            </div>
                                         </div>
                                     </div>
                                  </div>
                                            <div class="form-group row">
                                                      <div class="col-sm-12">
                                                   	    <div class="form-group  col-sm-12">
	                         						<input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         					<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         						<button rel="<%=contextPath %>/leave/new_Leave_Department" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
                                                     </div>
                                                    </div>
                                
                                                        </form>
                                                    </div>
                                                  </div>
                                                  <c:choose>
					<c:when test = '${opr_mode=="update"}'>
					
						<%Leave_Department leave_department=(Leave_Department)request.getAttribute("leave_department");
			           		if(leave_department!=null){
			           	
			           	%>	
			           		<script type="text/javascript">
									$(document).ready(function() {
										$('#leave_type').val('<%=leave_department.getLd_leave_type()%>');
										$('#display_name').val('<%=leave_department.getLd_display_name()%>');
										$('#duration').val('<%=leave_department.getLd_duration()%>');
										$('#manager').val('<%=leave_department.getLd_manager()%>');
										$('#parent_department').val('<%=leave_department.getLd_parent_department()%>');
										});
								
								</script>
			           	
			           	
			           	<% }%>
						
					</c:when>
				</c:choose>
                    </div>
                                                </div>
                                              </div>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 $('#department').bootstrapValidator()
   .on("success.form.bv", function() {
  var form = new FormData($('#department')[0]);
  alert('validating form');
            //$("#file_error").text("").hide();
                            
    return false;
        });
$('#add_leave_department').bootstrapValidator();
 
 $('#btn-cancel').on('click', function() {
     var loc=$(this).attr('rel');
    location.href=loc;
	});
    });

</script>