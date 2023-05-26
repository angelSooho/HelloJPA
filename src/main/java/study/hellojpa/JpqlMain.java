package study.hellojpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.jpql.Member;
import study.hellojpa.jpql.MemberDto;
import study.hellojpa.jpql.Team;

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

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자");
            member.setAge(10);
            member.changeTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            String query =
                    "select " +
                    "case " +
                        "when m.age <= 10 then '학생요금' " +
                        "when m.age >= 60 then '경로요금' " +
                        "else '일반요금' end" +
                    " from Member m";

            String query2 = "select coalesce(m.username, '이름 없는 회원') from Member m";
            String query3 = "select nullif(m.username, '관리자') from Member m";
            String query4 = "select function('group_concat', m.username) from Member m";


            List<String> resultList = em.createQuery(query3, String.class)
                    .getResultList();

            for (String s : resultList) {
                System.out.println("s = " + s);
            }


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
