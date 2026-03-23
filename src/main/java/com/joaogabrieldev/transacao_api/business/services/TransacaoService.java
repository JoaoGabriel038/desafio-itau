package com.joaogabrieldev.transacao_api.business.services;

import com.joaogabrieldev.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.joaogabrieldev.transacao_api.infraestructure.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();


    public void adicionarTransacao(TransacaoRequestDTO dto) {

        log.info("Iniciado o processamento de gravar transacoes" + dto);

        if(dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora maiores que atual");
            throw new UnprocessableEntity("data hora maiores que a data hora atual");
        }
        if (dto.valor() <0) {
            log.error("Valor não pode menor que 0");
            throw new UnprocessableEntity("valor não pode ser menor que 0");
        }

        listaTransacoes.add(dto);
        log.info("Transações adicionadas com sucesso");

    }

    public void limparTransacoes() {
        log.info("Iniciado o processamento de deletar transacoes");
        listaTransacoes.clear();
        log.info("Transações deletadas com sucesso");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
        log.info("Iniciado as buscas de transacoes por tempo" + intervaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        log.info("Retorno de transacoes com sucesso");
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();

    }

}
