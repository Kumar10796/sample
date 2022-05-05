package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class Voter_id
 */
@WebServlet("/Voter_id")
public class Voter_id extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Voter_id() {
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
		
		         
		    	 response.setContentType("text/html");
		          PrintWriter pw = response.getWriter();
		          
		          String name = request.getParameter("name");
		          int age = Integer.parseInt(request.getParameter("age"));
		          if (age>=18)
		          {
		               pw.println("<font color='green' size='12' align=center background-color=black>"+name+" You are eligible to vote</font>");
		          }
		          else
		               pw.println("<font color='red' size='12' align=center background-color=black	>"+name+" You are not eligible to vote</font>");
		         
		          pw.println("<br><br><a href= 'Index.jsp'>Home</a>");
		          
		          pw.close();
		     }
		}

