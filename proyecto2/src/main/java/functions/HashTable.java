/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author victoriagarcia
 */

import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class HashTable {
    
    private User[] users;
    private int size;
    private int total;
    
    public HashTable(){
        this.users = new User[999];
        this.size = 999;
        total = 0;
        for (int i = 0; i < size; i++) {
            this.users[i] = null;
        }
    }
    
    public int hashFunction(String username){
        int n = 11;
        int index = 0;
        for (int i = 0; i < username.length(); i++) {      
            index = n*index + username.charAt(i); 
            if (index< 0){
                index*=-1;
            };
        }
//      System.out.println(index);
        index = index%998;
        return index;
    }
    
    public void insert_is(User user){
        int index = hashFunction(user.getUsername());
        if(this.getUsers()[index]== null){
            this.getUsers()[index] = user;
            setTotal(getTotal() + 1);
        }else{
            if (getTotal() == getSize()){
                System.out.println("Numero máximo de usuarios alcanzado");
            }else{
                this.getUsers()[index].insert(user);
            
            }
        }
    }
    
    public void insert(String username, String priority){
        User user = new User(username, priority);
        int index = hashFunction(username);
        if(this.getUsers()[index]== null){
            this.getUsers()[index] = user;
            setTotal(getTotal() + 1);
        }else{
            if (getTotal() == getSize()){
                System.out.println("Numero máximo de usuarios alcanzado");
            }else{
                this.getUsers()[index].insert(user);
            
            }
        }
    }
    
    public User search(String username){
        int hash = hashFunction(username);
        if(this.getUsers()[hash]!= null && this.getUsers()[hash].getUsername().equals(username)){
            return this.getUsers()[hash];
        }else{
            User us = this.getUsers()[hash];
            while(us != null && !us.getUsername().equals(username)){
                us = us.getNext();
            }
            return us;
        }
        
    }
    
    public void print(){
        for (int i = 0; i < getSize(); i++) {
            if(this.getUsers()[i] != null){
                this.getUsers()[i].print("");
            }
        }
    }
    
    public void delete(String username){
        int hash = hashFunction(username);
        if(this.getUsers()[hash] != null && this.getUsers()[hash].getUsername().equals(username)){
            this.getUsers()[hash] = new User("", "");
        }else{
            User us = this.getUsers()[hash];
            while(us.getNext() != null && !us.getNext().getUsername().equals(username)){
                us = us.getNext();
            }
            if(us!=null){
                us.setNext(us.getNext().getNext());
            }
        }
        

    }
    
    public boolean delete_document(User usuario, String title){
        
        if(usuario!= null){
            Document doc = usuario.getfDocmuent();
            if(doc != null && doc.getTitle().equals(title)){
                usuario.setfDocmuent(usuario.getfDocmuent().getNext());
                return true;
            }
            while(doc.getNext() != null && !doc.getNext().getTitle().equals(title)){
                doc = doc.getNext();
            }
            if(doc!= null && doc.getNext().getTitle().equals(title)){
                doc.setNext(doc.getNext().getNext());
                return true;
            }else{
                return false;
            }}else{
            return false;
        }
        
    }
    
    public Document search_document(String username, String title){
        User user = search(username);
        if (user!= null){
            Document doc = user.getfDocmuent();
            
            while(doc != null && !doc.getTitle().equals(title)){
                doc = doc.getNext();
            }
            return doc;
        }
        return null;
    }
    
    public String print_users(String print){
        for (int i = 0; i < getSize(); i++) {
            if(getUsers()[i] != null){
                print = getUsers()[i].print(print);
                print += getUsers()[i].print_docs();
            }
        }
        return print;
    }

    /**
     * @return the users
     */
    public User[] getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(User[] users) {
        this.users = users;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
}


