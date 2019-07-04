package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DeleteKategorijuDao;
import util.DB;

public class DaoDeleteKategorijuImp implements DeleteKategorijuDao {

	@Override
	public void deleteKategoriju(int id) {
		Connection con= DB.getInstanca().getInstanca().getConnection();
		String sqlDeleteKategoriju= "DELETE FROM kategorije WHERE idKategorije = ?";
		PreparedStatement ps;
		
		try {
			ps=con.prepareStatement(sqlDeleteKategoriju);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Greska pri brisanju kategorije");
			e.printStackTrace();
		}
		finally {
			DB.getInstanca().putConnection(con);
		}

	}

}
