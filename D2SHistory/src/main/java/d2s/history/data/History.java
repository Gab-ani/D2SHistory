package d2s.history.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import d2s.history.domain.Match;

@Service
public class History {
	
	@Autowired
	private MatchRepository matchesDB;
	
	public void add(Match match) {
		matchesDB.save(match);
	}
	
	public void addAll(Iterable<Match> collection) {
		matchesDB.saveAll(collection);
	}
	
	public Match findById(long id) {
		return matchesDB.findByMatchId(id);
	}
	
	public List<Match> findAll() {
		return matchesDB.findAll();
	}

	public ArrayList<Match> getUnparsed() {
		return matchesDB.findByParsed(false);
	}
	
	public ArrayList<Long> getUnparsedIDs() {
		var unparsedMatches = getUnparsed();
		var unparsedIDs = new ArrayList<Long>();
		unparsedMatches.forEach(match -> unparsedIDs.add(match.getMatchId()));
		return unparsedIDs;
	}

	public void createUnparsed(Long id) {
		matchesDB.save(Match.corrupted(id));
	}

	public ArrayList<Match> getByPeriod(long from, long to) {
		return matchesDB.findByPeriod(from, to);
	}

}
