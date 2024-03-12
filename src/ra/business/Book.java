package ra.business;

import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        bookStatus = true;

    }

    public Book(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạ nhập id");
        bookId = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạ nhập tên sách");
        bookName = scanner.nextLine();
        System.out.println("Mời bạn nhập tên tác giả");
        author = scanner.nextLine();
        System.out.println("Mời bạ nhập mô tả");
        description = scanner.nextLine();
        System.out.println("Mời bạ nhập giá nhập");
        importPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạ nhập gía xuất");
        exportPrice = Double.parseDouble(scanner.nextLine());
    }

    public void displayData() {
        System.out.println("Book{" +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", descriptions='" + description + '\'' +
                ", status=" + (bookStatus ? "Đang bán" : "Không bán") +
                '}');
        System.out.println("=========================================");
    }

    public void calInterest() {
        interest = (float) (exportPrice - importPrice);
    }
}



