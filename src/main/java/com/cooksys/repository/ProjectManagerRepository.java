package com.cooksys.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.cooksys.dto.ProjectDto;
import com.cooksys.entity.Project;
import com.cooksys.entity.ProjectManager;

import io.swagger.annotations.ApiOperation;

public interface ProjectManagerRepository extends JpaRepository<ProjectManager, Long>{
	@Transactional
    List<ProjectManager> findByProjectsDueDateLessThan(Date date);
    @Transactional
    List<ProjectManager> findByProjectsContains(Project project);
}
