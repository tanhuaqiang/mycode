package com.daling.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {

	private Integer oid;
	private Date date;
	private Double total;
	private String desc;

	/**
	 * 某个订单对应的用户信息
	 */
	private User user;


}