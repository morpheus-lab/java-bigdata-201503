package webday5;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;		// 아이디
	private String name;	// 이름
	private String pw;		// 비번
	private String email;	// 이메일
	private Date regDate;	// 가입일
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPw() {
		return pw;
	}
	public String getEmail() {
		return email;
	}
	public Date getRegDate() {
		return regDate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}
