package com.mayank.mayankbookstore.controllers;

import com.mayank.mayankbookstore.model.Book;
import com.mayank.mayankbookstore.repositories.DBConnection;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class TestController {

    @GetMapping("/books")
    public List<Book> getBooks() throws SQLException {
        Connection con = DBConnection.getCon();
        List<Book> bookList = new LinkedList<>();
        PreparedStatement ps = con.prepareStatement("Select * from " + Book.TABLE_BOOK);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            bookList.add(extracted( rs));
        }
        return bookList;
    }
    private Book  extracted(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setName(rs.getString(2));
        book.setAuthor(rs.getString(3));
        book.setBarcode(rs.getString(1));
        book.setPrice(rs.getInt(4));
        book.setQuantity(rs.getInt(5));
        return book;
    }

}
