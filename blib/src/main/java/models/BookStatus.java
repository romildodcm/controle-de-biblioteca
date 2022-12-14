package models;

public enum BookStatus {
    AVAILABLE, BORROWED, UNAVAILABLE;

    public static BookStatus fromInteger(int x) {
        switch(x) {
        case 1:
            return AVAILABLE;
        case 2:
            return BORROWED;
        case 3:
            return UNAVAILABLE;
        }
        return null;
    }

    public int toInteger() {
        switch(this) {
        case AVAILABLE:
            return 1;
        case BORROWED:
            return 2;
        case UNAVAILABLE:
            return 3;
        }
        return -1;
    }

    @Override
    public String toString() {
        switch(this) {
        case AVAILABLE:
            return "Disponível";
        case BORROWED:
            return "Emprestado";
        case UNAVAILABLE:
            return "Indisponível";
        }
        return null;
    }
}