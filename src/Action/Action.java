/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Action;


import java.util.List;
import DATA.ActionProduct;
import DATA.Product;
import DATA.User;


/**
 *
 * @author ADMIN
 */
public class Action {
    private ActionProduct actionProduct;
    
    public Action(){
        actionProduct=new ActionProduct();
    }
    
    public List<Product> getallProducts(){
        return actionProduct.getallProducts();
    }
    
    public void addProduct(Product product){
        actionProduct.addProduct(product);
    }
    public void addUser(User user){
        actionProduct.addUser(user);
    }
    public void deleteProduct(int IdProduct){
        actionProduct.deleteProduct(IdProduct);
    }
    public void UpdateProduct(Product product){
        actionProduct.UpdateProduct(product);
    }
    
    public Product getProductById(int IdProduct){
        return actionProduct.getProductById(IdProduct);
    }
}
