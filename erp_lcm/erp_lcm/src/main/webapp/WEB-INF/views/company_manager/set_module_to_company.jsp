<%@page import="com.spcl.erp.model.Com_Enquiry"%>
<%@page import="com.spcl.erp.model.Leave_type"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String contextPath = request.getContextPath(); 
	
%>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />

<div class="page-body">
	
	<div class="row">
	   	<div class="col-sm-12">
	       	<!-- Basic Inputs Validation start -->
	   		<div class="card">
	         	<div class="card-header">
	                   <h5>Enquiry</h5>
	             </div>
            	<div class="card-block">
            		<form id="add_leave" method="post" action="<%=contextPath%>/" modelAttribute="enquiry">
					<input type=hidden class="form-control" id="lt_id"name="lt_id" value="${enquiry.enq_id}" />
						<div class="row">
							<div class="col-sm-2">
								<label class="block" style="font-weight:bold">Enquirer Name</label>
							</div>
							<div class="col-sm-4">
	                			<span>${enquiry.enq_name}</span>
		                 	</div>
						</div>
						
						<div class="row">
							<div class="col-sm-2">
								<label  class="block" style="font-weight:bold">Company</label>
							</div>
							<div class="col-sm-4">
						        <span>${enquiry.enq_company_name}</span>
						    </div>
						</div>              	
	              	
	              	
						<div class="row">
							<div class="col-sm-2" >
								<label  class="block" style="font-weight:bold">Email id</label>
							</div>
							<div class="col-sm-4">
						        <span>${enquiry.enq_email}</span>
						    </div>
						</div>
	
						<div class="row">
							<div class="col-sm-2">
								<label  class="block" style="font-weight:bold">Designation</label>
							</div>
							<div class="col-sm-4">
						        <span>${enquiry.enq_post_id}</span>
						    </div>
						</div>
	                      
	                    <div class="row">
							<div class="col-sm-2">
	                        	<label class="block" style="font-weight:bold">Country</label>
	                       	</div>
	                        <div class="col-sm-4">
						        <span>${enquiry.enq_cuntry.cntry_name}</span>
						    </div>
						</div>
	                    
	                    <div class="row">
	                    	<label class="col-sm-2" style="font-weight:bold">Description</label>
	                        <div class="col-sm-4">
						        <span>${enquiry.enq_description}</span>
						    </div>
	                 	</div>
					</form>
	           	</div>
	           	
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
