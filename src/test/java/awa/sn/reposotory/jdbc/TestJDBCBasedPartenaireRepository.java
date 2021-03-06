package awa.sn.reposotory.jdbc;
import Repository.JDBC.DataSource;
import Repository.JDBC.JDBCBasedPartenaireRepository;

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

public class TestJDBCBasedPartenaireRepository {
    private JDBCBasedPartenaireRepository jdbcBasedPartenaireRepository;
    @BeforeEach
    void setUp() throws SQLException {
        System.out.println("Dans la méthode setup");
        //Arrange
        DataSource dataSource = new MockDataSource();
     jdbcBasedPartenaireRepository = new JDBCBasedPartenaireRepository(dataSource);
    }
    @Test
    void getAllPartanires() throws SQLException {
        System.out.println("Dans la méthode get partenaire");
        //Act
        DataSource dataSource = mock(DataSource.class);
        when(dataSource.createConnection()).thenThrow(new RuntimeException("Base de données non disponible"));
        List<Partenaire> partenaires = jdbcBasedPartenaireRepository.getAll();
        //Assert
        assertEquals(4, partenaires.size(), "le nombre de partenaires doit être 4");
    }
    @Test
    void getByIdShouldReturnPartenaireWhenAvailable() throws SQLException {
        DataSource dataSource = mock(DataSource.class);
        Connection connection = mock(Connection.class);
        when(dataSource.createConnection()).thenReturn(connection);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        ResultSet resultSet2 = mock(ResultSet.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet2);
        when(resultSet2.getInt(anyString())).thenReturn(0);
        when(resultSet2.getString(anyString())).thenReturn("aaaaa");
        Partenaire partenaire = jdbcBasedPartenaireRepository.getById(0);
        assertNotNull(partenaire);
        assertEquals(0, partenaire.getIdP());
        //assertEquals("aaaaa", partenaire.getNinea());

    }


}

