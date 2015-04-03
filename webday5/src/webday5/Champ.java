package webday5;

import java.io.Serializable;
import java.sql.Date;

/**
 * Ã¨ÇÇ¾ð Á¤º¸ Java Bean
 */
public class Champ implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long no;
	private String name;
	private String type;
	private int health;
	private int damage;
	private Date regDate;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
