 <%@page import="com.spcl.erp.model.Ehs_Industrial"%>
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
            <h4>INDUSTRIAL HYGIENE AND SAFETY</h4>
            <!-- <span>Report Industrial Hygiene And Safety Management</span> -->
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
<div align="center">
<button rel="<%=contextPath %>/ehs/back_industrial_list" id="back_industrial_list" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Back</span></button>
<button  rel="<%=contextPath %>" id="print" type="button" class="btn btn-sm btn-success btn-new-tickets waves-effect waves-light m-r-15 m-b-5 m-t-5"><i class="icofont icofont-paper-plane"></i><span class="m-l-10">Print</span></button>
</div>
<!-- Page-header end -->




<!-- Page body start -->
<!-- Design Wizard card start -->
<div class="card">
<div class="card-header">
<h3>${opr_mode=="save"?"  ":""}</h3>
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
						
        <h3><span>Industrial Programs Aspects</span></h3>
                <fieldset>
								<!-- <legend>Inspection Programs Asp</legend> -->
								<div class="form-group row">
									<div class="col-sm-12">
										<div class="row">
											<div class="col-sm-12">
												<label for="name-2" class="block"><font size="3" ><b> 1)Programs Name:</b></font> </label> <input
													id="industrial_name" name="industrial_name" type="text"
													class="form-control">
											</div>
											<div class="col-sm-12">
												<label for="text-2" class="block"><font size="3" ><b>2)Aspect:</b> </font></label> <input
													id="industrial_aspect" name="industrial_aspect" type="text" class="form-control">
											</div>
										</div>
									</div>
								</div>
								
								
									<div class="form-group row">
									<div class="col-sm-12">
										<label for="text-2" class="block"><font size="3" align="justify"><b>3)Program Details:</b></font></label>
									</div>
									<div class="col-sm-12">
										<textarea rows="4" cols="50" id="industrial_des" name="industrial_des"
													type="text" class=" form-control"></textarea>
								    	</div>
								   </div>
								   
					
					 			<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
									<label for="emp_date" class="block"><font size="3" ><b>4)Date:</b></font></label>
									</div>
									<div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
										<input id="industrial_date" name="industrial_date"
												type="text" class="form-control "
													placeholder="select your Inspection Date" />
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
	  
	  $('#back_industrial_list').on('click', function() {
          var loc=$(this).attr('rel');
          location.href=loc;
		});
	  $('#print').on('click',function(){
			 window.print();
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
	
	Ehs_Industrial industrial=(Ehs_Industrial)request.getAttribute("industrial");
	String opr_mode=(String)request.getAttribute("opr_mode");
		if(opr_mode!=null&&industrial!=null){
			
       if(opr_mode.equals("view")){ %>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#print').show();
			  $('#industrial_name').replaceWith($("<span>",{text:'<%=industrial.getIndustrial_name()%>'}));
			  $('#industrial_aspect').replaceWith($("<span>",{text:'<%=industrial.getIndustrial_aspect()%>'}));
				$('#industrial_des').replaceWith($("<span>",{text:'<%=industrial.getIndustrial_des()%>'}));
				$('#industrial_date').replaceWith($("<span>",{text:'<%=industrial.getIndustrial_date()%>'}));
				
			});
		</script>
		<%			} }   %>








