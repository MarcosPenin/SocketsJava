package ejemplo10;

public class Curso {
	private String id;
	private String descripcion;
	
	public Curso() {}
	
	
	public Curso(String id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
