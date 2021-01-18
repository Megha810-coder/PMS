
<%@page import="java.util.List"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.LabourService"%>
<%@page import="com.spcl.erp.model.LabourCheck"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 	
	Helper helper=(Helper)request.getAttribute("helper");
	LabourService labourService=(LabourService)request.getAttribute("LabourService");
	LabourCheck labourCheck=(LabourCheck)request.getAttribute("labourCheck");
	String err_msg=request.getParameter("err_msg")!=null?request.getParameter("err_msg"):"";
	%>
<% String contextPath = request.getContextPath(); %>
<style>
#tra_partner_id {
	width: 340px;
}

gf
select {
	font-family: 'FontAwesome', Verdana;
}
</style>

<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<%--  <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/icon/ion-icon/css/ionicons.min.css"> --%>
<div id="file_error" class="alert alert-danger background-danger"
	style="display: none;"></div>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />


<!-- Page-header start -->
<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4>Labour Check_In</h4>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="index.html"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Labour Check_In</a></li>
					<li class="breadcrumb-item"><a href="#!">New</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!-- Page-header end -->




<!-- Page body start -->
<div class="page-body" id="content">
	<div class="row">
		<div class="col-sm-12">
			<!-- Basic Inputs Validation start -->
			<div class="card">
				<div class="card-header">
					<h3>${opr_mode=="save"?"labour Check_In":"labour Check_Out"}</h3>
					<p><%=err_msg %></p>
				</div>
				<div class="card-block">
					<form id="from_transfer" method="post"
						action="<%=contextPath%>/labour/save_labour"
						modelAttribute="labourCheck">
						<input type=hidden class="form-control" id="opr_mode"
							name="opr_mode" value="${opr_mode}" /> <input type=hidden
							class="form-control" id="lab_check_id" name="lab_check_id"
							value="${labourCheck.lab_check_id}" />
						<c:if test="${not empty msg}">
							<div class="alert alert-success background-success">${msg}</div>
						</c:if>
						<div class="row">
							<label class="col-sm-3 col-form-label">Labour Name</label>
							<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
								<select class="form-control" id="labour_lab_id"
									name="labour_lab_id" required
									data-bv-notempty-message="Please select name.">
									<option value="">---Select Labour Name---</option>
									<%=helper.getLabourDropDown() %>

								</select>
							</div>
						</div>
						<div class="row">
							<label class="col-sm-3 col-form-label">Department</label>
							<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
								<select id="department_dept_id" name="department_dept_id"
									class="form-control" required
									data-bv-notempty-message="Please select Department">
									<option value="">---Select Department---</option>
									<%=helper.getDepartmentDropDown() %>
								</select>
							</div>
						</div>
						<div class="row">
							<label class="col-sm-3 col-form-label">Shift Time</label>
							<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
								<select id="shift_id" name="shift_id" class="form-control"
									required data-bv-notempty-message="Please select Shift Time">
									<option value="">---Select Shift Time---</option>
									<option value="1">07:00-03.30</option>
									<option value="2">03.30-12:00</option>
									<option value="3">12:00-07:00</option>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<input type="submit" id="submit-btn"
									value='${opr_mode=="save"?"CheckIn":"CheckedOut"}'
									class="btn btn-primary m-b-0 submit navbutton"
									style="margin-left: 700px;"></input>
								<button rel="<%=contextPath %>/labour/mng_checkIn"
									id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- Basic Inputs Validation end -->
		</div>
	</div>
</div>
<!-- Page body end -->


<!-- Date-range picker js -->
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>

<script type="text/javascript">

$(document).ready(function(){
       var idx_num=0;
       var decimal_format=2;
  
       
       $('#from_transfer').bootstrapValidator()
           .on("success.form.bv", function() {
           var form = new FormData($('#from_transfer')[0]);
         
           $.ajax({
               url: '<%=contextPath %>/labour/save_labCheck',
               type: 'POST',
               dataType :"json",
               complete: function() {}, 
               success:  function (data) {
               	if(data.status == 1) {
               		if(data.tra_id!=''){
               			location.href='<%=contextPath %>/labour/mng_checkIn';
               			<%-- $('#page_body').load('<%=contextPath %>/transfer/view_transfer?tra_id='+data.tra_id); --%>
               		}
                   } else if(data.status == 0) { 
                   	$('#file_error').append(data.error).show();
                       $("#submit-btn").prop("disabled",false);
                   }
               },
               error: function(xhr, textStatus, thrownError) {
               	console.log("ERROR: ", thrownError);
                   alert("Labour completed 210 days....");
               },
               data: form,
               cache: false,
               contentType: false,
               processData: false
           });
           
           return false;
       });
       
       $('#btn-cancel').on('click', function() {
           var loc=$(this).attr('rel');
          location.href=loc;
       });
       
   
                          
	});
					
</script>











