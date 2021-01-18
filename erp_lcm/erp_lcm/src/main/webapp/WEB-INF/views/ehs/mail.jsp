
<%@page import="java.util.List"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.LabourService"%>
<%@page import="com.spcl.erp.model.LabourCheck"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String contextPath = request.getContextPath();
	String err_msg = request.getParameter("err_msg") != null ? request.getParameter("err_msg") : "";
	String msg = request.getParameter("msg") != null ? request.getParameter("msg") : "";
	//String  Message=(String)request.getParameter("Message");
%>
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
	href="<%=contextPath%>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<%--  <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/icon/ion-icon/css/ionicons.min.css"> --%>
<div id="file_error" class="alert alert-danger background-danger"
	style="display: none;"></div>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />


<div class="page-body" id="content">
	<div class="row">
		<div class="col-sm-12">
			<h3> Mail </h3>
<%-- 			 <p>${Message}</p>
 --%>			<!-- 	</div> -->
			<div class="card-block">
				<form action="<%=contextPath%>/mail" method="post">
					<div class="row">
						<label class="col-sm-3 col-form-label">To</label>
						<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
							<input type="text" name="to" />
						</div>
					</div>
					<div class="row">
						<label class="col-sm-3 col-form-label">Subject</label>
						<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
							<textarea type="text" name="subject"></textarea>
						</div>
					</div>
					<div class="row">
						<label class="col-sm-3 col-form-label">Message</label>
						<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
							<textarea type="text" name="message"></textarea>
						</div>
					</div>
					<div class="row">
						<label class="col-sm-3 col-form-label">Your Email id</label>
						<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
							<input type="text" name="gmailuser">
						</div>
					</div>
					<div class="row">
						<label class="col-sm-3 col-form-label">Password</label>
						<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
							<input type="password" name="gmailpass" />
						</div>
					</div>
					<div class="row">
						<input type="submit" value="send" />
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
	<script type="text/javascript"
		src="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
	<script type="text/javascript"
		src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>

	<%-- <script type="text/javascript">

$(document).ready(function(){
       var idx_num=0;
       var decimal_format=2;
  
       
       $('#from_transfer').bootstrapValidator()
           .on("success.form.bv", function() {
           var form = new FormData($('#from_transfer')[0]);
         
           $.ajax({
               url: '<%=contextPath %>/mail_ehs',
               type: 'POST',
               dataType :"json",
               complete: function() {}, 
               success:  function (data) {
               	if(data.status == 1) {
               		if(data.tra_id!=''){
               			location.href='<%=contextPath %>/labour/mng_checkIn';
               			$('#page_body').load('<%=contextPath %>/transfer/view_transfer?tra_id='+data.tra_id);
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
					
</script> --%>












