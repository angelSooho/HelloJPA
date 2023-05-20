package study.hellojpa;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.domian.Book;

@Component
public class JPAMain {

//    private static EntityManagerFactory emf;
//    private static EntityManager em = emf.createEntityManager("hello");

    @PersistenceContext
    private EntityManager em;

    @Bean
    @Transactional
    public void run() {

        try {
//            EntityTransaction tx = em.getTransaction();
//            tx.begin();

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

        }  catch (Exception e) {
//            tx.rollback();
        } finally {
            em.close();
        }
    }
}
