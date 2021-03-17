package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
public class AziendeDAO {
	private  Connection con = null;
	private  ResultSet rs = null;
	
    protected void connect() throws SQLException {
        if (con == null || con.isClosed()) { 
            
            con = DriverManager.getConnection(
            		"jdbc:mariadb://localhost:3306/iti_elia_5f_as_2020_21_contabilita",
					"root", ""
					);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public boolean insertAziende(Aziende aziende) throws SQLException {
        String sql = "INSERT INTO aziende (anagrafica, userId,passwd ) VALUES ( ?, ?, ?)";
        connect();
         
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(2, aziende.getAnagrafica());
        statement.setString(3, aziende.getUserId());
        statement.setString(4, aziende.getPasswd());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    
    
    
    
	public String StampAziende() {
		String json = "[]";
			final String q =
				"SELECT *" +
				"FROM " +
				"aziende;"; 

			List<Aziende> aziendeList = new ArrayList<Aziende>();

			try {
				connect();
				rs = con.createStatement().executeQuery(q);
				for(; rs.next(); ) {
					aziendeList.add(
						new Aziende(
							rs.getInt("idAzienda"),
							rs.getString("anagrafica"),
							rs.getString("userId"),
							rs.getString("passwd")
						)
					);
				}
				rs.close();
				disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
			json = new Gson().toJson(aziendeList);
		

		return json;
	}
}