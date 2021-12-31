package com.mayank.mayankbookstore.controllers;

import com.mayank.mayankbookstore.model.Book;
import com.mayank.mayankbookstore.repositories.DBConnection;
import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class BookController {
    Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/book")
    public String service(ServletRequest req, Model model) throws IOException, ServletException {
        try {
            Connection con = DBConnection.getCon();
            List<Book> bookList = new LinkedList<>();
            PreparedStatement ps = con.prepareStatement("Select * from " + Book.TABLE_BOOK);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                bookList.add(extracted( rs));
            }
            model.addAttribute("isAdmin", Boolean.valueOf(req.getParameter("isAdmin")));
            model.addAttribute("books", bookList);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "bookList";
    }

    @GetMapping("/book/{barCode}")
    public String getBook(HttpServletRequest request, Model model,
                          @NotNull @PathVariable String barCode ) throws SQLException {
        Connection con = DBConnection.getCon();
        PreparedStatement ps = con.prepareStatement("Select * from " + Book.TABLE_BOOK+" where barcode =?");
        ps.setString(1, barCode);
        ResultSet rs = ps.executeQuery();
        Book book = null;
        if (rs.next()) {
            book =extracted( rs);
        }
        log.info("Buying Book "+ book);
        model.addAttribute("book", book);
        return "buyBook";
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

    @PostMapping("/book")
    public String addBook(HttpServletRequest req, Model model) {
        String barcode = req.getParameter(Book.COLUMN_BARCODE);
        String name = req.getParameter(Book.COLUMN_NAME);
        String author = req.getParameter(Book.COLUMN_AUTHOR);
        String price = req.getParameter(Book.COLUMN_PRICE);
        String quantity = req.getParameter(Book.COLUMN_QUANTITY);
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("insert into " + Book.TABLE_BOOK + "  values(?,?,?,?,?)");
            ps.setString(1,barcode);
            ps.setString(2,name);
            ps.setString(3,author);
            ps.setString(4,price);
            ps.setString(5,quantity);
            int k = ps.executeUpdate();
                if(k == 1){
                    model.addAttribute("message","Books added successfully");
                    model.addAttribute("result", "added");
                    return "addBook";
                }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        model.addAttribute("result", "error");
        return "addBook";
    }

    @GetMapping("/addBook")
    public String addBook(HttpServletRequest request){
        return "addBook";
    }
    @PostMapping("/removebook")
    public String removeBook(HttpServletRequest req, Model model){
        String bkid = req.getParameter("barcode");
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement(
                    "delete from " + Book.TABLE_BOOK + "  where " + Book.COLUMN_BARCODE + "=?");
            ps.setString(1, bkid);
            int k = ps.executeUpdate();
            if (k == 1) {
                return "removeBooks";
            } else {
                return "loggedInAdmin";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "removeBook";
    }
    @GetMapping("/removebook")
    public String removeBook(HttpServletRequest request){
        return "removeBooks";
    }
}
