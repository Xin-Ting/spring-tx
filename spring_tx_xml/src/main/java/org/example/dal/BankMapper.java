package org.example.dal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.example.domain.Account;
import org.example.domain.Log;

/**
 * @author 85217
 */
public interface BankMapper {
    /**
     * 出钞
     * @param account
     */
    @Update("UPDATE account SET money=money-#{money} WHERE id =#{id}")
    void outMoney(Account account);

    /**
     * 记录日志
     * @param log
     */
    @Insert("INSERT INTO LOG (LOG) VALUE (#{log})")
    void recordLog(Log log);
}
