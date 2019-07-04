package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.VratiKategorijeDao;
import domen.Kategorija;
import util.DB;

public class VratiKategorijeDaoImp implements VratiKategorijeDao {

	@Override
	public List<Kategorija> vratiKategorije() {
		List<Kategorija> listaKategorija= new ArrayList<Kategorija>();
		Connection con= DB.getInstanca().getConnection();
		PreparedStatement ps;
		ResultSet rs;
		String sql="select * from kategorije";
		List<Kategorija>list = new ArrayList<Kategorija>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Kategorija k = new Kategorija();
				k.setId(rs.getInt("idKategorije"));
				k.setNaziv(rs.getString("naziv"));
				list.add(k);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}
	
		return list;
	}

}
