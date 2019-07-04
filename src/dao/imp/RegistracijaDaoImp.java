package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.RegistacijaDao;
import domen.User;
import util.DB;


public class RegistracijaDaoImp implements RegistacijaDao {

	@Override
	public void insertUser(User user) {
		Connection con = DB.getInstanca().getConnection();
		PreparedStatement ps;
		try {
			ps= con.prepareStatement(insertUser);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getStatus());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);  // ovde vracamo konekciju u con pool
		}
	}

}
