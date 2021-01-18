<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<% String contextPath = request.getContextPath(); %>
<% 	
Helper helper=(Helper)request.getAttribute("helper");
%>

<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

 <div class="page-body">
        <div class="row">
            <div class="col-sm-12">
                <!-- Tab variant tab card start -->
                <div class="card">
                    <form id="form_Bom" method="post" action="<%=contextPath%>/bill/save_bill" modelAttribute="bill">
                    <input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
							<input type=hidden class="form-control" id="bom_id"name="bom_id" value="${bill.bom_id}" />
                        <div class="card-header">
                            <div class="col-sm-12">
                              <h6>Bill Of Material</h6>
                              <span>Create New Bill Of Material</span>
                                                           
                            </div><hr/>  
                        </div>
                        <div class="card-block">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class=" row">
                                     <label class="col-sm-4 col-form-label">Product Name</label>
                                         <div class="form-group col-sm-7">
                                            <select  id="bom_pro_id" name="bom_pro_id" required data-bv-notempty-message="Please select Product." class="form-control">
                                            <option value="">---Select Product---</option>
                                            <option value="1">milk</option>
                                            <option value="2">Create and Edit</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="row">
                                        <label class="col-sm-4 col-form-label">Quantity</label>
                                            <div class="form-group col-sm-7">
                                            <input type="text" class="form-control" id="bom_qty" name="bom_qty" required data-bv-notempty-message="Please enter quantity">
                                            </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">    
                                    <div class=" row">
                                        <label class="col-sm-4 col-form-label">Reference</label>
                                            <div class="form-group col-sm-7">
                                            <input type="text" class="form-control" id="bom_reference" name="bom_reference">
                                            <span class="messages"></span>
                                            </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group ">  
                                <div class="row"> 
                                    <div class="col-sm-12">
                                         <div class="table-responsive">
                                            <input type="hidden" id="total_row_num" name="total_row_num" value='0'>
                                            <table id="table_item" class="table table-xs table-hover table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Components</th>
                                                        <th>Quantity</th>
                                                       <th style="width: 40px;">Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="prod_cart_row">
                                                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                  <div class="row">
                                    <div class="col-sm-12">
                                         <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#cart_product">Add</button>
                                    </div>
                                </div> 
                            </div>
                             <div class="form-group row">
                                    <input type="submit"   value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;"></input>&nbsp;
                                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               <button rel="<%=contextPath %>/bill/bill_material_list" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
                         	</div> 
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
     <!---model for contact and address start -->
 <div class="modal fade" id="cart_product" tabindex="-1" role="dialog" style="z-index: 1050; display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <form id="from_cart_product" method="post" action="javascript:void(0);">
                <div class="modal-header">
                    <h4 class="modal-title">Add Product to cart</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">X</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Product </label>
                                <div class=" col-sm-9 form-group">
                                     <select id="bom_com_product_id" name="bom_com_product_id" class="form-control" required data-bv-notempty-message="Please select product.">
                                        <option value="">---Select Product---</option>
                                       <%=helper.getProductDropDown() %>
                                    </select>
                                </div>
                            </div>
                           <br>
                            
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Quantity</label>
                                <div class="col-sm-9 form-group">
                                    <input type="text" class="form-control" id="bom_com_qty" name="bom_com_qty" placeholder="Enter Quantity" required data-bv-notempty-message="Please enter quantity." >
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default waves-effect " data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary waves-effect waves-light add_prod_row">Add to cart</button>
                </div>
            </form>
        </div>
    </div>
</div> 

<!---model for contact and address end-->

    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
    <script>
     
     
     
    $(document).ready(function(){
    	  var idx_num=1;
        $('#form_Bom').bootstrapValidator();
           
        
        $('#from_cart_product').bootstrapValidator();

        $('.add_prod_row').on("click", function() {

            if ($('#from_cart_product').bootstrapValidator('validate').has('.has-error').length) {
                return;
            } else {
                var itm_name = $("#bom_com_product_id option:selected").text();
                var flag=false;
                var itm_id = $("#bom_com_product_id option:selected").val();

                var bom_com_qty=$('#bom_com_qty').val();
  
          
                var html_txt="<tr data-itm_id="+itm_id+">"+
                                "<td>"+itm_name+"</td>"+

                                "<td><input type='text'  class='form-control' id='bom_com_qty"+itm_id+"' name='bom_com_qty"+itm_id+"' value='"+bom_com_qty+"' style='width: 80px;'></td>"+

                              
                                "<td class='action-icon text-center'>"+
                                    "<a href='javascript:void(0);' class='text-muted' id='remv_prod_cart_"+itm_id+"' data-toggle='tooltip' data-placement='top' title='Renove' data-original-title='Remonve'><i class='icofont icofont-delete-alt'></i></a>"+
                                "</td>"+

                                "<input type='hidden' name='bom_com_product_id"+idx_num+"' value='"+itm_id+"'>"+
                            "</tr>";

                $("#prod_cart_row").append(html_txt);

                $('#remv_prod_cart_'+itm_id).on("click", function() {
                    $(this).closest("tr").remove();
                    idx_num--;
                });

              
                
            }
        });
    });
    
   
</script>
    