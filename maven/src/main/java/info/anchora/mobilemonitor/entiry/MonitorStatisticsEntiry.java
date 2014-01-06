package info.anchora.mobilemonitor.entiry;

import java.sql.Date;

public class MonitorStatisticsEntiry {

	private Date startday;
	private Date stopday;
	
	public MonitorStatisticsEntiry(){
		super();
	}
	
	public MonitorStatisticsEntiry(Date startday, Date stopday){
		super();
		this.startday = startday;
		this.stopday = stopday;
	}
	
	public Date getStartday() {
		return startday;
	}
	public void setStartday(Date startday) {
		this.startday = startday;
	}
	public Date getStopday() {
		return stopday;
	}
	public void setStopday(Date stopday) {
		this.stopday = stopday;
	}

}
