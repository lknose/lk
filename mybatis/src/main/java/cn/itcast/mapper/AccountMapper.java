package cn.itcast.mapper;

import cn.itcast.model.Account;

import java.util.List;

public interface AccountMapper {

    List<Account> queryAccountByUserId(int id);
}
