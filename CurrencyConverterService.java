package com.example.currencyconverter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConverterService {

    private final Map<String, Double> exchangeRates;

    public CurrencyConverterService() {
        // Simulação de taxas de câmbio para algumas moedas
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); // Dólar Americano como referência
        exchangeRates.put("EUR", 0.85); // Euro
        exchangeRates.put("GBP", 0.75); // Libra Esterlina
        exchangeRates.put("BRL", 5.0);  // Real Brasileiro
        exchangeRates.put("JPY", 110.0); // Iene Japonês
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Moeda não suportada.");
        }
        double rateFrom = exchangeRates.get(fromCurrency);
        double rateTo = exchangeRates.get(toCurrency);
        return (amount / rateFrom) * rateTo;
    }

    public Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }
}
