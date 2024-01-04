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


@WebServlet("/Blood1")
public class Blood1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private PrintWriter out;
       
    
    public Blood1() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("cc");
		
		String num=request.getParameter("ss");
		
	    String blg=request.getParameter("group");
	    
	    String loc=request.getParameter("L");
	    
	    
        try {
        	
        
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Atchaya@15");
        	PreparedStatement st=con.prepareStatement("insert into bo1(name,num,blg,loc) values(?,?,?,?)");
        	                  st.setString(1, name);
        	                  st.setString(2, num);
        	                  st.setString(3, blg);
        	                  st.setString(4, loc);
        	                  
        	                  int res=st.executeUpdate();
        	                  
        	                  if(res>0)
        	                  {
        	                	  if(validate1(name))
        	                	  {
        	                		  if(validate2(num))
        	                		  {
        	                			  if(validate3(blg))
        	                			  {
        	                				  if(validate4(loc))
        	                				  {
        	                	  out.print("Data inserted successfully");
        	                		 }
        	                	    } 
        	                	  }
        	                    }
                              }
	
	                         else
        	                  {
        	                	  
								out.print("Data is invalid inserted ");
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


	
	    public boolean validate1(String data)
	    {
	    	return data.matches("[a-zA-Z]+$");
	    }
	    public boolean validate2(String number)

	    {
	    	String pattern="^(\\+\\d{1,2}[-]?)?\\(?\\d{3}\\)?[-]?\\d{3}[-]?\\d{4}$";
	    	
	    	return number.matches(pattern);
	    }
	    public boolean validate3(String group)
	    {
	    	
	    	String[] groups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
	    	
	        
			
			for (String validGroup : groups)
			{
	            if (validGroup.equals(group.toUpperCase())) 
	            {
	                return true;
	            }
			}
			return false;
	    }
	       
	    public boolean validate4(String location)
	    {
	    	return location.matches("chennai");
	    }



        	                  


		
	    
		
		
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
