package service.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.UpdateKategorijuDao;
import domen.Kategorija;
import util.DB;

public class UpdateKategorijuDaoImp implements UpdateKategorijuDao {

	@Override
	public void updateKategoriju(Kategorija k) {
		Connection con= DB.getInstanca().getConnection();
		PreparedStatement ps;
		String sqlUpdateKategorju="UPDATE `kategorije` SET naziv = ? WHERE idKategorije = ?";
		
		try {
			ps = con.prepareStatement(sqlUpdateKategorju);
			ps.setString(1, k.getNaziv());
			ps.setInt(2, k.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Greska pri update-u kategorije");
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}

	}

}
