package com.example.springmysql.dao;

import com.example.springmysql.newModels.*;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class AllDAO {

    public Connection getConnections(){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }
        catch (Exception e){}
        return null;
    }

    private static final String url = "jdbc:mysql://localhost:3306/newKursach";
    private static final String user = "root";
    private static final String password = "12345678";
    public static Statement state;
    public <T> void add(T object) {
        Connection connection = getConnections();
        String query = "";
        int id = 1;
        try {
            Statement stateQuery = connection.createStatement();
            if (object.getClass() == Category.class) {
                Category a = (Category) object;
                String querySel = "SELECT categoryid FROM category ORDER BY categoryid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }

                query = "INSERT INTO `category`(`categoryid`, `category_name`, `age_limit`) VALUES " +
                        "('"+id+"','"+a.getCategoryName()+"','"+a.getAgeLimit()+"')";

            } else if (object.getClass() == User.class) {
                User a = (User) object;
                String querySel = "SELECT userid FROM user ORDER BY userid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `user`(`userid`, `user_login`, `user_password`, `email`, `balance`, `role`) VALUES " +
                        "('"+id+"','"+a.getUserLogin()+"','"+a.getUserPassword()+"','"+a.getEmail()+"',"+a.getBalance()+",'"+a.getRole()+"')";

            } else if (object.getClass() == Product.class) {
                Product a = (Product) object;
                String querySel = "SELECT productid FROM product ORDER BY productid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `product`(`productid`, `product_name`, `product_description`) VALUES " +
                        "('"+id+"','"+a.getProductName()+"','"+a.getProductDescription()+"')";

            } else if (object.getClass() == Ordering.class) {
                Ordering a = (Ordering) object;
                String querySel = "SELECT orderingid FROM ordering ORDER BY orderingid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `ordering`(`orderingid`, `ordering_number`) VALUES " +
                        "('"+id+"','"+a.getOrderingNumber()+"')";


            } else if (object.getClass() == Role.class) {
                Role a = (Role) object;
                String querySel = "SELECT roleid FROM role ORDER BY roleid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `role`(`roleid`, `role_name`) VALUES " +
                        "('"+id+"','"+a.getRoleName()+"')";


            } else if (object.getClass() == Benefit.class) {
                Benefit a = (Benefit) object;
                String querySel = "SELECT benefitid FROM benefit ORDER BY benefitid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `benefit`(`benefitid`, `benefit_name`, `benefit_discount`) VALUES " +
                        "('"+id+"','"+a.getBenefitName()+"','"+a.getBenefitDiscount()+"')";


            } else if (object.getClass() == Supplier.class) {
                Supplier a = (Supplier) object;
                String querySel = "SELECT supplierid FROM supplier ORDER BY supplierid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `supplier`(`supplierid`, `supplier_name`) VALUES " +
                        "('"+id+"','"+a.getSupplierName()+"')";


            } else if (object.getClass() == Feedback.class) {
                Feedback a = (Feedback) object;
                String querySel = "SELECT feedbackid FROM feedback ORDER BY feedbackid DESC";
                ResultSet resState = stateQuery.executeQuery(querySel);
                if (resState.next()) {
                    id = resState.getInt(1) + 1;
                }
                query = "INSERT INTO `feedback`(`feedbackid`, `feedback_text`) VALUES " +
                        "('"+id+"','"+a.getFeedbackText()+"')";


//            } else if (object.getClass() == People.class) {
//                People a = (People) object;
//                String querySel = "SELECT peopleid FROM people ORDER BY peopleid DESC";
//                ResultSet resState = stateQuery.executeQuery(querySel);
//                if (resState.next()) {
//                    id = resState.getInt(1) + 1;
//                }
//                query = "INSERT INTO `people`(`peopleid`, `email`, `full_name`, `person_age`, `person_birth`) VALUES " +
//                        "('"+id+"','"+a.getEmail()+"','"+a.getFullName()+"','"+a.getPersonAge()+"','"+a.getPersonBirth()+"')";


            }
            stateQuery.executeUpdate(query);
        } catch (SQLException e){
            Logger.getLogger("WARN").warning(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (Exception e){}
            Logger.getAnonymousLogger().info(query);
        }


    }
    public <T> void delete(T object) throws SQLException {
        Connection connection = getConnections();
        String query = "";
        if (object.getClass() == Category.class) {
            query = "DELETE FROM `category` WHERE 'categoryid' == "+((Category) object).getCategoryID();
        } else if (object.getClass() == User.class) {
            query = "DELETE FROM `user` WHERE 'userid' == "+((User) object).getUserID();
        } else if (object.getClass() == Product.class) {
            query = "DELETE FROM `product` WHERE 'productid' == "+((Product) object).getProductID();
        } else if (object.getClass() == Ordering.class) {
            query = "DELETE FROM `ordering` WHERE 'orderingid' == "+((Ordering) object).getOrderingID();


        } else if (object.getClass() == Role.class) {
            query = "DELETE FROM `role` WHERE 'roleid' == "+((Role) object).getRoleID();
        } else if (object.getClass() == Benefit.class) {
            query = "DELETE FROM `benefit` WHERE 'benefitid' == "+((Benefit) object).getBenefitID();
        } else if (object.getClass() == Supplier.class) {
            query = "DELETE FROM `supplier` WHERE 'supplierid' == "+((Supplier) object).getSupplierID();
        } else if (object.getClass() == Feedback.class) {
            query = "DELETE FROM `feedback` WHERE 'feedbackid' == "+((Feedback) object).getFeedbackID();


//        } else if (object.getClass() == People.class) {
//            query = "DELETE FROM `people` WHERE 'peopleid' == "+((People) object).getPeopleID();

        }
        Statement stateQuery = connection.createStatement();
        stateQuery.executeUpdate(query);
        connection.close();
        Logger.getAnonymousLogger().info(query);
    }
    public <T> void update(T object) throws SQLException {
        Connection connection = getConnections();
        String query = "";
        if (object.getClass() == Category.class) {

        } else if (object.getClass() == User.class) {

        } else if (object.getClass() == Product.class) {

        } else if (object.getClass() == Ordering.class) {



        } else if (object.getClass() == Role.class) {

        } else if (object.getClass() == Supplier.class) {

        } else if (object.getClass() == Benefit.class) {

        } else if (object.getClass() == Feedback.class) {

//        } else if (object.getClass() == People.class) {

        }
        Statement stateQuery = connection.createStatement();
        stateQuery.executeUpdate(query);
        connection.close();
        Logger.getAnonymousLogger().info(query);
    }
    public <T> List<Object> get(T object) throws SQLException {
        Connection connection = getConnections();
        String query = "";
        List<Object> objs = new ArrayList<>();
        if(object.getClass() == Category.class){
            query = "SELECT `categoryid`, `category_name`, `age_limit` from `category`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Category(set.getInt(1),
                        set.getString(2),
                        set.getString(3)));
            }
        }

        else if (object.getClass() == User.class){
            query = "SELECT `userid`, `user_login`, `user_password`, `email`, `balance`, `role`  from `user`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new User(set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getInt(5),
                        set.getString(6)));
            }
        }

        else if (object.getClass() == Product.class){
            query = "SELECT `productid`, `product_name`, `product_description` from `product`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Product(set.getInt(1),
                        set.getString(2),
                        set.getString(3)));
            }
        }

        else if (object.getClass() == Ordering.class){
            query = "SELECT `orderingid`, `ordering_number` from `ordering`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Ordering(set.getInt(1),
                        set.getString(2)));
            }
        }




        else if (object.getClass() == Role.class){
            query = "SELECT `roleid`, `role_name` from `role`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Role(set.getInt(1),
                        set.getString(2)));
            }
        }

        else if (object.getClass() == Supplier.class){
            query = "SELECT `supplierid`, `supplier_name` from `supplier`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Supplier(set.getInt(1),
                        set.getString(2)));
            }
        }

        else if (object.getClass() == Benefit.class){
            query = "SELECT `benefitid`, `benefit_name`, `benefit_discount` from `benefit`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Benefit(set.getInt(1),
                        set.getString(2),
                        set.getInt(3)));
            }
        }

        else if (object.getClass() == Feedback.class){
            query = "SELECT `feedbackid`, `feedback_text` from `feedback`";
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                objs.add(new Feedback(set.getInt(1),
                        set.getString(2)));
            }
        }

//        else if (object.getClass() == People.class){
//            query = "SELECT `peopleid`, `email`, `full_name`, `person_age`, `person_birth` from `people`";
//            Statement stateQuery = connection.createStatement();
//            ResultSet set = stateQuery.executeQuery(query);
//            while (set.next()){
//                objs.add(new People(set.getInt(1),
//                        set.getString(3),
//                        set.getInt(4),
//                        set.getString(2),
//                        set.getString(5)));
//            }
//        }

        connection.close();
        Logger.getAnonymousLogger().info(query);
        return objs;
    }

    public <T> Object get(int id,T object) throws SQLException {
        Connection connection = getConnections();
        String query = "";
        Object obj = new Object();

        if(object.getClass() == Category.class){
            query = "SELECT `categoryid`, `category_name`, `age_limit` from `category` where categoryid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = new Category(set.getInt(1),
                        set.getString(2),
                        set.getString(3));
            }
        }

        else if (object.getClass() == User.class){
            query = "SELECT `userid`, `user_login`, `user_password`, `email`, `balance`, `role` from `user` where userid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = (new User(set.getInt(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getInt(5),
                        set.getString(6)));
            }
        }

        else if (object.getClass() == Product.class){
            query = "SELECT `productid`, `product_name`, `product_description` from `product` where productid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj =(new Product(set.getInt(1),
                        set.getString(2),
                        set.getString(3)));
            }
        }

        else if (object.getClass() == Ordering.class){
            query = "SELECT `orderingid`, `ordering_number` from `ordering` where orderingid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = (new Ordering(set.getInt(1),
                        set.getString(2)));
            }
        }



        else if (object.getClass() == Role.class){
            query = "SELECT `roleid`, `role_name` from `role` where roleid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = (new Role(set.getInt(1),
                        set.getString(2)));
            }
        }

        else if (object.getClass() == Supplier.class){
            query = "SELECT `supplierid`, `supplier_name` from `supplier` where supplierid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = (new Supplier(set.getInt(1),
                        set.getString(2)));
            }
        }

        else if (object.getClass() == Benefit.class){
            query = "SELECT `benefitid`, `benefit_name`, `benefit_discount` from `benefit` where benefitid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = (new Benefit(set.getInt(1),
                        set.getString(2),
                        set.getInt(3)));
            }
        }

        else if (object.getClass() == Feedback.class){
            query = "SELECT `feedbackid`, `feedback_text` from `feedback` where feedbackid = "+id;
            Statement stateQuery = connection.createStatement();
            ResultSet set = stateQuery.executeQuery(query);
            while (set.next()){
                obj = (new Feedback(set.getInt(1),
                        set.getString(2)));
            }
        }

//        else if (object.getClass() == People.class){
//            query = "SELECT `peopleid`, `email`, `full_name`, `person_age`, `person_birth` from `people` where peopleid = "+id;
//            Statement stateQuery = connection.createStatement();
//            ResultSet set = stateQuery.executeQuery(query);
//            while (set.next()){
//                obj = (new People(set.getInt(1),
//                        set.getString(3),
//                        set.getInt(4),
//                        set.getString(2),
//                        set.getString(5)));
//            }
//        }

        Logger.getAnonymousLogger().info(query);
        connection.close();
        return obj;
    }
}
