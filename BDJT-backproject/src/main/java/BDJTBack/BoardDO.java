package BDJTBack;

import java.time.LocalDateTime;

public class BoardDO {
	private String photo;
    private String title;
    private String url;
    private String skill;
    private LocalDateTime creationDate;
    private int orderRcmnd;
    private String id;

	public BoardDO() {
		// TODO Auto-generated constructor stub
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public int getOrderRcmnd() {
		return orderRcmnd;
	}

	public void setOrderRcmnd(int orderRcmnd) {
		this.orderRcmnd = orderRcmnd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
