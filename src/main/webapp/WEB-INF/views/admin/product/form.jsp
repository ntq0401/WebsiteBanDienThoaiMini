<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<h1>Quản lí sản phẩm</h1>
<form:form method="post" modelAttribute="p">
    <p>Name :
        <form:input path="name"/>
    <form:errors path="name"/>
    </p>
    <p>Price :
        <form:input path="price" type="number"/>
        <form:errors path="price"/>
    </p>
    <p>Category :
        <form:select path="category">
            <form:option value="">----------------</form:option>
            <form:options items="${listCategory}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="category"/>
    </p>

    <p>Image :
        <form:input path="image"/>
        <form:errors path="image"/>
    </p>
    <c:if test="${!isUpdate}">
        <button formaction="/admin/product/create" class="btn btn-success">Add</button>
    </c:if>
    <c:if test="${isUpdate}">
        <button formaction="/admin/product/update/${p.id}" class="btn btn-success">Update</button>
    </c:if>
</form:form>