package ra.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.api.entity.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
