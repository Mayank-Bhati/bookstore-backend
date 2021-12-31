package com.mayank.mayankbookstore.controllers;

import com.mayank.mayankbookstore.model.User;
import com.mayank.mayankbookstore.repositories.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Controller
public class UserSignUpController {
    Logger log = LoggerFactory.getLogger(UserSignUpController.class);



    @GetMapping("/register")
    public String getSignUpPage(HttpServletRequest request){
        return "userSignUp";
    }


    @PostMapping("/userreg")
    public String signUp(ServletRequest req, Model model) throws IOException, ServletException {

            String uName = req.getParameter(User.COLUMN_USERNAME);
            String pWord = req.getParameter(User.COLUMN_PASSWORD);
            String fName = req.getParameter(User.COLUMN_FIRSTNAME);
            String lName = req.getParameter(User.COLUMN_LASTNAME);
            String addr = req.getParameter(User.COLUMN_ADDRESS);
            String phNo = req.getParameter(User.COLUMN_PHONE);
            String mailId = req.getParameter(User.COLUMN_MAILID);
            model.addAttribute("username",uName);
            try {
                Connection con = DBConnection.getCon();
                PreparedStatement ps = con
                        .prepareStatement("insert into " + User.TABLE_USERS + "  values(?,?,?,?,?,?,?,?)");
                ps.setString(1, uName);
                ps.setString(2, pWord);
                ps.setString(3, fName);
                ps.setString(4, lName);
                ps.setString(5, addr);
                ps.setString(6, phNo);
                ps.setString(7, mailId);
                ps.setInt(8, 2);
                int k = ps.executeUpdate();
                if (k == 1) {
                    return "signedUpUser";
                } else {
                    log.error("Signup Failed!!!");
                    return "signUpFailed";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "signUpFailed";
    }
}
