package com.green.dehome.dto;

import java.sql.Timestamp;

public class MyPageUl2DTO {
	
	//내가 작성한 QNA 관련 변수
	private int qna_no;
	private String qna_title;
	private String qna_content;
	private Timestamp qna_date;
	private int qna_count;
	private String qna_type;
	private String qna_pw;
	private String qna_process;
	private String qna_user_nick;
	
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
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
	public String getQna_user_nick() {
		return qna_user_nick;
	}
	public void setQna_user_nick(String qna_user_nick) {
		this.qna_user_nick = qna_user_nick;
	}




	//내가 등록한 중고거래 물품 관련 변수
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
	private String tr_thumb; //이미지 파일 업로드 썸네일
	private int tr_complete; //거래완료 여부
	private int like;  //관심도 갯수 총합
	private String user_addr2;  //유저 주소,닉네임 집어 넣을 변수
	
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getTr_no() {
		return tr_no;
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
	public int getTr_evalue() {
		return tr_evalue;
	}
	public void setTr_evalue(int tr_evalue) {
		this.tr_evalue = tr_evalue;
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
	public String getTr_thumb() {
		return tr_thumb;
	}
	public void setTr_thumb(String tr_thumb) {
		this.tr_thumb = tr_thumb;
	}
	public int getTr_complete() {
		return tr_complete;
	}
	public void setTr_complete(int tr_complete) {
		this.tr_complete = tr_complete;
	}




	//내가 작성한 인테리어팁 관련 변수
	private int tip_no;
	private String tip_user_nick;
	private String tip_category;
	private String tip_title;
	private String tip_content;
	private String tip_file;
	private Timestamp tip_date;
	private int tip_count;
	private int tip_bookmark;
	// 해당 글 북마크 추가한 유저 변수
	private String tip_bmuser;
	//이미지 파일 업로드 썸네일
	private String tip_thumb;
	
	public int getTip_no() {
		return tip_no;
	}
	public void setTip_no(int tip_no) {
		this.tip_no = tip_no;
	}
	public String getTip_user_nick() {
		return tip_user_nick;
	}
	public void setTip_user_nick(String tip_user_nick) {
		this.tip_user_nick = tip_user_nick;
	}
	public String getTip_category() {
		return tip_category;
	}
	public void setTip_category(String tip_category) {
		this.tip_category = tip_category;
	}
	public String getTip_title() {
		return tip_title;
	}
	public void setTip_title(String tip_title) {
		this.tip_title = tip_title;
	}
	public String getTip_content() {
		return tip_content;
	}
	public void setTip_content(String tip_content) {
		this.tip_content = tip_content;
	}
	public String getTip_file() {
		return tip_file;
	}
	public void setTip_file(String tip_file) {
		this.tip_file = tip_file;
	}
	public Timestamp getTip_date() {
		return tip_date;
	}
	public void setTip_date(Timestamp tip_date) {
		this.tip_date = tip_date;
	}
	public int getTip_count() {
		return tip_count;
	}
	public void setTip_count(int tip_count) {
		this.tip_count = tip_count;
	}
	public int getTip_bookmark() {
		return tip_bookmark;
	}
	public void setTip_bookmark(int tip_bookmark) {
		this.tip_bookmark = tip_bookmark;
	}
	public String getTip_bmuser() {
		return tip_bmuser;
	}
	public void setTip_bmuser(String tip_bmuser) {
		this.tip_bmuser = tip_bmuser;
	}
	public String getTip_thumb() {
		return tip_thumb;
	}
	public void setTip_thumb(String tip_thumb) {
		this.tip_thumb = tip_thumb;
	}
	
	
	
	
	// 내가 작성한 게시물 관련 변수
	private int board_id;
	private String user_nick;
	private String board_title;
	private String board_content;
	private Timestamp board_date;
   	private int board_count;
   	private String board_pw;
   	private int board_pagenum;
   	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Timestamp getBoard_date() {
		return board_date;
	}
	public void setBoard_date(Timestamp board_date) {
		this.board_date = board_date;
	}
	public int getBoard_count() {
		return board_count;
	}
	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}
	public String getBoard_pw() {
		return board_pw;
	}
	public void setBoard_pw(String board_pw) {
		this.board_pw = board_pw;
	}
	public int getBoard_pagenum() {
		return board_pagenum;
	}
	public void setBoard_pagenum(int board_pagenum) {
		this.board_pagenum = board_pagenum;
	}
   	
}
