package com.demo.m2m;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.*;

public class Project {
	private int projectId;
	private String projectName;
	private List<Employee> employees = new ArrayList<Employee>();

	//@LazyCollection(LazyCollectionOption.EXTRA)
//	public void addEmployeeToProject(Employee employee){
//		employees.add(employee);
//		employee.getProjects().add(this);
//	}
	public Project() {
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project(String projectName) {
		this.projectName = projectName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + "]";
	}

	
}
