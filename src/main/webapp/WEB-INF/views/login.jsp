<%@include file="headCommon.jsp"%>

<title>Login</title>
<style>
.col-5 {
	padding: 2em;
}
input{
	border-radius: 25px;
}
#cloud{
	border-radius:50%;
	position:absolute;
	left:45%;
	top:9%;
	
}
</style>
<%@include file="headCommonEnd.jsp"%>


	<div class="container" style="padding-top: 10%">
		<img id="cloud" src="<%=request.getContextPath()%>/resources/images/akatskiCloud.jpg">
		<div class="row">
			<div class="col"></div>
			<div class="col-5" style="background-color: #d3d3d3; border-radius: 25px;">
				<br>
				<h1 style="padding-top:25px">Welcome to MyWatchlist!</h1>
				<p style="color:green">${registrationSuccessful}</p>
				<hr>
				<p style="color:red;">${loginAgainMessage}</p>
				<form action="loginProcess" method="post"
					style="display: flex; flex-direction: column">
					Username: <input type="text" name="username"><br>
					Password: <input type="password" name="userPassword"><br> 
					<p style="color:red;">${message}</p>
					<input type="submit" name="login" value="Login" style="width: 50%">
				</form>
				<a href="register">Create an Account!</a>
			</div>
			<div class="col"></div>
		</div>
	</div>
<%@include file="footCommon.jsp"%>