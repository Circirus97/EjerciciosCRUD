package entity;

import java.util.Date;

public class Book {

    private Integer id;

    private String title;

    private Date yearPublication;

    private Double price;

    private Integer idAuthor;


    public Book(Integer id, String title, Date yearPublication, Double price, Integer idAuthor) {
        this.id = id;
        this.title = title;
        this.yearPublication = yearPublication;
        this.price = price;
        this.idAuthor = idAuthor;
    }

    public Book() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(Date yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearPublication=" + yearPublication +
                ", price=" + price +
                ", idAuthor=" + idAuthor +
                '}' + "\n\n";
    }
}
