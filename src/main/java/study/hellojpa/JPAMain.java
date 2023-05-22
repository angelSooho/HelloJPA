package study.hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.domian.Book;
import study.hellojpa.entity.*;

@Component
public class JPAMain {

//    private static EntityManagerFactory emf;
//    private static EntityManager em = emf.createEntityManager("hello");

    @PersistenceContext
    private EntityManager em;

    @Bean
    @Transactional
    public void runMain() {

        try {
            System.out.println("========================================Main===================================================");
//            EntityTransaction tx = em.getTransaction();
//            tx.begin();

            Address address =  new Address("city", "street", "10000");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAddress(address);
            em.persist(member1);

            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAddress(newAddress);
            em.persist(member2);

            Address address1 = new Address("city", "street", "10000");
            Address address2 = new Address("city", "street", "10000");

//            System.out.println("address1 == address2 : " + (address1 == address2));
            System.out.println("address1 equals address2 : " + (address1.equals(address2)));



            // tx.commit();
            System.out.println("================================================================================================");
        } catch (Exception e) {
//            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
