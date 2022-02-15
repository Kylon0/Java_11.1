package domain;

public class Book extends Product {
    private String author;

    public Book() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
