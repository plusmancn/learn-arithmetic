package cn.plusman.http.application.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MyAtmApplication {

    private static Logger LOGGER = LoggerFactory.getLogger(MyAtmApplication.class);

    public static void run(String[] args) throws Exception {
        LOGGER.info("[Application] Starting ATM application");

        Date date = new Date();
        System.out.println(date.toString());
        MyAtm.withdrawMoney(Integer.parseInt(args[2]));

        Thread.sleep(Long.valueOf(args[1]));

        MyAtm.withdrawMoney(Integer.parseInt(args[3]));
    }

}
