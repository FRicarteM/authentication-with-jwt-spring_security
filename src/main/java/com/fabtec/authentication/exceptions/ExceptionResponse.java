package com.fabtec.authentication.exceptions;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 8486068814491095598L;
	
	private String title;
	private String timestamp;
	private String message;
	private int status;
	private String details;
	
	public ExceptionResponse() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, message, status, timestamp, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(obj instanceof ExceptionResponse))
			return false;
		ExceptionResponse other = (ExceptionResponse) obj;
		return Objects.equals(details, other.details) && Objects.equals(message, other.message)
				&& status == other.status && Objects.equals(timestamp, other.timestamp)
				&& Objects.equals(title, other.title);
	}
	
	
	
}
