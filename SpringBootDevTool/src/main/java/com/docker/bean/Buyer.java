package com.docker.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Buyer {

	@Id
	@SequenceGenerator(name="buyerSeq", initialValue=101, allocationSize=1)
	@GeneratedValue(generator="buyerSeq", strategy=GenerationType.SEQUENCE)
	@Column(name="BUYER_ID")
	@ApiModelProperty(hidden=true)
	private int buyerId;
	@Column(name="BUYER_NAME")
	private String buyerName;
	@Enumerated(EnumType.ORDINAL)
	@Column(name="BUYER_GENDER")
	private Gender gender;
	@Column(name="BUYER_JOIN")
	private LocalDateTime joinDateTime;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Book> books;
	
	public Buyer() {
		books = new ArrayList<>();
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDateTime getJoinDateTime() {
		return joinDateTime;
	}

	public void setJoinDateTime(LocalDateTime joinDateTime) {
		this.joinDateTime = joinDateTime;
	}

	public List<Book> getProducts() {
		return books;
	}

	public void setProducts(List<Book> books) {
		this.books = books;
	}
	
}
