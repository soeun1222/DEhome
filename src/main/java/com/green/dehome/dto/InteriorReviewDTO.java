package com.green.dehome.dto;

import java.sql.Timestamp;

public class InteriorReviewDTO {
	private int re_no;
	private String com_name;
	private String user_nick;
	private String re_title;
	private String re_content;
	private String re_file;
	private Timestamp re_date;
	private float com_rating;
	
	//더보기 버튼 클릭할떄 필요한 변수
		private int startPage;
		
		public int getStartPage() {
			return startPage;
		}
		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}
	////////////////////
		
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getRe_title() {
		return re_title;
	}
	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}
	public String getRe_content() {
		return re_content;
	}
	public void setRe_content(String re_content) {
		this.re_content = re_content;
	}
	public String getRe_file() {
		return re_file;
	}
	public void setRe_file(String re_file) {
		this.re_file = re_file;
	}
	public Timestamp getRe_date() {
		return re_date;
	}
	public void setRe_date(Timestamp re_date) {
		this.re_date = re_date;
	}
	public float getCom_rating() {
		return com_rating;
	}
	public void setCom_rating(float com_rating) {
		this.com_rating = com_rating;
	}
	
}
