<%@page import="com.spcl.erp.services.WarehouseService"%>
<%@page import="com.spcl.erp.model.Warehouse"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<% 	String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />

<body>
<%-- <jsp:include page="/WEB-INF/includes/loader.jsp"></jsp:include> --%>

<div id="pcoded" class="pcoded">
<div class="pcoded-overlay-box"></div>
<div class="pcoded-container navbar-wrapper">
<!-- Add horizantal menu here -->
<jsp:include page="/WEB-INF/includes/horizantal_nav_menu.jsp"></jsp:include>

<div class="pcoded-main-container">
<div class="pcoded-wrapper">
<!-- Add vertical menu here -->
<jsp:include page="/WEB-INF/includes/vertical_nav_menu.jsp"></jsp:include>
<div class="pcoded-content">
<div class="pcoded-inner-content">
<div class="main-body">
<div class="page-wrapper">
<!-- Add pagebody here -->
<div id="page_body" >
<div class="page-body invoice-list-page">
<div class="row">
<div class="col-xl-12 col-lg-12 filter-bar">
<!-- Navigation start -->

   <div class="page-body">
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <form id="from_operation" method="post" action="<%=contextPath%>/scrap/save_scrap" modelAttribute="scrap">
                    	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
							<input type=hidden class="form-control" id="scrap_id"name="scrap_id" value="${scrap.scrap_id}" />
                        <div class="card-header">
                            <div class="col-sm-12">
                                <h5>${opr_mode=="save"?"Add Operation":"Edit Scrap Orders"}</h5>
                                <span>Create New Scrap Order</span>
                                                        
                            </div><hr>
                        </div>
                        <div class="card-block">
                            <div class="row">
                                <div class="col-sm-6">
                                     <div class="form-group row">
				                        <label class="col-sm-3 col-form-label" style="font-size: 15px;">Operation</label>
				                        <div class="col-sm-7">
				                        <input type="text" class="form-control" name="Operation" id="Operation" >
				                        <span class="messages"></span>
				                        </div>
                   					 </div>
                                </div>
                                <div class="col-sm-6">
                                      <div class="form-group row">
					                        <label class="col-sm-3 col-form-label">Type Of Operation</label>
					                        <div class="col-sm-7">
					                            <select name="opt_type" id="opt_type" class="form-control">
					                                <option value="1">Vendor</option>
					                                <option value="2">Customers</option>
					                                <option value="3">create/Edit</option>
					                            </select>
					                        </div>
					                   </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-group row">
                                        <label class="col-sm-3 col-form-label">Reference Sequence</label>
                                       <div class="col-sm-7">
					                            <select name="opt_refer_sequ" id="opt_refer_sequ" class="form-control">
					                                <option value="1">Vendor</option>
					                                <option value="2">Customers</option>
					                                <option value="3">create/Edit</option>
					                            </select>
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
                </div>
            </div>
        </div>
    </div>        

</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>


</div>

<!-- add footer page here -->
<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>

<script>

$(document).ready(function() {
$('[data-toggle="tooltip"]').tooltip();
//Alert confirm
 $('#from_operation').bootstrapValidator()
                .on("success.form.bv", function() {
                var form = new FormData($('#from_operation')[0]);
                alert('validating form');
                //$("#file_error").text("").hide();             
                return false;
            });

$('#new_scrap').on('click', function() {
var loc=$(this).attr('rel');
$("#page_body").load(loc);
});

});


</script>


</body>




































