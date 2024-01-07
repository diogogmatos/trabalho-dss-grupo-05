package ESIdealLN.Servicos;

import java.time.LocalTime;
import java.util.List;

public interface IGesServicos {
    /**
     *
     * @param tipoServico
     */
    public List<Servico> obterServicosDeTipo(String tipoServico) throws Exception;

    /**
     *
     * @param nrCartao
     */
    public boolean temServicosAtribuidos(int nrCartao) throws Exception;

    /**
     *
     * @param nrCartao
     */
    public ServicoAgendado getServicoPendente(int nrCartao) throws Exception;

    /**
     *
     * @param designacao
     * @param tipo
     */
    public int adicionarServicoDisponivel(String designacao, int tempoNecessario, String tipo) throws Exception;

    /**
     *
     * @param designacao
     */
    public void removerServicoDisponivel(String designacao) throws Exception;

    /**
     *
     * @param idServico
     */
    public Servico getServicoDisponivel(int idServico) throws Exception;

    /**
     *
     * @param matricula
     */
    public boolean veiculoTemServicosPendentes(String matricula) throws Exception;

    /**
     *
     * @param matricula
     */
    public boolean veiculoTemServicosConcluidos(String matricula) throws Exception;

    /**
     *
     * @param funcionarioOtimo
     * @param servico
     * @param fecho
     */
    public boolean analisarDisponibilidade(int funcionarioOtimo, Servico servico, LocalTime fecho) throws Exception;

    /**
     *
     * @param nrMarcacao
     */
    public void concluirServico(int nrMarcacao) throws Exception;

    /**
     *
     * @param nrMarcacao
     * @param motivo
     */
    public void marcarComoIncompleto(int nrMarcacao, String motivo) throws Exception;

    /**
     *
     * @param nrsMarcacao
     */
    public LocalTime calcularHoraConclusao(List<Integer> nrsMarcacao) throws Exception;
}