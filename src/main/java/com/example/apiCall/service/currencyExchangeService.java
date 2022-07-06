package com.example.apiCall.service;

import com.example.apiCall.model.CurrenciesSymbols;
import com.example.apiCall.model.ExchangeCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class currencyExchangeService {
    private final WebClient webClient;

    public currencyExchangeService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.apilayer.com/exchangerates_data").build();
    }

    public Mono<CurrenciesSymbols> checkSymbols(){
        log.info("Check All Currencies Symbols");
        return this.webClient.get()
                .uri("/symbols")
                .header("apikey","Ld481XAlejnMNHOV6VQHyvckzp4SvVXy")
                .retrieve()
                .bodyToMono(CurrenciesSymbols.class);
    }

        public Mono<ExchangeCurrency> convertRatestoMYR(String fromCurrency, int amount){
        log.info("Check Currencies Exchange Rate");
        Mono<ExchangeCurrency> ratesResult =  webClient.get()
                .uri("/convert?to=MYR" + "&from=" + fromCurrency + "&amount=" + amount)
                .header("apikey","Ld481XAlejnMNHOV6VQHyvckzp4SvVXy")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ExchangeCurrency.class);
//                .map(s -> s.getResult());
        return ratesResult;
    }
}




