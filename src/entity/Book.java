package entity;

import java.util.Date;

public class Book {

    private int id;

    private String title;

    private Date publicationYear;

    private double price;

    public Book(int id, String title, Date publicationYear, double price) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", price=" + price;
    }
}
