package co.com.siigo.automation.utils;

import net.datafaker.Faker;

import java.util.Locale;


public class FakerRandom {

    private static final Faker FAKER = new Faker(new Locale("es"));

    private FakerRandom(){}

    public static Faker get() {return FAKER;}

    public static String nombre(){return FAKER.name().firstName();}
    public static String apellido(){return FAKER.name().lastName();}
    public static String documento(){int length = FAKER.number().numberBetween(3, 14); // entre 3 y 13 dígitos
        StringBuilder sb = new StringBuilder();

        // primer dígito que no sea 0
        sb.append(FAKER.number().numberBetween(1, 10));

        for (int i = 1; i < length; i++) {
            sb.append(FAKER.number().numberBetween(0, 10));
        }

        return sb.toString();}
    public static String direccion(){return FAKER.address().streetAddress();}
    public static String correo(){return FAKER.internet().emailAddress();}
    public static String celular(){return "3"+FAKER.number().digits(9);}
    public static String codigoPostal(){
        int codigo = FAKER.number().numberBetween(1, 35);
        return String.format("0500%02d", codigo);
    }

}
