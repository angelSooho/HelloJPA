package study.hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.domian.Book;
import study.hellojpa.entity.Locker;
import study.hellojpa.entity.Member;

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
            System.out.println("================================================================================================");
//            EntityTransaction tx = em.getTransaction();
//            tx.begin();

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member.getId());
            System.out.println("refMember = " + refMember.getClass()); // Proxy

            Hibernate.initialize(refMember);

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
