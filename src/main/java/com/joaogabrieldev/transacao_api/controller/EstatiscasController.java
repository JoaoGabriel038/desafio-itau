package com.joaogabrieldev.transacao_api.controller;

import com.joaogabrieldev.transacao_api.business.services.EstatisticasService;
import com.joaogabrieldev.transacao_api.business.services.TransacaoService;
import com.joaogabrieldev.transacao_api.controller.dtos.EstatisticasResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estatistica")
@RequiredArgsConstructor

public class EstatiscasController {

    private final EstatisticasService estatisticasService;

    public ResponseEntity<EstatisticasResponseDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervaloBusca ){
        return ResponseEntity.ok(estatisticasService.calcularEstatisticasTransacoes(intervaloBusca));
    }
}
