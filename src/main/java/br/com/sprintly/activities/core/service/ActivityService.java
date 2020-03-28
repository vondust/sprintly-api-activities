package br.com.sprintly.activities.core.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.sprintly.activities.adapter.datastore.dto.ActivityMapper;
import br.com.sprintly.activities.adapter.datastore.entity.ActivityEntity;
import br.com.sprintly.activities.adapter.datastore.repository.ActivityRepository;
import br.com.sprintly.activities.core.model.Activity;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;

	public Activity cria(Activity model) {
		return ActivityMapper.toDto(repository.save(ActivityMapper.toEntity(model)));
	}

	public Activity atualiza(Long id, Activity model) {
		buscaPorId(id);
		model.setId(id);
		return ActivityMapper.toDto(repository.save(ActivityMapper.toEntity(model)));
	}

	public void remove(Long id) {
		buscaPorId(id);
		repository.deleteById(id);
	}

	public Activity buscaPorId(Long id) {
		Optional<ActivityEntity> activity = repository.findById(id);
		if (!activity.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					String.format("Atividade com id %s não encontrada", id.toString()));

		return ActivityMapper.toDto(activity.get());
	}

	public Collection<Activity> busca() {
		return ActivityMapper.toDto(repository.findAll());
	}
}
