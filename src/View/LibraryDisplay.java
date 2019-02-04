package View;

public class LibraryDisplay {
    private static LibraryDisplay ourInstance = new LibraryDisplay();

    public static LibraryDisplay getInstance() {
        return ourInstance;
    }

    private LibraryDisplay() {
    }
}
