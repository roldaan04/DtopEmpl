package DptoEmpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Consola {
    public void consola() {

        DAOEmp emp = new DAOEmp();
        DAODpto dpto = new DAODpto();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("Ingrese su opcion:");
            System.out.println("1. Empleados");
            System.out.println("2. Dpto");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su opcion:");
                    System.out.println("1. Lista de empleados");
                    System.out.println("2. Insert empleado");
                    System.out.println("3. Eliminar empleado");
                    System.out.println("4. Modificar empleado");
                    System.out.println("5. Filtrar por ID");
                    System.out.println("6. Filtrar por departamento");
                    System.out.println("7. Salir");
                    int opcionEmp = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcionEmp) {
                        case 1:
                            try {
                                System.out.println(emp.getAllEmpleados());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Introduzca el id:");
                                int idEmp = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Introduzca el nombre:");
                                String nombreEmp = scanner.nextLine();
                                System.out.println("Introduzca la edad:");
                                int edadEmp = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Introduzca el departamento:");
                                int dpto_id = scanner.nextInt();
                                scanner.nextLine();
                                DTOEmpl emp1 = new DTOEmpl(idEmp, nombreEmp, edadEmp, dpto_id);
                                emp.insertEmpleado(emp1);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Introduzca el id a eliminar:");
                                int idEmp = scanner.nextInt();
                                scanner.nextLine();
                                emp.deleteEmpleado(idEmp);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            try {
                                System.out.println("Introduzca el id:");
                                int idEmp = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Introduzca el nombre:");
                                String nombreEmp = scanner.nextLine();
                                System.out.println("Introduzca la edad:");
                                int edadEmp = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Introduzca el departamento:");
                                int dpto_id = scanner.nextInt();
                                scanner.nextLine();
                                emp.updateEmpleadoDpto(idEmp, nombreEmp, edadEmp, dpto_id);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 5:
                            try {
                                System.out.println("Introduzca el id:");
                                int idEmp = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(emp.getEmpleadobyId(idEmp));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 6:
                            try {
                                System.out.println("Inserte el departamento");
                                int dpto_id = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(emp.getEmpleadosByDepartamento(dpto_id));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 7:
                            salir = true;
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Ingrese su opcion:");
                    System.out.println("1. Lista de dpto");
                    System.out.println("2. Insert dpto");
                    System.out.println("3. Eliminar dpto");
                    System.out.println("4. Modificar dpto");
                    System.out.println("5. Filtrar por ID");
                    System.out.println("6. Salir");
                    int opcionDpto = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcionDpto) {
                        case 1:
                            try {
                                System.out.println(dpto.getAllDepartamentos());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                System.out.println("Introduzca el nombre:");
                                String nombreDpto = scanner.nextLine();
                                DTODpto dpto1 = new DTODpto(nombreDpto);
                                dpto.insertDepartamento(dpto1);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Introduzca el id a eliminar:");
                                int idDpto = scanner.nextInt();
                                scanner.nextLine();
                                dpto.deleteDepartamento(idDpto);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 4:
                            try {
                                System.out.println("Introduzca el id a modificar:");
                                int idDpto = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Introduzca el nuevo nombre:");
                                String nombreDpto = scanner.nextLine();
                                dpto.updateDepartamento(idDpto, nombreDpto);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 5:
                            try {
                                System.out.println("Introduzca el id:");
                                int idDpto = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println(dpto.getDepartamentobyId(idDpto));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 6:
                            salir = true;
                            break;
                    }
                    break;
                case 3:
                    salir = true;
                    break;
            }
        }

    }
}

