<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html ng-app="govacationApp">
    <head>
        <link type="text/css" rel="stylesheet" href="<c:url value='/resources/bower_components/bootstrap/dist/css/bootstrap.min.css'/>">
        
         <!--Custom CSS -->
        <link type="text/css" href="<c:url value='/resources/css/landing-page.css'/>" rel="stylesheet">

        <!-- Custom Fonts -->
        <link async href="http://fonts.googleapis.com/css?family=Antic" data-generated="http://enjoycss.com" rel="stylesheet" type="text/css"/>
        <link async href="http://fonts.googleapis.com/css?family=Antic" data-generated="http://enjoycss.com" rel="stylesheet" type="text/css"/>
        <link href="<c:url value='/resources/css/font-awesome.css' /> rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="<c:url value='/resources/bower_components/jquery/dist/jquery.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/bower_components/angular/angular.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/bower_components/angular-resource/angular-resource.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/bower_components/angular-route/angular-route.js'/>"></script>
        <!--<script src="bower_components/jquery/dist/jquery.js"></script>-->
        <script type="text/javascript" src="<c:url value='/resources/app.module.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/app.config.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/homepage/homepage.module.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/homepage/homepage.component.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/places-list/places-list.module.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/resources/places-list/places-list.component.js'/>"></script>
        <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false&libraries=places&key=AIzaSyDLXS3BYdyVZ_Lp3HEIPETgcabZ8HA70IE"></script>        
    </head>
    <body>
        <!--{{2+3}}-->
        <div ng-view></div>
        <!--<homepage></homepage>-->
        <!--<places-list></places-list>-->
    </body>
</html>