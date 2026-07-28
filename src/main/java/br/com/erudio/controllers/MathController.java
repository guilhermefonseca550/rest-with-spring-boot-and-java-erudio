package br.com.erudio.controllers;

import br.com.erudio.treatment.NumberOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")

public class MathController extends NumberOperations {

   private final NumberOperations numberOperations = new NumberOperations();


    @Override
    public Double sum(String numberOne, String numberTwo){

        return numberOperations.sum(numberOne, numberTwo);
    }

    @Override
    public Double subtraction(String numberOne, String numberTwo) {
        return numberOperations.subtraction(numberOne, numberTwo);
    }

    @Override
    public Double division(String numberOne, String numberTwo)   {
        return numberOperations.division(numberOne, numberTwo);
    }

    @Override
    public Double multiplier(String numberOne, String numberTwo){
        return numberOperations.multiplier(numberOne, numberTwo);
    }

    @Override
    public Double square(String number)  {
        return numberOperations.square(number);
    }

    @Override
    public Double mean(String numberOne, String numberTwo)  {
        return numberOperations.mean(numberOne, numberTwo);
    }
}
