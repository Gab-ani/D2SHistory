package d2s.history.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import d2s.history.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {

	public ArrayList<Match> findByParsed(boolean isParsed);
	
	public Match findByMatchId(long id);
	
}
