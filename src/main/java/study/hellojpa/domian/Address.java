//package study.hellojpa.domian;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//import java.util.Objects;
//
//@Embeddable
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Address {
//
//    @Column(length = 10)
//    private String city;
//    @Column(length = 20)
//    private String street;
//    @Column(length = 5)
//    private String zipcode;
//
//    public String fullAddress() {
//        return getCity() + " " + getStreet() + " " + getZipcode();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Address address = (Address) o;
//        return Objects.equals(getCity(), address.getCity()) &&
//                Objects.equals(getStreet(), address.getStreet()) &&
//                Objects.equals(getZipcode(), address.getZipcode());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getCity(), getStreet(), getZipcode());
//    }
//}
