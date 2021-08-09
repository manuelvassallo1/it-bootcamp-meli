package java_3.practicaTM.ejercicio1;

public class Celular implements Precedable<Celular> {
    private Integer numero;
    private String titular;

    public Celular(Integer numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.titular.compareTo(celular.getTitular());
    }
}
