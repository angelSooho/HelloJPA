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

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);

            // tx.commit();
            System.out.println("================================================================================================");
        }  catch (Exception e) {
//            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}