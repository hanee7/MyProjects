package text;
import java.io.*; 
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws 
ServletException,IOException{
	
	//taking the req parameters from.jsp file and storing into file
	String uN=req.getParameter("uname");
	String pW=req.getParameter("pword");
	
	//calling the logiDao class ang giving the parameters and also storing the data into userBean
	UserBean ub=new LoginDAO().login(uN, pW);
	
	if(ub==null) {
		//setting attribute / a msg to print
		req.setAttribute("msg","invalied login process...<br>");
		
		//sending that msg by using RequestDispatcher
	    RequestDispatcher rd=req.getRequestDispatcher("Msg.jsp");
	    rd.forward(req,res);
	}
	else {
		//creating a store
	ServletContext sc=req.getServletContext();	
	sc.setAttribute("ubean",ub);
	
    Cookie ck=new Cookie("fname",ub.getfName());
    res.addCookie(ck);
    RequestDispatcher rd=req.getRequestDispatcher("LoginSuccess.jsp");
    rd.forward(req, res);
	}
}
}
