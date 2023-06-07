package study.hellojpa;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.jpql.Member;
import study.hellojpa.jpql.Team;

import java.util.Collection;
import java.util.List;

@Component
public class JpqlMain {

//    private static EntityManagerFactory emf;
//    private static EntityManager em = emf.createEntityManager("hello");

    @PersistenceContext
    private EntityManager em;

    @Bean
    @Transactional
    public void runJpql() {

        try {
            System.out.println("========================================Main===================================================");
//            EntityTransaction tx = em.getTransaction();
//            tx.begin();

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Team teamC = new Team();
            teamC.setName("teamC");
            em.persist(teamC);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(10);
            member1.changeTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(10);
            member2.changeTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(10);
            member3.changeTeam(teamB);
            em.persist(member3);

//            em.flush();
//            em.clear();

            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            em.clear();

            Member findMember = em.find(Member.class, member1.getId());

            System.out.println("findMember = " + findMember.getAge());
            System.out.println("resultCount = " + resultCount);

            // tx.commit();
            System.out.println("===============================================================================================");
        } catch (Exception e) {
//            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
