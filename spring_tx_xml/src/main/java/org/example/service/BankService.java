package org.example.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.example.domain.Account;
import org.example.domain.Log;

/**
 * @author 85217
 */
public interface BankService {
    /**
     * 取钱业务
     * @param accountId
     * @param money
     */
    void takeMoney(long accountId,double money);

    /**
     * 出钞
     * @param accountId
     * @param money
     */
    void outMoney(long accountId,double money);

    /**
     * 记录日志
     * @param accountId
     * @param money
     */
    void recordLog(long accountId,double money);
}
