package service.imp;

import dao.UnesiArtikalDao;
import dao.imp.UnesiArtikalDaoImp;
import domen.Artikal;
import service.ServiceArtikal;


public class ServiceArtikalImp implements ServiceArtikal {



	@Override
	public void unesiArtikal(Artikal a) {
		UnesiArtikalDao uad= new UnesiArtikalDaoImp();
		uad.unesiArtikal(a);
		
	}

}
