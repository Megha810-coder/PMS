 <%@page import="com.spcl.erp.model.Ehs_Waste"%>
  <%@page import="com.spcl.erp.model.Ehs_Shipping"%>
   <%@page import="com.spcl.erp.model.Ehs_Waste_Transport"%>
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String contextPath = request.getContextPath();
/*  	EhsService ehsService=(EhsService)request.getAttribute("EhsService");
 */ 
  
%>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>
<!-- jquery file upload Frame work -->
<link href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/jquery.filer.css" type="text/css" rel="stylesheet" />
<link href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/themes/jquery.filer-dragdropbox-theme.css" type="text/css" rel="stylesheet" />
<!--forms-wizard css-->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/jquery.steps/css/jquery.steps.css">
<!-- Date-time picker css -->
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources//assets/pages/advance-elements/css/bootstrap-datetimepicker.css">
    <!-- Date-range picker css  -->
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
    <!-- Date-Dropper css -->
    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/datedropper/css/datedropper.min.css" />
<style>

    #design-wizard .steps li{
        width: 20%;
    }
    #design-wizard .steps li a{
        width: 40%;
    }
.checkbox-zoom label input[type="checkbox"], .checkbox-zoom label input[type="radio"] {

    display: none;

}

.wizard > .content {

    background: #eee;
    display: block;
    margin: 0.5em;
    min-height: 50em;
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
            <h4>INDUSTRIAL HYGIENE AND SAFETY</h4>
            <span>Report Industrial Hygiene And Safety Management</span>
        </div>
    </div>
</div>
<div class="col-lg-4">
    <div class="page-header-breadcrumb">
        <ul class="breadcrumb-title">
            <li class="breadcrumb-item">
                <a href="index.html"> <i class="feather icon-home"></i> </a>
            </li>
            <li class="breadcrumb-item"><a href="#!">Invoice</a>
            </li>
             <li class="breadcrumb-item"><a href="#!">New</a>
            </li>
        </ul>
    </div>
</div>
</div>
</div>
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

    <form class="wizard-form" id="inc-design-wizard" action="<%=contextPath%>/ehs/save_industrial" method="post"  modelAttribute="industrial">
    
    <input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
	<input type=hidden class="form-control" id="industrial_id" name="industrial_id" value="${industrial.industrial_id}" />
	<%-- <input type=hidden class="form-control" id="shipping_id" name="ehs_Shipping.shipping_id" value="${waste.ehs_Shipping.shipping_id}" />
	<input type=hidden class="form-control" id="trans_id" name="ehs_Waste_Transport.trans_id" value="${waste.ehs_Waste_Transport.trans_id}" /> --%>
						
        <h3></h3>
                <fieldset>
								<legend>Inspection Programs Aspects</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>Inspection Program Name:</b></font> </label> <input
													id="industrial_name" name="industrial_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>Aspect:</b> </font></label> <input
													id="industrial_aspect" name="industrial_aspect" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								
								
								
									<div class="form-group row">
									<div class="col-sm-12">
										<label for="text-2" class="block"><font size="3" ><b>Inspection Description:</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea rows="4" cols="50" id="industrial_des" name="industrial_des"
													type="text" class=" form-control"></textarea>
								    	</div>
								   </div>
								   
					 <!--   <div class="row">
					    	<label class="col-sm-3"><font size="4" >Waste Department:
						   </label></font>
							 <div class="col-sm-3">
								<select type="text" class="form-control"
										id="waste_department" name="waste_department"
											data-bv-notempty-message="Please enter Department Type.">
											<option value="">---Select Department---</option>
											<option value="Production">Production</option>
											<option value="Research and Development">Research and Development</option>
											<option value="Purchasing">Purchasing</option>
											<option value="Marketing">Marketing </option>
    										<option value="Human Resource Management">Human Resource Management</option>
    										<option value="Accounting and Finance ">Accounting and Finance </option>
    										
									</select>
		 						</div>
					 -->				<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
									<label for="emp_date" class="block"><font size="3" ><b>Date of	Inspection:</b></font></label>
									</div>
									 <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
										<input id="industrial_date" name="industrial_date"
												type="text" class="form-control "
													placeholder="select your Inspection Date" />
									</div>
									
									<!-- <label class="col-sm-3"><font size="4" >Types of Techniques:
						            </font></label>
							 <div class="col-sm-3">
								<select type="text" class="form-control"
										id="techniques" name="techniques"
											data-bv-notempty-message="Please enter Technique Type.">
											<option value="">---Select Techniques---</option>
											<option value="LandFill">LandFill</option>
											<option value="Incineration">Incineration</option>
											<option value="Deep Well Injection">Deep Well Injection</option>
									</select>
		 						</div> -->
							</div>
		 						

							</fieldset>
        <!-- <h3></h3>
        <fieldset>
            <legend>Waste Containers</legend>
            <div class="form-group row">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="name-2" class="block"><font size="4" >Shipping Name:</font> </label>
                                <input id="shipping_name" name="ehs_Shipping.shipping_name" type="text" class="form-control">
                                    </div>
                        <div class="col-sm-6">
                            <label for="text-2" class="block"><font size="4" >Waste Unit:</font></label>
                                <input id="waste_unit" name="ehs_Shipping.waste_unit" type="text" class="form-control">
                                    </div>
                                </div>
                            </div>
                        </div>
            
            <div class="form-group row">
                <div class="col-sm-12">
                    <label for="address-2" class="block"><font size="4" >Disposal Address:</font></label>
                </div>
                <div class="col-sm-12">
                    <input id="dis_address" name="ehs_Shipping.dis_address" type="text" class="form-control">
                </div>
            </div>
            
            	   <div class="row">
					    	<label class="col-sm-3"><font size="4" >Types of Containers:</font>
						   </label>
							 <div class="col-sm-3">
								<select type="text" class="form-control"
										id="containers" name="ehs_Shipping.containers"
											data-bv-notempty-message="Please enter Account Type.">
											<option value="">---Select Container---</option>
											<option value="solid">Solid waste Container</option>
											<option value="liquid">Liquid Waste Container</option>
											<option value="geseous">Gaseous Waste Container</option>
									</select>
		 						</div>
									<div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
									<label for="emp_date" class="block"><font size="4" >Date of	Shipment:</font></label>
									</div>
									 <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
										<input id="shipment_date" name="ehs_Shipping.shipment_date"
												type="text" class="form-control "
													placeholder="select your Shipment Date" />
									</div>
							</div><br><br>
							 <div class="form-group row">
                <div class="col-sm-12">
                    
                <div class="row">
               
               <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
                                <label for="emp_gender" class="block"><font size="4" >Generation:</font></label>
                            </div>
                            <div class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.generation" id="generation_1" value="1">
                                        <i class="helper"></i>Yes
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.generation" id="generation_2" value="2">
                                        <i class="helper"></i>No
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.generation" id="generation_3" value="3"/>
                                        <i class="helper"></i>Unknown
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
                                <label for="emp_gender" class="block"><font size="4" >Collection:</font></label>
                            </div>
                            <div class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.collection" id="collection_1" value="1">
                                        <i class="helper"></i>Yes
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.collection" id="collection_2" value="2">
                                        <i class="helper"></i>No
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.collection" id="collection_3" value="3"/>
                                        <i class="helper"></i>Unknown
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
                                <label for="emp_gender" class="block"><font size="4" >Storage:</font></label>
                            </div>
                            <div class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.storage" id="storage_1" value="1">
                                        <i class="helper"></i>Yes
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.storage" id="storage_2" value="2">
                                        <i class="helper"></i>No
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.storage" id="storage_3" value="3"/>
                                        <i class="helper"></i>Unknown
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
                                <label for="emp_gender" class="block"><font size="4" >Transportation:</font></label>
                            </div>
                            <div class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.transportation" id="transportation_1" value="1">
                                        <i class="helper"></i>Yes
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.transportation" id="transportation_2" value="2">
                                        <i class="helper"></i>No
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.transportation" id="transportation_3" value="3"/>
                                        <i class="helper"></i>Unknown
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
                                <label for="emp_gender" class="block"><font size="4" >Treatment:</font></label>
                            </div>
                            <div class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.treatment" id="treatment_1" value="1">
                                        <i class="helper"></i>Yes
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.treatment" id="treatment_2" value="2">
                                        <i class="helper"></i>No
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.treatment" id="treatment_3" value="3"/>
                                        <i class="helper"></i>Unknown
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                        <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
                                <label for="emp_gender" class="block"><font size="4" >Disposal:</font></label>
                            </div>
                            <div class="form-group form-radio col-sm-9 col-md-9 col-lg-9 col-xl-9">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.disposal" id="disposal_1" value="1">
                                        <i class="helper"></i>Yes
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.disposal" id="disposal_2" value="2">
                                        <i class="helper"></i>No
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="ehs_Shipping.disposal" id="disposal_3" value="3"/>
                                        <i class="helper"></i>Unknown
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
                       <div class="col-sm-6"> 
                    <label for="email-2" class="block">E-mail</label>
                    <input id="injured_email" name="ehs_Injured.injured_email" type="email" class="form-control">
                       </div>
                       <div class="col-sm-6">
                    <label for="phone-2" class="block">Phone-num</label>
                    <input id="injured_phone" name="ehs_Injured.injured_phone" type="Number" class="form-control">
                       </div>
                    </div>
                </div>
            </div>
      <legend>Witnessed</legend>
            <div class="form-group row">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-6">
                            <label for="name-2" class="block">Name *</label>
                                <input id="witness_name" name="witnesed_list[0].witness_name" type="text" class="form-control">
                                    </div>
                        <div class="col-sm-6">
                            <label for="text-2" class="block">Organizational Unit *</label>
                                <input id="witness_org_unit" name="witnesed_list[0].witness_org_unit" type="text" class="form-control">
                                    </div>
                                </div>
                            </div>
                        </div>
            <div class="form-group row">
                <div class="col-sm-12">
                    <div class="row">
                       <div class="col-sm-6"> 
                    <label for="email-2" class="block">E-mail</label>
                    <input id="witness_email" name="witnesed_list[0].witness_email" type="email" class="form-control">
                       </div>
                       <div class="col-sm-6">
                    <label for="phone-2" class="block">Phone-num</label>
                    <input id="witness_phone" name="witnesed_list[0].witness_phone" type="Number" class="form-control">
                       </div>
                    </div>
                </div>
            </div>

            
        </fieldset>
        <h3></h3>
        <fieldset>
            <div class="form-group row">
                <div class="col-sm-12">
		            <div class="row">
		                <div class="col-sm-6">
		                <legend>Address</legend>    
		       			 </div>
		   	 		</div>
				</div>
			</div>
    	<div class="form-group row">
                        <div class="col-sm-12">
                            <label for="comment" class="block"><font size="4" >Any other form of Handling:</font></label>
                        </div>
                        <div class="col-sm-12">
                            <textarea rows="4" cols="50" id="form_handling" name="ehs_Waste_Transport.form_handling " type="text" class=" form-control"></textarea>
                        
                        </div>
                    </div>
                        <div class="form-group row">
                <div class="col-sm-12">
                    <label for="address-2" class="block"><font size="4" >Address of the place of Treatment facility:</font></label>
                </div>
                <div class="col-sm-12">
                    <input id="treet_address" name="ehs_Waste_Transport.treet_address" type="text" class="form-control">
                </div>
            </div>
              <div class="form-group row">
                <div class="col-sm-12">
                    <label for="address-2" class="block"><font size="4" >Address of the place of Disposal facility:</font></label>
                </div>
                <div class="col-sm-12">
                    <input id="disposal_address" name="ehs_Waste_Transport.disposal_address" type="text" class="form-control">
                </div>
            </div>
            
            
        </fieldset>
        <h3></h3>
     +
        <fieldset>
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
                                                <div class="sub-title"><font size="4" >Document Name:</font></div>
                                                <input type="file" name="files" id="filer_input1" multiple="multiple">
                                            </div>
                                        </div>
                                        <div>
                                            
                                        </div>

         File upload card end
            
        </fieldset> 
        
 -->        </form>

</div>
</div>
</div>
</div>
</div>
</section>
                                        <!-- Design Wizard card end -->

<!---model for contact and address end-->




<!-- Date-range picker js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/advance-elements/moment-with-locales.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
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
                 url: '<%=contextPath%>/ehs/save_industrial',
                 type: 'POST',
                 dataType :"json",
                 complete: function() {}, 
                 success:  function (data) {
                 	if(data.status == 1) {
                 		location.href='<%=contextPath%>/ehs/mng_industrial_hygine_programs_list';
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

	  $('#industrial_date').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
       });
	  
	 /*  $('#shipment_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	       });
 */
	/*   $('#action_date').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
       });
	   */
	
});
</script>
<%
	
	Ehs_Waste waste=(Ehs_Waste)request.getAttribute("waste");
	String opr_mode=(String)request.getAttribute("opr_mode");
		if(opr_mode!=null&&waste!=null){
			if(opr_mode.equals("update")){
	%>	
		<script type="text/javascript">
			$(document).ready(function() {
					$('#chem_name').val('<%=waste.getChem_name()%>');
		        	$('#quantity').val('<%=waste.getQuantity()%>');
		        	$('#waste_desc').val('<%=waste.getWaste_desc()%>');
		        	$('#waste_department').val('<%=waste.getWaste_department()%>');
		       	 	$('#disposal_date').val('<%=waste.getDisposal_date()%>');
		        	$('#techniques').val('<%=waste.getTechniques()%>'); 
				 	
		        	$('#shipping_name').val('<%=waste.getEhs_Shipping().getShipping_name()%>'); 
			      	$('#waste_unit').val('<%=waste.getEhs_Shipping().getWaste_unit()%>');
			        $('#dis_address').val('<%=waste.getEhs_Shipping().getDis_address()%>');
			        $('#containers').val('<%=waste.getEhs_Shipping().getContainers()%>');
			        $('#shipment_date').val('<%=waste.getEhs_Shipping().getShipment_date()%>');
			    	if(<%=waste.getEhs_Shipping().getGeneration()%>==1){
						$('#generation_1').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getGeneration()%>==2){
						$('#generation_2').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getGeneration()%>==3){
						$('#generation_3').prop('checked', true);
					}	
					if(<%=waste.getEhs_Shipping().getCollection()%>==1){
						$('#collection_1').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getCollection()%>==2){
						$('#collection_2').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getCollection()%>==3){
						$('#collection_3').prop('checked', true);
					}
					
					if(<%=waste.getEhs_Shipping().getStorage()%>==1){
						$('#storage_1').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getStorage()%>==2){
						$('#storage_2').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getStorage()%>==3){
						$('#storage_3').prop('checked', true);
					}
					
					if(<%=waste.getEhs_Shipping().getTransportation()%>==1){
						$('#transportation_1').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getTransportation()%>==2){
						$('#transportation_2').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getTransportation()%>==3){
						$('#transportation_3').prop('checked', true);
					}
					
					if(<%=waste.getEhs_Shipping().getTreatment()%>==1){
						$('#treatment_1').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getTreatment()%>==2){
						$('#treatment_2').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getTreatment()%>==3){
						$('#treatment_3').prop('checked', true);
					}
					
					if(<%=waste.getEhs_Shipping().getDisposal()%>==1){
						$('#disposal_1').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getDisposal()%>==2){
						$('#disposal_2').prop('checked', true);
					}
					else if(<%=waste.getEhs_Shipping().getDisposal()%>==3){
						$('#disposalt_3').prop('checked', true);
					}
					
			        $('#form_handling').val('<%=waste.getEhs_Waste_Transport().getForm_handling()%>');
			     	$('#treet_address').val('<%=waste.getEhs_Waste_Transport().getTreet_address()%>');
				 	$('#disposal_address').val('<%=waste.getEhs_Waste_Transport().getDisposal_address()%>'); 
				});
		</script>
<% 			}else if(opr_mode.equals("view")){ %>
		
		<script type="text/javascript">
			$(document).ready(function() {
			  $('#chem_name').replaceWith($("<span>",{text:'<%=waste.getChem_name()%>'}));
			  $('#quantity').replaceWith($("<span>",{text:'<%=waste.getQuantity()%>'}));
				$('#waste_desc').replaceWith($("<span>",{text:'<%=waste.getWaste_desc()%>'}));
				$('#waste_department').replaceWith($("<span>",{text:'<%=waste.getWaste_department()%>'}));
				$('#disposal_date').replaceWith($("<span>",{text:'<%=waste.getDisposal_date()%>'}));
				$('#techniques').replaceWith($("<span>",{text:"<%=waste.getTechniques()%>"})); 
				
				$('#shipping_name').replaceWith($("<span>",{text:'<%=waste.getEhs_Shipping().getShipping_name()%>'}));
				$('#waste_unit').replaceWith($("<span>",{text:'<%=waste.getEhs_Shipping().getWaste_unit()%>'}));
				$('#dis_address').replaceWith($("<span>",{text:'<%=waste.getEhs_Shipping().getDis_address()%>'}));
				$('#containers').replaceWith($("<span>",{text:'<%=waste.getEhs_Shipping().getContainers()%>'}));
				
				$('#shipment_date').replaceWith($("<span>",{text:'<%=waste.getEhs_Shipping().getShipment_date()%>'}));
				
				if(<%=waste.getEhs_Shipping().getGeneration()%>==1){
					$('#generation_1').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getGeneration()%>==2){
					$('#generation_2').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getGeneration()%>==3){
					$('#generation_3').prop('checked', true);
				}	
				if(<%=waste.getEhs_Shipping().getCollection()%>==1){
					$('#collection_1').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getCollection()%>==2){
					$('#collection_2').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getCollection()%>==3){
					$('#collection_3').prop('checked', true);
				}
				
				if(<%=waste.getEhs_Shipping().getStorage()%>==1){
					$('#storage_1').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getStorage()%>==2){
					$('#storage_2').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getStorage()%>==3){
					$('#storage_3').prop('checked', true);
				}
				
				if(<%=waste.getEhs_Shipping().getTransportation()%>==1){
					$('#transportation_1').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getTransportation()%>==2){
					$('#transportation_2').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getTransportation()%>==3){
					$('#transportation_3').prop('checked', true);
				}
				
				if(<%=waste.getEhs_Shipping().getTreatment()%>==1){
					$('#treatment_1').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getTreatment()%>==2){
					$('#treatment_2').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getTreatment()%>==3){
					$('#treatment_3').prop('checked', true);
				}
				
				if(<%=waste.getEhs_Shipping().getDisposal()%>==1){
					$('#disposal_1').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getDisposal()%>==2){
					$('#disposal_2').prop('checked', true);
				}
				else if(<%=waste.getEhs_Shipping().getDisposal()%>==3){
					$('#disposalt_3').prop('checked', true);
				}
				$('#form_handling').replaceWith($("<span>",{text:'<%=waste.getEhs_Waste_Transport().getForm_handling()%>'}));
				$('#treet_address').replaceWith($("<span>",{text:'<%=waste.getEhs_Waste_Transport().getTreet_address()%>'}));
				$('#disposal_address').replaceWith($("<span>",{text:"<%=waste.getEhs_Waste_Transport().getDisposal_address()%>"}));
			 
			});
							
		</script>
		
		
		<%			}
			
		}
%>








