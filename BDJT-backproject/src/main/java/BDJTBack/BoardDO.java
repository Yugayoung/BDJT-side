package BDJTBack;

import java.util.Date;

public class BoardDO {
	private String photo;
    private String title;
    private String url;
    private String skill;
    private Date creationdate;
    private int orderRcmnd;
    private String id;
    
    public BoardDO() {
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

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
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
