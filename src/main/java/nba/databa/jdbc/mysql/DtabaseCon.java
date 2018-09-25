package nba.databa.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DtabaseCon  {

    String url="jdbc:mysql://localhost:3306/?useSSL=false";
    String user="root";
    String password="root";
    Connection conn=DriverManager.getConnection(url, user, password);

    public DtabaseCon() throws SQLException {
    }

    //public void setConn(Connection conn) {
     //   this.conn = conn;
    //}

    public Connection getConn() {
        return conn;
    }
}
