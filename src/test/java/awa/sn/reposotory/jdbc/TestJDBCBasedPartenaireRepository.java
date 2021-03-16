package awa.sn.reposotory.jdbc;
import Repository.JDBC.JDBCBasedCompteRepository;
import Repository.JDBC.JDBCBasedDepotRepository;
import Repository.JDBC.JDBCBasedPartenaireRepository;
import domain.Compte;
import domain.Depot;
import domain.Partenaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestJDBCBasedPartenaireRepository {
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        //DataSource dataSource = new MockDatasource();
    }
    @Test
    void getAllPartanires(){
        System.out.println("Dans la méthode get partenaire");
        JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository = new JDBCBasedPartenaireRepository();

        //Act
        List<Partenaire> partenaires = jdbcBasedPartenaireRepository.getAll();
        //Assert
        assertEquals(2, partenaires.size(), "le nombre de partenaires doit être 2");
    }
    @Test
    void getByIdShouldReturnPartenaireWhenAvailable(){
        JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository = new JDBCBasedPartenaireRepository();
        Partenaire partenaire = jdbcBasedPartenaireRepository.getById(1);
        assertNotNull(partenaire);
        assertEquals(1, partenaire.getIdP());
        //assertEquals("", partenaire.getNinea());
        assertEquals("", partenaire.getPrenom());
        //assertEquals("", partenaire.getNom());
    }
    @Test
    void getAllComptes(){
        System.out.println("Dans la méthode get compte");
        JDBCBasedCompteRepository jdbcBasedCompteRepositoryRepository = new JDBCBasedCompteRepository();

        //Act
        List<Compte> comptes = jdbcBasedCompteRepositoryRepository.getAll();
        //Assert
        assertEquals(7, comptes.size(), "le nombre de partenaires doit être 7");
    }
    @Test
    void getAllDepots(){
        System.out.println("Dans la méthode get Depot");
        JDBCBasedDepotRepository jdbcBasedDepotRepository = new JDBCBasedDepotRepository();

        //Act
        List<Depot> depots = jdbcBasedDepotRepository.getAll();
        //Assert
        assertEquals(2, depots.size(), "le nombre de depots doit être 2");
    }
}
