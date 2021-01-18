<%@ page import="com.spcl.erp.services.EHSService"%>
<%@ page import="java.util.List"%>
<%@ page import="com.spcl.erp.model.Ehs_Waste"%>
<%@ page language="java" contentType="application/json; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
    String contextPath = request.getContextPath();
    EHSService ehsService=(EHSService)request.getAttribute("ehsService");
	String json=(String)request.getAttribute("Json");
%>
	<%=json%>
	

<%-- <%
				                                		List<Contractor> contractor_list =(List<Contractor>)request.getAttribute("contractor_list");
                         					          	if(lab_list!=null&&!lab_list.isEmpty()){
                         					                    	int idx_num=1;
                         					                    	for (Labour lab :lab_list) {
				                                	%> --%>
				                                
					                                	<%-- <%=lab.getLab_fname()%>
					                                		<%=lab.getLab_mname()%>
					                                		<%=lab.getLab_mobile_no()%>
					                                		<%=lab.getLab_dob()%>
					                                	<%} } %> --%>
