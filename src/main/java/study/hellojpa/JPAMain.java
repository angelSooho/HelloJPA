package study.hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.hellojpa.domian.Book;
import study.hellojpa.entity.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

//@Component
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

            Member member = new Member();
            member.setUsername("member");
            member.setAddress(new Address("home",  "street1", "10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street1", "10000"));
            member.getAddressHistory().add(new AddressEntity("old2", "street1", "10000"));

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            List<AddressEntity> addressHistory = findMember.getAddressHistory();
            System.out.println("addressHistory = " + addressHistory);

            for (AddressEntity address : addressHistory) {
                System.out.println("address = " + address.getAddress().getStreet());
            }

            Set<String> favoriteFoods = findMember.getFavoriteFoods();
            System.out.println("favoriteFoods = " + favoriteFoods);

            for (String favoriteFood : favoriteFoods) {
                System.out.println("favoriteFood = " + favoriteFood);
            }

            Address address = findMember.getAddress();
            findMember.setAddress(new Address("new City", address.getStreet(), address.getZipcode()));

            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            // tx.commit();
            System.out.println("===================z=============================================================================");
        } catch (Exception e) {
//            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
