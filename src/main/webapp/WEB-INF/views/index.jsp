<%@include file="headCommon.jsp"%>
<%@ page import="com.AnimeWatchlist.entities.User"%>
<style>

html, body {
	font-family: 'ABeeZee', sans-serif;
	background: linear-gradient(0deg, rgba(34,193,195,1) 0%, rgba(226,197,134,1) 100%);
	height:100%;
	width:100%;
	margin:0px;
	padding:0px;
}

.tg {
	border-collapse: collapse;
	border-color: #2276c3;
	border-spacing: 0;
	border-style: solid;
	border-width: 1px;
}

.tg td {
	background-color: #F9CDAD;
	border-color: #2276c3;
	border-style: solid;
	border-width: 0px;
	color: #002b36;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg th {
	background-color: #2276c3;
	border-color: #2276c3;;
	border-style: solid;
	border-width: 0px;
	color: #fdf6e3;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg .tg-0pky {
	border-color: inherit;
	text-align: right;
	vertical-align: top
}

.tg .tg-brdm {
	background-color: #FFA4A0;
	border-color: inherit;
	text-align: right;
	vertical-align: top
}
</style>

<title>Home</title>
<%@include file="headCommonEnd.jsp"%>
<%@include file="navbar.jsp"%>
<%
	if(session.getAttribute("user") == null){
		
		request.setAttribute("loginAgainMessage", "Please sign in!");
		response.sendRedirect("login");
	}
%>
	<div class="container">
		<div class="row" style="padding-top:5%">
			<div class="col" style="margin-right:2%">
				<h3>Thanks for signing up for Anime Watchlist! Below is a record of all the shows currently being tracked by our Users!</h3>
				<hr>
				<table class = "tg" style="width:100%">
					<thead>
						<tr>
							<th class="tg-0pky" style="text-align: left">
								Show Name:
							</th>
		
							<th class="tg-0pky" style="text-align: left">
								Total Episodes:
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allShowsInDb}" var="show" begin="0">
							<tr>
								<td class="tg-0pky">
									<c:out value="${show.getShowName()}"></c:out>
								</td>
								<td class="tg-0pky">
									<c:out value="${show.totalEpisodes}"></c:out>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col">
				<form action="addShowToDb" method="post" style="display:flex; flex-direction:column;" >
					<h2>Please enter a show you want to add!</h2>
					<input type="text" name="showName" style="width:60%"><br><br>
					<h2>Please enter the total number of episodes in your show!</h2>
					<input type="number" name="totalEpisodes" id="totalEp" style="width:40%"><br>
						<script type="text/javascript">
							document.getElementById("totalEp").value = '0';
						</script>
					<input type="submit" name="addShowToForm" value="Add" style="width:40%">
					<p style="color:red">${showAlreadyInDb}</p>
					<p style="color:green">${showAddedSuccess}</p>
				</form>
			</div>
		</div>
	</div>



<%@include file="footCommon.jsp"%>
