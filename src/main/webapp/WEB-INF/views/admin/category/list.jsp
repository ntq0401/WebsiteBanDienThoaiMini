<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<h1>Danh sách nhóm SP</h1>
<a href="admin/category/create"><button class="btn btn-success">Add</button></a>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listCate}" var="ct">
        <tr>
            <td>${ct.id}</td>
            <td>${ct.name}</td>
            <td><a href="/admin/category/update/${ct.id}"><button class="btn btn-warning">Update</button></a> </td>
        </tr>
    </c:forEach>
</table>