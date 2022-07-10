package dao.media;

import entity.db.AIMSDB;
import entity.media.CD;
import entity.media.Media;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author
 */
public class CDDAO extends MediaDAO {
    //Coincidental cohesion vi co the tach ra thanh 2 phuong thuc truy van du lieu, xu li du lieu roi goi den 2 phuong thuc do
    //cac class DAO deu ke thua class MediaDAO thi nen tao cac phuong thuc o MediaDAO roi override
    @Override
    public Media getMediaById(int id) throws SQLException {
        String sql = "SELECT * FROM "+
                "aims.CD " +
                "INNER JOIN aims.Media " +
                "ON Media.id = CD.id " +
                "where Media.id = " + id + ";";
//Vi pham nguyen tac Common Coupling: Viec truy van tu 1 DB chung can duoc thuc hien tai 1 function chuyen biet (MediaDAO)
        ResultSet res = AIMSDB.getConnection().createStatement().executeQuery(sql);
        if(res.next()) {

            // from media table
            String title = "";
            String type = res.getString("type");
            int price = res.getInt("price");
            String category = res.getString("category");
            int quantity = res.getInt("quantity");

            // from CD table
            String artist = res.getString("artist");
            String recordLabel = res.getString("recordLabel");
            String musicType = res.getString("musicType");
            Date releasedDate = res.getDate("releasedDate");

            return new CD(id, title, category, price, quantity, type,
                    artist, recordLabel, musicType, releasedDate);

        } else {
            throw new SQLException();
        }
    }
}
