<%@ page import="org.jdom2.Element" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.net.httpserver.Authenticator" %><%--
  Created by IntelliJ IDEA.
  User: Personnel
  Date: 15/03/2017
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title> - Loan Panel</title>
    <link rel="icon" type="image/png" href="http://download.seaicons.com/download/i8554/double-j-design/iphone4-mini/double-j-design-iphone4-mini-address-book.ico" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="hover-min.css" rel="stylesheet" media="all">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <style>
        body {
            font-family: 'Roboto';
            background: #fafafa;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 50px; border: 1px solid #e6e6e6; bborder-radius: 1px; background-color: #ffffff; margin-top: 47.5vh;transform: translateY(-50%);">
        <div class="col s12" style="padding: 15px; font-size: 24px; font-family: Roboto ; text-align: center; background-color: #D64541; color: White;">
            MODIFY CUSTOMER
        </div>
        <form class="col s12" style="margin: 15px;" method="post" action="modifyCustomer">
            <input type="hidden" name="id" value="${idCustomer}">
            <div class="row">
                <div class="input-field col s4">
                    <input id="first_name" value="${customer.getChildText("First-name")}" name="fname" type="text" class="validate" required>
                    <label for="first_name">First Name</label>
                </div>
                <div class="input-field col s4">
                    <input id="last_name" value="${customer.getChildText("Last-name")}" name="lname" type="text" class="validate" required>
                    <label for="last_name">Last Name</label>
                </div>
                <div class="switch input-field col s4">
                    <label>
                        <input id="Return" name="return" value="1" type="checkbox">
                        <span class="lever"></span>
                        Returned
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s4">
                    <input id="itemName" value="${customer.getChildText("Item-name")}" name="itemName" type="text" class="validate" required>
                    <label for="itemName">Item name</label>
                </div>
                <div class="input-field col s4">
                    <input id="itemType" name="itemType" value="${customer.getChildText("Item-type")}" type="text" class="autocomplete" required>
                    <label for="itemtype">Item type</label>
                </div>
                <div class="input-field col s4">
                    <input type="date" id="itemDate" value="${customer.getChildText("Date")}" name="itemDate" class="datepicker picker__input" required>
                    <label for="itemDate"></label>
                </div>
            </div>
            <div class="col s4 offset-s1" style="color: 26a69a; text-align: center;">
                <c:choose>
                    <c:when test="${empty Success}">
                    </c:when>
                    <c:otherwise>
                        <div class="chip">
                                ${Success}
                            <i class="close material-icons">close</i>
                        </div>
                    </c:otherwise>
                </c:choose>

            </div>
            <a href="registerCustomer" class="btn waves-effect waves-light col s1" style="background: #D64541;" type="submit" name="action"><i class="material-icons">keyboard_backspace</i>
            </a>
            <button class="btn waves-effect waves-light col s3 offset-s1" style="background: #D64541;" type="submit" name="action">Submit
            </button>
        </form>
    </div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</body>
</html>
