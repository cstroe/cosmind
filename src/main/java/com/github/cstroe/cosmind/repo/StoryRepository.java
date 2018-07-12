package com.github.cstroe.cosmind.repo;

import com.github.cstroe.cosmind.dao.StoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity, Long> {
}
