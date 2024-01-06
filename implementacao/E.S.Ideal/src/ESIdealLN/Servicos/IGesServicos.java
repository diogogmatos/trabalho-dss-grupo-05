package ESIdealLN.Servicos;

import java.time.LocalTime;
import java.util.List;

public interface IGesServicos {
    /**
     *
     * @param tipoServico
     */
    public List<Servico> obterServicosDeTipo(String tipoServico);

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
     * @param idServico
     */
    public Servico getServicoDisponivel(int idServico);

    /**
     *
     * @param matricula
     * @param designacaoServicos
     */
    public List<Integer> agendarServicos(String matricula, List<String> designacaoServicos) throws Exception;

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
     * @param nrMarcacao
     * @param motivo
     */
    public void marcarComoIncompleto(int nrMarcacao, String motivo);

    /**
     *
     * @param servicos
     */
    public LocalTime calcularHoraConclusao(List<Integer> servicos);
}