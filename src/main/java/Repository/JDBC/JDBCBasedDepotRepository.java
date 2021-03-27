package Repository.JDBC;

import Repository.DepotRepository;
import domain.Compte;
import domain.Depot;
import domain.Partenaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JDBCBasedDepotRepository  implements DepotRepository{
    private final DataSource dataSource;
    public JDBCBasedDepotRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Depot> getAll() {
        List<Depot> depots = new ArrayList<Depot>();
        String query="SELECT * FROM Depot";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                Depot e=new Depot();
                e.setIdD(res.getInt(1));
                e.setMontant(res.getInt(2));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                e.setDateDepot(simpleDateFormat.parse(res.getString(3)));
                JDBCBasedCompteRepository jdbcBasedCompteRepository=new JDBCBasedCompteRepository(dataSource);
                Compte compte =jdbcBasedCompteRepository.getById(res.getInt(4));
                e.setCompte(compte);
                depots.add(e);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return depots;
    }

    @Override
    public Depot getById(int idD) {
        Depot dp=new Depot();
        String query="SELECT * FROM Depot WHERE idD='"+idD+"'";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                dp.setIdD(res.getInt(1));
                dp.setMontant(res.getInt(2));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                dp.setDateDepot(simpleDateFormat.parse(res.getString(3)));
                JDBCBasedCompteRepository jdbcBasedCompteRepository=new JDBCBasedCompteRepository(dataSource);
                Compte compte =jdbcBasedCompteRepository.getById(res.getInt(4));
                dp.setCompte(compte);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return dp;
    }

    @Override
    public List<Depot> getByIdC(int idC) {
        List<Depot> depots = new ArrayList<Depot>();
        String query="SELECT * FROM Depot WHERE idC='"+idC+"'";
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                Depot sc=new Depot();
                sc.setIdD(res.getInt(1));
                sc.setMontant(res.getInt(2));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                sc.setDateDepot(simpleDateFormat.parse(res.getString(3)));
                JDBCBasedCompteRepository jdbcBasedCompteRepository=new JDBCBasedCompteRepository(dataSource);
                Compte compte =jdbcBasedCompteRepository.getById(res.getInt(4));
                sc.setCompte(compte);
                depots.add(sc);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return depots;
    }

    @Override
    public int add(Depot d) {
        String query="INSERT INTO Depot VALUES (NULL,?,?,?)";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement db = connection.prepareStatement(query);
            db.setInt(1, d.getMontant());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            db.setString(2,simpleDateFormat.format(d.getDateDepot()));
            db.setInt(3,d.getCompte().getIdC());
            db.execute();
            return 1;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
