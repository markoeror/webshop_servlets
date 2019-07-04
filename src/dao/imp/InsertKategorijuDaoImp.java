package dao.imp;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.InsertKategorijuDao;
import domen.Kategorija;
import util.DB;

public class InsertKategorijuDaoImp implements InsertKategorijuDao {

	@Override
	public void insertkategoriju(Kategorija kategorija) {
		Connection con= DB.getInstanca().getConnection();
		PreparedStatement ps;
		String sqlInsertKategoriju="INSERT INTO `kategorije` (naziv) values (?)";
		try {
			ps=con.prepareStatement(sqlInsertKategoriju);
			ps.setString(1, kategorija.getNaziv());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}
		

	}

}
