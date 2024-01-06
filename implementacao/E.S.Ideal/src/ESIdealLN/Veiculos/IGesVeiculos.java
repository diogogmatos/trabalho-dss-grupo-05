package ESIdealLN.Veiculos;

import java.util.List;

public interface IGesVeiculos {
    /**
     *
     * @param nif
     * @param matricula
     * @param tipo
     */
    public void adicionarVeiculo(String nif, String matricula, String tipo);

    /**
     *
     * @param matricula
     */
    public boolean verificarRegistoVeiculo(String matricula);

    /**
     *
     * @param nif
     * @param matricula
     */
    public boolean validarDonoVeiculo(String nif, String matricula);

    /**
     *
     * @param matricula
     */
    public Veiculo getVeiculo(String matricula);

    /**
     *
     * @param matricula
     * @param tipoServico
     */
    public boolean validarCompatibilidadeVeiculo(String matricula, String tipoServico);

    /**
     *
     * @param matricula
     */
    public List<String> obterTipoServicosCompativeis(String matricula);
}