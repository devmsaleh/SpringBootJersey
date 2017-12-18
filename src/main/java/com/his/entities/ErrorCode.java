package com.his.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ErrorCode {

	@Id
	private Long id;
	@Column(nullable = false, name = "errorCode")
	private String errorCode;
	@Column(nullable = false, name = "errorNameArabic")
	private String errorNameArabic;
	@Column(nullable = false, name = "errorNameEnglish")
	private String errorNameEnglish;
	private boolean active;

	public ErrorCode() {
		super();
	}

	public ErrorCode(Long id) {
		super();
		this.id = id;
	}

	public ErrorCode(Long id, String errorNameArabic, String errorNameEnglish, Integer errorCodeValue) {
		super();
		this.id = id;
		this.errorNameArabic = errorNameArabic;
		this.errorNameEnglish = errorNameEnglish;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorNameArabic() {
		return errorNameArabic;
	}

	public void setErrorNameArabic(String errorNameArabic) {
		this.errorNameArabic = errorNameArabic;
	}

	public String getErrorNameEnglish() {
		return errorNameEnglish;
	}

	public void setErrorNameEnglish(String errorNameEnglish) {
		this.errorNameEnglish = errorNameEnglish;
	}

}
