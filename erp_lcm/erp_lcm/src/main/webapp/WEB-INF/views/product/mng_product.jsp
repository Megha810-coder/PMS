<%@ page import="com.spcl.erp.services.LabourService"%>
<%@ page import="java.util.List"%>
<%@ page import="com.spcl.erp.model.Product"%>
<%@ page language="java" contentType="application/json; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String contextPath = request.getContextPath();
   	LabourService labourService=(LabourService)request.getAttribute("labourService");
String json=(String)request.getAttribute("Json");
%>
<%=json%>


<%-- <%
                                	 List<Labour> lab_list =(List<Labour>request.getAttribute("lab_list";
                         	            if(lab_list!=null&&!lab_list.isEmpty()){
                         	                     	int idx_num=1;
                         	                     	for (Labour lab :lab_list) {
                                	%> --%>
                                
                                	<%-- <%=lab.getLab_fname()%>
                                 <%=lab.getLab_mname()%>
                                	<%} } %> --%>
