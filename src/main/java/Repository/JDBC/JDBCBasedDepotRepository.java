package Repository.JDBC;

import Repository.DepotRepository;
import domain.Compte;
import domain.Depot;
import domain.Partenaire;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JDBCBasedDepotRepository  implements DepotRepository{
    private MysqlDataSource db =new MysqlDataSource();
    private int ok;
    private ResultSet res;
    @Override
    public List<Depot> getAll() {
        List<Depot> depots = new ArrayList<Depot>();
        String sql="SELECT * FROM Depot";
        try {
            db.initPrepare(sql);
            res=db.executeSelect();
            while (res.next()){
                Depot e=new Depot();
                e.setIdD(res.getInt(1));
                e.setMontant(res.getInt(2));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                e.setDateDepot(simpleDateFormat.parse(res.getString(3)));
                JDBCBasedCompteRepository jdbcBasedCompteRepository=new JDBCBasedCompteRepository();
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
        String sql="SELECT * FROM Depot WHERE idD='"+idD+"'";
        try {
            db.initPrepare(sql);
            res=db.executeSelect();
            while (res.next()){
                dp.setIdD(res.getInt(1));
                dp.setMontant(res.getInt(2));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                dp.setDateDepot(simpleDateFormat.parse(res.getString(3)));
                JDBCBasedCompteRepository jdbcBasedCompteRepository=new JDBCBasedCompteRepository();
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

        String sql="SELECT * FROM Depot WHERE idC='"+idC+"'";
        try {
            db.initPrepare(sql);
            res=db.executeSelect();
            while (res.next()){
                Depot sc=new Depot();
                sc.setIdD(res.getInt(1));
                sc.setMontant(res.getInt(2));
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
                sc.setDateDepot(simpleDateFormat.parse(res.getString(3)));
                JDBCBasedCompteRepository jdbcBasedCompteRepository=new JDBCBasedCompteRepository();
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
        String sql="INSERT INTO Depot VALUES (NULL,?,?,?)";
        try {
            db.initPrepare(sql);

            db.getPstm().setInt(1, d.getMontant());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            db.getPstm().setString(2,simpleDateFormat.format(d.getDateDepot()));
            db.getPstm().setInt(3,d.getCompte().getIdC());
            ok=db.executeMaj();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
}
