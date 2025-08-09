package conversor.model;

import com.google.gson.annotations.SerializedName;

public class Moeda {
    @SerializedName("base_code")
    private String base;
    @SerializedName("target_code")
    private String target;
    @SerializedName("conversion_rate")
    private double valor;

    public String getBase() {
        return base;
    }
    public String getTarget() {
        return target;
    }
    public double getValor() {
        return valor;
    }
}
