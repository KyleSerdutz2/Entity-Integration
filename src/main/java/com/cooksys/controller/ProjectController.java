package com.cooksys.controller;

import static org.assertj.core.api.Assertions.registerCustomDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.dto.ProjectDto;
import com.cooksys.dto.ProjectDto;
import com.cooksys.service.ProjectService;
import com.cooksys.service.ProjectService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("project")
public class ProjectController {
	//=============
	
	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping("overdue")
    @ApiOperation(value = "", nickname = "findDueDatesLessThan")
    public List<ProjectDto> getAllPastDue() {
        return projectService.findDueDatesLessThan();
    }
	
	@GetMapping("projectManager/{id}/project")
    @ApiOperation(value = "", nickname = "findDueDatesLessThan")
	public List<ProjectDto> findByManagerId(@PathVariable Long managerId){
		return projectService.findByManagerId(managerId);
	}
	
	//===
	
//	@GetMapping
//	@ApiOperation(value = "", nickname = "getAllProjects")
//	public List<ProjectDto> getAll() {
//		return projectService.getAll();
//	}
//
//	@RequestMapping(method = RequestMethod.HEAD, value = "{id}")
//	@ApiOperation(value = "", nickname = "projectExistsForId")
//	public void has(@PathVariable Long id, HttpServletResponse httpResponse) {
//		if(!projectService.has(id))
//			httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
//	}
//
//	@GetMapping("{id}")
//	@ApiOperation(value = "", nickname = "getProjectById")
//	public ProjectDto get(@PathVariable Long id) {
//		return projectService.get(id);
//	}
//
//	@PostMapping
//	@ApiOperation(value = "", nickname = "postNewManager")
//	public Long post(@RequestBody @Validated ProjectDto projectDto, HttpServletResponse httpResponse) {
//		Long id = projectService.post(projectDto);
//		httpResponse.setStatus(HttpServletResponse.SC_CREATED);
//		return id;
//	}
//	
//	@PutMapping("{id}")
//	@ApiOperation(value = "", nickname = "putProjectWithId")
//	public void put(@PathVariable Long id, @RequestBody @Validated ProjectDto projectDto, HttpServletResponse httpResponse) {
//		projectService.put(id, projectDto);
//	}
//	
//	@DeleteMapping("{id}")
//	@ApiOperation(value = "", nickname = "deleteProjectAtId")
//	public void delete(@PathVariable Long id, HttpServletResponse httpResponse) {
//		projectService.delete(id);
//	}
}
