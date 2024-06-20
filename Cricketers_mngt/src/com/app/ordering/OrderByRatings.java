package com.app.ordering;

import java.util.Comparator;

import com.app.entities.Cricketers;

public class OrderByRatings implements Comparator<Cricketers> {

	@Override
	public int compare(Cricketers c1, Cricketers c2) {
		if(c1.getRating()<c2.getRating())
		return -1;
		if(c1.getRating()==c2.getRating())
			return 0;
		return 1;	
	}
}


