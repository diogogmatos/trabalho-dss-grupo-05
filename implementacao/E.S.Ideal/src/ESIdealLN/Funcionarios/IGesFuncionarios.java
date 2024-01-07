package ESIdealLN.Funcionarios;

import ESIdealDL.RegistoServicoDAO;
import ESIdealDL.RegistoTurnoDAO;

import java.util.List;

public interface IGesFuncionarios {
    /**
     *
     * @param competencias
     */
    public void registarFuncionario(List<String> competencias) throws Exception;

    /**
     *
     * @param nrCartao
     */
    public void removerFuncionario(int nrCartao) throws Exception;

    /**
     *
     * @param nrCartao
     */
    public boolean validaFuncionario(int nrCartao) throws Exception;

    /**
     *
     * @param competencias
     */
    public void adicionarCompetencias(int nrCartao, List<String> competencias) throws Exception;

    /**
     *
     * @param competencias
     */
    public void removerCompetencias(int nrCartao, List<String> competencias) throws Exception;

    /**
     *
     * @param nrCartao
     */
    public List<String> getCompetencias(int nrCartao) throws Exception;

    /**
     *
     * @param nrCartao
     */
    public int iniciarTurno(int nrCartao) throws Exception;

    /**
     *
     * @param nrCartao
     * @param nrTurno
     */
    public void terminarTurno(int nrTurno) throws Exception;

    /**
     *
     * @param competencia
     */
    public List<Integer> getFuncionariosComCompetencia(String competencia) throws Exception;

    /**
     *
     * @param nrTurno
     * @param nrMarcacao
     */
    public void iniciarServico(int nrTurno, int nrMarcacao) throws Exception;

    /**
     *
     * @param nrMarcacao
     */
    public void terminarServico(int nrMarcacao) throws Exception;

    public List<Funcionario> getFuncionarios() throws Exception;

    public List<RegistoTurno> getTurnos() throws Exception;

    public List<RegistoServico> getRegistoServicos() throws Exception;
}