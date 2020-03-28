package br.com.sprintly.activities.core.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {

	private Long id;
	private Long idSprint;
	private String name;
	private String status;
	private LocalTime estimatedTime;
	private LocalTime spentTime;
	private String createdBy;
	private String associatedTo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, locale = "pt_BR", pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdOn;
}
