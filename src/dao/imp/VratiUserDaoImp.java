package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.VratiUserDao;
import domen.User;
import util.DB;

public class VratiUserDaoImp  implements VratiUserDao{

	@Override
	public User vratiUser(User user) {
		Connection con=DB.getInstanca().getConnection();
		PreparedStatement  ps;
		ResultSet rs;
		User userVrati = new User();	
		String sql= "select * from user where username = ? and password = ?";
		
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs= ps.executeQuery();
			
			if(rs.next()) {
				userVrati.setId(rs.getInt("id"));
				userVrati.setUsername(rs.getString("username"));
				userVrati.setPassword(rs.getString("password"));
				userVrati.setStatus(rs.getInt("status"));
				System.out.println("User "+rs.getString("username")+" vracen.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}
		
		return userVrati;
	}

}
