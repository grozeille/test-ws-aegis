package org.grozeille;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Items {
	
	private String dummyFriend; 
	
	public String getDummyFriend() {
		return dummyFriend;
	}

	public void setDummyFriend(String dummyFriend) {
		this.dummyFriend = dummyFriend;
	}

	private List<String> items;
	
	public Items(List<String> items) {
		super();
		this.items = items;
	}

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlElement(nillable=false)
	public List<String> getItems() {
		return items;
	}
	
	public void setItems(List<String> items) {
		this.items = items;
	}
}
