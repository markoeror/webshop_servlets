package service.imp;

import dao.DeleteKategorijuDao;
import dao.imp.DaoDeleteKategorijuImp;
import service.ServiceDeleteKategoriju;

public class ServiceDeleteKategorijuImp implements ServiceDeleteKategoriju {

	@Override
	public void deleteKategoriju(int id) {
		DeleteKategorijuDao ddk= new DaoDeleteKategorijuImp();
		ddk.deleteKategoriju(id);
		

	}

}
