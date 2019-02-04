package Model;

import Model.Users.User;

import java.util.ArrayList;

public class Library {
    private ArrayList<MediaItem> itemsList = new ArrayList<>();

    public void saveLibrary() {
        for (MediaItem mediaItem : itemsList
             ) {
            mediaItem.prepareForSaving();
        }
    }

    public void previewItem(MediaItem mediaItem){
        mediaItem.preview();
    }

    public ArrayList<MediaItem> getItemsList() {
        return itemsList;
    }

    public void addAnItemToTheLibrary(User user, MediaItem mediaItem){
        if(user.isManager()) itemsList.add(mediaItem);
    }

    public void removeAnItemFromTheLibrary(User user, MediaItem mediaItem){
        if(user.isManager()) itemsList.remove(mediaItem);
    }

    public void rentAnItem(User user, MediaItem mediaItem) {
        if (itemsList.indexOf(mediaItem) >= 0){
            if (mediaItem.isRented()) {
                System.out.println("This item is already rented");
            } else {
                user.addItemsToRentedList(mediaItem);
                mediaItem.setRented(true);
                mediaItem.setCurrentUser(user);
            }
        }
    }

    public void returnAnItem(User user, MediaItem mediaItem){

        if (itemsList.indexOf(mediaItem) >= 0 && mediaItem.isRented() && mediaItem.getCurrentUser().equals(user)){
                user.removeItemsFromRentedList(mediaItem);
                mediaItem.setRented(false);
                mediaItem.setCurrentUser(null);
        }
    }
}
