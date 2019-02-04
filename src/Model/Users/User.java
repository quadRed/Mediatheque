package Model.Users;

import Model.MediaItem;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger itemIDsequence = new AtomicInteger();
    private String login;
    private String password;
    private boolean isManager;
    private Integer ID = itemIDsequence.getAndIncrement();
    private ArrayList<MediaItem> rentedItems = new ArrayList<>();

    public User(boolean makeManager){
        isManager = makeManager;
    }

    public void addItemsToRentedList(MediaItem mediaItem){
        rentedItems.add(mediaItem);
    }

    public void removeItemsFromRentedList(MediaItem mediaItem){
        try{
            rentedItems.remove(mediaItem);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println(mediaItem + " not present in " + login + " rented items.");
        }
    }

    public boolean isManager() {
        return isManager;
    }
}
