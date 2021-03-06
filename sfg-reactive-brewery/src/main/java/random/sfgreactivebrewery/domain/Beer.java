package random.sfgreactivebrewery.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import random.sfgreactivebrewery.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
public class Beer {

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
//    @Type(type = "org.hibernate.type.UUIDCharType")
//    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private Integer id;

    //    @Version
    private Long version;

    private String beerName;
    private BeerStyleEnum beerStyle;
    private String upc;

    private Integer quantityOnHand;
    private BigDecimal price;

    //    @CreationTimestamp
//    @Column(updatable = false)
    private LocalDateTime createdDate;

    //    @UpdateTimestamp
    private LocalDateTime lastModifiedDate;
}
