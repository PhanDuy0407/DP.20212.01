package dao.media;

import entity.media.Media;

import java.sql.SQLException;

public interface MediaInterface {
    public Media getMediaById(int id) throws SQLException;
}
