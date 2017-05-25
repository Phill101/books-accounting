<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>--%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style type="text/css">
    span.error {
        color: red;
    }
</style>

<page:template>
    <jsp:body>
        <c:url value="/admPanel" var="admPanel"/>
        <c:url value="/admPanel/addBook" var="addBook"/>
        <c:url value="/admPanel/addCategory" var="addCategory"/>
        <c:url value="/admPanel/addUser" var="addUser"/>

        <!-- Page Content -->
        <div class="container">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Панель администрирования
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="/index.html">На главную</a>
                        </li>
                        <li class="active">Панель администрирования</li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->

            <!-- Content Row -->
            <div class="row">
                <!-- Sidebar Column -->
                <div class="col-md-3">
                    <div class="list-group">

                        <a href="${addBook}" class="list-group-item">Добавить книгу</a>
                        <a href="${addCategory}" class="list-group-item">Добавить категорию</a>
                        <a href="${addUser}" class="list-group-item">Зарегистрировать пользователя</a>


                    </div>
                </div>
                <!-- Content Column -->
                <div class="col-md-9">
                    <c:if test="${not empty model.action}">
                        <%--Add book--%>
                        <c:if test="${model.action == 'addBook'}">
                            <c:if test="${model.success}">
                                <b style="color: green">Книга успешно добавлена</b>
                            </c:if>

                            <form:form method="post" modelAttribute="addBookForm">
                                <table>
                                    <tr>
                                        <td>Название книги:</td>
                                        <td><form:input path="bookName"/></td>
                                        <td><span class="error"><form:errors path="bookName"/></span></td>
                                    </tr>
                                    <tr>
                                        <td>Автор книги:</td>
                                        <td><form:input path="bookAuthor"/></td>
                                        <td><span class="error"><form:errors path="bookAuthor"/></span></td>
                                    </tr>
                                    <tr>
                                        <td>Количество книг:</td>
                                        <td><form:input type="number" min="1" max="2147483647" value="1" path="qty"/></td>
                                        <td><span class="error"><form:errors path="qty"/></span></td>
                                    </tr>
                                    <tr>
                                        <td>Название книги:</td>
                                        <td><form:select path="categoryId">
                                            <c:forEach var="categoryVar" items="#{model.categories}">
                                                <option value="${categoryVar.id}">${categoryVar.name}</option>
                                            </c:forEach>
                                        </form:select></td>
                                        <td><span class="error"><form:errors path="categoryId"/></span></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><input type="submit" value="Добавить"></td>
                                    </tr>
                                </table>
                            </form:form>
                        </c:if>
                        <%--Add category--%>
                        <c:if test="${model.action == 'addCategory'}">
                            <c:if test="${model.success}">
                                <b style="color: green">Категория успешно добавлена</b>
                            </c:if>

                            <form:form method="post" modelAttribute="addCategoryForm">
                                <table>
                                    <tr>
                                        <td>Имя категории:</td>
                                        <td><form:input path="categoryName"/></td>
                                        <td><span class="error"><form:errors path="categoryName"/></span></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><input type="submit" value="Добавить"></td>
                                    </tr>
                                </table>
                            </form:form>
                        </c:if>
                        <%--Add user--%>
                        <c:if test="${model.action == 'addUser'}">
                            <c:if test="${model.success}">
                                <b style="color: green">Пользователь успешно зарегистрирован</b>
                            </c:if>

                            <form:form method="post" modelAttribute="regForm">
                                <table>
                                    <tr>
                                        <td>Электронная почта:</td>
                                        <td><form:input path="email"/></td>
                                        <td><span class="error"><form:errors path="email"/></span></td>
                                    </tr>

                                    <tr>
                                        <td>Пароль:</td>
                                        <td><form:password path="password"/></td>
                                        <td><span class="error"><form:errors path="password"/></span></td>
                                    </tr>

                                    <tr>
                                        <td>Подтвердите пароль:</td>
                                        <td><form:password path="confirmPassword"/></td>
                                        <td><span class="error"><form:errors path="confirmPassword"/></span></td>
                                    </tr>

                                    <tr>
                                        <td colspan="3"><input type="submit" value="Зарегистрировать"></td>
                                    </tr>
                                </table>
                            </form:form>

                        </c:if>
                    </c:if>
                </div>
            </div>
            <!-- /.row -->

            <hr>

        </div>
        <!-- /.container -->

    </jsp:body>
</page:template>

