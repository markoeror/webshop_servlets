package service.imp;

import dao.InsertKategorijuDao;
import dao.imp.InsertKategorijuDaoImp;
import domen.Kategorija;
import service.ServiceInsertKategoriju;

public class ServiceInsertKategorijuImp implements ServiceInsertKategoriju {

	@Override
	public void insertKategoriju(Kategorija kategorija) {
		InsertKategorijuDao ikd= new InsertKategorijuDaoImp();
		ikd.insertkategoriju(kategorija);
	}

}
