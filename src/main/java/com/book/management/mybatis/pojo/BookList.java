package com.book.management.mybatis.pojo;

import java.io.Serializable;

import lombok.Data;

/**
 * book_list
 *
 * @author
 */
@Data
public class BookList implements Serializable {
    private Long bookId;

    private String name;

    private String author;

    private Integer year;

    private String isbn;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BookList other = (BookList) that;
        return (this.getBookId() == null ? other.getBookId() == null : this.getBookId().equals(other.getBookId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
                && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
                && (this.getIsbn() == null ? other.getIsbn() == null : this.getIsbn().equals(other.getIsbn()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBookId() == null) ? 0 : getBookId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getIsbn() == null) ? 0 : getIsbn().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bookId=").append(bookId);
        sb.append(", name=").append(name);
        sb.append(", author=").append(author);
        sb.append(", year=").append(year);
        sb.append(", isbn=").append(isbn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}