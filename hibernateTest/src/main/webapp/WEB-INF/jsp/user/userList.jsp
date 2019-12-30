<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
유저  리스트 화면
<div class="container">
	<div class="row">
		<div class="col-12">
			
				<table border="1" width="100%">
					<thead>
						<th>번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>주소</th>
						<th>성별</th>
					</thead>
					<tbody>
						<c:forEach var = "user" items = "${userList }" >	<!-- varStatus="status" -->
							<tr>
								<td>${user.userIdx }</td>
								<td>${user.userName }</td>
								<td>${user.userEmail }</td>
								<td>${user.userAddress }</td>
								<td>${user.userGender }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				
		</div>
	</div>
</div>
</body>
</html>