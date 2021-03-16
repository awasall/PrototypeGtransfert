package Repository.JDBC;

import Repository.CompteRepository;
import domain.Compte;
import domain.Partenaire;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JDBCBasedCompteRepository implements CompteRepository {
    private MysqlDataSource db =new MysqlDataSource();
    private int ok;
    private ResultSet res;

    @Override
    public List<Compte> getAll() {
        List<Compte> comptes = new ArrayList<Compte>();
        String sql="SELECT * FROM Compte";
        try {
            db.initPrepare(sql);
            res=db.executeSelect();
            while (res.next()){
                Compte e=new Compte();
                e.setIdC(res.getInt(1));
                e.setNumerCompte(res.getString(2));
                e.setSolde(res.getInt(3));
                JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository=new JDBCBasedPartenaireRepository();
                Partenaire partenaire =jdbcBasedPartenaireRepository.getById(res.getInt(4));
                e.setPartenaire(partenaire);

                comptes.add(e);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return comptes;
    }

    @Override
    public Compte getById(int idC) {
        Compte sc=new Compte();
        String sql="SELECT * FROM Compte WHERE idC='"+idC+"'";
        try {
            db.initPrepare(sql);
            res=db.executeSelect();
            while (res.next()){
                sc.setIdC(res.getInt(1));
                sc.setNumerCompte(res.getString(2));
                sc.setSolde(res.getInt(3));
                JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository=new JDBCBasedPartenaireRepository();
                Partenaire partenaire =jdbcBasedPartenaireRepository.getById(res.getInt(4));
                sc.setPartenaire(partenaire);

                //comptes.add(e);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return sc;
    }

    @Override
    public List<Compte>  getByIdP(int idP) {
        List<Compte> comptes = new ArrayList<Compte>();

        String sql="SELECT * FROM Compte WHERE idP='"+idP+"'";
        try {
            db.initPrepare(sql);
            res=db.executeSelect();
            while (res.next()){
                Compte sc=new Compte();
                sc.setIdC(res.getInt(1));
                sc.setNumerCompte(res.getString(2));
                sc.setSolde(res.getInt(3));
                JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository=new JDBCBasedPartenaireRepository();
                Partenaire partenaire =jdbcBasedPartenaireRepository.getById(res.getInt(4));
                sc.setPartenaire(partenaire);
                comptes.add(sc);

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return comptes;
    }

    @Override
    public int add(Compte c) {
        String sql="INSERT INTO Compte VALUES (NULL,?,?,?)";
        try {
            db.initPrepare(sql);

            db.getPstm().setString(1, c.getNumerCompte());
            db.getPstm().setInt(2,c.getSolde());
            db.getPstm().setInt(3,c.getPartenaire().getIdP());
            ok=db.executeMaj();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
}
