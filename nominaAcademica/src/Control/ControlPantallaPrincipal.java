package Control;

import view.*;
import Model.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Daniel
 */
public class ControlPantallaPrincipal {
    private ArrayList<Profesor> listaDeProfesores;
    private ArrayList<Administrativo> listaDeAdministrativos;
    private ArrayList<Producto> listaDeProductos;
    private ArrayList<Proyecto> listaDeProyectos;
    private jfrPrincipal Pantalla;
    private jftAniadirEmpleado pantallaAniadir;

    public ControlPantallaPrincipal() {
    }
    
    public ControlPantallaPrincipal(jfrPrincipal Pantalla, jftAniadirEmpleado pantallaAniadir) {
        this.listaDeProfesores = new ArrayList<>();
        this.listaDeAdministrativos = new ArrayList<>();
        this.listaDeProductos = new ArrayList<>();
        this.listaDeProyectos = new ArrayList<>();
        this.Pantalla = Pantalla;
        this.pantallaAniadir = pantallaAniadir;
        
        ControlPantallaAniadirEmpleado controlAniadir = new ControlPantallaAniadirEmpleado(Pantalla, pantallaAniadir, this);
        
        initedEvent();
    }
    
    public void initedEvent(){
        Pantalla.btmAniadirProfe.addActionListener((e) -> aniadirProfe());
        Pantalla.btmAniadirAdmin.addActionListener((e) -> aniadirAdmin());
        Pantalla.btmInformacionProfesor.addActionListener((e) -> InformacionProfesor());
        Pantalla.btmInformacionAdmin.addActionListener((e) -> InformacionAdmin());
        Pantalla.btmCalcularAntiguedadProfe.addActionListener((e) -> antiguedadProfe());
        Pantalla.btmCacularAntiguedadAdmin.addActionListener((e) -> antiguedadAdmin());
        Pantalla.btmCalcularSalarioProfe.addActionListener((e) -> CalcularSalarioProf());
        Pantalla.btmCalcularSalarioAdmin.addActionListener((e) -> CalcularSalarioAdmin());
        
        // Eventos de registro usando la interfaz gráfica
        Pantalla.btmRegistrarProyecto.addActionListener((e) -> RegistarProyecto());
        Pantalla.btmRegistrarProducto.addActionListener((e) -> RegistarProducto());
        
        // Listeners para cambio de selección dinámica en consultas
        Pantalla.cmbProductosRegistradosMostrarInfo.addActionListener((e) -> mostrarInformacionProductoSeleccionado());
        Pantalla.cmbProyectosAgregadosVerInformacion.addActionListener((e) -> mostrarInformacionProyectoSeleccionado());
    }

    private void aniadirProfe() {
        pantallaAniadir.cmbCargo.setSelectedItem("Profesor");
        pantallaAniadir.cmbCargo.setEnabled(false);
        pantallaAniadir.setVisible(true);
    }

    private void aniadirAdmin() {
        pantallaAniadir.cmbCargo.setSelectedItem("Administrativo");
        pantallaAniadir.cmbCargo.setEnabled(false);
        pantallaAniadir.setVisible(true);
    }

    public void actualizarComboProfesores() {
        Pantalla.cmbListadoDeProfesores.removeAllItems();
        Pantalla.cmbProfesorAniadirProyecto.removeAllItems(); // Llena el combo de la sección proyectos automáticamente
        
        for (Profesor p : listaDeProfesores) {
            String nombreCompleto = p.getNombre() + " " + p.getApellido();
            Pantalla.cmbListadoDeProfesores.addItem(nombreCompleto);
            Pantalla.cmbProfesorAniadirProyecto.addItem(nombreCompleto);
        }
    }

    public void actualizarComboAdministrativos() {
        Pantalla.cmbAdmins.removeAllItems();
        for (Administrativo a : listaDeAdministrativos) {
            Pantalla.cmbAdmins.addItem(a.getNombre() + " " + a.getApellido());
        }
    }

    private void InformacionProfesor() {
        int index = Pantalla.cmbListadoDeProfesores.getSelectedIndex();
        if (index < 0 || listaDeProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "No hay ningún profesor registrado o seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Profesor p = listaDeProfesores.get(index);
        String info = "ID: " + p.getId() + "\nNombre: " + p.getNombre() + " " + p.getApellido() + "\nCargo: " + p.getCargo() + "\nEspecialidad: " + p.getEspecialidad();
        Pantalla.txtInfoProfesores.setText(info);
    }

    private void InformacionAdmin() {
        int index = Pantalla.cmbAdmins.getSelectedIndex();
        if (index < 0 || listaDeAdministrativos.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "No hay ningún administrativo registrado o seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Administrativo a = listaDeAdministrativos.get(index);
        String info = "ID: " + a.getId() + "\nNombre: " + a.getNombre() + " " + a.getApellido() + "\nCargo: " + a.getCargo() + "\nBono Fijo: $" + a.getBonoFijo();
        Pantalla.txtInfoAdmins.setText(info);
    }

    private void antiguedadProfe() {
        int index = Pantalla.cmbListadoDeProfesores.getSelectedIndex();
        if (index < 0 || listaDeProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "Seleccione un profesor de la lista primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Profesor p = listaDeProfesores.get(index);
        Fecha fIngreso = p.getFechaIngreso();
        
        try {
            int dia = Integer.parseInt(fIngreso.getDia());
            int mes = Integer.parseInt(fIngreso.getMes());
            int anio = Integer.parseInt(fIngreso.getAnio());
            
            LocalDate fechaIngresoClase = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            
            Period periodo = Period.between(fechaIngresoClase, fechaActual);
            
            String mensaje = "El profesor " + p.getNombre() + " " + p.getApellido() + " tiene una antigüedad de:\n"
                    + periodo.getYears() + " años, "
                    + periodo.getMonths() + " meses y "
                    + periodo.getDays() + " días.";
                    
            JOptionPane.showMessageDialog(Pantalla, mensaje, "Antigüedad Profesor", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Pantalla, "Error en el formato de la fecha de ingreso.");
        }
    }

    private void antiguedadAdmin() {
        int index = Pantalla.cmbAdmins.getSelectedIndex();
        if (index < 0 || listaDeAdministrativos.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "Seleccione un administrativo de la lista primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Administrativo a = listaDeAdministrativos.get(index);
        Fecha fIngreso = a.getFechaIngreso();
        
        try {
            int dia = Integer.parseInt(fIngreso.getDia());
            int mes = Integer.parseInt(fIngreso.getMes());
            int anio = Integer.parseInt(fIngreso.getAnio());
            
            LocalDate fechaIngresoClase = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            
            Period periodo = Period.between(fechaIngresoClase, fechaActual);
            
            String mensaje = "El administrativo " + a.getNombre() + " " + a.getApellido() + " tiene una antigüedad de:\n"
                    + periodo.getYears() + " años, "
                    + periodo.getMonths() + " meses y "
                    + periodo.getDays() + " días.";
                    
            JOptionPane.showMessageDialog(Pantalla, mensaje, "Antigüedad Administrativo", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(Pantalla, "Error en el formato de la fecha de ingreso.");
        }
    }

    private void CalcularSalarioProf() {
        int index = Pantalla.cmbListadoDeProfesores.getSelectedIndex();
        if (index < 0 || listaDeProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "Seleccione un profesor de la lista primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Profesor p = listaDeProfesores.get(index);
        double salarioCalculado = 0;
        String detalleTipo = "";

        if (p instanceof ProfesorCatedratico) {
            ProfesorCatedratico pc = (ProfesorCatedratico) p;
            salarioCalculado = pc.getValorHora() * pc.getHorasTrabajadas();
            detalleTipo = "Catedrático (Horas * Valor Hora)";
        } else if (p instanceof ProfesorOcacional) {
            ProfesorOcacional po = (ProfesorOcacional) p;
            double base = Double.parseDouble(po.getStringSalarioBase());
            double extra = po.getHorasExtra() * po.getValorHora();
            salarioCalculado = base + extra;
            detalleTipo = "Ocasional (Salario Base + Horas Extra)";
        } else if (p instanceof ProfesorAsociado) {
            ProfesorAsociado pa = (ProfesorAsociado) p;
            salarioCalculado = Double.parseDouble(pa.getStringSalarioBase());
            detalleTipo = "Asociado (Salario Fijo)";
        }

        String infoActual = "ID: " + p.getId() + "\n"
                + "Nombre: " + p.getNombre() + " " + p.getApellido() + "\n"
                + "Tipo: " + detalleTipo + "\n"
                + "-----------------------------------\n"
                + "SALARIO TOTAL: $" + salarioCalculado;
                
        Pantalla.txtInfoProfesores.setText(infoActual);
    }

    private void CalcularSalarioAdmin() {
        int index = Pantalla.cmbAdmins.getSelectedIndex();
        if (index < 0 || listaDeAdministrativos.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "Seleccione un administrativo de la lista primero.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Administrativo a = listaDeAdministrativos.get(index);
        
        double salarioBase = Double.parseDouble(a.getStringSalarioBase());
        double bono = a.getBonoFijo();
        double salarioTotal = salarioBase + bono;
        
        String infoActual = "ID: " + a.getId() + "\n"
                + "Nombre: " + a.getNombre() + " " + a.getApellido() + "\n"
                + "Salario Base: $" + salarioBase + "\n"
                + "Bono Fijo: $" + bono + "\n"
                + "-----------------------------------\n"
                + "SALARIO TOTAL: $" + salarioTotal;
                
        Pantalla.txtInfoAdmins.setText(infoActual);
    }

    private void RegistarProyecto() {
        int indexProfesor = Pantalla.cmbProfesorAniadirProyecto.getSelectedIndex();
        if (indexProfesor < 0 || listaDeProfesores.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "Por favor, seleccione un profesor para asignarle el proyecto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nombreProyecto = Pantalla.txtNombreDelProyecto.getText().trim();
        String descripcionProyecto = Pantalla.txtDescripcionDelProyecto.getText().trim();
        
        if (nombreProyecto.isEmpty() || descripcionProyecto.isEmpty()) {
            JOptionPane.showMessageDialog(Pantalla, "Por favor, llene el Nombre y la Descripción del proyecto.", "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Profesor p = listaDeProfesores.get(indexProfesor);
        
        if (p.getListaDeProyectos() == null) {
            p.setListaDeProyectos(new ArrayList<>());
        }
        
        ArrayList<Producto> productosVacio = new ArrayList<>();
        Proyecto nuevoProyecto = new Proyecto(nombreProyecto, descripcionProyecto, productosVacio);
        
        p.getListaDeProyectos().add(nuevoProyecto);
        listaDeProyectos.add(nuevoProyecto);
        
        Pantalla.txtNombreDelProyecto.setText("");
        Pantalla.txtDescripcionDelProyecto.setText("");
        
        actualizarComponentesProyecto();
        
        // Forzar la selección del proyecto recién registrado para reflejar su info de inmediato
        if (!listaDeProyectos.isEmpty()) {
            Pantalla.cmbProyectosAgregadosVerInformacion.setSelectedIndex(listaDeProyectos.size() - 1);
        }
        
        JOptionPane.showMessageDialog(Pantalla, "Proyecto '" + nombreProyecto + "' registrado y asignado con éxito al profesor " + p.getNombre(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    private void RegistarProducto() {
        try {
            String nombre = Pantalla.txtNombreDelProducto.getText().trim();
            String tipo = Pantalla.txtTipoDeProducto.getText().trim();
            String puntosStr = Pantalla.txtPuntosDelProducto.getText().trim();

            if (nombre.isEmpty() || tipo.isEmpty() || puntosStr.isEmpty()) {
                JOptionPane.showMessageDialog(Pantalla, "Por favor, llene todos los campos de la sección Registrar un Producto.", "Campos Vacíos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int puntos = Integer.parseInt(puntosStr);

            Producto nuevoProducto = new Producto(nombre, tipo, puntos);
            listaDeProductos.add(nuevoProducto);

            Pantalla.txtNombreDelProducto.setText("");
            Pantalla.txtTipoDeProducto.setText("");
            Pantalla.txtPuntosDelProducto.setText("");

            actualizarComponentesProducto();

            if (!listaDeProductos.isEmpty()) {
                Pantalla.cmbProductosRegistradosMostrarInfo.setSelectedIndex(listaDeProductos.size() - 1);
            }

            JOptionPane.showMessageDialog(Pantalla, "Producto registrado con éxito en el sistema.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(Pantalla, "El campo 'Puntos' debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarComponentesProducto() {
        java.awt.event.ActionListener[] listeners = Pantalla.cmbProductosRegistradosMostrarInfo.getActionListeners();
        for (java.awt.event.ActionListener al : listeners) {
            Pantalla.cmbProductosRegistradosMostrarInfo.removeActionListener(al);
        }

        Pantalla.txtInfoProductosRegistrados.setText("");
        Pantalla.cmbProductosRegistradosMostrarInfo.removeAllItems();
        Pantalla.cmbProductosRegistradosAniadirAlProyecto.removeAllItems();

        for (Producto prod : listaDeProductos) {
            Pantalla.txtInfoProductosRegistrados.append("Nombre: " + prod.getNombre() + "\n");
            Pantalla.txtInfoProductosRegistrados.append("Tipo: " + prod.getTipo() + "\n");
            Pantalla.txtInfoProductosRegistrados.append("Puntos: " + prod.getPuntos() + "\n");
            Pantalla.txtInfoProductosRegistrados.append("---------------------------------------\n");

            Pantalla.cmbProductosRegistradosMostrarInfo.addItem(prod.getNombre());
            Pantalla.cmbProductosRegistradosAniadirAlProyecto.addItem(prod.getNombre());
        }

        for (java.awt.event.ActionListener al : listeners) {
            Pantalla.cmbProductosRegistradosMostrarInfo.addActionListener(al);
        }
    }

    private void actualizarComponentesProyecto() {
        java.awt.event.ActionListener[] listeners = Pantalla.cmbProyectosAgregadosVerInformacion.getActionListeners();
        for (java.awt.event.ActionListener al : listeners) {
            Pantalla.cmbProyectosAgregadosVerInformacion.removeActionListener(al);
        }

        Pantalla.cmbProyectosAgregadosVerInformacion.removeAllItems();
        for (Proyecto proy : listaDeProyectos) {
            Pantalla.cmbProyectosAgregadosVerInformacion.addItem(proy.getCodigo()); 
        }

        for (java.awt.event.ActionListener al : listeners) {
            Pantalla.cmbProyectosAgregadosVerInformacion.addActionListener(al);
        }
    }

    private void mostrarInformacionProductoSeleccionado() {
        int index = Pantalla.cmbProductosRegistradosMostrarInfo.getSelectedIndex();
        
        if (index < 0 || listaDeProductos.isEmpty()) {
            Pantalla.txtInfoProductosRegistrados.setText("");
            return;
        }
        
        Producto prod = listaDeProductos.get(index);
        
        String info = "INFORMACIÓN DEL PRODUCTO\n"
                    + "=======================\n"
                    + "Nombre: " + prod.getNombre() + "\n"
                    + "Tipo: " + prod.getTipo() + "\n"
                    + "Puntos: " + prod.getPuntos();
        
        Pantalla.txtInfoProductosRegistrados.setText(info);
    }

    private void mostrarInformacionProyectoSeleccionado() {
        int index = Pantalla.cmbProyectosAgregadosVerInformacion.getSelectedIndex();
        
        if (index < 0 || listaDeProyectos.isEmpty()) {
            Pantalla.txtInformacionDeLosProyectos.setText("");
            return;
        }
        
        Proyecto proy = listaDeProyectos.get(index);
        
        // Buscar el profesor asignado al proyecto para complementar la consulta visual
        String profesorAsignado = "No asignado";
        for (Profesor prof : listaDeProfesores) {
            if (prof.getListaDeProyectos() != null && prof.getListaDeProyectos().contains(proy)) {
                profesorAsignado = prof.getNombre() + " " + prof.getApellido();
                break;
            }
        }
        
        String info = "INFORMACIÓN DEL PROYECTO\n"
                    + "=======================\n"
                    + "Nombre/Código: " + proy.getCodigo() + "\n"
                    + "Descripción: " + proy.getDescripcion() + "\n"
                    + "Profesor Líder: " + profesorAsignado + "\n"
                    + "Productos Asociados: " + (proy.getListaDeProductos() != null ? proy.getListaDeProductos().size() : 0);
        
        Pantalla.txtInformacionDeLosProyectos.setText(info);
    }

    // Getters y Setters
    public ArrayList<Profesor> getListaDeProfesores() { return listaDeProfesores; }
    public void setListaDeProfesores(ArrayList<Profesor> listaDeProfesores) { this.listaDeProfesores = listaDeProfesores; }
    public ArrayList<Administrativo> getListaDeAdministrativos() { return listaDeAdministrativos; }
    public void setListaDeAdministrativos(ArrayList<Administrativo> listaDeAdministrativos) { this.listaDeAdministrativos = listaDeAdministrativos; }
    public ArrayList<Producto> getListaDeProductos() { return listaDeProductos; }
    public void setListaDeProductos(ArrayList<Producto> listaDeProductos) { this.listaDeProductos = listaDeProductos; }
    public ArrayList<Proyecto> getListaDeProyectos() { return listaDeProyectos; }
    public void setListaDeProyectos(ArrayList<Proyecto> listaDeProyectos) { this.listaDeProyectos = listaDeProyectos; }
    public jfrPrincipal getPantalla() { return Pantalla; }
    public void setPantalla(jfrPrincipal Pantalla) { this.Pantalla = Pantalla; }
    public jftAniadirEmpleado getPantallaAniadir() { return pantallaAniadir; }
    public void setPantallaAniadir(jftAniadirEmpleado pantallaAniadir) { this.pantallaAniadir = pantallaAniadir; }
}