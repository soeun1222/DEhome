package com.green.dehome.dto;

import java.sql.Timestamp;

public class CustomerDTO {
	// 외래키로받아오는 user_nick
	private String user_nick;
	private String user_nick2;
	
	
	public String getUser_nick2() {
		return user_nick2;
	}

	public void setUser_nick2(String user_nick2) {
		this.user_nick2 = user_nick2;
	}

	// QnA
	private int qna_no;
	private String qna_title;
	private String qna_content;
	private Timestamp qna_date;
	private int qna_count;
	private String qna_type;
	private String qna_pw;
	private String qna_process;
	private String usernick2;

	// QnA답글
	private int qna_c_no;
	private String qna_c_content;
	private Timestamp qna_c_date;

	// Notice
	private int not_no;
	private String not_title;
	private String not_content;
	private Timestamp not_date;
	private int not_count;
	private String not_menu;
	
	// startindex
	private int startIndex;
	
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getQna_no() {
		return qna_no;
	}

	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}

	public String getUser_nick() {
		return user_nick;
	}

	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}

	public String getQna_title() {
		return qna_title;
	}

	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}

	public String getQna_content() {
		return qna_content;
	}

	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}

	public Timestamp getQna_date() {
		return qna_date;
	}

	public void setQna_date(Timestamp qna_date) {
		this.qna_date = qna_date;
	}

	public int getQna_count() {
		return qna_count;
	}

	public void setQna_count(int qna_count) {
		this.qna_count = qna_count;
	}

	public String getQna_type() {
		return qna_type;
	}

	public void setQna_type(String qna_type) {
		this.qna_type = qna_type;
	}

	public String getQna_pw() {
		return qna_pw;
	}

	public void setQna_pw(String qna_pw) {
		this.qna_pw = qna_pw;
	}

	public String getQna_process() {
		return qna_process;
	}

	public void setQna_process(String qna_process) {
		this.qna_process = qna_process;
	}

	public String getUsernick2() {
		return usernick2;
	}

	public void setUsernick2(String usernick2) {
		this.usernick2 = usernick2;
	}

	public int getQna_c_no() {
		return qna_c_no;
	}

	public void setQna_c_no(int qna_c_no) {
		this.qna_c_no = qna_c_no;
	}

	public String getQna_c_content() {
		return qna_c_content;
	}

	public void setQna_c_content(String qna_c_content) {
		this.qna_c_content = qna_c_content;
	}

	public Timestamp getQna_c_date() {
		return qna_c_date;
	}

	public void setQna_c_date(Timestamp qna_c_date) {
		this.qna_c_date = qna_c_date;
	}

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
