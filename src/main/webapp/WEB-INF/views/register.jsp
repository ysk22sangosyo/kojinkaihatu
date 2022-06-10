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
<form:form action ="register" modelAttribute="register" method="post">
<h2>登録情報</h2>
ユーザID<br>
<form:input path="userId" /><br>
パスワード<br>
<form:password path="password" /><br>
ユーザーネーム<br>
<form:input path="name" /><br>
<form:button>登録</form:button>
</form:form>
<a href ="top">戻る</a>
</body>
</html>