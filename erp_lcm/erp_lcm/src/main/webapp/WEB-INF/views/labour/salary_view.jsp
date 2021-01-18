<%@page import="com.spcl.erp.model.LabourCheck,com.spcl.erp.model.Labour"%>
<%@page import="com.spcl.erp.services.LabourService, java.util.*"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String contextPath = request.getContextPath();
	 Helper helper = (Helper)request.getAttribute("helper");
	 LabourService labourService=(LabourService)request.getAttribute("labourService"); 
	 Labour labour=(Labour)request.getAttribute("labour"); 
	 Integer halfDay=(Integer)request.getAttribute("halfDay");
	 Integer fullDay=(Integer)request.getAttribute("fullDay");
	 Integer salary=(Integer)request.getAttribute("salary");
	 Integer fullSalary=(Integer)request.getAttribute("fullSalary");
	 Integer halfSalary=(Integer)request.getAttribute("halfSalary");
	 Integer total_salary_addtion=(Integer)request.getAttribute("total_salary_addtion");
	 String Lab_id=(String)request.getAttribute("Lab_id_");
	 Integer leave=(Integer)request.getAttribute("leave");
%> 

<!-- Page-header start -->
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Salary of Labour</h4>
                    <span>View Salary.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Request for Salary</a>
                    </li>
                     <li class="breadcrumb-item"><a href="#!">View</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Page-header end -->
<div class="page-body">
    <!-- Container-fluid starts -->
    <div class="container">
         <!-- Main content starts -->
        <div>
        <%	LabourCheck labourCheck=(LabourCheck)request.getAttribute("labourCheck");
			String opr_mode=(String)request.getAttribute("opr_mode");
				if(opr_mode!=null&&labourCheck!=null){
						if(opr_mode.equals("view")){
			%>	
			  <div class="row text-center">
                   <div class="col-sm-12 invoice-btn-group text-center">
                       <button type="button" class="btn btn-primary btn-print-invoice m-b-10 btn-sm waves-effect waves-light m-r-20">Print</button>
                   </div>
               </div>
           <!-- Salary card start -->
               <div class="card">
                   <div class="card-block">
                       <div class="row invoive-info">
                           <div class="col-md-4 col-xs-12 invoice-client-info">
                               <h6>Labour Salary Details :</h6>
                        	   <h6 class="m-0"><%=labourService.getLabourByFullName(Lab_id)%></h6> 
                             <%--  <p class="m-0 m-t-10">Department :&nbsp;<%=labourCheck.getDepartment().getDt_department_name()%></p>
                                <p class="m-0">Shift Time :&nbsp;<%=labourCheck.getShift_time().getShift_status()%></p> --%>
                           </div>                          
                       </div>
                       <div class="row">
                           <div class="col-sm-12">
                               <div class="table-responsive">
                                   <table class="table  invoice-detail-table">
                                       <thead>
                                           <tr class="thead-default">
                                               <th>Days</th>
                                               <th>No</th>
                                               <th>Total</th>
                                           </tr>
                                       </thead>
                                       <tbody>                                    
                                           <tr>
                                              <td>HalfDay</td>
                                               <td>${halfDay}</td>
                                                <td>${halfSalary}.00&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i>
                                                </span></td>
                                           </tr>
                                           <tr>
                                              <td>FullDay</td>
                                               <td>${fullDay}</td>
                                                <td>${fullSalary}.00&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i>
                                                </span></td>
                                           </tr>  
                                            <tr>
                                              <td>Leave</td>
                                               <td>${leave}</td>
                                                <td>0.00&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i>
                                                </span></td>
                                           </tr> 
                                           <tr>
                                              <td>ESIC</td>
                                               <td>0%</td>
                                                <td>0.00&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i>
                                                </span></td>
                                           </tr>   
                                            <tr>
                                              <td>PF</td>
                                               <td>0%</td>
                                                <td>0.00&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i>
                                                </span></td>
                                           </tr>   
                                           <tr>
                                              <td>PT</td>
                                               <td>0%</td>
                                                <td>0.00&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i>
                                                </span></td>
                                           </tr>  
                                       </tbody>
                                   </table>
                               </div>
                           </div>
                       </div>
                       <div class="row">
                           <div class="col-sm-12">
                               <table class="table table-responsive invoice-table invoice-total">
                                   <tbody>
                                       <tr>
                                           <th>Total salary :</th>
                                           <td><%=total_salary_addtion %>&nbsp;<span><i class="fa fa-inr" aria-hidden="true"></i></td>
                                       </tr>
                                   </tbody>
                               </table>
                           </div>
                       </div>
                   </div>
               </div>
                <%		}
					 
					}
				%>
               <!-- Invoice card end -->
                 		<div class="row text-center">
                              <div class="col-sm-12 invoice-btn-group text-center">
                                  <button type="button" class="btn btn-primary btn-print-invoice m-b-10 btn-sm waves-effect waves-light m-r-20">Print</button>
                                 <button rel="<%=contextPath %>/labour/mng_attendance" id="btn-cancel" type="button" class="btn btn-danger m-b-10 btn-sm waves-effect waves-light m-r-20">Cancel</button>
                              </div>
                          </div>
                                     </div>
                                </div>
                                <!-- Container ends -->
                            </div>
                            <!-- Page body end -->
                        </div>
                    </div>
                    <!-- Warning Section Starts -->

                    <div id="styleSelector">

                    </div>
                    </div>
                </div>
            </div>
        </div>
       
    </div>
</div>

<script>

		$(document).ready(function(){
	$('#btn-cancel').on('click', function() {
            var loc=$(this).attr('rel');
            location.href=loc;
 		});
});
</script>