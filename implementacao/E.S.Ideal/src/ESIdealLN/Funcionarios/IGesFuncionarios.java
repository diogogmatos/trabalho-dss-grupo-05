package ESIdealLN.Funcionarios;

import ESIdealDL.RegistoServicoDAO;
import ESIdealDL.RegistoTurnoDAO;

import java.util.List;

public interface IGesFuncionarios {
    /**
     *
     * @param competencias
     */
    public void registarFuncionario(List<String> competencias);

    /**
     *
     * @param nrCartao
     */
    public boolean removerFuncionario(int nrCartao);

    /**
     *
     * @param nrCartao
     * @param nrPosto
     */
    public boolean autenticarFuncionario(int nrCartao, int nrPosto);

    /**
     *
     * @param competencias
     */
    public void adicionarCompetencias(List<String> competencias);

    /**
     *
     * @param competencias
     */
    public void removerCompetencias(List<String> competencias);

    /**
     *
     * @param nrCartao
     */
    public int iniciarTurno(int nrCartao);

    /**
     *
     * @param nrCartao
     * @param nrTurno
     */
    public void terminarTurno(int nrCartao, int nrTurno);

    /**
     *
     * @param nrCartao
     * @param nrMarcacao
     */
    public int iniciarServico(int nrCartao, int nrMarcacao);

    /**
     *
     * @param nrCartao
     * @param nrMarcacao
     */
    public void terminarServico(int nrCartao, int nrMarcacao);
}