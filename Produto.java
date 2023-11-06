public class Produto {

    int codigo;
    String nome;
    String tipo;
    double valor;
    int estoque;

    public Produto(int codigo, String nome, String tipo, double valor, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.estoque = estoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Nome: " + nome + "\n" +
                "Tipo: " + tipo + "\n" +
                "Valor: " + valor + "\n" +
                "Estoque: " + estoque + "\n";
    }
}
