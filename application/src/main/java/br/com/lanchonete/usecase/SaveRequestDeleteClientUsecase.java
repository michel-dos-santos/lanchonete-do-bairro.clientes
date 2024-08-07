package br.com.lanchonete.usecase;

import br.com.lanchonete.model.LogCode;
import br.com.lanchonete.model.RequestDeleteClient;
import br.com.lanchonete.port.repository.LogRepository;
import br.com.lanchonete.port.repository.RequestDeleteClientRepository;
import br.com.lanchonete.port.usecase.SaveRequestDeleteClient;

public class SaveRequestDeleteClientUsecase implements SaveRequestDeleteClient {

    private final LogRepository logRepository;
    private final RequestDeleteClientRepository requestDeleteClientRepository;

    public SaveRequestDeleteClientUsecase(RequestDeleteClientRepository requestDeleteClientRepository, LogRepository logRepository) {
        this.logRepository = logRepository;
        this.requestDeleteClientRepository = requestDeleteClientRepository;
    }

    @Override
    public RequestDeleteClient save(RequestDeleteClient requestDeleteClient) {
        logRepository.info(SaveRequestDeleteClientUsecase.class, LogCode.LogCodeInfo._0001);
        RequestDeleteClient requestDeleteClientSaved = requestDeleteClientRepository.save(requestDeleteClient);
        logRepository.info(SaveRequestDeleteClientUsecase.class, LogCode.LogCodeInfo._0003);

        return requestDeleteClientSaved;
    }
}
