package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
