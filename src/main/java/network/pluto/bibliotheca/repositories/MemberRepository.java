package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}

