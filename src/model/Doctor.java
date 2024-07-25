package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    //Atributos
    private String speciality;


    public Doctor(String name, String email) {
        super(name, email);
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(String data, String time) {
        //string a date es parciar
        availableAppointments.add(new AvailableAppointment(data, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable Appointments: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: Cruz Roja");
        System.out.println("Departamento: Cancerologia");
    }

    //clase anidada
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            //de string a date es parseo
            try {
                this.date = formatter.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.time = time;
        }

        public Date getDate(String DATE) {
            return date;
        }

        public String getDate( ){
            return formatter.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \nDate: " + date + "\nTime: " + time;
        }
    }
}


