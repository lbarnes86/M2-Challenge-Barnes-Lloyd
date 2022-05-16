package com.company.M2ChallengeBarnesLloyd.controller;



import com.company.M2ChallengeBarnesLloyd.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
public class MathSolutionController {

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution add( @RequestBody @Valid MathSolution sum) {

        sum.setAnswer(sum.getOperand1() + sum.getOperand2());
        sum.setOperation("add");


        return sum;
}

    @PostMapping("/subtract")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution subtract(@RequestBody @Valid MathSolution difference) {
        difference.setAnswer(difference.getOperand1() - difference.getOperand2());
        difference.setOperation("subtract");

        return difference;
    }

    @PostMapping("/multiply")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution multiply(@RequestBody @Valid MathSolution product) {
        product.setAnswer(product.getOperand1() * product.getOperand2());
        product.setOperation("multiply");

        return product;
    }
    @PostMapping("/divide")
    @ResponseStatus(value = HttpStatus.CREATED)
    public MathSolution divide(@RequestBody @Valid MathSolution quotient) {
//        quotient.setAnswer(quotient.getOperand1() / quotient.getOperand2());
//        quotient.setOperation("divide");

        if (quotient.getOperand1() == null || quotient.getOperand2() == null) {
            throw new IllegalArgumentException("Please enter a valid number");
        }
        else if (quotient.getOperand2() == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");

        } else {
            quotient.setAnswer(quotient.getOperand1() / quotient.getOperand2());
            quotient.setOperation("divide");
        }

        return quotient;
    }

}