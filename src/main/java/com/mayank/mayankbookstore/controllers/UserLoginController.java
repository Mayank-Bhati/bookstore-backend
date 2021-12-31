package com.mayank.mayankbookstore.controllers;

import com.mayank.mayankbookstore.model.User;
import com.mayank.mayankbookstore.repositories.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Controller
public class UserLoginController {
    Logger log = LoggerFactory.getLogger(UserLoginController.class);
    @GetMapping("/login")
    public String getLoginPage(HttpServletRequest request){
        return "userLogin";
    }



    @PostMapping("/userLogin")
    public String login(HttpServletRequest request, Model model){
        String uName = request.getParameter(User.COLUMN_USERNAME);
        String pWord = request.getParameter(User.COLUMN_PASSWORD);
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM" + " " + User.TABLE_USERS + " WHERE "
                    + User.COLUMN_USERNAME + "=? AND " + User.COLUMN_PASSWORD + "=? AND " + User.COLUMN_USERTYPE + "=2");
            ps.setString(1, uName);
            ps.setString(2, pWord);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                model.addAttribute("username", uName);
                return "loggedinUser";
            } else {
                log.error("Login Failed!!!");
                return "loginFailed";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loginFailed";
    }
}
