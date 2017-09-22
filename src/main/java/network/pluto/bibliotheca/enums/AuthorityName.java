package network.pluto.bibliotheca.enums;

public enum AuthorityName {
    ROLE_ADMIN,
    ROLE_USER;

    public static AuthorityName find(String name) {
        for (AuthorityName authorityName : AuthorityName.values()) {
            if (authorityName.name().equals(name)) {
                return authorityName;
            }
        }
        return null;
    }
}
