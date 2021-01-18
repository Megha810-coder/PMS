<%@page import="com.spcl.erp.model.Ehs_Product"%>
<%@page import="com.spcl.erp.model.Ehs_Safety"%>
<%@page import="com.spcl.erp.model.Ehs_Pack"%>
<%@page import="java.util.List"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

	String contextPath = request.getContextPath();
    String manufacturing_date=(String)request.getAttribute("manufacturing_date");
    String expiry_date=(String)request.getAttribute("expiry_date");
    String packeging_date=(String)request.getAttribute("packeging_date");
    String delivery_date=(String)request.getAttribute("delivery_date");
    String del_date=(String)request.getAttribute("del_date");
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
					<h4>PRODUCT MANAGEMENT</h4>
					<!-- <span>MSDS</span> -->
				</div>
			</div>
		</div>
		
		<!-- <div class="col-lg-4">
			<div class="page-header-breadcrumb">
				<ul class="breadcrumb-title">
					<li class="breadcrumb-item"><a href="index.html"> <i
							class="feather icon-home"></i>
					</a></li>
					<li class="breadcrumb-item"><a href="#!">Invoice</a></li>
					<li class="breadcrumb-item"><a href="#!">New</a></li>
				</ul>
			</div>
		</div> -->
	</div>
</div>
<div align="center">
<button rel="<%=contextPath %>/ehs/back_product" id="back_product" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button>

  <button onclick="myFunction()" id="print" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
<!-- Page-header end --></div>
<script>
$(document).ready(function(){
  $('#print').hide();
  
});
</script>

<!-- Page body start -->
<!-- Design Wizard card start -->
<section>
<div class="card">
	<div class="card-header">
	<h3>${opr_mode=="save"?"":""}</h3>
		<!-- <h5>Design Wizard</h5>
<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span> -->

	</div>
	
	
		<div class="card-block">
			<div class="row">
				<div class="col-md-12">
					<div id="wizard3">

						<form class="wizard-form" id="product" action="<%=contextPath%>/ehs/save_product" method="post"  modelAttribute="products">
						
						<input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
<input type=hidden class="form-control" id="product_id" name="product_id" value="${products.product_id}" />
 	<input type=hidden class="form-control" id="safety_id" name="ehs_Safety.safety_id" value="${products.ehs_Safety.safety_id}" />
<input type=hidden class="form-control" id="pack_id" name="ehs_Pack.pack_id" value="${products.ehs_Pack.pack_id}" /> 
<input type=hidden class="form-control" id="vehicle_id" name="ehs_Vehicle.vehicle_id" value="${products.ehs_Vehicle.vehicle_id}" />
						 
							<h3><span>Product Details</span></h3>
							<fieldset>
								<legend>A)Product Details:-</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1.Name:-</b></font> </label> <input
													id="product_name" name="product_name" type="text"
													class="form-control">
											</div>
											
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>2.Code:-</b> </font></label> <input
													id="prod_code" name="prod_code" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>

                    <div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>3.Type:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="type_of_product" name="type_of_product" type="text"
											class="form-control">
									</div>
								</div>
								<!-- <div class="form-group row">
									 <div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>Formula:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="formula" name="formula" type="text"
											class="form-control">
									</div>
								</div> -->
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											

											<div class="col-sm-6">
												<label for="emp_date" class="block"><font size="3" ><b>4.Manufacturing Date:-</b></font></label> <input
													id="manufacturing_date" name="manufacturing_date" type="text"
													class="form-control" placeholder="select your Treatment Date" value="12/24/2018"/>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											

											<div class="col-sm-6">
												<label for="emp_date" class="block"><font size="3" ><b>5.Expiry Date:-</b></font></label> <input
													id="expiry_date" name="expiry_date" type="text"
													class="form-control" placeholder="select your Treatment Date" value="12/21/2027" />
											</div>
										</div>
									</div>
								</div>
								
							
							</fieldset>
							<h3><span>Process Of Safety</span></h3>
							<fieldset>
								<legend>B)Process Of Safety:- </legend>

								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1.Hazard Of Chemical Used In Process:-</b></font></label>
												<textarea rows="3" cols="50" id="chemical_used" name="ehs_Safety.chemical_used"
													type="text" class=" form-control"></textarea>
											</div>
											
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											
											<div class="col-sm-6">
											
												<label for="text-2" class="block"><font size="3" ><b>2.Technology Of Process:-</b></font></label>
												<textarea rows="3" cols="50" id="technology_used" name="ehs_Safety.technology_used"
													type="text" class=" form-control"></textarea>
											</div>
										</div>
									</div>
								</div>


								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>3.Equipment Of Process:-</b></font></label>
												<textarea rows="3" cols="50" id="equipment_used" name="ehs_Safety.equipment_used"
													type="text" class=" form-control"></textarea>
											</div>
											
										</div>
									</div>
								</div>
										
							</fieldset>

							<h3><span>Packaging</span></h3>
							<fieldset>
							<legend>C)Packaging:-</legend>

								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
									<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1.Type:-</b></font> </label> <input
													id="packeging_type" name="ehs_Pack.packeging_type" type="text"
													class="form-control">
											</div>
									</div>
								</div>
							</div>
		
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>2.Method:-</b></font></label>
												<textarea rows="3" cols="50" id="packeging_method" name="ehs_Pack.packeging_method"
													type="text" class=" form-control"></textarea>
											</div>
											
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>3.Way To Handle:-</b></font></label>
												<textarea rows="3" cols="50" id="way_to_handle" name="ehs_Pack.way_to_handle"
													type="text" class=" form-control"></textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
										<div class="col-sm-4">
							                   	 <label for="emp_date" class="block"><font size="3" ><b>4.Packaging Date:-</b></font></label>
							                   	 <input id="packeging_date" name="ehs_Pack.packeging_date" type="text" class="form-control " placeholder="select your Treatment Date"/>
							              		</div>
										</div>
									</div>
								</div>
										<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
										<div class="col-sm-4">
							                   	 <label for="emp_date" class="block"><font size="3" ><b>5.Delivery Date:-</b></font></label>
							                   	 <input id="delivery_date" name="ehs_Pack.delivery_date" type="text" class="form-control " placeholder="select your delivery Date"/>
							              		</div>
										</div>
									</div>
								</div>
								</fieldset>
								
									<h3><span>Vehicle Details</span></h3>
							<fieldset>
								<legend>D)Vehicle Details:-</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1.Name:-</b></font> </label> <input
													id="vehicle_name" name="ehs_Vehicle.vehicle_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>2.No:- </b></font></label> <input
													id="vehicle_no" name="ehs_Vehicle.vehicle_no" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								

                    			<div class="form-group row">
										<div class="col-sm-6">
												<label for="emp_date" class="block"><font size="3" ><b>3.Delivery Date:-</b></font></label> <input
													id="del_date" name="ehs_Vehicle.del_date" type="text"
													class="form-control" placeholder="select your Delivery Date" />
											</div>
								
								</div>
							<brt><br>
								<legend>E)Supplier Details:-</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1.Name:-</b></font> </label> <input
													id="suplier_name" name="ehs_Vehicle.suplier_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>2.Phone No:- </b></font></label> <input
													id="suplier_no" name="ehs_Vehicle.suplier_no" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-12">
										<label for="address-2" class="block"><font size="3" ><b>3.Address:-</b></font></label>
									</div>
									<div class="col-sm-12">
										<input id="suplier_address" name="ehs_Vehicle.suplier_address" type="text"
											class="form-control">
									</div>
								</div>
								
								<br><br>
								<legend>F)Vehicle Driver Details:-</legend>
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-6">
												<label for="name-2" class="block"><font size="3" ><b>1.Name:-</b></font> </label> <input
													id="driver_name" name="ehs_Vehicle.driver_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-6">
												<label for="text-2" class="block"><font size="3" ><b>2.Phone No:-</b> </font></label> <input
													id="driver_no" name="ehs_Vehicle.driver_no" type="text" class="form-control">
											</div>
										</div>
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
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/moment/js/moment.min.js"></script>
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
	
	var form = $("#product").show();
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
            var form = new FormData($('#product')[0]);
  			$.ajax({
                 url: '<%=contextPath%>/ehs/save_product',
                 type: 'POST',
                 dataType :"json",
                 complete: function() {}, 
                 success:  function (data) {
                 	if(data.status == 1) {
                 		location.href='<%=contextPath%>/ehs/mng_product';
                     } else if(data.status == 0) { 
                     	$('#file_error').append(data.error).show();
                         $("#submit-btn").prop("disabled",false);
                     }
                 },
                 error: function(xhr, textStatus, thrownError) {
                 	console.log("ERROR: ", thrownError);
                     alert("MeghaSomthing went wrong....");
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
     $('#manufacturing_date').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
       });
    
		$('#expiry_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	       }); 
		$('#packeging_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	       });
		$('#delivery_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	       });
		$('#del_date').daterangepicker({
	        singleDatePicker: true,
	        showDropdowns: true
	       });
		$('#back_product').on('click', function() {
	           var loc=$(this).attr('rel');
	           location.href=loc;
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

<%
	
         Ehs_Product products=(Ehs_Product)request.getAttribute("products");
	     String opr_mode=(String)request.getAttribute("opr_mode");
		   if(opr_mode!=null&&products!=null){
		    	if(opr_mode.equals("update")){
	%>	
		<script type="text/javascript">
			$(document).ready(function() {
				
				
				$('#product_name').val('<%=products.getProduct_name()%>');
	        	$('#prod_code').val('<%=products.getProd_code()%>');
	        	$('#type_of_product').val('<%=products.getType_of_product()%>');
	        	$('#formula').val('<%=products.getFormula()%>');
	        	$('#manufacturing_date').val('${manufacturing_date}');
	        	$('#expiry_date').val('${expiry_date}');
	       		$('#chemical_used').val('<%=products.getEhs_Safety().getChemical_used()%>'); 
	       		$('#technology_used').val('<%=products.getEhs_Safety().getTechnology_used()%>'); 
	       		$('#equipment_used').val('<%=products.getEhs_Safety().getEquipment_used()%>'); 
	       		
	       		$('#packeging_type').val('<%=products.getEhs_Pack().getPackeging_type()%>'); 
	       		$('#packeging_method').val('<%=products.getEhs_Pack().getPackeging_method()%>'); 
	       		$('#way_to_handle').val('<%=products.getEhs_Pack().getWay_to_handle()%>'); 
	        	$('#packeging_date').val('${packeging_date}');
	        	$('#delivery_date').val('${delivery_date}');

	       		<%-- $('#packeging_date').val('<%=products.getEhs_Pack().getPackeging_date()%>'); 
	       		$('#delivery_date').val('<%=products.getEhs_Pack().getDelivery_date()%>');  --%>
	       		
	       		$('#vehicle_name').val('<%=products.getEhs_Vehicle().getVehicle_name()%>'); 
	       		$('#vehicle_no').val('<%=products.getEhs_Vehicle().getVehicle_no()%>'); 
	       		$('#del_date').val('${del_date}');
	       		<%-- $('#del_date').val('<%=products.getEhs_Vehicle().getDel_date()%>');  --%>
	       		$('#suplier_name').val('<%=products.getEhs_Vehicle().getSuplier_name()%>'); 
	       		$('#suplier_no').val('<%=products.getEhs_Vehicle().getSuplier_no()%>'); 
	       		$('#suplier_address').val('<%=products.getEhs_Vehicle().getSuplier_address()%>'); 
	       		$('#driver_name').val('<%=products.getEhs_Vehicle().getDriver_name()%>'); 
	       		$('#driver_no').val('<%=products.getEhs_Vehicle().getDriver_no()%>'); 
				});
		</script>
<% 			}else if(opr_mode.equals("view")){ %>

	<!-- <div align="center">

  <button onclick="myFunction()" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
  </div>
   <script>
function myFunction() {
  window.print();
  $('#print').show();
}
</script>  -->
<script>
$(document).ready(function(){
	$('#print').on('click',function(){
  $('#print').show();
  window.print();
	});
});
</script>
		<script type="text/javascript">
			$(document).ready(function() {
				 $('#print').show(); 
				  
				  $('#product_name').replaceWith($("<span>",{text:'<%=products.getProduct_name()%>'}));
				  $('#prod_code').replaceWith($("<span>",{text:'<%=products.getProd_code()%>'}));
				  $('#type_of_product').replaceWith($("<span>",{text:'<%=products.getType_of_product()%>'}));
				  $('#formula').replaceWith($("<span>",{text:'<%=products.getFormula()%>'}));
				  $('#manufacturing_date').replaceWith($("<span>",{text:'<%=products.getManufacturing_date()%>'}));
				  $('#expiry_date').replaceWith($("<span>",{text:'<%=products.getExpiry_date()%>'}));
					
				  $('#chemical_used').replaceWith($("<span>",{text:'<%=products.getEhs_Safety().getChemical_used()%>'}));
					$('#technology_used').replaceWith($("<span>",{text:'<%=products.getEhs_Safety().getTechnology_used()%>'}));
					$('#equipment_used').replaceWith($("<span>",{text:'<%=products.getEhs_Safety().getEquipment_used()%>'}));
					
					$('#packeging_type').replaceWith($("<span>",{text:'<%=products.getEhs_Pack().getPackeging_type()%>'}));
					$('#packeging_method').replaceWith($("<span>",{text:'<%=products.getEhs_Pack().getPackeging_method()%>'}));
					$('#way_to_handle').replaceWith($("<span>",{text:'<%=products.getEhs_Pack().getWay_to_handle()%>'}));
					$('#packeging_date').replaceWith($("<span>",{text:'<%=products.getEhs_Pack().getPackeging_date()%>'}));
				    $('#delivery_date').replaceWith($("<span>",{text:'<%=products.getEhs_Pack().getDelivery_date()%>'}));
				    
				    $('#vehicle_name').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getVehicle_name()%>'}));
					$('#vehicle_no').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getVehicle_no()%>'}));
					$('#del_date').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getDel_date()%>'}));
					$('#suplier_name').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getSuplier_name()%>'}));
					$('#suplier_no').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getSuplier_no()%>'}));
					$('#suplier_address').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getSuplier_address()%>'}));
					$('#driver_name').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getDriver_name()%>'}));
				    $('#driver_no').replaceWith($("<span>",{text:'<%=products.getEhs_Vehicle().getDriver_no()%>'}));
			});
							
		</script>
		
		
		<%			}
			
		}
%>







