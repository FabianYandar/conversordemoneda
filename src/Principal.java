import com.google.gson.*;
import org.json.JSONArray;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String direccion = "https://v6.exchangerate-api.com/v6/e328108004da40628221c661/latest/USD";
        Scanner lectura = new Scanner(System.in);
        //ConsultaDivisa consulta = new ConsultaDivisa();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        int opcion = 0;
        double divisa=0;
        double convertido=0;
        String menu = """ 
               ******************************************************** 
               Sea bienvenido/a al Conversor de Moneda:
               
               1 - Dólar ==> Peso argentino
               2 - Peso argentino ==> Dólar 
               3 - Dólar ==> Real brasileño
               4 - Real brasileño ==> Dólar
               5 - Dólar ==> Peso colombiano
               6 - Peso colombiano ==> Dólar
               7 - Salir 
               Elija una opcion válida
               ********************************************************
                """;

            ConsultaDivisa consulta = new ConsultaDivisa();
            Map<String, Double> conversionRates = consulta.buscaConversionRates();

            // Imprimir las tasas de conversión
            System.out.println("Tasas de Conversion");
            for (Map.Entry<String, Double> entry : conversionRates.entrySet()) {
                //System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        // Obtener los valores de las tasas ARS, BRL y COP
        Double tasaARS = conversionRates.get("ARS");
        Double tasaBRL = conversionRates.get("BRL");
        Double tasaCOP = conversionRates.get("COP");

        // Imprimir las tasas de conversión ARS, BRL y COP
        System.out.println("Tasa de conversión de ARS: " + tasaARS);
        System.out.println("Tasa de conversión de BRL: " + tasaBRL);
        System.out.println("Tasa de conversión de COP: " + tasaCOP);

        while(opcion!=7){
            System.out.println(menu);
            try {
                opcion = lectura.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Por favor ingrese solo valores numericos");
                opcion=7;
            }
            switch (opcion){

                    case 1:
                        System.out.println("Ingresa el valor que deseas convertir: ");
                        try {
                            divisa = lectura.nextDouble();
                            convertido = divisa * tasaARS;
                            System.out.println("El valor " + divisa + " [USD] corresponde al valor final de =>>> " + convertido + " ARS");
                        }catch (InputMismatchException e){
                            System.out.println("Por favor ingrese solo valores numericos");
                        }
                        break;
                    case 2:
                        System.out.println("\"Ingresa el valor que deseas convertir: ");
                        try {
                            divisa = lectura.nextDouble();
                            convertido = divisa / tasaARS;
                            System.out.println("El valor " + divisa + " [ARS] corresponde al valor final de =>>> " + convertido + " USD");
                        }catch (InputMismatchException e){
                            System.out.println("Por favor ingrese solo valores numericos");
                        }
                        break;
                    case 3:
                        System.out.println("\"Ingresa el valor que deseas convertir: ");
                        try {
                            divisa = lectura.nextDouble();
                            convertido = divisa * tasaBRL;
                            System.out.println("El valor " + divisa + " [USD] corresponde al valor final de =>>> " + convertido + " BRL");
                        }catch (InputMismatchException e){
                            System.out.println("Por favor ingrese solo valores numericos");
                        }break;
                    case 4:
                        System.out.println("\"Ingresa el valor que deseas convertir: ");
                        try{
                        divisa = lectura.nextDouble();
                        convertido = divisa / tasaBRL;
                        System.out.println("El valor " + divisa + " [BRL] corresponde al valor final de =>>> " + convertido + " USD");
                        }catch (InputMismatchException e){
                            System.out.println("Por favor ingrese solo valores numericos");
                        }break;
                    case 5:
                        System.out.println("\"Ingresa el valor que deseas convertir: ");
                        try {
                            divisa = lectura.nextDouble();
                            convertido = divisa * tasaCOP;
                            System.out.println("El valor " + divisa + " [USD] corresponde al valor final de =>>> " + convertido + " COP");
                        }catch (InputMismatchException e){
                        System.out.println("Por favor ingrese solo valores numericos");
                         }break;
                    case 6:
                        System.out.println("\"Ingresa el valor que deseas convertir: ");
                        try {
                            divisa = lectura.nextDouble();
                            convertido = divisa / tasaCOP;
                            System.out.println("El valor " + divisa + " [COP] corresponde al valor final de =>>> " + convertido + " USD");
                        }catch (InputMismatchException e){
                            System.out.println("Por favor ingrese solo valores numericos");
                        }
                        break;
                    case 7:
                        System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                        break;
                    default:
                        System.out.println("Opcion no valida");

            }
        }
    }
}
