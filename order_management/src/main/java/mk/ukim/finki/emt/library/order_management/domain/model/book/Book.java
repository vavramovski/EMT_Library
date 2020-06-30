package mk.ukim.finki.emt.library.order_management.domain.model.book;


import mk.ukim.finki.emt.library.order_management.domain.model.author.Author;
import mk.ukim.finki.emt.library.order_management.domain.model.bookSample.BookSample;

import java.util.Set;

public class Book {

    private String title;

    private int pages;

    private Set<BookSample> bookSamples;

    private Set<Author> authors;

}