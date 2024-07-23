<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<h1>Danh sách SP</h1>
<a href="/admin/product/create"><button class="btn btn-success">Add</button> </a>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Image</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${listProduct}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.category.name}</td>
            <td><img style="width: 200px" height="200px" src="${p.image}"></td>
            <td><a href="/admin/product/update/${p.id}"><button class="btn btn-warning">Update</button> </a></td>
        </tr>
    </c:forEach>
</table>