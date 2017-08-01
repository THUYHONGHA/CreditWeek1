package cs544.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimeFrame {		
	@Temporal(TemporalType.DATE)
	private Date start;	
	@Temporal(TemporalType.DATE)
	private Date end;

	/* Constructors */
	public TimeFrame() {
	}

	

	


}
