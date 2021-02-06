package facades;

import dtos.BankCustomerDTO;
import dtos.RenameMeDTO;
import entities.BankCustomer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class BankCustomerFacade {

    private static BankCustomerFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private BankCustomerFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static BankCustomerFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BankCustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public BankCustomerDTO create(BankCustomer bc){
        BankCustomer tmpBankCustomer = new BankCustomer(bc.getFirstName(), bc.getLastName());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(tmpBankCustomer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new BankCustomerDTO(bc);
    }
    public BankCustomerDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        return new BankCustomerDTO(em.find(BankCustomer.class, id));
    }
    
    public List<BankCustomer> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<BankCustomer> query = em.createQuery("SELECT b FROM BankCustomer b", BankCustomer.class);
        List<BankCustomer> rms = query.getResultList();
        return RenameMeDTO.getDtos(rms);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        BankCustomerFacade fe = getFacadeExample(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }

}
