package com.example.apiCall.controllers;


import com.example.apiCall.model.CurrenciesSymbols;
import com.example.apiCall.model.ExchangeCurrency;
import com.example.apiCall.model.Product;
import com.example.apiCall.service.currencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1/currency")
@RestController
public class CurrenciesController {
    private final currencyExchangeService forexService;

    @Autowired
    public CurrenciesController(currencyExchangeService forexService) {
        this.forexService = forexService;
    }

    //Check the symbols of all available currencies
    @GetMapping(path="symbol")
    public Mono<CurrenciesSymbols> checkAvailableCurrencySymbol(){
        return forexService.checkSymbols();
    }

    //select a currency and see the rates between the
    @GetMapping(path="rates")
    public Mono<ExchangeCurrency> testEndpoint2(@RequestParam(value="from") String from,
                                                @RequestParam(value="amount") int amount){
        return forexService.convertRatestoMYR(from, amount);
    }

}
