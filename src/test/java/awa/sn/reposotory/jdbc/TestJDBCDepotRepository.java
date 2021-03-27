package awa.sn.reposotory.jdbc;
import Repository.JDBC.DataSource;
import Repository.JDBC.JDBCBasedCompteRepository;
import Repository.JDBC.JDBCBasedDepotRepository;
import domain.Depot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
public class TestJDBCDepotRepository {
    private JDBCBasedDepotRepository jdbcBasedDepotRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MockDataSource();
        jdbcBasedDepotRepository=new JDBCBasedDepotRepository(dataSource);

    }
    @Test
    void getAllDepots(){
        System.out.println("Dans la méthode get Depot");
        //Act
        List<Depot> depots = jdbcBasedDepotRepository.getAll();
        //Assert
        assertEquals(3, depots.size(), "le nombre de depots doit être 2");
    }
}

