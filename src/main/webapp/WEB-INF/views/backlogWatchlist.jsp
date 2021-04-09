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
	background-color: #26c1e2;
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
	border-color: #2276c3;
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
	background-color:#F9CDAD;
	border-color: inherit;
	text-align: right;
	vertical-align: top
}

.tg .tg-brdm {
	background-color: #26c1e2;
	border-color: inherit;
	text-align: right;
	vertical-align: top
}
</style>
<title>Backlog Watchlist</title>

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
		
		<div class="col">
			
			<h1 style="color:#6c757d">Backlog Watchlist: </h1>
			
			<table class = "tg" style="width:75%;">
				<tr>
					<th class="tg-0pky" style="text-align: left; background-color: #2276c3;">
						Show Name:
					</th>

					<th class="tg-0pky" style="text-align: left; background-color: #2276c3;">
						Total Episodes:
					</th>
				</tr>
				<tbody>
					<c:forEach items="${backlogList}" var="i" begin="0">
						<tr>
							<td width="10%" class="tg-0pky">
								<c:out value="${i.getShowName()}"></c:out>
							</td>
							<td width="5%" class="tg-brdm">
								<c:out value="${i.getTotalEpisodes()}"></c:out>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col">
			<p> Backlog empty? Try adding a show from our collection below!
			<p style="color:red">${backlogAlreadyAdded}</p>
			<p style="color:red">${alreadyInCurrent}</p>
			<form:form  action="addToBacklog" methodAttribute="showAdd" method="post" style="display: flex; flex-direction: column; justify-content: space-between; width: 50%">
				<select name="showName" style="width:50%">
					<c:forEach items="${showList}" var="show" begin="0">
						<option value="${show.showName}">${show.showName}</option>
					</c:forEach>
				</select>
				<br>
				<input style="width: 50%" type="submit" name="addToBacklog" value="Add">	
			</form:form>
			<br>
			<p>Don't want to watch <i>that</i> show? Remove it here!</p>
			<form:form action="removeFromBacklog" methodAttribute="showRemove" method="post" style="display: flex; flex-direction: column; justify-content: space-between; width: 50%" >
				<select name="showName" style="width:50%">
					<c:forEach items="${backlogList}" var="show" begin="0">
						<option value="${show.showName}">${show.showName}</option>
					</c:forEach>
				</select> 
				<br>
				<input style="width: 50%" type="submit" name="removeFromBacklog" value="Remove">
			</form:form>
			<br>
			<p>Want to move a show to your current watchlist? Select which one from the dropdown below!</p>
			<form:form action="moveFromBackToCurrent" methodAttribute="showMove" method="post" style="display: flex; flex-direction: column; justify-content: space-between; width: 50%">
				<select name="showName" style="width:50%">
					<c:forEach items="${backlogList}" var="show" begin="0">
						<option value="${show.showName}">${show.showName}</option>
					</c:forEach>
				</select>
				<br>
				<input style="width: 50%" type="submit" name="moveToCurrent" value="Move">
			</form:form>
		</div>
	</div>
</div>





<%@include file="footCommon.jsp"%>