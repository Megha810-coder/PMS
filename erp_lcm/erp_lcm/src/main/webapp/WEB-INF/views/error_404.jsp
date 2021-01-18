<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String contextPath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en-us" class="no-js">
<head>
<meta charset="utf-8">
<title>SPCL - ERP System</title>
<meta name="description" content="Flat able 404 Error page design">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="SPCL">

<link rel="shortcut icon" href="<%=contextPath %>/resources/assets/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="<%=contextPath %>/resources/assets/error_404/error_404.css" />
</head>
<body>
<canvas id="dotty"></canvas>

<div class="content">
<div class="content-box">
<div class="big-content">

<div class="list-square">
<span class="square"></span>
<span class="square"></span>
<span class="square"></span>
</div>

<div class="list-line">
<span class="line"></span>
<span class="line"></span>
<span class="line"></span>
<span class="line"></span>
<span class="line"></span>
<span class="line"></span>
</div>

<i class="fa fa-search" aria-hidden="true"></i>

<div class="clear"></div>
</div>

<h1>Oops! Error 404 not found.</h1>
<p>The page you were looking for doesn't exist.<br>
We think the page may have moved.</p>
</div>
</div>
<footer class="light">
<ul>
<li><a href="#">Support</a></li>
<li><a href="#"><i class="fa fa-facebook"></i></a></li>
<li><a href="#"><i class="fa fa-twitter"></i></a></li>
</ul>
</footer>
<script type="text/javascript" src="<%=contextPath %>/resources/assets/error_404/mozic.js"></script>

</body>
</html>