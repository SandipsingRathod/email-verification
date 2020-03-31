package com.stackabuse.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenid;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public ConfirmationToken(User user) {
        this.user = user;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

  public ConfirmationToken() {
	  
  }

public ConfirmationToken(long tokenid, String confirmationToken, Date createdDate, User user) {
	super();
	this.tokenid = tokenid;
	this.confirmationToken = confirmationToken;
	this.createdDate = createdDate;
	this.user = user;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((confirmationToken == null) ? 0 : confirmationToken.hashCode());
	result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
	result = prime * result + (int) (tokenid ^ (tokenid >>> 32));
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ConfirmationToken other = (ConfirmationToken) obj;
	if (confirmationToken == null) {
		if (other.confirmationToken != null)
			return false;
	} else if (!confirmationToken.equals(other.confirmationToken))
		return false;
	if (createdDate == null) {
		if (other.createdDate != null)
			return false;
	} else if (!createdDate.equals(other.createdDate))
		return false;
	if (tokenid != other.tokenid)
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}

public long getTokenid() {
	return tokenid;
}

public void setTokenid(long tokenid) {
	this.tokenid = tokenid;
}

public String getConfirmationToken() {
	return confirmationToken;
}

public void setConfirmationToken(String confirmationToken) {
	this.confirmationToken = confirmationToken;
}

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
        
}