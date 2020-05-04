package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.domain.Auction;
import dongduk.cs.ssd.domain.GroupBuy;

/**
 * @author Hyekyung Kim
 * @since 2020.05.04
 */

public interface SearchService {
	List<GroupBuy> groupBuyListByKeyword(String keyword);
	List<Auction> auctionListByKeyword(String keyword);
}
