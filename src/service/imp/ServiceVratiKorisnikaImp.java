package service.imp;

import dao.VratiUserDao;
import dao.imp.VratiUserDaoImp;
import domen.User;
import service.ServiceVratiKorisnika;

public class ServiceVratiKorisnikaImp  implements ServiceVratiKorisnika{

	@Override
	public User getVrati(User user) {
	VratiUserDao dk= new VratiUserDaoImp();
	return dk.vratiUser(user);
	}



}
