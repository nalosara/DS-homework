package main.java.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        SocialNetwork socialNetwork = null;

        try {
            Scanner fileScanner = new Scanner(new File("social_network.csv"));
            socialNetwork = new SocialNetwork(fileScanner);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure the file 'social_network.csv' is present.");
            return;
        }

        System.out.println("Social Network loaded.");
        System.out.println("Total users: " + socialNetwork.getV());
        System.out.println("Total friendships: " + socialNetwork.getE());
        System.out.println("=================================");

        while (true) {
            System.out.print("Enter a name to recommend friends to (or type -1 to exit): ");
            String name = console.nextLine();

            if (name.equals("-1")) {
                System.out.print("Thank you for using out friendship recommender algorithm.");
                break;
            }

            if (socialNetwork.hasUser(name)) {
                ArrayList<FriendshipRecommendation> recommendations = socialNetwork.recommendFriends(name);
                System.out.println("Total number of recommendations: " + recommendations.size());

                System.out.println("Top 10 recommendations based on friendship strength:");

                for (int i = 0; i < Math.min(10, recommendations.size()); i++) {
                    FriendshipRecommendation recommendation = recommendations.get(i);
                    System.out.println(recommendation.getUser() + ": " + recommendation.getRecommendationStrength());
                }
            } else {
                System.out.println("The user you are looking for does not exist in the network.");
            }
        }

        console.close();
    }
}
