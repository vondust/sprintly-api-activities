package br.com.sprintly.activities.adapter.http.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sprintly.activities.core.model.Activity;
import br.com.sprintly.activities.core.service.ActivityService;

@RestController
@RequestMapping("/sprintly/activities")
public class ActivityController {

	private static final String ID = "id";
	private static final String ID_PATH = "/{id}";

	@Autowired
	private ActivityService service;

	@PostMapping
	public ResponseEntity<?> post(@RequestBody(required = true) Activity model) {
		Activity activity = service.cria(model);
		return ResponseEntity.created(URI.create("/sprintly/activities/" + activity.getId())).body(activity);
	}

	@PutMapping(ID_PATH)
	public ResponseEntity<?> put(@PathVariable(required = true, name = ID) final Long id,
			@RequestBody(required = true) Activity model) {

		Activity activity = service.cria(model);
		return ResponseEntity.created(URI.create("/sprintly/activities/" + activity.getId())).body(activity);
	}

	@GetMapping
	public ResponseEntity<?> get() {
		return ResponseEntity.ok(service.busca());
	}

	@GetMapping(ID_PATH)
	public ResponseEntity<?> getId(@PathVariable(required = true, name = ID) final Long id) {
		return ResponseEntity.ok(service.buscaPorId(id));
	}

	@DeleteMapping(ID_PATH)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(required = true, name = ID) final Long id) {
		service.remove(id);
	}
}
