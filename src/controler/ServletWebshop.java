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

/**
 * Servlet implementation class ServletWebshop
 */
@WebServlet("/ServletWebshop")
public class ServletWebshop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletWebshop() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
		
			/* * OVDE U SESIJU UBACUJEMO ARRAYLISTU STAVKI, I SA SVAKIM LOGOVANJEM KAKO SE
			 * SALJE SESIJA TAKO CE SE PROSLEDJIVATI I LISTA STAVKI TJ KORPA */
			
			HttpSession sesija = request.getSession();
			String id = request.getParameter("idartikla");	
			String kolicina = request.getParameter("kolicina");
			int vrednost = Integer.parseInt(kolicina);
			System.out.println(vrednost);
			String cena = request.getParameter("cenaA");
			double cena1=Double.parseDouble(cena);
			System.out.println(cena);
			if(vrednost >= 1) {
			
			Stavke stavke = new Stavke();
			stavke.setIdArtikla(Integer.parseInt(id));
			stavke.setKolicina(vrednost);
			
			ArrayList<Stavke> listaStavki = (ArrayList<Stavke>) sesija.getAttribute("listaStavki");
			ArrayList<Double> listaCena=(ArrayList<Double>) sesija.getAttribute("listaCena");
			Double korpa= (Double) sesija.getAttribute("korpa");
			if (listaStavki == null) {
				listaStavki = new ArrayList<Stavke>();
			}
			if (listaCena == null) {
				listaCena = new ArrayList<Double>();
			}
				listaStavki.add(stavke);
				listaCena.add((double) cena1);
			if(korpa == null) {
				korpa=(double) 0.0;
			}
				korpa+=cena1*vrednost;
				System.out.println(korpa);
				sesija.setAttribute("listaStavki", listaStavki);
				 sesija.setAttribute("korpa", korpa); 
				 sesija.setAttribute("listaCena", listaCena);
				response.sendRedirect("webshop.jsp");
			} else {
				response.sendRedirect("webshop.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("webshop.jsp");
		}

	}
}
