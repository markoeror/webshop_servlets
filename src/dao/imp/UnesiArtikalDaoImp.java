package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.UnesiArtikalDao;
import domen.Artikal;
import util.DB;


public class UnesiArtikalDaoImp implements UnesiArtikalDao {



	@Override
	public void unesiArtikal(Artikal a) {
		
		Connection con = DB.getInstanca().getConnection();
		String sql = "insert into artikal(naziv, cena, nazivSlike, idKategorije) values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getNaziv());
			ps.setDouble(2, a.getCena());
			ps.setString(3, a.getNazivSlike());
			ps.setInt(4, a.getIdKategorije());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DB.getInstanca().putConnection(con);
		}
	}

}
