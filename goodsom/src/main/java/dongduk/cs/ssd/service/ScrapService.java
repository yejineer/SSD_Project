package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dongduk.cs.ssd.domain.Scrap_a;
import dongduk.cs.ssd.domain.Scrap_g;

/**
 * @author kimdahyee
 * @since 05.06.2020
 */

@Service("scrapServiceImpl")
public interface ScrapService {
	
	List<Scrap_a> getScrap_aList();
	
	Scrap_a createScrap_a(int auctionId);
	
	int deleteScrap_a(int auctionId);
	
	List<Scrap_g> getScrap_gList();
	
	Scrap_g createScrap_g(int groupById);
	
	int deleteScrap_g(int groupById);
}
