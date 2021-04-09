<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-text">Hello, ${user.getUsername() }</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNavAltMarkup"
			aria-controls="navbarNavAltMarkup" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-link" href="index">Home</a> 
				<a class="nav-link dropdown-toggle" href="#" 
					id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown"
					aria-expanded="false">Watchlists</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<li><a class="dropdown-item" href="backlogWatchlist">Backlog</a></li>
					<li><a class="dropdown-item" href="currentWatchlist">Current</a></li>
				</ul>
					<a class="nav-link" href="logout">Logout!</a>
			</div>
		</div>
	</div>
</nav>