package DptoEmpl;

import java.util.List;

public class DTODpto {
    int id;
    String nombre;
    List<DTOEmpl> listaEmp;

    public DTODpto(int id, String nombre,List<DTOEmpl> listaEmp) {
        this.id = id;
        this.nombre = nombre;
        this.listaEmp = listaEmp;
    }

    public DTODpto(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DTOEmpl> getListaEmp() {
        return listaEmp;
    }

    public void setListaEmp(List<DTOEmpl> listaEmp) {
        this.listaEmp = listaEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTODpto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaEmp=" + listaEmp +
                '}';
    }
}
