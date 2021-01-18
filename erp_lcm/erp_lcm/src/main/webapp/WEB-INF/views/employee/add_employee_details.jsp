<%@page import="com.spcl.erp.model.Employee_Education"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.EmployeeService"%>
<%@page import="com.spcl.erp.model.Employee"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%
	 	String contextPath = request.getContextPath();
	  	Employee employee=(Employee)request.getAttribute("employee");
	 	Helper helper = (Helper)request.getAttribute("helper");
	 	EmployeeService employeeService=(EmployeeService)request.getAttribute("employeeService");
	 %> 
<style>
.md-tabs .nav-item {
    width: calc(100% / 8);
    text-align: center;
}
</style>
<!-- Select 2 css -->
<link rel="stylesheet" href="<%=contextPath%>/resources/assets/bower_components/select2/css/select2.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<div class="page-header">
    <div class="row align-items-end">
        <div class="col-sm-8 col-md-8 col-lg-8 col-xl-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Employee Details</h4>
                    <span>Create new Employee/Employee System.</span>
                </div>
            </div>
        </div>
        <div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Employee Details</a>
                    </li>
                     <li class="breadcrumb-item"><a href="#!">New</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Page-header end -->

<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>

<div class="row">
	<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
	<!-- Tab variant tab card start -->
	<div class="card">
        <div class="card-header">
            <h6 class="sub-title">${opr_mode=="save"?"New Employee":"Edit Employee"}</h6>
        </div>
            
        <!-- Row start -->
        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#personal" role="tab">
                            <i class="icofont icofont-home"></i>Personal
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#education" role="tab">
                            <i class="icofont icofont-ui-user "></i>Educational Qualification
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#Contact " role="tab">
                            <i class="icofont icofont-ui-message"></i>Contact
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#bank" role="tab">
                            <i class="icofont icofont-ui-settings"></i>Bank Details
                        </a>
                    </li>
                    
                    <li class="nav-item">
                        <a class="nav-link " data-toggle="tab" href="#company" role="tab">
                            <i class="icofont icofont-home"></i>Company 
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#position" role="tab">
                            <i class="icofont icofont-ui-user "></i>Position
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#Work" role="tab">
                            <i class="icofont icofont-ui-message"></i>Work Experience
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#doc" role="tab">
                            <i class="icofont icofont-ui-settings"></i>Documents
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        
        <form id="from_employee" method="post" action="<%=contextPath%>/employee/save_employee_details" modelAttribute="employee">
        	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
      		<input type=hidden class="form-control" id="emp_id"name="emp_id" value="${employee.emp_id}" />
            <input type=hidden class="form-control" id="emp_img_code"name="emp_img_code" value="${employee.emp_img_code}" />                    
    	<!-- Tab panes -->
    	<div class="tab-content card-block">
    		<!-- tab for personal data start-->
    	    <div class="tab-pane active" id="personal" role="tabpanel">
             	<div class="row">
    				<div class=" col-sm-6 col-md-6 col-lg-6 col-xl-6">
                    	<div class="row">
                          	<div class="  col-sm-4 col-md-4 col-lg-4 col-xl-4">
                            	<label for="emp_code" class="block">Employee Code</label>
                           	</div>
                            <div class="form-group col-sm-8 col-md-8 col-lg-8 col-xl-8">
                                <input id="emp_code" name="emp_code" type="text" class=" form-control" value="${employee.emp_code}"/>
                            </div>
    					</div>
                   	</div>
                   	<div class="  col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
                        <input type="file" class="form-control" onchange="document.getElementById('emp_profile_photo_view').src = window.URL.createObjectURL(this.files[0])" id="emp_profile_photo" name="emp_profile_photo">
                        <img class="d-block img-fluid img-thumbnail" 
                        	id="emp_profile_photo_view" 
                        	style="height: 150px;" 
                        	src="<%=contextPath %>/resources/emp_img/${employee.emp_img_code }" 
                        	alt="Preview Photo here....">
                    </div>
                </div>
    			
                <div class="row">
               		<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
               			<div class="row">
               				<div class="  col-sm-2 col-md-2 col-lg-2 col-xl-2">
                            	<label for="emp_fname" class="block">Full Name</label>
                           	</div>
    						<div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
                            	<select name="emp_title" id="emp_title" class="form-control"
                                	required data-bv-notempty-message="Please select title.">
                                	<option value="">---Select Title---</option>
                                    <option value="Mr.">Mr.</option>
                                    <option value="Mrs.">Mrs.</option>
                                    <option value="Miss.">Miss.</option>
                               	</select>
    						</div>
    						<div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
                     			<input id="emp_fname" name="emp_fname" type="text" class=" form-control" 
                                      placeholder="First Name"
                                      required data-bv-notempty-message="Please enter first name.">
                        	</div>
                        	<div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <input id="emp_mname" name="emp_mname" type="text" class=" form-control"
                                placeholder="Middle Name" 
                                required data-bv-notempty-message="Please enter middle name.">
                            </div>
                            <div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <input id="emp_lname" name="emp_lname" type="text" class=" form-control"
                                placeholder="Last Name" 
                                required data-bv-notempty-message="Please enter last name.">
                            </div>
                     	</div>
                   	</div>
    				
    		    </div>
    			
                <div class=row>
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <label for="emp_gender" class="block">Gender</label>
                            </div>
                            <div class="form-group form-radio col-sm-10 col-md-10 col-lg-10 col-xl-10">
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="emp_gender" id="emp_gender_1" value="1">
                                        <i class="helper"></i>Male
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="emp_gender" id="emp_gender_2" value="2">
                                        <i class="helper"></i>Female
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="emp_gender" id="emp_gender_3" value="3"/>
                                        <i class="helper"></i>Transgender
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <label for="emp_date" class="block">Date of Birth</label>
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
                                <input id="emp_dob" name="emp_dob" type="text" class="form-control "
                                    placeholder="select your Date of Birth"/>
	              			</div>
	               		</div>
                    </div> 
                </div>
           
                
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <label for="emp_place" class="block">Place Of Birth</label>
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
                                <input type="text" id="emp_place" name="emp_place" class="form-control" 
                                    placeholder="Enter your place of birth"
                                    required data-bv-notempty-message="Please select place of birth."/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                        	 <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <label for="emp_place" class="block">Marital Status</label>
                            </div>
                           <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
                                <select  class="form-control" id="emp_marital_status" name="emp_marital_status"
                                 required data-bv-notempty-message="Please select marital status.">
                                    <option value="1">Single</option>
                                    <option value="2">Married</option>
                                    <option value="3">Divorce</option>
                                    <option value="4">Widowe</option>
                                    <option value="5">Legal Cohabitant</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
           	</div>
			<!-- tab for personal data end-->
			
			<!-- tab for education data start-->
			<div class="tab-pane" id="education" role="tabpanel">
				<input id="edu_id"  name="education_list[0].edu_id" type="hidden"
							class=" form-control" value="">
				<div class="form-group row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="edu_university" class="block">Higher Qualification</label>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
						<select name="education_list[0].edu_certificate" id="edu_certificate"
							class="form-control">
							<option value="">Select Certificate</option>
							<%
								if(helper!=null){
									for(Entry<String, String> e : helper.get_Certificate_list().entrySet()) {
							%>	      
								<%="<option value="+e.getKey()+">"+e.getValue()+"</option>"%>
							<%
								} }
							%>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="edu_university" class="block">University</label>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
						<input id="edu_university" name="education_list[0].edu_university" type="text"
							class=" form-control" required
							data-bv-notempty-message="Please enter university.">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="edu_passing_yrar" class="block">Passing Year</label>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
						<input id="edu_passing_year" name="education_list[0].edu_passing_year" type="text"
							class="form-control ">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="edu_degree" class="block">Degree</label>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
						<select id="edu_degree" name="education_list[0].edu_degree" class="form-control">
							<option value="">Select Degree</option>
							<%
								if(helper!=null){
													for(Entry<String, String> e : helper.get_Degree_list().entrySet()) {
							%>	      
								<%="<option value="+e.getKey()+">"+e.getValue()+"</option>"%>
							<%
								} }
							%>
							
						</select>
					</div>
				</div>
			</div>
	   		<!-- tab for education data end-->
	   		
	   		<!-- tab for education data start-->
			<div class="tab-pane" id="Contact" role="tabpanel">
				<div class="row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_mobile_no" class="block">Mobile No</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_mobile_no" name="contacts.emp_mobile_no" type="text"
							class=" form-control" required
							data-bv-notempty-message="Please enter mobile number.">
					</div>					
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_mobile_no" class="block">Alternative Mobile No</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_alt_mobile_no" name="contacts.emp_alt_mobile_no" type="text"
							class=" form-control" >
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_land_no" class="block">LandLine No</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_landline_no" name="contacts.emp_landline_no" type="text"
							class=" form-control" >
					</div>
					
				</div>
				
				<hr>
				
				<div class="row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_email" class="block">Email id</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_email" name="contacts.emp_email" type="email"
							class=" form-control" required
							data-bv-notempty-message="Please enter email id.">
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_alt_email" class="block">Alternative Email id</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_alt_email" name="contacts.emp_alt_email" type="email"
							class=" form-control" >
					</div>
				</div>
				
				<hr>
				
				<div class="row">
				
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_twitter_link" class="block">Twitter-link</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_twitter_link" name="contacts.emp_twitter_link" type="text"
							class=" form-control" >
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_facebook_link" class="block">Facebook-link</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_facebook_link" name="contacts.emp_facebook_link" type="text"
							class=" form-control" >
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_instagram_link" class="block">Instagram-link</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_instagram_link" name="contacts.emp_instagram_link" type="text"
							class=" form-control" >
					</div>
					
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<label for="emp_blog_link" class="block">Blog-link</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<input id="emp_blog_link" name="contacts.emp_blog_link" type="text"
							class=" form-control" >
					</div>
					
					
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_website" class="block">Website</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_website" name="contacts.emp_website" type="text"
							class=" form-control" >
					</div>
				</div>
				
				<hr>
				
				<div class="row">
					<div class="col-sm-6">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<label for="corr_line1" class="block">Correspondence Address</label>
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<input id="corr_line1" name="contacts.address_list[0].add_line1"
									type="text" class=" form-control">
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<input id="corr_line2" name="contacts.address_list[0].add_line2"
									type="text" class=" form-control">
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<select id="corr_city" name="contacts.address_list[0].enq_city.city_id" class="form-control" required data-bv-notempty-message="Please select city.">
                                    <option value="">---Select City---</option>
                                </select>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<label for="corr_line1" class="block">Permanent Address</label>
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<input id="per_line1" name="contacts.address_list[1].add_line1"
									type="text" class=" form-control">
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<input id="per_line2" name="contacts.address_list[1].add_line1"
									type="text" class=" form-control">
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<select id="per_city" name="contacts.address_list[1].enq_city.city_id" class="form-control" required data-bv-notempty-message="Please select city.">
                                    <option value="">---Select City---</option>
                                </select>
							</div>
						</div>
					</div>	
					
				</div>
			</div>
			<!-- tab for bank account details start -->
   	 		<div class="tab-pane" id="bank" role="tabpanel">
           		<div class="row">
                    <div class="col-sm-6">
						<div class="row">
						<label class="col-sm-3 col-form-label" >Account Number</label>
						<div class="form-group col-sm-9"> 
						<input type="text" class="form-control" id="acc_number" name="account.acc_number"
						placeholder="Enter Your Account Number "
						 required data-bv-notempty-message="Please enter Account Number .">
                                    </div>
                                 	</div>
                            	<div class="row">
                                   	<label class="col-sm-3 col-form-label">Type </label>
                                    	<div class=" form-group col-sm-9">
                                        	<select type="text" class="form-control" id="acc_type" name="account.acc_type"
											 required data-bv-notempty-message="Please enter Account Type.">
											 <option value="">---Select Type ---</option> 
                                          <option value="Megha">Normal</option> 
                                           <option value="Salary account">Salary account</option> 
                                            <option value="saving">saving</option> 
                                            <option value="current">current</option> 
                                               </select> 
                                        </div>
                                </div>
                           	 <div class="row">
                                <label class="col-sm-3 col-form-label">Account holder</label>
                                    <div class=" form-group col-sm-9">
                                        <select type="text" class="form-control" id="acc_holder" name="account.acc_holder" 
                                        placeholder="Account Holder" 
                                        required data-bv-notempty-message="Please enter Account Holder Name.">
                                         <option value="">---Select Name ---</option> 
                                          <option value="Megha">Megha</option> 
                                           <option value="Neha">Neha</option> 
                                            <option value="Dhanashree">Dhanashree</option> 
                                               </select> 
                                    </div>
                             </div>
                         </div>
         	 	<div class="col-sm-6">
                            	<div class="row">
                                   	<label class="col-sm-3 col-form-label">Bank </label>
                                    	<div class=" form-group col-sm-9">
											<select type="text" class="form-control" id="acc_bank" name="bank.bnk_id" 
                                              required data-bv-notempty-message="Please Enter Bank Details">
                                               <option value="">---Select ---</option> 
                                               </select>            
                                             </div>
                                </div>
                           	 <div class="row">
                                <label class="col-sm-3 col-form-label">Account Holder</label>
                                    <div class=" form-group col-sm-9">
                                        <input type="text" class="form-control" id="acc_holder1" name="account.acc_holder1" 
                                        placeholder="Enter your Account Holder" 
                                        required data-bv-notempty-message="Please enter Account Holder.">
                                    </div>
                             </div>
                         </div>
                      </div> 
                      </div>
<!-- tab for bank details end -->


								                
								<!-- tab for personal data end--> 
								
								
    	 <div class="tab-pane" id="position" role="tabpanel">
    	<input id="emp_position_id"  name="position_list[0].emp_position_id" type="hidden"
						class=" form-control" value="">
						           <div class="row">
						               <div class="col-sm-6">
						<div class="row">
						<label class="col-sm-3 col-form-label" >Job Description</label>
						<div class="form-group col-sm-9"> 
						<textarea rows="4" cols="50" class="form-control" id="emp_job_description" name="position_list[0].emp_job_description"
						placeholder="Enter Your Job Description Details"
						 required data-bv-notempty-message="Please enter Job Description."></textarea>
                                    </div>
                                 	</div>
                                 	<div class="row">
                                <label class="col-sm-3 col-form-label">Employee Name</label>
                                    <div class=" form-group col-sm-9">
                                        <input type="text" class="form-control" id="emp_name" name="position_list[0].emp_name" 
                                        placeholder="Enter your Name" 
                                        required data-bv-notempty-message="Please enter employee name.">
                                    </div>
                             </div>
                            	<div class="row">
                                   	<label class="col-sm-3 col-form-label">Job Position </label>
                                    	<div class=" form-group col-sm-9">
                                        	<select type="text" class="form-control" id="emp_job_position" name="position_list[0].emp_job_position"
											 required data-bv-notempty-message="Please enter Your Job Position.">
											<option value="">---Select Position ---</option> 
                                          	<option value="engineer">Software Engineer</option> 
                                           	<option value="designert">Graphics Designer</option> 
                                            <option value="accountant">Accountant</option> 
                                            <option value="developer">Web Developer</option> 
                                               </select> 
                                        </div>
                                </div>
                                
                           	 </div>
         	 <div class="col-sm-6">
                            	<div class="row">
                                <label class="col-sm-3 col-form-label">Job Type</label>
                                    <div class=" form-group col-sm-9">
                                        <select type="text" class="form-control" id="emp_job_type" name="position_list[0].emp_job_type" 
                                        placeholder="Employee Job" 
                                        required data-bv-notempty-message="Please enter Empolyee Job Type.">
                                         <option value="">---Select Job Type ---</option> 
                                          <option value="fullTime">Full Time</option> 
                                           <option value="partTime">Part Time</option> 
                                            <option value="permanent">Permanent</option>
                                            <option value="contract">Contract</option> 
                                               </select> 
                                    </div>
                             </div>
                             <div class="row">
								<label class="col-sm-3 col-form-label" >Employee  Manager</label>
								<div class="form-group col-sm-9"> 
								<input type="text" class="form-control" id="emp_position_manager" name="position_list[0].emp_position_manager"
								placeholder="Enter Your Manager Name"
								 required data-bv-notempty-message="Please enter Your Manager name.">
		                                    </div>
		                                 	</div>
		                                 	<div class="row">
		                                <label class="col-sm-3 col-form-label">Employee Department</label>
		                                    <div class=" form-group col-sm-9">
		                                        <select type="text" class="form-control" id="emp_position_department" name="position_list[0].emp_position_department" 
		                                        placeholder="Employee Department" 
		                                        required data-bv-notempty-message="Please enter Empolyee Department.">
		                                         <option value="">---Select Department ---</option> 
		                                         <%=helper.getDepartmentDropDown()%>
		                                               </select> 
		                                    </div>
		                             </div>
		                      </div>
		                      <div class="col-sm-6">
		                             <div class="row">
		                                <label class="col-sm-3 col-form-label">Employee Shift</label>
		                                    <div class=" form-group col-sm-9">
		                                        <select type="text" class="form-control" id="emp_shift" name="position_list[0].emp_shift" 
		                                        placeholder="Employee Shift" 
		                                        required data-bv-notempty-message="Please enter Empolyee Job Type.">
		                                         <option value="">---Select Shift ---</option> 
		                                          <option value="1">7:00 to 3:30</option> 
		                                           <option value="2">3:30 to 12:00</option> 
		                                            <option value="3">12:00 to 7</option> 
		                                               </select> 
		                                    </div>
		                             </div>
		         	  </div>
		         	  <div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
		                        <div class="row">
		                            <div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
		                                <label for="emp_date" class="block">Joining Date</label>
		                            </div>
		                            <div class="form-group col-sm-6 col-md-6 col-lg-6 col-xl-6">
		                                <input id="emp_joining_date" name="position_list[0].emp_joining_date" type="text" class="form-control "
		                                    placeholder="select your Date of Birth"/>
		              	 </div>
		               	 </div>
		                    </div> 
		                   
		                </div>
		                </div>
<!-- tab end for employee documents -->
				 <div class="tab-pane" id="Work" role="tabpanel">
            <input id="emp_company_id"  name="work_list[0].emp_company_id" type="hidden"
							class=" form-control" value="">
		         <div class="row">
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_name" class="block">Employee Name:-</label>
					</div>
					<div class="col-sm-2 col-md-2 col-lg-3 col-xl-3 form-group">
						<input id="emp_name" name="work_list[0].emp_name" type="text"
							class=" form-control" required
							data-bv-notempty-message="Please enter employee name.">
					</div>	
					</div>	
					
					<div class="row">	
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_work_location" class="block">Work Location:-</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_work_location" name="work_list[0].emp_work_location" type="text"
							class=" form-control" >
					</div>
				</div>  
				<div class="row">	
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_phone" class="block">Phone No:-</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_phone" name="work_list[0].emp_phone" type="text"
							class=" form-control" >
					</div>
				</div>  
				<div class="row">	
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_job" class="block">Job:-</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_job" name="work_list[0].emp_job" type="text"
							class=" form-control" >
					</div>
				</div>  
				<div class="row">	
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_salary" class="block">Salary:-</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_salary" name="work_list[0].emp_salary" type="text"
							class=" form-control" >
					</div>
				</div> 
				<div class="row">	
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
						<label for="emp_experiance" class="block">Total Experiance:-</label>
					</div>
					<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3 form-group">
						<input id="emp_experiance" name="work_list[0].emp_experiance" type="text"
							class=" form-control" >
					</div>
				</div>  
             </div>
             
             <!--tab for employee documents  -->
								 <div class="tab-pane" id="doc" role="tabpanel">
								            	 <input id="emp_document_id"  name="document_list[0].emp_document_id" type="hidden" class=" form-control" value="">
								         	 <div class="row">
								<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
								<label for="emp_doc" class="block">Document 1:-</label>
								</div>
								<div class="  col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
								                   <input type="file" class="form-control" onchange="document.getElementById('emp_doc1_view').src = window.URL.createObjectURL(this.files[0])" id="emp_doc1" name="document.emp_doc1">
								                 </div>	
								</div>	<br><br>
								 	
								 	 <div class="row">
								<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
								<label for="emp_doc" class="block">Document 2:-</label>
								</div>
								<div class="  col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
								                        <input type="file" class="form-control" onchange="document.getElementById('emp_doc2').src = window.URL.createObjectURL(this.files[0])" id="emp_doc2" name="document.emp_doc2">
								                    </div>	
								</div>	<br><br>
								 
								 	 <div class="row">
								<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
								<label for="emp_doc" class="block">Document 3:-</label>
								</div>
								<div class="  col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
								                        <input type="file" class="form-control" onchange="document.getElementById('emp_doc3').src = window.URL.createObjectURL(this.files[0])" id="emp_doc3" name="document.emp_doc3">
								                   </div>	
								</div>	
								             </div>
								           	</div>
           	<!-- Tab panes for employee position-->
		</div>
        
       <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
	        <div class="row">
	            <div class="form-group">
	                <input type="submit" id="submit-btn"  value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"></input>
	                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	               <button rel="<%=contextPath%>/employee/mng_employee" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	        	</div>
	        </div>
        </div>
        </form>
    </div>
    <!-- Tab variant tab card end -->
    </div>
</div>
                
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/select2/js/select2.full.min.js"></script>
                      
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/moment/js/moment.min.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#emp_dob').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
    });
	$('#acc_bank').select2({
		placeholder: "Select Bank Name",
		  	ajax: {
		    	url: '<%=contextPath %>/extra/getBanklist',
		    	dataType: 'json',
		    	data: function (params) {
		         var query = {
		           search: params.term
		         }

		         // Query parameters will be ?search=[term]&type=public
		         return query;
		       }
		   	}
		});
	
	$('#corr_city').select2({
		placeholder: "Select city Name",
	  	ajax: {
	    	url: '<%=contextPath%>/extra/getCitylist',
	    	dataType: 'json',
	    	data: function (params) {
	         var query = {
	           search: params.term
	         }
			return query;
	       }
	   	}
	});
	
	$('#per_city').select2({
		placeholder: "Select city Name",
	  	ajax: {
	    	url: '<%=contextPath%>/extra/getCitylist',
	    	dataType: 'json',
	    	data: function (params) {
	         var query = {
	           search: params.term
	         }
			return query;
	       }
	   	}
	});
	
	$('#from_employee').bootstrapValidator()
	.on("success.form.bv", function() {
    	$('#file_error').html("").hide();
   		var form = new FormData($('#from_employee')[0]);
	    $.ajax({
	        url: '<%=contextPath%>/employee/save_employee_details',
			type : 'POST',
			dataType : "json",
			complete : function() {
			},
			success : function(data) {
			if (data.status == 1) {
				location.href = '<%=contextPath%>/employee/mng_employee';
				} else if (data.status == 0) {
					$('#file_error')
							.append(
									data.error)
							.show();
					$("#submit-btn")
							.prop(
									"disabled",
									false);
				}
			},
			error : function(xhr,
					textStatus,
					thrownError) {
				console
						.log(
								"ERROR: ",
								thrownError);
				alert("Somthing went wrong....");
			},
			data : form,
			cache : false,
			contentType : false,
			processData : false
		});

		return false;
	});

	$('.btn_radio').on("click", function() {
		var btn_val = $(this).val();

		if (btn_val == 0) {
			$('#hide_address').hide();
		} else {
			$('#hide_address').show();
		}

	});

	$('#btn-cancel').on('click', function() {
		var loc = $(this).attr('rel');
		location.href = loc;
	});
	
	<%String opr_mode = (String) request.getAttribute("opr_mode");

		if (opr_mode != null && employee != null) {
		if (opr_mode.equals("update")) {%>
		$('#emp_code').val('${employee.emp_code}');
		$('#emp_title').val('${employee.emp_title}');
		$('#emp_fname').val('${employee.emp_fname}');
		$('#emp_lname').val('${employee.emp_lname}');
		$('#emp_mname').val('${employee.emp_mname}');
		$('#emp_place').val('${employee.emp_place}');
		$('#emp_dob').val('${emp_dob}');
		$('#emp_marital_status').val('${employee.emp_marital_status}');
	<%if (employee.getEmp_gender() != null) {%>
		$('#emp_gender_' +<%=employee.getEmp_gender()%>).prop('checked', true);
	<%}%>
	
	<%if (employee.getEducation_list() != null) {%>
		$('#edu_id').val('${employee.education_list[0].edu_id}');
		$('#edu_certificate').val('${employee.education_list[0].edu_certificate}');
		$('#edu_university').val('${employee.education_list[0].edu_university}');
		$('#edu_passing_year').val('${employee.education_list[0].edu_passing_year}');
		$('#edu_degree').val('${employee.education_list[0].edu_degree}');
	<%}%>
		
		
		
	<%}else if(opr_mode.equals("view")){%>
		
		$('#emp_code').replaceWith($("<span>",{text:'${employee.emp_code}'}));
		$('#emp_title').closest('div').addClass('  col-sm-6 col-md-6 col-lg-6 col-xl-6');
		$('#emp_title').replaceWith($("<span>",{text:'<%=employeeService.getEmployeeByFullName(employee)%>'}));
		$('#emp_fname').closest('div').replaceWith('');
		$('#emp_lname').closest('div').replaceWith('');
		$('#emp_mname').closest('div').replaceWith('');
		$('#emp_place').replaceWith($("<span>",{text:'${employee.emp_place}'}));
		$('#emp_dob').replaceWith($("<span>",{text:'${emp_dob}'}));								
		$('#emp_marital_status').replaceWith($("<span>",{text:'${employee.emp_marital_status}'}));
				
		$('#emp_gender_1').closest('div').replaceWith($("<span>",{text:'<%=employeeService.getEmployeeGender(employee)%>'}));
		$('#emp_gender_2').closest('div').replaceWith('');
		$('#emp_gender_3').closest('div').replaceWith('');
		
		<%if(employee.getEducation_list()!=null){ 
			for(Employee_Education edu: employee.getEducation_list()){%>
			$('#edu_certificate').replaceWith($("<span>",{text:'<%=edu.getCrtificateText(helper)%>'}));
			$('#edu_university').replaceWith($("<span>",{text:'<%=edu.getEdu_university()%>'}));
			$('#edu_passing_year').replaceWith($("<span>",{text:'<%=edu.getEdu_passing_year()%>'}));
			$('#edu_degree').replaceWith($("<span>",{text:'<%=edu.getDegreeText(helper)%>'}));
		<% }} %>
		
		//$('#add_row_button').replaceWith('');
		$('input[type="file"]').replaceWith('');
		$('input[type="submit"]').replaceWith('');
		$('input[type="reset"]').replaceWith('');
		//$("#col_action").remove();
		
	<% 	
		}
	}
%>

});

</script>
                                                             
                        
                    
             
