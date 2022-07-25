package com.example.index_market.entity.product;

import com.example.index_market.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Detail extends Auditable {
    private String nameUz;
    private String nameRu;

    public Detail(String id, String nameUz, String nameRu) {
        super(id);
        this.nameUz = nameUz;
        this.nameRu = nameRu;
    }
}
