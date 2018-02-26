package model;

import java.time.LocalDate;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {

	private int id;
	private SimpleStringProperty title;
	private SimpleStringProperty summary;
	private SimpleIntegerProperty yearPublished;
	private SimpleObjectProperty<Publisher> publisher;
	private SimpleStringProperty isbn;
	private SimpleObjectProperty<LocalDate> dateAdded;
	
	public Book() {
		title = new SimpleStringProperty();
		summary = new SimpleStringProperty();
		yearPublished = new SimpleIntegerProperty();
		publisher = new SimpleObjectProperty<Publisher>();
		isbn = new SimpleStringProperty();
		dateAdded = new SimpleObjectProperty<LocalDate>();
		
		setId(0);
		setTitle("");
		setSummary("");
		setYearPublished(0);
		setPublisher(null);
		setIsbn("");
		//setDateAdded(null);

	}
	
	public Book(String title, String summary, int yearPublished, Publisher publisher, String isbn, LocalDate dateAdded){
		this.title = new SimpleStringProperty();
		this.summary = new SimpleStringProperty();
		this.yearPublished = new SimpleIntegerProperty();
		this.publisher = new SimpleObjectProperty<Publisher>();
		this.isbn = new SimpleStringProperty();
		this.dateAdded = new SimpleObjectProperty<LocalDate>();
		
		if(!isValidTitle(title))
			throw new IllegalArgumentException("title must be between 1 and 255 characters!");
		setTitle(title);
		
		if(!isValidSummary(summary))
			throw new IllegalArgumentException("summary must be less than 65536 characters!");
		setSummary(summary);
		
		if(!isValidYear(yearPublished))
			throw new IllegalArgumentException("year published cannot be greater than currennt year!");
		setYearPublished(yearPublished);
		
		if(!isValidIsbn(isbn))
			throw new IllegalArgumentException("isbn cannot be more than 13 characters!");
		setIsbn(isbn);
		
		//maybe something for date added?
	}

	public boolean isValidTitle(String title){
		if(title.length() < 1 || title.length() > 255)
			return false;
		return true;
	}
	
	public boolean isValidSummary(String summary){
		if(summary.length() > 65536)
			return false;
		return true;
	}
	
	public boolean isValidYear(int yearPublished){
		LocalDate currDate = LocalDate.now();
		if(yearPublished == 0)
			return false;
		if(yearPublished <= currDate.getYear())
			return true;
		return false;
	}
	
	public boolean isValidIsbn(String isbn){
		if(isbn.length() > 13)
			return false;
		return true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getSummary() {
		return summary.get();
	}

	public void setSummary(String summary) {
		this.summary.set(summary);
	}

	public int getYearPublished() {
		return yearPublished.get();
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished.set(yearPublished);
	}

	public Publisher getPublisher() {
		return publisher.get();
	}

	public void setPublisher(Publisher publisher) {
		this.publisher.set(publisher);
	}

	public String getIsbn() {
		return isbn.get();
	}

	public void setIsbn(String isbn) {
		this.isbn.set(isbn);
	}

	/*public LocalDate getDateAdded() {
		return dateAdded.get();
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded.set(dateAdded);
	}*/
	
	public SimpleStringProperty titleProperty(){
		return title;
	}
	public SimpleStringProperty summaryProperty(){
		return summary;
	}
	public SimpleIntegerProperty yearPublishedProperty(){
		return yearPublished;
	}
	public SimpleObjectProperty<Publisher> publisherProperty(){
		return publisher;
	}
	public SimpleStringProperty isbnProperty(){
		return isbn;
	}
	public SimpleObjectProperty<LocalDate> dateAddedProperty(){
		return dateAdded;
	}
}
