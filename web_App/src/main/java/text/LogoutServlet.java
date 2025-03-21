package text;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
protected void doGet(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
	
	Cookie ck[]=req.getCookies();
	
	if(ck==null) {
		req.setAttribute("msg","Session expire...<br>");
	}else {
		
		ServletContext sc=req.getServletContext();
        sc.removeAttribute("ubean");
        
        ck[0].setMaxAge(0);
        
        res.addCookie(ck[0]);
        
        req.setAttribute("msg","User Loggedout Successfully...<br>");
	}
	req.getRequestDispatcher("Msg.jsp").forward(req,res);
}
}