package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Order;
import com.sinanengin.perfume.entities.Permission;
import com.sinanengin.perfume.entities.User;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService {

    DataResult<List<Permission>> getPermission(User user);

    DataResult<User> getUserByMail(String mail);

   DataResult<User> getUserByMailOrUsername(String mail, String username);
    DataResult<User> addUser(User user);
}
