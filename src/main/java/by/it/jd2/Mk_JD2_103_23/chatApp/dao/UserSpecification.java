package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.UserDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification {
    public static Specification<User> byFlightFilter(UserDTO filter){
        return new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if(filter.getLogin() != null){
                    predicates.add(cb.equal(root.get("login"), filter.getLogin()));
                }
                if(filter.getPassword() != null){
                    predicates.add(cb.equal(root.get("password"), filter.getPassword()));
                }
                if(filter.getFullname() != null){
                    predicates.add(cb.equal(root.get("fullname"), filter.getFullname()));
                }
                if(filter.getBirthday() != null){
                    Path<LocalDate> birthday = root.get("birthday");

                    predicates.add(
                            cb.and(
                                    cb.greaterThanOrEqualTo(birthday, filter.getBirthday()),
                                    cb.lessThan(birthday, filter.getBirthday().plusDays(1))
                            )
                    );
                }

                return cb.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
}
