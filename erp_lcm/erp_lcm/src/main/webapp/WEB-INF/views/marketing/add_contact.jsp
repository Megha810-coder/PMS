<%@page import="com.spcl.erp.model.Contact"%>
<%@page import="com.spcl.erp.services.TransferService"%>
<%@page import="com.spcl.erp.model.Transfer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<% 	String contextPath = request.getContextPath(); 
%>

	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
	
	<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>
	<div class="page-body">
    	<div class="row">
        	<div class="col-sm-12">
            	<!-- Basic Inputs Validation start -->
          		<div class="card">
                	<div class="card-header">
                        <h3>${opr_mode=="save"?"Add New Contact":"Edit Contact"}</h3>
                    </div>
                  	
                  	<div class="card-block">
                         <form id="add_cotc" method="post" action="<%=contextPath%>/marketing/save_contact"  modelAttribute="contact">
                         	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
							<input type=hidden class="form-control" id="cntc_id"name="cntc_id" value="${contact.cntc_id}" />
                        
                         	<div class="row">
                            	<div class="col-sm-6">
                                    <div class="row">
                                    	<label class="col-sm-3 col-form-label">Name</label>
                                       	<div class="form_group col-sm-9">
                                        	<input type="text" class="form-control" id="cntc_name" 
                                           		name="cntc_name" placeholder="Enter your name" 
                                           		required data-bv-notempty-message="Please enter name." >
                                    	</div>
                            		</div>
                           		</div>

								<div class="col-sm-6">
									<div class="row">
										<label class="col-sm-3 col-form-label">Address</label>
										<div class=" form-group col-sm-9">
                                        	<textarea rows="5" cols="4" class="form-control" id="cntc_address" name="cntc_address" 
                                           	placeholder="Enter your address" 
                                           	required data-bv-notempty-message="Please enter address." ></textarea>
                                    	</div>
                                	</div>
                           		</div>
							</div>
							
							<div class="row">
								<div class="col-sm-6">
									<div class="row">
										<label class="col-sm-3 col-form-form">Job Position</label>
                                    	<div class="form-group col-sm-9">
                                  			<input type ="text" class="form-control" id="cntc_postion"  name="cntc_postion" 
                                  			placeholder="Enter your job position" 
                                  			/required data-bv-notempty-message="Please enter job position.">
                               			</div>
                                 	</div>
                            	</div>
                                
								<div class="col-sm-6">
                             		<div class="row">
                                   		<label class="col-sm-3 col-form-label">Mobile No.</label>
                                    	<div class="col-sm-9">
                                        	<input type="text" class="form-control" id="cntc_mobile" name="cntc_mobile"
                                        	 placeholder="Enter your contact number."
											 required data-bv-notempty-message="Please enter mobile number.">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="col-sm-6">
									<div class="row">
	                                    <label class="col-sm-3 col-form-label">Email</label>
	                                    <div class="col-sm-9">
	                                        <input type="email" class="form-control" id="cntc_email" name="cntc_email" 
	                                        placeholder="Enter your email id" 
	                                        required data-bv-notempty-message="Please enter email-id.">
	                                    </div>
	                                </div>
	                           	</div>
                          	</div>
                          	
                            
								
							<div class="form-group row">
								<div class="col-sm-12">
                                	<input type="submit"  id="submit-btn"  value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"/>&nbsp;
                                	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               		<button rel="<%=contextPath %>/marketing/mng_contact" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
								</div>
                           	</div>      
                      	</form>
                  	</div>
             	</div>
			</div>
		</div>  
	</div>

<!-- <div id="styleSelector">
</div> -->


<!-- add footer page here -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('#add_cotc').bootstrapValidator()
            .on("success.form.bv", function() {
           	$('#file_error').hide();
            var form = new FormData($('#add_cotc')[0]);
            $.ajax({
                url: '<%=contextPath%>/marketing/save_contact',
                type: 'POST',
                dataType :"json",
                complete: function() {}, 
                success:  function (data) {
                	if(data.status == 1) {
                		location.href='<%=contextPath %>/marketing/mng_contact';
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

<%	Contact contact=(Contact)request.getAttribute("contact");
	String opr_mode=(String)request.getAttribute("opr_mode");

		if(opr_mode!=null&&contact!=null){
			if(opr_mode.equals("update")){
					
			
	%>	
		<script type="text/javascript">
			$(document).ready(function() {
				
				$('#cntc_name').val('<%=contact.getCntc_name()%>');
		        $('#cntc_email').val('<%=contact.getCntc_email()%>');
		        $('#cntc_mobile').val('<%=contact.getCntc_mobile()%>');
		        $('#cntc_postion').val('<%=contact.getCntc_postion()%>');      
		        $('#cntc_address').val('<%=contact.getCntc_address()%>');
		
				
			});
		</script>
<% 			}else if(opr_mode.equals("view")){ %>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#cntc_name').replaceWith($("<span>",{text:'<%=contact.getCntc_name()%>'}));
				$('#cntc_email').replaceWith($("<span>",{text:'<%=contact.getCntc_email()%>'}));
				$('#cntc_mobile').replaceWith($("<span>",{text:'<%=contact.getCntc_mobile()%>'}));
				$('#cntc_postion').replaceWith($("<span>",{text:'<%=contact.getCntc_postion()%>'}));								
				$('#cntc_address').replaceWith($("<span>",{text:'<%=contact.getCntc_address()%>'}));
				
				$('input[type="submit"]').replaceWith('');
				$('input[type="reset"]').replaceWith('');
			});
							
		</script>

	
<%			}
			
		}
%>
