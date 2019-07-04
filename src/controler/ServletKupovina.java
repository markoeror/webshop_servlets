package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domen.Stavke;
import domen.User;
import service.ServiceKupovina;
import service.imp.ServiceKupovinaImpl;

/**
 * Servlet implementation class ServletKupovina
 */
@WebServlet("/ServletKupovina")
public class ServletKupovina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletKupovina() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesija=request.getSession();
		User user=(User) sesija.getAttribute("UlogovanKorisnik");
		if(user!=null) {
    		ArrayList<Stavke>lista = (ArrayList<Stavke>)sesija.getAttribute("listaStavki");
    		ServiceKupovina sk = new ServiceKupovinaImpl();
    		sk.insertKupovine(lista,user);
    		Double korpa=(Double)sesija.getAttribute("korpa");
    		korpa=0.0;
    		sesija.setAttribute("korpa", korpa);
    		response.sendRedirect("webshop.jsp");
    		System.out.println("porudzbina uspesno kreirana");
		}else {
			response.sendRedirect("kontakt.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
