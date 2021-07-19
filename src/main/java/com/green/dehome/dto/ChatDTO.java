package com.green.dehome.dto;

import java.security.Timestamp;

public class ChatDTO {
	private int trade_chatno; // 채팅데이터번호
	private int trade_no; // 사고싶은 물품의 번호
	private String user_nick; // 보내는 사람 닉네임
	private String to_nick; // 상대방 닉네임
	private String trade_chatcontent; // 채팅내용
	private Timestamp trade_chattime; // 발송시간
	private int trade_chatread; // 읽음표시
	private String listType;
	private int number; //제한두기위해서사용
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public int getTrade_chatno() {
		return trade_chatno;
	}
	public void setTrade_chatno(int trade_chatno) {
		this.trade_chatno = trade_chatno;
	}
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
	public String getTo_nick() {
		return to_nick;
	}
	public void setTo_nick(String to_nick) {
		this.to_nick = to_nick;
	}
	public String getTrade_chatcontent() {
		return trade_chatcontent;
	}
	public void setTrade_chatcontent(String trade_chatcontent) {
		this.trade_chatcontent = trade_chatcontent;
	}
	public Timestamp getTrade_chattime() {
		return trade_chattime;
	}
	public void setTrade_chattime(Timestamp trade_chattime) {
		this.trade_chattime = trade_chattime;
	}
	public int getTrade_chatread() {
		return trade_chatread;
	}
	public void setTrade_chatread(int trade_chatread) {
		this.trade_chatread = trade_chatread;
	}
	//트레이드 목록
	private String trade_photo;
	private String trade_price;
	private int trade_complete;
	private String trade_title;
	private Timestamp trade_date;
	public String getTrade_title() {
		return trade_title;
	}
	public void setTrade_title(String trade_title) {
		this.trade_title = trade_title;
	}
	public String getTrade_photo() {
		return trade_photo;
	}
	public void setTrade_photo(String trade_photo) {
		this.trade_photo = trade_photo;
	}
	public String getTrade_price() {
		return trade_price;
	}
	public void setTrade_price(String trade_price) {
		this.trade_price = trade_price;
	}
	public int getTrade_complete() {
		return trade_complete;
	}
	public void setTrade_complete(int trade_complete) {
		this.trade_complete = trade_complete;
	}
	public Timestamp getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Timestamp trade_date) {
		this.trade_date = trade_date;
	}
	// 대화상대담을 닉네임
	private String chat_nick;


	public String getChat_nick() {
		return chat_nick;
	}
	public void setChat_nick(String chat_nick) {
		this.chat_nick = chat_nick;
	}
	
	/*--시공상담 채팅--*/
	private int coun_chatno; // 시공상담 채팅데이터번호
	private String com_name; // 시공상담 진행중인 업체
//	private String user_nick; // 보내는 사람 닉네임
//	private String to_nick; // 상대방 닉네임
	private String coun_chatcontent; // 시공상담 채팅내용
	private Timestamp coun_chattime; // 시공상담 채팅 발송시간
	private int coun_chatread; // 시공상담 읽음표시
//	private String listType;
//	private int number; //제한두기위해서사용
	
	
	//시공상담 업체 정보
	private String com_addr; // 업체 위치
	private float com_rating; // 업체 평점
	private String com_file; // 업체 사진


	public int getCoun_chatno() {
		return coun_chatno;
	}
	public void setCoun_chatno(int coun_chatno) {
		this.coun_chatno = coun_chatno;
	}
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getCoun_chatcontent() {
		return coun_chatcontent;
	}
	public void setCoun_chatcontent(String coun_chatcontent) {
		this.coun_chatcontent = coun_chatcontent;
	}
	public Timestamp getCoun_chattime() {
		return coun_chattime;
	}
	public void setCoun_chattime(Timestamp coun_chattime) {
		this.coun_chattime = coun_chattime;
	}
	public int getCoun_chatread() {
		return coun_chatread;
	}
	public void setCoun_chatread(int coun_chatread) {
		this.coun_chatread = coun_chatread;
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
	public String getCom_file() {
		return com_file;
	}
	public void setCom_file(String com_file) {
		this.com_file = com_file;
	}
	
	
}
