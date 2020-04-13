package com.myweb.domain;

import java.sql.Date;

// 마이바티스에서 데이터베이스와 연동시 데이터와 칼럼명이 동기화 됨.( 마이바티스가 알아서 get해주고 set해준다. )
public class ProductVO {
	private int pno;
	private String category;
	private String pname; 
	private String content; 
	private String pwriter; 
	private int readcount;
	private Date regdate;
	private Date moddate;
	private String imgfile;
	
	public ProductVO() {}
	
	
	// 제품수정( update )시 필요한 생성자
	public ProductVO(int pno, String category, String pname, String content, String imgfile) { // update
		this.pno = pno;
		this.category = category;
		this.pname = pname;
		this.content = content;
		this.imgfile = imgfile;
	}
	
	// 제품등록( insert )시 필요한 생성자
	public ProductVO(String pname, String category, String pwriter, String imgfile, String content) { // insert
		this.pname = pname;
		this.category = category;
		this.pwriter = pwriter;
		this.imgfile = imgfile;
		this.content = content;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getPwriter() {
		return pwriter;
	}


	public void setPwriter(String pwriter) {
		this.pwriter = pwriter;
	}


	public int getReadcount() {
		return readcount;
	}


	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public Date getModdate() {
		return moddate;
	}


	public void setModdate(Date moddate) {
		this.moddate = moddate;
	}


	public String getImgfile() {
		return imgfile;
	}


	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}
	
}
