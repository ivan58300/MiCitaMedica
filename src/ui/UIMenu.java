package ui;

import modelo.Doctor;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MESES = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorRegistrado;
    public static Paciente pacienteRegistrado;

    public static void mostrarMenu(){
        System.out.println("Bienvenido a Mis citas");
        System.out.println("Selecciona la opción deseada");

        int respuesta = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("0. salir");

            Scanner sc = new Scanner(System.in);
            respuesta = Integer.valueOf(sc.nextLine());

            switch (respuesta){
                case 1:
                    respuesta = 0;
                    verificarUsuario(1);
                    break;
                case 2:
                    respuesta = 0;
                    verificarUsuario(2);
                    break;
                case 0:
                    respuesta = 0;
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (respuesta != 0);
    }

    private static void verificarUsuario(int tipoUsuario ){
        //tipoUsuario = 1 Doctor
        //tipoUsuario = 2 paciente

        ArrayList<Doctor> doctores = new ArrayList<>();
        doctores.add(new Doctor("Ivanoe Lopez","ivan@email.com"));
        doctores.add(new Doctor("Samuel Lopez","samuel@email.com"));
        doctores.add(new Doctor("Esther Lopez","esther@email.com"));

        ArrayList <Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Juan Perez","juan@email.com"));
        pacientes.add(new Paciente("Taylor Perez","taylor@email.com"));
        pacientes.add(new Paciente("Tyrone  Perez","tyrone@email.com"));

        boolean emailCorecto = false;
        do{
            System.out.println("Inserta tu correo electrónico. : [user@email.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if( tipoUsuario == 1){
                for(Doctor d : doctores){
                    if(d.getEmail().equals(email)){
                        emailCorecto = true;
                        //obtener el registro del doctor
                        doctorRegistrado = d;
                        UIMenuDoctor.mostrarMenuDoctor();
                    }
                }
            }
            if( tipoUsuario == 2){
                for( Paciente p : pacientes){
                    if(p.getEmail().equals(email)){
                        emailCorecto = true;
                        pacienteRegistrado = p;
                        UIMenuPaciente.mostrarMenuPaciente();
                    }
                }

            }

        }while (!emailCorecto);
    }

}

