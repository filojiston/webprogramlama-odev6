<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<title>Tüm Kullanıcılar</title>
	<link rel="stylesheet" href="/Odev6/css/style.css" type="text/css"/>
  </head>
<body>
  <h1 class="center">Tüm Kullanıcıların Listesi</h1>
  <div class="center">
    <table class="minimalistBlack">
      <tr>
        <th>ID</th>
        <th>Kullanıcı Adı</th>
        <th>E-mail</th>
        <th>Ulke</th>
        <th>İşlemler</th>
      </tr>
      <c:forEach var="user" items="${userList}">
        <tr>
          <td><c:out value="${user.id}" /></td>
          <td><c:out value="${user.name}" /></td>
          <td><c:out value="${user.email}" /></td>
          <td><c:out value="${user.country}" /></td>
          <td>
            <a href="/Odev6/update-user-form?id=<c:out value='${user.id}' />">Güncelle</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/Odev6/delete-user?id=<c:out value='${user.id}' />">Sil</a>                     
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>