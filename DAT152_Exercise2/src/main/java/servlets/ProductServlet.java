package servlets;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import eao.ProductEAO;
import pakke.Description;
import pakke.Product;

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductEAO eao = new ProductEAO();
	List<Product> choosen = new ArrayList<Product>();
    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
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
			//lager ny cookie til ? sette localen til neste gange
			Cookie localecookie = new Cookie("locale", locale.getLanguage());
			System.out.println(locale.getLanguage());
			//bestemmer hvor lenge denne skal v?re gyldig, m? spesifisere dette for at den skal lagres 
			localecookie.setMaxAge(365 * 24 * 60 * 60); // One year in seconds);
			//sender cookie
			response.addCookie(localecookie);
		}
		List<Product> prod = eao.getAll();
		request.getSession().setAttribute("products", prod);
		response.sendRedirect("product.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pno = request.getParameter("pno");
		if(pno!=null) {
			int pnoint = Integer.parseInt(pno);
			if(!choosen.stream().anyMatch(p->p.getPno()==pnoint)) {
				System.out.println(eao.getProduct(pnoint).getpName());
				choosen.add(eao.getProduct(pnoint));
			}else {
				eao.getProduct(pnoint).setQty();
			}
		}
		int total = choosen.stream().map(p -> p.getQty() * p.getPriceInEuro()).collect(Collectors.summingInt(Integer::intValue));
        request.getSession().setAttribute("choosen", choosen);
        request.getSession().setAttribute("total", total);
		request.getSession().setAttribute("choosen", choosen);
		response.sendRedirect("Cart");
	}

}
