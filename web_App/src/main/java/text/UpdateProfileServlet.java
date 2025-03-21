package text;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet
{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
	Cookie ck[]=req.getCookies();
	if(ck==null) {
		req.setAttribute("msg","Session expire...<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		
	}else {
		String fN=ck[0].getValue();
		req.setAttribute("fname", fN);
		ServletContext sc=req.getServletContext();
		UserBean ub=(UserBean)sc.getAttribute("ubean");
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k=new UpdateProfileDAO().update(ub);
		if(k>0) {
			req.setAttribute("msg", "Profile Updated successfully...<br>");
		    req.getRequestDispatcher("UpdateProfile.jsp").forward(req,res);
		}
	}
}
}