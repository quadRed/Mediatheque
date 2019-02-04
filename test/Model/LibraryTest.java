package Model;

import Model.MediaItems.Book;
import Model.Users.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    Library library = new Library();
    User user1 = new User(false);
    User manager = new User(true);
    Book book = new Book();
    Book book1 = new Book();

    @Test
    public void addAnItemToTheLibrary() {

        library.addAnItemToTheLibrary(user1, book);
        ArrayList<MediaItem> exampleList = new ArrayList<>();
        assertArrayEquals(exampleList.toArray(), library.getItemsList().toArray());

        library.addAnItemToTheLibrary(manager, book);
        exampleList.add(book);
        assertArrayEquals(exampleList.toArray(),library.getItemsList().toArray());
    }

    @Test
    public void removeAnItemFromTheLibrary() {

        ArrayList<MediaItem> exampleList = new ArrayList<>();
        library.addAnItemToTheLibrary(manager, book);
        exampleList.add(book);
        assertArrayEquals(exampleList.toArray(),library.getItemsList().toArray());

        library.removeAnItemFromTheLibrary(user1, book);
        assertArrayEquals(exampleList.toArray(), library.getItemsList().toArray());

        library.removeAnItemFromTheLibrary(manager, book1);
        assertArrayEquals(exampleList.toArray(), library.getItemsList().toArray());

        library.removeAnItemFromTheLibrary(manager, book);
        exampleList.remove(book);
        assertArrayEquals(exampleList.toArray(), library.getItemsList().toArray());
    }

    @Test
    public void rentAnItem() {
        library.addAnItemToTheLibrary(manager, book);
        assertFalse(book.isRented());
        library.rentAnItem(user1, book);
        assertTrue(book.isRented());
    }

    @Test
    public void returnAnItem() {
        library.addAnItemToTheLibrary(manager, book);
        assertFalse(book.isRented());
        library.rentAnItem(user1, book);
        assertTrue(book.isRented());
        library.returnAnItem(user1, book);
        assertFalse(book1.isRented());
    }
}
