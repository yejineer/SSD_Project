package dongduk.cs.ssd.dao;

import java.util.*;
import dongduk.cs.ssd.domain.Scrap_g;
import org.springframework.dao.DataAccessException;

public interface Scrap_gDao {
	
	List<Scrap_g> getScrap_gList() throws DataAccessException;
	
	Scrap_g createScrap_g(int groupById) throws DataAccessException;
	
	int deleteScrap_g(int groupById) throws DataAccessException;
}
