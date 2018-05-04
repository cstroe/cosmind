package com.github.cstroe.cosidea.repo;

import com.github.cstroe.cosidea.dao.StoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity, Long> {
}
