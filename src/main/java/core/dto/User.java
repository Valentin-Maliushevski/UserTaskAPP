package core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String login;
    private String password;
    private String FIO;
    private LocalDate birthday;
    private LocalDateTime dateOfIndentification;
    private RoleType role;

    public User(String login, String password, String FIO, LocalDate birthday, RoleType role) {
        this.login = login;
        this.password = password;
        this.FIO = FIO;
        this.birthday = birthday;
        this.dateOfIndentification = LocalDateTime.now();
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", password='" + password + '\'' +
            ", FIO='" + FIO + '\'' +
            ", birthday=" + birthday +
            ", dateOfIndentification=" + dateOfIndentification.toString() +
            ", role=" + role.toString() +
            '}';
    }
}
