package com.green.dehome.dto;

import java.sql.Timestamp;

public class MyTradeDTO {
	private int trade_no;
	private String user_nick;
	private String category;
	private String trade_title;
	private String trade_content;
	private Timestamp trade_date;
	private int trade_count;
	private int trade_evalue;
	private String trade_price;
	private String trade_photo;
	private String trade_thumb;
	private int trade_complete;
	private int trade_interest;
	private String user_addr2;
	
	
	public int getTrade_no() {
		return trade_no;
	}
	public void setTrade_no(int trade_no) {
		this.trade_no = trade_no;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTrade_title() {
		return trade_title;
	}
	public void setTrade_title(String trade_title) {
		this.trade_title = trade_title;
	}
	public String getTrade_content() {
		return trade_content;
	}
	public void setTrade_content(String trade_content) {
		this.trade_content = trade_content;
	}
	public Timestamp getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Timestamp trade_date) {
		this.trade_date = trade_date;
	}
	public int getTrade_count() {
		return trade_count;
	}
	public void setTrade_count(int trade_count) {
		this.trade_count = trade_count;
	}
	public int getTrade_evalue() {
		return trade_evalue;
	}
	public void setTrade_evalue(int trade_evalue) {
		this.trade_evalue = trade_evalue;
	}
	public String getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(String trade_price) {
		this.trade_price = trade_price;
	}
	public String getTrade_photo() {
		return trade_photo;
	}
	public void setTrade_photo(String trade_photo) {
		this.trade_photo = trade_photo;
	}
	public String getTrade_thumb() {
		return trade_thumb;
	}
	public void setTrade_thumb(String trade_thumb) {
		this.trade_thumb = trade_thumb;
	}
	public int getTrade_complete() {
		return trade_complete;
	}
	public void setTrade_complete(int trade_complete) {
		this.trade_complete = trade_complete;
	}
	public int getTrade_interest() {
		return trade_interest;
	}
	public void setTrade_interest(int trade_interest) {
		this.trade_interest = trade_interest;
	}
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	
	
}
