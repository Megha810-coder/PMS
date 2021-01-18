<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  
	<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>
	
	
	<body> 
		<jsp:include page="/WEB-INF/includes/loader.jsp"></jsp:include>
	    
	    <div id="pcoded" class="pcoded">
	        <div class="pcoded-overlay-box"></div>
	        <div class="pcoded-container navbar-wrapper">
	            <!-- Add horizantal menu here -->
	            <jsp:include page="/WEB-INF/includes/horizantal_nav_menu.jsp"></jsp:include>
	            
	            <div class="pcoded-main-container">
	                <div class="pcoded-wrapper">
	                    <!-- Add vertical menu here -->
	                    <jsp:include page="/WEB-INF/includes/vertical_nav_menu.jsp"></jsp:include>
	                    <div class="pcoded-content">
	                        <div class="pcoded-inner-content">
	                            <div class="main-body">
	                                <div class="page-wrapper">
	                                    <!-- Add pagebody here -->
	                                    <div id="page_body" >
	                                    	
	                                    </div>
									 </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	        <!-- <div id="styleSelector">
	        </div> -->
	    </div>
	    
	    <!-- add footer page here -->
	   	<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>
	   	
	    <script>
	        $(document).ready(function () {
	            $("#big_report").on('click',function () { 
	            	
	                $("#page_body").load('complete_report.html');
	            });
	            $("#small_report").on('click',function () {                
	                $("#page_body").load('product_rep.html');
	            });
	            $("#basic_form").on('click',function () {                
	                $("#page_body").load('product_add.html');
	            });
	
	            $("#add_cust_vend").on('click',function () { 
	            	$("#page_body").load('<%=contextPath %>/vendor_add');
	            	
	            	$.ajax({
                    	url: '<%=contextPath %>/vendor_add',
                    	type: 'GET',
                    	dataType :'text',
                    	success: function (data) {
                    		if (data!='') {
                    			$("#page_body").append(data);
							}
                    	},
	                    error: function(xhr, textStatus, thrownError) {
	                        alert("Error load page");
	                    },
	                    cache: false,
	                    contentType: false,
	                    processData: false
	           		});
	            });
	            
	            $("#add_rfq").on('click',function () {                
	                $("#page_body").load('<%=contextPath %>/leave');
	            });
	            $("#leave_type").on('click',function () {                
	                $("#page_body").load('<%=contextPath %>/leave/mng_leave_type');
	            });
	            $("#create_bill").on('click',function () {                
	                $("#page_body").load('create_purchase_bill.html');
	            });
	            $("#compose_mail").on('click',function () {                
	                $("#page_body").load('compose_email.html');
	            });
	 		 	$("#add_product").on('click',function () { 
	            	$("#page_body").load('<%=contextPath %>/product_create');
	            });
	            
	        });
	    </script>
	</body>
</html>