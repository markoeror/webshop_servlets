package service.imp;

import dao.RegistacijaDao;
import dao.imp.RegistracijaDaoImp;
import domen.User;
import service.RegistracijaService;

public class RegistracijaServiceImp implements RegistracijaService{ 

	@Override
	public void insertUser(User user) {
		RegistacijaDao rd= new RegistracijaDaoImp();
		rd.insertUser(user);
		
	}

}
