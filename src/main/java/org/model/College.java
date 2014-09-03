package org.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college_tbl")
public class College {
	@Id
	private String collegeId;
	private String collegeName;
	private String rank;

	public String getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName="
				+ collegeName + ", Rank=" + rank + "]";
	}

	public College(String collegeId, String collegeName,
			String rank) {
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.rank = rank;
	}

	public College() {

	}

	

}
