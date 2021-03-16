package Repository.JDBC;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.*;
import java.sql.DriverManager;
public class MysqlDataSource  {
    private Connection cnx;
    private ResultSet res;
    private PreparedStatement pstm;
    private int ok;

    private void getConnection(){
        String url="jdbc:mysql://localhost:3306/WARIJEE";
        String user="symfony";
        String password="passer";
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            cnx= DriverManager.getConnection(url,user,password);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void initPrepare(String sql){
        try {
            getConnection();
            pstm=cnx.prepareStatement(sql);
        }catch (Exception ex){
            ex.printStackTrace();

        }

    }
    public ResultSet executeSelect(){
        try {
            res=pstm.executeQuery();
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return res;
    }
    public  int executeMaj(){
        try {
            ok=pstm.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
    public void closeConnection(){
        try {
            if(cnx!=null)
                cnx.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }
}
    public PreparedStatement getPstm() {
        return pstm;
    }
}
