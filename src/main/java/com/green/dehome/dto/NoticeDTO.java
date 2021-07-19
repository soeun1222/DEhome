package com.green.dehome.dto;

import java.sql.Timestamp;

public class NoticeDTO {
	private int not_no;
	private String not_title;
	private String not_content;
	private Timestamp not_date;
	private int not_count;
	private String not_menu;
	public int getNot_no() {
		return not_no;
	}
	public void setNot_no(int not_no) {
		this.not_no = not_no;
	}
	public String getNot_title() {
		return not_title;
	}
	public void setNot_title(String not_title) {
		this.not_title = not_title;
	}
	public String getNot_content() {
		return not_content;
	}
	public void setNot_content(String not_content) {
		this.not_content = not_content;
	}
	public Timestamp getNot_date() {
		return not_date;
	}
	public void setNot_date(Timestamp not_date) {
		this.not_date = not_date;
	}
	public int getNot_count() {
		return not_count;
	}
	public void setNot_count(int not_count) {
		this.not_count = not_count;
	}
	public String getNot_menu() {
		return not_menu;
	}
	public void setNot_menu(String not_menu) {
		this.not_menu = not_menu;
	}
	
	
}
