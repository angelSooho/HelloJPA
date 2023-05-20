package study.hellojpa.domian;

import jakarta.persistence.*;

@Entity
public class Delivery extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;


}
