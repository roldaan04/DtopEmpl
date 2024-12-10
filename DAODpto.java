package DptoEmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODpto{
    Connection conn;
    private DAOEmp daoEmpleado;
    public DAODpto() {
        conn= DB.getConexion();
        this.daoEmpleado = new DAOEmp();
    }

    public boolean insertDepartamento(DTODpto departamento) throws SQLException {
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("INSERT INTO departamento(id,nombre) VALUES (?,?)");
            preparedStatement.setInt(1, departamento.getId());
            preparedStatement.setString(2, departamento.getNombre());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public DTODpto getDepartamentobyId(int id)  throws SQLException{
        DTODpto departamento= null;
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("SELECT * FROM departamento WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                List<DTOEmpl> listaEmpleados= new ArrayList<>();
                listaEmpleados= daoEmpleado.getEmpleadosByDepartamento(resultSet.getInt("id"));
                departamento = new DTODpto(resultSet.getInt("id"), resultSet.getString("nombre"), listaEmpleados);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return departamento;
    }

    public List<DTODpto> getAllDepartamentos() throws SQLException {
        List<DTODpto> listaDepartamentos = new ArrayList<>();
        DTODpto departamento = null;

        try {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM departamento");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                departamento = new DTODpto(resultSet.getString("nombre"));
                departamento.setId(resultSet.getInt("id"));

                departamento.setListaEmp(daoEmpleado.getEmpleadosByDepartamento(departamento.getId()));
                listaDepartamentos.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDepartamentos;
    }

    public boolean deleteDepartamento(int id) throws SQLException {
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("DELETE FROM departamento WHERE id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateDepartamento(int id, String nombre) throws SQLException {
        try{
            PreparedStatement ps= conn.prepareStatement("UPDATE departamento SET nombre=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setInt(2, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteDepartamentobyNombre(String nombre) throws SQLException {
        try{
            PreparedStatement preparedStatement= conn.prepareStatement("DELETE FROM departamento WHERE nombre=?");
            preparedStatement.setString(1, nombre);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

}
