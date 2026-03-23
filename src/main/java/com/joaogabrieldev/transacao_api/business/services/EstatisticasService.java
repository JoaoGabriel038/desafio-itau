package com.joaogabrieldev.transacao_api.business.services;

import com.joaogabrieldev.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.joaogabrieldev.transacao_api.controller.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EstatisticasService {

    public final TransacaoService transacaoService;

    public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){
        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        DoubleSummaryStatistics estatiscasTransacoes = transacoes.stream()
                .mapToDouble(TransacaoRequestDTO::valor).summaryStatistics();

        return new EstatisticasResponseDTO(estatiscasTransacoes.getCount(),
                estatiscasTransacoes.getSum(),
                estatiscasTransacoes.getAverage(),
                estatiscasTransacoes.getMin(),
                estatiscasTransacoes.getMax());
    }

}
