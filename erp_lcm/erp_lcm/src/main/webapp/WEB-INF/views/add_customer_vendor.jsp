<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>

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


<!-- Page body start -->
 <div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
            <div class="card">
                <div class="card-header">
                    <h3>New</h3>
                </div>
                <div class="card-block">
                    <form id="from_add_cust_ved" method="post" action="#">
                        <div class="row form-radio">
                            <div class="radio radio-inline col-sm-2">
                                <label>
                                    <input type="radio" class="cust_type"  name="cust_type" value="1">
                                    <i class="helper"></i>Individual Person
                                </label>
                            </div>
                            <div class="radio radio-inline col-sm-2">
                                <label>
                                    <input  type="radio" class="cust_type" name="cust_type" value="
                                    2">
                                    <i class="helper"></i>Company
                                </label>
                            </div>
                        </div>
                        <hr></hr>

                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <input type="file" class="form-control" onchange="document.getElementById('cust_profile_photo_view').src = window.URL.createObjectURL(this.files[0])" id="cust_profile_photo" name="cust_profile_photo">
                                <img class="d-block img-fluid img-thumbnail" id="cust_profile_photo_view" style="height: 150px;" src="<%=contextPath %>/resources/assets/images/animate.jpg" alt="Third slide">
                            </div>
                            <div class="col-sm-6 hide_cust_name">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Name</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                            <select name="cust_title" class="form-control" required data-bv-notempty-message="Please select title.">
                                                <option value="">---Select Title---</option>
                                                <option value="Mr.">Mr.</option>
                                                <option value="Mrs.">Mrs.</option>
                                                <option value="Miss">Miss</option>
                                            </select>
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_f_name" name="cust_f_name" placeholder="Enter first name" required data-bv-notempty-message="Please enter first name.">
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_m_name" name="cust_m_name" placeholder="Enter middle name" required data-bv-notempty-message="Please enter middle name.">
                                        </div>
                                        <div class="form-group row col-sm-12">
                                            <input type="text" class="form-control" id="cust_l_name" name="cust_l_name" placeholder="Enter last name" required data-bv-notempty-message="Please enter last name.">
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
                                            <select id="cust_adds_city" name="cust_adds_city" class="form-control" required data-bv-notempty-message="Please select city.">
                                                <option value="">---Select City---</option>
                                                <option value="1">Mumbai</option>
                                                <option value="2">Pune</option>
                                                <option value="3">Nagpur</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-4 col-form-label">Extra Note( Max length 120 character)</label>
                                    <div class="col-sm-8 form-group">
                                        <textarea rows="5" cols="5" class="form-control" id="cust_extra_note" name="cust_extra_note"  placeholder="....Add a note here....."></textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">GSTN</label>
                                    <div class="form-group col-sm-9">
                                        <input type="text" class="form-control" id="cust_gstn" name="cust_gstn" placeholder="e.g. BET894583459..." required data-bv-notempty-message="Please enter gst number.">
                                    </div>
                                </div>
                                
                                <div class="row hide_cust_job_postion">
                                    <label class="col-sm-3 col-form-label">Job Position</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="text" class="form-control" id="cust_job_postion" name="cust_job_postion" placeholder="Enter job postion">
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Mobile No.</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="text" class="form-control" id="cust_contact_num" name="cust_contact_num" placeholder="Enter contact number." required data-bv-notempty-message="Please enter Mobile number." pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed" data-bv-stringlength="true"  data-bv-stringlength-min="6" data-bv-stringlength-max="10"  data-bv-stringlength-message="Mobile number should be 10 digits">
                                        
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Email</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="email" class="form-control" id="cust_email_id" name="cust_email_id" placeholder="Enter email id." required data-bv-notempty-message="Please enter email id.">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Website</label>
                                    <div class="col-sm-9 form-group">
                                        <input type="text" class="form-control" id="cust_website_link" name="cust_website_link" placeholder="Enter websiste name/link">
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
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <tr>
                                                                        <th>1</th>
                                                                        <td>Contact</td>
                                                                        <td>Mark</td>
                                                                        <td>@mdo</td>
                                                                        <td>645645</td>
                                                                        <td>Otto</td>
                                                                        
                                                                    </tr>
                                                                    <tr>
                                                                        <th>2</th>
                                                                        <td>Invoice</td>
                                                                        <td>Jacob</td>
                                                                        <td>@fat</td>
                                                                        <td>645645</td>
                                                                        <td>Otto</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <th>2</th>
                                                                        <td>shipping</td>
                                                                        <td>Larry</td>
                                                                        <td>@twitter</td>
                                                                        <td>645645</td>
                                                                        <td>Otto</td>
                                                                    </tr>
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
                                                            <input type="checkbox" id="is_customer" name="is_customer" value="">
                                                            <span class="cr">
                                                                <i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                                            </span>
                                                        </label>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Salesperson</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"  name="cust_salseperson_id" id="cust_salseperson_id">
                                                            <option value="false">---Select---</option>
                                                            <option value="1">Gopal Mankar</option><option value="2">Mayuri Ladi</option>
                                                            <option value="3">Dhanshree </option>
                                                            <option value="4">NNeha Swami</option>
                                                        </select>
                                                    </div>              
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Due days</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"  name="cust_payment_term" id="cust_payment_term">
                                                            <option value="false">---Select---</option>
                                                            <option value="1">Immediate Payment</option><option value="2">15 Days</option>
                                                            <option value="3">30 Net Days</option>
                                                            <option value="4">45 Days</option>
                                                            <option value="5">2 Months</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                
                                                
                                            </div>

                                            <div class="tab-pane" id="purchase_tab" role="tabpanel">
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Is a Customer</label>
                                                    <div class="checkbox-fade fade-in-primary">
                                                        <label class="col-sm-5 ">
                                                            <input type="checkbox" id="is_vendor" name="is_vendor" value="">
                                                            <span class="cr">
                                                                <i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                                            </span>
                                                        </label>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Due days</label>
                                                    <div class="col-sm-5">
                                                        <select class="form-control"  name="vend_payment_term" id="vend_payment_term">
                                                            <option value="false">---Select---</option>
                                                            <option value="1">Immediate Payment</option><option value="2">15 Days</option>
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
                                                            <select name="select" class="form-control">
                                                                <option value="opt1">---Select---</option>
                                                                <option value="opt2">Type 2</option>
                                                                <option value="opt3">Type 3</option>
                                                                <option value="opt4">Type 4</option>
                                                                <option value="opt5">Type 5</option>
                                                                <option value="opt6">Type 6</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group row">
                                                         <label class="col-sm-2 col-form-label">Due Account</label>
                                                         <div class="col-sm-5">
                                                            <select name="select" class="form-control">
                                                                <option value="opt1">---Select---</option>
                                                                <option value="opt2">Type 2</option>
                                                                <option value="opt3">Type 3</option>
                                                                <option value="opt4">Type 4</option>
                                                                <option value="opt5">Type 5</option>
                                                                <option value="opt6">Type 6</option>
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
                                <input type="submit" class="btn btn-primary m-b-0" value="Save">
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

<!---model for contact and address start -->
<div class="modal fade" id="large-Modal" tabindex="-1" role="dialog" style="z-index: 1050; display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <form id="from_cust_ved_adds" method="post" action="#">
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
                                <input type="radio" class="btn_radio" name="adds_type" value="0" >
                                <i class="helper"></i>Conatct
                            </label>
                        </div>
                        <div class="radio radio-inline col-sm-2" >
                            <label>
                                <input  type="radio" class="btn_radio" name="adds_type" value="1">
                                <i class="helper"></i>Invoice
                            </label>
                        </div>
                        <div class="radio radio-inline col-sm-3" >
                            <label>
                                <input  type="radio" class="btn_radio" name="adds_type" value="2">
                                <i class="helper"></i>Shipping
                            </label>
                        </div>
                        <div class="radio radio-inline col-sm-3" >
                            <label>
                                <input  type="radio" class="btn_radio" name="adds_type" value="3">
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
                    <button type="submit" class="btn btn-primary waves-effect waves-light save_adds_cust_ved ">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!---model for contact and address end-->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('#from_add_cust_ved').bootstrapValidator()
            .on("success.form.bv", function() {
            var form = new FormData($('#from_add_cust_ved')[0]);
            alert('validating form');
            //$("#file_error").text("").hide();
            return false;
        });

        $('#from_cust_ved_adds').bootstrapValidator()
            .on("success.form.bv", function() {
                var btn_val=$(this).val();
            
            if (btn_val==0) {
                $('#hide_address').hide();
            }else{
                $('#hide_address').show();
            } 

            var form = new FormData($('#from_cust_ved_adds')[0]);
            alert('validating form');
            //$("#file_error").text("").hide();
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
    });
</script>







