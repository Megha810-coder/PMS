<%@page import="com.spcl.erp.model.Warehouse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>

<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<div class="page-body">
 	<div class="row">
        <div class="col-sm-12">
            <div class="card" id="sub">
                <div class="card-header">
                    <h5>${opr_mode=="save"?"Add Warehouse":"Edit Warehouse"}</h5>
                    <hr>
                </div>
                <div class="card-block">
                    <form id="add_warehouse" method="post" action="<%=contextPath%>/warehouse/save_warehouse" modelAttribute="warehouse" >
                    <input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
					<input type=hidden class="form-control" id="ware_id"name="ware_id" value="${warehouse.ware_id}" />
					<!-- <input type=hidden class="form-control" id="ware_active"name="ware_active" value="1" /> -->
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-4 col-form-label">Warehouse</label>
                                    <div class="form-group col-sm-8">
                                        <input type="text" class="form-control" id="ware_name" name="ware_name" required data-bv-notempty-message="Please Enter warehouse Name." >
                                        <span class="messages"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Short Name</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="ware_short_name" name="ware_short_name" required data-bv-notempty-message="Please Enter Short Name." >
                                        <span class="messages"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Address</label>
                                    <div class="col-sm-8">
                                        <select  name="ware_addr_id" id="ware_addr_id" required data-bv-notempty-message="Please select Address." class="form-control">
                                                <option value="">---Select Product---</option>
                                                <option value="1">patil</option>
                                                <option value="2">crate/edit</option>
                                            </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="form-group row">
                                <input type="submit"   value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"></input>&nbsp;
                                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               <button rel="<%=contextPath %>/warehouse/mng_warehouse" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
                        </div> 
                        </div>
                    </form>
                </div>
                <c:choose>
					<c:when test = '${opr_mode=="update"}'>
					
						<% 	Warehouse warehouse=(Warehouse)request.getAttribute("warehouse");
			           		if(warehouse!=null){
			           	
			           	%>	
			           		<script type="text/javascript">
									$(document).ready(function() {
										$('#ware_name').val('<%=warehouse.getWare_name()%>');
										$('#ware_short_name').val('<%=warehouse.getWare_short_name()%>');
										$('#ware_addr_id').val('<%=warehouse.getWare_addr_id()%>');
										
																		
									});
								
								</script>
			           	
			           	
			           	<% }%>
						
					</c:when>
				</c:choose>
				
				<c:choose>
					<c:when test = '${opr_mode=="view"}'>
					
						<% 	Warehouse warehouse=(Warehouse)request.getAttribute("warehouse");
			           		if(warehouse!=null){
			           	
			           	%>	
			           		<script type="text/javascript">
									$(document).ready(function() {
										$('#ware_name').replaceWith($("<span>", {text: '<%=warehouse.getWare_name()%>'}));
										
										$('#ware_short_name').replaceWith($("<span>", {text:'<%=warehouse.getWare_short_name()%>'}));
										$('#ware_addr_id').replaceWith($("<span>", {text:'<%=warehouse.getWare_addr_id()%>'}));
																			
										$('input[type="submit"]').replaceWith('');
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
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	        
        $('#add_warehouse').bootstrapValidator();
        
        $('#btn-cancel').on('click', function() {
            var loc=$(this).attr('rel');
           location.href=loc;
 		});
    });
</script>
