package servlet;

import implement.Imple;
import inter.Inter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Registerr;

/**
 * Servlet implementation class KKregg
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
     String name=request.getParameter("Name");
     System.out.println("Name"+name);
		
     String email=request.getParameter("Email");
     System.out.println("Email"+email);
		
     String number=request.getParameter("Mobile");
     System.out.println("Mobnum"+number);
	
     String pswd=request.getParameter("Password");
     System.out.println("Pass"+pswd);
		
     String cpswd=request.getParameter("Cpassword");
     System.out.println("Cpass"+cpswd);
		
		Registerr kkr=new Registerr();
		
		kkr.setUuname(name);
		kkr.setEmail(email);
		kkr.setPhone(number);
		kkr.setPswd(pswd);
		kkr.setCpswd(cpswd);
		
		Inter kr=new Imple();
		int k=kr.kkrg(kkr);
		if(k==1)
		{
			response.sendRedirect("Login.jsp");
		}
		else
		{
			response.sendRedirect("Error");
		}
	
	
	}
	

}
