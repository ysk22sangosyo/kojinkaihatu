<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/kaihatu.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="${userIcon}"width="50" height="50">
${userName}

<div>プロフィール
${userProfile}
</div>
<%-- <form:form action ="/updateInput"> --%>
  <input type="button" onclick="location.href='/updateInput'" value="編集">
<%-- </form:form> --%>

 <input type="button" onclick ="location.href='/characterRegister'" value="キャラクター登録"><br>
 
 <form method="get" action="search" class="search_container">
      <input type="text" size="25" name="characterName" placeholder="キーワード検索">
      <input type="submit" value="&#xf002">
    </form>
 
 
 
  <table>
       
        
     
      <thead>
        <tr>
          <th>キャラID</th>
          <th>名前</th>
          <th>性別</th>
          <th>年齢</th>
          <th>職業</th>
          <th>プロフィール</th>
          <th>キャラ画像</th>
          <th>詳細</th>
         
        </tr>
        
      </thead>
      <tbody>
     
<%--            <c:if test="${not empty charaList}"> --%>
          <c:forEach items="${charaList}" var="chara">
          <tr>
            <td>${fn:escapeXml(chara.characterId)}</td>
    		<td>${fn:escapeXml(chara.characterName)}</td>
    		<td>${fn:escapeXml(chara.sex)}</td>
    		<td>${fn:escapeXml(chara.old)}</td>
    		<td>${fn:escapeXml(chara.job)}</td>
    		<td>${fn:escapeXml(chara.profile)}</td>
    		<td><img src="${fn:escapeXml(chara.img)}"width="50" height="50"></td>
            <td><a class="detail_btn" href="|/detail/${chara.characterId}|">詳細</a></td> 
          </tr>
          </c:forEach>
<%--           </c:if> --%>
      </tbody>
      
    </table>
  
<%-- <c:forEach items="${charaList}" var="chara"> --%>
<!-- <table> -->
<!--   <tr> -->
<%--     <td>${fn:escapeXml(chara.characterId)}</td> --%>
<%--     <td>${fn:escapeXml(chara.characterName)}</td> --%>
<%--     <td>${fn:escapeXml(chara.sex)}</td> --%>
<%--     <td>${fn:escapeXml(chara.old)}</td> --%>
<%--     <td>${fn:escapeXml(chara.job)}</td> --%>
<%--     <td>${fn:escapeXml(chara.profile)}</td> --%>
<%--      <td>${fn:escapeXml(chara.img)}</td> --%>
<!--   </tr> -->
<!--   </table> -->
<%-- </c:forEach> --%>

<input type="button" onclick ="location.href='/logout'" value="ログアウト"><br>
</body>
</html>