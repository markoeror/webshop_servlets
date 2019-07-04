package controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domen.Artikal;
import service.ServiceVratiArtikleKategorija;
import service.imp.ServiceVratiArtikleKategorijaImp;



/**
 * Servlet implementation class ServletKategorijePrikaz
 */
@WebServlet("/ServletKategorijePrikaz")
public class ServletKategorijePrikaz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletKategorijePrikaz() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		ServiceVratiArtikleKategorija svak= new ServiceVratiArtikleKategorijaImp();
		List<Artikal> list= svak.vratiListuArtikala(id);
		request.setAttribute("list", list);
		//response.sendRedirect("productKategorija.jsp");
		request.getRequestDispatcher("/productKategorija.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
