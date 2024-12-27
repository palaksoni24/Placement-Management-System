package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "placement")
public class Placement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;

	@Column(name = "name")
	private String name;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "designation")
	private String designation;
	
	@Column(name = "academicCriteria")
	private String academicCriteria;

	@Column(name = "location")
	private String location;

	@Column(name = "ctcOffered")
	private String ctcOffered;
	
	@Column(name = "registrationLink")
	private String registrationLink;
	
	@Column(name = "lastDate")
	private String lastDate;
	
	@Column(name = "selectionProcess")
	private String selectionProcess;
	
	@Column(name = "companyWebsite")
	private String companyWebsite;
	

	public Placement() {
	}

	public Placement(String name, String qualification, String designation, String academicCriteria, String location,String ctcOffered,String registrationLink,String lastDate,String selectionProcess,String companyWebsite) {

		this.name = name;
		this.qualification = qualification;
		this.designation = designation;
		this.academicCriteria = academicCriteria;
		this.location = location;
		this.ctcOffered = ctcOffered;
		this.registrationLink = registrationLink;
		this.lastDate = lastDate;
		this.selectionProcess = selectionProcess;
		this.companyWebsite = companyWebsite;

	}

	public Placement(int id,String name, String qualification, String designation, String academicCriteria, String location,String ctcOffered,String registrationLink,String lastDate,String selectionProcess,String companyWebsite) {

		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.designation = designation;
		this.academicCriteria = academicCriteria;
		this.location = location;
		this.ctcOffered = ctcOffered;
		this.registrationLink = registrationLink;
		this.lastDate = lastDate;
		this.selectionProcess = selectionProcess;
		this.companyWebsite = companyWebsite;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAcademicCriteria() {
		return academicCriteria;
	}

	public void setAcademicCriteria(String academicCriteria) {
		this.academicCriteria = academicCriteria;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCtcOffered() {
		return ctcOffered;
	}

	public void setCtcOffered(String ctcOffered) {
		this.ctcOffered = ctcOffered;
	}

	public String getRegistrationLink() {
		return registrationLink;
	}

	public void setRegistrationLink(String registrationLink) {
		this.registrationLink = registrationLink;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	public String getSelectionProcess() {
		return selectionProcess;
	}

	public void setSelectionProcess(String selectionProcess) {
		this.selectionProcess = selectionProcess;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}



}
