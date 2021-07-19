package com.green.dehome.dto;
import java.sql.Timestamp;

public class TradeDTO {
	private int tr_no;
	private String tr_user_nick;
	private String tr_category;
	private String tr_title;
	private String tr_content;
	private Timestamp tr_date;
	private int tr_count;
	private int tr_evalue;
	private String tr_price;
	private String tr_photo;
	private String tr_thumb;//이미지 파일 업로드 썸네일
	private int tr_complete; //거래완료 여부
	private String tr_buyer;
	public String getTr_buyer() {
		return tr_buyer;
	}
	public void setTr_buyer(String tr_buyer) {
		this.tr_buyer = tr_buyer;
	}
	//날짜 받아오는 변수들
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	//더보기 버튼 클릭할떄 필요한 변수
	private int startPage;
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public String getTr_thumb() {
		return tr_thumb;
	}
	public void setTr_thumb(String tr_thumb) {
		this.tr_thumb = tr_thumb;
	}
	////////////////////
	//유저 주소,닉네임 집어 넣을 변수
	private String user_addr2;
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	////////////////////
	///관심도 갯수 총합
	private int like;
	
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	///////////////////
	public int getTr_no() {
		return tr_no;
	}
	public int getTr_evalue() {
		return tr_evalue;
	}
	public void setTr_evalue(int tr_evalue) {
		this.tr_evalue = tr_evalue;
	}
	public void setTr_no(int tr_no) {
		this.tr_no = tr_no;
	}
	public String getTr_user_nick() {
		return tr_user_nick;
	}
	public void setTr_user_nick(String tr_user_nick) {
		this.tr_user_nick = tr_user_nick;
	}
	public String getTr_category() {
		return tr_category;
	}
	public void setTr_category(String tr_category) {
		this.tr_category = tr_category;
	}
	public String getTr_title() {
		return tr_title;
	}
	public void setTr_title(String tr_title) {
		this.tr_title = tr_title;
	}
	public String getTr_content() {
		return tr_content;
	}
	public void setTr_content(String tr_content) {
		this.tr_content = tr_content;
	}
	public Timestamp getTr_date() {
		return tr_date;
	}
	public void setTr_date(Timestamp tr_date) {
		this.tr_date = tr_date;
	}
	public int getTr_count() {
		return tr_count;
	}
	public void setTr_count(int tr_count) {
		this.tr_count = tr_count;
	}
	public String getTr_price() {
		return tr_price;
	}
	public void setTr_price(String tr_price) {
		this.tr_price = tr_price;
	}
	public String getTr_photo() {
		return tr_photo;
	}
	public void setTr_photo(String tr_photo) {
		this.tr_photo = tr_photo;
	}
	public int getTr_complete() {
		return tr_complete;
	}
	public void setTr_complete(int tr_complete) {
		this.tr_complete = tr_complete;
	}
}
