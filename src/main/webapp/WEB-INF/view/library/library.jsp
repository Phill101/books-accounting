<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<page:template>
    <jsp:body>
        <c:url value="/library" var="library"/>
        <c:url value="/admPanel" var="admPanel"/>

        <!-- Page Content -->
        <div class="container">

            <!-- Page Heading/Breadcrumbs -->
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Библиотека
                        <small>Возьми почитать</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="index.html">На главную</a>
                        </li>
                        <li class="active">Библиотека</li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->

            <!-- Content Row -->
            <div class="row">
                <!-- Sidebar Column -->
                <div class="col-md-3">
                    <div class="list-group">
                        <c:if test="${not empty model}">
                            <b>Количество взятых книг: </b><c:out value="${model.userHasBooks}/4"/>
                        </c:if>

                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <a style="color: green" href="${admPanel}"
                               class="list-group-item"><i class="fa fa-fw fa-plus"></i>Добавить категорию/книгу
                            </a>
                        </security:authorize>

                        <c:if test="${not empty model}">
                            <c:forEach var="categoryVar" items="#{model.categories}">
                                <a href="${library}?category=<c:out value="${categoryVar.id}"/>"
                                   class="list-group-item"><c:out value="${categoryVar.name}"/>
                                </a>
                            </c:forEach>
                        </c:if>

                    </div>
                </div>
                <!-- Content Column -->
                <div class="col-md-9">
                    <c:if test="${not empty model}">
                        <c:if test="${not empty model.books}">
                            <table>
                                <c:forEach var="var" items="#{model.books}">
                                    <tr>
                                        <td><b>id:</b></td>
                                        <td><c:out value="${var.id}"/></td>
                                    </tr>
                                    <tr>
                                        <td><b>Автор:</b></td>
                                        <td><c:out value="${var.author}"/></td>
                                    </tr>
                                    <tr>
                                        <td><b>Название:</b></td>
                                        <td><c:out value="${var.name}"/></td>
                                    </tr>
                                    <tr>
                                        <td><b>Количество:</b></td>
                                        <td><c:out value="${var.available}/${var.libQuantity}"/></td>
                                    </tr>
                                    <tr><td><b>

                                        <c:if test="${var.enabled && var.available > 0}">
                                            <c:if test="${model.userHasBooks < 4}">
                                                <a href="${library}?category=${param.category}&getBook=${var.id}" style="color: green">Взять почитать</a>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${!var.enabled}">
                                            <a href="${library}?category=${param.category}&returnBook=${var.id}" style="color: red">Сдать книгу</a>
                                        </c:if>
                                        <c:if test="${var.enabled && (var.available == 0 || model.userHasBooks >= 4)}">
                                            <a style="color: #8c8c8c">Книга недоступна</a>
                                        </c:if>

                                    </b></td></tr>
                                    <tr><td><br/></td></tr>
                                </c:forEach>
                            </table>
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

