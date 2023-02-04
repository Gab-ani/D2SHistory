package d2s.history.data;

import java.util.List;

import d2s.history.domain.Match;

public class MatchListDTO {

	private List<Match> matches;
	
	public MatchListDTO(List<Match> list) {
		matches = list;
	}
	
	public List<Match> getList() {
		return matches;
	}
	
}
