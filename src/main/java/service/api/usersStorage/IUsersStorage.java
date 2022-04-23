package service.api.usersStorage;

import core.dto.User;

public interface IUsersStorage {
  void saveUser(User user);
 // void saveAdmin();
  User getUser(String userLogin);
  boolean checkLoginAndPassword(String userLogin, String password);

}
