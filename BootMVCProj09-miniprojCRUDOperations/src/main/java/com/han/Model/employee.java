package com.han.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table(name="emp")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class employee {

	@Id
	@SequenceGenerator(name = "h",sequenceName = "empno_SEQ",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "h",strategy = GenerationType.SEQUENCE)
	private Integer  empno;
	@NonNull
	private String ename;
	@NonNull
	private String job;
	@NonNull
	private Float sal;
	@NonNull
	private Long deptno;
	
}
