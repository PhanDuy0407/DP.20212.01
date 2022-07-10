package entity.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import java.sql.Connection;
import utils.*;

/*
    Db is coincidental cohesion so it's not related to the package entity, 
    it must belong to db or connect package
*/
public class AIMSDB {

    /**
     * Clean code: Thay đổi các giá trị string bằng hằng số
     */

    private static final String NAME_JDBC = "org.sqlite.JDBC";
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/resources/assets/db/aims.db";

	private static Logger LOGGER = Utils.getLogger(Connection.class.getName());
	private static Connection connect;
    // TODO: refactor Utils -> limit connections
    // Common coupling: xảy ra khi ai cũng có thể truy cập vào method này 
    public static Connection getConnection() {
        if (connect != null) return connect;
        try {
			Class.forName(NAME_JDBC);
            String url = DATABASE_URL;
            connect = DriverManager.getConnection(url);
            LOGGER.info("Connect database successfully");
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        } 
        return connect;
    }


//Vi pham nguyen tac temproral cohesion: ham main se duoc goi truoc xong roi ham GetConnection se duoc goi sau do nhung
//chung ko lien quan gi den nhau vi chi co 1 ham Main duy nhat duoc goi khi chuong trinh thuc thi tai file App.java
    public static void main(String[] args) {
        AIMSDB.getConnection();
    }
}
