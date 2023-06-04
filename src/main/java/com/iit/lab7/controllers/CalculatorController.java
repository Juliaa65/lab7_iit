package com.iit.lab7.controllers;

import com.iit.lab7.model.MathOps;
import org.fluentd.logger.FluentLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CalculatorController {

    private static FluentLogger logger = FluentLogger.getLogger("app", "127.0.0.1",  24224);

    @GetMapping("/")
    public String showCalculator() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam int num1, @RequestParam int num2, @RequestParam(name = "operation") String operations, Model model) {
        MathOps calculator = new MathOps(num1, num2);
        Integer result = null;
        Double result2 = null;
        String message = "";
        Map<String, Object> data = new HashMap<>();
        data.put("number1", num1);
        data.put("number2", num2);
        data.put("operation", operations);
        if (operations.equals("add")) {
            result = calculator.add();
        } else if (operations.equals("subtract")) {
            result = calculator.subtract();
        } else if (operations.equals("multiply")) {
            result = calculator.multiply();
        } else if (operations.equals("divide")) {
            if (num2 != 0) {
                result2 = calculator.divide();
                data.put("double_result", result2);
            } else {
                message = "Dividing by zero is not allowed!!!";
                data.put("message", message);
            }
        }
        data.put("result", result);
        logger.log("Processed_data", data);
        model.addAttribute("result", result);
        model.addAttribute("result2", result2);
        model.addAttribute("message", message);
        return "calculator";
    }
}
