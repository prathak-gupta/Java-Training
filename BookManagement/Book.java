package day3_4;

public class Book
{
	static int noOfBooks =0;
	private int bookId, isbNo, noOfPages;
	private String title, authName, publisher, publisherAddress;
	private int isAvailable;
	private double prize;
	private float discount;
	
	public Book()
	{
		bookId=0;
		isbNo=0;
		noOfPages =0;
		title = "No Title";
		authName = "No Author details";
		publisher = "No Publisher name";
		publisherAddress="No Address defined";
		isAvailable = 0;
		prize=0;
		noOfPages=0;
		discount =0.25f;
		noOfBooks++;
		}
	
	public Book(int bookId, int isbNo, int noOfPages, String title, String authName, String publisher,
			String publisherAddress, int isAvailable, double prize, float discount) {
		super();
		this.bookId = bookId;
		this.isbNo = isbNo;
		this.noOfPages = noOfPages;
		this.title = title;
		this.authName = authName;
		this.publisher = publisher;
		this.publisherAddress = publisherAddress;
		this.isAvailable = isAvailable;
		this.prize = prize;
		this.discount = discount;
		noOfBooks++;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getIsbNo() {
		return isbNo;
	}
	public void setIsbNo(int isbNo) {
		this.isbNo = isbNo;
	}
	public int getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisherAddress() {
		return publisherAddress;
	}
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}
	public int isAvailable() {
		return isAvailable;
	}
	public void setAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	
	
	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public void displayInfo() {
		System.out.println("---------------------------\n"
				+ "Book id: "+bookId+
				"\nISBN: "+isbNo+
				"\nTitle: "+ title
				+"\nAuthore: "+authName+
				"\nNo. of Pages: "+noOfPages+
				"\nPublisher: "+publisher+
				"\nPublisher Address: "+publisherAddress+
				"\nPrize: "+prize+
				"\nDiscount: "+ discount*100+"%"+
				"\nAfter Discount Cost: "+ (prize-=(prize*discount))+
				"\nAvailablity: "+isAvailable+
				"\n----x----x----x----x----x-----");
	}
	
	void issueBook()
	{
		if(isAvailable <=0)
		{
			System.out.println("Sorry, Book is not available!");
		}
		else
			isAvailable--;
	}
	
	void issueMultiple(int no) {
		if(no<=isAvailable)
		{
			isAvailable -= no;
		}
		else
		{
			System.out.println("Limit exceeded!");
		}
	}
	
    public void returnBook() {
        isAvailable++;
    }
	
}
