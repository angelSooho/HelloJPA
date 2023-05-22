package study.hellojpa.domian;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import study.hellojpa.entity.Team;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @Embedded
    private Address address;
}
