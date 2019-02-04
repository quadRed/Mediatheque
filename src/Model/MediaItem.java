package Model;

import Model.Users.User;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MediaItem implements Previewable, Saveable{

    private static final AtomicInteger itemIDsequence = new AtomicInteger();

    private class ItemMetaData {
        private String metaDataFromItem;
        public String getMetaDataFromItem() {
            return metaDataFromItem;
        }

        public void setMetaDataFromItem(String metaDataFromItem) {
            this.metaDataFromItem = metaDataFromItem;
        }
    }

    private String name;
    private ItemMetaData itemMetaData;
    private String author;
    private int length;
    private Date releaseDate;
    private Integer ID = itemIDsequence.getAndIncrement();
    private boolean rented;
    private User currentUser;
    private boolean isReserved;
    private User currentQueuedUser;

    public boolean isRented() {
        return rented;
    }

    void setRented(boolean rented) {
        this.rented = rented;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
