package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoVratiSveArtikle;
import domen.Artikal;
import util.DB;

public class DaoVratiSveArtikleImp implements DaoVratiSveArtikle {

	@Override
	public List<Artikal> listaSvihArtikala() {
		Connection con = DB.getInstanca().getConnection();
		String sql ="select * from artikal ";
		List<Artikal>listaSvihArtikala = new ArrayList<Artikal>();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Artikal a = new Artikal();
				a.setCena(rs.getDouble("cena"));
				a.setNaziv(rs.getString("naziv"));
				a.setNazivSlike(rs.getString("nazivSlike"));
				a.setIdArtikla(rs.getInt("idArtikla"));
				a.setIdKategorije(rs.getInt("idKategorije"));
				listaSvihArtikala.add(a);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DB.getInstanca().putConnection(con);
		}
		
		
		
		return listaSvihArtikala;
	}

}
