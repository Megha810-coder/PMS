<%@page import="com.spcl.erp.services.SalepersonService"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.model.SalePerson "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%
	String contextPath = request.getContextPath();
	 Helper helper = (Helper)request.getAttribute("helper");
	SalepersonService salepersonService=(SalepersonService)request.getAttribute("SalepersonService"); 
	%> 
<!--forms-wizard css-->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/jquery.steps/css/jquery.steps.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<!-- Page body start -->
 <div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
            <div class="card">
                <div class="card-header">
                    
                    <h5>${opr_mode=="save"?"New SalesPerson":"Edit SalesPerson"}</h5>
                </div>
                <div class="card-block">
                  <form id="new_saleperson" method="post" action="<%=contextPath%>/saleperson/save_saleperson" modelAttribute="saleperson" enctype="multipart/form-data">
                    <input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
					<input type=hidden class="form-control" id="salep_id" name="salep_id" value="${saleperson.salep_id}" />
					<div class="row">
					<div class="col-sm-6"></div>
                            <div class="col-sm-6 form-group">
                                <input type="file" class="form-control" onchange="document.getElementById('salep_profile_photo_view').src = window.URL.createObjectURL(this.files[0])" id="salep_profile_photo" name="salep_profile_photo">
                                <img class="d-block img-fluid img-thumbnail" 
                                	id="salep_profile_photo_view" 
                                	style="height: 150px;" 
                                	src="<%=contextPath %>/resources/saleperson_img/${saleperson.salep_img_code }" 
                                	alt="Preview Photo here....">
                            </div>
                         </div>
                      <div class="row">
                          <label class="col-sm-2 col-form-label">Name</label>
                          <div class="col-sm-2">
                              <div class="form-group row col-sm-12">
                                  <select name="salep_title" class="form-control" required data-bv-notempty-message="Please select title.">
                                      <option value="">---Select Title---</option>
                                      <option value="Mr.">Mr.</option>
                                      <option value="Mrs.">Mrs.</option>
                                      <option value="Miss">Miss</option>
                                  </select>
                              </div>
                          </div>
                          <div class="col-sm-3">
                              <div class="form-group row col-sm-12">
                                  <input type="text" class="form-control" id="salep_fname" name="salep_fname" placeholder="Enter first name" required data-bv-notempty-message="Please enter first name.">
                              </div>
                          </div>
                          <div class="col-sm-2">
                              <div class="form-group row col-sm-12">
                                  <input type="text" class="form-control" id="salep_mname" name="salep_mname" placeholder="Enter middle name" required data-bv-notempty-message="Please enter middle name.">
                              </div>
                          </div>
                          <div class="col-sm-3">
                              <div class="form-group row col-sm-12">
                                  <input type="text" class="form-control" id="salep_lname" name="salep_lname" placeholder="Enter last name" required data-bv-notempty-message="Please enter last name.">
                              </div>
                          </div>
                      </div>
                      <div class="row">
                        <label class="col-sm-3 col-form-label">Mobile No.</label>
                        <div class="col-sm-9 form-group">
                            <input type="text" class="form-control" id="salep_contact" name="salep_contact" placeholder="Enter contact number." required data-bv-notempty-message="Please enter Mobile number." pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed" data-bv-stringlength="true"  data-bv-stringlength-min="6" data-bv-stringlength-max="10"  data-bv-stringlength-message="Mobile number should be 10 digits">
                            
                        </div>
                      </div>
                      <div class="row">
                          <label class="col-sm-3 col-form-label">Email</label>
                          <div class="col-sm-9 form-group">
                              <input type="email" class="form-control" id="salep_email" name="salep_email" placeholder="Enter email id." required data-bv-notempty-message="Please enter email id.">
                          </div>
                      </div>
                      <div class="form-group row">
                          <label class="col-sm-3 col-form-label">Website</label>
                          <div class="col-sm-9 form-group">
                              <input type="text" class="form-control" id="salep_website" name="salep_website" placeholder="Enter websiste name/link">
                          </div>
                      </div>
                      <div class="form-group row">
                        <label class="col-sm-2"></label>
                        <div class="col-sm-12">
                               	<input type="submit" id="submit-btn" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         	<button rel="<%=contextPath %>/saleperson/mng_saleperson" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	                     	
                            </div>
                      </div>
                    </form>
                </div>
              </div>
            </div>
        </div>
        <!-- Basic Inputs Validation end -->

      </div>
    </div>
</div>
<!-- Page body end -->

<c:choose>
	<c:when test = '${opr_mode=="update"}'>
		<% 	SalePerson salePerson=(SalePerson)request.getAttribute("salePerson");
			if(salePerson!=null){
		%>
		<script type="text/javascript">
			$(document).ready(function() {
			
				$('#salep_title').val('<%=salePerson.getSalep_title()%>');
				$('#salep_fname').val('<%=salePerson.getSalep_fname()%>');
				$('#salep_mname').val('<%=salePerson.getSalep_mname()%>');
				$('#salep_lname').val('<%=salePerson.getSalep_lname()%>');
				$('#salep_phone').val('<%=salePerson.getSalep_contact()%>');
				$('#salep_email').val('<%=salePerson.getSalep_email()%>');
				$('#salep_website').val('<%=salePerson.getSalep_website()%>');
																					
			});
				
		</script>
		<% }%>
	</c:when>
</c:choose>

<c:choose>
	<c:when test = '${opr_mode=="view"}'>
		<% 	SalePerson salePerson=(SalePerson)request.getAttribute("salePerson");
			if(salePerson!=null){
		%>
		<script type="text/javascript">
			$(document).ready(function() {
			
				$('#salep_title').closest("div"). replaceWith($("<span>", {text: '<%=salepersonService.getSalepersonByFullName(salePerson)%>'}));
				$('#salep_fname').closest("div").replaceWith('');
				$('#salep_mname').closest("div").replaceWith('');
				$('#salep_lname').closest("div").replaceWith('');
				
				$('#salep_contact').replaceWith($("<span>", {text: '<%=salePerson.getSalep_contact()%>'}));
				$('#salep_email').replaceWith($("<span>", {text: '<%=salePerson.getSalep_email()%>'}));
				$('#salep_website').replaceWith($("<span>", {text: '<%=salePerson.getSalep_website() %>'}));
								
				$('input[type="submit"]').replaceWith('');
				
				$('input[type="reset"]').replaceWith('');
			
			
			});
			
		</script>
		<% }%>
	</c:when>
</c:choose>




<!--Forms Validation js-->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/ajax/libs/moment.js/2.10.6/moment.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
 
<script type="text/javascript">
    $(document).ready(function(){
        $('#new_saleperson').bootstrapValidator()
            .on("success.form.bv", function() {
            var form = new FormData($('#new_saleperson')[0]);
            $.ajax({
                url: '<%=contextPath %>/saleperson/save_saleperson',
                type: 'POST',
                dataType :"json",
                complete: function() {}, 
                success: function (data) {
                	if(data.status == 1) {
                		location.href='<%=contextPath %>/saleperson/mng_saleperson';
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
        
        $('#btn-cancel').on('click', function() {
            var loc=$(this).attr('rel');
           	location.href=loc;
 		});
    });
</script>






</body>
</html>