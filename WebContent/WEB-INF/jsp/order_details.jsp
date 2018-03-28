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

