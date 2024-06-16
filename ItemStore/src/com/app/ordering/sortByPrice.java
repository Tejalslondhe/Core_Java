package com.app.ordering;

import java.util.Comparator;

import com.app.entity.Item;

public class sortByPrice implements Comparator<Item>{

	@Override
	public int compare(Item i1, Item i2) {
		if(i1.getPrice()<i2.getPrice())
		return -1;
		if(i1.getPrice()==i2.getPrice())
		return 0;
		return 1;
	}

}
