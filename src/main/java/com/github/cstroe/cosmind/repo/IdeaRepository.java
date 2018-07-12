package com.github.cstroe.cosmind.repo;

import com.github.cstroe.cosmind.dao.IdeaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdeaRepository extends CrudRepository<IdeaEntity, Long> {
}
