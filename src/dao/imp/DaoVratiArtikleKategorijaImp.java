package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoVratiArtikleKategorija;
import domen.Artikal;
import util.DB;


public class DaoVratiArtikleKategorijaImp implements DaoVratiArtikleKategorija {

	@Override
	public List<Artikal> listaArtikalaKategorije(int id) {
		
		Connection con = DB.getInstanca().getConnection();
		String sql ="select * from artikal where idKategorije = ?";
		List<Artikal>list = new ArrayList<Artikal>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Artikal a = new Artikal();
				a.setCena(rs.getDouble("cena"));
				a.setNaziv(rs.getString("naziv"));
				a.setNazivSlike(rs.getString("nazivSlike"));
				a.setIdArtikla(rs.getInt("idArtikla"));
				a.setIdKategorije(rs.getInt("idKategorije"));
				list.add(a);
				
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
