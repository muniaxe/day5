/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.BankCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class BankCustomerDTO {
    private long id;
    private String firstName;
    private String lastName;

    public BankCustomerDTO(String dummyStr1, String dummyStr2) {
        this.firstName = dummyStr1;
        this.lastName = dummyStr2;
    }
    
    public static List<BankCustomerDTO> getDtos(List<BankCustomer> rms){
        List<BankCustomerDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new BankCustomerDTO(rm)));
        return rmdtos;
    }


    public BankCustomerDTO(BankCustomer bc) {
        this.id = bc.getId();
        this.firstName = bc.getFirstName();
        this.lastName = bc.getLastName();
    }

    public String getDummyStr1() {
        return firstName;
    }

    public void setDummyStr1(String firstName) {
        this.firstName = firstName;
    }

    public String getDummyStr2() {
        return lastName;
    }

    public void setDummyStr2(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "BankCustomerDTO{" + "id=" + id + ", str1=" + firstName + ", str2=" + lastName + '}';
    }
    
    
    
    
    
    
}
