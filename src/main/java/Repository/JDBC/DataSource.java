package Repository.JDBC;

import java.sql.Connection;

public interface DataSource {
    Connection createConnection();
}
