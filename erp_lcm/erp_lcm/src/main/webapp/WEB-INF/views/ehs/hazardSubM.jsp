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
					<h4>MATERIAL SAFETY DATA SHEET</h4>
					<!-- <span>MSDS</span> -->
				</div>
			</div>
		</div>
		
	</div>
</div>
<div align="center">
		  <button rel="<%=contextPath %>/ehs/mng_hazardous" id="back" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button>
		<button  rel="<%=contextPath %>" id="print" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
		
</div>
<!-- Page-header end -->




<!-- Page body start -->
<!-- Design Wizard card start -->
<div class="card">
	<div class="card-header">
	<h3>${opr_mode=="save"?"":""}</h3>
		<!-- <h5>Design Wizard</h5>
<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span> -->

	</div>
	<section>
		<div class="card-block">
			<div class="row">
				<div class="col-md-12">
					<div id="wizard3">

						<form class="wizard-form" id="hazard" action="<%=contextPath%>/ehs/save_hazardous" method="post"  modelAttribute="chemicals">
						
						<input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
						<input type=hidden class="form-control" id="hazard_id" name="hazard_id" value="${hazard.hazard_id}" />
						<input type=hidden class="form-control" id="identification_id" name="identification.identification_id" value="${hazard.identification.identification_id}" />
						<input type=hidden class="form-control" id="first_id" name="first_aid.first_id" value="${hazard.first_aid.first_id}" />
						
							<h3><span>Material Safety Data Sheet</span></h3>
							<fieldset>
								<legend>A)MSDS</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1)Chemical Name:-</b></font> </label> <input
													id="chemical_name" name="chemical_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="email-2" class="block"><font size="3" ><b>2)Synonyms:-</b></font></label> <input
													id="synonyms" name="synonyms" type="text"
													class="form-control">
											</div>
											
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>3)Formula:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="formula" name="formula" type="text"
											class="form-control">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>4)Product Code:- </b></font></label> <input
													id="prod_code" name="prod_code" type="text" class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="phone-2" class="block"><font size="3" ><b>5)Supplier Name:-</b></font></label> <input
													id="supplier_name" name="supplier_name" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>6)Supplier
											Address:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea rows="3" cols="50" id="supplier_address" name="supplier_address"
											type="text" class=" form-control"></textarea>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="text-2" class="block"><font size="3" ><b>7)Supplier Phone:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="supplier_phone" name="supplier_phone" type="number"
											class="form-control">
									</div>
								</div>
								<legend>B)Physical and Chemical Properties</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1)Physical State:-</b></font> </label> <input
													id="phy_state" name="phy_state" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>2)Odor and
													Appearance:-</b></font> </label> <input id="odor_name" name="odor_name" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>3)vapor Pressure:-</b></font> </label> <input
													id="vapor_pressure" name="vapor_pressure" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>4)Vapor Density:-</b></font> </label> <input
													id="vapor_density" name="vapor_density" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>5)Evaporation Rate:-</b></font> </label>
												<input id="evaporation_rate" name="evaporation_rate" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>6)Boiling Point:-</b></font></label> <input
													id="boiling_point" name="boiling_point" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>7)Melting Point:-</b></font> </label> <input
													id="melting_point" name="melting_point" type="text"
													class="form-control">
											</div>
										</div>
									</div>
								</div>
							</fieldset>
							<h3><span>Hazard Identification</span></h3>
							<fieldset>
								<legend>C)Hazard Identification</legend>

								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1)Skin Contact:-</b></font></label>
												<textarea rows="3" cols="50" id="skin_contact" name="identification.skin_contact"
													type="text" class=" form-control"></textarea>
											</div>
											<div class="col-sm-6">
											
												<label for="text-2" class="block"><font size="3" ><b>2)Eye Contact:-</b></font></label>
												<textarea rows="3" cols="50" id="eye_contact" name="identification.eye_contact"
													type="text" class=" form-control"></textarea>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>3)Inhalation:-</b></font></label>
												<textarea rows="3" cols="50" id="inhalation" name="identification.inhalation"
													type="text" class=" form-control"></textarea>
											</div>
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>4)Long term Toxic
													Effect:-</b></font></label>
												<textarea rows="3" cols="50" id="toxic_effect" name="identification.toxic_effect"
													type="text" class=" form-control"></textarea>
											</div>

										</div>
									</div>
								</div>
								
								<legend>D)Risk Assessment</legend>
											<div class="form-group row">
												<div class="col-sm-12">
													<label for="address-2" class="block"><font size="3"><b>1)</b></font></label>
												</div>
												<div class="col-sm-12">
													<input id="RA1" name="identification.RA1" type="text"
														class="form-control">
												</div>
											</div>
											<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>2)</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="RA2" name="identification.RA2" type="text"
											class="form-control">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>3)</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="RA3" name="identification.RA3" type="text"
											class="form-control">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>4)</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="RA4" name="identification.RA4" type="text"
											class="form-control">
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>5)</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="RA5" name="identification.RA5" type="text"
											class="form-control">
									</div>
								</div>
							</fieldset>

							<h3><span>Treatment</span></h3>
							<fieldset>
							<legend>E)Treatment</legend>

								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1)Skin Contact:-</b></font></label>
												<textarea rows="3" cols="50" id="skin_contacts" name="first_aid.skin_contacts"
													type="text" class=" form-control"></textarea>
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>2)Eye Contact:-</b></font></label>
												<textarea rows="3" cols="50" id="eye_contacts" name="first_aid.eye_contacts"
													type="text" class=" form-control"></textarea>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>3)Inhalation:-</b></font></label>
												<textarea rows="3" cols="50" id="inhalations" name="first_aid.inhalations"
													type="text" class=" form-control"></textarea>
											</div>
											

										</div>
									</div>
								</div>
								

								<div class="form-group row" id="document">
									<div class="col-sm-12">
										<legend>F)Documents</legend>
										<div class="card">
											<div class="card-block">
												<input type="file" class="form-control"
													onchange="document.getElementById('doc_name_view').src = window.URL.createObjectURL(this.files[0])"
													id="doc_name" name="doc_name" multiple="multiple">
												<img class="d-block img-fluid img-thumbnail"
													id="file_name_view" style="height: 150px;"
													alt="Preview Photo here....">
											</div>
										</div>
									</div>
								</div>

							</fieldset>
								<!-- <h3></h3>
							<fieldset>
							<div class="card-block">
									<label for="name-2" class="block"><font size="3" > <b>MSdS Document:-</font></label>
										  <input type="file" class="form-control" onchange="document.getElementById('doc_name_view').src = window.URL.createObjectURL(this.files[0])" id="doc_name" name="doc_name" multiple="multiple">
									</div>
							<form action="uploadFile" enctype="multipart/form-data">
								<legend>Documents</legend>
            
           							 File upload card start
           							 
                                        <div class="card">
                                            <div class="card-header">
                                                <h5>Add Documents</h5>
                                                <div class="card-header-right">
                                                    <ul class="list-unstyled card-option">
                                                        <li><i class="feather icon-maximize full-card"></i></li>
                                                        <li><i class="feather icon-minus minimize-card"></i></li>
                                                        <li><i class="feather icon-trash-2 close-card"></i></li>
                                                    </ul>
                                                </div>
                                            </div>
                                            <div class="card-block">
                                                <div class="sub-title">Document Name</div>
                                                <input type="file" name="file" id="filer_input1" >
                                            </div>
                                        </div>
                                        <div>
                                             <input type="submit" value="Upload">
                                        </div>
								
								</form>
							</fieldset> -->
<!-- 
							 <h3></h3>
        <fieldset>
            <legend>Documents</legend>

								File upload card start
								<form method="POST" modelAttribute="fileUpload"
									enctype="multipart/form-data">
									<div class="card">
										<div class="card-header">
											<h5>Add Documents</h5>
											<div class="card-header-right">
												<ul class="list-unstyled card-option">
													<li><i class="feather icon-maximize full-card"></i></li>
													<li><i class="feather icon-minus minimize-card"></i></li>
													<li><i class="feather icon-trash-2 close-card"></i></li>
												</ul>
											</div>
										</div>
										<div class="card-block">
											<div class="sub-title">Document Name</div>
											<input type="file" name="file" id="filer_input1"
												multiple="multiple">
										</div>
									</div>
									<div>
										<input type="submit" value="upload" />
									</div>
								</form>

								File upload card end

							</fieldset> 
 -->
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
	var form = $("#hazard").show();
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
          //alert("Submitted!");
        	$('#file_error').hide();
            var form = new FormData($('#hazard')[0]);
  			$.ajax({
                 url: '<%=contextPath%>/ehs/save_hazardous',
                 type: 'POST',
                 dataType :"json",
                 complete: function() {}, 
                 success:  function (data) {
                 	if(data.status == 1) {
                 		location.href='<%=contextPath%>/ehs/mng_hazardous';
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
	
	
	 <%-- $('#design-wizard').bootstrapValidator()
     .on("success.form.bv", function() {
    	$('#file_error').hide();
     	var form = new FormData($('#design-wizard')[0]);
     	$.ajax({
	         url: '<%=contextPath%>/ehs/save_ehs',
	         type: 'POST',
	         dataType :"json",
	         complete: function() {}, 
	         success:  function (data) {
	         	if(data.status == 1) {
	         		location.href='<%=contextPath %>/ehs/mng_ehs';
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
	var idx_num=1;
	var decimal_format=2;
	$('#design-wizard').bootstrapValidator()
    	.on("success.form.bv", function() {
    	var form = new FormData($('#from_add_cust_ved')[0]);
    	alert('validating form');
    	//$("#file_error").text("").hide();
    	return false;
	}); --%>
	
	
	
	
});
</script>

<%	Hazardous_Chemicals hazard=(Hazardous_Chemicals)request.getAttribute("hazard");
	String opr_mode=(String)request.getAttribute("opr_mode");

		if(opr_mode!=null&&hazard!=null){
			if(opr_mode.equals("update")){
					
			
	%>	
		<script type="text/javascript">
			$(document).ready(function() {
				$('#chemical_name').val('<%=hazard.getChemical_name()%>');
		        $('#prod_code').val('<%=hazard.getProd_code()%>');
		        $('#formula').val('<%=hazard.getFormula()%>');
		        $('#synonyms').val('<%=hazard.getSynonyms()%>');
		        $('#supplier_name').val('<%=hazard.getSupplier_name()%>');
		        $('#supplier_address').val('<%=hazard.getSupplier_address().replaceAll("\r\n", " ")%>');
		        $('#supplier_phone').val('<%=hazard.getSupplier_phone()%>');
		        $('#phy_state').val('<%=hazard.getPhy_state()%>');
		        $('#odor_name').val('<%=hazard.getOdor_name()%>');
		        $('#vapor_pressure').val('<%=hazard.getVapor_pressure()%>');
		        $('#vapor_density').val('<%=hazard.getVapor_density()%>');
		        $('#evaporation_rate').val('<%=hazard.getEvaporation_rate()%>');
		        $('#boiling_point').val('<%=hazard.getBoiling_point()%>');
		        $('#melting_point').val('<%=hazard.getMelting_point()%>');
		        $('#skin_contact').val('<%=hazard.getIdentification().getSkin_contact()%>');
		        $('#eye_contact').val('<%=hazard.getIdentification().getEye_contact()%>');
		        $('#inhalation').val('<%=hazard.getIdentification().getInhalation()%>');
		        $('#ingestion').val('<%=hazard.getIdentification().getIngestion()%>');
		        $('#toxic_effect').val('<%=hazard.getIdentification().getToxic_effect()%>');
		        $('#RA1').val('<%=hazard.getIdentification().getRA1()%>');
		        $('#RA2').val('<%=hazard.getIdentification().getRA2()%>');
		        $('#RA3').val('<%=hazard.getIdentification().getRA3()%>');
		        $('#RA4').val('<%=hazard.getIdentification().getRA4() %>');
		        $('#RA5').val('<%=hazard.getIdentification().getRA5()%>');
		        $('#skin_contacts').val('<%=hazard.getFirst_aid().getSkin_contacts()%>');
		        $('#eye_contacts').val('<%=hazard.getFirst_aid().getEye_contacts()%>');
		        $('#inhalations').val('<%=hazard.getFirst_aid().getInhalations()%>');
		        $('#ingestions').val('<%=hazard.getFirst_aid().getIngestions()%>');
		        $('#other').val('<%=hazard.getFirst_aid().getOther()%>');
		        
			});
		</script>
<% 			}else if(opr_mode.equals("view")){ %>

		
		<script type="text/javascript">
	
			$(document).ready(function() {
				$('#print').show();
				$('#chemical_name').replaceWith($("<span>",{text:'<%=hazard.getChemical_name()%>'}));
				$('#prod_code').replaceWith($("<span>",{text:'<%=hazard.getProd_code()%>'}));
				$('#formula').replaceWith($("<span>",{text:'<%=hazard.getFormula()%>'}));
				$('#synonyms').replaceWith($("<span>",{text:'<%=hazard.getSynonyms()%>'}));
				$('#supplier_name').replaceWith($("<span>",{text:'<%=hazard.getSupplier_name()%>'}));
				$('#supplier_address').replaceWith($("<span>",{text:"<%=hazard.getSupplier_address().replaceAll("\r\n", " ")%>"})); 
				$('#supplier_phone').replaceWith($("<span>",{text:'<%=hazard.getSupplier_phone()%>'}));
				$('#phy_state').replaceWith($("<span>",{text:'<%=hazard.getPhy_state()%>'}));
				$('#odor_name').replaceWith($("<span>",{text:'<%=hazard.getOdor_name()%>'}));
				$('#vapor_pressure').replaceWith($("<span>",{text:'<%=hazard.getVapor_pressure()%>'}));
				$('#vapor_density').replaceWith($("<span>",{text:'<%=hazard.getVapor_density()%>'}));
				$('#evaporation_rate').replaceWith($("<span>",{text:'<%=hazard.getEvaporation_rate()%>'}));
				$('#melting_point').replaceWith($("<span>",{text:'<%=hazard.getMelting_point()%>'}));
				$('#boiling_point').replaceWith($("<span>",{text:'<%=hazard.getBoiling_point()%>'}));
				$('#skin_contact').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getSkin_contact()%>'}));
				$('#eye_contact').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getEye_contact()%>'}));
				$('#inhalation').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getInhalation()%>'}));
				$('#ingestion').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getIngestion()%>'}));
				$('#toxic_effect').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getToxic_effect()%>'}));
				$('#RA1').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getRA1()%>'}));
				$('#RA2').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getRA2()%>'}));
				$('#RA3').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getRA3()%>'}));
				$('#RA4').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getRA4()%>'}));
				$('#RA5').replaceWith($("<span>",{text:'<%=hazard.getIdentification().getRA5()%>'}));
 				$('#skin_contacts').replaceWith($("<span>",{text:'<%=hazard.getFirst_aid().getSkin_contacts()%>'}));
				$('#eye_contacts').replaceWith($("<span>",{text:'<%=hazard.getFirst_aid().getEye_contacts()%>'}));
				$('#inhalations').replaceWith($("<span>",{text:'<%=hazard.getFirst_aid().getInhalations()%>'}));
				$('#ingestions').replaceWith($("<span>",{text:'<%=hazard.getFirst_aid().getIngestions()%>'}));
				$('#other').replaceWith($("<span>",{text:'<%=hazard.getFirst_aid().getOther()%>'})); 
				
				
				
				$('#document').replaceWith('');
				//$('#').replaceWith('');
			});
				
			function myFunction() {

				document.getElementById("admitted").innerHTML = "Please submite form Number 24 to factory Inspection Office.";	
				 $('#admitted').show();

			}
			function myFunctionhide(){
				 $('#admitted').hide();
			}
			
		</script>

	
<%			}
			
		}
%>

<script type="text/javascript">

$('#back').on('click', function() {
   var loc=$(this).attr('rel');
location.href=loc;	}); 


$('#print').on('click',function(){
		 window.print();
		 });
</script>







