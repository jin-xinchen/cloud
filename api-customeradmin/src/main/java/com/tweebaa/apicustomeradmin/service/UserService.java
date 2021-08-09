package com.tweebaa.apicustomeradmin.service;

import com.tweebaa.apicustomeradmin.controller.PageCustomers;

public interface UserService {
    PageCustomers receiveUsersJDBC(int page, int number);
}
