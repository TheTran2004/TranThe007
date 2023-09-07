package Baithi.com.baithidemo.modes;

import Baithi.com.baithidemo.product.Product;
import Baithi.com.baithidemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class ProductStatus {
    public  static final int PRODUCT_GOING = 1;
    public  static final int PRODUCT_CANCEL = -1;
    public static final int PRODUCT_PENDING = 0;
    public static final  int PRODUCT_FINISH = 2;
}
