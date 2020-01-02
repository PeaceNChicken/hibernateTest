<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html" charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>유저리스트</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-12">
			<table class="table table-bordered" width="100%">
				<thead>
					<th>번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>주소</th>
					<th>성별</th>
					<th>나이</th>
					<th>권한</th>
					<th>등록날짜</th>
				</thead>
				<tbody>
					<c:forEach var = "user" items = "${userList }" >	<!-- varStatus="status" ?? -->
						<tr>
							<td>${user.userIdx }</td>
							<td>${user.userName }</td>
							<td>${user.userEmail }</td>
							<td>${user.userAddress }</td>
							<td>${user.userGender }</td>
							<td>${user.userAge }</td>
							<td>${user.userRole }</td>
							<td>${user.createdAt }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>