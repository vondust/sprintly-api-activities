package br.com.sprintly.activities.adapter.datastore.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import br.com.sprintly.activities.adapter.datastore.entity.ActivityEntity;
import br.com.sprintly.activities.adapter.datastore.enuns.ActivityStatus;
import br.com.sprintly.activities.core.model.Activity;

public class ActivityMapper {

	private ActivityMapper() {}

	public static Collection<Activity> toDto(Collection<ActivityEntity> entities) {
		return entities.stream().map(ActivityMapper::toDto).collect(Collectors.toList());
	}

	public static Collection<ActivityEntity> toEntity(Collection<Activity> models) {
		return models.stream().map(ActivityMapper::toEntity).collect(Collectors.toList());
	}

	public static ActivityEntity toEntity(Activity model) {
		return ActivityEntity.builder()
				.id(model.getId())
				.idSprint(model.getIdSprint())
				.name(model.getName())
				.status(ActivityStatus.fromDescription(model.getStatus()))
				.estimatedTime(model.getEstimatedTime())
				.spentTime(model.getSpentTime())
				.createdBy(model.getCreatedBy())
				.associatedTo(model.getAssociatedTo())
				.createdOn(model.getCreatedOn())
				.build();
	}

	public static Activity toDto(ActivityEntity entity) {
		return Activity.builder()
				.id(entity.getId())
				.idSprint(entity.getIdSprint())
				.name(entity.getName())
				.status(entity.getStatus().getDescription())
				.estimatedTime(entity.getEstimatedTime())
				.spentTime(entity.getSpentTime())
				.createdBy(entity.getCreatedBy())
				.associatedTo(entity.getAssociatedTo())
				.createdOn(entity.getCreatedOn())
				.build();
	}
}
