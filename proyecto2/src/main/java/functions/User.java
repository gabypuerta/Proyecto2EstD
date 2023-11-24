/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

import java.util.Arrays;


public class User {
    private String username;
    private String priority;
    private Document fDocmuent;
    private User next;
    
    public User(String u, String p){
        this.username = u;
        this.priority = p;
        this.fDocmuent = null;
        
    }
    public void insert(User user){
        User us = this;
        while(us.getNext()!= null){
                us = us.getNext();
            }
        us.setNext(user);
    }
    public void add_document(String t, int s, String y, int c){
        Document aux =  new Document(t,s,y,c);
        if(this.getfDocmuent()==null){
            this.setfDocmuent(aux);
        }else{
            Document doc = this.getfDocmuent();
            while(doc.getNext()!= null){
                doc = doc.getNext();
            }
            doc.setNext(aux);
        }
                
    }
    
    public void send_to_printer(Document doc, BinaryHeap printer){
        printer.insert(doc);
        System.out.println("AÑADIDO EXITOSAMENTE A LA COLA DE IMPRESIÓN");
    }
    
    public String print_docs(){
        String docs = "";
        Document doc = this.getfDocmuent();
        while(doc != null){
            String send = "";
            if(doc.isEnviado()){
                    send = "En cola";
                }
                docs += "       " + doc.getTitle() + " "+doc.getType() + ": " + send + "\n";
                doc = doc.getNext();
            }
        return docs;
    }
    
    public String print(String users){
        User us = this;
        while(us!= null){
            users += "Username: " + us.getUsername() + "- Prioridad: " + us.getPriority() + "\n";
            us = us.getNext();
        }
        return users;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the fDocmuent
     */
    public Document getfDocmuent() {
        return fDocmuent;
    }

    /**
     * @param fDocmuent the fDocmuent to set
     */
    public void setfDocmuent(Document fDocmuent) {
        this.fDocmuent = fDocmuent;
    }

    /**
     * @return the next
     */
    public User getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(User next) {
        this.next = next;
    }
    

}
