package service.imp;

import java.util.List;

import dao.DaoVratiSveArtikle;
import dao.imp.DaoVratiSveArtikleImp;
import domen.Artikal;
import service.ServiceVratiSveArtikle;

public class ServiceVratiSveArtikleImp implements ServiceVratiSveArtikle {

	@Override
	public List<Artikal> vratiListuArtikala() {
		DaoVratiSveArtikle dvsa= new DaoVratiSveArtikleImp();
		List<Artikal> listaSvihArtikala=dvsa.listaSvihArtikala();
		return listaSvihArtikala;
	}

}
