package servlet;

import implement.Imple;
import inter.Inter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Registerr;

/**
 * Servlet implementation class KKlog
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		String email1=request.getParameter("email");		
		System.out.println("Email:"+email1);
		
		String pswd=request.getParameter("password");
		System.out.println("Pass"+pswd);
		
		Registerr kkl=new Registerr();
		kkl.setEmail(email1);
		kkl.setPswd(pswd);
		
		Inter kl=new Imple();
		boolean lk=kl.kklg(kkl);
		if(lk==true)
		{
			response.sendRedirect("Success");
		}
		else
		{
			response.sendRedirect("Error");
		}
		
		
		
	}

}
