package com.cperez.models;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {
	
	File pathWorspace; 
	File pathInput; 
	File pathOutput; 
	File pathException; 
	File pathLogs; 
	String fechaEjecucion; 

}
