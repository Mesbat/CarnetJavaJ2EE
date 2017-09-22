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
        <div class="row" style="margin-top: 50px; border: 1px solid #e6e6e6; bborder-radius: 1px; background-color: #ffffff;">
            <div class="col s12" style="padding: 15px; font-size: 24px; font-family: Roboto ; text-align: center; background-color: #D64541; color: White;">
                LOAN APPLICATION
            </div>
            <form class="col s12" style="margin: 15px;" method="post" action="registerCustomer">
                <div class="row">
                    <div class="input-field col s4">
                        <input id="first_name" name="fname" type="text" class="validate" required>
                        <label for="first_name">First Name</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="last_name" name="lname" type="text" class="validate" required>
                        <label for="last_name">Last Name</label>
                    </div>
                    <div class="switch input-field col s4">
                        <label>
                            Not Returned
                            <input disabled id="Return" name="return" value="1" type="checkbox">
                            <span class="lever"></span>
                            Returned
                        </label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s4">
                        <input id="itemName" name="itemName" type="text" class="validate" required>
                        <label for="itemName">Item name</label>
                    </div>
                    <div class="input-field col s4">
                        <input id="itemType" name="itemType" type="text" class="autocomplete" required>
                        <label for="itemtype">Item type</label>
                    </div>
                    <div class="input-field col s4">
                        <input type="date" id="itemDate" name="itemDate" class="datepicker picker__input" required>
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
                <button class="btn waves-effect waves-light col s3 offset-s2" style="background: #D64541;" type="submit" name="action">Submit
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>




    <div class="row" style="margin-top: 50px; border: 1px solid #e6e6e6; bborder-radius: 1px; background-color: #ffffff;">
        <div class="col s12" style="padding: 15px; font-size: 24px; font-family: Roboto ; text-align: center; background-color: #019875; color: White;">
            LOAN LIST
        </div>
        <div style="padding:20px;">
            <table>
            <thead>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Item</th>
                <th>Item Type</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${nodeList}" var="item" varStatus="loop">
                <c:choose>
                    <c:when test="${loop.count % 2 == 0}">
                        <tr style="background-color: #DADFE1">
                    </c:when>
                    <c:otherwise>
                        <tr>
                    </c:otherwise>
                </c:choose>
                        <td>${item.getChildText("First-name")}</td>
                        <td>${item.getChildText("Last-name")}</td>
                        <td>${item.getChildText("Item-name")}</td>
                        <td>${item.getChildText("Item-type")}</td>
                        <td>${item.getChildText("Date")}</td>
                        <td><a href="modifyCustomer?id=${loop.count - 1}" class="hvr-pulse-grow"><i class="material-icons">mode_edit</i></a></td>
                    </tr>
            </c:forEach>
            </tbody>
            </table>
        </div>
    </div>



    </div>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
    <script>
        $(document).ready(function () {$('input.autocomplete').autocomplete({
            data: {
                "Apple": null,
                "Microsoft": null,
                "Google": null,
                "Book": null,
                "Movie": null,
                "Music": null,
                "Art": null,
                "Game": null,
                "DVD": null,
                "CD": null
            }});});

        jQuery(function(){
            var kKeys = [];
            function Kpress(e){
                kKeys.push(e.keyCode);
                if (kKeys.toString().indexOf("38,38,40,40,37,39,37,39,66,65") >= 0) {
                    jQuery(this).unbind('keydown', Kpress);
                    kExec();
                }
            }
            jQuery(document).keydown(Kpress);
        });
        function kExec(){
            Materialize.toast('Initializing XML test file.', 4000)
            $.ajax({
                url : '/xmlTest',
                type : 'POST', // Le type de la requête HTTP, ici devenu POST
                data : 'test=1', // On fait passer nos variables, exactement comme en GET, au script more_com.php
                dataType : 'html'
            });
        }
    </script>
  </body>
</html>
