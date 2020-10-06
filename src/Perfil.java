import java.util.Calendar;

public class Perfil {
	private char sexo;
	private Calendar dataNascimento;
	private String cidade;
	private String estado;
	private String telefone;
	private String descricao;
	private String foto;
	
	public Perfil(char sexo, Calendar dataNascimento, String cidade, String estado, String telefone, String descricao,
			String foto) {
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.descricao = descricao;
		this.foto = foto;
	}
	
	public String toString() {
		String out = "sexo: "+getSexo()+"\n";
		out = out +"dataNascimento: "+getDataNascimento().getTime()+"\n";
		out = out +"cidade: "+getCidade()+"\n";
		out = out +"estado: "+getEstado()+"\n";
		out = out +"telefone:"+getTelefone()+"\n";
		out = out +"descricao: "+getDescricao()+"\n";
		out = out +"foto: "+getFoto()+"\n";
		return out;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}
}
