package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Message;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageSpecification {
    public static Specification<Message> byMessage(MessageDTO filter){
        return new Specification<Message>() {
            @Override
            public Predicate toPredicate(Root<Message> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if(filter.getFrom() != null){
                    predicates.add(cb.equal(root.get("from"), filter.getFrom()));
                }
                if(filter.getTo() != null){
                    predicates.add(cb.equal(root.get("to"), filter.getTo()));
                }
                if(filter.getText() != null){
                    predicates.add(cb.equal(root.get("text"), filter.getText()));
                }

                return cb.and(predicates.toArray(Predicate[]::new));
            }
        };
    }
}
