package servlets;

import java.sql.*;

public class DBInterface {
    private final String user = "root";
    private final String password = "mrair2636";
    private final String url = "jdbc:mysql://localhost:3306/DeathValleyDB";
    private Statement statement;
    private Connection connection;
    private ResultSet resultSet;
    public DBInterface() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load class.");
            e.printStackTrace();
        }

        connection = DriverManager.getConnection(url, user, password);
        this.statement = connection.createStatement();
    }
    public String requestRichest() throws SQLException {
        resultSet = statement.executeQuery("select a.userid, sum(a.account) account, u.name, u.surename " +
                "from user u inner join account a on u.userid = a.userid group by u.userid order by account desc limit 1");
        String resultStr = " ";
        while(resultSet.next()){
            resultStr = resultSet.getString("name")
                    + " " + resultSet.getString("surename");
        }
        return resultStr;
    }
    public String requestSum() throws SQLException {
        resultSet = statement.executeQuery("select sum(account) account from account");
        String resultStr = " ";
        while(resultSet.next()){
            resultStr = resultSet.getString("account");
        }
        return resultStr;
    }
    public void insert(String sql) throws SQLException {
        statement.executeQuery(sql);
    }
    public void close() throws SQLException {
        connection.close();
    }
}
