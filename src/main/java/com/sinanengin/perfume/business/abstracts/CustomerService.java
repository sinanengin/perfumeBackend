package com.sinanengin.perfume.business.abstracts;

import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Brand;
import com.sinanengin.perfume.entities.Customer;

import java.util.List;

public interface CustomerService {

    DataResult<List<Customer>> getAllCustomer();
    DataResult<Customer> getCustomerByUserId(int userId);

    DataResult<Customer> addCustomer(Customer customer);
    DataResult<Customer> deleteCustomer(int customerId);
    DataResult<Customer> updateCustomer(Customer customer);
}
