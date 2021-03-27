package Repository.JDBC;

import Repository.PartenaireRepository;
import domain.Partenaire;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCBasedPartenaireRepository implements PartenaireRepository {
    private final DataSource dataSource;
    //private MysqlDataSource md =new MysqlDataSource();
    private int ok;
    private ResultSet res;

    public JDBCBasedPartenaireRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Partenaire> getAll() {
        //mapper le résultat
        String query = "SELECT * FROM Partenaire";
        List<Partenaire> partenaires = new ArrayList<>();
        System.out.println("okkkkkkk");

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
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
        String query="SELECT * FROM Partenaire WHERE idP="+idP;
        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(query) ;
            while (res.next()){
                sc.setIdP(res.getInt(1));
                sc.setNinea(res.getString(2));
                sc.setPrenom(res.getString(3));
                sc.setNom(res.getString(4));
                sc.setEmail(res.getString(5));
                sc.setTelephone(res.getString(6));
                sc.setAdresse(res.getString(7));
                sc.setRaisonsociale(res.getString(8));
                sc.setStatut(res.getString(9));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return sc;
    }

    @Override
    public int add(Partenaire p) {
        String query="INSERT INTO Partenaire VALUES (NULL,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement md = connection.prepareStatement(query);
            //int md = statement.executeUpdate(query) ;
            //md.initPrepare(sql);

            md.setString(1, p.getNinea());
            md.setString(2,p.getPrenom());
            md.setString(3, p.getNom());
            md.setString(4, p.getEmail());
            md.setString(5, p.getTelephone());
            md.setString(6, p.getAdresse());
            md.setString(7, p.getRaisonsociale());
            md.setString(8, p.getStatut());


            md.execute();
            return 1;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
