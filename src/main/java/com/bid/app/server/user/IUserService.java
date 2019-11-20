package com.bid.app.server.user;

import com.bid.app.server.bootstrap.ServiceInterface;

public interface IUserService extends ServiceInterface {
   public String addUser(User user);
}
