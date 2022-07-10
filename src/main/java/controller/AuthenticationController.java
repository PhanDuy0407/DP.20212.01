package controller;

import common.exception.ExpiredSessionException;
import common.exception.FailLoginException;
import dao.user.UserDAO;
import entity.user.User;
import helper.Security;
import utils.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;



/**
 * @author
 */

/*
    ducanh
    Temporal Cohesion: 3 is checking, or using when login, md5 is not related in Authentication
    SRP: Because getMainUser not realated other method 
    
*/
public class AuthenticationController extends BaseController {

//Vi pham nguyen tac temproral cohesion: Viec xac thuc nguoi dung la lien quan den nhau ve mat thoi gian, nhung nen tach
//thanh cac class khac nhau vi xac thuc qua nhieu thong tin trong 1 class se gay code kho doc va chinh sua
//ngoai ra nhung cap xac thuc ma ko lien quan gi den nhau thi nen cho sang cac class khac
    public boolean isAnonymousSession() {
        try {
            getMainUser();
            return false;
        } catch (Exception ex) {
            return true;
        }
    }

    public User getMainUser() throws ExpiredSessionException {
        if (SessionInformation.mainUser == null || SessionInformation.expiredTime == null || SessionInformation.expiredTime.isBefore(LocalDateTime.now())) {
            logout();
            throw new ExpiredSessionException();
        } else return SessionInformation.mainUser.cloneInformation();
    }

    public void login(String email, String password) throws Exception {
        try {
        	Security security = Security.getInstance();
            User user = new UserDAO().authenticate(email,security.md5Encryption(password));
            if (Objects.isNull(user)) throw new FailLoginException();
            SessionInformation.mainUser = user;
            SessionInformation.expiredTime = LocalDateTime.now().plusHours(24);
        } catch (SQLException ex) {
            throw new FailLoginException();
        }
    }

    public void logout() {
        SessionInformation.mainUser = null;
        SessionInformation.expiredTime = null;
    }

    /**
     * Return a {@link String String} that represents the cipher text
     * encrypted by md5 algorithm.
     *
     * @param message - plain text as {@link String String}.
     * @return cipher text as {@link String String}.
     */


}
