<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action ="login" modelAttribute="login" method="post">
<h2>ログイン情報</h2>
<p>${errorMsg}</p>
ユーザID<br>
 <form:input path="userId" /><form:errors path="userId" cssStyle="color: red"/><br>
パスワード<br>
 <form:password path="password" /><form:errors path="password" cssStyle="color: red"/><br>
  <form:button>ログイン</form:button>

</form:form>
<a href ="top">戻る</a>
</body>
</html>