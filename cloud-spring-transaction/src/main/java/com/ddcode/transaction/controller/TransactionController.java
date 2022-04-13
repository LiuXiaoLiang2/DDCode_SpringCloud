package com.ddcode.transaction.controller;

import com.ddcode.transaction.service.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TransactionController {

    @Resource
    private TransactionService transactionService;

    @RequestMapping("/testInsert")
    public String testInsert(){
        transactionService.insert();
        return "ok";
    }

    @RequestMapping("/notransaction_exception_required_required")
    public String notransaction_exception_required_required(){
        transactionService.notransaction_exception_required_required();
        return "ok";
    }

    @RequestMapping("/notransaction_required_required_exception")
    public String notransaction_required_required_exception(){
        transactionService.notransaction_required_required_exception();
        return "ok";
    }

    @RequestMapping("/transaction_exception_required_required")
    public String transaction_exception_required_required(){
        transactionService.transaction_exception_required_required();
        return "ok";
    }

    @RequestMapping("/transaction_required_required_exception")
    public String transaction_required_required_exception(){
        transactionService.transaction_required_required_exception();
        return "ok";
    }

    @RequestMapping("/transaction_required_required_exception_try")
    public String transaction_required_required_exception_try(){
        transactionService.transaction_required_required_exception_try();
        return "ok";
    }

    @RequestMapping("/notransaction_exception_requiresNew_requiresNew")
    public String notransaction_exception_requiresNew_requiresNew(){
        transactionService.notransaction_exception_requiresNew_requiresNew();
        return "ok";
    }

    @RequestMapping("/notransaction_requiresNew_requiresNew_exception")
    public String notransaction_requiresNew_requiresNew_exception(){
        transactionService.notransaction_requiresNew_requiresNew_exception();
        return "ok";
    }
}
