<%--
  Created by IntelliJ IDEA.
  User: Altair
  Date: 20.12.2017
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:forEach items="${place.menu}" var="recipe">
    <br/>
    Place: ${place.name}
    <br/>
    Recipe name: ${recipe.name}<br/>
    Recipe category: ${recipe.category.name}<br/>
    <br/>
    Entries: <br/>
      <c:forEach items="${recipe.ingredients}" var="entry">
        <br/>
        <tr>
          <td>Ingredient name:</td><td>${entry.ingredient.name}</td> <br/>
          <td>Ingredient calories:</td><td>${entry.ingredient.calories}</td> <br/>
          <td>Dimension name:</td><td>${entry.dimension.name}</td> <br/>
          <td>Amount:</td><td>${entry.amount}</td> <br/>
        </tr>
        <br/>
        </c:forEach>
  </c:forEach>
  </body>
</html>
