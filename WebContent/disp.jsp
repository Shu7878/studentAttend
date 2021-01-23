<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>出席管理画面</title>
</head>
<body>
	<h1>生徒　出席入力画面</h1>
	<p><c:out value="${message}"/></p>
	<p><c:out value="${errorMessage}"/></p>
	<c:if test="${not empty requestScope.studentList }">
		<h2>生徒一覧</h2>
		<form action="" method="post">
		<table border="1" summary="生徒一覧">
			<tr>
				<th>ID</th>
				<th>クラス番号</th>
				<th>出席番号</th>
				<th>生徒氏名</th>
				<th>出欠状況</th>
				<th></th>
			</tr>
			<c:forEach var="attend" items="${requestScope.studentList }">
				<tr>
					<th><c:out value="${attend.student_id}"/></th>
					<th><c:out value="${attend.student_classId}"/></th>
					<th><c:out value="${attend.student_attendId}"/></th>
					<th><c:out value="${attend.student_name}"/></th>
					<th><c:out value="${attend.student_attend}"/></th>
					<th>
						<select name="attend">
							<option value="attend">出席</option>
							<option value="notattend">欠席</option>
							<option value="other">その他</option>
						</select>
					</th>
				</tr>
			</c:forEach>
		</table>
		<p><input type="hidden" name="btn" value="attendBtn"/></p>
		<p><input type="submit" value="変更する"/></p>
		</form>
	</c:if>
</body>
</html>