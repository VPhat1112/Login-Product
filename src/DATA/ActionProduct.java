/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DATA;

import Connection.ConnectionJDBC;
import Login.Signin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DATA.Product;

/**
 *
 * @author ADMIN
 */
public class ActionProduct {
    public Product getProductById(int IdProduct){
        Connection connection=ConnectionJDBC.getJDBCConnection();
        String sql="SELECT * FROM product where idProduct=?";
        try{
            
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, IdProduct);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                Product product=new Product();
                product.setIdProduct(rs.getInt("IdProduct"));
                product.setName(rs.getString("NameProduct"));
                product.setQuantity(rs.getInt("Quantity"));
                
                return product;
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return null;
    }
    public List<Product> getallProducts(){
        List<Product> Products= new ArrayList<Product>();
        Connection connection=ConnectionJDBC.getJDBCConnection();
        String sql="SELECT * FROM product";
        try{
            
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                Product product=new Product();
                product.setIdProduct(rs.getInt("IdProduct"));
                product.setName(rs.getString("NameProduct"));
                product.setQuantity(rs.getInt("Quantity"));
                
                Products.add(product);
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return Products;
    }
    public void addUser(User user){
        Connection connection = ConnectionJDBC.getJDBCConnection();
        String sql="Insert into User1(NameUser,Password) VALUES(?,?)";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           
           preparedStatement.setString(1, user.getUserName());
           preparedStatement.setString(2, user.getPassword());
           
           int rs=preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void addProduct(Product product){
        Connection connection = ConnectionJDBC.getJDBCConnection();
        String sql="Insert into product(NameProduct,Quantity) VALUES(?,?)";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           
           preparedStatement.setString(1, product.getName());
           preparedStatement.setInt(2, product.getQuantity());
           
           int rs=preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void deleteProduct(int IdProduct){
        Connection connection = ConnectionJDBC.getJDBCConnection();
         String sql="delete from product where IdProduct = ?";
         try {
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setInt(1, IdProduct);
             int rs=preparedStatement.executeUpdate();
             System.out.println(rs);
         }catch (SQLException e){
                e.printStackTrace();
        }
    }
    public void UpdateProduct(Product product){
        Connection connection = ConnectionJDBC.getJDBCConnection();
        String sql="UPDATE product SET NameProduct=?,Quantity=? WHERE IdProduct=? ";
        try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, product.getName());
           preparedStatement.setInt(2, product.getQuantity());
        
           preparedStatement.setString(3,String.valueOf(product.getIdProduct()));
           
           
           int rs=preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch (SQLException e){
                e.printStackTrace();
        }
    }
}
