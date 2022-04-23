package core.dto;

public enum RoleType {
  OtherUser, Admin;

  public static RoleType getRole(String roleName) {
    for(RoleType role: values()) {
      if(role.name().equalsIgnoreCase(roleName)) {
        return role;
      }
    }
    throw new IllegalArgumentException("There are no such roleType");
  }
}
