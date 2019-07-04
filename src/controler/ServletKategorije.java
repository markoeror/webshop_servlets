package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domen.Kategorija;
import service.ServiceDeleteKategoriju;
import service.ServiceInsertKategoriju;
import service.ServiceUpdateKategoriju;
import service.imp.ServiceDeleteKategorijuImp;
import service.imp.ServiceInsertKategorijuImp;
import service.imp.ServiceUpdateKategorijuImp;

/**
 * Servlet implementation class ServletKategorije
 */
@WebServlet({ "/ServletKategorija", "/akcija/*" })
public class ServletKategorije extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletKategorije() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String putanja= request.getPathInfo();
		
		//BRISANJE KATEGORIJE
		if(putanja.equals("/deleteKategorije")){
			String id=request.getParameter("id");
			System.out.println("Zahtev za brisanje kategorije sa id-em: "+id);
			ServiceDeleteKategoriju sdk= new ServiceDeleteKategorijuImp();
			sdk.deleteKategoriju(Integer.parseInt(id));
			System.out.println("Uspesno brisanje kategorije"+id);
			response.sendRedirect("/CetvrtiProjekatSesije/kategorije.jsp");		
		}
		// UPDATE KATEGORIJE PRELAZAK NA STRANU UPDATEKATEGORIJE/jsp
		if(putanja.equals("/updateKategorije")) {
			String id = request.getParameter("id");
			String naziv = request.getParameter("naziv");
			request.setAttribute("id", id);
			request.setAttribute("naziv", naziv);
			request.getRequestDispatcher("/updateKategorije.jsp").forward(request, response);
			
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String putanja = request.getPathInfo();
			//UNOS KATEGORIJE
		if (putanja.equals("/unesiKategoriju")) {
			String naziv = request.getParameter("txt_kategorija");
			Kategorija kategorija = new Kategorija();
			kategorija.setNaziv(naziv);
			ServiceInsertKategoriju sik = new ServiceInsertKategorijuImp();
			sik.insertKategoriju(kategorija);
			request.setAttribute("msg", "Uspesno ste uneli kategoriju");
			response.sendRedirect("/CetvrtiProjekatSesije/kategorije.jsp");
			//request.getRequestDispatcher("/kategorije.jsp").forward(request, response);
		}
		// UPDATE KATEGORIJE NA STRANI UPDATEKATEGORIJE.jsp I VRACANJE NA STRANU KATEGORIJE.jsp
		else if(putanja.equals("/updateKategorije")) {
			String id = request.getParameter("id");
			String naziv= request.getParameter("naziv");
			Kategorija k= new Kategorija();
			k.setId(Integer.parseInt(id));
			k.setNaziv(naziv);
			System.out.println("Zahtev za update kategorije sa id-em: "+id);
			ServiceUpdateKategoriju suk= new ServiceUpdateKategorijuImp();
			suk.updateKategoriju(k);
			System.out.println("Uspesan update kategorije: "+id+" promenjen naziv u: "+naziv);
			response.sendRedirect("/CetvrtiProjekatSesije/kategorije.jsp");
		
		}
	}

	
	
	
	
	/*
	 * // KREIRANJE KORISNIKA String vrednost= request.getParameter("submit");
	 * if(vrednost.equalsIgnoreCase("Unesi kategoriju")) { String naziv=
	 * request.getParameter("kategorija"); Kategorija kategorija= new Kategorija();
	 * kategorija.setNaziv(naziv); ServiceInsertKategoriju sik= new
	 * ServiceInsertKategorijuImp(); sik.insertKategoriju(kategorija);
	 * request.setAttribute("msg", "Uspesno ste uneli kategoriju");
	 * request.getRequestDispatcher("kategorije.jsp").forward(request, response); }
	 * 
	 * else if(vrednost.equalsIgnoreCase("Obrisi kategoriju")) {
	 * 
	 * }
	 */

}
