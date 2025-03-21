package text;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest req,HttpServletResponse res)throws 
  ServletException,IOException{
	  Cookie ck[]=req.getCookies();
	  if(ck==null) {
		  req.setAttribute("msg","Session Expired...");
		  req.getRequestDispatcher("Msg.jsp").forward(req, res);
	  }else {
		  String fN=ck[0].getValue();
		  req.setAttribute("fname", fN);
		  req.getRequestDispatcher("ViewProfile.jsp").forward(req, res);
	  }
  }
}
