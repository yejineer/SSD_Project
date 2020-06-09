package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.Scrap_aDao;
import dongduk.cs.ssd.dao.Scrap_gDao;
import dongduk.cs.ssd.domain.Scrap_a;
import dongduk.cs.ssd.domain.Scrap_g;

/**
 * @author kimdahyee
 * @since 05.06.2020
 */

@Service
public class ScrapServiceImple implements ScrapService {

	@Autowired
	private Scrap_aDao scrap_aDao;
	
	@Autowired
	private Scrap_gDao scrap_gDao;
	
	@Override
	public List<Scrap_a> getScrap_aList() throws DataAccessException {
		return scrap_aDao.getScrap_aList();
	}

	@Override
	public List<Scrap_g> getScrap_gList() throws DataAccessException {
		return scrap_gDao.getScrap_gList();
	}
	
	@Override
	public Scrap_a createScrap_a(int auctionId) throws DataAccessException {
		return scrap_aDao.createScrap_a(auctionId);
	}
	
	@Override
	public Scrap_g createScrap_g(int groupBuyId) throws DataAccessException {
		return scrap_gDao.createScrap_g(groupBuyId);
	}

	@Override
	public int deleteScrap_a(int auctionId) throws DataAccessException {
		return scrap_aDao.deleteScrap_a(auctionId);
	}

	@Override
	public int deleteScrap_g(int groupBuyId) throws DataAccessException {
		return scrap_gDao.deleteScrap_g(groupBuyId);
	}

}
