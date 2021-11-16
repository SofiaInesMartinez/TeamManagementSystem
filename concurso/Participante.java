package concurso;

import java.util.ArrayList;

import concurso.filtros.Filtro;

public class Participante extends GrupoAbstracto {
	private int edad;
	private ArrayList<String> generosPreferidos;
	private ArrayList<String> idiomas;
	private ArrayList<String> instrumentos;

	public Participante(String nombre, int edad, ArrayList<String> generosPreferidos, ArrayList<String> idiomas,
			ArrayList<String> instrumentos) {
		super(nombre);
		this.edad = edad;
		this.generosPreferidos = new ArrayList<>(generosPreferidos);
		this.idiomas = new ArrayList<>(idiomas);
		this.instrumentos = new ArrayList<>(instrumentos);
	}

	public ArrayList<String> getListaInstrumentos() {
		ArrayList<String> lista = new ArrayList<>(instrumentos);
		return lista;
	}

	public ArrayList<String> getListaIdiomas() {
		ArrayList<String> lista = new ArrayList<>(idiomas);
		return lista;
	}

	public ArrayList<String> getListaGeneros() {
		ArrayList<String> lista = new ArrayList<>(generosPreferidos);
		return lista;
	}

	@Override //verifica si el participante habla cierto idioma
	public boolean hablaIdioma(String idioma) {
		return idiomas.contains(idioma);
	}

	@Override //verifica si el participante prefiere cierto genero
	public boolean prefiereGenero(String genero) {
		return generosPreferidos.contains(genero);
	}

	@Override //verifica si el participante toca cierto instrumento
	public boolean tocaInstrumento(String instrumento) {
		return instrumentos.contains(instrumento);
	}

	public void addGenero(String genero) {
		if (!generosPreferidos.contains(genero)) {
			generosPreferidos.add(genero);
		}
	}

	public void addInstrumento(String instrumento) {
		if (!instrumentos.contains(instrumento)) {
			instrumentos.add(instrumento);
		}
	}

	public void addIdioma(String idioma) {
		if (!idiomas.contains(idioma)) {
			idiomas.add(idioma);
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public int calcularIntegrantes() {
		return 1;
	}

	@Override //este metodo verifica si el participante cumple con cierto criterio para agregarlo al listado buscado
	public ArrayList<GrupoAbstracto> buscar(Filtro criterio) {
		ArrayList<GrupoAbstracto> participante = new ArrayList<GrupoAbstracto>();
		if (criterio.cumple(this)) {
			Participante p = new Participante(this.getNombre(), this.getEdad(), this.getListaGeneros(),
					this.getListaIdiomas(), this.getListaInstrumentos());
			participante.add(p);
		}
		return participante;
	}

	@Override //este metodo verifica la cantidad de intrumentos que toca el participante de cierto tema
	public int cantMiembrosInstrumentos(TemaMusical t) {
		ArrayList<String> instrumentos = t.getInstrumentosNecesarios();
		for (String i : instrumentos) {
			if (this.tocaInstrumento(i)) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int cantInstrumentos() {
		return this.getListaInstrumentos().size();
	}

	@Override
	public int cantGeneros() {
		return this.getListaGeneros().size();
	}

	@Override
	public int cantIdiomas() {
		return this.getListaIdiomas().size();
	}

}
