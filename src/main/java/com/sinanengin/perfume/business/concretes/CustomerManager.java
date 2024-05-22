package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.CustomerService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.entities.Customer;

import java.util.List;

public class CustomerManager implements CustomerService {
    @Override
    public DataResult<List<Customer>> getAllCustomer() {
        return null;
    }

    @Override
    public DataResult<Customer> getCustomerByUserId(int userId) {
        return null;
    }

    @Override
    public DataResult<Customer> addCustomer(Customer customer) {
        return null;
    }

    @Override
    public DataResult<Customer> deleteCustomer(int customerId) {
        return null;
    }

    @Override
    public DataResult<Customer> updateCustomer(Customer customer) {
        return null;
    }
}
