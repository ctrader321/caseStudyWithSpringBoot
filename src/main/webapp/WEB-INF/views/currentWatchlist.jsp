<%@include file="headCommon.jsp"%>
<%@ page import="com.AnimeWatchlist.entities.User"%>
<%@ page import="com.AnimeWatchlist.entities.UserCurrentShow"%>
<%@ page import="com.AnimeWatchlist.services.UserCurrentShowServices"%>
<%@ page import="com.AnimeWatchlist.services.ShowServices"%>
<%@ page import="java.util.List" %>
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
	border-color: ##2276c3;
	border-spacing: 0;
	border-style: solid;
	border-width: 1px;
}

.tg td {
	background-color: #F9CDAD;
	border-color: ##2276c3;
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
<title>Currently Watching</title>
<%@include file="headCommonEnd.jsp"%>
<%@include file="navbar.jsp"%>
 <%
	if(session.getAttribute("user") == null){
		
		request.setAttribute("loginAgainMessage", "Please sign in!");
		response.sendRedirect("login");
	}
%>
	<div class="container">
		<div class="row" style = "padding-top:5%">
			<div class = "col">
			<p>Select a show to add (Total episode count)</p>
			<p style="color:red">${alreadyInList}</p>
				<form:form action="addToCurrent" methodAttribute="showAdd" method ="get" style="display:flex; flex-direction:column; justify-content:space-between; width:50%">
					<select name="showName">
						<c:forEach items="${showList}" var="show" begin="0">
							<option value="${show.showName}">${show.showName} == ${show.totalEpisodes}</option>
						</c:forEach>
					</select>
					<label>Which episode are you on?</label>
					<input name="episodeToSet" id="episodeForAddTo" style="width:50%" type="number">
					<script type="text/javascript">
						document.getElementById("episodeForAddTo").value = '0';
					</script>
					<input style="width:50%" type="submit" name="addToCurrent" value="Add"> 				
				</form:form>
				<br>
				<p>Select a show to edit</p> 
				<form:form action="editInCurrent" methodAttribute="showEdit" method="get" style="display: flex; flex-direction: column; justify-content: space-between; width: 50%">	
					<select	name="showName">
						<c:forEach items="${currentShows}" var="show" begin="0">
							<option value="${show.showName}">${show.showName}</option>
						</c:forEach>
					</select>
					<label>Which episode did you most recently finish?</label> 
					<input style="width: 50%" type="number" id="episodeForEditIn" name="episodeNumberToSet">
						<script type="text/javascript">
							document.getElementById("episodeForEditIn").value = '0';
						</script>
					<input style="width: 50%" type="submit" name="addToCurrent" value="Edit">
				</form:form>
				<br>
				<p>Select a show to remove!</p> 
				<form:form action="removeFromCurrent" methodAttribute="showRemove" method="get" style="display: flex; flex-direction: column; justify-content: space-between; width: 50%">
					<select	name="showName">
						<c:forEach items="${currentShows}" var="show" begin="0">
							<option value="${show.showName}">${show.showName}</option>
						</c:forEach>
					</select>
					<input style="width: 50%" type="submit" name="removeFromCurrent" value="Remove">
				</form:form>
		</div>
			<div class = "col-md">
			
				<h1 style="color:#6c757d">Current Watchlist:</h1>
			
				<table class="tg">
					<tr>
						<th class="tg-0pky" style="text-align: left">
							Show Name:
						</th>
						<th class="tg-0pky" style="text-align: left">
							Current Episode:
						</th>
						<th class="tg-0pky" style="text-align: left">
							Total Episodes:
						</th>
						<th class="tg-0pky" style="text-align: left">
							Completion Percentage:
						</th>
					</tr>
					<tbody id="currentlyWatching">
						<c:forEach items="${userList}" var="i" begin="0">
							<tr>
								<td width = "10%" class="tg-0pky">
									<c:out value="${i.getShowName()}"></c:out>
								</td>
								<td width = "10%" class="tg-brdm">
									<c:out value="${i.getCurrentEpisode()}"></c:out>
								</td>
								<td width = "10%" class="tg-0pky">
									<c:out value="${i.getTotalEpisodes()}"></c:out>
								</td>
								<td width = "10%" class="tg-brdm">
									<c:if test="${i.getCompletionPercentage() >= 100 }"><span style="color:blue; padding:0%;"><strong>Completed</strong></span></c:if>
									<c:if test="${i.getCompletionPercentage() < 100 }">${i.completionPercentage}</c:if>
									</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<%@include file="footCommon.jsp"%>