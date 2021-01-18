<%-- <%@page import="com.spcl.erp.model.Bank"%>
<%@page import="java.util.List"%> --%>
 <%@page import="com.spcl.erp.model.Ehs_Factory_Act"%>
<%@page import="com.spcl.erp.model.Osha_Law"%>
<%@page import="com.spcl.erp.model.Ehs_Training"%>

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
            <h4>INDUSTRIAL HYIGENE AND SAFETY MANAGEMENT </h4>
            <!-- <span>Report Industrial Hygiene and safety Management</span> -->
        </div>
    </div>
</div>
<!-- <div class="col-lg-4" >
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
<div class="col-md-12" style="background-color:#f3f3f3">
<div id="wizard3">
    <form class="wizard-form" id="design-wizard" action="factory">
        <h3></h3>
           <%	Ehs_Factory_Act factory=(Ehs_Factory_Act)request.getAttribute("factory");
				String value=(String)request.getAttribute("value");

				if(factory!=null){
			
		  %>
		  
							<br>
							<center><font size="5"><u><i><font color="TEAL">FACTORY ACT</font></i></u></font></center>
							<br>
							<br>
							<div class="form-group row">
							<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12" align="center">
											<!-- <label for="name-2" class="block"><font size="4"><b>Title
											: </b> </font> </label><br> --> 
											<font size="4"><%=factory.getFactory_name()%></font>
										</div>
									</div>
								</div>
							</div>
							<br>
							<br>
							
							<div>
							<div class="col-sm-12" align="center">
							<!-- <label for="name-2" class="block"><font size="4"><b> FACT :</b></font></label> -->
							<br><i><blackqoute><font size="2"><%=factory.getFactory_fact()%></font></blackqoute></i>
							</div>
							</div>
							<br>
							<br>
							<div>
							<div class="col-sm-12" align="justify">
							<label for="name-2" class="block"><font size="4"><b> FACTORY ACT DESCRIPATION :</b></font></label>
							<br> <font size="3"><%=factory.getFactory_des() %></font>
							</div>
							</div>
							<br>
							<br>
							<div class="col-sm-12" align="left" >
							<label for="name-2" class="block"><font size="2"><b> DATE :</b></font></label>
							<br> <font size="2"><%=factory.getFactory_date()%></font>
							</div>
							</div>
							<br>
							<br>
							
							<!-- <div class="col-sm-12" align="center">
							

				<p><b><font size="3">U.S. Department of Labor Renews Alliance with Toledo Electrical Joint</br>
						Apprenticeship Training Committee to Improve Workplace Safety </font></b></p>
							</div><br><br> -->
							
							<!-- <div class="col-sm-12">
							<i> <p> <font size="2"> "The Occupational Safety and Health Act requires employers to comply with safety and health standards and regulations promulgated by OSHA or by a state with an OSHA-approved state plan."</font> </p></i>
							</div>
								<div class="col-sm-12">
									<div class="row">
										<div class="col-sm-12"  >
										<p> <font size="3">1)<b>TOLEDO, OH:</b> The U.S. Department of Labors Occupational Safety and Health Administration (OSHA) has renewed an alliance with the Toledo Electrical Joint Apprenticeship Training Committee (JATC) to address safety and health hazards that Ohios apprentice and journey person electricians may encounter while working in construction and general industry.</font></P>
										</div><br><br>
										<div class="col-sm-12"  >
										<p>	<font size="3">2)The five-year alliance will focus on developing effective training and 
											   education programs regarding electrical safety and arc flash hazards, wind tower safety, photo-voltaic cell installation and maintenance safety, rigging, fall protection, and cave-in protection.</font></p>
										</div><br><br>
										<div class="col-sm-12"  >
											<p ><font size="3">3)Under the Occupational Safety and Health Act of 1970, employers are responsible
											   for providing safe and healthful workplaces for their employees. OSHA role is to help ensure these conditions for Americas working men and women by setting and enforcing standards, and providing training, education, and assistance. </font></p>
										</div><br><br>
										<div class="col-sm-12 ">
										<p> <font size="3">4)The OSHA Alliance Program fosters collaborative relationships with groups committed to worker safety and health. Alliance partners help OSHA reach targeted audiences, such as employers and workers in high-hazard industries, giving them better access to workplace safety and health tools and information.</font></p>
										</div> -->
										 <div class="row">
                                          
									</div> 
									</div>
								</div>
							</div>
							<br>
							<br>
							
							
		<%		}%>
                
                <fieldset>
              
                  
      </form>
	
</div>

							<%-- <div class="row text-center">
                              <div class="col-sm-12 invoice-btn-group text-center">
                                 <button rel="<%=contextPath %>/ehs/edit_factory_law" id="btn-edit" type="button" class="btn btn-danger m-b-10 btn-sm waves-effect waves-light m-r-20">Edit</button>
                              </div>
                          </div> --%>
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


