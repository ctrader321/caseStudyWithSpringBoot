
<%@ page import="com.AnimeWatchlist.entities.User" %>
<%@include file="headCommon.jsp" %>
<style>
.col-5{
	padding:2em;
}
input{
	border-radius: 25px;
}
</style>
<title>Registration</title>
<%@include file="headCommonEnd.jsp" %>

	<div class="container" style="padding-top:10%">
	  <div class="row">
	    <div class="col">
	    </div>
	    <div class="col-5" style="background-color:#d3d3d3; border-radius:25px;">
	    	<h1>Register an Account!</h1>
	    	<form action="registerSubmit" method="post" style="display:flex; flex-direction:column">
				Username: <input type="text" name="username" pattern="[a-zA-Z0-9-_]{4, 24}"><br>
				<p style="color:red;">${usernameMessage}</p>
				<p style="color:red;">${usernameShort}</p>
				Password: <input type="text" name="userPassword"><br>
				<p style="color:red">${passwordMessage}</p>
				Verify Password: <input type="text" name="verifyPassword"><br>
				<p style="color:red;">${message}</p>
				<input type="submit" name="register" value="Register" style="width:50%">
				
			</form>
			<a href="login">Back to login</a>
	    </div>
	    <div class="col">
	    </div>
	  </div>
	</div>
	

	
<%@include file="footCommon.jsp"%>