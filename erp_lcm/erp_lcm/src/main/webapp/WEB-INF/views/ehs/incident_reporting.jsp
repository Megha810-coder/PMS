 <%@page import="com.spcl.erp.model.Ehs_Action"%>
 <%@page import="com.spcl.erp.model.Ehs_witnesed"%>
 <%@page import="com.spcl.erp.model.Ehs_Incident"%>
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String contextPath = request.getContextPath();
    Ehs_Action ehs_Action=(Ehs_Action)request.getAttribute("action");
    String treatment_date=(String)request.getAttribute("treatment_date");
    String action_date=(String)request.getAttribute("action_date");
/* 	EhsService ehsService=(EhsService)request.getAttribute("EhsService");
 */
%>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<div id="file_error" class="alert alert-danger background-danger"
	style="display: none;"></div>
<!-- jquery file upload Frame work -->
<link
	href="<%=contextPath%>/resources/assets/pages/jquery.filer/css/jquery.filer.css"
	type="text/css" rel="stylesheet" />
<link
	href="<%=contextPath%>/resources/assets/pages/jquery.filer/css/themes/jquery.filer-dragdropbox-theme.css"
	type="text/css" rel="stylesheet" />
<!--forms-wizard css-->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/jquery.steps/css/jquery.steps.css">
<!-- Date-time picker css -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources//assets/pages/advance-elements/css/bootstrap-datetimepicker.css">
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<!-- Date-Dropper css -->
<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/resources/assets/bower_components/datedropper/css/datedropper.min.css" />
<style>
div.a{
  font-size:15px;
  font-weight:bold;
}
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
	min-height: 70em;
	overflow: hidden;
	position: relative;
	width: auto;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
}
#print{
display:none;
}
</style>
<!-- Page-header start -->
<div class="page-header">
	<div class="row align-items-end">
		<div class="col-lg-8">
			<div class="page-header-title">
				<div class="d-inline">
					<h4>Incident And Accident Management</h4>
				</div>
			</div>
		</div>
		
	</div>
</div>
<div align="center">
		  <button rel="<%=contextPath %>/ehs/mng_ehs" id="back" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button>
		<button  rel="<%=contextPath %>" id="print" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
		
</div>
<!-- Page-header end -->




<!-- Page body start -->
<!-- Design Wizard card start -->
<div class="card">
	<div class="card-header">
		<h3>${opr_mode=="save"?" ":""}</h3>
	</div>
	<section>
		<div class="card-block">
			<div class="row">
				<div class="col-md-12">
					<div id="wizard3">
						<form class="wizard-form" id="inc-design-wizard"
							action="<%=contextPath%>/ehs/save_ehs" method="post"
							modelAttribute="action">

							<input type=hidden class="form-control" id="opr_mode"
								name="opr_mode" value="${opr_mode}" /> 
							
							<input type=hidden
								class="form-control" id="action_id" name="action_id"
								value="" />
								
							
							<input type=hidden
								class="form-control" id="treatment_id" name="treatment.treatment_id"
								value="${action.treatment.treatment_id}" />
								
							
							<h3><span>Accident Information</span></h3>
							<fieldset>
								<legend>A)Accident Information</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											
											<div class="col-sm-6">
											
												<div class="row">
									<div class="col-sm-5">
										<label for="userName-2" class="block"><font size="3"><b>1)Employee Name: *</b></font></label>
										
									</div>
									<div class="col-sm-7">
										<input id="title" name="title" type="text"
											class=" form-control">
								</div>
								</div>
								</div>
								<div class="col-sm-6 row">
								<div class="col-sm-5">
										<label for="userName-2" class="block"><font size="3"><b>2)Plant Name: *</b></font></label>
									</div>
									<div class="col-sm-7">
										<input id="plant_name" name="plant_name" type="text"
											class=" form-control"></div>
								</div>
								</div>
								</div>
								</div>
								
									<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											
											<div class="col-sm-6">
											
												<div class="row">
									<div class="col-sm-5">
										<label for="userName-2" class="block"><font size="3"><b>3)Department: *</b></font></label>
									</div>
									<div class="col-sm-7">
										<input id="department" name="department" type="text"
											class=" form-control">
								</div>
								</div>
								</div>
								<div class="col-sm-6 row">
								<div class="col-sm-5">
										<label for="userName-2" class="block"><font size="3"><b>4)Incident Location: *</b></font></label>
									</div>
									<div class="col-sm-7">
										<input id="incident_location" name="incident_location" type="text"
											class=" form-control"></div>
								</div>
								</div>
								</div>
								</div>
								
									<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											
											<div class="col-sm-6">
											
												<div class="row">
									<div class="col-sm-5">
										<label for="userName-2" class="block"><font size="3"><b>5)Personal Mobile Number: *</b></font></label>
									</div>
									<div class="col-sm-7">
										<input id="personal_mobile" name="personal_mobile" type="text"
											class=" form-control">
								</div>
								</div>
								</div>
								<div class="col-sm-6 row">
								<div class="col-sm-5">
										<label for="userName-2" class="block"><font size="3"><b>6)Emergency Mobile Number:*</b></font></label>
									</div>
									<div class="col-sm-7">
										<input id="emergency_mobile" name="emergency_mobile" type="text"
											class=" form-control"></div>
								</div>
								</div>
								</div>
								</div>
						
								
						
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="comment" class="block"><font size="3"><b>7)Description: *</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea rows="4" cols="50" id="description"
											name="description" type="text" class=" form-control"></textarea>

									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="comment" class="block"><font size="3"><b>8)Imediate Action
											Taken:*</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea rows="4" cols="50" id="action" name="action"
											type="text" class=" form-control"></textarea>
									</div>

									<div class="col-sm-12">
										<label for="comment" class="block"><font size="3"><b>9)When did it happen?
											</b></font></label>
									</div>
								
									<div class="card col-sm-12">
										<div class="card-header"></div>
										<div class="card-block">
											<div class="row">
												<div class="col-sm-4">
							                   	 <label for="emp_date" class="block"><font size="3"><b>Date</b></font></label>
							                   	 <input id="action_date" name="action_date" type="text" class="form-control " placeholder="select Date"/>
							              		</div>
                   							 <div class="col-sm-4">
								                    <label class="sub-title"><font size="3"><b>Time</b></font></label>
								                    <input class="form-control" id="time" name="time" type="time" />
               								 </div>
												
											</div>
										</div>
									</div>
								</div>
									<legend>B)Witnessed</legend>
								<div id="more_witness"></div>
							</fieldset>

							

							<h3><span>Treatment</span></h3>
							<fieldset>
								<div class="form-group row">
								<legend>C)Treatment</legend>
									<div class="col-sm-12">
										<div class="row">
											
											<br><br>
											<div class="col-sm-6">
											
												<div class="row">
													<div class="col-sm-6">

														<label><font size="3"><b>1)Initial Treatment:-</b></font></label>
													</div>
													<div class="col-sm-6">
														<input id="physician" name="treatment.physician"
															type="text" class="form-control " value="First AID">
													</div>
												</div>
											</div>

											<div class="col-sm-6">
												<legend></legend>
												<div class="row">
													<div class="col-sm-6">

														<label><font size="3"><b>2)Secondary Treatment:-</b></font></label>
													</div>
													<div class="col-sm-6">
														<input id="first_aid" name="treatment.first_aid"
															type="text" class="form-control " value=" Company Medical Room ">
													</div>
												</div>
											</div>
										</div>
									</div>
										<div class="col-sm-6">
												<legend></legend>
												<div class="row">
													<div class="col-sm-6">

														<label><font size="3"><b>3)Hospital Treatment:-</b></font></label>
													</div>
													<div class="col-sm-6">
														<input id="treatment_provider" name="treatment.treatment_provider"
															type="text" class="form-control ">
													</div>
												</div>
											</div>
								</div>
				<br>
				<br>
			
								<div class="form-group row">
									<div class="col-sm-12">

										<div class="row">

											<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
												<div class="row">
													<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
														<label for="emp_gender" class="block"><font size="3"><b>I)Return to work same day:-</b></font></label>
													</div>
													<div
														class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
														<div class="radio radio-inline">
															<label> <input type="radio" class="form_control"
																name="treatment.beyond_first_aid" id="beyond_first_aid1"
																value="1"> <i class="helper"></i>Yes
															</label>
														</div>
														<div class="radio radio-inline">
															<label> <input type="radio" class="form_control"
																name="treatment.beyond_first_aid" id="beyond_first_aid2"
																value="2"> <i class="helper"></i>No
															</label>
														</div>
														
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">

										<div class="row">

											<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
												<div class="row">
													<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
														<label for="emp_gender" class="block"><font size="3"><b>II)Return to work next day:-</b></font></label>
													</div>
													<div
														class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
														<div class="radio radio-inline">
															<label> <input type="radio" class="form_control"
																name="treatment.impatient_overnight" id="impatient_overnight1"
																value="1"> <i class="helper"></i>Yes
															</label>
														</div>
														<div class="radio radio-inline">
															<label> <input type="radio" class="form_control"
																name="treatment.impatient_overnight" id="impatient_overnight2"
																value="2"> <i class="helper"></i>No
															</label>
														</div>
													
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>
							<div class="form-group row">
									<div class="col-sm-12">

										<div class="row">

											<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
												<div class="row">
													<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
														<label for="emp_gender" class="block"><font size="3"><b>III)Admitted for more than two days:-</b></font></label>
													</div>
													<div
														class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
														<div class="radio radio-inline">
															<label> <input type="radio" class="form_control"
																name="treatment.emergency_room" id="emergency_room1"
																value="1" onclick="myFunction()"> <i class="helper"></i>Yes
															</label>
														</div>
														<div class="radio radio-inline">
															<label> <input type="radio" class="form_control"
																name="treatment.emergency_room" id="emergency_room2"
																value="2" onclick="myFunctionhide()"> <i class="helper"></i>No
															</label>
														</div>
												
													</div>
														<p id="admitted" style="color: red"></p>
												</div>
											</div>

										</div>
									</div>
								</div>
						
							<br><br>
							
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="comment" class="block"><font size="3"><b>4)Comment:</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea id="comment"
											name="treatment.comment" type="text" class=" form-control"></textarea>

									</div>
								</div>
							
								<div class="form-group row" id="incident_pic">
								<legend>D)Documents</legend>
								<div class="card">
									
									<div class="card-block">
										
										  <input type="file" class="form-control" onchange="document.getElementById('file_name_view').src = window.URL.createObjectURL(this.files[0])" id="file_name_photo" name="file_name_photo">
		                        <img class="d-block img-fluid img-thumbnail" 
		                        	id="file_name_view" 
		                        	style="height: 150px;" 
		                        	 src="<%=contextPath %>/resources/lab_img/${ehs_Action.getFile_name() }"  
		                        	alt="Preview Photo here...."> 
									</div>
								</div>
							</div>
							</fieldset>

					
<%-- 
							 <h3></h3>
							<fieldset>
								<legend>Documents</legend>
								<div class="card">
									
									<div class="card-block">
										
										  <input type="file" class="form-control" onchange="document.getElementById('file_name_view').src = window.URL.createObjectURL(this.files[0])" id="file_name_photo" name="file_name_photo">
		                        <img class="d-block img-fluid img-thumbnail" 
		                        	id="file_name_view" 
		                        	style="height: 150px;" 
		                        	 src="<%=contextPath %>/resources/lab_img/${ehs_Action.get }"  
		                        	alt="Preview Photo here...."> 
									</div>
								</div>
								<div></div>
							</fieldset>  --%>
						</form>
					</div>
				</div>
			</div>
		</div>
	
	</section>
</div>                                        
<!-- Design Wizard card end -->
<!---model for contact and address end-->




<!-- Date-range picker js -->
<script type="text/javascript" src="<%=contextPath%>/resources/assets/pages/advance-elements/moment-with-locales.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<!-- Bootstrap date-time-picker js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/advance-elements/moment-with-locales.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/advance-elements/bootstrap-datetimepicker.min.js"></script>
<!--Forms - Wizard js-->
<script src="<%=contextPath %>/resources/assets/bower_components/jquery.cookie/js/jquery.cookie.js"></script>
<script src="<%=contextPath %>/resources/assets/bower_components/jquery.steps/js/jquery.steps.js"></script>
<script src="<%=contextPath %>/resources/assets/bower_components/jquery-validation/js/jquery.validate.js"></script>
<script src="<%=contextPath %>/resources/assets/pages/forms-wizard-validation/form-wizard.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    var wt_i=0;
    var wt_text='';

	var form = $("#inc-design-wizard").show();
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
	            var form = new FormData($('#inc-design-wizard')[0]);
	  			$.ajax({
	                 url: '<%=contextPath%>/ehs/save_ehs',
	                 type: 'POST',
	                 dataType :"json",
	                 complete: function() {}, 
	                 success:  function (data) {
	                 	if(data.status == 1) {
	                 		location.href='<%=contextPath%>/ehs/mng_ehs';
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

	  	$('#treatment_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
       });
	  
	  	$('#action_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	       });
	   <%	String opr_mode = (String) request.getAttribute("opr_mode");

			Ehs_Action action = (Ehs_Action) request.getAttribute("action");
			Ehs_witnesed witneses = (Ehs_witnesed) request.getAttribute("witnesed");
	

			if (action != null && opr_mode.equals("update")) {%>	
		
			
			$('#action_id').val('<%=action.getAction_id()%>');
			
			$('#treatment_id').val('<%=action.getTreatment().getTreatment_id()%>'); 
			$('#title').val('<%=action.getTitle()%>');
			$('#description').val('<%=action.getDescription()%>');
			$('#plant_name').val('<%=action.getPlant_name()%>');
			$('#department').val('<%=action.getDepartment()%>');
			$('#incident_location').val('<%=action.getIncident_location()%>');
			$('#personal_mobile').val('<%=action.getPersonal_mobile()%>');
			$('#emergency_mobile').val('<%=action.getEmergency_mobile()%>');
			$('#action').val('<%=action.getAction()%>');
			$('#action_date').val('${action_date}');
			<%-- $('#action_date').val('<%=action.getAction_date()%>'); --%>
			$('#time').val('<%=action.getTime()%>');
					
			$('#first_aid').val('<%=action.getTreatment().getFirst_aid()%>');
			$('#physician').val('<%=action.getTreatment().getPhysician()%>');
			$('#treatment_provider').val('<%=action.getTreatment().getTreatment_provider()%>');
		
			$('#comment').val('<%=action.getTreatment().getComment()%>');

		<%-- $('#treatment_date').val('<%=action.getTreatment().getTreatment_date()%>'); --%>
		
		if(<%=action.getTreatment().getBeyond_first_aid()%>==1){
			$('#beyond_first_aid1').prop('checked', true);
		}
		else if(<%=action.getTreatment().getBeyond_first_aid()%>==2){
			$('#beyond_first_aid2').prop('checked', true);
		}
			
		if(<%=action.getTreatment().getEmergency_room()%>==1){
			$('#emergency_room1').prop('checked', true);
		}
		else if(<%=action.getTreatment().getEmergency_room()%>==2){
			$('#emergency_room2').prop('checked', true);
		}
		
		
		if(<%=action.getTreatment().getImpatient_overnight()%>==1){
			$('#impatient_overnight1').prop('checked', true);
		}
		else if(<%=action.getTreatment().getImpatient_overnight()%>==2){
			$('#impatient_overnight2').prop('checked', true);
		}
	
	

		<% 
			for (Ehs_witnesed ehs_witnesed : action.getWitnesed_list()) {
			%>	
			
			wt_text +="<div class='form-group row'>"+
			"<div class='col-sm-12'>"+
			"<div class='row'>"+
			"<div class='col-sm-6'>"+
			"<label for='name-2' class='block'>Name *</label>"+
			"<input id='witnesed_list' name='witnesed_list["+wt_i+"].witness_name'"+
			"type='text' value='<%=ehs_witnesed.getWitness_name()%>' class='form-control'>"+
			"<input name='witnesed_list["+wt_i+"].witnesed_id'"+
			"type='hidden' value='<%=ehs_witnesed.getWitnesed_id()%>'>"+
			"</div>"+
			"<div class='col-sm-6'>"+
			"<label for='text-2' class='block'>Department *</label>"+ 
			"<input id='witness_org_unit'name='witnesed_list["+wt_i+"].witness_org_unit'"+ 
			"type='text' value='<%=ehs_witnesed.getWitness_org_unit()%>'  class='form-control'>"+
			"</div>"+
			"</div>"+
			"</div>"+
			"</div>"+
			"<div class='form-group row'>"+
			"<div class='col-sm-12'>"+
			"<div class='row'>"+
			"<div class='col-sm-6'>"+
			"<label for='email-2' class='block'>E-mail</label>"+
			                                        "<input id='witness_email' name='witnesed_list["+wt_i+"].witness_email'"+
			"type='email' value='<%=ehs_witnesed.getWitness_email()%>' class='form-control'>"+
			"</div>"+
			"<div class='col-sm-6'>"+
			"<label for='phone-2' class='block'>Phone No </label>"+
			                                        "<input type='text' id='witness_phone' name='witnesed_list["+wt_i+"].witness_phone' value='<%=ehs_witnesed.getWitness_phone()%>' class='form-control'>"+
			"</div>"+
			"</div>"+
			"</div>"+
			"</div>";
			wt_i++;

		<%}%>
		
		$("#more_witness").html(wt_text);		
		
		
		
		
	 	<% }else if(opr_mode.equals("view")){
			
		%>
		$('#print').show();
		
		$('#title').replaceWith($("<span>",{text:'<%=action.getTitle()%>'}));
		$('#description').replaceWith($("<span>",{text:'<%=action.getDescription()%>'}));
		$('#action').replaceWith($("<span>",{text:'<%=action.getAction()%>'}));
		$('#action_date').replaceWith($("<span>",{text:'<%=action.getAction_date()%>'}));
		$('#time').replaceWith($("<span>",{text:'<%=action.getTime()%>'}));
		
		$('#plant_name').replaceWith($("<span>",{text:'<%=action.getPlant_name()%>'}));
		$('#department').replaceWith($("<span>",{text:'<%=action.getDepartment()%>'}));
		$('#incident_location').replaceWith($("<span>",{text:'<%=action.getIncident_location()%>'}));
		$('#personal_mobile').replaceWith($("<span>",{text:'<%=action.getPersonal_mobile()%>'}));
		$('#emergency_mobile').replaceWith($("<span>",{text:'<%=action.getEmergency_mobile()%>'}));
	
		$('#first_aid').replaceWith($("<span>",{text:'<%=action.getTreatment().getFirst_aid()%>'}));
		$('#physician').replaceWith($("<span>",{text:'<%=action.getTreatment().getPhysician()%>'}));
		$('#treatment_provider').replaceWith($("<span>",{text:'<%=action.getTreatment().getTreatment_provider()%>'}));
		
		
		if(<%=action.getTreatment().getBeyond_first_aid()%>==1){
			$('#beyond_first_aid1').prop('checked', true);
		}
		else if(<%=action.getTreatment().getBeyond_first_aid()%>==2){
			$('#beyond_first_aid2').prop('checked', true);
		}
	
		
		if(<%=action.getTreatment().getEmergency_room()%>==1){
			$('#emergency_room1').prop('checked', true);
		}
		else if(<%=action.getTreatment().getEmergency_room()%>==2){
			$('#emergency_room2').prop('checked', true);
		}
		
		
		if(<%=action.getTreatment().getImpatient_overnight()%>==1){
			$('#impatient_overnight1').prop('checked', true);
		}
		else if(<%=action.getTreatment().getImpatient_overnight()%>==2){
			$('#impatient_overnight2').prop('checked', true);
		}
		
	
 	
		$('#witness_name').replaceWith($("<span>",{text:'<%=witneses.getWitness_name()%>'}));
		$('#witness_org_unit').replaceWith($("<span>",{text:'<%=witneses.getWitness_org_unit()%>'}));
		$('#witness_email').replaceWith($("<span>",{text:'<%=witneses.getWitness_email()%>'}));
		$('#witness_phone').replaceWith($("<span>",{text:'<%=witneses.getWitness_phone()%>'}));
		$('#comment').replaceWith($("<span>",{text:'<%=action.getTreatment().getComment()%>'}));

		$('input[type="submit"]').replaceWith('');
		$('input[type="reset"]').replaceWith(''); 
		<% 
		for (Ehs_witnesed ehs_witnesed : action.getWitnesed_list()) {
		%>	
		
		
		wt_text +="<div class='form-group row'>"+
						"<div class='col-sm-12'>"+
							"<div class='row'>"+
								"<div class='col-sm-6'>"+
								 "<div class='a'>"+
									"<label for='name-2' class='block'>Name *</label></div>"+
									"<input id='witnesed_list' name='witnesed_list["+wt_i+"].witness_name'"+
										"type='hidden' value='<%=ehs_witnesed.getWitness_name()%>' class='form-control'>"+'<%=ehs_witnesed.getWitness_name()%>' +
									
								"</div>"+
								"<div class='col-sm-6'>"+
								"<div class='a'>"+
									"<label for='text-2' class='block'> Department *</label></div>"+ 
									"<input id='witness_org_unit' name='witnesed_list["+wt_i+"].witness_org_unit'"+ 
									"type='hidden' value='<%=ehs_witnesed.getWitness_org_unit()%>'  class='form-control'>"+'<%=ehs_witnesed.getWitness_org_unit()%>' +
								"</div>"+
							"</div>"+
						"</div>"+
					"</div>"+
					"<div class='form-group row'>"+
						"<div class='col-sm-12'>"+
							"<div class='row'>"+
								"<div class='col-sm-6'>"+
								"<div class='a'>"+
									"<label for='email-2' class='block'>E-mail *</label></div>"+
                                    "<input id='witness_email' name='witnesed_list["+wt_i+"].witness_email'"+
										"type='hidden' value='<%=ehs_witnesed.getWitness_email()%>' class='form-control'>"+'<%=ehs_witnesed.getWitness_email()%>'+
								"</div>"+
								"<div class='col-sm-6'>"+
								"<div class='a'>"+
									"<label for='phone-2' class='block'>Phone No </label></div>"+
                                    "<input type='hidden' id='witness_phone' name='witnesed_list["+wt_i+"].witness_phone' value='<%=ehs_witnesed.getWitness_phone()%>' class='form-control'>"+'<%=ehs_witnesed.getWitness_phone()%>'+
								"</div>"+
							"</div>"+
						"</div>"+
					"</div>";
		wt_i++; 
	
	<%}%>
	
	$("#more_witness").html(wt_text);	
			
			
		<% }else{%> 
		
		
	 
			wt_text +="<div class='form-group row'>"+
					"<div class='col-sm-12'>"+
						"<div class='row'>"+
							"<div class='col-sm-6'>"+
							"<div class='a'>"+
								"<label for='name-2' class='block'>Name *</label></div>"+
								"<input id='witnesed_list' name='witnesed_list["+wt_i+"].witness_name'"+
									"type='text'  class='form-control'>"+
							"</div>"+
							"<div class='col-sm-6'>"+
							"<div class='a'>"+
								"<label for='text-2' class='block'>Department *</label></div>"+ 
								"<input id='witness_org_unit'name='witnesed_list["+wt_i+"].witness_org_unit'"+ 
								"type='text' class='form-control'>"+
							"</div>"+
						"</div>"+
					"</div>"+
				"</div>"+
				"<div class='form-group row'>"+
					"<div class='col-sm-12'>"+
						"<div class='row'>"+
							"<div class='col-sm-6'>"+
							"<div class='a'>"+
								"<label for='email-2' class='block'>E-mail</label></div>"+
                                "<input id='witness_email' name='witnesed_list["+wt_i+"].witness_email'"+
									"type='email' class='form-control'>"+
							"</div>"+
							"<div class='col-sm-6'>"+
							"<div class='a'>"+
								"<label for='phone-2' class='block'>Phone no</label></div>"+ 
								"<input id='witness_phone' name='witnesed_list["+wt_i+"].witness_phone' "+
									"type='text' class='form-control' >"+
							"</div>"+
						"</div>"+
					"</div>"+
				"</div>";
			$("#more_witness").html(wt_text); 
		
	<% }%>	
	
});

 $('#back').on('click', function() {
    var loc=$(this).attr('rel');
location.href=loc;	}); 
 
 function myFunction() {

	document.getElementById("admitted").innerHTML = "Please submite form Number 24 to factory Inspection Office.";	
	 $('#admitted').show();

 }
 function myFunctionhide(){
	 $('#admitted').hide();
 }

 $('#print').on('click',function(){
		 window.print();
		 });
</script>








