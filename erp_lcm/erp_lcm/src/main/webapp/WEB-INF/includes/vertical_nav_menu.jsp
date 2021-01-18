
<% String contextPath = request.getContextPath(); %>
<nav class="pcoded-navbar">
	<div class="pcoded-inner-navbar main-menu">
	    <div class="pcoded-navigatio-lavel">Navigation</div>
	    <ul class="pcoded-item pcoded-left-item">
	        <!-- <li class="">
	            <a id="basic_form" href="#">
	                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
	                <span class="pcoded-mtext">basic val form</span>
	            </a>
	        </li>
	        <li class="">
	            <a id="small_report" href="#">
	                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
	                <span class="pcoded-mtext">small_page_report</span>
	            </a>
	        </li>
	        <li class="">
	            <a id="big_report" href="#">
	                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
	                <span class="pcoded-mtext">big report</span>
	            </a>
	        </li>
	        	
	        <li class="">
	            <a href="navbar-light.html">
	                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
	                <span class="pcoded-mtext">Dashboard</span>
	            </a>
	        </li> -->
	        <%-- <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-sidebar"></i></span>
	                <span class="pcoded-mtext">Super-Admin</span>
	                
	            </a>
	            <ul class="pcoded-submenu">
	                <li class=" ">
	                    <a id="mng_company_enquiry" href="<%=contextPath %>/company/mng_company_enquiry">
	                        <span class="pcoded-mtext" >Enquiry</span>
	                    </a>
	                </li>
	            </ul>
	        </li>
	        
	        
	        
	        <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-sidebar"></i></span>
	                <span class="pcoded-mtext">HR Management</span>
	                
	            </a>
	            <ul class="pcoded-submenu">
	                <li class=" ">
	                    <a id="mng_employee" href="<%=contextPath %>/employee/mng_employee">
	                        <span class="pcoded-mtext">Employee </span>
	                    </a>
	                    
	                </li>
	                <li class=" pcoded-hasmenu">
	                    <a href="javascript:void(0)">
	                        <span class="pcoded-mtext" >Recruitment</span>
	                    </a>
	                    
	                </li>
	                <li class=" ">
						<a id="mng_bank" href="<%=contextPath %>/bank/mng_bank">
						<span class="pcoded-mtext">Bank</span>
	                    </a>
	                </li>
	                 <li class=" ">
						<a id="mng_account" href="<%=contextPath %>/bank/mng_account">
						<span class="pcoded-mtext">Account</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a id="mng_leave_type" href="<%=contextPath %>/leave/mng_leave_type">
	                        <span class="pcoded-mtext" >Leaves</span>
	                    </a>
	                </li>
	                 <li class=" ">
	                    <a id="mng_leave_request" href="<%=contextPath %>/leave/mng_leave_request">
	                        <span class="pcoded-mtext" >Leaves Request</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a href="#" target="_blank">
	                        <span class="pcoded-mtext">Expenses</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a href="#" target="_blank">
	                        <span class="pcoded-mtext">Attendance</span>
	                    </a>
	                </li>
	                 <li class=" ">
	                    <a href="#" target="_blank">
	                        <span class="pcoded-mtext">Configuration</span>
	                    </a>
	                </li>
	                <li class="">
			            <a id="department_List" href="<%=contextPath %>/department/department_list">
			                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
			                <span class="pcoded-mtext">Department</span>
			            </a>
			        </li>
			        <li class="">
			            <a id="mng_leave_departement" href="<%=contextPath %>/leave/mng_leave_departement">
			                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
			                <span class="pcoded-mtext">Leave Department</span>
			            </a>
			        </li>
			       
	            </ul>
	        </li>
	        
	        <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">Inventory</span>
	            </a>
	            <ul class="pcoded-submenu">
	           		 <li class=" ">
	                    <a id="invent_transfer" href="<%=contextPath %>/transfer/invent_transfer">
	                        <span class="pcoded-mtext">Transfer</span>
	                    </a>	                    
	                </li>
	                 <li class=" ">
	                    <a id="mng_reorder" href="<%=contextPath %>/reorder/mng_reorder">
	                        <span class="pcoded-mtext">Reordering</span>
	                    </a>	                    
	                </li>
	                <li class=" ">
	                    <a id="mng_scrap" href="<%=contextPath %>/scrap/mng_scrap">
	                        <span class="pcoded-mtext">Scrap</span>
	                    </a>	                    
	                </li>
	                 <li class=" ">
	                    <a id="create_operation" href="<%=contextPath %>/warehouse/create_operation">
	                        <span class="pcoded-mtext">Operation</span>
	                    </a>	                    
	                </li>
	                <li class=" ">
		                <a id="warehouse" href="<%=contextPath %>/warehouse/mng_warehouse">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class="pcoded-mtext" >Warehouse</span>
		                </a>
		            </li>
	            </ul>
	        </li>
	        
	        <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-box"></i></span>
	                <span class="pcoded-mtext">Purchase</span>
	                
	            </a>
	            <ul class="pcoded-submenu">
	                <li class=" ">
	                	<a id="mng_rfq"
							href="<%=contextPath %>/purchase/mng_rfq"> 
							<span class="pcoded-mtext">Request For Quotation </span>
						</a>
					</li>
					<li class=" ">
						<a 	id="mng_rfq"
							href="<%=contextPath %>/purchase/mng_po"> 
							<span class="pcoded-mtext">Purchase Order </span>
					</a></li>
					
	                <li class=" ">
	                    <a id="create_bill" href="javascript:void(0)">
	                        <span class="pcoded-mtext" >Create Bill</span>
	                    </a>
	                    
	                </li>
	                <li class="">
	                	<a 	id="mng_saleperson"
							href="<%=contextPath %>/saleperson/mng_saleperson"> 
							<span 	class="pcoded-micon">
								<i class="feather icon-home"></i>
							</span> 
							<span	class="pcoded-mtext">Add SalePerson</span>
						</a>
					</li>
					
	                <li class=" ">
	                    <a id="add_rfq" href="javascript:void(0)">
	                        <span class="pcoded-mtext">Order</span>
	                    </a>
					</li>
	               <li class=" ">
	                    <a id="customer" href="<%=contextPath %>/customer/mng_customer">
	                        <span class="pcoded-mtext" >Vendors</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a id="mng_product" href="<%=contextPath %>/product/mng_product">
	                        <span class="pcoded-mtext">Product</span>
	                    </a>
	                </li>
	                
	            </ul>
	        </li> --%>
		   
	        <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">LCM</span>
	            </a>
	            <ul class="pcoded-submenu">
	            <li class=" ">
	                    <a id="contract" href="<%=contextPath %>/labour/report">
	                        <span class="pcoded-mtext">Reports</span>
	                    </a>	                    
	                </li>
	                <li class=" ">
                    <a id="hr_requirement" href="<%=contextPath %>/hr_requirement/mng_hr_requirement">
                     <span class="pcoded-mtext">Hr Requirement</span>
                    </a>
                    
                </li>
	           		 <li class=" ">
	                    <a id="contract" href="<%=contextPath %>/labour/mng_contract">
	                        <span class="pcoded-mtext">Contractor List</span>
	                    </a>	                    
	                </li>
	                 <li class=" ">
	                    <a id="labour" href="<%=contextPath %>/labour/mng_labour">
	                        <span class="pcoded-mtext">Labour List</span>
	                    </a>	                    
	                </li>
	                  <li class=" ">
	                    <a id="labourCheck" href="<%=contextPath %>/labour/mng_checkIn">
	                        <span class="pcoded-mtext">Manual labour Check</span>
	                    </a>	                    
	                </li>
	                 <li class=" ">
	                    <a id="labourCheck" href="<%=contextPath %>/labour/mng_attendance">
	                        <span class="pcoded-mtext">Attendance</span>
	                    </a>	                    
	                </li>
	                <!--  <li class=" ">
	                    <a id="mng_reorder" href="#">
	                        <span class="pcoded-mtext">Product Management</span>
	                    </a>	                    
	                </li> -->
	               <!--  <li class=" ">
	                    <a id="mng_scrap" href="#">
	                        <span class="pcoded-mtext">Hazardous Substance Management</span>
	                    </a>	                    
	                </li>
	                 <li class=" ">
	                    <a id="create_operation" href="#">
	                        <span class="pcoded-mtext">Dangerous Goods Management</span>
	                    </a>	                    
	                </li>
	                <li class=" ">
		                <a id="warehouse" href="#">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class="pcoded-mtext" >Waste Management</span>
		                </a>
		            </li>
		            <li class=" ">
		                <a id="warehouse" href="#">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class="pcoded-mtext" >Occupational Safety</span>
		                </a>
		            </li> -->
		            <%-- <li class=" ">
		                <a id="mng_ehs" href="<%=contextPath %>/ehs/mng_ehs">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class="pcoded-mtext" >Incident And Accident Management</span>
		                </a>
		            </li>
		            <li class=" ">
		                <a id="warehouse" href="#">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class="pcoded-mtext" >Industrial Hygiene And Safety</span>
		                </a>
		            </li>
		            <li class=" ">
		                <a id="warehouse" href="#">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class="pcoded-mtext" >EHS Analytics/EHS Reports</span>
		                </a>
		            </li> --%>
	            </ul>
	        </li>
	         <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">EHS</span>
	            </a>
	            <ul class="pcoded-submenu">
	            <li class=" ">
		                <a id="mng_ehs" href="<%=contextPath %>/ehs/mng_ehs">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class=" " >1) Incident And Accident Management</span>
		                </a>
		            </li> 
		             <li class=" ">
                    <a id="mng_hira" href="<%=contextPath %>/ehs/mng_hira">
                    <span class="pcoded-micon"><i class="feather icon-home"></i></span>
                        <span class="">2)Hazard Identification and Risk Analysis (HIRA)</span>
                    </a>	                    
               	  </li>
		             <li class=" ">
                    <a id="mng_hazardous"  href="<%=contextPath %>/ehs/mng_hazardous">
                        <span class=" ">3) Hazardous Material Management</span>
                    </a>	                    
                </li> 
                <%--   <li class=" ">
                    <a id="mng_dangrous_goods" href="<%=contextPath %>/ehs/mng_danagrous_goods_list">
                        <span class="pcoded-mtext">Dangerous Goods Management</span>
                    </a>	                    
                </li> --%>
	           		 
	                 <li class=" ">
	                    <a id="mng_product" href="<%=contextPath %>/ehs/mng_product">
	                        <span class=" ">4) Product Management</span>
	                    </a>	                    
	                </li>
	              
	                <li class=" ">
		                <a id="mng_waste_list" href="<%=contextPath %>/ehs/mng_waste_list">
		                    <span class=" " >5) Waste Management</span>
		                </a>
		            </li>
		            <li class=" ">
		                <a id="mng_occupational_programs_list" href="<%=contextPath %>/ehs/mng_occupational_programs_list">
		                    <span class=" " >6) Occupational Safety Training</span>
		                </a>
		            </li>
		       <li class=" ">
		                <a id="mng_industrial_hygine_programs_list" href="<%=contextPath %>/ehs/mng_industrial_hygine_programs_list">
		                    <span class=" " >7) Industrial Hygiene And Safety</span>
		                </a>
		            </li>
		               <li class=" ">
	                    <a id="invent_transfer" href="#">
	                        <span class=" ">8) Basic Data And Tools</span>
	                    </a>	                    
	                </li>
		            <li class=" ">
		                <a id="warehouse" href="#">
		                <span class="pcoded-micon"><i class="feather icon-home"></i></span>
		                    <span class=" " >9) EHS Analytics/EHS Reports</span>
		                </a>
		            </li>
	            </ul>
	        </li>
	        <%--  <li class="">
	            <a href="#">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">CRM</span>
	            </a>
	        </li>
	         <li class="">
	            <a href="#">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">TPM</span>
	            </a>
	        </li>
	         <li class="">
	            <a href="#">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">Customize E-Learning Solutions</span>
	            </a>
	        </li>
	        <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-layers"></i></span>
	                <span class="pcoded-mtext" >Production</span>
	               
	            </a>
	            <ul class="pcoded-submenu">
	                 <li class=" ">
	                    <a id="add_product"  href="javascript:void(0)">
	                        <span class="pcoded-mtext" >Products and Operation</span>
	                    </a>
	                </li>
	                <li class=" ">
                         <a id="create_bill_material" href="<%=contextPath %>/bill/bill_material_list">
                             <span class="pcoded-mtext" >Bill Of Material</span>
                         </a>
                    </li>
                    <li class=" ">
                          <a id="create_Manufacturing" href="javascript:void(0)">
                              <span class="pcoded-mtext" >Manufacturing</span>
                          </a>
                    </li>
                     <li class=" ">
                          <a id="scrap" href="<%=contextPath %>/scrap/mng_scrap">
                              <span class="pcoded-mtext" >Scrap Order</span>
                          </a>
                    </li>
	                <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Tasks</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Quality Control</span>
	                    </a>
	                </li>
	                 <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Setups and plans</span>
	                    </a>
	                </li>
	                 <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Maintenance</span>
	                    </a>
	                </li>
	                  <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Reports</span>
	                    </a>
	                </li>
	            </ul>
	        </li>
	        <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-box"></i></span>
	                <span class="pcoded-mtext" >Finance and Accounting</span>
	            </a>
	            <ul class="pcoded-submenu">
	                <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext">Customers</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Vendors</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Accounting</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a href="#">
	                        <span class="pcoded-mtext" >Reports</span>
	                    </a>
	                </li>
	                <li class=" ">
	                    <a  href="#">
	                        <span class="pcoded-mtext" >General Settings</span>
	                    </a>
	                </li>
	               
	            </ul>
	        </li>
	         <li class="pcoded-hasmenu">
	            <a href="javascript:void(0)">
	                <span class="pcoded-micon"><i class="feather icon-mail"></i></span>
	                <span class="pcoded-mtext">Marketing</span>
	                
	            </a>
	            <ul class="pcoded-submenu">
	                
	                <li class=" ">
	                    <a id="compose_mail" href="javascript:void(0)">
	                        <span class="pcoded-mtext" >Compose Mail</span>
	                    </a>
	                    
	                </li>
	                <li class=" ">
	                    <a id="new_contact" href="<%=contextPath %>/marketing/new_contact">
	                        <span class="pcoded-mtext" >Contacts</span>
	                    </a>
	                    
	                </li>
	            </ul>
	        </li>
	            	
	        <li class="">
	            <a href="navbar-light.html">
	                <span class="pcoded-micon"><i class="feather icon-menu"></i></span>
	                <span class="pcoded-mtext">Sales</span>
	            </a>
	        </li> --%>
	        
	        
	    </ul>
	    <!-- <div class="pcoded-navigatio-lavel">UI Element</div> -->
	     </div>
	</nav>
	<% 	String url= (String)request.getAttribute("url");
		if(url!=null){
			url=url.substring(url.lastIndexOf("/")+1,url.length());
			
		
	%>
	
	
		<script type="text/javascript">
			$(document).ready(function() {
				$("#<%=url %>").closest('ul').closest('li').addClass('pcoded-trigger');
				$("#<%=url %>").closest('li').addClass('active');
				
			});
		</script>
	<%} %>
	 
	                    