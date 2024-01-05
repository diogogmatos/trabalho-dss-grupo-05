package ESIdealLN.Servicos;

import java.time.LocalDateTime;
import java.util.List;

public interface IGesServicos {
    /**
     *
     * @param nrCartao
     */
    public boolean temServicosAtribuidos(int nrCartao);

    /**
     *
     * @param nrCartao
     */
    public ServicoAgendado getServicoPendente(int nrCartao);

    /**
     *
     * @param designacao
     * @param tipo
     */
    public boolean adicionarServicoDisponivel(String designacao, String tipo);

    /**
     *
     * @param designacao
     */
    public boolean removerServicoDisponivel(String designacao);

    /**
     *
     * @param matricula
     * @param designacaoServicos
     */
    public List<Integer> agendarServicos(String matricula, List<String> designacaoServicos);

    /**
     *
     * @param matricula
     */
    public boolean veiculoTemServicosPendentes(String matricula);

    /**
     *
     * @param matricula
     */
    public boolean veiculoTemServicosConcluidos(String matricula);

    /**
     *
     * @param nrMarcacao
     */
    public void concluirServico(int nrMarcacao);

    /**
     *
     * @param servicos
     */
    public LocalDateTime calcularHoraConclusao(List<Integer> servicos);
}