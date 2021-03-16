package Repository.JDBC;

import Repository.PartenaireRepository;
import domain.Partenaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCBasedPartenaireRepository implements PartenaireRepository {
    private MysqlDataSource md =new MysqlDataSource();
    //private int ok;
    private ResultSet res;
    private int ok;
    @Override
    public List<Partenaire> getAll() {
        //mapper le résultat
        String sql = "SELECT * FROM Partenaire";
        List<Partenaire> partenaires = new ArrayList<>();
        System.out.println("okkkkkkk");

        try {
            md.initPrepare(sql);

            res=md.executeSelect();
            while (res.next()) {


                int idP = res.getInt("idP");
                String ninea = res.getString("ninea");
                String prenom = res.getString("prenom");
                String nom = res.getString("nom");
                String email = res.getString("email");
                String telephone = res.getString("telephone");
                String adresse = res.getString("adresse");
                String raisonsociale = res.getString("raisonsociale");
                String statut = res.getString("statut");
                //mapping retour db (relationnel) avec objet Prestation
                Partenaire partenaire = new Partenaire( idP, ninea ,prenom,nom,email,telephone,adresse,raisonsociale,statut);

                partenaires.add(partenaire);
            }
            System.out.println("okkkkkkk");
            return partenaires;

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
  return partenaires;
    }

    @Override
    public Partenaire getById(int idP) {
        Partenaire sc=new Partenaire();
        String sql="SELECT * FROM Partenaire WHERE idP='"+idP+"'";
        try {
            md.initPrepare(sql);
            res=md.executeSelect();
            while (res.next()){
                sc.setIdP(res.getInt(1));
                sc.setNinea(res.getString(2));
                sc.setPrenom(res.getString(3));
                sc.setNom(res.getString(4));
                sc.setEmail(res.getString(5));
                sc.setTelephone(res.getString(5));
                sc.setAdresse(res.getString(5));
                sc.setRaisonsociale(res.getString(5));
                sc.setStatut(res.getString(5));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return sc;
    }

    @Override
    public int add(Partenaire p) {
        String sql="INSERT INTO Partenaire VALUES (NULL,?,?,?,?,?,?,?,?)";
        try {
            md.initPrepare(sql);
            md.getPstm().setString(1, p.getNinea());
            md.getPstm().setString(2,p.getPrenom());
            md.getPstm().setString(3, p.getNom());
            md.getPstm().setString(4, p.getEmail());
            md.getPstm().setString(5, p.getTelephone());
            md.getPstm().setString(6, p.getAdresse());
            md.getPstm().setString(7, p.getRaisonsociale());
            md.getPstm().setString(8, p.getStatut());


            ok=md.executeMaj();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ok;
    }
}
