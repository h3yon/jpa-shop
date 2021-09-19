package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /**
     * self로 매핑
     */
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),  //내가 조인해야 되고
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID") //반대쪽에서 조인해야되는 부분
    )
    private List<Item> items = new ArrayList<>();
}
