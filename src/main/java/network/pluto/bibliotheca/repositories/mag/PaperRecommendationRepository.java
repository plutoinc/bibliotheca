package network.pluto.bibliotheca.repositories.mag;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import network.pluto.bibliotheca.models.mag.PaperRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@XRayEnabled
public interface PaperRecommendationRepository extends JpaRepository<PaperRecommendation, PaperRecommendation.PaperRecommendationId> {
    List<PaperRecommendation> findTop5ByPaperIdOrderByScoreDesc(long paperId);
}
