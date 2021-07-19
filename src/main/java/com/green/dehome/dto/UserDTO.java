package com.green.dehome.dto;
import java.sql.Timestamp;

public class UserDTO {
	private String user_nick;
	private String user_id;
	private String user_pw;
	private String user_name;
	private int user_pnum;
	private String user_email;
	private String user_email2;
	private String user_sex;
	private String user_addr1;
	private String user_addr2;
	private String user_addr3;
	private String user_addr4;
	private Timestamp reg_date;
	private String com_name;
	private String login_type;

	///////select user이메일 선택값일때////////
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//////////////////////////////////
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_pnum() {
		return user_pnum;
	}
	public void setUser_pnum(int user_pnum) {
		this.user_pnum = user_pnum;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_email2() {
		return user_email2;
	}
	public void setUser_email2(String user_email2) {
		this.user_email2 = user_email2;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_addr1() {
		return user_addr1;
	}
	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	public String getUser_addr3() {
		return user_addr3;
	}
	public void setUser_addr3(String user_addr3) {
		this.user_addr3 = user_addr3;
	}
	public String getUser_addr4() {
		return user_addr4;
	}
	public void setUser_addr4(String user_addr4) {
		this.user_addr4 = user_addr4;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
	//메인페이지 중고거래 리스트용 변수
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
	private String tr_thumb;
	private int tr_complete;
	
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
	
	
	@Override
	public String toString() {
		return "RegisterDTO [user_nick=" + user_nick + ", user_id=" + user_id + ", user_pw=" + user_pw + ", user_name="
				+ user_name + ", user_pnum=" + user_pnum + ", user_email=" + user_email + ", user_email2=" + user_email2
				+ ", user_sex=" + user_sex + ", user_addr1=" + user_addr1 + ", user_addr2=" + user_addr2
				+ ", user_addr3=" + user_addr3 + ", user_addr4=" + user_addr4 + ", reg_date=" + reg_date + ", com_name="
				+ com_name + "]";
	}
}
