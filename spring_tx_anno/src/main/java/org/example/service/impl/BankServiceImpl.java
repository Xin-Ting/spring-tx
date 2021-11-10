package org.example.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.example.dal.BankMapper;
import org.example.domain.Account;
import org.example.domain.Log;
import org.example.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.soap.Addressing;

/**
 * @author 85217
 */

@Service
public class BankServiceImpl implements org.example.service.BankService {
    @Autowired
    private BankMapper bankMapper;

    @Transactional(noRollbackFor = {ArithmeticException.class})
    public void takeMoney(long accountId, double money) {
        outMoney(accountId,money);
        recordLog(accountId,money);
    }
    @Transactional()
    public void outMoney(long accountId, double money) {
        Account account = new Account();
        account.setId(accountId);
        account.setMoney(money);
        bankMapper.outMoney(account);
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void recordLog(long accountId, double money) {
        Log log = new Log();

        log.setLog("取出"+money+"元");
        bankMapper.recordLog(log);
    }
}
