/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author Jan
 */
public class DatabaseConnection {
    
    public DatabaseConnection(){
        
    try{
         getConnection();
    }
    catch(Exception ex){
    }
    
    }
    
    //TODO
    // Set correct URL
    private Connection conn;
    private Statement stmt;
    public void getConnection() throws SQLException{
           OracleDataSource ds;
           ds = new OracleDataSource();
           ds.setURL("jdbc:oracle:thin:@localhost:1521");
           conn=ds.getConnection("soademo", "soademo");
           stmt = conn.createStatement();
        
    }
    
    public boolean runQuery(String query)throws SQLException{
        if(stmt.executeUpdate(query) == 1){
            return true;
        }else{
            return false;
        }
    }
    
    public ResultSet runGetDataQuery(String query)throws SQLException{  
                 
       ResultSet rset = stmt.executeQuery(query);      
       return rset;   
    }
    
    public boolean insertQuery(String Query){

        try {
            System.out.println(Query);
            return stmt.execute(Query);
        } catch (SQLException e) {
            return false;
        }
    }
    
}