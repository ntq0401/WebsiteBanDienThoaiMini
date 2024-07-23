<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<h1>Danh sách tài khoản</h1>
<a href="/admin/account/create"><button class="btn btn-success">Add</button></a>
<table class="table">
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listAccount}" var="a">
        <tr>
            <td>${a.username}</td>
            <td>${a.password}</td>
            <td>${a.fullname}</td>
            <td>${a.email}</td>
            <td><a href="/admin/account/update/${a.username}"><button class="btn btn-warning">Update</button></a></td>
        </tr>
    </c:forEach>
</table>