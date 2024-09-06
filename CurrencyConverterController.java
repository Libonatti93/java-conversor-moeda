package com.example.currencyconverter.controller;

import com.example.currencyconverter.service.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/converter")
public class CurrencyConverterController {

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @GetMapping
    public String showConverterForm(Model model) {
        model.addAttribute("currencies", currencyConverterService.getExchangeRates().keySet());
        return "converter";
    }

    @PostMapping
    public String convertCurrency(@RequestParam String fromCurrency,
                                  @RequestParam String toCurrency,
                                  @RequestParam double amount,
                                  Model model) {
        double result = currencyConverterService.convert(fromCurrency, toCurrency, amount);
        model.addAttribute("fromCurrency", fromCurrency);
        model.addAttribute("toCurrency", toCurrency);
        model.addAttribute("amount", amount);
        model.addAttribute("result", result);
        model.addAttribute("currencies", currencyConverterService.getExchangeRates().keySet());
        return "converter";
    }
}
