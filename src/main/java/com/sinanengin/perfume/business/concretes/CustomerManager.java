package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.CustomerService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.SuccessDataResult;
import com.sinanengin.perfume.dataAccess.abstracts.AnswerDao;
import com.sinanengin.perfume.dataAccess.abstracts.CustomerDao;
import com.sinanengin.perfume.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerManager implements CustomerService {

    CustomerDao customerDao;

    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public DataResult<List<Customer>> getAllCustomer() {
        return new SuccessDataResult<>(customerDao.findAll());
    }

    @Override
    public DataResult<Customer> getCustomerByUserId(int userId) {
        return new SuccessDataResult<>(customerDao.getByUser_userId(userId));
    }

    @Override
    public DataResult<Customer> addCustomer(Customer customer) {
        customerDao.save(customer);
        return new SuccessDataResult<>(customer, "Müşteri eklendi.");
    }

    @Override
    public DataResult<Customer> deleteCustomer(int customerId) {
        customerDao.deleteById(customerId);
        return new SuccessDataResult<>("Müşteri silindi.");

    }

    @Override
    public DataResult<Customer> updateCustomer(Customer customer) {
        customerDao.save(customer);
        return new SuccessDataResult<>(customer, "Müşteri güncellendi.");
    }
}
