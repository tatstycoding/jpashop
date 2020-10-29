package jpabook.jpashop.domain;


import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.DeleiverStatus;
import jpabook.jpashop.domain.Order;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")

    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ORDINAL이 디폴트인데 숫자가 문자 아닌 숫자로 들어간다// 고로 STRING으로 설정해야한다.
    private DeleiverStatus status //READY, COMP
}
