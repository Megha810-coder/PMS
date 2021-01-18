




 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 	String contextPath = request.getContextPath(); 
    Integer TotalLabour=(Integer)request.getAttribute("TotalLabour");
	 Integer TotalContractor=(Integer)request.getAttribute("TotalContractor");
    Integer totalCHeckIn=(Integer)request.getAttribute("totalCHeckIn");
    Integer shift1Count=(Integer)request.getAttribute("shift1Count");
    Integer shift2Count=(Integer)request.getAttribute("shift2Count");
    Integer shift3Count=(Integer)request.getAttribute("shift3Count");
    Integer TotalHrlabourrequirement=(Integer)request.getAttribute("TotalHrlabourrequirement");
    Number totalweeklyCount=(Number)request.getAttribute("totalweeklyCount");
    %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  
	<jsp:include page="/WEB-INF/includes/header.jsp"></jsp:include>
	<body>
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
                                    <div class="page-body">
                                        <div class="row">

                                            <!-- statustic-card start -->
                                            <div class="col-xl-3 col-md-6">
                                                <div class="card text-white" style="background-color:#ff9999">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col">
                                                                <h5>Number of Contractors</h5><br>
                                                                <a href="<%=contextPath%>/labour/mng_contract"><h4 class="m-b-0">${TotalContractor}</h4></a>
                                                            </div>
                                                            <div class="col col-auto text-right">
                                                                <i class="feather icon-user f-50 text-c-yellow"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                       <div class="col-xl-3 col-md-6">
                                                <div class="card  text-white" style="background-color:  #73c6b6  ">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col">
                                                                <h5>Total Number of Labours </h5><br>
                                                                <a href="<%=contextPath%>/labour/mng_labour"><h4 class="m-b-0">${TotalLabour}</h4></a>
                                                            </div>
                                                            <div class="col col-auto text-right">
                                                                <i class="feather icon-user f-50 text-c-yellow"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card bg-c-yellow text-white">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col">
                                                                <h5>Today's Labour CheckIN</h5><br>
                                                                <a href="<%=contextPath%>/labour/mng_attendance"><h4 class="m-b-0">${totalCHeckIn} </h4></a>
                                                            </div>
                                                            <div class="col col-auto text-right">
                                                                <i class="feather icon-user f-50 text-c-yellow"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                           
                                             <div class="col-xl-3 col-md-6">
                                                <div class="card  text-white" style="background-color: #a9cce3 ">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col">
                                                                <h5>Todays's Employee CheckIn</h5>
                                                                <a href="<%=contextPath%>/labour/mng_checkIn"><h4 class="m-b-0">0</h4></a>
                                                            </div>
                                                            <div class="col col-auto text-right">
                                                                <i class="feather icon-user f-50 text-c-yellow"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        <div class="row">

                                            <!-- statustic-card start -->
                                            <div class="col-xl-4 col-md-6">
                                                <div class="card bg-c-green text-white">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col-xl-8">
                                                                <h5>Shiftwise Checkin Count</h5>
                                                                 <a href="<%=contextPath%>/labour/mng_contract"><h4 class="m-b-0">${totalCHeckIn} </h4></a>
                                                               <h5 class="m-b-0">
	                                                               <a href="<%=contextPath%>/labour/mng_attendance?shift_type=1"> 
	                                                                Shift1:-${shift1Count}
	                                                               </a>
                                                               </h5>
                                                               <h5 class="m-b-0">
                                                               <a href="<%=contextPath%>/labour/mng_attendance?shift_type=2"> 
                                                               	Shift2:-${shift2Count}
                                                               </a>
                                                               </h5>
                                                               <h5 class="m-b-0">
	                                                               <a href="<%=contextPath%>/labour/mng_attendance?shift_type=3"> 
	                                                               	Shift3:-${shift3Count}
	                                                               </a>
                                                               </h5>
                                                            </div>
                                                            <div class="col-xl-4 text-right">
                                                                <i class="feather icon-credit-card f-50 text-c-green"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                           
                                           
                                            <div class="col-xl-4 col-md-6">
                                                <div class="card bg-c-green text-white">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col-xl-8">
                                                                <h5>Checkin Count</h5><br>
                                                               <h5 class="m-b-0">
	                                                               <a href="<%=contextPath%>/labour/mng_attendance?search_type=week"> 
	                                                               	Weekly count	:-${cntlist[0][0]}
	                                                               </a>
                                                               </h5>
                                                               <h5 class="m-b-0">
                                                               <a href="<%=contextPath%>/labour/mng_attendance?search_type=month"> 
                                                               	Monthly count	:-${cntlist[0][1]}
                                                               </a>
                                                               </h5>
                                                               <h5 class="m-b-0">
	                                                               <a href="<%=contextPath%>/labour/mng_attendance?search_type=year"> 
	                                                               	Yearly count	:-${cntlist[0][2]}
	                                                               </a>
                                                               </h5>
                                                            </div>
                                                            <div class="col-xl-4 text-right">
                                                                <i class="feather icon-credit-card f-50 text-c-green"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                             <div class="col-xl-4 col-md-6">
                                                <div class="card bg-c-green text-white">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col-xl-8">
                                                                <h5>Todays Labour Requirement</h5><br>
                                                                 <h4 class="m-b-0"><%=TotalHrlabourrequirement%> </h4>
                                                                                                                             
                                                            </div>
                                                            <div class="col-xl-4 text-right">
                                                                <i class="feather icon-credit-card f-50 text-c-green"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                           
                                           <div class="col-xl-4 col-md-6">
                                                <div class="card bg-c-green text-white">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col-xl-8">
                                                                <p class="m-b-5">Department</p>
                                                                 <a href="<%=contextPath%>/labour/mng_contract"><h4 class="m-b-0">${totalCHeckIn} </h4></a>
                                                               <h5 class="m-b-0">
	                                                               <a href="<%=contextPath%>/labour/mng_attendance?search_type=week"> 
	                                                                Shift1:-${shift1Count}
	                                                               </a>
                                                               </h5>
                                                               <h5 class="m-b-0">
                                                               <a href="<%=contextPath%>/labour/mng_attendance?search_type=month"> 
                                                               	Shift2:-${shift2Count}
                                                               </a>
                                                               </h5>
                                                               <h5 class="m-b-0">
	                                                               <a href="<%=contextPath%>/labour/mng_attendance?search_type=year"> 
	                                                               	Shift3:-${shift3Count}
	                                                               </a>
                                                               </h5>
                                                            </div>
                                                            <div class="col-xl-4 text-right">
                                                                <i class="feather icon-credit-card f-50 text-c-green"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                              <div class="col-xl-3 col-md-6">
                                               <%-- <d iv class="card bg-c-green text-white">
                                                    <div class="card-block">
                                                        <div class="row align-items-center">
                                                            <div class="col">
                                                            <%
                               				List<LabourCheck> report =(List<LabourCheck>)request.getAttribute("report");
                    					          	if(report!=null&&!report.isEmpty()){
                    					                    	int idx_num=1;
                    					                    	for (LabourCheck labourCheck :report) {
                    					                    	
                              						 	%>
                                                              <p class="m-b-5"> Department</p>
                                                           
                                                               <h4>"${department1Count}"=${shift1Count+shift2Count+shift3Count}<h4>
                                                               
                                                                <p class="m-b-5"> Shift1</p>
                                                               <h4>${shift1Count}<h4>
                                                                <p class="m-b-5"> Shift2</p>
                                                                <h4>${shift2Count}<h4>
                                                                <p class="m-b-5"> Shift3</p>
                                                              <h4>${shift3Count}<h4>
                                                            </div>
                                                            <div class="col col-auto text-right">
                                                                <i class="feather icon-credit-card f-50 text-c-green"></i>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> --%>
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>

                                <div id="styleSelector">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>
   
</body>
</html>


 