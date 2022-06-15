package Com.Emloyee;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Employee,Integer> {  //method for finding username
Employee findByUsername(String username);
}
