package d2s.history.domain;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="history")
public class Match {

	@Id
	private long matchId;
	 
	private long date;
	
	private String winner;
	
	private ArrayList<String> teamRadiant;
	private ArrayList<String> teamDire;

	private boolean parsed;
	
	public Match() {
		
	}
	
	public boolean isParsed() {
		return parsed;
	}

	public long getMatchId() {
		return matchId;
	}

	public long getDate() {
		return date;
	}

	public String getWinner() {
		return winner;
	}

	public ArrayList<String> getTeamRadiant() {
		return teamRadiant;
	}

	public ArrayList<String> getTeamDire() {
		return teamDire;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public void setTeamRadiant(ArrayList<String> teamRadiant) {
		this.teamRadiant = teamRadiant;
	}

	public void setTeamDire(ArrayList<String> teamDire) {
		this.teamDire = teamDire;
	}

	public void setParsed(boolean parsed) {
		this.parsed = parsed;
	}

	public static Match corrupted(long id) {
		Match corrupted = new Match();
		corrupted.date = -1;
		corrupted.matchId = id;
		corrupted.winner = "none";
		corrupted.setParsed(false);
		return corrupted;
	}
	
	public String toString() {
		return "Dota2 match n" + matchId + " played at " + date + " winner: " + winner;
	}

}
