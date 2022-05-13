package com.company.M2ChallengeBarnesLloyd.controller;

import com.company.M2ChallengeBarnesLloyd.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {
    //Convert months.
// Follow the code from recordStore activity.
    private static List<Month> monthList = new ArrayList<>(Arrays.asList(

            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December")
    ));

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByMonthNumber(@PathVariable int monthNumber) {
//        Using code from RecordStore assignment in RecordStoreController.
        Month foundMonth = null;

        for(Month month : monthList) {
            if (month.getMonthNumber() == monthNumber) {
                foundMonth = month;
                break;
            }

            if (monthNumber <1 || monthNumber > 12) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Month not found, incorrect entry.");
            }
        }
        return foundMonth;
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getRandomMonth() {

// Following code from https://www.baeldung.com/java-random-list-element & https://mkyong.com/java/java-return-a-random-item-from-a-list/.
        Random rand = new Random();
        int ranMonth = rand.nextInt(13);
        return monthList.get(ranMonth);

    }


}
