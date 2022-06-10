<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <div class="header">
    <h1 class="site_logo"><a href="menu.jsp">TRPGセッションノート</a></h1>
    
    <div class="user">
      <p class="user_name">${userName}さん、こんにちは</p>
<%--       <form class="logout_form" action="logout.jsp" method="get"> --%>
<!--         <button class="logout_btn" type="submit"> -->
<!--           <img src="images/ドアアイコン.png">ログアウト</button> -->
<%--       </form> --%>
    </div>
  </div>

  <hr>

  <div class="insert">
    <div class="form_body">
      <p class="error">エラーメッセージ</p>

      <form:form action ="updateInput" modelAttribute="updateInput" method="post">
        <fieldset class="label-130">
        <div>
       
        </div>
          <div>
            <label>ID</label>
            <form:input  path="userId" value="${user.userId}" class="base-text"/>
            <span class="error"></span>
          </div>
          <div>
            <label>パスワード</label>
            <form:input  path ="password" value="${user.password}" class="base-text"/>
            <span class="error"></span>
          </div>
          <div>
            <label>名前</label>
            <form:input type="text" path="name" value="${user.name}" class="base-text"/>
            <span class="error"></span>
          </div>
          
          <div>
            <label>プロフィール</label>
            <form:textarea path="profile" placeholder="${user.profile}" class="base-text"/>
          
            
          </div>
          <div>
            <label>画像</label>
            <form:input type="file" path="img"/>
            <img src="${user.img}"width="50" height="50">
<%--             ${login.img}  --%>
            <span class="error">エラーメッセージ</span>
          </div>
        </fieldset>
          <div class="btns">
            <button type="button" onclick="openModal()" class="basic_btn">更新</button>
            <input type="button" onclick="location.href='./userPage'" value="ユーザーページに戻る" class="cancel_btn">
          </div>
          <div id="modal">
            <p class="modal_message">更新しますか？</p>
            <div class="btns">
              <button type="submit" class="basic_btn">更新</button>
<!--               <button type="button" "location.href='./updateInput'" class="cancel_btn">キャンセル</button> -->
<!--               <button type="button" onclick="closeModal()" class="cancel_btn">キャンセル</button> -->
            </div>
          </div>
      </form:form>
    </div>
  </div>
  <div id="fadeLayer"></div>
</body>
</html>
<script src="./js/commons.js"></script>