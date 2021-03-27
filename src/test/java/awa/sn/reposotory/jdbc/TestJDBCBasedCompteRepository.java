package awa.sn.reposotory.jdbc;

import Repository.JDBC.DataSource;
import Repository.JDBC.JDBCBasedCompteRepository;
import Repository.JDBC.JDBCBasedPartenaireRepository;
import domain.Compte;
import domain.Partenaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestJDBCBasedCompteRepository {
    private JDBCBasedCompteRepository jdbcBasedCompteRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MockDataSource();
        jdbcBasedCompteRepository=new JDBCBasedCompteRepository(dataSource);

    }
    @Test
    void getAllComptes(){
        System.out.println("Dans la méthode get compte");
        //Act
        List<Compte> comptes = jdbcBasedCompteRepository.getAll();
        //Assert
        assertEquals(5, comptes.size(), "le nombre de partenaires doit être 5");
    }
    @Test
    void getByIdShouldReturnCompteWhenAvailable() throws SQLException {
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        when(dataSource.createConnection()).thenReturn(connection);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        ResultSet resultSet2 = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet2);
        when(resultSet2.getInt(anyString())).thenReturn(2);
        when(resultSet2.getString(anyString())).thenReturn("aaaa");
        Compte compte = jdbcBasedCompteRepository.getById(2);
        assertNotNull(compte);
        assertEquals(2, compte.getIdC());
        assertEquals("aaaa", compte.getNumerCompte());

    }
}
