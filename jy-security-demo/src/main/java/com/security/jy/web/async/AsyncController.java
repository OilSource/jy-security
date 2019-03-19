package com.security.jy.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")
    public Callable<String> order() throws InterruptedException {
        logger.info("主线程开始");
        Callable<String> result = () -> {
                logger.info("副线程开始");
                Thread.sleep(1000);
                logger.info("副线程返回");
                return "副线程 success";
        };
        logger.info("主线程返回");
        return result;
    }

    @RequestMapping("/async")
    public DeferredResult<String> async() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);
        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber,result);
        logger.info("主线程返回");
        return result;
    }
}
