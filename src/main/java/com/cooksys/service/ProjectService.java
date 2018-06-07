package com.cooksys.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.dto.ProjectDto;
import com.cooksys.dto.ProjectManagerDto;
import com.cooksys.entity.Project;
import com.cooksys.exception.ReferencedEntityNotFoundException;
import com.cooksys.mapper.ProjectMapper;
import com.cooksys.repository.ProjectRepository;

@Service
public class ProjectService {
	private ProjectRepository repo;
	private ProjectMapper mapper;

	public ProjectService(ProjectRepository repo, ProjectMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public List<ProjectDto> getAll() {
		return repo.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	public boolean has(Long id) {
		return repo.exists(id);
	}

	public ProjectDto get(Long id) {
		mustExist(id);
		return mapper.toDto(repo.findOne(id));
	}

	public Long post(ProjectDto projectManagerDto) {
		projectManagerDto.setId(null);
		return repo.save(mapper.toEntity(projectManagerDto)).getId();
	}

	public void put(Long id, ProjectDto projectManagerDto) {
		mustExist(id);
		projectManagerDto.setId(id);
		repo.save(mapper.toEntity(projectManagerDto));
	}
	
	private void mustExist(Long id) {
		if(!has(id))
			throw new ReferencedEntityNotFoundException(Project.class, id);
	}

	public void delete(Long id) {
		mustExist(id);
		repo.delete(id);
	}
	
	//===
	
	public List<ProjectDto> findDueDatesLessThan(){
		Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		return repo.findByDueDateLessThan(date).stream().map(mapper::toDto).collect(Collectors.toList());
	}
	
	public List<ProjectDto> findByManagerId(Long managerId){
		return repo.findByManagerId(managerId).stream().map(mapper::toDto).collect(Collectors.toList());
	}

//	public Long add(ProjectDto projectManagerDto) {
//		projectManagerDto.setId(null);
//		return repo.save(mapper.toEntity(projectManagerDto)).getId();
//	}
//	public List<ProjectDto> add(ProjectDto projectManagerDto) {
//		projectManagerDto.setId(null);
//		return repo.save(mapper.toEntity(projectManagerDto)).getId();
//	}
}
