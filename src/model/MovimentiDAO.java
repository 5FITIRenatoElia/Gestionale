package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class MovimentiDAO {
	private static Connection con = null;
	private static ResultSet rs = null;

	public static String StampMovimenti() {
		String json = "[]";
			final String q =
				"SELECT *" +
				"FROM " +
				"movimenti;"; 

			List<Movimenti> movimentiList = new ArrayList<Movimenti>();

			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/iti_elia_5f_as_2020_21_contabilita",
						"root", ""
						);
				rs = con.createStatement().executeQuery(q);
				for(; rs.next(); ) {
					movimentiList.add(
						new Movimenti(
							rs.getInt("idMovimento"),
							rs.getDate("dataOra"),
							rs.getString("descrizione"),
							rs.getDouble("importo"),
							rs.getInt("codCausale"),
							rs.getInt("codAzienda")
						)
					);
				}
				rs.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			json = new Gson().toJson(movimentiList);
		

		return json;
	}
}