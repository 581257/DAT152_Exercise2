package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
/**
 * 
 * Tar seg av språkskifte med chooseLanguage.jsp
 *
 */
@WebServlet("/SetLanguage")
public class SetLanguageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 public SetLanguageServlet() {
	        super();
	    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//henter språkparameter fra client
    	String locale = request.getParameter("locale");
    	//sjekker om locale har innhold
    	if (locale !=null) {
    		//setter localen Config.FMT_LOCALE
    		Config.set(request.getSession(), Config.FMT_LOCALE, locale);
    		//legger det inn i en cookie og sender tilake sånn at det er tilgjengelig for clienten 
    		Cookie localeCookie = new Cookie("locale", locale);
    		localeCookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds, må sette lengde
            response.addCookie(localeCookie);
    	}
    	//vet ikke helt hva denne gjør 
    	String referrer = request.getHeader("referer");
        response.sendRedirect(referrer);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
