<%@page import="java.util.Map.Entry"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.services.LabourService"%>
<%@page import="com.spcl.erp.model.Labour"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%
	 	String contextPath = request.getContextPath();
	  	Labour labour=(Labour)request.getAttribute("lab");

	 	Helper helper = (Helper)request.getAttribute("helper");
	 	LabourService LabourService=(LabourService)request.getAttribute("labourService");
	 %> 

<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" href="<%=contextPath %>/resources/assets/bower_components/select2/css/select2.min.css"/>

<!-- jquery file upload Frame work -->
<link href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/jquery.filer.css" type="text/css" rel="stylesheet" />
<link href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/themes/jquery.filer-dragdropbox-theme.css" type="text/css" rel="stylesheet" />

<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>

<div class="page-header">
    <div class="row align-items-end">
        <div class="col-sm-8 col-md-8 col-lg-8 col-xl-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Labour Details</h4>
                    <span>Create new Labour/Labour System.</span>
                </div>
            </div>
        </div>
        <div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Labour</a>
                    </li>
                     <li class="breadcrumb-item"><a href="#!">New</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

  

 <div class="page-body">
        <div class="row">
            <div class="col-sm-12">                       
                <div class="card">
                   <form id="from_labour" method="post" action="<%=contextPath%>/labour/save_labour" modelAttribute="labour" enctype="multipart/form-data">
		        	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
		      		<input type=hidden class="form-control" id="lab_id"name="lab_id" value="${labour.lab_id}" />
		            <input type=hidden class="form-control" id="lab_img_code"name="lab_img_code" value="${labour.lab_img_code}" />                    
		    		
		    		<div class="card-header">
                            <div class="col-sm-12">
                                <h5>${opr_mode=="save"?"Add new Labour":"Edit Labour"}</h5>
                                <span>Add new Labour</span>                            
                            </div><hr>
                        </div>
                        <div class="card-block">
                        <div class="col-sm-12 row">
                        <div class="col-sm-6 ">
                            <div class="row">
	                          	<div class="  col-sm-4 col-md-4 col-lg-4 col-xl-4">
	                            	<label for="emp_code" class="block">Labour Code</label>
	                           	</div>
	                            <div class="form-group col-sm-8 col-md-8 col-lg-8 col-xl-8">
	                                <input id="lab_code" name="lab_code" type="text" class=" form-control" value="${labour.lab_code}"/>
	                            </div>
    						</div>
                            </div>
                            <div class="  col-sm-6 col-md-6 col-lg-6 col-xl-6 ">
		                        <input type="file" class="form-control" onchange="document.getElementById('lab_profile_photo_view').src = window.URL.createObjectURL(this.files[0])" id="lab_profile_photo" name="lab_profile_photo">
		                        <img class="d-block img-fluid img-thumbnail" 
		                        	id="lab_profile_photo_view" 
		                        	style="height: 150px;" 
		                        	src="<%=contextPath %>/resources/lab_img/${labour.lab_img_code }" 
		                        	alt="Preview Photo here....">
		                    </div>
						</div><br/>
                        <div class="row">
	               		<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
	               			<div class="row">
	               				<div class="  col-sm-2 col-md-2 col-lg-2 col-xl-2">
	                            	<label for="emp_fname" class="block">Full Name</label>
	                           	</div>
	    						<div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
	                            	<select name="lab_title" id="lab_title" class="form-control"
	                                	required data-bv-notempty-message="Please select title.">
	                                	<option value="">---Select Title---</option>
	                                    <option value="Mr.">Mr.</option>
	                                    <option value="Mrs.">Mrs.</option>
	                                    <option value="Miss.">Miss.</option>
	                               	</select>
	    						</div>
	    						<div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
	                     			<input id="lab_fname" name="lab_fname" type="text" class=" form-control" 
	                                      placeholder="First Name"
	                                      required data-bv-notempty-message="Please enter first name.">
	                        	</div>
	                        	<div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
	                                <input id="lab_mname" name="lab_mname" type="text" class=" form-control"
	                                placeholder="Middle Name" 
	                                required data-bv-notempty-message="Please enter middle name.">
	                            </div>
	                            <div class="form-group col-sm-2 col-md-2 col-lg-2 col-xl-2">
	                                <input id="lab_lname" name="lab_lname" type="text" class=" form-control"
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
                                        <input type="radio" class="form_control" name="lab_gender" id="lab_gender_1" value="1">
                                        <i class="helper"></i>Male
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="lab_gender" id="lab_gender_2" value="2">
                                        <i class="helper"></i>Female
                                    </label>
                                </div>
                                <div class="radio radio-inline">
                                    <label>
                                        <input type="radio" class="form_control" name="lab_gender" id="lab_gender_3" value="3"/>
                                        <i class="helper"></i>Transgender
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>      
                     <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                            <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <label for="lab_date" class="block">Date of Birth</label>
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
                                <input id="lab_dob" name="lab_dob" type="text" class="form-control "
                                    placeholder="select your Date of Birth"/>
	              			</div>
	               		</div>
                    </div> 
                </div>
                <div class="row">
                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                           <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
						<label for="emp_mobile_no" class="block">Mobile No</label>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-4 col-xl-4 form-group">
							<input id="lab_mobile_no" name="lab_mobile_no" type="text"
								class=" form-control" required
								data-bv-notempty-message="Please enter mobile number.">
						</div>
                        </div>
                    </div>

                    <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                        <div class="row">
                        	 <div class="col-sm-2 col-md-2 col-lg-2 col-xl-2">
                                <label for="emp_place" class="block">Marital Status</label>
                            </div>
                           <div class="form-group col-sm-4 col-md-4 col-lg-4 col-xl-4">
                                <select  class="form-control" id="lab_marital_status" name="lab_marital_status"
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
                    <div class="row"> 
                    <div class="col-sm-6">
						<div class="row">
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
								<label for="corr_line1" class="block">Correspondence Address</label>
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<input id="corr_line1" name="corr_line1"
									type="text" class=" form-control">
							</div>
							<div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 form-group">
								<input id="corr_line2" name="corr_line2"
									type="text" class=" form-control">
							</div>
							<div class="form-group  col-sm-12">
                                <select id="lab_city_id" name="lab_city_id" class="form-control" required data-bv-notempty-message="Please select city.">
                                    <option value="">---Select City---</option>
                                </select>
                            </div>
						</div>
					</div>
					
					<div class="col-sm-6">
						<div class="row">
						<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
							<label for="corr_line1" class="block">Department</label>
						</div>
						<div class="col-sm-7 col-md-7 col-lg-7 col-xl-7 form-group">
							<select id="department_dept_id" name="department_dept_id" class="form-control" required data-bv-notempty-message="Please select Department">
                                   <option value="">---Select Department---</option>
                                   <%=helper.getDepartmentDropDown() %>
                               </select>
							</div>
						</div>
					
					</div>
				</div>  
				<div class="row">
				<div class="col-sm-6 col-md-6 col-lg-6 col-xl-6">
                        <div class="row">
                            <div class="col-sm-4 col-md-4 col-lg-4 col-xl-4">
                                <label for="lab_date" class="block">Joining Date</label>
                            </div>
                            <div class="form-group col-sm-6 col-md-6 col-lg-6 col-xl-6">
                                <input id="lab_join_date" name="lab_join_date" type="text" class="form-control "
                                    placeholder="select your Date of Birth"/>
	              			</div>
	               		</div>
                    </div> 
                    <div class="col-sm-6">
						<div class="row">
						<div class="col-sm-3 col-md-3 col-lg-3 col-xl-3">
							<label for="corr_line1" class="block">Contractor</label>
						</div>
						<div class="col-sm-7 col-md-7 col-lg-7 col-xl-7 form-group">
							<select id="contractor_cd_id" name="contractor_cd_id" class="form-control" required data-bv-notempty-message="Please select Department">
                                   <option value="">---Select Contractor---</option>
                                   <%=helper.getContractorDropDown() %>
                               </select>
							</div>
						</div>
					
					</div>
				</div>             
		
                        </div>
                        <div class="form-group row">
                                <input type="submit"   value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"></input>&nbsp;
                                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               <button rel="<%=contextPath %>/labour/mng_labour" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
                        </div> 
                    </form>
                    	
                </div>    
            </div>
        </div>
    </div>    
 <!-- Date-range picker js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/moment/js/moment.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/select2/js/select2.full.min.js"></script>
  
<script type="text/javascript" src="<%=contextPath%>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#lab_dob').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
    });
	$('#lab_join_date').daterangepicker({
        singleDatePicker: true,
        showDropdowns: true
    });
	$('#lab_city_id').select2({
		placeholder: "Select city Name",
		  	ajax: {
		    	url: '<%=contextPath %>/extra/getCitylist',
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
	
	
	
	$('#from_labour').bootstrapValidator()
	.on("success.form.bv", function() {
    	$('#file_error').html("").hide();
   		var form = new FormData($('#from_labour')[0]);
	    $.ajax({
	        url: '<%=contextPath%>/labour/save_labour',
			type : 'POST',
			dataType : "json",
			complete : function() {
			},
			success : function(data) {
			if (data.status == 1) {
				
				location.href = '<%=contextPath%>/labour/mng_labour';
				} else if (data.status == 0) {
					
					$('#file_error')
							.append(data.error)
							.show();
					$("#submit-btn")
							.prop("disabled",false);
				}
			},
			error : function(xhr,
					textStatus,
					thrownError) {
				console.log("ERROR: ",thrownError);
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
	
});
</script>




























