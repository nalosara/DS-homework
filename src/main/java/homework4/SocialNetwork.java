package main.java.homework4;

import java.util.*;

public class SocialNetwork {
    private int V;
    private int E;
    private HashMap<String, ArrayList<Friendship>> adj;

    public SocialNetwork() {
        this.V = 0;
        this.E = 0;
        this.adj = new HashMap<>();
    }

    public SocialNetwork(Scanner in) {
        this();
        boolean isFirstLine = true;  // Variable to track the first line
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (isFirstLine) {
                isFirstLine = false;  // Skip the header line
                continue;
            }
            String[] parts = line.split(";");  // Split by semicolon
            if (parts.length != 3) {
                System.err.println("Invalid line format: " + line);
                continue; // Skip invalid lines
            }

            try {
                String user1 = parts[0].trim();
                String user2 = parts[1].trim();
                int strength = Integer.parseInt(parts[2].trim());
                this.addFriendship(new Friendship(user1, user2, strength));
            } catch (NumberFormatException e) {
                System.err.println("Invalid strength value: " + parts[2].trim());
            }
        }
    }

    public void addUser(String user) {
        if (!adj.containsKey(user)) {
            adj.put(user, new ArrayList<>());
            V++;
        }
    }

    public void addFriendship(Friendship f) {
        addUser(f.getFriend1());
        addUser(f.getFriend2());
        adj.get(f.getFriend1()).add(f);
        adj.get(f.getFriend2()).add(f);
        E++;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public boolean hasUser(String user) {
        return adj.containsKey(user);
    }

    public ArrayList<FriendshipRecommendation> recommendFriends(String user) {
        if (!adj.containsKey(user)) {
            return new ArrayList<>();
        }

        HashMap<String, Double> recommendations = new HashMap<>();
        HashSet<String> userFriends = new HashSet<>();
        for (Friendship f : adj.get(user)) {
            String friend = f.getFriend1().equals(user) ? f.getFriend2() : f.getFriend1();
            userFriends.add(friend);
        }

        for (String friend : userFriends) {
            for (Friendship friendOfFriendship : adj.get(friend)) {
                String potentialFriend = friendOfFriendship.getFriend1().equals(friend) ? friendOfFriendship.getFriend2() : friendOfFriendship.getFriend1();
                if (!potentialFriend.equals(user) && !userFriends.contains(potentialFriend)) {
                    double minStrength = Math.min(
                            getFriendshipStrength(user, friend),
                            getFriendshipStrength(friend, potentialFriend)
                    );
                    recommendations.put(potentialFriend, recommendations.getOrDefault(potentialFriend, 0.0) + minStrength);
                }
            }
        }

        ArrayList<FriendshipRecommendation> recommendationList = new ArrayList<>();
        for (String recommendedUser : recommendations.keySet()) {
            recommendationList.add(new FriendshipRecommendation(recommendedUser, recommendations.get(recommendedUser)));
        }

        Collections.sort(recommendationList);
        return recommendationList;
    }

    private int getFriendshipStrength(String user1, String user2) {
        for (Friendship f : adj.get(user1)) {
            if ((f.getFriend1().equals(user1) && f.getFriend2().equals(user2)) ||
                    (f.getFriend1().equals(user2) && f.getFriend2().equals(user1))) {
                return f.getStrength();
            }
        }
        return 0;
    }
}
