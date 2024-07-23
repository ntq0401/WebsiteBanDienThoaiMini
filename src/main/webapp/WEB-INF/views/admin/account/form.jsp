<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8"%>
<h1>Quản lí tài khoản</h1>
<form:form method="post" modelAttribute="a">
    <p>Username :
        <form:input class="form-control" path="username"/>
        <form:errors class="text-danger" path="username"/>
    </p><p>Password :
        <form:input class="form-control" type="password" path="password"/>
        <form:errors class="text-danger" path="password"/>
    </p><p>Fullname :
        <form:input class="form-control" path="fullname"/>
        <form:errors class="text-danger" path="fullname"/>
    </p><p>Email :
        <form:input class="form-control" path="email"/>
        <form:errors class="text-danger" path="email"/>
    </p>
    <c:if test="${!isUpdate}">
        <button class="btn btn-success" formaction="/admin/account/create">Add</button>
    </c:if>
    <c:if test="${isUpdate}">
        <button class="btn btn-success" formaction="/admin/account/create">Update</button>
    </c:if>
</form:form>