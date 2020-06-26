package dongduk.cs.ssd.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupBuy {
	private static final String PROCEEDING = "proceeding";
	private static final int MENUID_GROUPBUY = 2;
	
	int groupBuyId;
	@NotEmpty
	String title;
	@NotEmpty
	String content;
	String img;
	
	@NotNull
	@Positive
	int minNo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	Date uploadDate;

	@NotNull
	@Future
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
	Date endDate;
	
	int count;
	String state;
	int rate;
	int participants;
	
	@NotNull
	int catId;
	
	int menuId;
	int userId;
	
	@NotNull
	@Positive
	int price;
	@NotEmpty
	String[] optionList;
	
	List<Option> options = new ArrayList<Option>();
	List<User> groupBuyUsers = new ArrayList<User>();
	List<Question> questions = new ArrayList<Question>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public List<User> getGroupBuyUsers() {
		return groupBuyUsers;
	}

	public void setGroupBuyUsers(List<User> groupBuyUsers) {
		this.groupBuyUsers = groupBuyUsers;
	}

	public int getGroupBuyId() {
		return groupBuyId;
	}

	public void setGroupBuyId(int groupBuyId) {
		this.groupBuyId = groupBuyId;
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

	public int getMinNo() {
		return minNo;
	}

	public void setMinNo(int minNo) {
		this.minNo = minNo;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getParticipants() {
		return participants;
	}

	public void setParticipants(int participants) {
		this.participants = participants;
	}
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String[] getOptionList() {
		return optionList;
	}

	public void setOptionList(String[] optionList) {
		this.optionList = optionList;
	}

	public GroupBuy() {
	}

//	기본 이미지 지정하는 메서드
	public void initImg(String contextPath) {
		img = contextPath + "/resources/images/somsom.jpg";
	}
	
	public void initGroupBuy(User user) {
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        System.out.println(date);
        
        uploadDate = date;
        userId = user.getUserId();
        count = 0;					// 조회수
        state = PROCEEDING;			// 게시물 상태
        rate = 0;					// 참여 달성률
        participants = 0;			// 참여자 수
        menuId = MENUID_GROUPBUY;	// 메뉴
        
        System.out.println("[initGroupBuy] uploadDate: " + uploadDate + ", userId: " + userId
        		 + ", count: " + count  + ", state: " + state  + ", rate: " + rate  
        		 + ", participants: " + participants  + ", menuId: " + menuId );
	}
	
	public void optionSetting(int groupBuyId) {
		
		for(int i = 0; i < optionList.length; i++) {
			Option op = new Option();
			op.setName(optionList[i]);
			op.setGroupBuyId(groupBuyId);
			options.add(i, op);
		}
	}
	
	public String getDday(long start, long end) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		long timeLength = getEndDate().getTime() - getUploadDate().getTime();
		long hour = (timeLength % ( 24*60*60*1000 )) / ( 60*60*1000 ); 
		long dDay = timeLength / ( 24*60*60*1000 ); 
		String str = dDay + "일 " + hour + "시간  (" + sdf.format(getEndDate()) + "까지)";
		System.out.println("str");
		return str;
	}
	
	public String toString() {
		String str = "groupBuyId: " + groupBuyId + ", title: " + title + ", content: " + content + ", img: " + img 
				+ ", minNo: " + minNo + ", uploadDate: " + uploadDate + ", endDate: " + endDate + ", catId: " + catId;
		str += "\noptions --> ";
		for(Option op:options) {
			str += op.toString() + "\n";
		}
		
		return str;
	}

}
