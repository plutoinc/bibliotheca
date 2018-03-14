package network.pluto.bibliotheca.models.mag;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Joiner;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import network.pluto.bibliotheca.utils.JsonUtils;
import org.hibernate.annotations.BatchSize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.IOException;

@Slf4j
@Getter
@BatchSize(size = 10)
@Table(schema = "mcsa", name = "paper_abstract_inverted_index")
@Entity
public class PaperAbstract {

    @Id
    private long paperId;

    @Column
    private String invertedAbstract;

    public String getAbstract() {
        if (!StringUtils.hasText(this.invertedAbstract)) {
            return null;
        }

        InvertedAbstract invertedAbstract = InvertedAbstract.of(this.invertedAbstract);
        if (invertedAbstract == null) {
            return null;
        }

        return invertedAbstract.toAbstract();
    }

    @Getter
    public static class InvertedAbstract {

        @JsonProperty("IndexLength")
        private int length;

        @JsonProperty("InvertedIndex")
        private LinkedMultiValueMap<String, Integer> invertedIndex;

        public InvertedAbstract() {}

        public static InvertedAbstract of(String abstractJson) {
            if (!StringUtils.hasText(abstractJson)) {
                return null;
            }

            try {
                return JsonUtils.fromJson(abstractJson, InvertedAbstract.class);
            } catch (IOException e) {
                log.error("Fail to convert inverted abstract json", e);
                return null;
            }
        }

        public String toAbstract() {
            if (length == 0 || invertedIndex == null) {
                return null;
            }

            String[] abstractArray = new String[length];
            invertedIndex.keySet().forEach(key -> {
                invertedIndex.get(key).forEach(index -> {
                    if (index >= length) {
                        return;
                    }
                    abstractArray[index] = key;
                });
            });

            return Joiner.on(" ").skipNulls().join(abstractArray).trim();
        }
    }

}
