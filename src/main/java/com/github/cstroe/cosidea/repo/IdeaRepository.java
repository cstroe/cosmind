package com.github.cstroe.cosidea.repo;

import com.github.cstroe.cosidea.dao.IdeaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends CrudRepository<IdeaEntity, Long> {
}
