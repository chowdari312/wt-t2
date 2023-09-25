package com.mypack;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/f1")
public class f1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pa = request.getParameter("email");
        String ps = request.getParameter("pass");
        String email = "";
        String password = "";
        String name = "";
        String gender = "";
        String mobile = "";
        String percentage = "";
        String eduQf = "";
        String course = "";
        PrintWriter o = response.getWriter();
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            try (
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "root");
                PreparedStatement p = con.prepareStatement("SELECT Email, password FROM used");
            ) {
                ResultSet rSet = p.executeQuery();

                while (rSet.next()) {
                    String Email = rSet.getString("Email");
                    String pass = rSet.getString("password");
                    a.add(Email);
                    b.add(pass);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int ans = 0;

        for (int i = 0; i < a.size(); i++) {
        	 o.print("<html><body>");
             o.print("<script>");
        	if (pa.equals(a.get(i)) && ps.equals(b.get(i))) {
        	    ans = 1;
        	    try {
        	        Class.forName("com.mysql.cj.jdbc.Driver");
        	        try (
        	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb", "root", "root");
        	            PreparedStatement p = con.prepareStatement("SELECT Email, password, name, Gender, Mobile, percentage, eduQf, Course FROM used WHERE Email=? AND password=?");
        	        ) {
        	            p.setString(1, pa);
        	            p.setString(2, ps);
        	            ResultSet resultSet = p.executeQuery();
        	            while (resultSet.next()) {
        	                email = resultSet.getString("Email");
        	                password = resultSet.getString("password");
        	                name = resultSet.getString("name");
        	                gender = resultSet.getString("Gender");
        	                mobile = resultSet.getString("Mobile");
        	                percentage = resultSet.getString("percentage");
        	                eduQf = resultSet.getString("eduQf");
        	                course = resultSet.getString("Course");
        	            }
        	        }
        	    } catch (Exception e) {
        	        e.printStackTrace();
        	    }
        	    
        	    HttpSession session = request.getSession(true);
        	    
        	    session.setAttribute("password", password);
        	    session.setAttribute("email", email);
        	    session.setAttribute("name", name);
        	    session.setAttribute("gender", gender);
        	    session.setAttribute("mobile", mobile);
        	    session.setAttribute("course", course);
        	    session.setAttribute("percentage", percentage);
        	    session.setAttribute("eduqf", eduQf);
        	    o.print("alert('" + name + " You have logged in successfully');");
                o.print("window.location.href = 'first.jsp';");
                o.print("</script>");
                o.print("</body></html>");
        	   // request.getRequestDispatcher("/first.jsp").forward(request, response);
        	    break;
        	}
        	else
        	{
        		o.print("<html><body>");
                o.print("<script>");
                 o.print("alert('Ivalid User');");
                 o.print("window.location.href = 'index.html';");
                 o.print("</script>");
                 o.print("</body></html>");
        	}

        }
    }
}
