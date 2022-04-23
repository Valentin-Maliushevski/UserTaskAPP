package service.api.usersStorage;

import core.dto.RoleType;
import core.dto.User;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import service.api.messagesStorage.MessagesStorage;

public class UsersStorage implements IUsersStorage {

  private static class UsersStorageHolder {
    private static final UsersStorage USERS_STORAGE_INSTANCE = new UsersStorage();
  }

  public static UsersStorage getInstance() {
    return UsersStorageHolder.USERS_STORAGE_INSTANCE;
  }

  public UsersStorage() {
    UserStorage.put(adminUser.getLogin(), adminUser);
  }


  private static int allUsersCount = 0;
  private final Map<String, User> UserStorage = new HashMap<>();

  User adminUser = new User("admin", "admin", "Maliushevski Valentin Sergeevich",
                            LocalDate.of(1997,01,10), RoleType.getRole("Admin"));

  public User getAdminUser() {
    return adminUser;
  }

  public static int getAllUsersCount() {
    return allUsersCount;
  }

  @Override
  public synchronized void saveUser(User user) {
    UserStorage.put(user.getLogin(), user);
    MessagesStorage.getInstance().saveUserWithHisMessages(user.getLogin());
    allUsersCount++;
  }

  @Override
  public User getUser(String userLogin) {
    return UserStorage.get(userLogin);
  }

  @Override
  public boolean checkLoginAndPassword(String userLogin, String userPassword) {

    if (UserStorage.containsKey(userLogin)) {
      if (userPassword.equals(UserStorage.get(userLogin).getPassword())) {
        return true;
      } else return false;
    } else return false;
  }
}
