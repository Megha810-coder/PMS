 <%@page import="com.spcl.erp.model.Ehs_Training"%>
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
            <h4>OCCUPATIONAL SAFETY TRANING</h4>
           <!--  <span>Report Occupational Management</span> -->
           
        </div>
    </div>
</div>


<!-- <div class="col-lg-4">
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
</div> -->
</div>
</div>
<div class=" waves-effect waves-light m-r-10 v-middle issue-btn-group">
		  <button rel="<%=contextPath %>/ehs/back_occupational_list" id="back_occupational_list" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button>
		<button  rel="<%=contextPath %>" id="print" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
		
</div>

<%-- <button rel="<%=contextPath %>/ehs/mng_occupational_programs_list" id="mng_occupational_programs_list" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button> --%>
<%-- <button rel="<%=contextPath %>/ehs/back_occupational_list" id="back_occupational_list" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button> --%>

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

    <form class="wizard-form" id="inc-design-wizard" action="<%=contextPath%>/ehs/save_occupational" method="post"  modelAttribute="occupational">
    
    <input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
	<input type=hidden class="form-control" id="training_id" name="training_id" value="${training.training_id}" />
	<%-- <input type=hidden class="form-control" id="shipping_id" name="ehs_Shipping.shipping_id" value="${waste.ehs_Shipping.shipping_id}" />
	<input type=hidden class="form-control" id="trans_id" name="ehs_Waste_Transport.trans_id" value="${waste.ehs_Waste_Transport.trans_id}" /> --%>
						
     <h3><span>Occupational Training Programs Aspects</span></h3>
     <fieldset>
								<!-- <legend>Training Programs Aspects</legend> -->
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-12">
												<label for="name-2" class="block"><font size="3" ><b>1) Training Name:</b></font> </label> <input
													id="training_name" name="training_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-12">
												<label for="text-2" class="block"><font size="3" ><b>2) Aspect:</b> </font></label> <input
													id="training_aspect" name="training_aspect" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								
								
								
									<div class="form-group row">
									<div class="col-sm-12">
										<label for="text-2" class="block"><font size="3" ><b>3) Training Details</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea rows="4" cols="50" id="training_des" name="training_des"
													type="text" class=" form-control"></textarea>
								    	</div>
								   </div>
								   
								 <div class="col-sm-12">
												<label for="text-2" class="block"><font size="3" ><b>4) Training Rating:</b> </font></label> <input
													id="training_rat" name="training_rat" type="text" class="form-control">
											</div>
										
								
								
								
								<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
									<label for="emp_date" class="block"><font size="3" ><b>5) Date</b></font></label>
									</div>
									 <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
										<input id="training_date" name="training_date"
												type="text" class="form-control "
													placeholder="select your Treatment Date" />
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
                 url: '<%=contextPath%>/ehs/save_occupational',
                 type: 'POST',
                 dataType :"json",
                 complete: function() {}, 
                 success:  function (data) {
                 	if(data.status == 1) {
                 		location.href='<%=contextPath%>/ehs/mng_occupational_programs_list';
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

	  $('#training_date').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
       });
	  $('#back_occupational_list').on('click', function() {
          var loc=$(this).attr('rel');
          location.href=loc;
		});
	  
	 	 
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
	  
	 /*  $('#back_occupational_list').on('click', function(){
		  window.print();
	  }); */
	  
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
	
	Ehs_Training training=(Ehs_Training)request.getAttribute("training");
	String opr_mode=(String)request.getAttribute("opr_mode");
		if(opr_mode!=null&&training!=null){
			
       if(opr_mode.equals("view")){ %>
		
		<script type="text/javascript">
			$(document).ready(function() {
			$('#print').show();
			  $('#training_name').replaceWith($("<span>",{text:'<%=training.getTraining_name()%>'}));
			  $('#training_aspect').replaceWith($("<span>",{text:'<%=training.getTraining_aspect()%>'}));
				$('#training_des').replaceWith($("<span>",{text:'<%=training.getTraining_des()%>'}));
				$('#training_rat').replaceWith($("<span>",{text:'<%=training.getTraining_rat()%>'}));
				$('#training_date').replaceWith($("<span>",{text:'<%=training.getTraining_date()%>'}));
				
			});
			function myFunction() {

				document.getElementById("admitted").innerHTML = "Please submite form Number 24 to factory Inspection Office.";	
				 $('#admitted').show();

			 }
			 function myFunctionhide(){
				 $('#admitted').hide();
			 }
			
		</script>
		<%			} }   %>