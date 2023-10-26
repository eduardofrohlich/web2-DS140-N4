package backend.lavanderia.relatorio.dto;

import java.time.LocalDate;

public record RelatorioReceitaDatasDTO(
		LocalDate dataInicial,
		LocalDate dataFinal) {
}