package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em; // 스프링이 엔티티 매니저를 만들어서 em에 주입

    public void save(Member member){
        em.persist(member);
    } // 회원을 em.persist해서 넣으면 jpa가 저장하는 로직

    public Member findOne(Long id){
        return em.find(Member.class, id);
        // 첫번째가 Type (Member.class), 두번째가 PK(id).
        // jpa가 제공하는 find 메서드
    } // 조회하는 메서드.

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }


    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
