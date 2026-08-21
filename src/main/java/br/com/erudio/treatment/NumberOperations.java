package br.com.erudio.treatment;

import br.com.erudio.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



public class NumberOperations extends NumberTreatment {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo)
            throws IllegalArgumentException {
        if(!NumberTreatment.isNumeric(numberOne) || !NumberTreatment.isNumeric(numberTwo)) throw new ResourceNotFoundException(
                "Please set a numeric value");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne,
                              @PathVariable String numberTwo)
            throws IllegalArgumentException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("Please set a numeric value");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne,
                           @PathVariable String numberTwo) throws IllegalArgumentException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException("Please set a numeric value");{
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }

    } @RequestMapping("/multiplier/{numberOne}/{numberTwo}")
    public Double multiplier(@PathVariable String numberOne,
                             @PathVariable String numberTwo) throws IllegalArgumentException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException("Please set a numeric value");{
            return convertToDouble(numberOne) * convertToDouble(numberTwo);
        }

    }@RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable String numberOne,
                          @PathVariable String numberTwo) throws IllegalArgumentException {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new IllegalArgumentException("Please set a numeric value");{
            return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        }

    }@RequestMapping("/square/{number}")
    public Double square(@PathVariable String number) throws IllegalArgumentException {
        if (!isNumeric(number)) throw new IllegalArgumentException("Please set a numeric value");
        {
            return Math.sqrt(convertToDouble(number));
        }
    }
}
