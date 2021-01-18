<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<footer>
<div class="row col-sm-12">
<div class="col-sm-6"></div>
<div class="col-sm-6">
All Rights Reserved . SPCL Infotech Services Pvt. Ltd.</div>
</div>

   <!-- Required Jquery -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/popper.js/js/popper.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/pcoded.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/vartical-layout.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/script.js"></script>
    
    <!-- j-pro js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/j-pro/js/jquery.ui.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/j-pro/js/jquery.maskedinput.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/pages/j-pro/js/jquery.j-pro.js"></script>
    
    <!-- jquery slimscroll js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/jquery-slimscroll/js/jquery.slimscroll.js"></script>
    
    <!-- modernizr js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/modernizr/js/modernizr.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/modernizr/js/css-scrollbars.js"></script>

    <!-- i18next.min.js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/i18next/js/i18next.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/i18next-xhr-backend/js/i18nextXHRBackend.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/i18next-browser-languagedetector/js/i18nextBrowserLanguageDetector.min.js"></script>
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/bower_components/jquery-i18next/js/jquery-i18next.min.js"></script>
    <!-- notification js -->
    <script type="text/javascript" src="<%=contextPath %>/resources/assets/js/bootstrap-growl.min.js"></script>
    
    <script>
    function notify(from, align, icon, type, animIn, animOut,ntitle,nmsg){
        $.growl({
            		icon: icon,
            		title: ntitle,
            		message: nmsg,
            		url: ''
        		},
        		{
        			element: 'body',
        			type: type,
        			allow_dismiss: true,
        			placement: {
        				from: from,
        				align: align
        			},
        			offset: {
        				x: 30,
        				y: 30
        			},
		            spacing: 10,
		            z_index: 999999,
		            delay: 2500,
		            timer: 1000,
		            url_target: '_blank',
		            mouse_over: false,
		            animate: {
		                enter: animIn,
		                exit: animOut
		            },
		            icon_type: 'class',
		            template: '<div data-growl="container" class="alert" role="alert">' +
		            '<button type="button" class="close" data-growl="dismiss">' +
		            '<span aria-hidden="true">&times;</span>' +
		            '<span class="sr-only">Close</span>' +
		            '</button>' +
		            '<span data-growl="icon"></span>' +
		            '<span data-growl="title"></span>' +
		            '<span data-growl="message"></span>' +
		            '<a href="#" data-growl="url"></a>' +
		            '</div>'
		        });
    		};
	</script>
     
     
</footer>