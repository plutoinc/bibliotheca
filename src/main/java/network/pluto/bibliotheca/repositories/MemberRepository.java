package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberIdAndPassword(Long memberId, String password);
    Member findByEmail(String email);
}

