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


@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public First() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        PrintWriter out=response.getWriter();
		
		String name=request.getParameter("A");
		String pass=request.getParameter("B");
		
		  try
	        {
	        	Class.forName("com.mysql.jdbc.Driver");
	        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Atchaya@15");
	        	PreparedStatement st=con.prepareStatement("insert into blo(name,pass) values(?,?)");
	        	                  st.setString(1, name);
	        	                  st.setString(2, pass);
	        	                  
	        	                  int res=st.executeUpdate();
	        	                  
	        	                  if(res>0)
	        	                  {
	        	                	  out.print("Data inserted successfully");
	        	                	  
	        	                  }
	        	                  else
	        	                  {
	        	                	  out.print("Data not inserted ");
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
