public class MoedaConvertida {
    private double taxaDeConversao;



    public MoedaConvertida(MoedaConvertidaJson novaMoeda) {
        this.taxaDeConversao=novaMoeda.conversion_rate();
    }

    public double converterMoeda(double valorConverter){
        return this.taxaDeConversao*valorConverter;
    }



}
