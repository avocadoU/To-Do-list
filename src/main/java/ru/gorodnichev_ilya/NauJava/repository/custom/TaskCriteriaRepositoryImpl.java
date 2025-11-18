package ru.gorodnichev_ilya.NauJava.repository.custom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;
import ru.gorodnichev_ilya.NauJava.domain.Task;

import java.util.List;

public class TaskCriteriaRepositoryImpl implements TaskCriteriaRepository {

    private final EntityManager entityManager;

    public TaskCriteriaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> findByUserIdCriteria(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = cb.createQuery(Task.class);

        Root<Task> taskRoot = query.from(Task.class);

        query.select(taskRoot)
                .where(cb.equal(taskRoot.get("user").get("userID"), userId));

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Task> findByCategoryNameCriteria(String categoryName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Task> query = cb.createQuery(Task.class);

        Root<Task> taskRoot = query.from(Task.class);

        query.select(taskRoot)
                .where(cb.equal(taskRoot.get("category").get("categoryName"), categoryName));

        return entityManager.createQuery(query).getResultList();
    }
}
