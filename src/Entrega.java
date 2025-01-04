public class Entrega {
    private int id; // Identificador único
    private String cliente; // Nome do cliente
    private String endereco; // Endereço de entrega
    private String produto; // Produto a ser entregue
    private String status; // Status da entrega

    // Construtor
    public Entrega(int id, String cliente, String endereco, String produto, String status) {
        this.id = id;
        this.cliente = cliente;
        this.endereco = endereco;
        this.produto = produto;
        this.status = status;
    }

    // Getters e Setters (para acessar e modificar os atributos)
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Entrega [ID: " + id + ", Cliente: " + cliente + ", Endereço: " + endereco +
                ", Produto: " + produto + ", Status: " + status + "]";
    }
}
