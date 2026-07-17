package com.ecommerce.userservice.dto;

import jakarta.validation.constraints.NotBlank;

public class UserUpdateRequestDTO {
	
	@NotBlank(message = "Full name is required")
	private String fullName;
	
	@NotBlank(message = "Phone is required")
	private String phone;
	
	@NotBlank(message = "role is required")
	private String role;
	
	private Boolean active;

	// getters & setters
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
