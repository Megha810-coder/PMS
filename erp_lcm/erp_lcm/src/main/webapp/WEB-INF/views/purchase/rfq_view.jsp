<%@page import="com.spcl.erp.model.RequestQuotation,com.spcl.erp.model.RfqProductList"%>
<%@page import="com.spcl.erp.services.PurchaseService, java.util.*,com.spcl.erp.services.CustomerService"%>
<%@page import="com.spcl.erp.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	String contextPath = request.getContextPath();
	 Helper helper = (Helper)request.getAttribute("helper");
	PurchaseService purchaseService=(PurchaseService)request.getAttribute("purchaseService"); 
	CustomerService customerService=(CustomerService)request.getAttribute("customerService"); 
%> 

<!-- Page-header start -->
<div class="page-header">
    <div class="row align-items-end">
        <div class="col-lg-8">
            <div class="page-header-title">
                <div class="d-inline">
                    <h4>Requests for Quotation</h4>
                    <span>View rfq in system.</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4">
            <div class="page-header-breadcrumb">
                <ul class="breadcrumb-title">
                    <li class="breadcrumb-item">
                        <a href="index.html"> <i class="feather icon-home"></i> </a>
                    </li>
                    <li class="breadcrumb-item"><a href="#!">Request for quotation</a>
                    </li>
                     <li class="breadcrumb-item"><a href="#!">View</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Page-header end -->
<div class="page-body">
    <!-- Container-fluid starts -->
    <div class="container">
         <!-- Main content starts -->
        <div>
        <%	RequestQuotation rfq=(RequestQuotation)request.getAttribute("rfq");
			String opr_mode=(String)request.getAttribute("opr_mode");
			
				if(opr_mode!=null&&rfq!=null){
					List<RfqProductList> prod_list=rfq.getRfqproductlist();
					if(prod_list!=null&&prod_list.size()>0){
						if(opr_mode.equals("view")){
			
			%>	
			  <div class="row text-center">
                   <div class="col-sm-12 invoice-btn-group text-center">
                       <button type="button" class="btn btn-primary btn-print-invoice m-b-10 btn-sm waves-effect waves-light m-r-20">Print</button>
                       <button type="button" class="btn btn-danger waves-effect m-b-10 btn-sm waves-light">Cancel</button>
                   </div>
               </div>
           <!-- Invoice card start -->
               <div class="card">
                   <div class="row invoice-contact">
                       <div class="col-md-8">
                           <div class="invoice-box row">
                               <div class="col-sm-12">
                                   <table class="table table-responsive invoice-table table-borderless">
                                       <tbody>
                                           <tr>
                                               <td><img src="../files/assets/images/logo-blue.png" class="m-b-10" alt=""></td>
                                           </tr>
                                           <tr>
                                               <td><%=rfq.getCustomer().getCust_id() %></td>
                                           </tr>
                                           <tr>
                                               <td>123 6th St. Melbourne, FL 32904 West Chicago, IL 60185</td>
                                           </tr>
                                           <tr>
                                               <td><a href="https://colorlib.com/cdn-cgi/l/email-protection#81e5e4eceec1e6ece0e8edafe2eeec" target="_top"><span class="__cf_email__" data-cfemail="96f2f3fbf9d6f1fbf7fffab8f5f9fb">[email&#160;protected]</span></a>
                                               </td>
                                           </tr>
                                           <tr>
                                               <td>+91 919-91-91-919</td>
                                           </tr>
                                           <!-- <tr>
                           <td><a href="#" target="_blank">www.demo.com</a>
                           </td>
                       </tr> -->
                                       </tbody>
                                   </table>
                               </div>
                           </div>
                       </div>
                       <div class="col-md-4">
                       </div>
                   </div>
                   <div class="card-block">
                       <div class="row invoive-info">
                           <div class="col-md-4 col-xs-12 invoice-client-info">
                               <h6>Client Information :</h6>
                               <h6 class="m-0"><%=customerService.getCustomerByFullName(rfq.getCustomer()) %></h6>
                               <p class="m-0 m-t-10"><%=helper.getCustomerAddress(rfq.getCustomer())%></p>
                               <p class="m-0"><%=rfq.getCustomer().getCust_phone() %></p>
                               <p><%=rfq.getCustomer().getCust_email()%></p>
                           </div>
                           <div class="col-md-4 col-sm-6">
                               <h6>Order Information :</h6>
                               <table class="table table-responsive invoice-table invoice-order table-borderless">
                                   <tbody>
                                       <tr>
                                           <th>Date :</th>
                                           <td><%=rfq.getRfq_odr_date() %></td>
                                       </tr>
                                       <tr>
                                           <th>Status :</th>
                                           <td>
                                               <span class="label label-warning">Pending</span>
                                           </td>
                                       </tr>
                                       <tr>
                                           <th>Id :</th>
                                           <td>
                                               #145698
                                           </td>
                                       </tr>
                                   </tbody>
                               </table>
                           </div>
                           <div class="col-md-4 col-sm-6">
                               <h6 class="m-b-20">Invoice Number <span>#12398521473</span></h6>
                               <h6 class="text-uppercase text-primary">Total Due :
                                   <span>$900.00</span>
                               </h6>
                           </div>
                       </div>
                       <div class="row">
                           <div class="col-sm-12">
                               <div class="table-responsive">
                                   <table class="table  invoice-detail-table">
                                       <thead>
                                           <tr class="thead-default">
                                               <th>Product</th>
                                               <th>Quantity</th>
                                               <th>Amount</th>
                                               <th>Tax</th>
                                               <th>Total</th>
                                           </tr>
                                       </thead>
                                       <tbody>
                                       <% for(RfqProductList rfpl: prod_list){ %>
                                           <tr>
                                               <td>
                                                   <h6><%=helper.getProductName(rfpl.getRfpl_prod_id()) %></h6>
                                                  
                                               </td>
                                               <td><%=rfpl.getRfpl_qty() %></td>
                                               <td><%=rfpl.getRfpl_unit_price()%></td>
                                               <td><%=rfpl.getRfpl_tax_id() %></td>
                                               <td><%=rfpl.getRfpl_subtotal() %></td>
                                           </tr>
                                           <%} %>
                                       </tbody>
                                   </table>
                               </div>
                           </div>
                       </div>
                       <div class="row">
                           <div class="col-sm-12">
                               <table class="table table-responsive invoice-table invoice-total">
                                   <tbody>
                                       <tr>
                                           <th>Gross Total :</th>
                                           <td><%=rfq.getGross_amount() %></td>
                                       </tr>
                                       <tr>
                                           <th>Taxes (10%) :</th>
                                           <td><%=rfq.getTax_amount() %></td>
                                       </tr>
                                      
                                       <tr class="text-info">
                                           <td>
                                               <hr/>
                                               <h5 class="text-primary">Net Total :</h5>
                                           </td>
                                           <td>
                                               <hr/>
                                               <h5 class="text-primary"><%=rfq.getNet_amount() %></h5>
                                           </td>
                                       </tr>
                                   </tbody>
                               </table>
                           </div>
                       </div>
                       <div class="row">
                           <div class="col-sm-12">
                               <h6>Terms And Condition :</h6>
                               <p>lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor </p>
                           </div>
                       </div>
                   </div>
               </div>
                <%		}
					  }
					}
				%>
               <!-- Invoice card end -->
                 		<div class="row text-center">
                              <div class="col-sm-12 invoice-btn-group text-center">
                                  <button type="button" class="btn btn-primary btn-print-invoice m-b-10 btn-sm waves-effect waves-light m-r-20">Print</button>
                                  <button type="button" class="btn btn-danger waves-effect m-b-10 btn-sm waves-light">Cancel</button>
                              </div>
                          </div>
                                     </div>
                                </div>
                                <!-- Container ends -->
                            </div>
                            <!-- Page body end -->
                        </div>
                    </div>
                    <!-- Warning Section Starts -->

                    <div id="styleSelector">

                    </div>
                    </div>
                </div>
            </div>
        </div>
       
    </div>
</div>
