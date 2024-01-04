package info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bloodbk")
public class Bloodbk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Bloodbk() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		

        PrintWriter out=response.getWriter();
		
		String name=request.getParameter("A");
		String pass=request.getParameter("B");
		
		 try
	        {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Atchaya@15");
	        	out.println("<table border='1'>");
	        	String num = null;
				String blg = null;
				PreparedStatement st=con.prepareStatement("<tr><td>" +name + "</td><td>" + num + "</td><td>" + blg + "</td></tr>");
	                              st.setString(1, name);
	                              st.setString(2, num);
	                              st.setString(3, blg);
	        
	        }
	        catch(ClassNotFoundException | SQLException e)
		    {
	        e.printStackTrace()	;
		    }
	

         out.println("</table>");
	        	
	
	}
}

	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

*/
