<%@include file="headCommon.jsp"%>
<style>
html, body {
	font-family: 'ABeeZee', sans-serif;
	background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(226,197,134,1) 100%);
	height:100%;
	width:100%;
	margin:0px;
	padding:0px;
}
</style>
<title>Logging Out!</title>
<%@include file="headCommonEnd.jsp"%>
	<script type="text/JavaScript">
	setTimeout("location.href='http://localhost:8080/WatchlistAndTracker/login';", 4000);
	</script>

	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-md-auto">
				<br>
				<h1>We're sad to see you go :( Come back soon!</h1>
				<hr>
				<div style="display:flex; justify-content:center;align-content:center;"><img src="https://media1.tenor.com/images/b84d4df063dc16149d66f8046a705377/tenor.gif?itemid=15485179" alt="Naruto crying gif" style="height:350px; width:600px"></div>
			</div>
		</div>
	</div>

<%@include file="footCommon.jsp"%>