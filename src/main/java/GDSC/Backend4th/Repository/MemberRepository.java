package GDSC.Backend4th.Repository;

import GDSC.Backend4th.domain.member.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    /**
     *
     * @param id
     * 한명 조회
     * @return
     */
    public Member findOne(Long id){
        return em.find(Member.class,id);
    }

    /**
     * 전체 조회
     * @return
     */
    public List<Member> findAll(){
        return em.createQuery("select m from Member As m", Member.class).getResultList();
    }

    /**
     *
     * @param userId
     * UserId로 멤버 찾기
     * NUll 값 반환 Optional 사가
     * @return
     */
    public Optional<Member> findByUserId(String userId){
        return findAll().stream()
                .filter(m -> m.getUserId().equals(userId))
                .findFirst();
    }
}
