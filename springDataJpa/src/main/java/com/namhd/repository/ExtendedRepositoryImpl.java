package com.namhd.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class ExtendedRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
    implements BaseRepository<T,ID>
{
    private JpaEntityInformation<T,?> entityInformation;
    private EntityManager entityManager;
    public ExtendedRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }

    @Override
    public List<T> findByIds(ID... ids) {
        Query query = this.entityManager.createQuery("select e from " + this.entityInformation.getEntityName()
        + " e where e." + this.entityInformation.getIdAttribute().getName() + " in :ids");
        query.setParameter("ids", Arrays.asList(ids));
        return (List<T>) query.getResultList();
    }
}
