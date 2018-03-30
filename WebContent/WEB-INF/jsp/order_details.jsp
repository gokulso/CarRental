<%-- 
    Document   : order_details.jsp
--%>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Details</title>
</head>
<body>

</body>
</html>  --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib uri="/WEB-INF/tlds/carrentaltaglib.tld" prefix="crtag" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>

	<c:set var="language" value="${not empty param.language ? param.language :
	                               not empty language ? language :
	                               pageContext.request.locale}" scope="session" />
	<fmt:setLocale value="${language}" />
	<fmt:setBundle basename="text" />

<!DOCTYPE html>

<html>
      
	 <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title><fmt:message key="index.title" /></title>

        <link href="styles/carrentalstyles.css" rel="stylesheet"/>

        <!-- Core CSS - Include with every page -->
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link href="font-awesome/css/font-awesome.css" rel="stylesheet"/>

        <!-- Page-Level Plugin CSS - Dashboard -->
        <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet"/>
        <link href="css/plugins/timeline/timeline.css" rel="stylesheet"/>

        <!-- SB Admin CSS - Include with every page -->
        <link href="css/sb-admin.css" rel="stylesheet"/>
        

     </head>  
            
     <body>
     
    <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header"><fmt:message key="index.orderhistorypaneltitle" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <fmt:message key="index.ordertable.title" />
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <th><fmt:message key="table.vehicle.make" /></th>
                                                <th><fmt:message key="table.vehicle.model" /></th>		
                                                <th><fmt:message key="table.vehicle.gearbox" /></th>
                                                <th><fmt:message key="table.vehicle.airConditioner" /></th>
                                                <th><fmt:message key="table.vehicle.seats" /></th>
                                                <th><fmt:message key="table.vehicle.price" /></th>
                                                <th><fmt:message key="table.vehicle.totalprice" /></th>
                                                <th><fmt:message key="table.vehicle.orderDate" /></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${vehicleList}" var="vehicle">
                                                <tr>
                                                    <td><c:out value="${vehicle.make}" /></td>
                                                    <td><c:out value="${vehicle.model}" /></td>
                                                    <td>
                                                        <c:if test="${vehicle.autoGearbox}">
                                                            <input type="checkbox" name="autoGearbox" disabled="" checked="" />
                                                        </c:if>
                                                        <c:if test="${not vehicle.autoGearbox}">
                                                            <input type="checkbox" name="autoGearbox" disabled="" />
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <c:if test="${vehicle.airConditioner}">
                                                            <input type="checkbox" name="airConditioner" disabled="" checked="" />
                                                        </c:if>
                                                        <c:if test="${not vehicle.airConditioner}">
                                                            <input type="checkbox" name="airConditioner" disabled="" />
                                                        </c:if>
                                                    </td>
                                                    <td><c:out value="${vehicle.seats}" /></td>
                                                    <td><c:out value="${vehicle.dailyPrice}" /></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-6 -->
                </div>
            </div>
            <!-- /#page-wrapper -->
     
  
     
     
     
     
      <!-- Core Scripts - Include with every page -->
        <script src="js/jquery-1.10.2.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>

        <!-- Page-Level Plugin Scripts - Dashboard -->
        <script src="js/plugins/morris/raphael-2.1.0.min.js"></script>
        <script src="js/plugins/morris/morris.js"></script>

        <!-- SB Admin Scripts - Include with every page -->
        <script src="js/sb-admin.js"></script>
     
     </body>























































</html>

