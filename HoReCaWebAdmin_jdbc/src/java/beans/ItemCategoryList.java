package beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import db.Database;

public class ItemCategoryList {

    private ArrayList<ItemCategory> itemCategoryList = new ArrayList<ItemCategory>();

    private ArrayList<ItemCategory> getItemCategories() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from item_category order by name");
            while (rs.next()) {
                ItemCategory item_category = new ItemCategory();
                item_category.setId(rs.getLong("id"));
                item_category.setName(rs.getString("name"));
                itemCategoryList.add(item_category);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemCategoryList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ItemCategoryList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return itemCategoryList;
    }

    public ArrayList<ItemCategory> getItemCategoryList() {
        if (!itemCategoryList.isEmpty()) {
            return itemCategoryList;
        } else {
            return getItemCategories();
        }
    }
}
