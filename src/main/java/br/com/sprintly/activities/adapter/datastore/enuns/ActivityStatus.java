package br.com.sprintly.activities.adapter.datastore.enuns;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum ActivityStatus {

	UNKNOWN("UNKNOWN"),
	TO_DO("TO DO"),
	IN_PROGRESS("IN PROGRESS"),
	IN_REVIEW("IN REVIEW"),
	DONE("DONE"),
	CANCELLED("CANCELLED");

	private final String description;
	private static final Map<String, ActivityStatus> map = new HashMap<>();

	private ActivityStatus(String description) {
		this.description = description;
	}

	static {
		for (ActivityStatus status : values())
			map.put(status.getDescription(), status);
	}

	public static ActivityStatus fromDescription(String description) {
		if (map.containsKey(description))
			return map.get(description);

		return UNKNOWN;
	}
}
