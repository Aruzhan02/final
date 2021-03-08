package com.company;
import java.sql.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner in = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/project", "postgres", "0000");
            if (connection != null){
                stmt = connection.createStatement();
                //System.out.println("connected");
            }
            else {
                System.out.println("no connection");
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        while(true){
            try {

                Menu();
                int san = in.nextInt();
                in.nextLine();
                if (san == 1){
                    System.out.println("Enter your name: ");
                    String name = in.nextLine();
                    User user = new User();
                    user.setName(name);
                    System.out.println("Enter your phone number: ");
                    String phone_number = in.nextLine();
                    user.setPhone_number(phone_number);
                    PreparedStatement prst = connection.prepareStatement("insert into user1(user_name, user_number) values(?,?) ");
                    prst.setString(1,name);
                    prst.setString(2,phone_number);
                    prst.executeUpdate();
                    System.out.println("Choose a category:");
                    System.out.println("1: Children");
                    System.out.println("2: Adult");
                    san = in.nextInt();
                    if (san == 1){
                        rs = stmt.executeQuery("select * from movies where movie_category='Children'");
                        while(rs.next()){
                            System.out.println("Movie_id:" + rs.getInt("movie_id") + '\t' +" Name: " + rs.getString("movie_name") + '\t' + " Country: " + rs.getString("movie_country") + '\t' + " Category: " + rs.getString("movie_category") + '\t' + " Genre: " + rs.getString("movie_genre") + '\t' + " Time: " + rs.getString("movie_time"));
                        }
                        int currentID = 0;
                        rs = stmt.executeQuery("select user_id from user1 where user1.user_id = user_id");
                        while (rs.next()) {
                            currentID = rs.getInt("user_id");
                        }
                        int currentIDMovie = 0;
                        rs = stmt.executeQuery("select movie_id from movies where movies.movie_id = movie_id");
                        while (rs.next()) {
                            currentIDMovie = rs.getInt("movie_id");
                        }
                        while (true) {
                            int selected = in.nextInt();
                            System.out.println("Inpur '-1' as soon as you finish booking.");
                            if (selected == -1) {
                                System.out.println("Choose a city: ");
                                rs = stmt.executeQuery("select * from city");
                                while(rs.next()){
                                    System.out.println("City_ID: " + rs.getString("city_id") + '\t' + " Name of the city: " + rs.getString("city_name"));
                                }
                                int chooseCity = in.nextInt();
                                String chooseCity1 = "";
                                in.nextLine();
                                if(chooseCity == 1){
                                    chooseCity1 = "Atyrau";
                                }
                                else if(chooseCity == 2){
                                    chooseCity1 = "Almaty";
                                }
                                else if(chooseCity == 3){
                                    chooseCity1 = "Astana";
                                }
                                else if(chooseCity == 4){
                                    chooseCity1 = "Shymkent";
                                }
                                else if(chooseCity == 5){
                                    chooseCity1 = "Semey";
                                }
                                System.out.println("Choose a cinema");
                                rs = stmt.executeQuery("select * from cinema");
                                while(rs.next()){
                                    System.out.println("Cinema_ID: " + rs.getString("cinema_id") + '\t' + " Name of the cinema: " + rs.getString("cinema_name"));
                                }
                                int chooseCinema = in.nextInt();
                                in.nextLine();
                                String chooseCinema1 = "";
                                if(chooseCinema == 1){
                                    chooseCinema1 = "Arsenal";
                                }
                                else if(chooseCinema == 2){
                                    chooseCinema1 = "Kinoplex";
                                }
                                else if(chooseCinema == 3){
                                    chooseCinema1 = "Chaplin";
                                }
                                else if(chooseCinema == 4){
                                    chooseCinema1 = "Keruen";
                                }
                                else if(chooseCinema == 5){
                                    chooseCinema1 = "Arman";
                                }
                                PreparedStatement prst2 = connection.prepareStatement("");
                                System.out.println("The reservation confirmed!" );
                                System.out.println("The chosen city is " + chooseCity1);
                                System.out.println("The chosen cinema is " + chooseCinema1);
                                System.out.println("Your unique ID is " + currentID + ". Please use it to check your reservation.");
                                break;
                            }
                            PreparedStatement prst1 = connection.prepareStatement("insert into reservation(user_id, movie_id) values (?, ?)");
                            prst1.setInt(1, currentID);
                            prst1.setInt(2, selected);
                            prst1.executeUpdate();
                        }
                    }
                    else if(san == 2){
                        rs = stmt.executeQuery("select * from movies where movie_category='Adult'");
                        while(rs.next()){
                            System.out.println("Movie_id:" + rs.getInt("movie_id") + '\t' +" Name: " + rs.getString("movie_name") + '\t' + " Country: " + rs.getString("movie_country") + '\t' + " Category: " + rs.getString("movie_category") + '\t' + " Genre: " + rs.getString("movie_genre") + '\t' + " Time: " + rs.getString("movie_time"));
                        }
                        int currentID = 0;
                        rs = stmt.executeQuery("select user_id from user1 where user1.user_id = user_id");
                        while (rs.next()) {
                            currentID = rs.getInt("user_id");
                        }
                        int currentIDMovie = 0;
                        rs = stmt.executeQuery("select movie_id from movies where movies.movie_id = movie_id");
                        while (rs.next()) {
                            currentIDMovie = rs.getInt("movie_id");
                        }
                        while (true) {
                            int selected = in.nextInt();
                            if (selected == -1) {
                                System.out.println("Choose a city: ");
                                rs = stmt.executeQuery("select * from city");
                                while(rs.next()){
                                    System.out.println("City_ID: " + rs.getString("city_id") + '\t' + " Name of the city: " + rs.getString("city_name"));
                                }
                                int chooseCity = in.nextInt();
                                String chooseCity1 = "";
                                in.nextLine();
                                if(chooseCity == 1){
                                    chooseCity1 = "Atyrau";
                                }
                                else if(chooseCity == 2){
                                    chooseCity1 = "Almaty";
                                }
                                else if(chooseCity == 3){
                                    chooseCity1 = "Astana";
                                }
                                else if(chooseCity == 4){
                                    chooseCity1 = "Shymkent";
                                }
                                else if(chooseCity == 5){
                                    chooseCity1 = "Semey";
                                }
                                System.out.println("Choose a cinema");
                                rs = stmt.executeQuery("select * from cinema");
                                while(rs.next()){
                                    System.out.println("Cinema_ID: " + rs.getString("cinema_id") + '\t' + " Name of the cinema: " + rs.getString("cinema_name"));
                                }
                                int chooseCinema = in.nextInt();
                                in.nextLine();
                                String chooseCinema1 = "";
                                if(chooseCinema == 1){
                                    chooseCinema1 = "Arsenal";
                                }
                                else if(chooseCinema == 2){
                                    chooseCinema1 = "Kinoplex";
                                }
                                else if(chooseCinema == 3){
                                    chooseCinema1 = "Chaplin";
                                }
                                else if(chooseCinema == 4){
                                    chooseCinema1 = "Keruen";
                                }
                                else if(chooseCinema == 5){
                                    chooseCinema1 = "Arman";
                                }
                                PreparedStatement prst2 = connection.prepareStatement("");
                                System.out.println("The reservation confirmed!" );
                                System.out.println("The chosen city is " + chooseCity1);
                                System.out.println("The chosen cinema is " + chooseCinema1);
                                System.out.println("Your unique ID is " + currentID + ". Please use it to check your reservation.");
                                break;
                            }
                            PreparedStatement prst1 = connection.prepareStatement("insert into reservation(user_id, movie_id) values (?, ?)");
                            prst1.setInt(1, currentID);
                            prst1.setInt(2, selected);
                            prst1.executeUpdate();
                        }
                    }
                }else if(san == 2){
                    System.out.println("Enter your ID: ");
                    int enteredID = in.nextInt();
                    ResultSet rss = stmt.executeQuery("select movie_name, movie_time from movies where movies.movie_id = (select movie_id from reservation where reservation.user_id = '"+enteredID+"')");
                    while(rss.next()){
                        System.out.println("Movie name: " + rss.getString("movie_name") + '\t' + " Date and Time: " + rss.getString("movie_time"));
                    }
                }
                else if(san == 3){
                    System.exit(0);
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    public static void Menu(){
        System.out.println("1: To book");
        System.out.println("2: To check reservation");
        System.out.println("3: Exit");
    }

}