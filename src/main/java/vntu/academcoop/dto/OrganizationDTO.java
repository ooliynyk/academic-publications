package vntu.academcoop.dto;

import vntu.academcoop.model.Organization;

public class OrganizationDTO {

	private String id;
	private String name;

	private Integer cooperationValue = 0;

	public OrganizationDTO(Organization organization) {
		this.id = organization.getId();
		this.name = organization.getName();
	}

	public OrganizationDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCooperationValue() {
		return cooperationValue;
	}

	public void setCooperationValue(Integer cooperationValue) {
		this.cooperationValue = cooperationValue;
	}

}