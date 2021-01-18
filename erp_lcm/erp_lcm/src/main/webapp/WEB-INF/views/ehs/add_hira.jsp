<%-- <%@page import="com.spcl.erp.model.Bank"%>
<%@page import="java.util.List"%> --%>
<%@page import="com.spcl.erp.model.Hazardous_Chemicals"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String contextPath = request.getContextPath();
   // Hazardous_Chemicals hazardous_Chemicals=(Hazardous_Chemicals)request.getAttribute("hazardous_Chemicals");

%>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<!-- jquery file upload Frame work -->
<link
	href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/jquery.filer.css"
	type="text/css" rel="stylesheet" />
<link
	href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/themes/jquery.filer-dragdropbox-theme.css"
	type="text/css" rel="stylesheet" />
<!--forms-wizard css-->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources/assets/bower_components/jquery.steps/css/jquery.steps.css">
<!-- Date-time picker css -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources//assets/pages/advance-elements/css/bootstrap-datetimepicker.css">
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<!-- Date-Dropper css -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath %>/resources/assets/bower_components/datedropper/css/datedropper.min.css" />
<style>
#design-wizard .steps li {
	width: 20%;
}

#design-wizard .steps li a {
	width: 40%;
}

.checkbox-zoom label input[type="checkbox"], .checkbox-zoom label input[type="radio"]
	{
	display: none;
}

.wizard>.content {
	background: #eee;
	display: block;
	margin: 0.5em;
	min-height: 110em;
	overflow: hidden;
	position: relative;
	width: auto;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}
</style>
<!-- Page-header start -->
<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4></h4>
					<!-- <span>MSDS</span> -->
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="page-header-breadcrumb">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="index.html"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Invoice</a></li>
					<li class="breadcrumb-item"><a href="#!">New</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
 <div class="btn-group m-b-5 m-t-5">
 <button  rel="<%=contextPath %>/ehs/mng_hira"  id="back" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button>
 </div>
 <!--  <div class="btn-group m-b-5 m-t-5">
 <button    id="print" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
 </div> -->
<!-- Page-header end -->




<!-- Page body start -->
<!-- Design Wizard card start -->
<div class="card">
	<div class="card-header">
	<h3>${opr_mode=="save"?"Add New ":"Edit"}</h3>
		<!-- <h5>Design Wizard</h5>
<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span> -->

	</div>
	<section>
		<div class="card-block">
			<div class="row">
				<div class="col-md-12">
					<div id="wizard3">

						<form class="wizard-form" id="hira" action="<%=contextPath%>/ehs/save_hira" method="post"  modelAttribute="hira">
						
						<input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
						<input type=hidden class="form-control" id="hira_id" name="hira_id" value="${hira.hira_id}" />
							<h3><span>Hazard Identification and Risk Analysis</span></h3>
							<fieldset>
								<legend>HIRA</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4" ><b>SR NO:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="sr_no" name="sr_no" type="text"
											class="form-control"></font>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4" ><b>Activity:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="activity" name="activity" type="text"
											class="form-control"></font>
									</div>
								</div>
								
								<legend>Aspect</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Land:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="land" name="land"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Air:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="air" name="air"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Water:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="water" name="water"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Human Being:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="human" name="human"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Resource:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="resource" name="resource"
											type="text" class="form-control"></font>
									</div>

								</div>
								<legend>Impact on</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Land:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="land1" name="land1"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Air:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="air1" name="air1"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Water:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="water1" name="water1"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Human Being:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="human1" name="human1"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4"><b>Resource:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="resource1" name="resource1"
											type="text" class="form-control"></font>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4" ><b>Total Rating:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="total_rating" name="total_rating" type="text"
											class="form-control"></font>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4" ><b>Legal Exposure:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="legal" name="legal" type="text"
											class="form-control"></font>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4" ><b>frequency of occurrence:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="frequency" name="frequency" type="text"
											class="form-control"></font>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="4" ><b>Overall Impact Rating:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<font size="3"><input id="impact_rating" name="impact_rating" type="text"
											class="form-control"></font>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
</div>
</section>
<!-- Design Wizard card end -->

<!---model for contact and address end-->




<!-- Date-range picker js -->
<script type="text/javascript"
	src="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<!-- Bootstrap date-time-picker js -->
<script type="text/javascript"
	src="<%=contextPath%>/resources/assets/pages/advance-elements/moment-with-locales.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/bower_components/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="<%=contextPath %>/resources/assets/pages/advance-elements/bootstrap-datetimepicker.min.js"></script>
<!--Forms - Wizard js-->
<script
	src="<%=contextPath %>/resources/assets/bower_components/jquery.cookie/js/jquery.cookie.js"></script>
<script
	src="<%=contextPath %>/resources/assets/bower_components/jquery.steps/js/jquery.steps.js"></script>
<script
	src="<%=contextPath %>/resources/assets/bower_components/jquery-validation/js/jquery.validate.js"></script>
<script
	src="<%=contextPath %>/resources/assets/pages/forms-wizard-validation/form-wizard.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var form = $("#hira").show();
    form.steps({
        headerTag: "h3",
        bodyTag: "fieldset",
        transitionEffect: "slideLeft",
        onStepChanging: function(event, currentIndex, newIndex) {

            // Allways allow previous action even if the current form is not valid!
            if (currentIndex > newIndex) {
                return true;
            }
            // Forbid next action on "Warning" step if the user is to young
            if (newIndex === 3 && Number($("#age-2").val()) < 18) {
                return false;
            }
            // Needed in some cases if the user went back (clean up)
            if (currentIndex < newIndex) {
                // To remove error styles
                form.find(".body:eq(" + newIndex + ") label.error").remove();
                form.find(".body:eq(" + newIndex + ") .error").removeClass("error");
            }
            form.validate().settings.ignore = ":disabled,:hidden";
            return form.valid();
        },
        onStepChanged: function(event, currentIndex, priorIndex) {

            // Used to skip the "Warning" step if the user is old enough.
            if (currentIndex === 2 && Number($("#age-2").val()) >= 18) {
                form.steps("next");
            }
            // Used to skip the "Warning" step if the user is old enough and wants to the previous step.
            if (currentIndex === 2 && priorIndex === 3) {
                form.steps("previous");
            }
        },
        onFinishing: function(event, currentIndex) {
             form.validate().settings.ignore = ":disabled";
            return form.valid(); 
        },
        onFinished: function(event, currentIndex) {
          alert("Submitted!");
        	$('#file_error').hide();
            var form = new FormData($('#hira')[0]);
  			$.ajax({
                 url: '<%=contextPath%>/ehs/save_hira',
                 type: 'POST',
                 dataType :"json",
                 complete: function() {}, 
                 success:  function (data) {
                 	if(data.status == 1) {
                 		location.href='<%=contextPath%>/ehs/mng_hira';
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
 			
        	}
	    }).validate({
	        errorPlacement: function errorPlacement(error, element) {
	
	            element.before(error);
	        },
	        rules: {
	            confirm: {
	                equalTo: "#password-2"
	            }
	        }
	    });
	
});
$('#back').on('click', function() {
    var loc=$(this).attr('rel');
location.href=loc;	});
 
</script>







