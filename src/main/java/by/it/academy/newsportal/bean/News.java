package by.it.academy.newsportal.bean;

import java.util.Date;

public class News {
	private String title;
	private String brief;
	private Date realeseDate;
	private String content;

	public News(String title, String brief, String content, Date date) {
		super();
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.realeseDate = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Date getRealeseDate() {
		return realeseDate;
	}

	public void setRealeseDate(Date realeseDate) {
		this.realeseDate = realeseDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((realeseDate == null) ? 0 : realeseDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		if (brief == null) {
			if (other.brief != null)
				return false;
		} else if (!brief.equals(other.brief))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (realeseDate == null) {
			if (other.realeseDate != null)
				return false;
		} else if (!realeseDate.equals(other.realeseDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("News [title=");
		builder.append(title);
		builder.append(", brief=");
		builder.append(brief);
		builder.append(", realeseDate=");
		builder.append(realeseDate);
		builder.append(", content=");
		builder.append(content);
		builder.append("]");
		return builder.toString();
	}

	
	

}
