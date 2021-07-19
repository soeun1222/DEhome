package com.green.dehome.dto;

import java.sql.Timestamp;

public class InteriorDTO {
	
	//업체 정보 받아오기
	private String com_name;
	private String com_addr;
	private float com_rating;
	private String com_title;
	private String com_content;
	private int com_contract;
	private int re_count;
	//이미지 업로으용 변수
	private String com_file;
	private String com_thumbfile;
	
	//업체 위치
	private String addr;
	//더보기 페이지
	private int startPage;
	private int startRePage;
	private int startExPage;
	
	//업체 리뷰 받아오기
	private int re_no;
	private String user_nick;
	private String re_title;
	private String re_content;
	private Timestamp re_date;
	private int re_interest;
	//이미지 업로으용 변수
	private String re_file;
	private String re_thumbfile;
	
	//업체 사례 받아오기
	private int ex_no;
	private String ex_title;
	private String ex_content;
	private Timestamp reg_date;
	//이미지 업로으용 변수
	private String ex_file;
	private String ex_thumbfile;
	
	
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCom_addr() {
		return com_addr;
	}
	public void setCom_addr(String com_addr) {
		this.com_addr = com_addr;
	}
	public float getCom_rating() {
		return com_rating;
	}
	public void setCom_rating(float com_rating) {
		this.com_rating = com_rating;
	}
	public String getCom_title() {
		return com_title;
	}
	public void setCom_title(String com_title) {
		this.com_title = com_title;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public int getCom_contract() {
		return com_contract;
	}
	public void setCom_contract(int com_contract) {
		this.com_contract = com_contract;
	}
	public String getCom_file() {
		return com_file;
	}
	public void setCom_file(String com_file) {
		this.com_file = com_file;
	}
	
	public String getCom_thumbfile() {
		return com_thumbfile;
	}
	public void setCom_thumbfile(String com_thumbfile) {
		this.com_thumbfile = com_thumbfile;
	}
	public int getRe_count() {
		return re_count;
	}
	public void setRe_count(int re_count) {
		this.re_count = re_count;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getStartRePage() {
		return startRePage;
	}
	public void setStartRePage(int startRePage) {
		this.startRePage = startRePage;
	}
	public int getStartExPage() {
		return startExPage;
	}
	public void setStartExPage(int startExPage) {
		this.startExPage = startExPage;
	}
	public int getRe_no() {
		return re_no;
	}
	public void setRe_no(int re_no) {
		this.re_no = re_no;
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
	
	public String getRe_thumbfile() {
		return re_thumbfile;
	}
	public void setRe_thumbfile(String re_thumbfile) {
		this.re_thumbfile = re_thumbfile;
	}
	public Timestamp getRe_date() {
		return re_date;
	}
	public void setRe_date(Timestamp re_date) {
		this.re_date = re_date;
	}
	public int getRe_interest() {
		return re_interest;
	}
	public void setRe_interest(int re_interest) {
		this.re_interest = re_interest;
	}
	public int getEx_no() {
		return ex_no;
	}
	public void setEx_no(int ex_no) {
		this.ex_no = ex_no;
	}
	public String getEx_title() {
		return ex_title;
	}
	public void setEx_title(String ex_title) {
		this.ex_title = ex_title;
	}
	public String getEx_content() {
		return ex_content;
	}
	public void setEx_content(String ex_content) {
		this.ex_content = ex_content;
	}
	public String getEx_file() {
		return ex_file;
	}
	public void setEx_file(String ex_file) {
		this.ex_file = ex_file;
	}
	
	public String getEx_thumbfile() {
		return ex_thumbfile;
	}
	public void setEx_thumbfile(String ex_thumbfile) {
		this.ex_thumbfile = ex_thumbfile;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}

}
