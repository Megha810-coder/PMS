<%@page import="com.spcl.erp.services.CustomerService"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@page import="com.spcl.erp.model.Customer "%>
<%-- <%@page import="com.spcl.erp.model.City "%>
<%@page import="com.spcl.erp.helper.Helper"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 <%
	String contextPath = request.getContextPath();
	Helper helper = (Helper)request.getAttribute("helper");
	CustomerService customerService=(CustomerService)request.getAttribute("CustomerService");
	%> 
<!-- Select 2 css -->
<link rel="stylesheet" href="<%=contextPath %>/resources/assets/bower_components/select2/css/select2.min.css"/>

<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<!-- Page-header start -->
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Vendors</h4>
                    <span>Create new vendor/customer in system.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Vendors</a>
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

<!-- Page body start -->
 <div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
            <div class="card">
                <div class="card-header">
                     <h5>${opr_mode=="save"?"New Customer":"Edit Customer"}</h5>
                </div>
                
                <div class="card-block">
                    <form id="from_add_cust_ved" method="post" action="<%=contextPath%>/customer/save_customer" modelAttribute="customer" enctype="multipart/form-data">
                    <input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
					<input type=hidden class="form-control" id="cust_id" name="cust_id" value="${customer.cust_id}" />
                        <div class="row form-radio">
                            <div class="radio radio-inline col-sm-2">
                                <label>
                                    <input type="radio" class="cust_type"  name="cust_type" id="cust_type" value="1">
                                    <i class="helper"></i>Individual Person
                                </label>
                            </div>
                            <div class="radio radio-inline col-sm-2">
                                <label>
                                    <input  type="radio" class="cust_type" name="cust_type" id="cust_type" value="
                                    2">
                                    <i class="helper"></i>Company
                                </label>
                            </div>
                        </div>
                        <hr></hr>

                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <input type="file" class="form-control" onchange="document.getElementById('cust_profile_photo_view').src = window.URL.createObjectURL(this.files[0])" id="cust_profile_photo" name="cust_profile_photo">
                                <img class="d-block img-fluid img-thumbnail" 
                                	id="cust_profile_photo_view" 
                                	style="height: 150px;" 
                                	src="<%=contextPath %>/resources/cust_img/${customer.cust_img_code }" 
                                	alt="Preview Photo here....">
                            </div>
                            <div class="col-sm-6 hide_cust_name">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Name</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                            <select name="cust_title" id="cust_title" class="form-control" required data-bv-notempty-message="Please select title.">
                                                <option value="">---Select Title---</option>
                                                <option value="Mr.">Mr.</option>
                                                <option value="Mrs.">Mrs.</option>
                                                <option value="Miss">Miss</option>
                                            </select>
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_fname" name="cust_fname" placeholder="Enter first name" required data-bv-notempty-message="Please enter first name.">
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_mname" name="cust_mname" placeholder="Enter middle name" required data-bv-notempty-message="Please enter middle name.">
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_lname" name="cust_lname" placeholder="Enter last name" required data-bv-notempty-message="Please enter last name.">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row" id="hide_cust_comp_name">
                            <label class="col-sm-2 col-form-label">Company Name</label>
                            <div class="col-sm-4 form-group">
                                <input type="text" class="form-control" id="cust_comp_name" name="cust_comp_name" placeholder="Enter company name" required data-bv-notempty-message="Please enter company name.">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-4 col-form-label">Address</label>
                                    <div class="col-sm-8">
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_adds_line1" name="cust_adds_line1" placeholder="Address Line 1" required data-bv-notempty-message="Please enter adds first line.">
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_adds_line2" name="cust_adds_line2" placeholder="Address Line 2">
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <select id="cust_city_id" name="cust_city_id" class="form-control" required data-bv-notempty-message="Please select city.">
                                                <option value="">---Select City---</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-4 col-form-label">Extra Note( Max length 120 character)</label>
                                    <div class="col-sm-8 form-group">
                                        <textarea rows="5" cols="5" class="form-control" id="cust_description" name="cust_description"  placeholder="....Add a note here....."></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">GSTN</label>
                                    <div class="form-group col-sm-9">
                                        <input type="text" class="form-control" id="cust_gst_no" name="cust_gst_no" placeholder="e.g. BET894583459..." required data-bv-notempty-message="Please enter gst number.">
                                    </div>
                                </div>
                               
                                <div class="row hide_cust_job_postion">
                                    <label class="col-sm-3 col-form-label">Job Position</label>
                    			
                    				<div class="col-sm-9 form-group">
                    					<select id="cust_job_position_id" name="cust_job_position_id" class=" col-sm-6 form-control" required data-bv-notempty-message="Please select Job Position">
	                                        <option value="">---Select Job Position---</option>
	                                        <option value="1">Sales Manager</option>
	                                        <option value="2">Executive</option>
	                                        <option value="3">Marketing Executive</option>
	                                    </select>
                    				</div>
                                </div>
                              
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Mobile No.</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="text" class="form-control" id="cust_phone" name="cust_phone" placeholder="Enter contact number." required data-bv-notempty-message="Please enter Mobile number." pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed" data-bv-stringlength="true"  data-bv-stringlength-min="6" data-bv-stringlength-max="10"  data-bv-stringlength-message="Mobile number should be 10 digits">
                                        
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Email</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="email" class="form-control" id="cust_email" name="cust_email" placeholder="Enter email id." required data-bv-notempty-message="Please enter email id.">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Website</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="text" class="form-control" id="cust_website" name="cust_website" placeholder="Enter websiste name/link">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-12">
                                <div class="row m-b-30">
                                    <div class="col-lg-12 col-sm-12">
                                        <ul class="nav nav-tabs md-tabs" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" data-toggle="tab" href="#contact_address" role="tab">Contact & Addresses</a>
                                                <div class="slide"></div>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" data-toggle="tab" href="#sales_tab" role="tab">Sales</a>
                                                <div class="slide"></div>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" data-toggle="tab" href="#purchase_tab" role="tab">Purchase</a>
                                                <div class="slide"></div>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" data-toggle="tab" href="#account_tab" role="tab">Accounts</a>
                                            <div class="slide"></div>
                                            </li>
                                        </ul>
                                        <!-- Tab panes -->
                                        <div class="tab-content card-block">

                                            <div class="tab-pane active" id="contact_address" role="tabpanel">
                                                <div class="row">
                                                    <div class="col-sm-12">
                                                         <button type="button" class="btn btn-primary waves-effect" data-toggle="modal" data-target="#large-Modal">Add</button>
                                                    </div>
                                                </div>

                                                <div class="row"> 
                                                    <div class="col-sm-12">
                                                         <div class="table-responsive">
                                                            <table class="table table-xs table-hover table-bordered">
                                                                <thead>
                                                                    <tr>
                                                                        <th>#</th>
                                                                        <th>Type</th>
                                                                        <th>Contact Name</th>
                                                                        <th>Email</th>
                                                                        <th>Contact</th>
                                                                        <th>City</th>
                                                                        <th>Action</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="prod_cart_row">
                                                                </tbody>    
                                                            </table>
                                                        </div>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                            
                                            <div class="tab-pane" id="sales_tab" role="tabpanel">
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Is a Customer</label>
                                                    <div class="checkbox-fade fade-in-primary">
                                                        <label class="col-sm-5 ">
                                                            <input type="checkbox" id="cust_cust" name="cust_cust" value="1">
                                                            <span class="cr">
                                                                <i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                                            </span>
                                                        </label>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Salesperson</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"  name="cust_saleperson_id" id="cust_saleperson_id">
                                                            <option value="false">---Select---</option>
                                                            <option value="1">Gopal Mankar</option>
                                                            <option value="2">Mayuri Ladi</option>
                                                            <option value="3">Dhanshree </option>
                                                            <option value="4">NNeha Swami</option>
                                                        </select>
                                                    </div>              
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Due days</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"  name="cust_payment_term_id" id="cust_payment_term_id">
                                                            <option value="false">---Select---</option>
                                                            <option value="1">Immediate Payment</option>
                                                            <option value="2">15 Days</option>
                                                            <option value="3">30 Net Days</option>
                                                            <option value="4">45 Days</option>
                                                            <option value="5">2 Months</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                
                                                
                                            </div>

                                            <div class="tab-pane" id="purchase_tab" role="tabpanel">
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Is a Vendor</label>
                                                    <div class="checkbox-fade fade-in-primary">
                                                        <label class="col-sm-5 ">
                                                            <input type="checkbox" id="cust_vendor" name="cust_vendor" value="1">
                                                            <span class="cr">
                                                                <i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                                            </span>
                                                        </label>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Due days</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"  name="cust_vend_payment_term" id="cust_vend_payment_term">
                                                            <option value="">---Select---</option>
                                                            <option value="1">Immediate Payment</option>
                                                            <option value="2">15 Days</option>
                                                            <option value="3">30 Net Days</option>
                                                            <option value="4">45 Days</option>
                                                            <option value="5">2 Months</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            <div class="tab-pane" id="account_tab" role="tabpanel">
                                                <div class="page-body">
                                                    <div class="table-responsive">
                                                        <table class="table table-striped table-bordered" id="example-1">
                                                            <thead>
                                                              <tr>
                                                                <th>#</th>
                                                                <th>Bank Name</th>
                                                                <th>Account Number</th>
                                                              </tr>
                                                            </thead>
                                                            <tbody>
                                                              <tr>
                                                                <td></td>
                                                                <td></td>
                                                                <td></td>
                                                              </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <button type="button" class="btn btn-primary waves-effect waves-light add">Add Row
                                                    </button>
                                                    <div class="form-group row">
                                                        <label class="col-sm-2 col-form-label">Account Payable</label>
                                                        <div class="col-sm-5">
                                                            <select name="cust_acc_pay_id" id="cust_acc_pay_id" class="form-control">
                                                                <option value="">---Select---</option>
                                                                <option value="1">Type 2</option>
                                                                <option value="2">Type 3</option>
                                                                <option value="3">Type 4</option>
                                                                <option value="4">Type 5</option>
                                                               
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                         <label class="col-sm-2 col-form-label">Due Account</label>
                                                         <div class="col-sm-5">
                                                            <select name="cust_acc_due_id" id="cust_acc_due_id" class="form-control">
                                                                <option value="">---Select---</option>
                                                                <option value="1">Type 2</option>
                                                                <option value="2">Type 3</option>
                                                                <option value="3">Type 4</option>
                                                                <option value="4">Type 5</option>
                                                                <option value="5">Type 6</option>
                                                            </select>
                                                        </div>
                                                    </div>  
                                                </div>     
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                               	<input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         	<button rel="<%=contextPath %>/customer/mng_customer" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	                     	
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Basic Inputs Validation end -->
        </div>
    </div>
 </div>
<!-- Page body end -->

<c:choose>
	<c:when test = '${opr_mode=="update"}'>
		<% 	Customer customer=(Customer)request.getAttribute("customer");
			if(customer!=null){
		%>
		<script type="text/javascript">
			$(document).ready(function() {
				<% if(customer.getCust_type()==1){ %>
				$('#cust_type').prop('checked', true);
				<%	} %>
				
				<% if(customer.getCust_type()==2){ %>
					$('#cust_type').prop('checked', true);
				<%	}%>
				
				
				$('#cust_title').val('<%=customer.getCust_title()%>');
				
				<%-- <% if(customer.getCust_type()==1){ %>
					$('#cust_type').prop('checked', true);
				<%	}else{ %>
				<% if(customer.getCust_type()==2){ %>
					$('#cust_type').prop('checked', true);
				<%	}}%> --%>
				
				$('#cust_fname').val('<%=customer.getCust_fname()%>');
				$('#cust_mname').val('<%=customer.getCust_mname()%>');
				$('#cust_lname').val('<%=customer.getCust_lname()%>');
				
				$('#cust_comp_name').val('<%=customer.getCust_comp_name()%>');
				$('#cust_phone').val('<%=customer.getCust_phone()%>');
				$('#cust_email').val('<%=customer.getCust_email()%>');
				$('#cust_website').val('<%=customer.getCust_website()%>');
				<% if(customer.getCust_cust()==1){ %>
				$('#cust_cust').prop('checked', true);
				<%	} %>
				
				<% if(customer.getCust_vendor()==1){ %>
					$('#cust_vendor').prop('checked', true);
				<%	}%>
				
				$('#cust_gst_no').val('<%=customer.getCust_gst_no()%>');
				$('#cust_addr_id').val('<%=customer.getCust_addr_id()%>');
				$('#cust_job_position_id').val('<%=customer.getCust_job_position_id()%>');
				$('#cust_description').val('<%=customer.getCust_description()%>');
				$('#cust_saleperson_id').val('<%=customer.getCust_saleperson_id()%>');
				
				$('#cust_bank_id').val('<%=customer.getCust_bank_id()%>');
				$('#cust_payment_term_id').val('<%=customer.getCust_payment_term_id()%>');
				$('#cust_vend_payment_term').val('<%=customer.getCust_vend_payment_term()%>');
				$('#cust_acc_pay_id').val('<%=customer.getCust_acc_pay_id()%>');
				$('#cust_acc_due_id').val('<%=customer.getCust_acc_due_id()%>');
				
				$('#cust_adds_line1').val('<%=customer.getCust_adds_line1()%>');
				$('#cust_adds_line2').val('<%=customer.getCust_adds_line2()%>');
				$('#cust_city_id').append('<option value="<%=customer.getEnq_city().getCity_id().intValue()%>" selected><%=customer.getEnq_city().getCity_name()%></option>');
				
																					
			});
				
		</script>
		<% }%>
	</c:when>
</c:choose>

<c:choose>
	<c:when test = '${opr_mode=="view"}'>
		<% 	Customer customer=(Customer)request.getAttribute("customer");
			if(customer!=null){
		%>
		<script type="text/javascript">
			$(document).ready(function() {
			<% if(customer.getCust_type()==1){ %>
				$('#cust_type').prop('checked', true);
				$('#cust_type').attr('readonly', true);
			<%	} else{%>
			<% if(customer.getCust_type()==2){ %>
				$('#cust_type').prop('checked', true);
				$('#cust_type').attr('readonly', true);
			<%	} }%>
		
				$('#cust_title').closest("div"). replaceWith($("<span>", {text: '<%=customerService.getCustomerByFullName(customer)%>'}));
				$('#cust_fname').closest("div").replaceWith('');
				$('#cust_mname').closest("div").replaceWith('');
				$('#cust_lname').closest("div").replaceWith('');
				
				$('#cust_comp_name').replaceWith($("<span>", {text: '<%=customer.getCust_comp_name() %>'}));
				$('#cust_phone').replaceWith($("<span>", {text: '<%=customer.getCust_phone()%>'}));
				$('#cust_email').replaceWith($("<span>", {text: '<%=customer.getCust_email()%>'}));
				$('#cust_website').replaceWith($("<span>", {text: '<%=customer.getCust_website() %>'}));
				
				<% if(customer.getCust_cust()==1){ %>
					$('#cust_cust').prop('checked', true);
					$('#cust_cust').attr('readonly', true);
				<%	} %>
				<% if(customer.getCust_vendor()==1){ %>
					$('#cust_vendor').prop('checked', true);
					$('#cust_vendor').attr('readonly', true);
				<%	} %>
				
				$('#cust_gst_no').replaceWith($("<span>", {text: '<%=customer.getCust_gst_no() %>'}));
				$('#cust_addr_id').replaceWith($("<span>", {text: '<%=customer.getCust_website() %>'}));
				$('#cust_job_position_id').replaceWith($("<span>", {text: '<%=customer.getCust_job_position_id() %>'}));
				
				$('#cust_description').replaceWith($("<span>", {text:'<%=customer.getCust_description()%>'}));
				$('#cust_saleperson_id').replaceWith($("<span>", {text: '<%=customer.getCust_saleperson_id() %>'}));
				$('#cust_bank_id').replaceWith($("<span>", {text: '<%=customer.getCust_bank_id() %>'}));
				$('#cust_payment_term_id').replaceWith($("<span>", {text: '<%=customer.getCust_payment_term_id() %>'}));
				$('#cust_vend_payment_term').replaceWith($("<span>", {text: '<%=customer.getCust_vend_payment_term() %>'}));
				$('#cust_acc_pay_id').replaceWith($("<span>", {text: '<%=customer.getCust_acc_pay_id() %>'}));
				$('#cust_acc_due_id').replaceWith($("<span>", {text: '<%=customer.getCust_acc_due_id() %>'}));
				
				
				$('#cust_adds_line1').replaceWith($("<span>", {text: '<%=customer.getCust_adds_line1() %>'}));
				$('#cust_adds_line2').replaceWith($("<span>", {text: '<%=customer.getCust_adds_line2() %>'}));
				
				$('#cust_city_id').replaceWith($("<span>", {text: '<%=customer.getEnq_city().getCity_name() %>'}));
													
				$('input[type="submit"]').replaceWith('');
				
				$('input[type="reset"]').replaceWith('');
			
			
			});
			
		</script>
		<% }%>
	</c:when>
</c:choose>





<!---model for contact and address start -->
	<div class="modal fade" id="large-Modal" tabindex="-1" role="dialog" style="z-index: 1050; display: none;" aria-hidden="true">
	   <div class="modal-dialog modal-lg" role="document">
	       <div class="modal-content">
	           <form id="from_cust_ved_adds" method="post" action="javascript:void(0);">
	               <div class="modal-header">
	                   <h4 class="modal-title">Add new address</h4>
	                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                       <span aria-hidden="true">x</span>
	                   </button>
	               </div>
	               <div class="modal-body">
	                   
	                   <div class="col-sm-12 form-radio">
	                       <div class="radio radio-inline col-sm-2">
	                           <label>
	                               <input type="radio" class="btn_radio" name="adds_type" data-name="contact" value="0" >
	                               <i class="helper"></i>Conatct
	                           </label>
	                       </div>
	                       <div class="radio radio-inline col-sm-2" >
	                           <label>
	                               <input  type="radio" class="btn_radio" name="adds_type" data-name="invoice" value="1">
	                               <i class="helper"></i>Invoice
	                           </label>
	                       </div>
	                       <div class="radio radio-inline col-sm-3" >
	                           <label>
	                               <input  type="radio" class="btn_radio" name="adds_type" data-name="shipping" value="2">
	                               <i class="helper"></i>Shipping
	                           </label>
	                       </div>
	                       <div class="radio radio-inline col-sm-3" >
	                           <label>
	                               <input  type="radio" class="btn_radio" name="adds_type" data-name="private" value="3">
	                               <i class="helper"></i>Private
	                           </label>
	                       </div>
	                   </div>
	                   <hr></hr>
	
	                   <div class="row">
	                       <div class="col-sm-6">
	                           <div class="row">
	                               <label class="col-sm-3 col-form-label">Contact name</label>
	                               <div class="form-group col-sm-9">
	                                   <input type="text" class="form-control" id="adds_contact_name" name="adds_contact_name" placeholder="Enter contact name." required data-bv-notempty-message="Please enter contact name.">
	                               </div>
	                           </div>
	                           
	                           <div class="row">
	                               <label class="col-sm-3 col-form-label">Job Position</label>
	                               <div class="col-sm-9 form-group">
	                                   <input type="text" class="form-control" id="adds_contact_job_postion" name="adds_contact_job_postion" placeholder="Enter job postion">
	                               </div>
	                           </div>
	                           <div class="row">
	                               <label class="col-sm-3 col-form-label">Mobile No.</label>
	                               <div class="col-sm-9 form-group">
	                                   <input type="text" class="form-control" id="adds_contact_num" name="adds_contact_num" placeholder="Enter contact number." required data-bv-notempty-message="Please enter Mobile number." pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed" data-bv-stringlength="true"  data-bv-stringlength-min="6" data-bv-stringlength-max="10"  data-bv-stringlength-message="Mobile number should be 10 digits">
	                                   
	                               </div>
	                           </div>
	                           <div class="row">
	                               <label class="col-sm-3 col-form-label">Email</label>
	                               <div class="col-sm-9 form-group">
	                                   <input type="email" class="form-control" id="adds_email_id" name="adds_email_id" placeholder="Enter email id." required data-bv-notempty-message="Please enter email id.">
	                               </div>
	                           </div>
	                       </div>
	
	                       <div class="col-sm-6">
	                           <div class="row" id="hide_address">
	                               <label class="col-sm-4 col-form-label">Address</label>
	                               <div class="col-sm-8">
	                                   <div class="form-group row col-sm-12">
	                                       <input type="text" class="form-control" id="adds_line1" name="adds_line1" placeholder="Address Line 1" required data-bv-notempty-message="Please enter adds first line.">
	                                   </div>
	                                   <div class="form-group row col-sm-12">
	                                       <input type="text" class="form-control" id="adds_line2" name="adds_line2" placeholder="Address Line 2">
	                                   </div>
	                                   <div class="form-group row col-sm-12">
	                                       <select id="adds_city" name="adds_city" class="form-control" required data-bv-notempty-message="Please select city.">
	                                           <option value="">---Select City---</option>
	                                           <option value="1">Mumbai</option>
	                                           <option value="2">Pune</option>
	                                           <option value="3">Nagpur</option>
	                                       </select>
	                                   </div>
	                               </div>
	                           </div>
	                           <div class="row">
	                               <label class="col-sm-4 col-form-label">Extra Note <p>( Max length 120 character)</p></label>
	                               <div class="col-sm-8 form-group">
	                                   <textarea rows="5" cols="5" class="form-control" id="adds_extra_note" name="cust_extra_note"  placeholder="....Add a note here....."></textarea>
	                               </div>
	                           </div>
	                       </div>
	                   </div>
	                   
	               </div>
	               <div class="modal-footer">
	                   <button type="button" class="btn btn-default waves-effect " data-dismiss="modal">Close</button>
	                   <button type="submit" class="btn btn-primary waves-effect waves-light save_adds_cust_ved add_vendor_row " >Save changes</button>
	               </div>
	           </form>
	       </div>
	 	</div>
	</div>
<!---model for contact and address end-->
<!-- Select 2 js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/select2/js/select2.full.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
    	
    	$('#cust_city_id').select2({
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
    	
        $('#from_add_cust_ved').bootstrapValidator()
       		.on("success.form.bv", function() {
	            $('#file_error').html("").hide();
	            var form = new FormData($('#from_add_cust_ved')[0]);
	            $.ajax({
	                url: '<%=contextPath %>/customer/save_customer',
	                type: 'POST',
	                dataType :"json",
	                complete: function() {}, 
	                success: function (data) {
	                	if(data.status == 1) {
	                		location.href='<%=contextPath %>/customer/mng_customer';
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
	
        
        
        var cust_address_list=[];
        var idx_num=1;
        var decimal_format=2;
    	var index=1;
    	
        $('#from_cust_ved_adds').bootstrapValidator()
            .on("success.form.bv", function() {
                var btn_val=$(this).val();
            
	            if (btn_val==0) {
	                $('#hide_address').hide();
	            }else{
	                $('#hide_address').show();
	            } 
	
	            var form = new FormData($('#from_cust_ved_adds')[0]);
	            
				var cust_ved_array=[];
            	
            	var radioValue = $("input[name='adds_type']:checked").data("name");
            	cust_ved_array.push(radioValue);
            	
                var adds_contact_name = $("#adds_contact_name").val();
                cust_ved_array.push(adds_contact_name);
                
                var adds_contact_job_postion = $("#adds_contact_job_postion").val();
                cust_ved_array.push(adds_contact_job_postion);
                
                var adds_contact_num = $("#adds_contact_num").val();
                cust_ved_array.push(adds_contact_num);
                
                var adds_email_id =$("#adds_email_id").val();
                cust_ved_array.push(adds_email_id);
                
                var adds_line1=$('#adds_line1').val();
                cust_ved_array.push(adds_line1);
                
                var adds_line2=$('#adds_line2').val();
                cust_ved_array.push(adds_line2);
                
                var adds_city = $("#adds_city option:selected").html();
                cust_ved_array.push(adds_city);
          
                var adds_extra_note=$('#adds_extra_note').val();
                cust_ved_array.push(adds_extra_note);
                
               // document.getElementById("demo").innerHTML = cust_ved_array;


                var html_txt="<tr>"+
              					 "<td>"+index+"</td>"+
               					 
             				 	 "<td>"+radioValue+"</td>"+
               				  
                                "<td>"+adds_contact_name+"</td>"+

                                "<td>"+adds_email_id+"</td>"+
                                
                                "<td>"+adds_contact_num+"</td>"+

                                "<td>"+adds_city+"</td>"+
                                
                                "<td class='action-icon text-center'>"+
                                "<a href='javascript:void(0);' class='text-muted' id='remv_prod_cart_"+index+"' data-toggle='tooltip' data-placement='top' title='Renove' data-original-title='Remonve'><i class='icofont icofont-delete-alt'></i></a>"+
                            "</td>"+

                            "</tr>";

                	$("#prod_cart_row").append(html_txt);
                
                	cust_address_list.push(cust_ved_array);
                
               	 	$('#remv_prod_cart_'+index).on("click", function() {
                    	$(this).closest("tr").remove();
                    	cust_address_list.pop(cust_ved_array.index);
                    	$.each(cust_address_list, function(index, val) {
                        	console.log(val);
                    	});
                	});
            	
                	$.each(cust_address_list, function(index, val) {
                    	console.log(val);
                	});
            	index++;
            	$('.add_vendor_row').attr('disabled',false);
           
            return false;
        });

        $('.btn_radio').on("click", function() {
            var btn_val=$(this).val();
            
            if (btn_val==0) {
                $('#hide_address').hide();
            }else{
                $('#hide_address').show();
            }       
            
        });
        $('.cust_type').on("click", function() {
            var btn_val=$(this).val();
            
            if (btn_val==1) {
                $('.hide_cust_name').show();
                $('#hide_cust_comp_name').hide();
                $('.hide_cust_job_postion').show();

            }else{
                $('.hide_cust_name').hide();
                $('#hide_cust_comp_name').show();
                $('.hide_cust_job_postion').hide();
                
            }       
            
        });
        
        $('#btn-cancel').on('click', function() {
            var loc=$(this).attr('rel');
           	location.href=loc;
 		});
        
        
        
        
        
        
    });
</script>







