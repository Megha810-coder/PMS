<%@page import="com.spcl.erp.model.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<% 	String contextPath = request.getContextPath(); 
%>

<link rel="stylesheet" href="<%=contextPath %>/resources/assets/bower_components/select2/css/select2.min.css"/>
	<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
	
	<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>
	<div class="page-body">
    	<div class="row">
        	<div class="col-sm-12">
            	<!-- Basic Inputs Validation start -->
          		<div class="card">
                	<div class="card-header">
                        <h3>${opr_mode=="save"?"Add New Account Holder Details":"Edit Account Holder Details"}</h3>
                    </div>
                  	
                  	<div class="card-block">
                         <form id="add_holder" method="post" action="<%=contextPath%>/bank/save_account"  modelAttribute="account">
                         	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
							<input type=hidden class="form-control" id="acc_id"name="acc_id" value="${account.acc_id}" />
                   		
                   				 <div class="row">
                            	<div class="col-sm-6">
								<div class="row">
									<label class="col-sm-3 col-form-label" >Account Number</label>
									<div class="form-group col-sm-9"> 
									<input type="text" class="form-control" id="acc_number" name="acc_number"
									placeholder="Enter Your Account Number "
											 required data-bv-notempty-message="Please enter Account Number .">
                                    </div>
                                 	</div>
                            	<div class="row">
                                   	<label class="col-sm-3 col-form-label">Type </label>
                                    	<div class=" form-group col-sm-9">
                                        	<select type="text" class="form-control" id="acc_type" name="acc_type"
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
	                                        <select type="text" class="form-control" id="acc_holder" name="acc_holder" 
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
                                               </select>                                        </div>
                                </div>
                           		<div class="row">
	                                <label class="col-sm-3 col-form-label">Account Holder</label>
	                                    <div class=" form-group col-sm-9">
	                                        <input type="text" class="form-control" id="acc_holder1" name="acc_holder1" 
	                                        placeholder="Enter your Account Holder" 
	                                        required data-bv-notempty-message="Please enter Account Holder.">
	                                    </div>
	                             </div>
	                         </div>
	                      </div>  
								
							<div class="form-group row">
								<div class="col-sm-12">
                                	<input type="submit"  id="submit-btn"  value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"/>&nbsp;
                                	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               		<button rel="<%=contextPath %>/bank/mng_account" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
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
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/select2/js/select2.full.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	
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
    
        $('#add_holder').bootstrapValidator()
            .on("success.form.bv", function() {
           	$('#file_error').hide();
            var form = new FormData($('#add_holder')[0]);
            $.ajax({
                url: '<%=contextPath%>/bank/save_account',
                type: 'POST',
                dataType :"json",
                complete: function() {}, 
                success:  function (data) {
                	if(data.status == 1) {
                		location.href='<%=contextPath %>/bank/mng_account';
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

<%	Account account=(Account)request.getAttribute("account");
	String opr_mode=(String)request.getAttribute("opr_mode");

		if(opr_mode!=null&&account!=null){
			if(opr_mode.equals("update")){
					
			
	%>	
		<script type="text/javascript">
			$(document).ready(function() {
				$('#acc_number').val('<%=account.getAcc_number()%>');
		        $('#acc_type').val('<%=account.getAcc_type()%>');
		        $('#acc_holder').val('<%=account.getAcc_holder()%>');
		        $('#acc_bank').append('<option value="<%=account.getBank().getBnk_id()%>" selected><%=account.getBank().getBnk_name()%></option>');
		        $('#acc_holder1').val('<%=account.getAcc_holder1()%>');
		
				
			});
		</script>
<% 			}else if(opr_mode.equals("view")){ %>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#acc_number').replaceWith($("<span>",{text:'<%=account.getAcc_number()%>'}));
				$('#acc_type').replaceWith($("<span>",{text:'<%=account.getAcc_type()%>'}));
				$('#acc_holder').replaceWith($("<span>",{text:'<%=account.getAcc_holder()%>'}));
		        $('#acc_bank').append('<option value="<%=account.getBank().getBnk_id()%>" selected><%=account.getBank().getBnk_name()%></option>');
				$('#acc_holder1').replaceWith($("<span>",{text:'<%=account.getAcc_holder1()%>'}));
				
				
				$('input[type="submit"]').replaceWith('');
				$('input[type="reset"]').replaceWith('');
			});
							
		</script>

	
<%			}
			
		}
%>