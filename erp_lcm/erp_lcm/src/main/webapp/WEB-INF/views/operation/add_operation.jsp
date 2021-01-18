<%@page import="com.spcl.erp.services.WarehouseService"%>
<%@page import="com.spcl.erp.model.Warehouse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<% String contextPath = request.getContextPath(); %>
<html lang="en">
<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<!-- Data Table Css -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/datatables.net-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/pages/data-table/css/buttons.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/css/component.css">
<!-- sweet alert framework -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/sweetalert/css/sweetalert.css">

<body>

<div id="pcoded" class="pcoded">
	<div class="pcoded-overlay-box"></div>
	<div class="pcoded-container navbar-wrapper">
		<!-- Add horizantal menu here -->
		<jsp:include page="/WEB-INF/includes/horizantal_nav_menu.jsp"></jsp:include>
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
									    <!-- Page body start -->
									    <br><br><br>
								    		<div class="page-body">
										        <div class="row">
										            <div class="col-sm-12">
										                <div class="card">
										                    <form id="from_operation" method="post" action="<%=contextPath%>/warehouse/save_operation" modelAttribute="operation">
										                    	<input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
																	<input type=hidden class="form-control" id="opt_id"name="opt_id" value="${operation.opt_id}" />
										                        <div class="card-header">
										                            <div class="col-sm-12">
										                                <h5>${opr_mode=="save"?"Add Operation":"Edit Add Operation"}</h5>
										                                <span>Create New Add Operation</span>
										                                                        
										                            </div><hr>
										                        </div>
										                        <div class="card-block">
										                            <div class="row">
										                                <div class="col-sm-12">
										                                     <div class="row">
														                        <label class="col-sm-3 col-form-label" style="font-size: 15px;">Operation</label>
														                        <div class="form-group col-sm-6">
														                        <input type="text" class="form-control" name="Operation" id="Operation"  required data-bv-notempty-message="Please enter Operation" >
														                        <span class="messages"></span>
														                        </div>
										                   					 </div>
										                                </div>										                               
										                            </div>
										                            <div class="row">
										                                <div class="col-sm-6">
										                                    <div class=" row">
										                                        <label class="col-sm-4 col-form-label">Reference Sequence</label>
										                                       <div class="form-group col-sm-7">
															                            <select name="opt_refer_sequ" id="opt_refer_sequ" class="form-control" required data-bv-notempty-message="Please select Reference Sequence">
															                            	<option value="">-----Select Reference Sequence----- </option>
															                                <option value="1">Vendor</option>
															                                <option value="2">Customers</option>
															                                <option value="3">create/Edit</option>
															                            </select>
															                     </div>
										                                    </div>
										                                </div>
										                              	 <div class="col-sm-6">
										                                      <div class="row">
															                        <label class="col-sm-4 col-form-label">Type Of Operation</label>
															                        <div class="form-group col-sm-7">
															                            <select name="opt_type" id="opt_type" class="form-control" required data-bv-notempty-message="Please select Type Of Operation">
															                            	<option value="">-----Select Type Of Operation----- </option>
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
										                               <button rel="<%=contextPath %>/Warehouse/mng_warehouse" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
										                                </div>     
										                            </div>
										                        </div>
										                    </form>
										                </div>
										            </div>
										        </div>
										    </div>
									            
										<!-- Page body end -->
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

<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>
 <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-buttons/js/dataTables.buttons.min.js"></script>

<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/sparkline/jquery.sparkline.js"></script>
<!-- task board js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/task-board/task-board.js"></script>
<!-- custom js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/data-table/js/data-table-custom.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/issue-list/issue-list.js"></script>
<!-- sweet alert js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/sweetalert/js/sweetalert.min.js"></script>
<!-- sweet alert modal.js intialize js -->
    <!-- data-table js -->
   <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>


    <script type="text/javascript">
          $(document).ready(function(){
           
        	  $('#scrap_date').daterangepicker({
                  singleDatePicker: true,
                  showDropdowns: true
              });
            $('#from_operation').bootstrapValidator();
           
          });
    </script>

</body>
</html>












































