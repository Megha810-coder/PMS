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
                          <h5>Leaves</h5>
                             </div>
                            <div class="card-block">
                                <form id="leave_details" method="post" action="#" novalidate>

                                         <div class="row">
                                        <label class="col-sm-2 col-form-label">Leave Type</label>
                                            <div class="form-group col-sm-4">
                                                <select name="select" class="form-control" required data-bv-notempty-message="Please select title.">
                                                   <option value="opt1">Select One Value Only</option>
                                                   <option value="opt6">Compensatory Days</option>
                                                    <option value="opt2">Unpaid</option>
                                                    <option value="opt3">Sick Leaves</option>
                                                    <option value="opt4">Create and Edit</option>
                                                      </select>
                                                  </div>
                                            </div>
                                               <div class="form-group row">
                                                                <label class="col-sm-2 col-form-label">Duration</label>
                                                                 <div class="col-sm-4">
                                                                    <input type="text" class="form-control" id="leave_duration" name="text" placeholder="Duration" required data-bv-notempty-message="Please enter first duration.">
                                                                <span class="messages"></span>
                                                                </div>
                                                            </div>
                                                                   <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Description</label>
                                                   <div class="col-sm-4">
                                     <textarea rows="5" cols="5" class="form-control" id="leave_description"required data-bv-notempty-message="Please enter first description."></textarea>
                                          </div>
                                      </div>
                                      <div class="form-group row">
                                                   <div class="col-sm-12">
                                           <input type="submit" class="btn btn-primary m-b-0" value="Submit">
                                           </div>
                                            </div>
                                              
                                                        </form>
                                                    </div>
                                                </div>
                                        </div>
                                    </div>
<script type="text/javascript" src="<%=contextPath %>/resource/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('#leave_details').bootstrapValidator()
            .on("success.form.bv", function() {
            var form = new FormData($('#leave_details')[0]);
            alert('validating form');
            //$("#file_error").text("").hide();
                            
            return false;
        });
    });
</script>
  