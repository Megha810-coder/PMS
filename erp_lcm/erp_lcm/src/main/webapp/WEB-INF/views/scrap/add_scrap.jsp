<%@page import="com.spcl.erp.model.Scrap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<% 	
Helper helper=(Helper)request.getAttribute("helper");
%>
<% String contextPath = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
 <div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>
    <!-- Page body start -->
    <div class="page-body">
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <form id="from_scrap" method="post" action="<%=contextPath%>/scrap/save_scrap" modelAttribute="scrap">
                    	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
							<input type=hidden class="form-control" id="scrap_id"name="scrap_id" value="${scrap.scrap_id}" />
                        <div class="card-header">
                            <div class="col-sm-12">
                                <h5>${opr_mode=="save"?"Add Scrap Orders":"Edit Scrap Orders"}</h5>
                                <span>Create New Scrap Order</span>
                                                        
                            </div><hr>
                        </div>
                        <div class="card-block">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Product Name</label>
                                        <div class="col-sm-8">
                                            <select  id="scrap_pro_id" name="scrap_pro_id" required data-bv-notempty-message="Please select Product." class="form-control">
                                                <option value="">---Select Product Name---</option>
                                              		<%=helper.getProductDropDown() %>
                                                <option value="2">Create and Edit</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Quantity</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="scrap_pro_qty" name="scrap_pro_qty" required data-bv-notempty-message="Please enter quantity">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Source Document</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" name="scrap_document" id="scrap_document" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Ending Date</label>
                                        <div class="col-sm-8">
                                            <input type="text" id="scrap_date" name="scrap_date" class="form-control" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                      <input type="submit"   value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"></input>&nbsp;
                                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               <button rel="<%=contextPath %>/scrap/mng_scrap" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
                                </div>     
                            </div>
                        </div>
                    </form>
                      <c:choose>
						<c:when test = '${opr_mode=="update"}'>
									<%Scrap scrap=(Scrap)request.getAttribute("scrap");
										if(scrap!=null){
									%>
							<script type="text/javascript">
								$(document).ready(function() {
									$('#scrap_pro_id').val('<%=scrap.getScrap_id()%>');
									$('#scrap_pro_qty').val('<%=scrap.getScrap_pro_qty()%>');
									$('#scrap_document').val('<%=scrap.getScrap_document()%>');
									$('#scrap_date').val('<%=scrap.getScrap_date()%>');								
								
								});
							
							</script>
							<% }%>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test = '${opr_mode=="view"}'>
								<%Scrap scrap=(Scrap)request.getAttribute("scrap");
									if(scrap!=null){
								%>
								<script type="text/javascript">
							$(document).ready(function() {
								$('#scrap_pro_id').replaceWith($("<span>",{text:'<%=scrap.getScrap_id()%>'}));
								$('#scrap_pro_qty').replaceWith($("<span>",{text:'<%=scrap.getScrap_pro_qty()%>'}));
								$('#scrap_document').replaceWith($("<span>",{text:'<%=scrap.getScrap_document()%>'}));
								$('#scrap_date').replaceWith($("<span>",{text:'<%=scrap.getScrap_date()%>'}));								
								$('input[type="submit"]').replaceWith('');
							/* 	$('#lead_div').replaceWith(''); */
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

    <!-- data-table js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/moment/js/moment.min.js"></script>
   	<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>


    <script type="text/javascript">
          $(document).ready(function(){
           
        	  $('#scrap_date').daterangepicker({
                  singleDatePicker: true,
                  showDropdowns: true
              });
        	   $('#from_scrap').bootstrapValidator()
        	   .on("success.form.bv", function() {
   	            $('#file_error').html("").hide();
   	            var form = new FormData($('#from_scrap')[0]);
   	            $.ajax({
   	                url: '<%=contextPath %>/scrap/save_scrap',
   	                type: 'POST',
   	                dataType :"json",
   	                complete: function() {}, 
   	                success: function (data) {
   	                	if(data.status == 1) {
   	                		location.href='<%=contextPath %>/scrap/mng_scrap';
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














































