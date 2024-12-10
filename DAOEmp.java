package DptoEmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEmp {
    Connection conn;

    public DAOEmp() {
        conn= DB.getConexion();
    }

    public boolean insertEmpleado(DTOEmpl empleado) throws SQLException {
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("INSERT INTO empleados(id,nombre,edad, dpto_id) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, empleado.getId());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setInt(3, empleado.getEdad());
            preparedStatement.setInt(4, empleado.getId_Dpto());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public DTOEmpl getEmpleadobyId(int id)  throws SQLException{
        DTOEmpl empleado= null;
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM empleados WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            if(resultSet.next()){
                empleado= new DTOEmpl(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),resultSet.getInt("dpto_id"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return empleado;
    }

    public List<DTOEmpl> getAllEmpleados(){
        List<DTOEmpl> listaEmpleados= new ArrayList<DTOEmpl>();
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM empleados");
            ResultSet resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                DTOEmpl empleado= new DTOEmpl(resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),resultSet.getInt("dpto_id"));
                listaEmpleados.add(empleado);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
       return listaEmpleados;
    }

    public boolean deleteEmpleado(int id) throws SQLException {
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("DELETE FROM empleados WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateEmpleado(int id, String nombre, int edad) throws SQLException {
        try{
            PreparedStatement ps= conn.prepareStatement("UPDATE empleados SET nombre=?, edad=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setInt(3, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateEmpleadoDpto(int id, String nombre, int edad, int dpto_id) throws SQLException {
        try{
            PreparedStatement ps= conn.prepareStatement("UPDATE empleados SET nombre=?, edad=?, dpto_id=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setInt(3, dpto_id);
            ps.setInt(4, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteEmpleadobyNombre(String nombre) throws SQLException {
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("DELETE FROM empleados WHERE nombre=?");
            preparedStatement.setString(1, nombre);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public List<DTOEmpl> getEmpleadosByDepartamento(int dptoId) throws SQLException {
        List<DTOEmpl> empleados = new ArrayList<>();
        DTOEmpl empleado = null;

        try {
            // Consulta para obtener empleados por ID de departamento
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM empleados WHERE dpto_id = ?");
            preparedStatement.setInt(1, dptoId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Crear un objeto empleado y agregarlo a la lista
                empleado = new DTOEmpl(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getInt("dpto_id")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

}
