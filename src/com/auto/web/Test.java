package com.auto.web;

import com.auto.dao.FindAllDeptDao;

public class Test {
	public static void main(String[] args) {
		//System.out.println(Integer.parseInt(""));
		FindAllDeptDao findAll = new FindAllDeptDao();
		System.out.println(findAll.findRows());
	}
}
