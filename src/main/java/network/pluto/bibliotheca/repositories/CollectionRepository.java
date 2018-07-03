package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Collection;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
    Page<Collection> findByCreatedByOrderByCreatedAtDesc(Member creator, Pageable pageable);
}
