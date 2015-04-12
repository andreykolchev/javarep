/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.naming.InitialContext;

/**
 *
 * @author user
 */
public class TestJDBC {
    
    public void check(){
        try {
            InitialContext is = new InitialContext();
            DataSource ds = (DataSource) is.lookup("jdbc/horecaDatasource");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from login");
            while (rs.next()) {
                System.out.println(rs.getString("username"));}
        } catch (Exception e) {
        }
    }
    
}
