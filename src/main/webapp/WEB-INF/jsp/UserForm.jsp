<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<c:if test="${user == null}">
      <title>Yeni Kullanıcı Ekle</title>
  	</c:if>
  	<c:if test="${user != null}">
      <title>Kullanıcı Bilgisini Güncelle</title>
  	</c:if>
	<link rel="stylesheet" href="/Odev6/css/style.css" />
  </head>
<body>
  <c:if test="${user == null}">
    <h1 class="center">Yeni Kullanıcı Ekle</h1>
  </c:if>
  <c:if test="${user != null}">
    <h1 class="center">Kullanıcı Bilgisini Güncelle</h1>
  </c:if>
  <div class="center">
    <c:if test="${user == null}">
      <form action="/Odev6/add-user" method="post">
    </c:if>
    <c:if test="${user != null}">
      <form action="/Odev6/update-user" method="post">
    </c:if>
    <table class="minimalistBlack">
      <c:if test="${user != null}">
        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
      </c:if>           
      <tr>
        <th>Kullanıcı Adı: </th>
        <td>
          <input type="text" name="name" size="100" value="<c:out value='${user.name}' />" />
         </td>
      </tr>
      <tr>
        <th>E-mail: </th>
          <td>
            <input type="text" name="email" size="100" value="<c:out value='${user.email}' />" />
          </td>
      </tr>
      <tr>
        <th>Ülke: </th>
        <td>
          <input type="text" name="country" size="60" value="<c:out value='${user.country}' />" />
        </td>
      </tr>
      <tr>
        <c:if test="${user == null}">
          <td colspan="2" align="center">
		    <input type="submit" value="Kullanıcı Ekle" />
          </td>
        </c:if>
        <c:if test="${user != null}">
          <td colspan="2" align="center">
		    <input type="submit" value="Kullanıcı Bilgisini Güncelle" />
          </td>
        </c:if>
      </tr>
    </table>
    </form>
  </div>
</body>
</html>