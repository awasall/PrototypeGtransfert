package awa.sn.reposotory.jdbc;
import Repository.JDBC.JDBCBasedPartenaireRepository;
import domain.Partenaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
