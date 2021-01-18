<%@page import="com.spcl.erp.model.Reorder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<%@page import="com.spcl.erp.helper.Helper"%>
<% 	
Helper helper=(Helper)request.getAttribute("helper");
%>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
 <div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>
<!-- Page-header start -->
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Reordering</h4>
                    <span>Create new Reorder.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Reorder</a>
                    </li>
                     <li class="breadcrumb-item"><a href="#!">New</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Page-header end -->



<div class="page-body">
 	<div class="row">
        <div class="col-sm-12">
            <div class="card" id="sub">
                <div class="card-header">
                    <h5>${opr_mode=="save"?"Add Reordering Rules":"Edit Reordering Rules"}</h5><hr>
                </div>
                <div class="card-block">
                    <form id="form_recording" method="post" action="<%=contextPath%>/reorder/save_reorder" modelAttribute="reorder">
                      <input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
						<input type=hidden class="form-control" id="reor_id"name="reor_id" value="${reorder.reor_id}" />
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Name</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="reor_name" name="reor_name" required data-bv-notempty-message="Please Enter Name.">
                                    </div>
                                </div>
                            </div>
                             <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Product</label>
                                    <div class="col-sm-8">
                                      <select  id="reor_pro_id" name="reor_pro_id" name="record_product"  required data-bv-notempty-message="Please select Product." class="form-control">
                                            <option value="">---Select Product---</option>
                                            <%=helper.getProductDropDown() %>
                                            <option value="2">Create and Edit</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                         <label class="col-sm-4 col-form-label" style="font-size: 20px;">Rules</label>
                         <br>
                         <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Minimum Quantity</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="reor_Miniqty" name="reor_Miniqty" required data-bv-notempty-message="Please Enter Minimum Quantity.">
                                        <span class="messages"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Maximum Quantity</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" required data-bv-notempty-message="Please Enter Maximum Quantity." id="reor_Maxqty" name="reor_Maxqty" >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Quantity Multiple</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="reor_Qty_Mul" name="reor_Qty_Mul" required data-bv-notempty-message="Please Enter Quantity Multiple.">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6" id="lead_div">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Lead Time</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="reor_Lead_time" name="reor_Lead_time" placeholder="Number of Days ">
                                         </div>
                                        <div class="col-sm-4" >
                                            <select  name="LeadT"  required data-bv-notempty-message="Please select Lead Time." class="form-control">
                                                <option value="">---Select Product---</option>
                                                <option value="1">Day(s) to get the products</option>
                                                <option value="2">Day(s) to purchase</option>
                                            </select>
                                    </div>
                                </div>
                            </div>
                       </div>
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <input type="submit"   value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"></input>&nbsp;
                                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               <button rel="<%=contextPath %>/reorder/mng_reorder" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
                            </div>
                        </div>
                    </form>
                     <c:choose>
						<c:when test = '${opr_mode=="update"}'>
									<%Reorder reorder=(Reorder)request.getAttribute("reorder");
										if(reorder!=null){
									%>
							<script type="text/javascript">
								$(document).ready(function() {
									$('#reor_name').val('<%=reorder.getReor_name()%>');
									$('#reor_pro_id').val('<%=reorder.getReor_pro_id()%>');
									$('#reor_Miniqty').val('<%=reorder.getReor_Miniqty()%>');
									$('#reor_Maxqty').val('<%=reorder.getReor_Maxqty()%>');								
									$('#reor_Qty_Mul').val('<%=reorder.getReor_Qty_Mul()%>');
									$('#reor_Lead_time').val('<%=reorder.getReor_Lead_time()%>');
								/* 	$('#lead_div').replaceWith(''); */
								});
							
							</script>
							<% }%>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test = '${opr_mode=="view"}'>
								<%Reorder reorder=(Reorder)request.getAttribute("reorder");
									if(reorder!=null){
								%>
								<script type="text/javascript">
							$(document).ready(function() {
								$('#reor_name').replaceWith($("<span>",{text:'<%=reorder.getReor_name()%>'}));
								$('#reor_pro_id').replaceWith($("<span>",{text:'<%=reorder.getReor_pro_id()%>'}));
								$('#reor_Miniqty').replaceWith($("<span>",{text:'<%=reorder.getReor_Miniqty()%>'}));
								$('#reor_Maxqty').replaceWith($("<span>",{text:'<%=reorder.getReor_Maxqty()%>'}));								
								$('#reor_Qty_Mul').replaceWith($("<span>",{text:'<%=reorder.getReor_Qty_Mul()%>'}));
								$('#reor_Lead_time').replaceWith($("<span>",{text:'<%=reorder.getReor_Lead_time()%>'}));
								$('input[type="submit"]').replaceWith('');
								$('#lead_div').replaceWith('');
								$('input[type="reset"]').replaceWith('');
							});
						
						</script>
						<% }%>
					</c:when>
				</c:choose>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function(){
     $('#form_recording').bootstrapValidator()
      .on("success.form.bv", function() {
   	            $('#file_error').html("").hide();
   	            var form = new FormData($('#form_recording')[0]);
   	            $.ajax({
   	                url: '<%=contextPath %>/reorder/save_reorder',
   	                type: 'POST',
   	                dataType :"json",
   	                complete: function() {}, 
   	                success: function (data) {
   	                	if(data.status == 1) {
   	                		location.href='<%=contextPath %>/reorder/mng_reorder';
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