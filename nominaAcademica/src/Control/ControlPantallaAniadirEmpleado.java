package Control;

import Model.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.jfrPrincipal;
import view.jftAniadirEmpleado;

/**
 *
 * @author Cristian Daniel
 */
public class ControlPantallaAniadirEmpleado {

    private jfrPrincipal pantalla;
    private jftAniadirEmpleado pantallaAniadir;
    private ControlPantallaPrincipal controlPantallaPrincipal;
    private ArrayList<Asignatura> listaDeMaterias;
    private ArrayList<Asignatura> listaDeAsignaturas = new ArrayList<>();

    public ControlPantallaAniadirEmpleado() {
    }

    public ControlPantallaAniadirEmpleado(
            jfrPrincipal pantalla,
            jftAniadirEmpleado pantallaAniadir,
            ControlPantallaPrincipal controlPantallaPrincipal) {

        this.pantalla = pantalla;
        this.pantallaAniadir = pantallaAniadir;
        this.controlPantallaPrincipal = controlPantallaPrincipal;
        this.listaDeMaterias = new ArrayList<>();
        
        
        ocultarCampos();
        initedEvent();
        
        
        precargarAsignaturas();

        pantallaAniadir.cmbMaterias.addActionListener(e -> {
            Asignatura materia = (Asignatura) pantallaAniadir.cmbMaterias.getSelectedItem();
            if (materia == null) return;
            pantallaAniadir.chekAniadirMateria.setSelected(listaDeMaterias.contains(materia));
        });

        pantallaAniadir.chekAniadirMateria.addActionListener(e -> {
            Asignatura materia = (Asignatura) pantallaAniadir.cmbMaterias.getSelectedItem();
            if (materia == null) return;

            if (pantallaAniadir.chekAniadirMateria.isSelected()) {
                if (!listaDeMaterias.contains(materia)) {
                    listaDeMaterias.add(materia);
                }
            } else {
                listaDeMaterias.remove(materia);
            }
        });
    }

    private void ocultarCampos() {
        pantallaAniadir.jblEspecialidad.setVisible(false);
        pantallaAniadir.jblMateria.setVisible(false);
        pantallaAniadir.jblTipoProfesor.setVisible(false);
        pantallaAniadir.txtEspecialidad.setVisible(false);
        pantallaAniadir.cmbTipoDeProfesor.setVisible(false);
        pantallaAniadir.cmbMaterias.setVisible(false);
        pantallaAniadir.chekAniadirMateria.setVisible(false);
        pantallaAniadir.jblHorasTrabajadas.setVisible(false);
        pantallaAniadir.jblValorHora.setVisible(false);
        pantallaAniadir.txtHorasTrabajadas.setVisible(false);
        pantallaAniadir.txtValorHoraTrabajada.setVisible(false);
    }

    public void initedEvent() {
        pantallaAniadir.btmAniadirEmpleado.addActionListener(e -> aniadir());

        pantallaAniadir.cmbCargo.addActionListener(e -> {
            String cargo = pantallaAniadir.cmbCargo.getSelectedItem().toString();

            if (cargo.equals("Profesor")) {
                pantallaAniadir.jblEspecialidad.setText("Especialidad");
                pantallaAniadir.jblEspecialidad.setVisible(true);
                pantallaAniadir.jblMateria.setVisible(true);
                pantallaAniadir.jblTipoProfesor.setVisible(true);
                pantallaAniadir.txtEspecialidad.setVisible(true);
                pantallaAniadir.cmbTipoDeProfesor.setVisible(true);
                pantallaAniadir.cmbMaterias.setVisible(true);
                pantallaAniadir.chekAniadirMateria.setVisible(true);
                
                if (pantallaAniadir.cmbTipoDeProfesor.getSelectedItem() != null) {
                    actualizarCamposPorTipoProfesor(pantallaAniadir.cmbTipoDeProfesor.getSelectedItem().toString());
                }
            } else {
                ocultarCampos();
                pantallaAniadir.jblEspecialidad.setText("Bono Fijo ($)");
                pantallaAniadir.jblEspecialidad.setVisible(true);
                pantallaAniadir.txtEspecialidad.setVisible(true);
            }
        });

        pantallaAniadir.cmbTipoDeProfesor.addActionListener(e -> {
            if (!pantallaAniadir.cmbCargo.getSelectedItem().toString().equals("Profesor")) return;
            String tipo = pantallaAniadir.cmbTipoDeProfesor.getSelectedItem().toString();
            actualizarCamposPorTipoProfesor(tipo);
        });
    }

    private void actualizarCamposPorTipoProfesor(String tipo) {
        if (tipo.equals("Catedratico") || tipo.equals("Ocasional")) {
            pantallaAniadir.jblHorasTrabajadas.setVisible(true);
            pantallaAniadir.jblValorHora.setVisible(true);
            pantallaAniadir.txtHorasTrabajadas.setVisible(true);
            pantallaAniadir.txtValorHoraTrabajada.setVisible(true);
        } else {
            pantallaAniadir.jblHorasTrabajadas.setVisible(false);
            pantallaAniadir.jblValorHora.setVisible(false);
            pantallaAniadir.txtHorasTrabajadas.setVisible(false);
            pantallaAniadir.txtValorHoraTrabajada.setVisible(false);
        }
    }

    private void aniadir() {
        String id = pantallaAniadir.txtId.getText().trim();
        String nombre = pantallaAniadir.txtNombre.getText().trim();
        String apellido = pantallaAniadir.txtApellido.getText().trim();
        String dia = pantallaAniadir.txtDiaDeIngreso.getText().trim();
        String mes = pantallaAniadir.txtMesdeIngreso.getText().trim();
        String anio = pantallaAniadir.txtAnioDeIngreso.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || dia.isEmpty() || mes.isEmpty() || anio.isEmpty()) {
            JOptionPane.showMessageDialog(pantallaAniadir, "Complete todos los campos obligatorios");
            return;
        }

        Fecha fecha = new Fecha(dia, mes, anio);
        String cargo = pantallaAniadir.cmbCargo.getSelectedItem().toString();

        if (cargo.equals("Profesor")) {
            crearProfesor(fecha);
        } else {
            crearAdministrativo(fecha);
        }
    }

    private void crearProfesor(Fecha fecha) {
        String id = pantallaAniadir.txtId.getText().trim();
        String nombre = pantallaAniadir.txtNombre.getText().trim();
        String apellido = pantallaAniadir.txtApellido.getText().trim();
        String especialidad = pantallaAniadir.txtEspecialidad.getText().trim();
        String tipoProfesor = pantallaAniadir.cmbTipoDeProfesor.getSelectedItem().toString();

        try {
            if (tipoProfesor.equals("Catedratico")) {
                double valorHora = Double.parseDouble(pantallaAniadir.txtValorHoraTrabajada.getText().trim());
                double horasTrabajadas = Double.parseDouble(pantallaAniadir.txtHorasTrabajadas.getText().trim());
                
                ProfesorCatedratico profesorCat = new ProfesorCatedratico(
                        valorHora, horasTrabajadas, especialidad, id, nombre, apellido, fecha, "Profesor", "0"
                );
                profesorCat.setListaDeAsignatura(new ArrayList<>(listaDeMaterias));
                controlPantallaPrincipal.getListaDeProfesores().add(profesorCat);
                
            } else if (tipoProfesor.equals("Ocasional")) {
                double valorHora = Double.parseDouble(pantallaAniadir.txtValorHoraTrabajada.getText().trim());
                double horasExtra = Double.parseDouble(pantallaAniadir.txtHorasTrabajadas.getText().trim());
                
                ProfesorOcacional profesorOca = new ProfesorOcacional(
                        horasExtra, valorHora, especialidad, id, nombre, apellido, fecha, "Profesor", "2200000"
                );
                profesorOca.setListaDeAsignatura(new ArrayList<>(listaDeMaterias));
                controlPantallaPrincipal.getListaDeProfesores().add(profesorOca);
                
            } else if (tipoProfesor.equals("Asociado")) {
                ProfesorAsociado profesorAso = new ProfesorAsociado(
                        especialidad, id, nombre, apellido, fecha, "Profesor", "3500000"
                );
                profesorAso.setListaDeAsignatura(new ArrayList<>(listaDeMaterias));
                controlPantallaPrincipal.getListaDeProfesores().add(profesorAso);
            }

            controlPantallaPrincipal.actualizarComboProfesores();
            JOptionPane.showMessageDialog(pantallaAniadir, "Profesor " + tipoProfesor + " agregado con éxito");
            limpiarYSalir();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(pantallaAniadir, "Horas o valor hora inválidos numéricamente");
        }
    }

    private void crearAdministrativo(Fecha fecha) {
        String id = pantallaAniadir.txtId.getText().trim();
        String nombre = pantallaAniadir.txtNombre.getText().trim();
        String apellido = pantallaAniadir.txtApellido.getText().trim();
        String txtBono = pantallaAniadir.txtEspecialidad.getText().trim();

        try {
            double bonoFijo = txtBono.isEmpty() ? 0 : Double.parseDouble(txtBono);

            Administrativo administrativo = new Administrativo(bonoFijo, id, nombre, apellido, fecha, "Administrativo", "1300000");

            controlPantallaPrincipal.getListaDeAdministrativos().add(administrativo);
            controlPantallaPrincipal.actualizarComboAdministrativos();

            JOptionPane.showMessageDialog(pantallaAniadir, "Administrativo agregado con éxito");
            limpiarYSalir();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(pantallaAniadir, "El valor ingresado en el bono no es un número válido");
        }
    }

    private void limpiarYSalir() {
        pantallaAniadir.txtId.setText("");
        pantallaAniadir.txtNombre.setText("");
        pantallaAniadir.txtApellido.setText("");
        pantallaAniadir.txtDiaDeIngreso.setText("");
        pantallaAniadir.txtMesdeIngreso.setText("");
        pantallaAniadir.txtAnioDeIngreso.setText("");
        pantallaAniadir.txtEspecialidad.setText("");
        pantallaAniadir.txtHorasTrabajadas.setText("");
        pantallaAniadir.txtValorHoraTrabajada.setText("");
        pantallaAniadir.chekAniadirMateria.setSelected(false);
        listaDeMaterias.clear();
        pantallaAniadir.setVisible(false);
    }

    private void precargarAsignaturas() {
        listaDeAsignaturas.clear(); // Limpiamos la lista para evitar duplicidad de elementos
        listaDeAsignaturas.add(new Asignatura("1150101", "Cálculo Integral", 4, 64));
        listaDeAsignaturas.add(new Asignatura("1150102", "Álgebra Lineal", 3, 48));
        listaDeAsignaturas.add(new Asignatura("1150103", "Física Mecánica", 4, 64));
        listaDeAsignaturas.add(new Asignatura("1150104", "Física Estática", 4, 64));
        listaDeAsignaturas.add(new Asignatura("1150105", "Estructuras de Datos", 3, 48));
        listaDeAsignaturas.add(new Asignatura("1150106", "Análisis y Desarrollo de Software", 5, 80));
        listaDeAsignaturas.add(new Asignatura("1150107", "Programación Orientada a Objetos", 4, 64));
        listaDeAsignaturas.add(new Asignatura("1150108", "Bases de Datos", 3, 48));
        listaDeAsignaturas.add(new Asignatura("1150109", "Ingeniería de Requisitos", 3, 48));
        listaDeAsignaturas.add(new Asignatura("1150110", "Arquitectura de Software", 4, 64));

        actualizarComboAsignaturas();
    }

    public void actualizarComboAsignaturas() {
        pantallaAniadir.cmbMaterias.removeAllItems();
        for (Asignatura asig : listaDeAsignaturas) {
            pantallaAniadir.cmbMaterias.addItem(asig); 
        }
    }
}