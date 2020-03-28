package br.com.sprintly.activities.adapter.datastore.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.sprintly.activities.adapter.datastore.enuns.ActivityStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "activities")
public class ActivityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(updatable = false, nullable = false)
	private Long idSprint;

	@Column(updatable = false, nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ActivityStatus status;

	@Column(nullable = false)
	private LocalTime estimatedTime;

	@Column(nullable = false)
	private LocalTime spentTime;

	@Column(updatable = false, nullable = false)
	private String createdBy;

	@Column
	private String associatedTo;

	@CreatedDate
	@Column(updatable = false, nullable = false)
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(updatable = false, nullable = false)
	private LocalDateTime lastModifiedAt;
}
