package text;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException{
	Cookie ck[]=req.getCookies();
	if(ck==null){
		req.setAttribute("msg","seccsion expired..<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req,res);
	}else {
		String fN=ck[0].getValue();
		req.setAttribute("fname",fN);
		req.getRequestDispatcher("EditProfile.jsp").forward(req, res);
	}
}
}
