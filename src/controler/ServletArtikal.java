package controler;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import domen.Artikal;
import service.ServiceArtikal;
import service.imp.ServiceArtikalImp;


/**
 * Servlet implementation class ServletArtikal
 */
@WebServlet("/ServletArtikal")
@MultipartConfig(maxFileSize = 1024*1024*10)//multi part konfig je anotacija koja sluzi da 
//pokupite sliek i da radite sa njima i ogranicavate velicinu
public class ServletArtikal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletArtikal() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String naziv=request.getParameter("naziv");
		String cena=request.getParameter("cena");
		Part part = request.getPart("file"); /* JAVA KLASA ZA RAD SA SLIKAMA */
		String imeFile = GetFile(part);
		int a=imeFile.lastIndexOf("\\");
		imeFile= imeFile.substring(a+1);
		
		String uploadFile="C:\\Users\\Marko Eror\\eclipse-workspace-JEE\\CetvrtiProjekatSesije\\WebContent\\slike\\";
		File f= new File(uploadFile);
		if(!f.exists()) {
			f.mkdir();
		}		
		String ime= uploadFile+imeFile;
		part.write(ime);
		System.out.println("snimljena slika "+ imeFile);
		
		Artikal artikal= new Artikal();
		artikal.setNaziv(naziv);
		artikal.setCena(Double.parseDouble(cena));
		artikal.setIdKategorije(Integer.parseInt(id));
		artikal.setNazivSlike(imeFile);
		ServiceArtikal sa= new ServiceArtikalImp();
		sa.unesiArtikal(artikal);
		response.sendRedirect("product.jsp");
		
		
		
	}
	

	/* Metoda za vracanje naziva slike iz putanje slike koju ubacujemo za artikal u JAVI */
	private String GetFile(Part part) {
		for(String content :  part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=")+2, content.length()-1);
			}		
		}
		return null;
	}

}
