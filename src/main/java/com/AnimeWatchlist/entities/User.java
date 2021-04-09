package com.AnimeWatchlist.entities;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(nullable=false, length=30)
	private String username;
	
	@Column(nullable=false, length=30)
	private String userPassword;
	
	@Transient //doesn't persist to the database;
	private String verifyPassword;
	
	@JoinTable(name="user_currentshowlist")
	@ManyToMany(targetEntity = Show.class, fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Show> currentShowList;
	
	@JoinTable(name="user_backlogshowlist")
	@ManyToMany(targetEntity = Show.class, fetch= FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Show> backlogShowList;
	
	
	public User() {
		super();
		
	}
	
	public User(String username, String userPassword) {
		super();
		this.username = username;
		this.userPassword = userPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public List<Show> getBacklogShowList() {
		return backlogShowList;
	}
	
	public void setBacklogShowList(List<Show> backlogShowList) {
		this.backlogShowList = backlogShowList;
	}
	
	public List<Show> getCurrentShowList() {
		return currentShowList;
	}
	
	public void setCurrentShowList(List<Show> currentShowList) {
		this.currentShowList = currentShowList;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((backlogShowList == null) ? 0 : backlogShowList.hashCode());
		result = prime * result + ((currentShowList == null) ? 0 : currentShowList.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (backlogShowList == null) {
			if (other.backlogShowList != null)
				return false;
		} else if (!backlogShowList.equals(other.backlogShowList))
			return false;
		if (currentShowList == null) {
			if (other.currentShowList != null)
				return false;
		} else if (!currentShowList.equals(other.currentShowList))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", userPassword=" + userPassword + ", currentShowList=" + currentShowList
				+ ", backlogShowList=" + backlogShowList + "]";
	}
}

