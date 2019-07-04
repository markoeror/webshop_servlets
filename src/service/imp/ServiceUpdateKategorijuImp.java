package service.imp;

import dao.UpdateKategorijuDao;
import domen.Kategorija;
import service.ServiceUpdateKategoriju;

public class ServiceUpdateKategorijuImp implements ServiceUpdateKategoriju {

	@Override
	public void updateKategoriju(Kategorija k) {
		UpdateKategorijuDao ukd= new UpdateKategorijuDaoImp();
		ukd.updateKategoriju(k);
		

	}

}
