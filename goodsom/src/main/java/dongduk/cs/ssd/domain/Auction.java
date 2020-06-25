package dongduk.cs.ssd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class Auction implements Serializable {
	private static final String PROCEEDING = "proceeding";
	private static final int MENUID_AUCTION = 1;
//	private static final String CLOSED = "closed";
	
	int auctionId;
	@NotEmpty
	String title;
	@NotEmpty
	String content;
	String img;
	int startPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date uploadDate;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date endDate;
	int count;
	int maxPrice;
	String state;
	int menuId;
	int userId;

	List<Bid> bids = new ArrayList<Bid>();
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public Auction() {
	}
	
	public int getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(int auctionId) {
		this.auctionId = auctionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int max) {
		this.maxPrice = max;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void initAuction(User user) {
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        System.out.println(date);
        
        uploadDate = date;
        userId = user.getUserId();
        state = PROCEEDING;
        count = 0;
        menuId = MENUID_AUCTION;
	}
	
//	기본 이미지 지정하는 메서드
	public void initImg(String contextPath) {
		img = contextPath + "/resources/images/somsom.jpg";
	}
	
	public String toString() {
		return "<<Auction객체의 값>" + "\nid : " + auctionId + "\ntitle : " + title + "\ncontent : " + content + "\nimg : " + img + 
				"\nstartPrice : " + startPrice + "\nendDate: " + endDate;
	}
	
}
