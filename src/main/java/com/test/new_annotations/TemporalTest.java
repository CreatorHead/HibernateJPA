package com.test.new_annotations;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="date_tests")
public class TemporalTest {
	@Id
	@GeneratedValue
	private int dateId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date dateTimeColumn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date timeStampColumn;
	
	@Temporal(TemporalType.TIME)
	@Column
	private Date timeColumn;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date dateColumn;
	
	@Column
	private java.sql.Timestamp sqlDateTimeColumn;
	
	@Column
	private java.sql.Timestamp sqlTimestampColumn;
	
	@Column
	private java.sql.Time sqlTimeColumn;
	
	@Column
	private java.sql.Date sqlDateColumn;
	
	

	public TemporalTest() {}
	
	public TemporalTest(Date date) {
		this.dateTimeColumn = date;
		this.timeStampColumn = date;
		this.timeColumn = date;
		this.dateColumn = date;
		
		this.sqlDateTimeColumn = new java.sql.Timestamp(date.getTime());
		this.sqlTimestampColumn = new Timestamp(date.getTime());
		this.sqlTimeColumn = new java.sql.Time(date.getTime());
		this.sqlDateColumn = new java.sql.Date(date.getTime());
	}
	
	public int getDateId() {
		return dateId;
	}

	public void setDateId(int dateId) {
		this.dateId = dateId;
	}

	public Date getDateTimeColumn() {
		return dateTimeColumn;
	}

	public void setDateTimeColumn(Date dateTimeColumn) {
		this.dateTimeColumn = dateTimeColumn;
	}

	public Date getTimeStampColumn() {
		return timeStampColumn;
	}

	public void setTimeStampColumn(Date timeStampColumn) {
		this.timeStampColumn = timeStampColumn;
	}

	public Date getTimeColumn() {
		return timeColumn;
	}

	public void setTimeColumn(Date timeColumn) {
		this.timeColumn = timeColumn;
	}

	public java.sql.Timestamp getSqlDateTimeColumn() {
		return sqlDateTimeColumn;
	}

	public void setSqlDateTimeColumn(java.sql.Timestamp sqlDateTimeColumn) {
		this.sqlDateTimeColumn = sqlDateTimeColumn;
	}

	public java.sql.Timestamp getSqlTimestampColumn() {
		return sqlTimestampColumn;
	}

	public void setSqlTimestampColumn(java.sql.Timestamp sqlTimestampColumn) {
		this.sqlTimestampColumn = sqlTimestampColumn;
	}

	public java.sql.Time getSqlTimeColumn() {
		return sqlTimeColumn;
	}

	public void setSqlTimeColumn(java.sql.Time sqlTimeColumn) {
		this.sqlTimeColumn = sqlTimeColumn;
	}

	public java.sql.Date getSqlDateColumn() {
		return sqlDateColumn;
	}

	public void setSqlDateColumn(java.sql.Date sqlDateColumn) {
		this.sqlDateColumn = sqlDateColumn;
	}

	public Date getDateColumn() {
		return dateColumn;
	}

	public void setDateColumn(Date dateColumn) {
		this.dateColumn = dateColumn;
	}
	

}
