package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class CausaliDAO {
	private static Connection con = null;
	private static ResultSet rs = null;

	public static String StampCausali() {
		String json = "[]";
			final String q =
				"SELECT *" +
				"FROM " +
				"causali;"; 

			List<Causali> causaliList = new ArrayList<Causali>();

			try {
				con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/iti_elia_5f_as_2020_21_contabilita",
						"root", ""
						);
				rs = con.createStatement().executeQuery(q);
				for(; rs.next(); ) {
					causaliList.add(
						new Causali(
							rs.getInt("idCausale"),
							rs.getString("nome"),
							rs.getString("dareAvere")
						)
					);
				}
				rs.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			json = new Gson().toJson(causaliList);
		

		return json;
	}
}
