package controller;

import common.exception.ExpiredSessionException;
import common.exception.FailLoginException;
import dao.user.UserDAO;
import entity.user.User;
import helper.Security;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserController {
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
    public User getMainUser() throws ExpiredSessionException {
        if (SessionInformation.mainUser == null || SessionInformation.expiredTime == null || SessionInformation.expiredTime.isBefore(LocalDateTime.now())) {
            logout();
            throw new ExpiredSessionException();
        } else return SessionInformation.mainUser.cloneInformation();
    }
    public void logout() {
        SessionInformation.mainUser = null;
        SessionInformation.expiredTime = null;
    }
}
