
<%@page import="com.spcl.erp.model.Transfer_Product"%>
<%@page import="java.util.List"%>
<%@page import="com.spcl.erp.model.Transfer"%>
<%@page import="com.spcl.erp.services.TransferService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.spcl.erp.helper.Helper"%>
	<% 	
		Helper helper=(Helper)request.getAttribute("helper");
		TransferService transferService=(TransferService)request.getAttribute("TransferService");
		Transfer transfer=(Transfer)request.getAttribute("transfer");
	%>
<% String contextPath = request.getContextPath(); %>
<style>
#tra_partner_id{
 width:340px;
 }gf
select {
  font-family: 'FontAwesome',Verdana ;
}


</style>

<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
<%--  <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/icon/ion-icon/css/ionicons.min.css"> --%>
<div id="file_error" class="alert alert-danger background-danger" style="display: none;"></div>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="-1" />


<!-- Page-header start -->
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Transfers</h4>
                    <span>Create new Transfers.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Transfers</a>
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
 <div class="page-body" id="content">
    <div class="row">
        <div class="col-sm-12">
            <!-- Basic Inputs Validation start -->
            <div class="card">
                <div class="card-header">
                    <h3>${opr_mode=="save"?"Add Transfers":"Edit Transfers"}</h3>
                </div>
                <div class="card-block">
                    <form id="from_transfer" method="post" action="<%=contextPath%>/transfer/save_transfer" modelAttribute="transfer">
						 <input type=hidden class="form-control" id="opr_mode"name="opr_mode" value="${opr_mode}" />
						<input type=hidden class="form-control" id="tra_id"name="tra_id" value="${transfer.tra_id}" />
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Partner</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                            <select data-show-icon="true" id="tra_partner_id" name="tra_partner_id" class="form-control" required data-bv-notempty-message="Please select Partner">
                                                <option value="">---Select Partner---</option>
                                                <option value="1">Mayuri Ladi</option>
                                                <option value="2">Gopal Mankar</option>
                                                <option value="3">Neha swami</option>
                                                <option >Create Partner &#xf055;</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Operation Type</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                            <select id="tra_opt_type" name="erp_operation.opt_id" class="form-control" required data-bv-notempty-message="Please select Partner">
                                                <option value="">---Select Operation Type---</option>
                                             <%=helper.getOperationDropDown()%> 
                                              	<option value=""><i class="ion-plus-circled"></i>create/edit</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="row">
                                    <label class="col-sm-3 col-form-label">Source Document</label>
                                    <div class="col-sm-9">
                                        <div class="form-group row col-sm-12">
                                             <input type="text" name="tra_source" id="tra_source" class="form-control" required data-bv-notempty-message="Please Enter Source Document.">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <ul class="nav nav-tabs  tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#operation" role="tab" aria-expanded="true">Operations</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#Add_info" role="tab" aria-expanded="false">Additional info</a>
                            </li>
                        </ul>
                        <div class="tab-content tabs card-block">
                            <div class="tab-pane active" id="operation" role="tabpanel">
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                         <h4>Products</h4>
                                    </div>
                                </div>
                                
                                <div class="row"> 
                                    <div class="col-sm-12">
                                         <div class="table-responsive">
                                            <input type="hidden" id="total_row_num" name="total_row_num" value='0'>
                                            <table id="table_item" class="table table-xs table-hover table-bordered">
                                                <thead>
                                                    <tr>
                                                        <th>Product</th>
                                                        <th>Initial Demand</th>
                                                        <th>Reserved</th>
                                                        <th>Done</th>
                                                       	<th id="col_action" style="width: 40px;">Action</th>
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
                                         <button id="add_row" type="button" class="btn btn-primary" data-toggle="modal" data-target="#cart_product">Add</button>
                                    </div>
                                </div>                              
                            </div>
                            <div class="tab-pane" id="Add_info" role="tabpanel">
                                <div class="row">
                                    <div class="col-sm-6">
                                        
                                        <div class="row">
                                            <label class="col-sm-3 col-form-label">Shipping Policy</label>
                                            <div class="col-sm-8 form-group">
                                                
                                                <select id="tra_shiping" name="tra_shiping" class="form-control" required data-bv-notempty-message="Please select Shipping Policy.">
                                                    <option value="">---Select Shipping Policy---</option>
                                                    <option value="1">As soon as possible</option>
                                                    <option value="2">type2</option>                                               
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-3 col-form-label">Priority</label>
                                            <div class="col-sm-8 form-group">
                                                
                                                <select id="tra_priority" name="tra_priority" class="form-control" required data-bv-notempty-message="Please select Priority.">
                                                    <option value="">---Select Priority---</option>
                                                    <option value="1">As soon as possible</option>
                                                    <option value="2">type2</option>                                               
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-3 col-form-label">Note</label>
                                            <div class="col-sm-8 form-group">
                                                <textarea rows="4" cols="5" class="form-control" id="tra_note" name="tra_note" placeholder="....Add a note here....."></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                         
                        <div class="row">
                            <div class="form-group row">
                                <input type="submit" data-target="transfer_id<%=transfer.getTra_id()%>" id="transfer_id<%=transfer.getTra_id()%>"  value='${opr_mode=="save"?"Save":"Update"}'class="btn btn-primary m-b-0 submit navbutton" style="margin-left: 700px;" ></input>&nbsp;
                                <input type="reset" class="btn btn-inverse m-b-0" value="Reset"/>&nbsp;
                               <button rel="<%=contextPath %>/transfer/invent_transfer" id="btn-cancel" type="button" class="btn btn-danger">Cancel</button>&nbsp;
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
                                <label class="col-sm-3 col-form-label">Product </label>
                                <div class=" col-sm-9 form-group">
                                     <select id="tra_product_id" name="tra_product_id" class="form-control" required data-bv-notempty-message="Please select product.">
                                        <option value="">---Select Product---</option>
                                        <option value="1">Milk</option>
                                        <option value="2">Cud</option>
                                        <option value="3">Buttremilk</option>
                                    </select>
                                </div>
                            </div> 
                            <div class="row">
                                <label class="col-sm-3 col-form-label">Initial Demand</label>
                                <div class="col-sm-9 form-group">
                                    <input type="text" class="form-control" id="tra_initial" name="tra_initial" placeholder="Enter Initial Demand" required data-bv-notempty-message="Please enter quantity." pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed">
                                </div>
                            </div>
                            <div class=" form-group row">
                                <label class="col-sm-3 col-form-label">Reserved	</label>
                                <div class="col-sm-9 ">
                                    <input type="text" class="form-control" id="tra_reserve" name="tra_reserve" value="0"  placeholder="Enter Reserved."  pattern="^[0-9.]+$" data-bv-regexp-message="only numbers are allowed" readonly="readonly">
                                 </div>
                            </div>
                            <div class="row form-group">
                                <label class="col-sm-3 col-form-label">Done</label>
                                <div class="col-sm-9 ">
                                    <input type="text" class="form-control" id="tra_done" name="tra_done" value="0" pattern="^[0-9.]+$" data-bv-regexp-message="only numbers are allowed" readonly="readonly" >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default waves-effect " data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary waves-effect waves-light add_prod_row">Add to cart</button>
                </div>
            </form>
        </div>
    </div>
</div> 

<!---model for contact and address end-->

<!-- Date-range picker js -->
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap-daterangepicker/js/daterangepicker.js"></script>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>

<script type="text/javascript">

$(document).ready(function(){
       var idx_num=0;
       var decimal_format=2;
       var transfer_status="<%=helper.getStatusLable(transfer) %>";
       
       $('#from_transfer').bootstrapValidator()
           .on("success.form.bv", function() {
           var form = new FormData($('#from_transfer')[0]);
         
           $.ajax({
               url: '<%=contextPath %>/transfer/save_transfer',
               type: 'POST',
               dataType :"json",
               complete: function() {}, 
               success:  function (data) {
               	if(data.status == 1) {
               		if(data.tra_id!=''){
               			location.href='<%=contextPath %>/transfer/invent_transfer';
               			<%-- $('#page_body').load('<%=contextPath %>/transfer/view_transfer?tra_id='+data.tra_id); --%>
               		}
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
       
       $('.add_prod_row').on("click", function() {

           if ($('#from_cart_product').bootstrapValidator('validate').has('.has-error').length) {
               return;
           } else {
               var itm_name = $("#tra_product_id option:selected").text();
               var flag=false;
               var itm_id = $("#tra_product_id option:selected").val();
               var tra_initial=$('#tra_initial').val();
               var tra_reserve=$('#tra_reserve').val();
               var tra_done=$('#tra_done').val();
              

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

               var html_txt="<tr data-itm_id="+itm_id+">"+
                   "<td>"+itm_name+"</td>"+

                   "<td><input type='text'  class='form-control' id='tra_initial"+idx_num+"' name='trp_list["+idx_num+"].trp_initial' value='"+tra_initial+"' style='width: 80px;'></td>"+

                   "<td><input type='text'  class='form-control' id='tra_reserve"+idx_num+"' name='trp_list["+idx_num+"].trp_reserve' value='"+tra_reserve+"' style='width: 80px;' readonly='readonly'></td>"+

                   "<td><input type='text'  class='form-control' id='tra_done"+idx_num+"' name='trp_list["+idx_num+"].trp_done' value='"+tra_done+"' class='form-control' style='width: 80px;' readonly='readonly'></td>"+

                   "<td class='action-icon text-center'>"+
                       "<a href='javascript:void(0);' class='text-muted' id='remv_prod_cart_"+idx_num+"' data-toggle='tooltip' data-placement='top' title='Renove' data-original-title='Remonve'><i class='icofont icofont-delete-alt'></i></a>"+
                   "</td>"+

                   "<input type='hidden' name='trp_list["+idx_num+"].trp_product_id' value='"+itm_id+"'>"+
               "</tr>";

               $("#prod_cart_row").append(html_txt);

               $('#remv_prod_cart_'+idx_num).on("click", function() {
                   $(this).closest("tr").remove();
                   idx_num--;

               });
               idx_num++;
               $("#add_prod_row").attr('disabled',false);
               return true;	
           }
       });
    
	<%	
		String opr_mode=(String)request.getAttribute("opr_mode");

		if(opr_mode!=null&&transfer!=null){
			List<Transfer_Product> trp_list=transfer.getTrp_list();
			if(trp_list!=null&&trp_list.size()>0){
				if(opr_mode.equals("update")){
					
			
	%>	
		
				
		$('#tra_partner_id').val('<%=transfer.getTra_partner_id()%>');
		$('#tra_opt_type').val('<%=transfer.getErp_operation().getOpt_id().intValue()%>');
		$('#tra_source').val('<%=transfer.getTra_source()%>');
		$('#tra_shiping').val('<%=transfer.getTra_shiping()%>');			
		$('#tra_priority').val('<%=transfer.getTra_priority()%>');
		$('#tra_note').val('<%=transfer.getTra_note()%>');
		$('#tra_product_id').val('<%=transfer.getTra_partner_id()%>');
		
		idx_num=0;
		<% for(Transfer_Product trp: trp_list){ %>
			
			var html_txt="<tr data-itm_id="+<%=trp.getTrp_product_id()%>+">"+
          			"<td><%=helper.getProductName(trp.getTrp_product_id())%></td>"+
	
          			"<td><input type='text'  class='form-control' id='tra_initial"+idx_num+
          					"'name='trp_list["+idx_num+"].trp_initial' value='"+<%=trp.getTrp_initial()%>+
          					"' class='form-control' style='width: 80px;'></td>"+

          			"<td><input type='text'  class='form-control' id='tra_reserve"+idx_num+
          					"' name='trp_list["+idx_num+"].trp_reserve' value='"+<%=trp.getTrp_reserve()%>+
          					"' class='form-control' style='width: 80px;'></td>"+

       				"<td><input type='text'  class='form-control' id='tra_done"+idx_num+
       						"' name='trp_list["+idx_num+"].trp_done' value='"+<%=trp.getTrp_done()%>+
    						"' class='form-control' style='width: 80px;'></td>"+
	
	                "<td class='action-icon text-center'>"+
	                    "<a href='javascript:void(0);' class='text-muted' id='remv_prod_cart_"+idx_num+
	                   	"' data-toggle='tooltip' data-placement='top' title='Renove' data-original-title='Remonve'>"+
	                   	"<i class='icofont icofont-delete-alt'></i></a>"+
	                "</td>"+
	
           			"<input type='hidden' name='trp_list["+idx_num+"].trp_product_id'"+
           			"value='"+<%=trp.getTrp_product_id()%>+"'>"+
           			
           			"<input type='hidden' name='trp_list["+idx_num+"].trp_id'"+
           			"value='"+<%=trp.getTrp_id()%>+"'>"+
       			"</tr>";
	
			$("#prod_cart_row").append(html_txt);
			
			$('#remv_prod_cart_'+idx_num).on("click", function() {
                 $(this).closest("tr").remove();
	                 idx_num--;
            });
        	if (transfer_status=='DRAFT') {
        		$("#tra_reserve"+idx_num).prop("readonly",true);
        		$("#tra_done"+idx_num).prop("readonly",true);
			}
        	
        	idx_num++;
		<% }%>

	<% }else if(opr_mode.equals("view")){
	
	%>
		$('#tra_partner_id').replaceWith($("<span>",{text:'<%=transfer.getTra_partner_id()%>'}));
		$('#tra_opt_type').replaceWith($("<span>",{text:'<%=transfer.getErp_operation().getOperation()%>'}));
		$('#tra_source').replaceWith($("<span>",{text:'<%=transfer.getTra_source()%>'}));
		$('#tra_shiping').replaceWith($("<span>",{text:'<%=transfer.getTra_shiping()%>'}));								
		$('#tra_priority').replaceWith($("<span>",{text:'<%=transfer.getTra_priority()%>'}));
		$('#tra_note').replaceWith($("<span>",{text:'<%=transfer.getTra_note()%>'}));
		$('#tra_product_id').replaceWith($("<span>",{text:'<%=transfer.getTra_partner_id()%>'}));
		
		$('input[type="submit"]').replaceWith('');
		$('input[type="reset"]').replaceWith('');
		$('#add_row').replaceWith('');
		
		$("#col_action").remove();
		idx_num=0;
		<% for(Transfer_Product trp: trp_list){ %>
			
			var html_txt="<tr data-itm_id="+<%=trp.getTrp_product_id()%>+">"+
					"<td><%=helper.getProductName(trp.getTrp_product_id())%></td>"+
					
              			"<td>"+<%=trp.getTrp_initial()%>+"</td>"+

              			"<td>"+<%=trp.getTrp_reserve()%>+"</td>"+

             				"<td>"+<%=trp.getTrp_done()%>+"</td>"
             			"</tr>";

			$("#prod_cart_row").append(html_txt);

              	$('#remv_prod_cart_'+idx_num).on("click", function() {
                  $(this).closest("tr").remove();
                  idx_num--;
              	});
              	idx_num++;
		<% } } } }%>
		
		
                          
	});
					
</script>

	








