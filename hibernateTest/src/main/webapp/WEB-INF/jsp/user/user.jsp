<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<script>
$(function(){	//	$(document).ready()
	$('#btn').click(function(){
		$('form[rel=userInsertForm]').submit();
	});

})


</script>
<title>회원가입 폼</title>
</head>
<body>
<div class="container">
	<form rel="userInsertForm" action="userInsert" method="post">
		<div class="form-group">
			<div class="row text-center">
				<div class="col-2"><label for="">이름:</label></div>
				<div class="col-10"><input class="form-control" type="text" name="userName" /></div>
			</div>
			<div class="row text-center">
				<div class="col-2"><label for="">성별:</label></div>
				<div class="col-10"><input class="form-control" type="text" name="userGender" /></div>
			</div>
			<div class="row text-center">
				<div class="col-2"><label for="">이메일:</label></div>
				<div class="col-10"><input class="form-control" type="text" name="userEmail" /></div>
			</div>
			<div class="row text-center">
				<div class="col-2"><label for="">주소:</label></div>
				<div class="col-10"><input class="form-control" type="text" name="userAddress" /></div>
			</div>
			<div class="row text-center">
				<div class="col-2"><label for="">권한:</label></div>
				<div class="col-2">관리자 <input class="form-control "type="radio" name="role" value="ADMIN" /></div>
				<div class="col-2">회원 <input class="form-control" type="radio" name="role" value="USER" /></div>
			</div>
			<div class="row text-center">
				<div class="col-2"><label for="">나이:</label></div>
				<div class="col-10"><input class="form-control" type="text" name="userAge" /></div>
			</div>
			<hr />
			<div class="row">
				<div class="col-12">
					<button type="button" id="btn" class="btn btn-primary btn-block">회원정보입력</button>
				</div>
			</div>
		</div>

	</form>
</div>
</body>
</html>