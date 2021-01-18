<%@page import="com.spcl.erp.model.RequestQuotation,com.spcl.erp.model.RfqProductList"%>
<%@page import="com.spcl.erp.services.PurchaseService, java.util.*"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%
	String contextPath = request.getContextPath();
	 Helper helper = (Helper)request.getAttribute("helper");
	PurchaseService purchaseService=(PurchaseService)request.getAttribute("purchaseService"); 
%> 
<!-- Date-range picker css  -->
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/css/daterangepicker.css" />
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">

<!-- jquery file upload Frame work -->
<link href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/jquery.filer.css" type="text/css" rel="stylesheet" />
<link href="<%=contextPath %>/resources/assets/pages/jquery.filer/css/themes/jquery.filer-dragdropbox-theme.css" type="text/css" rel="stylesheet" />

<!-- Page-header start -->
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                   <!--  <h4>Requests for Quotation</h4> -->
                    <h4>${rfq.rfq_isRfq=="1"?" Request For Quotation":"Purchase Order"}</h4>
                    <span>Create ${rfq.rfq_isRfq=="1"?" New Request For Quotation":"New Purchase Order"} in system.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">${rfq.rfq_isRfq=="1"?" Request For Quotation":"Purchase Order"}</a>
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
                     <h5>${opr_mode=="save"?"New Request For Quotation":"Edit Request For Quotation"}</h5>
                </div>
                <div class="card-block">
					<form id="from_rfq_odr" method="post" action="<%=contextPath%>/purchase/save_rfq"  modelAttribute="rfq" >
                    <input type=hidden class="form-control" id="opr_mode" name="opr_mode" value="${opr_mode}" />
					<input type=hidden class="form-control" id="rfq_id" name="rfq_id" value="${rfq.rfq_id}" />
					<input type=hidden class="form-control" id="rfq_isRfq" name="rfq_isRfq" value="${rfq.rfq_isRfq}" />
					<input type=hidden class="form-control" id="rfq_isPO" name="rfq_isPO" value="${rfq.rfq_isPO}" />
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Vendor Name</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                            <select id="rfq_vend_id" name="rfq_vend_id" class="form-control" required data-bv-notempty-message="Please select Vendor.">
                                                <option value="">---Select Vendor---</option>
                                               <%=helper.getVendorDropDown() %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Order Date</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                            <input type="text" name="rfq_odr_date" id="rfq_odr_date" class="form-control" required data-bv-notempty-message="Please select date.">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr></hr>

                        <div class="row">
                            <div class="col-sm-12 form-group">
                                 <h4>Products</h4>
                            </div>
                        </div>

                        <div class="row"> 
                            <div class="col-sm-12">
                                 <div class="table-responsive">
                                   
                                    <table id="table_item" class="table table-xs table-hover table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Quantity</th>
                                                <th id="col_rcv_qty">Received Quantity</th>
                                                <th id="col_bill_qty">Billed Quantity</th>
                                                <th>Unit Price</th>
                                                <th>Tax</th>
                                                <th>Subtotal</th>
                                                <th style="width: 40px;" id="col_action">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="prod_cart_row">
                                          <%--   <c:forEach items="${rfq.rfqproductlist}" var="product" varStatus="status">
												<tr>
													<td align="center">${status.count}</td>
													<td><input name="rfqproductlist[${status.index}].rfpl_qty" value="${product.rfpl_qty}"/></td>
													<td><input name="rfqproductlist[${status.index}].rfpl_unit_price" value="${product.rfpl_unit_price}"/></td>
													<td><input name="rfqproductlist[${status.index}].rfpl_tax_id" value="${product.rfpl_tax_id}"/></td>
													<td><input name="rfqproductlist[${status.index}].rfpl_subtotal" value="${product.rfpl_subtotal}"/></td>
												</tr>
											</c:forEach> --%>
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

                        <hr></hr>
                        
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Extra Note( Max length 120 character)</label>
                                    <div class="col-sm-8 form-group">
                                        <textarea rows="5" cols="5" class="form-control" id="rfq_extra_note" name="rfq_extra_note" placeholder="....Add a note here....."></textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Purchase Representative</label>
                                    <div class="col-sm-8 form-group">
                                        
                                        <select id="rfq_representive_id" name="rfq_representive_id" class="form-control" required data-bv-notempty-message="Please select.">
                                            <option value="">---Select Representative---</option>
                                            <%=helper.getRepresentativeDropDown() %> 
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Payment Terms</label>
                                    <div class="col-sm-8 form-group">
                                        <select class="form-control"  name="rfq_payment_term" id="rfq_payment_term">
                                            <option value="false">---Select---</option>
                                            <option value="1">Immediate Payment</option><option value="2">15 Days</option>
                                            <option value="3">30 Net Days</option>
                                            <option value="4">45 Days</option>
                                            <option value="5">2 Months</option>
                                        </select>   
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Billing Status</label>
                                    <div class="col-sm-8 form-group">
                                        <label>Nothing in Bill</label>
                                    </div>
                                </div>
                            </div>
                         
                            <div class="col-sm-6">
                                <div class="col-sm-12">
                                    <div class="row">
                                        <label class="col-md-6 col-form-label">Gross Amount :</label>
                                        <label class="col-md-6 col-form-label"><span id="gross_amount" name="gross_amount">00.00<i class="icofont-rupee"></i></span></label>
                                    </div>
                                </div>
                                <div class="col-sm-12">
                                    <div class="row">
                                        <label class="col-md-6 col-form-label">Tax Amount :</label>
                                        <label class="col-md-6 col-form-label"><span id="tax_amount" name="tax_amount">00.00<i class="icofont-rupee"></i></span></label>
                                    </div>
                                </div>
                                <hr></hr>
                                <div class="col-sm-12">
                                    <div class="row">
                                        <label class="col-md-6 col-form-label">Net Amount :</label>
                                        <label class="col-md-6 col-form-label"><span id="net_amount" name="net_amount">00.00<i class="icofont-rupee"></i></span></label>
                                    </div>
                                </div>
                             </div>
                        </div>

                        
                        <div class="row">
                             <div class="col-sm-12">
                               	<input type="submit" class="btn btn-primary m-b-0" value='${opr_mode=="save"?"Save":"Update"}'>
	                         	<input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>
	                         	<button rel="<%=contextPath %>/purchase/mng_rfq" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>
	                     	
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
<div class="modal fade" id="cart_product" tabindex="-1" role="dialog" style="z-index: 1050; display: none;" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <form id="from_cart_product" method="post" action="javascript:void(0);">
                <div class="modal-header">
                    <h4 class="modal-title">Add product to cart</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">X</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Product name</label>
                                <div class="form-group col-sm-9">
                                     <select id="rfpl_prod_id" name="rfpl_prod_id" class="form-control" required data-bv-notempty-message="Please select product.">
                                        <option value="">---Select Product---</option>
                                        <option value="1">Milk</option>
                                        <option value="2">Cud</option>
                                        <option value="3">Buttremilk</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Product tax</label>
                                <div class="form-group col-sm-9">
                                     <select id="rfpl_tax_id" name="rfpl_tax_id" class="form-control" required data-bv-notempty-message="Please select tax.">
                                        <option value="">---Select tax---</option>
                                        <option value="1" data-taxnum="2">IGST2%</option>
                                        <option value="2" data-taxnum="5">IGST5%</option>
                                        <option value="3" data-taxnum="8">IGST8%</option>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Quantity</label>
                                <div class="col-sm-9 form-group">
                                    <input type="text" class="form-control" id="rfpl_qty" name="rfpl_qty" placeholder="Enter quantity" required data-bv-notempty-message="Please enter quantity." pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed">
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Unit Price</label>
                                <div class="col-sm-9 form-group">
                                    <input type="text" class="form-control" id="rfpl_unit_price" name="rfpl_unit_price" placeholder="Enter unit price." required data-bv-notempty-message="Please enter unit price." pattern="^[0-9.]+$" data-bv-regexp-message="only numbers are allowed">
                                    
                                </div>
                            </div>
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Subtotal</label>
                                <div class="col-sm-9 form-group">
                                    <input type="text" class="form-control" id="rfpl_subtotal" name="rfpl_subtotal" value="" readonly>
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




<!-- Date-range picker js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/moment/js/moment.min.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var idx_num=0;
        var decimal_format=2;
        $('#col_rcv_qty').remove();
		$('#col_bill_qty').remove();
      	$('#from_rfq_odr').bootstrapValidator()
   		.on("success.form.bv", function() {
            $('#file_error').html("").hide();
            
            var form = new FormData($('#from_rfq_odr')[0]);
            $.ajax({
                url: '<%=contextPath %>/purchase/save_rfq',
                type: 'POST',
                dataType :"json",
                complete: function() {}, 
                success: function (data) {
                	if(data.status == 1) {
                		location.href='<%=contextPath %>/purchase/mng_rfq';
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
        
        $('.add_prod_row').on("click", function() {

            if ($('#from_cart_product').bootstrapValidator('validate').has('.has-error').length) {
                return;
            } else {
            	
                var itm_name = $("#rfpl_prod_id option:selected").text();
                var flag=false;
                var itm_id = $("#rfpl_prod_id option:selected").val();

                var itm_tax = $("#rfpl_tax_id option:selected").text();
                var flag=false;
                var itm_tax_id =$("#rfpl_tax_id option:selected").val();

                var itm_qty=$('#rfpl_qty').val();
                var itm_price=$('#rfpl_unit_price').val();
                var itm_subtotal=Number.parseFloat($("#rfpl_subtotal").val());

               

                $('#table_item > tbody  > tr').each(function() {
                    var tbl_row_id = $(this).attr('data-itm_id');
                    if(itm_id===tbl_row_id){
                        flag=true;
                    }
                });

                if(flag){
                    alert('item is already added in list please change quantity...')
                    return;
                }

                var html_txt="<tr data-itm_id="+itm_id+" data-row_id="+idx_num+">"+
                                "<td>"+itm_name+"</td>"+

                                "<td><input type='text'  class='form-control' id='rfpl_qty_"+idx_num+"' name='rfqproductlist["+idx_num+"].rfpl_qty' value='"+itm_qty+"' style='width: 80px;'></td>"+

                                "<td><input type='text'  class='form-control' id='rfpl_unit_price_"+idx_num+"' name='rfqproductlist["+idx_num+"].rfpl_unit_price' value='"+itm_price+"' style='width: 80px;'></td>"+

                                "<td><select id='rfpl_tax_id_"+idx_num+"' name='rfqproductlist["+idx_num+"].rfpl_tax_id' class='form-control' style='width: 100px;'>"+
                                        "<option value=''>---Select tax---</option>"+
                                        "<option value='1' data-taxnum='2'>IGST2%</option>"+
                                        "<option value='2' data-taxnum='5'>IGST5%</option>"+
                                        "<option value='3' data-taxnum='8'>IGST8%</option>"+
                                    "</select></td>"+

                                "<td id='rfpl_subtotal_"+idx_num+"'>"+itm_subtotal.toFixed(decimal_format)+"</td>"+

                                "<td class='action-icon text-center'>"+
                                    "<a href='javascript:void(0);' class='text-muted' id='remv_prod_cart_"+idx_num+"' data-toggle='tooltip' data-placement='top' title='Renove' data-original-title='Remonve'><i class='icofont icofont-delete-alt'></i></a>"+
                                "</td>"+

                                "<input type='hidden' name='rfqproductlist["+idx_num+"].rfpl_prod_id' value='"+itm_id+"'>"+
                            "</tr>";

                $("#prod_cart_row").append(html_txt);
                
                $('#rfpl_tax_id_'+idx_num).val(itm_tax_id);
                
                $('#remv_prod_cart_'+idx_num).on("click", function() {
                    $(this).closest("tr").remove();
                    idx_num--;
                    $("#total_row_num").val(idx_num);
                    calculate_net_amount();

                });

                $("#rfpl_qty_"+idx_num).on('keyup',function () {
                
                    var itm_qty=$(this).val();

                    if( typeof itm_qty === 'undefined' || itm_qty === null || itm_qty==="" || !$.isNumeric(itm_qty)){
                       $(this).val('');
                    }
                    calculate_sub_amount('_'+idx_num);
                    calculate_net_amount();

                });

                $("#rfpl_unit_price_"+idx_num).on('keyup',function () {
                
                    var itm_price=$(this).val();

                    if( typeof itm_price === 'undefined' || itm_price === null || itm_price==="" || !$.isNumeric(itm_price)){
                       $(this).val('');
                    }
                    calculate_sub_amount('_'+idx_num);
                    calculate_net_amount();

                });

                $("#rfpl_tax_id_"+idx_num).on('change',function () {
                
                    var itm_price=$(this).val();

                    if( typeof itm_price === 'undefined' || itm_price === null || itm_price===""){
                       $(this).val('');
                    }
                    calculate_net_amount();

                });

                calculate_net_amount();
                $('#cart_product').modal('hide');
                idx_num++;
            }
        });

        $("#rfpl_qty").on('keyup',function () {
                
            var itm_qty=$(this).val();

            if( typeof itm_qty === 'undefined' || itm_qty === null || itm_qty==="" || !$.isNumeric(itm_qty)){
               $(this).val('');
            }
            calculate_sub_amount('');
            
        });

        $("#rfpl_unit_price").on('keyup',function () {
        
            var itm_price=$(this).val();

            if( typeof itm_price === 'undefined' || itm_price === null || itm_price==="" || !$.isNumeric(itm_price)){
               $(this).val('');
            }
            calculate_sub_amount('');
        
        });

        $('#rfq_odr_date').daterangepicker({
            singleDatePicker: true,
            showDropdowns: true
        });

        function calculate_net_amount() {
            
            var gross_amt=0.00;
            var tax_amt=0.00;
            var net_amt=0.00;           

            $('#table_item > tbody  > tr').each(function() {
                var tbl_row_id = $(this).attr('data-row_id');
                var item_sub_amt=$("#rfpl_subtotal_"+tbl_row_id).text();
                var item_tax_num=$("#rfpl_tax_id_"+tbl_row_id).val()===''?0.00:$("#rfpl_tax_id_"+tbl_row_id+" option:selected").attr('data-taxnum');
                gross_amt=(+gross_amt)+(+item_sub_amt);
                tax_amt=(+tax_amt)+((+item_sub_amt)*((+item_tax_num)/100)); 
            });
  
            net_amt=(gross_amt+tax_amt);

            $("#gross_amount").text(gross_amt.toFixed(decimal_format))
            $("#tax_amount").text(tax_amt.toFixed(decimal_format))
            $("#net_amount").text(net_amt.toFixed(decimal_format));
            
            
        }


        function calculate_sub_amount(itm_id) {
            var itm_price=$("#rfpl_unit_price"+itm_id).val()===''?0.00:$("#rfpl_unit_price"+itm_id).val();
            var itm_qty=$("#rfpl_qty"+itm_id).val()===''?0.00:$("#rfpl_qty"+itm_id).val();
            var itm_tax=$("#rfpl_tax_id"+itm_id).val()===''?0.00:$("#rfpl_tax_id"+itm_id+" option:selected").attr('data-taxnum');
            
            var sub_amt=(+itm_price)*(+itm_qty);
            if (itm_id==='') {
                $("#rfpl_subtotal").val(sub_amt.toFixed(decimal_format));
            }else{
                $("#rfpl_subtotal"+itm_id).text(sub_amt.toFixed(decimal_format));
            }
          }
        
        $('#btn-cancel').on('click', function() {
            var loc=$(this).attr('rel');
           	location.href=loc;
 		});
        
        
        <%	RequestQuotation rfq=(RequestQuotation)request.getAttribute("rfq");
    	String opr_mode=(String)request.getAttribute("opr_mode");

    		if(opr_mode!=null&&rfq!=null){
    			List<RfqProductList> prod_list=rfq.getRfqproductlist();
    			if(prod_list!=null&&prod_list.size()>0){
    				if(opr_mode.equals("update")){
    			
    	%>	
	    	$('#rfq_vend_id').val('<%=rfq.getCustomer().getCust_id()%>');
			$('#rfq_odr_date').val('<%=rfq.getRfq_odr_date()%>');
			$('#rfq_extra_note').val('<%=rfq.getRfq_extra_note()%>');
			$('#rfq_representive_id').val('<%=rfq.getSaleperson().getSalep_id()%>');
			
			$('#rfq_payment_term').val('<%=rfq.getRfq_payment_term()%>');
			$('#gross_amount').val('<%=rfq.getGross_amount()%>');
			$('#tax_amount').val('<%=rfq.getTax_amount()%>');
			$('#net_amount').val('<%=rfq.getNet_amount()%>');
    		$('#col_rcv_qty').remove();
    		$('#col_bill_qty').remove();
			idx_num=0;
			<% for(RfqProductList rfpl: prod_list){ %>
					
			var html_txt="<tr data-itm_id="+<%=rfpl.getRfpl_prod_id()%>+" data-row_id="+idx_num+">"+
					"<td><%=helper.getProductName(rfpl.getRfpl_prod_id())%></td>"+
	
          			
          			"<td><input type='text'  class='form-control' id='rfpl_qty_"+idx_num+
          					"'name='rfqproductlist["+idx_num+"].rfpl_qty' value='"+<%=rfpl.getRfpl_qty()%>+
          					"' class='form-control' style='width: 80px;'></td>"+
          			
          			"<td><input type='text'  class='form-control' id='rfpl_unit_price_"+idx_num+
          					"' name='rfqproductlist["+idx_num+"].rfpl_unit_price' value='"+<%=rfpl.getRfpl_unit_price().toString()%>+
          					"' class='form-control' style='width: 80px;'></td>"+
		
					"<td><select id='rfpl_tax_id_"+idx_num+"' name='rfqproductlist["+idx_num+"].rfpl_tax_id' class='form-control' style='width: 100px;'>"+
                        "<option value=''>---Select tax---</option>"+
                        "<option value='1' data-taxnum='2'>IGST2%</option>"+
                        "<option value='2' data-taxnum='5'>IGST5%</option>"+
                        "<option value='3' data-taxnum='8'>IGST8%</option>"+
                   	"</select></td>"+
      						
      				"<td id='rfpl_subtotal_"+idx_num+"'><%=rfpl.getRfpl_subtotal().toString()%></td>"+

	                "<td class='action-icon text-center'>"+
	                    "<a href='javascript:void(0);' class='text-muted' id='remv_prod_cart_"+idx_num+
                    	"' data-toggle='tooltip' data-placement='top' title='Renove' data-original-title='Remonve'>"+
                    	"<i class='icofont icofont-delete-alt'></i></a>"+
	                "</td>"+

              			"<input type='hidden' name='rfqproductlist["+idx_num+"].rfpl_prod_id'"+
              			"value='"+<%=rfpl.getRfpl_prod_id()%>+"'>"+
              			
              			"<input type='hidden' name='rfqproductlist["+idx_num+"].rfq_list_id'"+
              			"value='"+<%=rfpl.getRfq_list_id().toString()%>+"'>"+
          			"</tr>";

				$("#prod_cart_row").append(html_txt);

				$('#rfpl_tax_id_'+idx_num).val('<%=rfpl.getRfpl_tax_id().toString()%>');
                
                $('#remv_prod_cart_'+idx_num).on("click", function() {
                    $(this).closest("tr").remove();
                    idx_num--;
                    $("#total_row_num").val(idx_num);
                    calculate_net_amount();

                });

                $("#rfpl_qty_"+idx_num).on('keyup',function () {
                
                    var itm_qty=$(this).val();

                    if( typeof itm_qty === 'undefined' || itm_qty === null || itm_qty==="" || !$.isNumeric(itm_qty)){
                       $(this).val('');
                    }
                    calculate_sub_amount('_'+idx_num);
                    calculate_net_amount();

                });

                $("#rfpl_unit_price_"+idx_num).on('keyup',function () {
                
                    var itm_price=$(this).val();

                    if( typeof itm_price === 'undefined' || itm_price === null || itm_price==="" || !$.isNumeric(itm_price)){
                       $(this).val('');
                    }
                    calculate_sub_amount('_'+idx_num);
                    calculate_net_amount();

                });

                $("#rfpl_tax_id_"+idx_num).on('change',function () {
                
                    var itm_price=$(this).val();

                    if( typeof itm_price === 'undefined' || itm_price === null || itm_price===""){
                       $(this).val('');
                    }
                    calculate_net_amount();

                });

                calculate_net_amount();
              	idx_num++;
		<% }%>
    		
    <% } else if(opr_mode.equals("view")){ %>
    		
    		
				    $('#rfq_vend_id'). replaceWith($("<span>", {text: '<%=rfq.getCustomer().getCust_fname()%>'}));
					$('#rfq_odr_date').replaceWith($("<span>", {text: '<%=rfq.getRfq_odr_date() %>'}));
					$('#rfq_extra_note').replaceWith($("<span>", {text: '<%=rfq.getRfq_extra_note() %>'}));
					$('#rfq_representive_id').replaceWith($("<span>", {text: '<%=rfq.getSaleperson().getSalep_fname() %>'}));
					$('#rfq_payment_term').replaceWith($("<span>", {text:'<%=rfq.getRfq_payment_term()%>'}));
					$('#gross_amount').replaceWith($("<span>", {text: '<%=rfq.getGross_amount() %>'}));
					$('#tax_amount').replaceWith($("<span>", {text: '<%=rfq.getTax_amount() %>'}));
					$('#net_amount').replaceWith($("<span>", {text: '<%=rfq.getNet_amount() %>'}));
    				
    				$("#col_action").remove();
    				$('#col_rcv_qty').remove();
    	    		$('#col_bill_qty').remove();
    				idx_num=0;
    				<% for(RfqProductList rfpl: prod_list){ %>
    					
    					var html_txt="<tr data-itm_id="+<%=rfpl.getRfpl_prod_id()%>+" data-row_id="+idx_num+">"+
                    			"<td>"+<%=rfpl.getRfpl_prod_id()%>+"</td>"+
    							
                    			"<td>"+<%=rfpl.getRfpl_qty()%>+"</td>"+

                    			"<td>"+<%=rfpl.getRfpl_unit_price()%>+"</td>"+
                    			"<td>"+<%=rfpl.getRfpl_tax_id()%>+"</td>"+

                   				"<td>"+<%=rfpl.getRfpl_subtotal()%>+"</td>"
                   			"</tr>";

    					$("#prod_cart_row").append(html_txt);

    	               	$('#remv_prod_cart_'+idx_num).on("click", function() {
    	                   $(this).closest("tr").remove();
    	                   idx_num--;
    	               	});
    	               	idx_num++;
    				<% }%> 
    	      

    	
    		<% } 
    			
    		}
    	}
    %>
                      
		});
						
	</script>







