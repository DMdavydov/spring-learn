<%--
  Created by IntelliJ IDEA.
  User: Robikman
  Date: 21.06.2020
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
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
    <div id="content">
        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"
        />
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
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
