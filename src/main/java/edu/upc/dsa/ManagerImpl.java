package edu.upc.dsa;

import edu.upc.dsa.models.Badge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

public class ManagerImpl implements Manager {
    private static Manager instance;
    protected List<Badge> badges;
    protected HashMap<String, User> users;
    final static Logger logger = Logger.getLogger(ManagerImpl.class);

    private ManagerImpl() {
        this.badges = new LinkedList<>();
    }

    public static Manager getInstance() {
        if (instance==null) instance = new ManagerImpl();
        return instance;
    }

    @Override
    public void addBadge(Badge b) {
        logger.info("new Badge " + b);

        this.badges.add (b);
        logger.info("new Badge added");
    }

    @Override
    public void addBadge(String name, String url) {
        this.addBadge(new Badge(name, url));
    }

    @Override
    public Badge getBadge(String name) {
        logger.info("getBadge("+name+")");

        for (Badge b: this.badges) {
            if (b.getName().equals(name)) {
                logger.info("getBadge("+name+"): "+b);
                return b;
            }
        }

        logger.warn("not found " + name);
        return null;
    }

    @Override
    public List<Badge> findAllBadges() {
        return this.badges;
    }

    @Override
    public void addUser(User u) {
        this.users.put(u.getUsername(), u);
    }

    @Override
    public void addUser(String username, String avatar, String name, String surname, List<String> badges) {
        User u = new User(username, avatar, name, surname, badges);
        this.users.put(username, u);
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public int size() {
        return this.badges.size();
    }


}