package dongduk.cs.ssd.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dongduk.cs.ssd.controller.groupBuy.LineGroupBuyCommand;

public class Order {
	int orderId;
	String cardBank;
	String cardNo;
	String validDate;
	String cvc;
	String address1;
	String address2;
	String address3;
	String phone;
	String refundBank;
	String refundAccount;
	int userId;
	List<LineGroupBuy> lineGroupBuys = new ArrayList<LineGroupBuy>();
	Bid successBidder = new Bid();
	User user = new User();
	int totalPrice;
	Date orderDate;
	String title; // 공동구매 또는 경매의 제목 for 결제내역 목록보기
	String img; // 미리보기 사진 for 결제내역 목록보기
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Bid getSuccessBidder() {
		return successBidder;
	}

	public void setSuccessBidder(Bid successBidder) {
		this.successBidder = successBidder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Order() {
	}
	
	public List<LineGroupBuy> getLineGroupBuys() {
		return lineGroupBuys;
	}

	public void setLineGroupBuys(List<LineGroupBuy> lineGroupBuys) {
		this.lineGroupBuys = lineGroupBuys;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCardBank() {
		return cardBank;
	}

	public void setCardBank(String cardBank) {
		this.cardBank = cardBank;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRefundBank() {
		return refundBank;
	}

	public void setRefundBank(String refundBank) {
		this.refundBank = refundBank;
	}

	public String getRefundAccount() {
		return refundAccount;
	}

	public void setRefundAccount(String refundAccount) {
		this.refundAccount = refundAccount;
	}
	
	public void initOrder(User user, LineGroupBuyCommand lineGroupBuyCommand, Auction auction) {
		// 주소 불러오기
		address1 = user.getAddress1();
		address2 = user.getAddress2();
		address3 = user.getAddress3();
		
		// 전화번호 불러오기
		phone = user.getPhone();
		
		// 환불계좌 정보 불러오기
		refundBank = user.getRefundBank();
		refundAccount = user.getRefundAccount();
		
		// order한 날짜
		orderDate = new Date();
		
		// GroupBuy를 결제하는 경우
		if (lineGroupBuyCommand != null) {
			//lineGroupBuys = lineGroupBuyCommand.getLineGroupBuyList();
			//totalPrice = lineGroupBuyCommand.getTotalPrice();
		}

		// Auction을 결제하는 경우
		if (auction != null) {
			List<Bid> bids = auction.getBids();
			totalPrice = auction.getMaxPrice();
			
			for (Bid bid : bids) {
				if (bid.getBidPrice() == totalPrice) {
					successBidder = bid;
					break;
				}
			}
		}

	}

}
