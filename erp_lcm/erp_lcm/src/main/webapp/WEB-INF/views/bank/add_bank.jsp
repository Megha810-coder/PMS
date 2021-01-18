<%@page import="com.spcl.erp.model.Bank"%>
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
                        <h3>${opr_mode=="save"?"Add New Bank Details":"Edit Bank Details"}</h3>
                    </div>
                  	
                  	<div class="card-block">
                         <form id="add_bnk" method="post" action="<%=contextPath%>/bank/save_bank"  modelAttribute="bank">
                         	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
							<input type=hidden class="form-control" id="bnk_id"name="bnk_id" value="${bank.bnk_id}" />
                        
                         	<div class="row">
                            	<div class="col-sm-6">
                                    <div class="row">
                                    	<label class="col-sm-3 col-form-label">Name</label>
                                       	<div class="form_group col-sm-9">
                                        	<input type="text" class="form-control" id="bnk_name" 
                                           		name="bnk_name" placeholder="Enter your Bank name" 
                                           		required data-bv-notempty-message="Please enter Bank name." >
                                    	</div>
                            		</div>
                           		</div>

								<div class="col-sm-6">
									<div class="row">
										<label class="col-sm-3 col-form-label"> Bank Identifier Code</label>
										<div class=" form-group col-sm-9">
                                        	<input type class="form-control" id="bnk_id_code" name="bnk_id_code" 
                                           	placeholder="Enter your bank identifier code" 
                                           	required data-bv-notempty-message="Please enter bank identifier code" >
                                    	</div>
                                	</div>
                           		</div>
							</div>
							<br>
							
							 <div class="row">
                            	<div class="col-sm-6">
								<div class="row">
									<label class="col-sm-3 col-form-label" ><b>Address</b></label>
                                    <div class="form-group col-sm-9"> </div>
                                 	</div>
                            	<div class="row">
                                   	<label class="col-sm-3 col-form-label"> </label>
                                    	<div class=" form-group col-sm-9">
                                        	<input type="text" class="form-control" id="street1" name="bnk_address.add_line1"
                                        	 placeholder="Street1"
											 required data-bv-notempty-message="Please enter street details.">
                                        </div>
                                </div>
                           		<div class="row">
	                                <label class="col-sm-3 col-form-label"></label>
	                                    <div class=" form-group col-sm-9">
	                                        <input type="text" class="form-control" id="street2" name="bnk_address.add_line2" 
	                                        placeholder="Street2" 
	                                        required data-bv-notempty-message="Please enter street details.">
	                                    </div>
	                             </div>
	                             <div class="row">
	                                <label class="col-sm-3 col-form-label"></label>
	                                    <div class=" form-group col-sm-9">
	                                        <select id="bnk_city_id" name="bnk_address.enq_city.city_id" class="form-control" required data-bv-notempty-message="Please select city.">
                                                <option value="">---Select City---</option>
                                            </select>
	                                    </div>
	                             </div>
	                         </div>
         					<div class="col-sm-6">
								<div class="row">
									<label class="col-sm-12 col-form-label" ><b>Communication</b></label>
                                    
                                 	</div>
                            	<div class="row">
                                   	<label class="col-sm-3 col-form-label">Contact no </label>
                                    	<div class=" form-group col-sm-9">
                                        	<input type="text" class="form-control" id="bnk_phone" name="bnk_phone"
                                        	 placeholder="Enter contact number."
											 required data-bv-notempty-message="Enter contact number.">
                                        </div>
                                </div>
                           		<div class="row">
	                                <label class="col-sm-3 col-form-label">Email</label>
	                                    <div class=" form-group col-sm-9">
	                                        <input type="email" class="form-control" id="bnk_email" name="bnk_email" 
	                                        placeholder="Enter email id" 
	                                        required data-bv-notempty-message="Please enter email-id.">
	                                    </div>
	                             </div>
	                         </div>
	                      </div>  
								
							<div class="form-group row">
								<div class="col-sm-12">
                                	<input type="submit"  id="submit-btn"  value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"/>&nbsp;
                                	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               		<button rel="<%=contextPath %>/bank/mng_bank" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
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
    	$('#bnk_city_id').select2({
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
    
        $('#add_bnk').bootstrapValidator()
            .on("success.form.bv", function() {
           	$('#file_error').hide();
            var form = new FormData($('#add_bnk')[0]);
            $.ajax({
                url: '<%=contextPath%>/bank/save_bank',
                type: 'POST',
                dataType :"json",
                complete: function() {}, 
                success:  function (data) {
                	if(data.status == 1) {
                		location.href='<%=contextPath %>/bank/mng_bank';
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

<%	Bank bank=(Bank)request.getAttribute("bank");
	String opr_mode=(String)request.getAttribute("opr_mode");

		if(opr_mode!=null&&bank!=null){
			if(opr_mode.equals("update")){
					
			
	%>	
		<script type="text/javascript">
			$(document).ready(function() {
				$('#bnk_name').val('<%=bank.getBnk_name()%>');
		        $('#bnk_id_code').val('<%=bank.getBnk_id_code()%>');
		        $('#street1').val('<%=bank.getBnk_address().getAdd_line1()%>');
		        $('#street2').val('<%=bank.getBnk_address().getAdd_line2()%>');
		        $('#bnk_city_id').append('<option value="<%=bank.getBnk_address().getEnq_city().getCity_id().intValue()%>" selected><%=bank.getBnk_address().getEnq_city().getCity_name()%></option>');
		        $('#bnk_phone').val('<%=bank.getBnk_phone()%>');
		        $('#bnk_email').val('<%=bank.getBnk_email()%>');
		
				
			});
		</script>
<% 			}else if(opr_mode.equals("view")){ %>
		
		<script type="text/javascript">
			$(document).ready(function() {
				$('#bnk_name').replaceWith($("<span>",{text:'<%=bank.getBnk_name()%>'}));
				$('#bnk_id_code').replaceWith($("<span>",{text:'<%=bank.getBnk_id_code()%>'}));
				$('#street1').replaceWith($("<span>",{text:'<%=bank.getBnk_address().getAdd_line1()%>'}));
				$('#street2').replaceWith($("<span>",{text:'<%=bank.getBnk_address().getAdd_line2()%>'}));
				$('#bnk_city_id').append('<option value="<%=bank.getBnk_address().getEnq_city().getCity_id().intValue()%>" selected><%=bank.getBnk_address().getEnq_city().getCity_name()%></option>');
		        $('#bnk_phone').replaceWith($("<span>",{text:'<%=bank.getBnk_phone()%>'}));
				$('#bnk_email').replaceWith($("<span>",{text:'<%=bank.getBnk_email()%>'}));
				
				
				$('input[type="submit"]').replaceWith('');
				$('input[type="reset"]').replaceWith('');
			});
							
		</script>

	
<%			}
			
		}
%>
