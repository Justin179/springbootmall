package com.justin.springbootmall.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount() {

        System.out.println(getClass() + ": doing my db work: add a membership account");
    }
}
