package service.imp;

import java.util.ArrayList;

import dao.DaoKupovina;
import dao.imp.DaoKupovinaImp;
import domen.Stavke;
import domen.User;
import service.ServiceKupovina;

public class ServiceKupovinaImpl implements ServiceKupovina {

	@Override
	public void insertKupovine(ArrayList<Stavke> lista, User user) {
		DaoKupovina dk= new DaoKupovinaImp();
		dk.insertKupovine(lista, user);
		
	}

}
