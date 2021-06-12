package modelo;

public class Livraria {
	
	private int codLivro;
	private double precov;
	private String nomeLivro;
	private double precoa;
	private String secLivro;
	private int qtdeLivro;
	String pesquisa;
	
	
	public Livraria() {
	}

	public Livraria(double precoa) {
		super();
		this.precoa = precoa;
	}
	
	public int getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}
	public double getPrecov() {
		return precov;
	}
	public void setPrecov(double precov) {
		this.precov = precov;
	}
	public String getNomeLivro() {
		return nomeLivro;
	}
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	public double getPrecoa() {
		return precoa;
	}
	public void setPrecoa(double precoa) {
		this.precoa = precoa;
	}
	public String getSecLivro() {
		return secLivro;
	}
	public void setSecLivro(String secLivro) {
		this.secLivro = secLivro;
	}
	public int getQtdeLivro() {
		return qtdeLivro;
	}
	public void setQtdeLivro(int qtdeLivro) {
		this.qtdeLivro = qtdeLivro;
	}
	
	public double calcularValor(){
		this.precov = this.precoa * 0.2;
		return precov;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
}
