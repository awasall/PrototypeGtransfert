package awa.sall;

import Repository.JDBC.*;
import domain.Compte;
import domain.Depot;
import domain.Partenaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainT {
    //private static IPartenaire partenaireService;
    //private final PartenaireService partenaireService;

    public static void main(String[] args) throws ParseException {
        int choix = 0;
        int choix1 = 0;
        int choix2 = 0;


        System.out.println("Faire un  choix");
        System.out.println("1- Partenaire");
        System.out.println("2- Compte");
        System.out.println("3- Depot");
        System.out.println("4- Utilisateur");
        System.out.print("Votre choix: ");
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();


        if (choix == 1) {
            System.out.println("1- Inscrire Partenaire");
            System.out.println("2- Liste Partenaire");
            System.out.println("3- Détail Partenaire");
            System.out.println("4- Modifier  Partenaire");
            choix1 = sc.nextInt();
            if (choix1==1){
                Partenaire p = new Partenaire();
                System.out.println("ninea");
                String ninea=sc.next();
                p.setNinea(ninea);
                System.out.println("Prenom");
                String prenom=sc.next();
                p.setPrenom(prenom);
                System.out.println("saisir le nom");
                String nom=sc.next();
                p.setNom(nom);
                System.out.println("Email");
                String email=sc.next();
                p.setEmail(email);
                System.out.println("saisir le telephone");
                String telephone=sc.next();
                p.setTelephone(telephone);
                System.out.println("Adress");
                String adresse=sc.next();
                p.setAdresse(adresse);
                System.out.println("Raison Sociale");
                String raisonsociale=sc.next();
                p.setRaisonsociale(raisonsociale);
                System.out.println("Statut");
                String statut=sc.next();
                p.setStatut(statut);
                MysqlDataSource dataSource=new MysqlDataSource();

                JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository =new JDBCBasedPartenaireRepository(dataSource);
               jdbcBasedPartenaireRepository.add(p);


            }
            if (choix1 == 2) {
                MysqlDataSource dataSource=new MysqlDataSource();
                JDBCBasedPartenaireRepository partenaireRepository = new JDBCBasedPartenaireRepository(dataSource);
                List<Partenaire> partenaires = partenaireRepository.getAll();
                for (int i = 0; i < partenaires.size(); i++) {
                    System.out.print(partenaires.get(i).getIdP() + "\t");
                    System.out.print(partenaires.get(i).getNinea() + "\t");
                    System.out.print(partenaires.get(i).getPrenom() + "\t");
                    System.out.print(partenaires.get(i).getNom() + "\t");
                    System.out.print(partenaires.get(i).getTelephone() + "\t");
                    System.out.print(partenaires.get(i).getEmail() + "\t");
                    System.out.print(partenaires.get(i).getRaisonsociale() + "\t");
                    System.out.print(partenaires.get(i).getStatut() + "\t");
                }
            }
            if (choix1 == 3) {
                System.out.print("Saisir id Partenaire: ");
                int idPartenaire = sc.nextInt();
                MysqlDataSource dataSource=new MysqlDataSource();

                //get partenaire by id
                JDBCBasedPartenaireRepository partenaireRepository = new JDBCBasedPartenaireRepository(dataSource);
                System.out.print(partenaireRepository.getById(idPartenaire).getIdP() + "\t");
                System.out.print(partenaireRepository.getById(idPartenaire).getNinea() + "\t");
            }
        }

        if (choix == 2) {
            System.out.println("1- Ajout Compte");
            System.out.println("2- Liste Compte");
            System.out.println("3- Détail Compte");
            System.out.println("4- Lister les comptes d'un partenaire");
            choix1 = sc.nextInt();
            if (choix1 == 1) {
             Compte c = new Compte();
            System.out.println("saisir le numero compte");
            //String nunCompute=sc.nextLine();
            c.setNumerCompte(sc.next());
            System.out.println("solde");
                int sold=sc.nextInt();
                c.setSolde(sold);
            Partenaire p=new Partenaire();
            System.out.println("saisir le partenaire id");
            int part=sc.nextInt();
            p.setIdP(part);
            c.setPartenaire(p);
                MysqlDataSource dataSource=new MysqlDataSource();
            JDBCBasedCompteRepository iemp =new JDBCBasedCompteRepository(dataSource);
            iemp.add(c);

        }

            if (choix1 == 2) {
                MysqlDataSource dataSource=new MysqlDataSource();
                JDBCBasedCompteRepository jdbcBasedCompteRepository = new JDBCBasedCompteRepository(dataSource);
                List<Compte> comptes = jdbcBasedCompteRepository.getAll();
                for (int i = 0; i < comptes.size(); i++) {
                    System.out.print(comptes.get(i).getIdC() + "\t");
                    System.out.print(comptes.get(i).getNumerCompte() + "\t");
                    System.out.print(comptes.get(i).getSolde() + "\t");
                    System.out.print(comptes.get(i).getPartenaire().getIdP() + "\n");

                }
            }
            if (choix1 == 3) {
                System.out.print("Saisir l'id du Compte: ");
                int idCompte = sc.nextInt();
                MysqlDataSource dataSource=new MysqlDataSource();
                //get Compte by id
                JDBCBasedCompteRepository jdbcBasedCompteRepository = new JDBCBasedCompteRepository(dataSource);
                System.out.print(jdbcBasedCompteRepository.getById(idCompte).getIdC() + "\t");
                System.out.print(jdbcBasedCompteRepository.getById(idCompte).getNumerCompte() + "\t");
                System.out.print(jdbcBasedCompteRepository.getById(idCompte).getSolde() + "\t");
                System.out.print(jdbcBasedCompteRepository.getById(idCompte).getPartenaire().getIdP() + "\t");
            }
            if (choix1 == 4) {
                System.out.print("Saisir l'id du partenaire: ");
                int idpartenaire = sc.nextInt();
                MysqlDataSource dataSource=new MysqlDataSource();
                JDBCBasedCompteRepository jdbcBasedCompteRepository = new JDBCBasedCompteRepository(dataSource);
                List<Compte> comptes = jdbcBasedCompteRepository.getByIdP(idpartenaire);
                for (int i = 0; i < comptes.size(); i++) {
                    System.out.print(comptes.get(i).getIdC() + "\t");
                    System.out.print(comptes.get(i).getNumerCompte() + "\t");
                    System.out.print(comptes.get(i).getSolde() + "\t");
                    System.out.print(comptes.get(i).getPartenaire().getIdP() + "\n");

                }

            }}

            if (choix == 3) {
                System.out.println("1- Faire un Dépot");
                System.out.println("2- Liste Dépot");
                System.out.println("3- detail depot");
                System.out.println("4- lister les historiques de dépot d'un compte");
                choix1 = sc.nextInt();
                if(choix1==1){
                    Depot d = new Depot();
                    System.out.println("saisir le montant");
                    //String nunCompute=sc.nextLine();
                    d.setMontant(sc.nextInt());
                    System.out.println("Saisir date de depot (AAAA-MM-JJ) :");
                    String str = sc.next();
                    if(str.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
                        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = f.parse(str);
                        d.setDateDepot(date);
                    }
                    else {
                        System.out.println("Erreur format");
                    }
                    Compte c=new Compte();
                    System.out.println("saisir le compte id");
                    int compt=sc.nextInt();
                    c.setIdC(compt);
                    d.setCompte(c);
                    MysqlDataSource dataSource=new MysqlDataSource();
                    JDBCBasedDepotRepository iemp =new JDBCBasedDepotRepository(dataSource);
                    iemp.add(d);
                }
                if (choix1==2) {
                    MysqlDataSource dataSource=new MysqlDataSource();
                    JDBCBasedDepotRepository jdbcBasedDepotRepository = new JDBCBasedDepotRepository(dataSource);
                    List<Depot> depots = jdbcBasedDepotRepository.getAll();
                    for (int i = 0; i < depots.size(); i++) {
                        System.out.print(depots.get(i).getIdD() + "\t");
                        System.out.print(depots.get(i).getMontant() + "\t");
                        System.out.print(depots.get(i).getDateDepot() + "\t");
                        System.out.print(depots.get(i).getCompte().getIdC() + "\n");
                    }
                }
                if (choix1 == 3) {
                    System.out.print("Saisir l'id du Depot: ");
                    int idDepot = sc.nextInt();
                    MysqlDataSource dataSource=new MysqlDataSource();
                    //get Compte by id
                    JDBCBasedDepotRepository jdbcBasedDepotRepository = new JDBCBasedDepotRepository(dataSource);
                    System.out.print(jdbcBasedDepotRepository.getById(idDepot).getIdD() + "\t");
                    System.out.print(jdbcBasedDepotRepository.getById(idDepot).getMontant() + "\t");
                    System.out.print(jdbcBasedDepotRepository.getById(idDepot).getDateDepot() + "\t");
                    System.out.print(jdbcBasedDepotRepository.getById(idDepot).getCompte().getIdC() + "\t");
                }
                if (choix1 == 4) {
                    System.out.print("Saisir l'id du Compte: ");
                    int idcompte = sc.nextInt();
                    MysqlDataSource dataSource=new MysqlDataSource();
                    JDBCBasedDepotRepository jdbcBasedDepotRepository = new JDBCBasedDepotRepository(dataSource);
                    List<Depot> depots = jdbcBasedDepotRepository.getByIdC(idcompte);
                    for (int i = 0; i < depots.size(); i++) {
                        System.out.print(depots.get(i).getIdD() + "\t");
                        System.out.print(depots.get(i).getMontant() + "\t");
                        System.out.print(depots.get(i).getDateDepot() + "\t");
                        System.out.print(depots.get(i).getCompte().getIdC() + "\n");

                    }

                }

            }
        }
}