package study.hellojpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.entity.*;
import study.hellojpa.jpql.Member;
import study.hellojpa.jpql.MemberDto;

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

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();

            // 반환 타입이 명확할 때 사용
            List<Member> resultList = em.createQuery("select m from Member m where m.username = :username", Member.class) //  where m.id = 10
                    .setParameter("username", "member1").getResultList();
            // 반환 타입이 명확하지 않을 때 사용
            List<MemberDto> list = em.createQuery("select new study.hellojpa.jpql.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                    .getResultList();

            MemberDto memberDto = list.get(0);
            System.out.println("username = " + memberDto.getUsername());
            System.out.println("age = " + memberDto.getAge());


//            Member singleResult = query1.getSingleResult();
//            System.out.println("singleResult = " + singleResult);

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
