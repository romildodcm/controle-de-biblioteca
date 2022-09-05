package model;

public enum UserType {
    ADMIN(0), OTHER(1);

    private UserType(int value) {
    }

    public static UserType fromInteger(int x) {
        switch(x) {
        case 0:
            return ADMIN;
        case 1:
            return OTHER;
        }
        return null;
    }

    public int toInteger() {
        switch(this) {
        case ADMIN:
            return 0;
        case OTHER:
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        switch(this) {
        case ADMIN:
            return "Administrador";
        case OTHER:
            return "Outro";
        }
        return null;
    }
}
