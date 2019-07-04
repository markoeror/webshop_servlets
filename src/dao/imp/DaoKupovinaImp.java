package dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import dao.DaoKupovina;
import domen.Stavke;
import domen.User;
import util.DB;

public class DaoKupovinaImp implements DaoKupovina {

	@Override
	public void insertKupovine(ArrayList<Stavke> list, User u) {
		Connection con = DB.getInstanca().getConnection();
		String sqlPorudzbina = "insert into porudzbina(idUser, datum)values(?,?)";
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(sqlPorudzbina);
			
			ps.setInt(1, u.getId());
			ps.setDate(2, Date.valueOf(LocalDateTime.now().toLocalDate()));
			ps.execute();
			String sqlVratiPorudzbinu= "SELECT * FROM porudzbina ORDER BY idPorudzbine DESC LIMIT 1" ;
			ps = con.prepareStatement(sqlVratiPorudzbinu);
			ResultSet rs = ps.executeQuery();
			int idPorudzbine = 0;
			if(rs.next()) {
				idPorudzbine = rs.getInt("idPorudzbine");
			}
			 	 	 
			String sqlInsertPoruzdbina ="insert into stavke (idPorudzbine,idArtikla,kolicina)values (?,?,?)";
			for(Stavke s : list) {
				ps = con.prepareStatement(sqlInsertPoruzdbina);
				ps.setInt(1, idPorudzbine);
				ps.setInt(2,s.getIdArtikla());
				ps.setInt(3, s.getKolicina());
				ps.execute();
			}
			con.commit();
			
		} catch (SQLException e) {
			try {
				e.printStackTrace();
				con.rollback();
				System.out.println("Greska pri upisu u bazu");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			DB.getInstanca().putConnection(con);
		}

	}

}
