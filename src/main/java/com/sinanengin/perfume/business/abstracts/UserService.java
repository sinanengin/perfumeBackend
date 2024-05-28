package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.entities.Order;
import com.sinanengin.perfume.entities.Permission;
import com.sinanengin.perfume.entities.User;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService {
    DataResult<List<Permission>> getPermissions(User user);
    Result add(User user);
    DataResult<User> getByMailOrUserName(String email, String username);
    DataResult<User> getByMail(String email);
}
