package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegistacijaDao;
import domen.User;
import domen.constants;
import service.ServiceRegistracija;
import service.ServiceVratiKorisnika;
import service.imp.ServiceRegistracijaImp;
import service.imp.ServiceVratiKorisnikaImp;

/**
 * Servlet implementation class PrviServlet
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vrednost= request.getParameter("submit");
		if(vrednost.equalsIgnoreCase("login")) {
			String user= request.getParameter("user");
			String pass= request.getParameter("pass");;
			// ovaj naredni deo je u vezi dovlacenja user-a iz baze
			User us= new User();
			us.setUsername(user);
			us.setPassword(pass);
			ServiceVratiKorisnika sv=new  ServiceVratiKorisnikaImp();
			User podatakIzBaze= sv.getVrati(us);
			 if(podatakIzBaze.getId()==0){
					response.sendRedirect("index.jsp");/*
					request.setAttribute("msg", "Los username i password");
					request.getRequestDispatcher("index.jsp").forward(request, response);*/
				}
			 else if(podatakIzBaze.getId()!=0  && podatakIzBaze.getStatus()==0) {
				System.out.println("Trazi se admin (prvi uslov)");
				if( podatakIzBaze.getUsername().equalsIgnoreCase(user) && podatakIzBaze.getPassword().equals(pass)) {
					System.out.println("Trazi se admin (drugi uslov)");
					String userBaza=podatakIzBaze.getUsername();
					String passBaza=podatakIzBaze.getPassword();
					String userZahtev=user;
					String passZahtev=pass;
					System.out.println("Zahtev sa usernameom: "+user+" i sifrom: "+pass);
					//SESIJE! sluze da kada se krecemo izmedju stranica da se zadrzavaju podaci bez njihovog gubljenja
					//Objekti sesije se cuvaju na serveru
					//request.getSession  na serveru se kreira objekat session			
					HttpSession sesija = request.getSession();
					sesija.setAttribute("UlogovanKorisnik", podatakIzBaze);
					request.getRequestDispatcher("kategorije.jsp").forward(request, response);	;		
			}				
			}
			else if(podatakIzBaze.getId()!=0 && podatakIzBaze.getStatus()==1) {
				System.out.println("Trazi se korisnik");
				if(podatakIzBaze.getUsername().equalsIgnoreCase(user) && podatakIzBaze.getPassword().equals(pass))  {
					System.out.println("Trazi se korisnik1");
					String userBaza=podatakIzBaze.getUsername();
					String passBaza=podatakIzBaze.getPassword();
					String userZahtev=user;
					String passZahtev=pass;
					System.out.println("zahtev sa usernameom "+user+" i sifrom "+pass);
					HttpSession sesija = request.getSession();
					sesija.setAttribute("UlogovanKorisnik", podatakIzBaze);
					request.getRequestDispatcher("webshop.jsp").forward(request, response);
			}
			}
			
			
			//REGISTRACIJA
		}else {
			String user= request.getParameter("user1");
			String ime= request.getParameter("ime");
			String prezime= request.getParameter("prezime");
			String pass1= request.getParameter("pass1");
			String pass2= request.getParameter("pass2");
			if(pass1.equals(pass2)){	// kreiramo objekat nad userom
				User u= new User();
				u.setIme(ime);
				u.setPrezime(prezime);
				u.setStatus(constants.USER.getId());
				u.setUsername(user);
				u.setPassword(pass1);
				ServiceRegistracija rs= new ServiceRegistracijaImp();
				rs.insertUser(u);
				request.setAttribute("msg", "Uspesno ste se registrovali");
				request.getRequestDispatcher("index.jsp").forward(request, response);
							
			}else {
				response.sendRedirect("index.jsp");
			}
		}
	}

}
