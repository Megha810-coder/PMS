<%@page import="com.spcl.erp.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 	
	Helper help= (Helper)request.getAttribute("help");
	String contextPath = request.getContextPath();
	
%>

<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
    <meta 	name="viewport" 
				content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    	<meta 	name="description" 
    			content="#">
    	<meta 	name="keywords" 
    			content="ERP, Order, Purchase, PO, Invoicing, Account, Accounting, Company Management">
    
    	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    	<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    	<meta http-equiv="cache-control" content="no-cache" />
    	<meta http-equiv="Pragma" content="no-cache" />
    	<meta http-equiv="Expires" content="-1" />
    	<title>SPCL - ERP System </title>
    	
    	<!-- Favicon icon -->
    	<link rel="icon" href="https://colorlib.com//polygon/adminty/files/assets/images/favicon.ico" type="image/x-icon">
		
		<!-- Google font-->
    	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,800" rel="stylesheet">
	    
	    <!-- Required Fremwork -->
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrap.min.css">
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/bower_components/bootstrap/css/bootstrapvalidator.css">
	    
	    <!-- themify-icons line icon -->
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/icon/themify-icons/themify-icons.css">
	    <!-- ico font -->
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/icon/icofont/css/icofont.css">
	    <!-- feather Awesome -->
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/icon/feather/css/feather.css">
	    <!-- jpro forms css -->
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/pages/j-pro/css/demo.css">
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/pages/j-pro/css/font-awesome.min.css">
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/pages/j-pro/css/j-pro-modern.css">
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/pages/j-pro/css/j-forms.css">
	    <!-- Style.css -->
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/css/style.css">
	    <link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/css/jquery.mCustomScrollbar.css">
		
</head>

<body>
<!-- Pre-loader start -->
<div class="theme-loader">
    <div class="ball-scale">
        <div class='contain'>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
            <div class="ring">
                <div class="frame"></div>
            </div>
        </div>
    </div>
</div>
<!-- Pre-loader end -->
<div id="pcoded" class="pcoded iscollapsed">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">

        <nav class="navbar header-navbar pcoded-header">
            <div class="navbar-wrapper">
				<div class="navbar-logo">
                   
                    <a href="index.html">
                        <img class="img-fluid" src="<%=contextPath %>/resources/assets/images/logo.png"  alt="Theme-Logo" />
                    </a>
                </div>
			</div>
        </nav>
       
        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <div class="pcoded-content" style="margin-left: 0px;" >
                    <div class="pcoded-inner-content">
                        <!-- Main-body start -->
                        <div class="main-body">
                            <div class="page-wrapper">
                                <!-- Page-header start -->
                                <div class="page-header">
                                    <div class="row align-items-end">
                                        <div class="col-lg-12" >
                                            <div class="page-header-title">
                                                <div class="d-inline">
                                                 <img src="resources/logo/logo.jpg" alt="SPCL infotech" WIDTH=150 HEIGHT=100>
                                                <span align="right"><font size="12"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SPCL INFOTECH SERVICES PVT LTD</b></font></span>
                                                  
                                                   <!--  <h4>Complete Enterprise Resource Planning system</h4>
                                                    <span>Computers have become so complex and commonplace in organizations, it is much easier to integrate all of the data and processing software modules and hardware into one large unit that is easier to access and control. This is called Enterprise Resource Planning, or ERP. Normally ERP systems use the same database throughout an entire company to store various types of data for different computerized functions. When first developed, ERP systems were used only for large manufacturing companies. Today, they benefit all sizes of companies, even those that are quite small.</span> -->
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Page-header end -->

<!-- page body start -->
<div class="page-body">
    <!-- Subscribe From card start -->
  
    <div class="card" >
    	<div class="card-block" style="background-color:#c0c0c0" >
    		<div id="file_error" class="alert alert-danger background-danger" style="display: none;">
		        
		    </div>
		    
		    <c:if test="${not empty error}">
				<div class="alert alert-danger background-danger">
			        
			        ${error} 
			    </div>
				
			</c:if>
			<c:if test="${not empty msg}">
				
			    <div class="alert alert-success background-success">
		           
		           ${msg} 
		       </div>
			</c:if>
    	
            <div class="wrapper wrapper-640">
                <div class="j-tabs-container">
                    <!-- start tab #1 -->
                    <input id="tab1" type="radio" name="tabs" checked>
                    <label class="j-tabs-label" for="tab1" title="Login">
                        <i class="icofont icofont-login "></i>
                        <span>Login</span>
                    </label>
                    <!-- end tab #1 -->
                    
                    <!-- start tab #2 -->
                    <input id="tab2" type="radio" name="tabs">
                    <label class="j-tabs-label" for="tab2" title="Registration">
                        <i class="icofont icofont-ui-user"></i>
                        <span>Registration</span>
                    </label>
                    <!-- end tab #2 -->
                    <!-- start tab #3 -->
                    <input id="tab3" type="radio" name="tabs">
                    <label class="j-tabs-label" for="tab3" title="Reset password">
                        <i class="icofont icofont-unlock"></i>
                        <span>Reset password</span>
                    </label>
                    <!-- end tab #3 -->
                    <!-- start form #1 -->
                    <div id="tabs-section-1" class="j-tabs-section">
                        <form action="<%=contextPath %>/check_app_user"  id="form_login" method="post" class="j-forms" novalidate>
                            <div class="content">
                                <div class="j-row">
                                    <div class="span6">
                                        <div class="divider-text gap-top-20 gap-bottom-45">
                                            <span>Sign in with</span>
                                        </div>
                                        <!-- start social icons-->
                                        <div class="unit">
                                            <div class="social-center">
                                                <div class="social-icon twitter">
                                                    <i class="fa fa-twitter"></i>
                                                    <button type="button"></button>
                                                </div>
                                                <div class="social-icon google-plus">
                                                    <i class="fa fa-google-plus"></i>
                                                    <button type="button"></button>
                                                </div>
                                                <div class="social-icon facebook">
                                                    <i class="fa fa-facebook"></i>
                                                    <button type="button"></button>
                                                </div>
                                                <div class="social-icon linkedin">
                                                    <i class="fa fa-linkedin"></i>
                                                    <button type="button"></button>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- end social icons-->
                                    </div>
                                    <!-- end /.span6 -->
                                    <div class="span6">
                                        <div class="divider-text gap-top-20 gap-bottom-45">
                                            <span>Or login</span>
                                        </div>
                                        <!-- start login -->
                                        <div class="unit form-group">
                                            <div class="input">
                                                <label class="icon-right" for="user_name">
                                                    <i class="icofont icofont-ui-user"></i>
                                                </label>
                                                <input type="text" id="user_name" name="user_name" placeholder="Enter Username" required data-bv-notempty-message="Enter username.">
                                            </div>
                                        </div>
                                        <!-- end login -->
                                        <!-- start password -->
                                        <div class="unit form-group">
                                            <div class="input">
                                                <label class="icon-right" for="password">
                                                    <i class="icofont icofont-lock"></i>
                                                </label>
                                                <input type="password" id="password" name="password" placeholder="Enter password..." required data-bv-notempty-message="Enter Password.">
                                            	<input type="hidden" id="token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            </div>
                                        </div>
                                        <!-- end password -->
                                        <!-- start keep logged 
                                        <div class="unit">
                                            <div class="checkbox-fade fade-in-primary">
                                                <label>
                                                    <input type="checkbox" value="true" checked="">
                                                    <span class="cr">
                                                        <i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                                    </span>
                                                    <span>Keep me logged in</span>
                                                </label>
                                            </div>
                                        </div>
                                        end keep logged -->
                                    </div>
                                    <!-- end /.span6 -->
                                </div>
                                <!-- end /.j-row -->
                                <button type="submit" class="btn btn-primary m-b-20 f-right">Sign in</button>
                            </div>
                            <!-- end /.content -->
                        </form>
                    </div>
                    <!-- end form #1 -->
                    
                    <!-- start form #2 -->
                    <div id="tabs-section-2" class="j-tabs-section">
                        <form id="form_reg" method="post" class="j-forms" action="<%=contextPath%>/company/reg_enq" modelAttribute="com_enquiry">
                            <input type=hidden class="form-control" id="enq_id"name="enq_id" value="${com_enquiry.enq_id}" />
                            <div class="content">
                                <div class="divider-text gap-top-20 gap-bottom-45">
                                    <span>Registration</span>
                                </div>
                                <!-- start name -->
                                <div class="unit form-group">
                                    <label class="icon-right" for="u_full_name">
                                        <i class="icofont icofont-ui-user"></i>
                                    </label>
                                    <input type="text" id="enq_name"  name="enq_name" placeholder="Full name" required data-bv-notempty-message="Enter Full name.">
                                </div>
                                <!-- end name -->
                                <!-- start email,contact -->
                                <div class="j-row">
                                    <div class="span6 unit">
                                        <div class="input">
                                            <label class="icon-right" for="u_email">
                                                <i class="icofont icofont-envelope"></i>
                                            </label>
                                            <input type="email" id="enq_email" name="enq_email" placeholder="Email id" required data-bv-notempty-message="Enter email id" >
                                        </div>
                                    </div>
                                    <div class="span6 unit">
                                        <div class="input">
                                            <label class="icon-right" for="u_contact_no">
                                                <i class="icofont icofont-phone"></i>
                                            </label>
                                            <input type="text" id="enq_cotc_num" name="enq_cotc_num" placeholder="Contact number" class="form-control" required data-bv-notempty-message="Enter contact number" pattern="^[0-9]+$" data-bv-regexp-message="only numbers are allowed">
                                        </div>
                                    </div>
                                </div>
                                <!-- end email,contact -->

                                <!-- start company name -->
                                <div class="unit">
                                    <label class="icon-right" for="enq_company_name">
                                        <i class="icofont icofont-building"></i>
                                    </label>
                                    <input type="text" id="enq_company_name"  name="enq_company_name" placeholder="Company name" required data-bv-notempty-message="Enter company name.">
                                
                                </div>
                                <!-- end company name -->

                                <!-- start designation,country -->
                                <div class="j-row">
                                    
                                    <div class="span6 unit form-group">
                                        <label class="input select">
                                        <select id="enq_post_id" name="enq_post_id" required data-bv-notempty-message="Please select designation">
                                            <option value="" selected>select designation..</option>
                                            <option value="1">Software engineer</option>
                                            <option value="2">Systems analyst</option>
                                            <option value="3">Business analyst</option>
                                            <option value="4">Technical support</option>
                                            <option value="5">Network engineer</option>
                                            <option value="6">Technical consultant</option>
                                            <option value="7">Technical sales</option>
                                            <option value="8">Project manager</option>
                                            <option value="9">Web developer</option>
                                            <option value="10">Software tester</option>
                                        </select>
                                        <i class="icofont icofont-caret-down"></i>
                                     </label>
                                    </div>
                                    <div class="span6 unit form-group">
                                        <label class="input select">
                                        <select name="enq_country_id" required data-bv-notempty-message="Please select country">
                                            <option value="" selected>select country..</option>
                                           <%=help.getContryDropDown() %>
                                        </select>
                                        <i class="icofont icofont-caret-down"></i>
                                     </label>
                                    </div>
                                </div>
                                <!-- end email,contact -->

                                <!-- start Message -->
                                <div class="unit">
                                    <div class="j-input">
                                        <textarea spellcheck="false" name="enq_description" style="height: 80px;" placeholder="Comments/Message"></textarea>
                                    </div>
                                </div>
                                <!-- end Message -->

                                <div class="divider gap-bottom-25"></div>
                                                                
                                <input type="submit" class="btn btn-primary m-b-20 f-right" value="Register"></input>
                            </div>
                            <!-- end /.content -->
                        </form>
                    </div>
                    <!-- end form #2 -->
                    
                    <!-- start form #3 -->
                    <div id="tabs-section-3" class="j-tabs-section">
                        <form action="#" id="form_fgpwd" method="post" class="j-forms" novalidate>
                            <div class="content">
                                <div class="divider-text gap-top-20 gap-bottom-45">
                                    <span>Password recovery</span>
                                </div>
                                <!-- start widget button 130 -->
                                <div class="unit form-group">
                                    <div class="widget right-130">
                                        <div class="input">
                                            <input type="email" placeholder="enter your email" name="u_fg_email" required data-bv-notempty-message="Please enter email id" >
                                        </div>
                                        <button type="submit" class="addon-btn adn-130 adn-right">
                                            Recovery
                                        </button>
                                    </div>
                                </div>
                                <!-- end widget button 130 -->
                            </div>
                            <!-- end /.content -->
                        </form>
                    </div>
                    <!-- end form #3 -->
                </div>
            </div>
        </div>

    </div>
    <!-- Subscribe From card end -->
</div>
<!-- page body end -->
                            </div>
                        </div>
                        <!-- Main-body end -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

    
    
    <!-- Required Jquery -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/jquery/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/jquery-ui/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/popper.js/js/popper.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrapvalidator.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/pcoded.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/vartical-layout.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/script.js"></script>

    <!-- j-pro js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/j-pro/js/jquery.ui.min.js"></script>
    <!-- jquery slimscroll js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/jquery-slimscroll/js/jquery.slimscroll.js"></script>
    <!-- modernizr js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/modernizr/js/modernizr.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/modernizr/js/css-scrollbars.js"></script>

    <!-- i18next.min.js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/i18next/js/i18next.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/i18next-xhr-backend/js/i18nextXHRBackend.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/i18next-browser-languagedetector/js/i18nextBrowserLanguageDetector.min.js"></script>
    
	
	<script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/jquery-i18next/js/jquery-i18next.min.js"></script><script type="text/javascript">
        $(document).ready(function(){
            $('#form_reg').bootstrapValidator()
                .on("success.form.bv", function() {
                $('#file_error').html("").hide();
                var form = new FormData($('#form_reg')[0]);
                $.ajax({
	                url: '<%=contextPath %>/company/reg_enq',
	                type: 'POST',
	                dataType :'text',
	                complete: function() {}, 
	                success: function (data) {
	                	$('#file_error').append(data).show();
	                },
	                error: function(xhr, textStatus, thrownError) {
	                    alert("Somthing went wrong....");
	                },
	                data: form,
	                cache: false,
	                contentType: false,
	                processData: false
                });
                
                return false;
            });

            $('#form_login').bootstrapValidator();

            $('#form_fgpwd').bootstrapValidator()
                .on("success.form.bv", function() {
                var form = new FormData($('#form_reg')[0]);
                alert('validating form');
                //$("#file_error").text("").hide();
                                
                return false;
            });
            
           
        });
    </script>   
</body>
</html>
