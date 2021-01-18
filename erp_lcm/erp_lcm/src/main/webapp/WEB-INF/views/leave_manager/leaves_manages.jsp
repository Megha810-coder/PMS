<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<div class="page-body">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
          <div class="card">
                <div class="card-header">
                          <h5>Add Expenses</h5>
                             </div>
                            <div class="card-block">
                                  <form id="exp_product" method="post" action="#">
                                    <div class="form-group row">
                                          <label class="col-sm-2 col-form-label">Expense Report</label>
                                                                 <div class="col-sm-5">
                                                                    <input type="text" class="form-control" id="password" name="text" placeholder="Duration">
                                                                    <span class="messages"></span>
                                                                </div>
                                                              </div>
                                                     
                                                     <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Expenses Report summary </label>
                                                                 <div class="col-sm-5">
                                                                    <input type="text" class="form-control" id="password" name="text" placeholder="unit Product">
                                                                    <span class="messages"></span>
                                                                </div>
                                                              </div>
                                                              <div class="form-group row">
                                                       <div class="col-sm-2">
                                                      <label for="password-2" class="block">Product type</label>
                                                      </div>
                                                     <div class="col-sm-5">
                                                     <input type="text" name="quantity" class="form-control" placeholder="quantity" required data-bv-notempty-message="Please enter first product type."/>
                                                    </div>
                                                </div>
                                                        <div class="form-group row">
                                                    <div class="col-sm-2">
                                                        <label for="password-2" class="block">Total</label>
                                                    </div>
                                                    <div class="col-sm-5">
                                                      <input type="text" name="total" class="form-control" placeholder="total" required data-bv-notempty-message="Please enter first total."/>
                                                    </div>
                                                </div>
                                                 <div class="form-group row">
                                                      <label class="col-sm-2 col-form-label">Sales Price</label>
                                                                 <div class="col-sm-5">
                                                                    <input type="text" class="form-control" id="paid" name="text" placeholder="paid by" required data-bv-notempty-message="Please enter first price.">
                                                                    <span class="messages"></span>
                                                                </div>
                                                              </div>
                                                                <div class="form-group row">
                                                                <label class="col-sm-2 col-form-label">Cost</label>
                                                                 <div class="col-sm-5">
                                                                    <input type="text" class="form-control" id="password" name="text" placeholder="bill Reference"required data-bv-notempty-message="Please enter first cost.">
                                                                    <span class="messages"></span>
                                                                </div>
                                                              </div>
                                                           <div class="form-group row">
                                                          <label class="col-sm-2 col-form-label">Internal Referance</label>
                                                           <div class="col-sm-5">
                                                           <input type="text" class="form-control" name="text" id="internal_ref"required data-bv-notempty-message="Please enter first Internal referance.">
                                                           </div>  </div>
                                                           <div class="form-group row">
                                                          <label class="col-sm-2 col-form-label">Accounting</label>
                                                           <div class="col-sm-5">
                                                           <input type="text" class="form-control" name="text" id="internal_ref"required data-bv-notempty-message="Please enter first Internal referance.">
                                                           </div>  </div>
                                                           <div class="form-group row">
                                                 <label class="col-sm-2 col-form-label">Vendor Taxes</label>
                                                     <div class="col-sm-5">
                                                   <textarea rows="5" cols="5" class="form-control"placeholder="Description" required data-bv-notempty-message="Please enter first vendors tax."></textarea>
                                                 </div>
                                             </div>
                                                          <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Customer Taxes</label>
                                                     <div class="col-sm-5">
                                                   <textarea rows="5" cols="5" class="form-control"placeholder="Description" required data-bv-notempty-message="Please enter first customer tax."></textarea>
                                                 </div>
                                             </div>

                                               <div class="tab-pane active" id="contact_address" role="tabpanel">
                                            <div class="form-group row">
                                                   <div class="col-sm-12">
                                       <input type="submit" class="btn btn-primary m-b-0" value="Submit">
                                     </div>
                                            </div>
                                                             
                                             </div>
                                                               </form>
                                                            </div>                                                
<script type="text/javascript" src="assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 $('#exp_product').bootstrapValidator()
   .on("success.form.bv", function() {
  var form = new FormData($('#exp_product')[0]);
  alert('validating form');
            //$("#file_error").text("").hide();
                            
    return false;
        });
    });
</script>
                                             
                                                
                                               
                                        
                                    
                              