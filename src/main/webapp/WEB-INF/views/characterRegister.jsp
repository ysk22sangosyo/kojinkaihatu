<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action ="characterRegister" modelAttribute="characterRegister" method="post">
<h2>登録情報</h2>
キャラクターID<br>
<form:input path="characterId" /><br>
名前<br>
<form:input path="characterName" /><br>
性別<br>
<form:input path="sex" /><br>
年齢<br>
<form:input path="old" /><br>
職業<br>
<form:input path="job" /><br>
プロフィール<br>
<form:textarea path="profile" /><br>
画像<br>
<form:input type="file" path="img"/><br>
<form:button>登録</form:button>
</form:form>
<a href ="userPage">戻る</a>
</body>
</html>