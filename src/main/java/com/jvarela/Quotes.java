package com.jvarela;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String quote;
    private String author;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getQuote() {
        return quote;
    }
    
    public void setQuote(String quote) {
        this.quote = quote;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
}
