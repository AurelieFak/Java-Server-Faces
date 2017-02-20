package myapp;


import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "course")
@SessionScoped
public class CourseControler {

    @EJB
    CourseManager cm;

    Course theCourse = new Course();

    @PostConstruct
    public void init() {
        System.out.println("Create " + this);
        if (cm.findCourses().size() == 0) {
            Course c1 = new Course();
            c1.setName("Architecture JEE");
            c1.setHours(60);
            c1.setDescription("Introduction à JEE.");
            c1.setLevel("Débutant");
            cm.saveCourse(c1);
        }
    }

    public List<Course> getCourses() {
        return cm.findCourses();
    }

    public Course getTheCourse() {
        return theCourse;
    }

    public String show(Integer n) {
        theCourse = cm.findCourse(n);
        return "showCourse";
    }
    
    public String addCourse() {
    	Course c1 = new Course();
    	 c1.setName("");
         c1.setHours(null);
         c1.setDescription("");
         c1.setLevel("");
    	cm.saveCourse(c1);
    	return "showCourse";
    }
    
    @ManagedProperty("#{messages}")
    ResourceBundle messages;

    public String save() {
    	System.out.println(messages);
    	if (theCourse.getHours() % 3 != 0) {
            FacesContext ct = FacesContext.getCurrentInstance();
            FacesMessage msg = new FacesMessage(messages.getString("hoursNotValid"));
            ct.addMessage("test:hours", msg);
            ct.validationFailed();
            return "editCourse";
        }
    	
        cm.saveCourse(theCourse);
        return "showCourse";
    }

    /**
	 * @return the messages
	 */
	public ResourceBundle getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ResourceBundle messages) {
		this.messages = messages;
	}

	public String newCourse() {
        theCourse = new Course();
        return "editCourse";
    }

}
