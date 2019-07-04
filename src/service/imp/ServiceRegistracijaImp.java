package service.imp;

import dao.RegistacijaDao;
import dao.imp.RegistracijaDaoImp;
import domen.User;
import service.ServiceRegistracija;

public class ServiceRegistracijaImp implements ServiceRegistracija{ 

	@Override
	public void insertUser(User user) {
		RegistacijaDao rd= new RegistracijaDaoImp();
		rd.insertUser(user);
		
	}

}
