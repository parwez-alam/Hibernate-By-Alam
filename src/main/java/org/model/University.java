package org.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "university_tbl")
public class University {
	@Id
	private String uid;
	private String universityName;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = College.class, fetch=FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size=2)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	@JoinColumn(name = "uid_fk", referencedColumnName = "uid")
	
	private List<College> collegeList;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public List<College> getCollegeList() {
		return collegeList;
	}

	public void setCollegeList(List<College> collegeList) {
		this.collegeList = collegeList;
	}

	@Override
	public String toString() {
		return "University [uid=" + uid + ", universityName=" + universityName
				+ ", collegeList=" + collegeList + "]";
	}

	public University(String uid, String universityName,
			List<College> collegeList) {
		this.uid = uid;
		this.universityName = universityName;
		this.collegeList = collegeList;
	}

	public University() {

	}

}
