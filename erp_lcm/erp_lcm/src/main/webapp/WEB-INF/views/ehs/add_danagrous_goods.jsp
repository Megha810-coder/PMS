<%-- <%@page import="com.spcl.erp.model.Bank"%>
<%@page import="java.util.List"%> --%>
<%@page import="com.spcl.erp.model.Hazardous_Chemicals"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String contextPath = request.getContextPath();
%>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

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

	/*  #page_body {
	background-color:#f3f3f3;
	} 
 */
    #design-wizard .steps li{
        width: 20%;
    }
    #design-wizard .steps li a{
        width: 40%;
    }
.checkbox-zoom label input[type="checkbox"], .checkbox-zoom label input[type="radio"] {

    display: none;

}
#design-wizard .steps li{
position:none;
z-index:unset;
}

.wizard > .steps a,
.wizard > .steps a:hover,
.wizard > .steps a:active
{
    display: none;
    width: auto;
    margin: 0 0.5em 0.5em;
    padding: 1em 1em;
    text-decoration: none;

    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
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
.wizard > .actions .disabled a,
.wizard > .actions .disabled a:hover,
.wizard > .actions .disabled a:disabled
{
    background:none;
    color: none;
}

.wizard > .actions a,
.wizard > .actions a:hover,
.wizard > .actions a:disabled
{
    background: none;
    color: none;
    display: none;
    padding: none;
    text-decoration: none;

    -webkit-border-radius: none;
    -moz-border-radius: none;
    border-radius: none;
}


</style>
<!-- Page-header start -->
<div class="page-header">
<div class="row align-items-end" style="Font-Size:48px">
<div class="col-lg-8"  >
    <div class="page-header-title">
        <div class="d-inline" >
            <h4>Dangerous Goods Management </h4>
            <span>Report Dangerous Goods Management</span>
        </div>
    </div>
</div>
<div class="col-lg-4" >
    <div class="page-header-breadcrumb">
        <ul class="breadcrumb-title">
            <li class="breadcrumb-item">
                <a href="index.html"> <i class="feather icon-home"></i> </a>
             </li>
            <!-- <li class="breadcrumb-item"><a href="#!">Invoice</a>
            </li>
             <li class="breadcrumb-item"><a href="#!">New</a>
            </li>  -->
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

<!-- <h5>Design Wizard</h5>
<span>Add class of <code>.form-control</code> with <code>&lt;input&gt;</code> tag</span> -->

</div>
<section>
<div class="card-block">
<div class="row">
<div class="col-md-12">
<div id="wizard3">
    <form class="wizard-form" id="design-wizard" action="#">
        <h3></h3>
          <%	Hazardous_Chemicals hazard=(Hazardous_Chemicals)request.getAttribute("hazard");
				String value=(String)request.getAttribute("value");

				if(value!=null&&hazard!=null){
				if(value.equals("impact")){
					
			
		  %>
							<br>
							<center><font size="5"><u><i><font color="TEAL">IMPACTS</font></i></u></font></center>
							<br>
							<br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>SKIN
											CONTACT : </b> </font> </label><br> <font size="4"><%=hazard.getIdentification().getSkin_contact()%></font>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>EYE
											CONTACT :</b></font> </label><br> <font size="4"><%=hazard.getIdentification().getEye_contact()%></font>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
											INHALATION  :</b></font> </label><br> <font size="4"><%=hazard.getIdentification().getInhalation()%></font>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
											INGESTION    :</b></font> </label><br> <font size="4"><%=hazard.getIdentification().getIngestion()%></font>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
											TOXIC EFFECT :</b></font> </label><br> <font size="4"><%=hazard.getIdentification().getToxic_effect()%></font>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
		<%		}
		 else if(value.equals("risk")){ %>
							 <br>
							 <center><font size="5"><u><i><font color="TEAL">RISKS</font></i></u></font></center>
							 <br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
										    RISK ASSESSMENT :</b></font> </label><br>
										      <font size="4">1)<%=hazard.getIdentification().getRA1()%></font>
										      <font size="4">2)<%=hazard.getIdentification().getRA2()%></font>
										      <font size="4">3)<%=hazard.getIdentification().getRA3()%></font>
										      <font size="4">4)<%=hazard.getIdentification().getRA4()%></font>
										      <font size="4">5)<%=hazard.getIdentification().getRA5()%></font>
										</div>
									</div>
								</div>
							</div>
							 <br>
							 <br>

							<%} else if(value.equals("safety")){ %>
							 <br>
							<center><font size="5"><u><i><font color="TEAL">SAFETY</font></i></u></font></center>
							<br>
							<br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>SKIN
											CONTACT :</b></font> </label><br> <font size="4"><%=hazard.getFirst_aid().getSkin_contacts()%></font>
										</div>
									</div>
								</div>
							</div>
							 <br>
							 <br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>EYE
											CONTACT :</b></font> </label><br> <font size="4"><%=hazard.getFirst_aid().getEye_contacts()%></font>
										</div>
									</div>
								</div>
							</div>
							 <br>
							 <br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
											INHALATION  :</b></font> </label><br> <font size="4"><%=hazard.getFirst_aid().getInhalations()%></font>
										</div>
									</div>
								</div>
							</div>
							 <br>
							 <br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
											INGESTION    :</b></font> </label><br> <font size="4"><%=hazard.getFirst_aid().getIngestions()%></font>
										</div>
									</div>
								</div>
							</div>
							 <br>
							 <br>
							<div class="form-group row">
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12">
											<label for="name-2" class="block"><font size="4"><b>
											TOXIC EFFECT :</b></font> </label><br> <font size="4"><%=hazard.getFirst_aid().getOther()%></font>
										</div>
									</div>
								</div>
							</div>
							 <br>
							 <br>
		<%} }%>
                
                <fieldset>
              
                  
      </form>
	
</div>

							<div class="row text-center">
                              <div class="col-sm-12 invoice-btn-group text-center">
                                 <button rel="<%=contextPath %>/ehs/mng_danagrous_goods_list" id="btn-cancel" type="button" class="btn btn-danger m-b-10 btn-sm waves-effect waves-light m-r-20">Cancel</button>
                              </div>
                          </div>
</div>
</div>
</div>
</div>
</section>
<!-- Design Wizard card end -->

<!---model for contact and address end-->




<!-- Date-range picker js -->
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
<script type="text/javascript">

	$(document).ready(function(){
		$('#btn-cancel').on('click', function() {
	            var loc=$(this).attr('rel');
	            location.href=loc;
	 		});
	});

</script>


