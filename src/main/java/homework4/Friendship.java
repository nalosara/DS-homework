package main.java.homework4;

import java.util.Objects;

public class Friendship {
    private String friend1;
    private String friend2;
    private int strength;

    public Friendship(String friend1, String friend2, int strength) {
        this.friend1 = friend1;
        this.friend2 = friend2;
        this.strength = strength;
    }

    public String getFriend1() {
        return friend1;
    }

    public void setFriend1(String friend1) {
        this.friend1 = friend1;
    }

    public String getFriend2() {
        return friend2;
    }

    public void setFriend2(String friend2) {
        this.friend2 = friend2;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return strength == that.strength &&
                Objects.equals(friend1, that.friend1) &&
                Objects.equals(friend2, that.friend2);
    }

}
