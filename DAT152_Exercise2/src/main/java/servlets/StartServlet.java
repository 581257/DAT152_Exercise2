package servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

@WebServlet("/index.html")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//pick ut locale from cookie, or http header if there is no cookies
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			//hvorfor så mange cookies?? 
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("locale")) {
					//setter localen fra cookien
					Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
				}
			}
		}else { //no cookies
			//henter locale fra http request header 
			Locale locale = request.getLocale();
			//setter localen
			Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());
			//lager ny cookie til å sette localen til neste gange
			Cookie localecookie = new Cookie("locale", locale.getLanguage());
			System.out.println(locale.getLanguage());
			//bestemmer hvor lenge denne skal være gyldig, må spesifisere dette for at den skal lagres 
			localecookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds);
			//sender cookie
			response.addCookie(localecookie);
		}
		
		response.sendRedirect("index.jsp");
	}

	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
