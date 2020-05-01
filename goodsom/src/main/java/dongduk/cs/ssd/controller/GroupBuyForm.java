package dongduk.cs.ssd.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Seonmi Hwang
 * @since 2020.05.01
 */

public class GroupBuyForm implements Serializable {
	String title;
	String img;
	String content;
	List<String> options;
	String tag;
	int minNum;
	Date endDate;
	
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
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<String> getOptions() {
		return options;
	}
	
	public void setOptions(List<String> options) {
		this.options = options;
	}
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public int getMinNum() {
		return minNum;
	}
	
	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
