package dao.impl.jdbc;

import com.ibatis.common.jdbc.ScriptRunner;
import dao.impl.jdbc.ConnectionJdbc;
import org.dbunit.*;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.CompositeOperation;
import org.dbunit.operation.DatabaseOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by dmity on 14.10.15.
 */
public abstract class BeforeTestShop extends DatabaseTestCase {

    public void createTestDB() throws Exception {
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, ConnectionJdbc.getDriver());
        Connection connection = ConnectionJdbc.createConnection();
        ScriptRunner runner = new ScriptRunner(connection, false, false);
        runner.runScript(new BufferedReader(new FileReader("src/test/resources/createdatabase.sql")));
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("/dataset.xml"));
    }

    @Override
    protected IDatabaseTester newDatabaseTester() throws Exception {
        JdbcDatabaseTester databaseTester = new JdbcDatabaseTester(ConnectionJdbc.getDriver(),
                ConnectionJdbc.getUrl(), ConnectionJdbc.getUser(), ConnectionJdbc.getPassWord());

        databaseTester.setSetUpOperation(new CompositeOperation(DatabaseOperation.REFRESH,
                DatabaseOperation.DELETE_ALL));

        return databaseTester;
    }

    @Override
    protected DatabaseConnection getConnection() throws SQLException, DatabaseUnitException {
        Connection connection = ConnectionJdbc.createConnection();
        String databaseProductName = connection.getMetaData().getDatabaseProductName();
        DatabaseConnection databaseConnection = new DatabaseConnection(connection);
        DatabaseConfig dbConfig = databaseConnection.getConfig();

        switch (databaseProductName) {
            case "MySQL":
                dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
                break;
            default:
                throw new SQLException("Unknown db type");
        }
        return databaseConnection;
    }

    @Override
    public void setUp() throws Exception {
        createTestDB();
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
    }
}
