package dongduk.cs.ssd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupBuy {
	int groupBuyId;
	String title;
	String content;
	String img;
	int minNo;
	String[] options;
	Date uploadDate;
	Date endDate;
	int count;
	int state;
	int rate;
	int participants;
	List<User> groupBuyUsers = new ArrayList<User>();
	List<Question> questions = new ArrayList<Question>();
	int catId;
	int menuId;
	int userId;
	List<LineGroupBuy> lineGroupBuys = new ArrayList<LineGroupBuy>();

	public List<LineGroupBuy> getLineGroupBuys() {
		return lineGroupBuys;
	}

	public void setLineGroupBuys(List<LineGroupBuy> lineGroupBuys) {
		this.lineGroupBuys = lineGroupBuys;
	}

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

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
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

	public GroupBuy() {
	}

	public void addLineGroupBuy(LineGroupBuy lineGroupBuy) {
		lineGroupBuys.add(lineGroupBuy);
	}

	public void removeLineGroupBuyById(int lineId) {
		lineGroupBuys.remove(lineId);
	}

	public int getTotalPrice() {
		int totalPrice = 0;

		for (LineGroupBuy lineGroupBuy : lineGroupBuys) {
			totalPrice += lineGroupBuy.getUnitPrice();
		}
		return totalPrice;
	}

}
