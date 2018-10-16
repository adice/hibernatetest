package com.abc.cakeonline.type.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.abc.cakeonline.entity.CakeType;
import com.abc.cakeonline.type.dao.CakeTypeDao;

public class CakeTypeService {
	
	public List<CakeType> list(){
		CakeTypeDao cakeTypeDao=new CakeTypeDao();
		return cakeTypeDao.findAll();
	}
	
	public HashMap<String, Set<String>> list1(){
		HashMap<String, Set<String>> types=new HashMap<String, Set<String>>();
		CakeTypeDao cakeTypeDao=new CakeTypeDao();
		List<CakeType> list=cakeTypeDao.findAll();
		for(CakeType temp:list) {
			if(temp.getParentId()==0) {
				types.put(temp.getName(), new HashSet<String>());
			}else {
				for(CakeType tem:list) {
					if(temp.getParentId()==tem.getId()) {
						types.get(tem.getName()).add(temp.getName());
					}
				}
			}
		}
		return types;
	}
}
