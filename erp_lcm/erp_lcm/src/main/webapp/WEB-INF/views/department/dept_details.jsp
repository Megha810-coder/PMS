<%@page import="com.spcl.erp.model.Department_type"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String contextPath = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
          <div class="card">
                <div class="card-header">
                          <h5>${opr_mode=="save"?"New Department Type":"Edit Department_type"}</h5>
                             </div>
                            <div class="card-block">
                            <form id="add_department" method="post" action="<%=contextPath%>/department/save_department_type" modelAttribute="Department_type">
                            <input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
                            <input type=hidden class="form-control" id="dept_id"name="dept_id" value="${department_type.dept_id}" />
                                   				 <div class="form-group row">
                                     				 <label class="col-sm-2 col-form-label">Department</label>
                                        			<div class="col-sm-3">
                                        			<input type="text" class="form-control" id="dt_department_name" name="dt_department_name" required data-bv-notempty-message="Please enter department name." placeholder="Please enter department name.">
                                    				 </div>
                                 					</div>
											
                                                    	 <div class="form-group row">
                                    					  <label class="col-sm-2 col-form-label">manager</label>
                                      					  <div class="col-sm-3">
                                      						  <input type="text" class="form-control" id="dt_manager" name="dt_manager" required data-bv-notempty-message="Please enter manager."  placeholder="Please enter manager.">
                                   								  </div>
                                							 </div>
                                                      <div class="form-group row">
                                    						  <label class="col-sm-2 col-form-label">Parent Department</label>
                                        						<div class="col-sm-3">
                                       				 			<input type="text" class="form-control" id="dt_parent_department" name="dt_parent_department" required data-bv-notempty-message="Please enter parent depatment."  placeholder="Please enter parent department.">
                                     						</div>
                                						 </div>
                                                <div class="form-group row">
                                                   <div class="col-sm-12">
                                                   <input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
                                                   <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
                                                   	<button rel="<%=contextPath %>/department/department_list" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
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
		<% 	Department_type department_type=(Department_type)request.getAttribute("department_type");
			if(department_type!=null){
		%>
		<script type="text/javascript">
		$(document).ready(function() {
				
				<%-- <% if(customer.getCust_type()==1){ %>
					$('#cust_type').prop('checked', true);
				<%	}else{ %>
				<% if(customer.getCust_type()==2){ %>
					$('#cust_type').prop('checked', true);
				<%	}}%> --%>
				
				$('#dt_department_name').val('<%=department_type.getDt_department_name()%>');
				$('#dt_manager').val('<%=department_type.getDt_manager()%>');
				$('#dt_parent_department').val('<%=department_type.getDt_parent_department()%>');
			});
				
		</script>
		<% }%>
	</c:when>
</c:choose>


<c:choose>
	<c:when test = '${opr_mode=="view"}'>
		<% 	Department_type department_type=(Department_type)request.getAttribute("department_type");
			if(department_type!=null){
		%>
		<script type="text/javascript">
			$(document).ready(function() {
		
				$('#dt_department_name').replaceWith($("<span>", {text: '<%=department_type.getDt_department_name() %>'}));
				$('#dt_manager').replaceWith($("<span>", {text: '<%=department_type.getDt_manager()%>'}));
				$('#dt_parant_department').replaceWith($("<span>", {text: '<%=department_type.getDt_parent_department()%>'}));
				
				
			});
			
		</script>
		<% }%>
	</c:when>
</c:choose>
		  
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script><script type="text/javascript">
$(document).ready(function(){
 $('#job_vacancy').bootstrapValidator()
   .on("success.form.bv", function() {
  var form = new FormData($('#job_vacancy')[0]);
  alert('validating form');
            //$("#file_error").text("").hide();
                            
    return false;
        });

 $('#add_department').bootstrapValidator();
 
 	$('#btn-cancel').on('click', function() {
     	var loc=$(this).attr('rel');
    	location.href=loc;
	});
});
</script>