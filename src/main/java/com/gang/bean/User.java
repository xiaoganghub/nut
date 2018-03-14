package com.gang.bean;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("tb_user")
public class User {
	
	@Id
	private long id;
	
	private String name;
	
	private String passwd;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + "]";
	}

	
}
