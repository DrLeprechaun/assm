package com.xentaurs.assm.service;

import com.xentaurs.assm.web.error.UserAlreadyExistException;
import com.xentaurs.assm.domain.User;
import com.xentaurs.assm.model.NewUser;

public interface IUserService {

    User registerNewUserAccount(NewUser accountDto) throws UserAlreadyExistException;

}
