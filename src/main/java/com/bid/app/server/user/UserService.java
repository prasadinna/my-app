package com.bid.app.server.user;

import org.hibernate.Query;

import com.bid.app.server.hibernate.BaseDataAccessObject;

public class UserService extends BaseDataAccessObject {
	public boolean createUser(User newUser) {
		begin();
		getSession().save(newUser);
		commit();
		return true;
	}
	
	public User getUser(int mobileNumber){
		begin();
		Query hql = getSession().createQuery("from User where mobile_number = :mobileNumber");
		hql.setInteger("mobileNumber", mobileNumber);
		User user = (User)hql.uniqueResult();
		commit();
		return user;
	}
	
	public boolean delete(int mobileNumber){
		User usr = getUser(mobileNumber);
		if(usr != null){
			return delete(usr);
		}
		return false;
	}
	
	public boolean delete(User user){
		begin();
		getSession().delete(user);
		commit();
		return true;
	}
}
