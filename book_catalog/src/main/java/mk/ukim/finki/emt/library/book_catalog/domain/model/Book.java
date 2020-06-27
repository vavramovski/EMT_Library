/*
package mk.ukim.finki.emt.library.book_catalog.domain.model;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Book extends AbstractEntity<ProductId> {

    @Version
    private Long version;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "currency"))
    })

    private int quantity;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    public Product() {

    }

    public Product(ProductId productId, String name, Money price, int quantity) {
        super(productId);
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}*/
