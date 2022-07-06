package net.java.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long subjectId;

    @Column(name="subject_name")
    private String  subjectname;
    private String marks;

    
    //@ManyToOne
  //  @JoinColumn(name="sub_id")
    public Subject() {
    	
    }
    
    public Subject(String subjectname, String marks) {
		super();
		this.subjectname = subjectname;
		this.marks = marks;
	}
    

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}



	
   
 

    
}
