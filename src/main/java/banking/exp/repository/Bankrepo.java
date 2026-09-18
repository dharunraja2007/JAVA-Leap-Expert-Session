package banking.exp.repository;
import banking.exp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bankrepo extends JpaRepository<Users,Integer> {
}
