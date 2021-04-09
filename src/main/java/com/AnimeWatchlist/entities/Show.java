package com.AnimeWatchlist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="shows")
public class Show {
	
	@Id
	@Column(name="name")
	private String showName;
	
	@Column(name="total_episode")
	private int totalEpisodes;
	
	
	public Show() {
		super();
	}
	
	public Show(String showName, int totalEpisodes) {
		super();
		this.showName = showName;
		this.totalEpisodes = totalEpisodes;
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

	public void setTotalEpisodes(Integer totalEpisodes) {
		this.totalEpisodes = totalEpisodes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((showName == null) ? 0 : showName.hashCode());
		result = prime * result + totalEpisodes;
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
		Show other = (Show) obj;
		if (showName == null) {
			if (other.showName != null)
				return false;
		} else if (!showName.equals(other.showName))
			return false;
		if (totalEpisodes != other.totalEpisodes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Show [showName=" + showName + ", totalEpisodes=" + totalEpisodes + "]";
	}

}
