package edu.upc.dsa;

import edu.upc.dsa.models.Badge;
import edu.upc.dsa.models.User;

import java.util.List;

public interface Manager {

    public void addBadge(Badge b);
    public Badge getBadge(String name);
    public void addBadge(String name, String url);
    public List<Badge> findAllBadges();

    public void addUser(User u);
    public void addUser(String username, String avatar, String name, String surname, List<String> badges);
    public User getUser(String username);

    public int size();


}
