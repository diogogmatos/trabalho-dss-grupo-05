package ESIdealLN.Veiculos;

import java.util.List;

public interface IGesVeiculos {
    /**
     *
     * @param nif
     * @param matricula
     * @param tipo
     */
    public void adicionarVeiculo(String nif, String matricula, String tipo) throws Exception;

    /**
     *
     * @param matricula
     */
    public boolean verificarRegistoVeiculo(String matricula) throws Exception;

    /**
     *
     * @param nif
     * @param matricula
     */
    public boolean validarDonoVeiculo(String nif, String matricula) throws Exception;

    /**
     *
     * @param matricula
     */
    public Veiculo getVeiculo(String matricula) throws Exception;

    /**
     *
     * @param matricula
     * @param tipoServico
     */
    public boolean validarCompatibilidadeVeiculo(String matricula, String tipoServico) throws Exception;

    /**
     *
     * @param matricula
     */
    public List<String> obterTipoServicosCompativeis(String matricula) throws Exception;

    public List<Veiculo> getVeiculos() throws Exception;
}