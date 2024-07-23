<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<h1>
    Quản lí nhóm sản phẩm
</h1>
<form:form method="post" modelAttribute="ct">
        <p>ID :
            <form:input class="form-control" path="id"/>
            <form:errors class="text-danger" path="id"/>
        </p>
    <p>Tên :
        <form:input class="form-control" path="name"/>
        <form:errors class="text-danger" path="name"/>
    </p>
    <c:if test="${!isUpdate}">
        <button class="btn btn-success" formaction="/admin/category/create">Add</button>
    </c:if>
    <c:if test="${isUpdate}">
        <button class="btn btn-success" formaction="/admin/category/update/${ct.id}">Update</button>
    </c:if>
</form:form>