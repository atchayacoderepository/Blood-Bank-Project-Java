package info;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Blood2")
public class Blood2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Blood2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		
        String blg=request.getParameter("group1");
	    
	    String loc=request.getParameter("ch");
	    
	    
	    
	    try {
        	
	        
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Atchaya@15");
        	
        	PreparedStatement st=con.prepareStatement("select * from bo1 where loc=? and blg=?");
        	
        	                   st.setString(1, loc);
        	                   st.setString(2, blg);
        	                   ResultSet rs = st.executeQuery();
        	                   if (rs.next()) 
        	                   {
        	                	   out.print("Blood group available");
        	                   }
        	                   else
        	                   {
        	                   
        	                	   out.print("Not available this type of blood group");
        	                   }
        	                   
	    }
	    catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
}


	    
	    

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
