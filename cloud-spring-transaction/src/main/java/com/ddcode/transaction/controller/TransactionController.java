package com.ddcode.transaction.controller;

import com.ddcode.transaction.service.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TransactionController {

    @Resource
    private TransactionService transactionService;

    @RequestMapping("/notransaction_exception_required_required")
    public String notransaction_exception_required_required(){
        transactionService.notransaction_exception_required_required();
        return "ok";
    }
}
