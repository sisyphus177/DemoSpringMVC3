package demo.spring.service;

import demo.spring.model.service.interf.AccountService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//import static org.junit.Assert.*;

/**
 * Created by raist on 2016/5/11.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-transaction.xml")
@ContextConfiguration(locations = {"file:web/WEB-INF/conf/spring/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountServiceImplTest {

//    @Resource(name = "accountServiceHibernateTemplateImplProxy")
//    @Resource(name = "accountServiceHibernateImplProxy")
//    @Resource(name = "accountServiceImplProxy")


    @Resource(name = "accountServiceImpl")
    private AccountService accountService1;

    @Resource(name = "accountServiceHibernateImpl")
    private AccountService accountService2;

    @Resource(name = "accountServiceHibernateTemplateImpl")
    private AccountService accountService3;

    @Test
    public void test1(){
        accountService1.transfer(1,2,100d);
    }

    @Test
    public void test2(){
        accountService2.transfer(1,2,100d);
    }

    @Test
    public void test3(){
        accountService3.transfer(1,2,100d);
    }

}