package myapp;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

public class ViewCounter implements Serializable {
	
	@ManagedProperty("#{applicationCounter}")
	ApplicationCounter appCounter;

    /**
	 * @return the appCounter
	 */
	public ApplicationCounter getAppCounter() {
		return appCounter;
	}

	/**
	 * @param appCounter the appCounter to set
	 */
	public void setAppCounter(ApplicationCounter appCounter) {
		this.appCounter = appCounter;
	}

	private static final long serialVersionUID = 7983140976075649622L;

    int value = 0;

    public Integer getCounter() {
        return ++value;
    }

    @PostConstruct
    void init() {
        System.err.println("Create " + this);
    }

    @PreDestroy
    void close() {
        System.err.println("Close " + this);
    }

}

