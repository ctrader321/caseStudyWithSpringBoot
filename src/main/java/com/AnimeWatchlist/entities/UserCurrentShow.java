package com.AnimeWatchlist.entities;

import java.io.Serializable;
import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(value = UserCurrentShowsId.class)
@Table(name="user_currentlyWatching")
public class UserCurrentShow {
	// using this to automatically format the completion percentage when a new UserCurrentShow is instantiated via constructor.
	static DecimalFormat df = new DecimalFormat("###.##");
	
	@Id
	private String username;
	@Id
	private String showName;
	@Column
	private int totalEpisodes;
	@Column
	private int currentEpisode;
	@Column
	private double completionPercentage;

	public UserCurrentShow() {
		super();
	}
	public UserCurrentShow(String username, String showName, int totalEpisodes, int currentEpisode) {
		super();
		this.username = username;
		this.showName = showName;
		this.totalEpisodes = totalEpisodes;
		this.currentEpisode = currentEpisode;
		this.completionPercentage = Double.parseDouble(df.format(100*((double)(currentEpisode/totalEpisodes))));
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public int getTotalEpisodes() {
		return totalEpisodes;
	}

	public void setTotalEpisodes(int totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	public int getCurrentEpisode() {
		return currentEpisode;
	}

	public void setCurrentEpisode(int currentEpisode) {
		this.currentEpisode = currentEpisode;
	}

	public double getCompletionPercentage() {
		return completionPercentage;
	}

	public void setCompletionPercentage(int currentEpisode) {
		this.completionPercentage = Double.parseDouble(df.format(100*((double)currentEpisode)/((double)this.totalEpisodes)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(completionPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + currentEpisode;
		result = prime * result + ((showName == null) ? 0 : showName.hashCode());
		result = prime * result + totalEpisodes;
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
		UserCurrentShow other = (UserCurrentShow) obj;
		if (Double.doubleToLongBits(completionPercentage) != Double.doubleToLongBits(other.completionPercentage))
			return false;
		if (currentEpisode != other.currentEpisode)
			return false;
		if (showName == null) {
			if (other.showName != null)
				return false;
		} else if (!showName.equals(other.showName))
			return false;
		if (totalEpisodes != other.totalEpisodes)
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
		return "UserCurrentShows [username=" + username + ", showName=" + showName + ", totalEpisodes=" + totalEpisodes
				+ ", currentEpisode=" + currentEpisode + ", completionPercentage=" + completionPercentage + "]";
	}
	
}

@SuppressWarnings("serial")
class UserCurrentShowsId implements Serializable{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUid = -1L;
	
	@Id
	private String username;
	@Id
	private String showName;
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

}


