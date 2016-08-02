package video;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import global.DispatcherServlet;
import global.Separator;

/**
 * Servlet implementation class VideoController2
 */
@WebServlet("/video.do")
public class VideoController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		HttpSession session = request.getSession();
		switch (Separator.command.getAction()) {
		case "move":
			Separator.command.setDirectory("member");	
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "browse_main":
			System.out.println("browse_main");
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "select_filme":
			Separator.command.setPage(Separator.command.getAction());
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);				
			break;
		case "payment":
			Separator.command.setPage(Separator.command.getAction());
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "regist_complete":
			Separator.command.setPage("main_before");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		case "login":
			Separator.command.setPage("browse_main");
			Separator.command.setView();
			DispatcherServlet.send(request,response,Separator.command);			
			break;
		default:
			break;
		}
		DispatcherServlet.send(request,response,Separator.command);			
	}


}
