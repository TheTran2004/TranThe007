package Baithi.com.baithidemo.product;

import Baithi.com.baithidemo.modes.ProductStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;
    private String type;
    private String desc;
    private double price;
    private String image;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    // Constructors, getters, setters
    private int status = ProductStatus.PRODUCT_PENDING;

    public boolean isActive() {return this.status == ProductStatus.PRODUCT_PENDING || this.status == ProductStatus.PRODUCT_GOING; }
    public boolean isCancel() {
        return this.status == ProductStatus.PRODUCT_CANCEL;
    }
    public boolean isFinish() {
        return this.status == ProductStatus.PRODUCT_FINISH;
    }
}
