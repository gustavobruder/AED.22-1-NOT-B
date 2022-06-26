package trabalho4;

public class Veiculo implements Comparable<Veiculo> {
    private String placa;
    private String modelo;
    private int ano;
    private String proprietario;

    public Veiculo() {
    }

    public Veiculo(String placa, String modelo, int ano, String proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    /* Função utilitaria para filtrar placas de uma colecao de veiculos */
    public static String[] FiltrarPlacas(Veiculo[] veiculos) {
        String[] placas = new String[veiculos.length];

        for (int i = 0; i < veiculos.length; i++) {
            placas[i] = veiculos[i].getPlaca();
        }

        return placas;
    }

    @Override
    public String toString() {
        return "Veiculo " + modelo + ", placa " + placa + ", ano " + ano + ", de " + proprietario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Veiculo other = (Veiculo) obj;
        if (placa == null) {
            if (other.getPlaca() != null)
                return false;
        } else if (!placa.equals(other.getPlaca()))
            return false;
        return true;
    }

    @Override
    public int compareTo(Veiculo outro) {
        return (this.getPlaca().compareTo(outro.getPlaca()));
    }
}