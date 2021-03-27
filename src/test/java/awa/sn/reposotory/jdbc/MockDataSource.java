package awa.sn.reposotory.jdbc;

import Repository.JDBC.DataSource;
import Repository.JDBC.MysqlDataSource;

import java.sql.*;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockDataSource implements DataSource {
    @Override
    public Connection createConnection() {
        Connection connection = mock(Connection.class);
        Statement statement = mock(Statement.class);
        try {
            when(connection.createStatement()).thenReturn(statement);
            PreparedStatement preparedStatement = mock(PreparedStatement.class);
            when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
            ResultSet resultSet2 = mock(ResultSet.class);
            when(preparedStatement.executeQuery()).thenReturn(resultSet2);
            when(resultSet2.getInt(anyString())).thenReturn(1);
            when(resultSet2.getString(anyString())).thenReturn("");

            ResultSet resultSet = mock(ResultSet.class);
            when(statement.executeQuery(anyString())).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(true, true, true, true, false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

