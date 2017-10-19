package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByMember_MemberId(long memberId);
}
