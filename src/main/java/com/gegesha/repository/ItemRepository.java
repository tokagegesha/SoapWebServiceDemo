package com.gegesha.repository;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class ItemRepository {
	
	Map< String, Double>itemList=new HashMap<>();
	
	@PostConstruct
	public void initData() {
		itemList.put("Apples", 1.90);
		itemList.put("watermelons", 3.55);
	}
	public double findItem(String name) {
		Assert.notNull(name);

		double result = 0;

		if(itemList.containsKey(name)){
			result = itemList.get(name);
		}

		return result;
	}

}
