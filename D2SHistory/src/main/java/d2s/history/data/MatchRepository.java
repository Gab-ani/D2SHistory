package d2s.history.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import d2s.history.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {

	public ArrayList<Match> findByParsed(boolean isParsed);
	
	public Match findByMatchId(long id);

	@Query("SELECT m FROM Match	m WHERE m.date > ?1 and m.date < ?2")
	public ArrayList<Match> findByPeriod(long from, long to);
	
}
