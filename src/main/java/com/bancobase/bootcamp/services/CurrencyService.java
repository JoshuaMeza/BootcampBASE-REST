package com.bancobase.bootcamp.services;

import com.bancobase.bootcamp.dto.CurrencyDTO;
import com.bancobase.bootcamp.dto.response.*;
import com.bancobase.bootcamp.http.APIExchangeRateClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final APIExchangeRateClient apiExchangeRateClient;

    public CurrencyService(APIExchangeRateClient apiExchangeRateClient) {
        this.apiExchangeRateClient = apiExchangeRateClient;
    }

    public List<CurrencyDTO> getCurrencies() {
        ExchangeRateResponse exchangeRate = apiExchangeRateClient.getExchangeRate();
        SymbolsNameResponse symbolsName = apiExchangeRateClient.getSymbolsName();

        return CurrencyDTO
                .mergeExchangeRateAndSymbolsNameResponses(exchangeRate, symbolsName);
    }
}