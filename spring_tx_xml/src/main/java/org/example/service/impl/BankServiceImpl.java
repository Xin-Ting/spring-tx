package org.example.service.impl;

import org.example.dal.BankMapper;
import org.example.domain.Account;
import org.example.domain.Log;
import org.example.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;

/**
 * @author 85217
 */

@Service
public class BankServiceImpl implements org.example.service.BankService {
    @Autowired
    private BankMapper bankMapper;

    public void takeMoney(long accountId, double money) {
        outMoney(accountId,money);
        recordLog(accountId,money);
    }

    public void outMoney(long accountId, double money) {
        Account account = new Account();
        account.setId(accountId);
        account.setMoney(money);
        bankMapper.outMoney(account);
    }

    public void recordLog(long accountId, double money) {
        Log log = new Log();
        //当打印凭条没有纸张时，不记录日志，而出钞正常
        int i = 1/0;
        log.setLog("取出"+money+"元");
        bankMapper.recordLog(log);
    }
}
