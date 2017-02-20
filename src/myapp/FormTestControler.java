package myapp;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Past;

@ManagedBean(name = "formTest")
@SessionScoped
public class FormTestControler {

    private String text = "X";

    public String submit() {
        System.out.println("LOG: Submit");
        return null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        System.out.println("LOG: Set text with " + text);
    }
    

    @Past(message = "Trop récent !")
    private Date birthday = new Date();

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        System.out.println("LOG: Set birthday with " + birthday);
    }
    
    private Double number = 100.0;

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
        System.out.println("LOG: Set number with " + number);
    }

}