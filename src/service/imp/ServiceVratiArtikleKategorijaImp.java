package service.imp;

import java.util.List;

import dao.DaoVratiArtikleKategorija;
import dao.imp.DaoVratiArtikleKategorijaImp;
import domen.Artikal;
import service.ServiceVratiArtikleKategorija;

public class ServiceVratiArtikleKategorijaImp implements ServiceVratiArtikleKategorija {

	@Override
	public List<Artikal> vratiListuArtikala(int id) {
		DaoVratiArtikleKategorija vlk= new DaoVratiArtikleKategorijaImp();
		List<Artikal>listaArtikalaKategorije= vlk.listaArtikalaKategorije(id);
		return listaArtikalaKategorije;
	}

}
