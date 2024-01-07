package ESIdealLN.Veiculos;

import java.util.List;

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

    public List<String> obterTipoServicosCompativeis() {
        return List.of("universal", "combustao", "gasoleo", "eletrico");
    }
}