package study.hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.domian.Book;
import study.hellojpa.entity.Child;
import study.hellojpa.entity.Parent;

@Component
public class JPATest {

//    private static EntityManagerFactory emf;
//    private static EntityManager em = emf.createEntityManager("hello");

    @PersistenceContext
    private EntityManager em;

    @Bean
    @Transactional
    public void runTest() {

        try {
            System.out.println("===========================================Test=================================================");
//            EntityTransaction tx = em.getTransaction();
//            tx.begin();

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

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
