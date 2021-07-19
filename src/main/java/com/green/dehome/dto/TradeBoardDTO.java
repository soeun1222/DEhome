package com.green.dehome.dto;

import java.sql.Timestamp;

public class TradeBoardDTO {
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
	@Override
	public String toString() {
		return "TradeBoardDTO [board_id=" + board_id + ", user_nick=" + user_nick + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_date=" + board_date + ", board_count=" + board_count
				+ ", board_pw=" + board_pw + ", board_pagenum=" + board_pagenum + "]";
	}
	
   	
//	public static int pageSize = 10;
//	public static int pageCount = 1;
//	public static int pageNum = 1;
//	
//	public static String pageNumber(int limit){
//		String str = "";
//		int temp = (pageNum - 1) % limit;
//		int startPage = pageNum - temp;
//		
//		if ((startPage - limit)>0) {
//			str = "<a href = 'tr_board_list.jsp?pageNum="+(startPage - 1)+"'>[����]</a>&nbsp;&nbsp;";
//		}
//		for (int i = startPage; i < (startPage+limit); i++) {
//			if (i == pageNum) {
//				str += "["+i+"]&nbsp;&nbsp;";
//			}else {
//				str += "<a href='tr_board_list.jsp?pageNum="+i+"'>["+i+"]</a>&nbsp;&nbsp;";
//			}
//			if (i >= pageCount) {
//				break;
//			}
//		}
//		if ((startPage + limit) <= pageCount) {
//			str += "<a href='tr_board_list.jsp?pageNum="+(startPage+limit)+"'>[����]</a>";
//		}
//		
//		return str;
//	}
//	

   	
}
