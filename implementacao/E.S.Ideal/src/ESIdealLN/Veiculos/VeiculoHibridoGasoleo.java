package ESIdealLN.Veiculos;

public class VeiculoHibridoGasoleo extends Veiculo {
    public VeiculoHibridoGasoleo(String matricula, String nifCliente) {
        super(matricula, nifCliente);
    }

    public String getTipoMotor() {
        return "hibridoglo";
    }

    /**
     *
     * @param tipoServico
     */
    public boolean validarCompatibilidade(String tipoServico) {
        return switch (tipoServico) {
            case "universal", "combustao", "gasoleo", "eletrico", "hibrido" -> true;
            default -> false;
        };
    }
}