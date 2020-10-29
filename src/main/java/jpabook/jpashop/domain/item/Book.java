package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")//싱글테이블이니 저장할때 구분되어야한다. 이 어노테이션으로 구분
@Getter
@Setter
public class Book extends Item{

    private String author;

    private String isbn;


}
