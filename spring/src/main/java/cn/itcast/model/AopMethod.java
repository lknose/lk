package cn.itcast.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AopMethod {

    @Before("execution(* cn.itcast.model.*.*(..))")
    public void after(){
        System.out.println("前置通知");
    }
}
