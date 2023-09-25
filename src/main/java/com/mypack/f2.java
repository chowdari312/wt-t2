package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/f2")
public class f2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String mobile = request.getParameter("mobile");
        String education = request.getParameter("education");
        String academics = request.getParameter("academics");
        String course = request.getParameter("course");
        
        Connection con = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "root");
            s = con.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS used ("
                    + "name VARCHAR(550), Email VARCHAR(50), password VARCHAR(200), Gender VARCHAR(300),"
                    + "DOB VARCHAR(40), Mobile varchar(20), percentage VARCHAR(10), EduQf VARCHAR(20), Course VARCHAR(20))";
            s.executeUpdate(createTableQuery);
            
            String insertQuery = "INSERT INTO used (name, Email, password, Gender, DOB, Mobile, percentage, EduQf, Course) VALUES "
                    + "('" + name + "', '" + email + "', '" + password + "', '" + gender + "', '" + dob + "', '" + mobile + "', '" + academics + "', '" + education + "', '" + course + "')";
            s.executeUpdate(insertQuery);
            
            s.executeUpdate("commit"); 
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null) {
                    s.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        out.print("<script>");
        out.print("alert('You have registered successfully');");
        out.print("window.location.href = 'index.html';");
        out.print("</script>");
        out.print("</body></html>");
    }
}
