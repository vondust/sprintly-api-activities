package br.com.sprintly.activities.adapter.datastore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sprintly.activities.adapter.datastore.entity.ActivityEntity;

public interface ActivityRepository
		extends JpaRepository<ActivityEntity, Long>, JpaSpecificationExecutor<ActivityEntity> {

}
