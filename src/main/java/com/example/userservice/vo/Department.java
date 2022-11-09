package com.example.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	private Long departmentId;
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
}
