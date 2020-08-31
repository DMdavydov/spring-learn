<%--
  Created by IntelliJ IDEA.
  User: Robikman
  Date: 21.06.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2> CRM </h2>
    </div>
</div>

<div id="container">
    User: <security:authentication property="principal.username"/>;
    Roles: <security:authentication property="principal.authorities"/>
    <div id="content">
        <security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
            <input type="button" value="Add Customer"
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"
            />
        </security:authorize>
        <table>
            <tr>
                <th>First name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <tr>
                    <td> ${customer.firstName} </td>
                    <td> ${customer.lastName} </td>
                    <td> ${customer.email} </td>
                    <td>
                        <security:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
                        </security:authorize>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout"/>
</form:form>
</body>
</html>
