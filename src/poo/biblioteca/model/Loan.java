package poo.biblioteca.model;

import java.util.Date;

import poo.Date.System.Data;

public class Loan {

    private int id;
    private int bookId;
    private int userId;

    // id do funcionario que fez o emprestimo
    private int authorId;
    private Date beginDate;
    private Date endDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date date) {
        this.beginDate = (Date) date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }
}
