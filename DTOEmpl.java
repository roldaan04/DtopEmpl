package DptoEmpl;

public class DTOEmpl {
    int id;
    String nombre;
    int edad;
    int dpto_id;

    public DTOEmpl(int id, String nombre, int edad, int dpto_id) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.dpto_id = dpto_id;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public int getId_Dpto() {
        return dpto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_Dpto(int dpto_id) {
        this.dpto_id = dpto_id;
    }



    @Override
    public String toString() {
        return "DTOEmpl{" +
                "edad=" + edad +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", id_Dpto=" + dpto_id +
                '}';
    }

}
