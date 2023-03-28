package com.bridge.sme.scheduler;

import com.bridge.sme.util.EmailSenderUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class DailyProspectAlert {

    @Autowired
    EmailSenderUtility emailSenderUtility;

    @Scheduled(cron = "* 5 * * * ?")
    public void prospectEmailAlert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }
}
