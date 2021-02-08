package facades;

import entities.BankCustomer;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        BankCustomerFacade fe = BankCustomerFacade.getFacadeExample(emf);
        fe.create(new BankCustomer("First 1", "Last 1"));
        fe.create(new BankCustomer("First 2", "Last 2"));
        fe.create(new BankCustomer("First 3", "Last 3"));
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
