package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import db.Database;

public class PlaceCategoryList {

    private ArrayList<PlaceCategory> placeCategoryList = new ArrayList<PlaceCategory>();

    private ArrayList<PlaceCategory> getPlaceCategories() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from place_category order by name");
            while (rs.next()) {
                PlaceCategory place_category = new PlaceCategory();
                place_category.setId(rs.getLong("id"));
                place_category.setName(rs.getString("name"));
                placeCategoryList.add(place_category);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PlaceCategoryList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PlaceCategoryList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return placeCategoryList;
    }

    public ArrayList<PlaceCategory> getPlaceCategoryList() {
        if (!placeCategoryList.isEmpty()) {
            return placeCategoryList;
        } else {
            return getPlaceCategories();
        }
    }
}
