package model;

import java.time.LocalDate;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Publisher {
	
	private int id;
	private SimpleStringProperty publisherName;
	
	public Publisher() {
		publisherName = new SimpleStringProperty();
		
		setPublisherName("");
	}
	
	public Publisher(String publisherName){
		setPublisherName(publisherName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName.get();
	}

	public void setPublisherName(String publisherName) {
		this.publisherName.set(publisherName);
	}

}
