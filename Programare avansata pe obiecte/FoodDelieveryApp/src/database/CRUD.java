package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    private static Connection connection = MySqlConn.getInstance().getConnection();
    public static List<List<String>> getRestaurants(){
        String sql = "SELECT * FROM restaurant";
        try{
            Statement statement = connection.createStatement();
            ResultSet restaurants = statement.executeQuery(sql);
            List<List<String>> result = new ArrayList<>();
            while (restaurants.next()){
                List <String> restaurant = new ArrayList<>();
                String restName = restaurants.getString(2);
                String restAdr = restaurants.getString(3);
                restaurant.add(restName);
                restaurant.add(restAdr);
                result.add(restaurant);
            }
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> getFoods(){
        String sql = "SELECT * FROM food";
        try{
            Statement statement = connection.createStatement();
            ResultSet foods = statement.executeQuery(sql);
            List<List<String>> result = new ArrayList<>();
            while (foods.next()){
                List <String> food = new ArrayList<>();
                String restName = foods.getString(2);
                String foodName = foods.getString(3);
                String desc = foods.getString(4);
                String price = foods.getString(5);
                String quantity = foods.getString(6);
                String ingredients = foods.getString(7);

                food.add(restName);
                food.add(foodName);
                food.add(desc);
                food.add(price);
                food.add(quantity);
                food.add(ingredients);

                result.add(food);
            }
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> getBeverages(){
        String sql = "SELECT * FROM beverage";
        try{
            Statement statement = connection.createStatement();
            ResultSet beverages = statement.executeQuery(sql);
            List<List<String>> result = new ArrayList<>();
            while (beverages.next()){
                List <String> beverage = new ArrayList<>();
                String restName = beverages.getString(2);
                String beverageName = beverages.getString(3);
                String desc = beverages.getString(4);
                String price = beverages.getString(5);
                String quantity = beverages.getString(6);

                beverage.add(restName);
                beverage.add(beverageName);
                beverage.add(desc);
                beverage.add(price);
                beverage.add(quantity);

                result.add(beverage);
            }
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> getUsers(){
        String sql = "SELECT * FROM user";
        try{
            Statement statement = connection.createStatement();
            ResultSet users = statement.executeQuery(sql);
            List<List<String>> result = new ArrayList<>();
            while (users.next()){
                List <String> user = new ArrayList<>();
                String name = users.getString(2);
                String email = users.getString(3);
                String password = users.getString(4);
                String phone = users.getString(5);
                String address = users.getString(6);

                user.add(name);
                user.add(email);
                user.add(password);
                user.add(phone);
                user.add(address);

                result.add(user);
            }
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<List<String>> getDrivers(){
        String sql = "SELECT * FROM driver";
        try{
            Statement statement = connection.createStatement();
            ResultSet foods = statement.executeQuery(sql);
            List<List<String>> result = new ArrayList<>();
            while (foods.next()){
                List <String> driver = new ArrayList<>();
                String name = foods.getString(2);
                String phone = foods.getString(3);
                String salary = foods.getString(4);
                String carName = foods.getString(5);
                String carNumber = foods.getString(6);
                String email = foods.getString(7);

                driver.add(name);
                driver.add(email);
                driver.add(phone);
                driver.add(salary);
                driver.add(carName);
                driver.add(carNumber);

                result.add(driver);
            }
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static boolean addUser(String name, String email, String password, String phoneNumber, String userAddress){
        try {
            String sql = "INSERT INTO user (name, email, password, phone, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, phoneNumber);
            statement.setString(5, userAddress);
            int rows = statement.executeUpdate();
            if(rows > 0){
                System.out.println("Registered succesfully.");
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public static void addFood(String restName, String prodName, String prodDesc, int price, int g, String ing){
        try {
            String sql = "INSERT INTO food (restaurant_name, food_name, description, price, quantity, ingredients) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, restName);
            statement.setString(2, prodName);
            statement.setString(3, prodDesc);
            statement.setInt(4, price);
            statement.setInt(5, g);
            statement.setString(6, ing);
            int rows = statement.executeUpdate();
            if(rows > 0){
                System.out.println("Food added succesfully.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addBeverage(String restName, String prodName, String prodDesc, int price, int ml){
        try {
            String sql = "INSERT INTO beverage (restaurant_name, beverage_name, description, price, quantity) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, restName);
            statement.setString(2, prodName);
            statement.setString(3, prodDesc);
            statement.setInt(4, price);
            statement.setInt(5, ml);
            int rows = statement.executeUpdate();
            if(rows > 0){
                System.out.println("Beverage added succesfully.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addDriver(String name, String email, String phoneNumber, double salary, String carName, String carNumber){
        try {
            String sql = "INSERT INTO driver (driver_name, phone, salary, car_name, car_number, driver_email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setDouble(3, salary);
            statement.setString(4, carName);
            statement.setString(5, carNumber);
            statement.setString(6, email);
            int rows = statement.executeUpdate();
            if(rows > 0){
                System.out.println("Driver added succesfully.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void writeAction(String actionName){
        try {
            String sql = "INSERT INTO audit (action_name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, actionName);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
