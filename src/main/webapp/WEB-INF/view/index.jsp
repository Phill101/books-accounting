<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

  <jsp:attribute name="title">Учёт книг в библиотеке</jsp:attribute>

  <jsp:body>

    <header id="myCarousel" class="carousel slide">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class=""></li>
        <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>

      <!-- Wrapper for slides -->
      <div class="carousel-inner">
        <div class="item">
          <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/images/indexImage1.png');"></div>
          <div class="carousel-caption">
            <h2>Книги – это инструмент насаждения мудрости</h2>
          </div>
        </div>
        <div class="item active">
          <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/images/indexImage2.png');"></div>
          <div class="carousel-caption">
            <h2>Хорошая книга – это подарок, завещанный автором человеческому роду</h2>
          </div>
        </div>
        <div class="item">
          <div class="fill" style="background-image:url('${pageContext.request.contextPath}/resources/images/indexImage3.png');"></div>
          <div class="carousel-caption">
            <h2>Тут ещё один афоризм</h2>
          </div>
        </div>
      </div>

      <!-- Controls -->
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">
        <span class="icon-prev"></span>
      </a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">
        <span class="icon-next"></span>
      </a>
    </header>
    <!-- Page Content -->
    <div class="container">

      <!-- Icons Section -->
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header">
            Тестовое задание – учёт книг в библиотеке
          </h1>
        </div>
        <div class="col-md-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4><i class="fa fa-fw fa-check"></i> Bootstrap v3.2.0</h4>
            </div>
            <div class="panel-body">
              <p>Bootstrap — интуитивно простой и мощный интерфейсный фрейморк, повышающий скорость и облегчающий разработку web-приложений.</p>
              <a href="http://getbootstrap.com/" class="btn btn-default">Подробнее</a>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4><i class="fa fa-fw fa-leaf"></i>Spring Framework</h4>
            </div>
            <div class="panel-body">
              <p>Spring Framework — обеспечивает комплексную модель разработки и конфигурации для современных бизнес-приложений на Java - на любых платформах.</p>
              <a href="http://spring.io" class="btn btn-default">Подробнее</a>
            </div>
          </div>
        </div>
        <div class="col-md-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h4><i class="fa fa-fw fa-compass"></i>Hibernate</h4>
            </div>
            <div class="panel-body">
              <p>Hibernate — библиотека для языка программирования Java, предназначенная для решения задач объектно-реляционного отображения (ORM).</p>
              <a href="http://hibernate.org/" class="btn btn-default">Подробнее</a>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->
      <!-- Portfolio Section -->
      <div class="row">
        <div class="col-lg-12">
          <h2 class="page-header">Здесь применяются</h2>
        </div>
        <div class="col-md-4 col-sm-6">
          <a href="https://java.com">
            <img class="img-responsive img-portfolio img-hover" src="${pageContext.request.contextPath}/resources/images/java8_logo.png" alt="">
          </a>
        </div>
        <div class="col-md-4 col-sm-6">
          <a href="http://spring.io">
            <img class="img-responsive img-portfolio img-hover" src="${pageContext.request.contextPath}/resources/images/spring1.png" alt="">
          </a>
        </div>
        <div class="col-md-4 col-sm-6">
          <a href="https://projects.spring.io/spring-security/">
            <img class="img-responsive img-portfolio img-hover" src="${pageContext.request.contextPath}/resources/images/Spring-Security-logo.png" alt="">
          </a>
        </div>
        <div class="col-md-4 col-sm-6">
          <a href="http://hibernate.org/">
            <img class="img-responsive img-portfolio img-hover" src="${pageContext.request.contextPath}/resources/images/Hibernate-Logo.png" alt="">
          </a>
        </div>
        <div class="col-md-4 col-sm-6">
          <a href="http://getbootstrap.com/">
            <img class="img-responsive img-portfolio img-hover" src="${pageContext.request.contextPath}/resources/images/bootstrap-logo.png" alt="">
          </a>
        </div>
        <div class="col-md-4 col-sm-6">
          <a href="https://maven.apache.org/">
            <img class="img-responsive img-portfolio img-hover" src="${pageContext.request.contextPath}/resources/images/maven-logo.png" alt="">
          </a>
        </div>
      </div>
    </div>
    <!-- /.container -->

    <!-- Script to Activate the Carousel -->
    <script>
      $('.carousel').carousel({
        interval: 5000 //changes the speed
      })
    </script>
  </jsp:body>

</page:template>
