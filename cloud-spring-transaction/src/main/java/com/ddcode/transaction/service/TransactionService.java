package com.ddcode.transaction.service;

public interface TransactionService {

    public void insert();

    public void notransaction_exception_required_required();

    public void notransaction_required_required_exception();

    public void transaction_exception_required_required();

    public void transaction_required_required_exception();

    public void transaction_required_required_exception_try();

    public void notransaction_exception_requiresNew_requiresNew();

    public void notransaction_requiresNew_requiresNew_exception();
}
