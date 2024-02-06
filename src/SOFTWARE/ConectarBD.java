package SOFTWARE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

public class ConectarBD {

    private Connection conexion;
    int IdUsuario;
    boolean Permisos;

    public ConectarBD() {
        this.conectar();
    }

    private void conectar() {

        String url = "jdbc:mysql://localhost:3306/mmpcapp2021";

        Properties propiedades = new Properties();
        propiedades.setProperty("user", "root");
        propiedades.setProperty("password", "12345");
        propiedades.setProperty("useSSL", "false");
        propiedades.setProperty("autoReconnect", "true");
        propiedades.setProperty("serverTimezone", "UTC");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection(url, propiedades);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida!");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void SetUsuarioSesion(int U) {
        IdUsuario = U;
    }

    public int GetUsuarioSesion() {
        return IdUsuario;
    }

    public void SetUsuarioPermiso(boolean p) {
        Permisos = p;
    }

    public boolean GetUsuarioPermiso() {
        return Permisos;
    }

    //////////////////////////////////////////////USUARIOS////////////////////////////////////////////////////////7
    public void RegistrarUsuario(String nom, String clav, String perm, int cre, boolean nue) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into usuario(Nombre, Clave, Permiso, Creador, Nuevo) values(?, ?, ?, ?,?)");
            enunciado.setString(1, nom);
            enunciado.setString(2, clav);
            enunciado.setString(3, perm);
            enunciado.setInt(4, cre);
            enunciado.setBoolean(5, nue);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] BuscarUsuario(int n) {
        String datos[] = new String[6];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From usuario Where IdUsuario = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdUsuario");
                datos[1] = resultado.getString("Nombre");
                datos[2] = resultado.getString("Clave");
                datos[3] = resultado.getString("Permiso");
                datos[4] = "" + resultado.getInt("Creador");
                datos[5] = "" + resultado.getBoolean("Nuevo");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void EliminarUsuario(int n) {
        int id;
        try {
            String[] sid = BuscarUsuario(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from Usuario where IdUsuario = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ModificarUsuario(int n, String nom, String clav, String perm) {
        int id;
        try {
            String[] sid = BuscarUsuario(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update Usuario set Nombre = ?, Clave = ?, Permiso = ? Where IdUsuario = ?");
            enunciado.setString(1, nom);
            enunciado.setString(2, clav);
            enunciado.setString(3, perm);
            enunciado.setInt(4, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Object[]> MostrarUsuario() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT UP.IdUsuario,UP.Nombre,UP.Clave,UP.Permiso,UC.Nombre AS 'Creador',UP.Nuevo FROM usuario UP INNER JOIN usuario UC ON UC.IdUsuario = UP.Creador");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdUsuario");
                String col2 = resultado.getString("Nombre");
                String col3 = resultado.getString("Clave");
                String col4 = resultado.getString("Permiso");
                String col5 = resultado.getString("Creador");
                boolean col6 = resultado.getBoolean("Nuevo");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarUsuario(int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;

            enunciado = conexion.prepareStatement("Select * From usuario");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT UP.IdUsuario,UP.Nombre,UP.Clave,UP.Permiso,UC.Nombre AS 'Creador',UP.Nuevo FROM usuario UP INNER JOIN usuario UC ON UC.IdUsuario = UP.Creador Where UP.Nombre =  '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT UP.IdUsuario,UP.Nombre,UP.Clave,UP.Permiso,UC.Nombre AS 'Creador',UP.Nuevo FROM usuario UP INNER JOIN usuario UC ON UC.IdUsuario = UP.Creador Where UP.Clave =  '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT UP.IdUsuario,UP.Nombre,UP.Clave,UP.Permiso,UC.Nombre AS 'Creador',UP.Nuevo FROM usuario UP INNER JOIN usuario UC ON UC.IdUsuario = UP.Creador Where UP.Permiso =  '" + Dato + "'");
            }
            if (c == 3) {
                Campo = "Creador";
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT UP.IdUsuario,UP.Nombre,UP.Clave,UP.Permiso,UC.Nombre AS 'Creador',UP.Nuevo FROM usuario UP INNER JOIN usuario UC ON UC.IdUsuario = UP.Creador Where UC.Nombre =  '" + Dato + "'");
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
            while (resultado.next()) {
                int col1 = resultado.getInt("IdUsuario");
                String col2 = resultado.getString("Nombre");
                String col3 = resultado.getString("Clave");
                String col4 = resultado.getString("Permiso");
                String col5 = resultado.getString("Creador");
                boolean col6 = resultado.getBoolean("Nuevo");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }

            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public void ModificarClave(int n, String clav) {
        int id;
        boolean nue = false;
        try {
            String[] sid = BuscarUsuario(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update Usuario set Clave = ?, Nuevo = ? Where IdUsuario = ?");
            enunciado.setString(1, clav);
            enunciado.setBoolean(2, nue);
            enunciado.setInt(3, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Clave Cambiada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////////////////////////// CLIENTES /////////////////////////////////////////
    public void RegistrarCliente(String nom, String app, String apm, String tel, String dir, String loc, String mail) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into cliente(Nombre, ApellidoPaterno, ApellidoMaterno, Telefono, Direccion, Localidad, Email) values(?, ?, ?, ?, ?, ?, ?)");
            enunciado.setString(1, nom);
            enunciado.setString(2, app);
            enunciado.setString(3, apm);
            enunciado.setString(4, tel);
            enunciado.setString(5, dir);
            enunciado.setString(6, loc);
            enunciado.setString(7, mail);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] BuscarCliente(int n) {
        String datos[] = new String[8];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From cliente Where IdCliente = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdCliente");
                datos[1] = resultado.getString("Nombre");
                datos[2] = resultado.getString("ApellidoPaterno");
                datos[3] = resultado.getString("ApellidoMaterno");
                datos[4] = resultado.getString("Telefono");
                datos[5] = resultado.getString("Direccion");
                datos[6] = resultado.getString("Localidad");
                datos[7] = resultado.getString("Email");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void EliminarCliente(int n) {
        int id;
        try {
            String[] sid = BuscarCliente(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from cliente where IdCliente = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ModificarCliente(int n, String nom, String app, String apm, String tel, String dir, String loc, String mail) {
        int id;
        try {
            String[] sid = BuscarCliente(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update Cliente set Nombre = ?, ApellidoPaterno = ?, ApellidoMaterno = ?, Telefono = ?, Direccion = ?, Localidad = ?, Email = ? Where IdCliente = ?");
            enunciado.setString(1, nom);
            enunciado.setString(2, app);
            enunciado.setString(3, apm);
            enunciado.setString(4, tel);
            enunciado.setString(5, dir);
            enunciado.setString(6, loc);
            enunciado.setString(7, mail);
            enunciado.setInt(8, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Object[]> MostrarCliente() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From cliente");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdCliente");
                String col2 = resultado.getString("Nombre");
                String col3 = resultado.getString("ApellidoPaterno");
                String col4 = resultado.getString("ApellidoMaterno");
                String col5 = resultado.getString("Telefono");
                String col6 = resultado.getString("Direccion");
                String col7 = resultado.getString("Localidad");
                String col8 = resultado.getString("Email");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarCliente(int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Dato;

            enunciado = conexion.prepareStatement("Select * From cliente");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where Nombre =  '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where ApellidoPaterno =  '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where ApellidoMaterno =  '" + Dato + "'");
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where Telefono =  '" + Dato + "'");
            }
            if (c == 4) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where Direccion =  '" + Dato + "'");
            }
            if (c == 5) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where Localidad =  '" + Dato + "'");
            }
            if (c == 6) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cliente Where Email =  '" + Dato + "'");
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdCliente");
                String col2 = resultado.getString("Nombre");
                String col3 = resultado.getString("ApellidoPaterno");
                String col4 = resultado.getString("ApellidoMaterno");
                String col5 = resultado.getString("Telefono");
                String col6 = resultado.getString("Direccion");
                String col7 = resultado.getString("Localidad");
                String col8 = resultado.getString("Email");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    ////////////////////////PROVEEDORES///////////////////////////////
    public ArrayList<Object[]> MostrarProveedor() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From proveedores");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdProveedor");
                String col2 = resultado.getString("Nombre");
                String col3 = resultado.getString("AreaTrabajo");
                String col4 = resultado.getString("Descripcion");
                String col5 = resultado.getString("Telefono");
                String col6 = resultado.getString("Email");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarProveedor(int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement("Select * From proveedores");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From proveedores Where Nombre =  '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From proveedores Where AreaTrabajo =  '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From proveedores Where Descripcion =  '" + Dato + "'");
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From proveedores Where Telefono =  '" + Dato + "'");
            }
            if (c == 4) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From proveedores Where Email =  '" + Dato + "'");
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdProveedor");
                String col2 = resultado.getString("Nombre");
                String col3 = resultado.getString("AreaTrabajo");
                String col4 = resultado.getString("Descripcion");
                String col5 = resultado.getString("Telefono");
                String col6 = resultado.getString("Email");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public String[] BuscarProveedor(int n) {
        String datos[] = new String[6];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From proveedores Where IdProveedor = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdProveedor");
                datos[1] = resultado.getString("Nombre");
                datos[2] = resultado.getString("AreaTrabajo");
                datos[3] = resultado.getString("Descripcion");
                datos[4] = resultado.getString("Telefono");
                datos[5] = resultado.getString("Email");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void RegistrarProveedor(String nom, String area, String desc, String tel, String email) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into Proveedores(Nombre, AreaTrabajo, Descripcion, Telefono, Email) values(?, ?, ?, ?, ?)");
            enunciado.setString(1, nom);
            enunciado.setString(2, area);
            enunciado.setString(3, desc);
            enunciado.setString(4, tel);
            enunciado.setString(5, email);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ModificarProveedor(int n, String nom, String area, String desc, String tel, String email) {
        int id;
        try {
            String[] sid = BuscarProveedor(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update proveedores set Nombre = ?, AreaTrabajo = ?, Descripcion = ?, Telefono = ?, Email = ? Where IdProveedor = ?");
            enunciado.setString(1, nom);
            enunciado.setString(2, area);
            enunciado.setString(3, desc);
            enunciado.setString(4, tel);
            enunciado.setString(5, email);
            enunciado.setInt(6, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarProveedor(int n) {
        int id;
        try {
            String[] sid = BuscarProveedor(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from proveedores where IdProveedor = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////////////////////Servicios////////////////////////////////////////
    public ArrayList<Object[]> MostrarServicio() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdServicio");
                int col2 = resultado.getInt("IdProveedor");
                String col3 = resultado.getString("Nombre");
                String col4 = resultado.getString("AreaTrabajo");
                String col5 = resultado.getString("ConceptoServicio");
                String col6 = resultado.getString("Descripcion");
                String col7 = resultado.getString("TipoCobro");
                int col8 = resultado.getInt("Costo");
                int col9 = resultado.getInt("Rangomaximo");
                int col10 = resultado.getInt("RangoMinimo");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9, col10};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarServicio(int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement("Select * From servicio");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where Nombre = '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where AreaTrabajo = '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where ConceptoServicio =  '" + Dato + "'");
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where Descripcion =  '" + Dato + "'");
            }
            if (c == 4) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where TipoCobro =  '" + Dato + "'");
            }
            if (c == 5) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where Costo = " + DatoNumero);
            }
            if (c == 6) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where Rangomaximo = " + DatoNumero);
            }
            if (c == 7) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT SE.IdServicio, SE.IdProveedor, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.Descripcion, SE.TipoCobro, SE.Costo, SE.Rangomaximo, SE.RangoMinimo FROM servicio SE INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor Where RangoMinimo = " + DatoNumero);
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdServicio");
                int col2 = resultado.getInt("IdProveedor");
                String col3 = resultado.getString("Nombre");
                String col4 = resultado.getString("AreaTrabajo");
                String col5 = resultado.getString("ConceptoServicio");
                String col6 = resultado.getString("Descripcion");
                String col7 = resultado.getString("TipoCobro");
                int col8 = resultado.getInt("Costo");
                int col9 = resultado.getInt("Rangomaximo");
                int col10 = resultado.getInt("RangoMinimo");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9, col10};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public void RegistrarServicio(int pro, String conc, String desc, String tipcob, int cost, int max, int min) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into servicio(IdProveedor, ConceptoServicio, Descripcion, TipoCobro, Costo, Rangomaximo, RangoMinimo) values(?, ?, ?, ?, ?, ?, ?)");
            enunciado.setInt(1, pro);
            enunciado.setString(2, conc);
            enunciado.setString(3, desc);
            enunciado.setString(4, tipcob);
            enunciado.setInt(5, cost);
            enunciado.setInt(6, max);
            enunciado.setInt(7, min);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] BuscarServicio(int n) {
        String datos[] = new String[8];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From servicio Where Idservicio = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdServicio");
                datos[1] = "" + resultado.getInt("IdProveedor");
                datos[2] = resultado.getString("ConceptoServicio");
                datos[3] = resultado.getString("Descripcion");
                datos[4] = resultado.getString("TipoCobro");
                datos[5] = "" + resultado.getInt("Costo");
                datos[6] = "" + resultado.getInt("Rangominimo");
                datos[7] = "" + resultado.getInt("RangoMaximo");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void ModificarServicio(int ser, int pro, String conc, String desc, String tipcob, int cost, int max, int min) {
        int id;
        try {
            String[] sid = BuscarServicio(ser);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update servicio set IdProveedor = ?, ConceptoServicio = ?, Descripcion = ?, TipoCobro = ?, Costo = ?, Rangomaximo = ?, RangoMinimo = ? Where IdServicio = ?");
            enunciado.setInt(1, pro);
            enunciado.setString(2, conc);
            enunciado.setString(3, desc);
            enunciado.setString(4, tipcob);
            enunciado.setInt(5, cost);
            enunciado.setInt(6, max);
            enunciado.setInt(7, min);
            enunciado.setInt(8, ser);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarServicio(int n) {
        int id;
        try {
            String[] sid = BuscarServicio(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from servicio where IdServicio = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////////////////////EVENTOS////////////////////////////////////////
    public ArrayList<Object[]> MostrarEvento() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT Ev.IdEvento, EV.IdCliente, CL.Nombre, EV.Fecha, EV.Invitados, EV.EventoTipo, EV.EventoEstado FROM evento EV INNER JOIN cliente CL ON CL.IdCliente = EV.IdCliente");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdEvento");
                int col2 = resultado.getInt("IdCliente");
                String col3 = resultado.getString("Nombre");
                String col4 = resultado.getString("Fecha");
                int col5 = resultado.getInt("Invitados");
                String col6 = resultado.getString("EventoTipo");
                String col7 = resultado.getString("EventoEstado");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarEvento(int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement("Select * From evento");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT Ev.IdEvento, EV.IdCliente, CL.Nombre, EV.Fecha, EV.Invitados, EV.EventoTipo, EV.EventoEstado FROM evento EV INNER JOIN cliente CL ON CL.IdCliente = EV.IdCliente Where CL.Nombre =  '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT Ev.IdEvento, EV.IdCliente, CL.Nombre, EV.Fecha, EV.Invitados, EV.EventoTipo, EV.EventoEstado FROM evento EV INNER JOIN cliente CL ON CL.IdCliente = EV.IdCliente Where EV.Fecha =  '" + Dato + "'");
            }
            if (c == 2) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT Ev.IdEvento, EV.IdCliente, CL.Nombre, EV.Fecha, EV.Invitados, EV.EventoTipo, EV.EventoEstado FROM evento EV INNER JOIN cliente CL ON CL.IdCliente = EV.IdCliente Where EV.Invitados =  " + DatoNumero);
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT Ev.IdEvento, EV.IdCliente, CL.Nombre, EV.Fecha, EV.Invitados, EV.EventoTipo, EV.EventoEstado FROM evento EV INNER JOIN cliente CL ON CL.IdCliente = EV.IdCliente Where EV.EventoTipo =  '" + Dato + "'");
            }
            if (c == 4) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT Ev.IdEvento, EV.IdCliente, CL.Nombre, EV.Fecha, EV.Invitados, EV.EventoTipo, EV.EventoEstado FROM evento EV INNER JOIN cliente CL ON CL.IdCliente = EV.IdCliente Where EV.EventoEstado =  '" + Dato + "'");
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdEvento");
                int col2 = resultado.getInt("IdCliente");
                String col3 = resultado.getString("Nombre");
                String col4 = resultado.getString("Fecha");
                int col5 = resultado.getInt("Invitados");
                String col6 = resultado.getString("EventoTipo");
                String col7 = resultado.getString("EventoEstado");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarEventoInner() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement(
                    "Select IdEvento,CONCAT(nombre, ' ',Apellidopaterno),Fecha,Invitados,EventoTipo,EventoEstado "
                    + "From evento"
                    + " INNER JOIN cliente USING(IdCliente) ");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdEvento");
                String col2 = resultado.getString("CONCAT(nombre, ' ',Apellidopaterno)");
                String col3 = resultado.getString("Fecha");
                String col4 = resultado.getString("Invitados");
                String col5 = resultado.getString("EventoTipo");
                String col6 = resultado.getString("EventoEstado");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public void RegistrarEvento(int cli, String fecha, int inv, String TipoEve, String EdoEve) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into Evento(IdCliente, Fecha, Invitados, EventoTipo, EventoEstado) values(?, ?, ?, ?, ?)");
            enunciado.setInt(1, cli);
            enunciado.setString(2, fecha);
            enunciado.setInt(3, inv);
            enunciado.setString(4, TipoEve);
            enunciado.setString(5, EdoEve);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] BuscarEvento(int n) {
        String datos[] = new String[6];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From evento Where IdEvento = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdEvento");
                datos[1] = resultado.getString("IdCliente");
                datos[2] = resultado.getString("Fecha");
                datos[3] = resultado.getString("Invitados");
                datos[4] = resultado.getString("EventoTipo");
                datos[5] = resultado.getString("EventoEstado");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void ModificarEvento(int n, int cli, String fecha, int inv, String TipoEve, String EdoEve) {
        int id;
        try {
            String[] sid = BuscarEvento(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update evento set IdCliente = ?, Fecha = ?, Invitados = ?, EventoTipo = ?, EventoEstado = ? Where IdEvento = ?");
            enunciado.setInt(1, cli);
            enunciado.setString(2, fecha);
            enunciado.setInt(3, inv);
            enunciado.setString(4, TipoEve);
            enunciado.setString(5, EdoEve);
            enunciado.setInt(6, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarEvento(int n) {
        int id;
        try {
            String[] sid = BuscarEvento(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from evento where IdEvento = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////////////////////////////REPORTES///////////////////////////////
    public ArrayList<Object[]> MostrarReporte() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT RE.IdReporte, RE.IdEvento, EV.EventoTipo AS 'Evento', EV.Fecha AS 'FechaEvento', RE.Fecha AS 'FechaReporte', RE.Asunto, RE.Descripcion, RE.Documento FROM reporte RE INNER JOIN evento EV ON EV.IdEvento = RE.IdEvento");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdReporte");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("Evento");
                String col4 = resultado.getString("FechaEvento");
                String col5 = resultado.getString("FechaReporte");
                String col6 = resultado.getString("Asunto");
                String col7 = resultado.getString("Descripcion");
                String col8 = resultado.getString("Documento");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarReporte(int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;

            enunciado = conexion.prepareStatement("Select * From reporte");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From reporte Where Evento =  '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From reporte Where FechaEvento =  '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From reporte Where FechaReporte =  '" + Dato + "'");
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From reporte Where Asunto =  '" + Dato + "'");
            }
            if (c == 4) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From reporte Where Descripcion =  '" + Dato + "'");
            }
            if (c == 5) {
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From reporte Where Documento =  '" + Dato + "'");
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdReporte");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("Evento");
                String col4 = resultado.getString("FechaEvento");
                String col5 = resultado.getString("FechaReporte");
                String col6 = resultado.getString("Asunto");
                String col7 = resultado.getString("Descripcion");
                String col8 = resultado.getString("Documento");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarReporteInner() {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement(
                    "Select r.IdReporte,e.IdEvento,CONCAT(c.nombre, ' ',c.Apellidopaterno),c.telefono,"
                    + "r.Fecha,r.Asunto,r.Descripcion,r.Documento From reporte r"
                    + " INNER JOIN Evento e USING(IdEvento) "
                    + " INNER JOIN Cliente c USING(IdCliente)");
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdReporte");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("CONCAT(c.nombre, ' ',c.Apellidopaterno)");
                String col4 = resultado.getString("telefono");
                String col5 = resultado.getString("Fecha");
                String col6 = resultado.getString("Asunto");
                String col7 = resultado.getString("Descripcion");
                String col8 = resultado.getString("Documento");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarFormatoReporte(int id) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT reporte.Fecha, reporte.Asunto, reporte.Descripcion, reporte.Documento, "
                    + "evento.Fecha AS 'FechaEvento', evento.EventoTipo, evento.EventoEstado, "
                    + "concat_ws(' ', cliente.Nombre, cliente.ApellidoPaterno, cliente.ApellidoMaterno) "
                    + "AS 'Nombre', cliente.Email FROM reporte INNER JOIN evento ON reporte.IdEvento = evento.IdEvento "
                    + "INNER JOIN cliente ON cliente.IdCliente = evento.IdCliente Where IdReporte = " + id);
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                String col1 = resultado.getString("Fecha");
                String col2 = resultado.getString("Asunto");
                String col3 = resultado.getString("Descripcion");
                String col4 = resultado.getString("Documento");
                String col5 = resultado.getString("FechaEvento");
                String col6 = resultado.getString("EventoTipo");
                String col7 = resultado.getString("EventoEstado");
                String col8 = resultado.getString("Nombre");
                String col9 = resultado.getString("Email");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public String[] BuscarReporte(int n) {
        String datos[] = new String[6];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From reporte Where IdReporte = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdReporte");
                datos[1] = "" + resultado.getInt("IdEvento");
                datos[2] = resultado.getString("Fecha");
                datos[3] = resultado.getString("Asunto");
                datos[4] = resultado.getString("Descripcion");
                datos[5] = resultado.getString("Documento");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void RegistrarReporte(int eve, String fecha, String asunto, String desc, String doc) {

        try {
            int resultado;
            ResultSet valE;
            PreparedStatement enunciado, val;

            boolean existe = false; //comprobar existe el idEvento en la bd

            val = conexion.prepareStatement("SELECT IdEvento FROM Evento WHERE IdEvento = '" + eve + "'");
            valE = val.executeQuery();
            while (valE.next()) {
                existe = true;
                if (existe == true) {
                    enunciado = conexion.prepareStatement("Insert into Reporte(IdEvento, Fecha, Asunto, Descripcion, Documento) values(?, ?, ?, ?, ?)");
                    enunciado.setInt(1, eve);
                    enunciado.setString(2, fecha);
                    enunciado.setString(3, asunto);
                    enunciado.setString(4, desc);
                    enunciado.setString(5, doc);
                    resultado = enunciado.executeUpdate();

                    if (resultado > 0) {
                        JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Guardar");
                    }
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "El evento ingresado no existe", "Error de captura", JOptionPane.ERROR_MESSAGE);
            }
            valE.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al Guardar los datos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ModificarReporte(int n, int eve, String fecha, String desc, String asunto, String doc) {
        int id;
        try {
            String[] sid = BuscarReporte(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update reporte set IdEvento = ?, Fecha = ?,Asunto=?, Descripcion = ?, Documento = ? Where IdReporte = ?");
            enunciado.setInt(1, eve);
            enunciado.setString(2, fecha);
            enunciado.setString(3, desc);
            enunciado.setString(4, asunto);
            enunciado.setString(5, doc);
            enunciado.setInt(6, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarReporte(int n) {
        int id;
        try {
            String[] sid = BuscarReporte(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from reporte where IdReporte = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////////////////////////EVENTODETALLE///////////////////////////////
    public ArrayList<Object[]> MostrarEventoDetalle(int idev) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT ED.IdEventoDetalle, ED.IdEvento, EV.EventoTipo AS 'Evento', EV.Fecha, ED.Detalle, ED.Descripcion FROM eventodetalle ED INNER JOIN evento EV ON EV.IdEvento = ED.IdEvento WHERE EV.IdEvento = " + idev);
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdEventoDetalle");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("Evento");
                String col4 = resultado.getString("Fecha");
                String col5 = resultado.getString("Detalle");
                String col6 = resultado.getString("Descripcion");
                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarEventoDetalle(int idev, int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement("Select * From eventodetalle");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ED.IdEventoDetalle, ED.IdEvento, EV.EventoTipo AS 'Evento', EV.Fecha, ED.Detalle, ED.Descripcion FROM eventodetalle ED INNER JOIN evento EV ON EV.IdEvento = ED.IdEvento WHERE EV.IdEvento = " + idev + " AND Evento = '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ED.IdEventoDetalle, ED.IdEvento, EV.EventoTipo AS 'Evento', EV.Fecha, ED.Detalle, ED.Descripcion FROM eventodetalle ED INNER JOIN evento EV ON EV.IdEvento = ED.IdEvento WHERE EV.IdEvento = " + idev + " AND Fecha = '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ED.IdEventoDetalle, ED.IdEvento, EV.EventoTipo AS 'Evento', EV.Fecha, ED.Detalle, ED.Descripcion FROM eventodetalle ED INNER JOIN evento EV ON EV.IdEvento = ED.IdEvento WHERE EV.IdEvento = " + idev + " AND Detalle = '" + Dato + "'");
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ED.IdEventoDetalle, ED.IdEvento, EV.EventoTipo AS 'Evento', EV.Fecha, ED.Detalle, ED.Descripcion FROM eventodetalle ED INNER JOIN evento EV ON EV.IdEvento = ED.IdEvento WHERE EV.IdEvento = " + idev + " AND Descripcion = '" + Dato + "'");
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdEventoDetalle");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("Evento");
                String col4 = resultado.getString("Fecha");
                String col5 = resultado.getString("Detalle");
                String col6 = resultado.getString("Descripcion");
                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public String[] BuscarEventoDetalle(int n) {
        String datos[] = new String[4];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From eventodetalle Where IdEventoDetalle = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdEventoDetalle");
                datos[1] = "" + resultado.getInt("IdEvento");
                datos[2] = resultado.getString("Detalle");
                datos[3] = resultado.getString("Descripcion");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void RegistrarEventoDetalle(int ide, String det, String desc) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into eventodetalle(IdEvento, Detalle, Descripcion) values(?, ?, ?)");
            enunciado.setInt(1, ide);
            enunciado.setString(2, det);
            enunciado.setString(3, desc);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ModificarEventoDetalle(int n, int ide, String det, String desc) {
        int id;
        try {
            String[] sid = BuscarProveedor(n);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update eventodetalle set IdEvento = ?, Detalle = ?, Descripcion = ? Where IdEventoDetalle = ?");
            enunciado.setInt(1, ide);
            enunciado.setString(2, det);
            enunciado.setString(3, desc);
            enunciado.setInt(4, n);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarEventoDetalle(int n) {
        int id;
        try {
            String[] sid = BuscarProveedor(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from eventodetalle where IdEventoDetalle = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////////////////////EventoServicios////////////////////////////////////////
    public ArrayList<Object[]> MostrarEventoServicio(int idev) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev);
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("ES.IdEventoServicio");
                int col2 = resultado.getInt("ES.IdEvento");
                int col3 = resultado.getInt("IdServicio");
                String col4 = resultado.getString("Nombre");
                String col5 = resultado.getString("AreaTrabajo");
                String col6 = resultado.getString("ConceptoServicio");
                String col7 = resultado.getString("TipoCobro");
                int col8 = resultado.getInt("Costo");
                int col9 = resultado.getInt("Cantidad");
                int col10 = resultado.getInt("RangoMinimo");
                int col11 = resultado.getInt("Rangomaximo");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarEventoServicio(int idev, int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement("Select * From eventoservicio");

            if (c == 0) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND PR.Nombre = '" + Dato + "'");
            }
            if (c == 1) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND PR.AreaTrabajo = '" + Dato + "'");
            }
            if (c == 2) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND SE.ConceptoServicio = '" + Dato + "'");
            }
            if (c == 3) {
                Dato = d;
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND SE.TipoCobro = '" + Dato + "'");
            }
            if (c == 4) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND SE.Costo = " + DatoNumero);
            }
            if (c == 5) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND ES.Cantidad = " + DatoNumero);
            }
            if (c == 6) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND SE.RangoMinimo = " + DatoNumero);
            }
            if (c == 7) {
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("SELECT ES.IdEventoServicio, ES.IdEvento, ES.IdServicio, PR.Nombre, PR.AreaTrabajo, SE.ConceptoServicio, SE.TipoCobro, SE.Costo, ES.Cantidad, SE.RangoMinimo, SE.Rangomaximo FROM eventoservicio ES INNER JOIN servicio SE ON SE.IdServicio = ES.IdServicio INNER JOIN proveedores PR ON PR.IdProveedor = SE.IdProveedor WHERE ES.IdEvento = " + idev + " AND SE.Rangomaximo = " + DatoNumero);
            }
            

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdEventoServicio");
                int col2 = resultado.getInt("IdEvento");
                int col3 = resultado.getInt("IdServicio");
                String col4 = resultado.getString("Nombre");
                String col5 = resultado.getString("AreaTrabajo");
                String col6 = resultado.getString("ConceptoServicio");
                String col7 = resultado.getString("TipoCobro");
                int col8 = resultado.getInt("Costo");
                int col9 = resultado.getInt("Cantidad");
                int col10 = resultado.getInt("RangoMinimo");
                int col11 = resultado.getInt("Rangomaximo");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public void RegistrarEventoServicio(int eve, int ser, int cant) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into eventoservicio(IdEvento, IdServicio, Cantidad) values(?, ?, ?)");
            enunciado.setInt(1, eve);
            enunciado.setInt(2, ser);
            enunciado.setInt(3, cant);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] BuscarEventoServicio(int n) {
        String datos[] = new String[4];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From eventoservicio Where IdEventoServicio = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                datos[0] = "" + resultado.getInt("IdEventoServicio");
                datos[1] = "" + resultado.getInt("IdEvento");
                datos[2] = "" + resultado.getInt("IdServicio");
                datos[3] = "" + resultado.getInt("Cantidad");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void ModificarEventoServicio(int eveser, int eve, int ser, int cant) {
        int id;
        try {
            String[] sid = BuscarServicio(eveser);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update eventoservicio set IdEvento = ?, IdServicio = ?, Cantidad = ? Where IdEventoServicio = ?");
            enunciado.setInt(1, eve);
            enunciado.setInt(2, ser);
            enunciado.setInt(3, cant);
            enunciado.setInt(4, eveser);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarEventoServicio(int n) {
        int id;
        try {
            String[] sid = BuscarServicio(n);
            id = Integer.parseInt(sid[0]);
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from eventoservicio where IdEventoServicio = ?");
            enunciado.setInt(1, id);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///////////////////////EventoCotizacion////////////////////////////////////////
    public ArrayList<Object[]> MostrarCotizacion(int idev) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From cotizacion Where IdEvento = " + idev);
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdCotizacion");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("CotizacionEstado");
                int col4 = resultado.getInt("Costo");
                String col5 = resultado.getString("Fecha");
                String col6 = resultado.getString("Detalles");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarCotizacion(int idev, int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement("Select * From cotizacion");

            if (c == 0) {
                Campo = "IdCotizacion";
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("Select * From cotizacion Where IdEvento = " + idev + " AND " + Campo + " = " + DatoNumero);
            }
            if (c == 1) {
                Campo = "CotizacionEstado";
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cotizacion Where IdEvento = " + idev + " AND " + Campo + " = " + Dato);
            }
            if (c == 2) {
                Campo = "Costo";
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement("Select * From cotizacion Where IdEvento = " + idev + " AND " + Campo + " = " + DatoNumero);
            }
            if (c == 3) {
                Campo = "Fecha";
                Dato = d;
                enunciado = conexion.prepareStatement("Select * From cotizacion Where IdEvento = " + idev + " AND " + Campo + " = " + Dato);
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                int col1 = resultado.getInt("IdCotizacion");
                int col2 = resultado.getInt("IdEvento");
                String col3 = resultado.getString("CotizacionEstado");
                int col4 = resultado.getInt("Costo");
                String col5 = resultado.getString("Fecha");
                String col6 = resultado.getString("Detalles");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5, col6};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public void RegistrarCotizacion(int idev, String est, int cos, String date, String det) {

        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Insert into cotizacion(IdEvento, CotizacionEstado, Costo, Fecha, Detalles) values(?, ?, ?, ?, ?)");
            enunciado.setInt(1, idev);
            enunciado.setString(2, est);
            enunciado.setInt(3, cos);
            enunciado.setString(4, date);
            enunciado.setString(5, det);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardando Datos", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] BuscarCotizacion(int n) {
        String datos[] = new String[6];
        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Select * From cotizacion Where IdCotizacion = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeQuery();

            if (resultado.next()) {
                String col1 = "" + resultado.getInt("IdCotizacion");
                String col2 = "" + resultado.getInt("IdEvento");
                String col3 = resultado.getString("CotizacionEstado");
                String col4 = "" + resultado.getInt("Costo");
                String col5 = resultado.getString("Fecha");
                String col6 = resultado.getString("Detalles");
                return datos;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void ModificarCotizacion(int idcot, String est) {
        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("Update cotizacion set CotizacionEstado = ? Where IdCotizacion = ?");
            enunciado.setString(1, est);
            enunciado.setInt(2, idcot);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Datos Actualizados");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarCotizacion(int n) {
        try {
            int resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement("delete from cotizacion where IdCotizacion = ?");
            enunciado.setInt(1, n);
            resultado = enunciado.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Object[]> MostrarCotizacionServicios(int idev) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            enunciado = conexion.prepareStatement(
                    "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                    + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                    + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev);
            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                String col1 = resultado.getString("Nombre");
                String col2 = resultado.getString("ConceptoServicio");
                String col3 = resultado.getString("TipoCobro");
                int col4 = resultado.getInt("Costo");
                int col5 = resultado.getInt("Cantidad");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public ArrayList<Object[]> MostrarCotizacionServicios(int idev, int c, String d) {
        ArrayList<Object[]> filas = new ArrayList<Object[]>();

        try {
            ResultSet resultado;
            PreparedStatement enunciado;
            String Campo;
            String Dato;
            int DatoNumero;

            enunciado = conexion.prepareStatement(
                    "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                    + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                    + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev);

            if (c == 0) {
                Campo = "proveedores.Nombre";
                Dato = d;
                enunciado = conexion.prepareStatement(
                        "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                        + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                        + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev + " AND " + Campo + " = " + Dato);
            }
            if (c == 1) {
                Campo = "servicio.ConceptoServicio";
                Dato = d;
                enunciado = conexion.prepareStatement(
                        "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                        + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                        + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev + " AND " + Campo + " = " + Dato);
            }
            if (c == 2) {
                Campo = "servicio.TipoCobro";
                Dato = d;
                enunciado = conexion.prepareStatement(
                        "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                        + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                        + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev + " AND " + Campo + " = " + Dato);
            }
            if (c == 3) {
                Campo = "servicio.Costo";
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement(
                        "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                        + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                        + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev + " AND " + Campo + " = " + DatoNumero);
            }
            if (c == 3) {
                Campo = "eventoservicio.Cantidad";
                DatoNumero = Integer.parseInt(d);
                enunciado = conexion.prepareStatement(
                        "SELECT proveedores.Nombre, servicio.ConceptoServicio, servicio.TipoCobro,"
                        + " servicio.Costo, eventoservicio.Cantidad FROM eventoservicio INNER JOIN servicio ON eventoservicio.IdServicio = servicio.IdServicio "
                        + "INNER JOIN proveedores ON proveedores.IdProveedor = servicio.IdProveedor Where eventoservicio.IdEvento = " + idev + " AND " + Campo + " = " + DatoNumero);
            }

            resultado = enunciado.executeQuery();

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
                return null;
            }

            while (resultado.next()) {
                String col1 = resultado.getString("Nombre");
                String col2 = resultado.getString("ConceptoServicio");
                String col3 = resultado.getString("TipoCobro");
                int col4 = resultado.getInt("Costo");
                int col5 = resultado.getInt("Cantidad");

                Object[] columnas = new Object[]{col1, col2, col3, col4, col5};
                filas.add(columnas);
            }
            return filas;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return filas;
    }

    public int CantidadInvitados(int IdEvento) {
        String[] arreglo;
        int inv;
        arreglo = BuscarEvento(IdEvento);
        inv = Integer.parseInt(arreglo[3]);
        return inv;
    }

}
