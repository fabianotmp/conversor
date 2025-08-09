package conversor.controller;
import conversor.api.TaxaDeCambioApi;
import conversor.model.Menu;
import conversor.model.Moeda;
import conversor.service.ConversorDeMoeda;

import java.util.Scanner;

public class Controller {
    private String dupla;
    public String getDupla() {
        return dupla;
    }

    public void iniciar() {
        TaxaDeCambioApi api = new TaxaDeCambioApi();
        ConversorDeMoeda resultado = new ConversorDeMoeda();
        int opc = 0;
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
        while(opc != 7){
            Menu menu = new Menu();
            Scanner scanner = new Scanner(System.in);
            opc = scanner.nextInt();

            switch(opc){
                case 1:
                    dupla = "USD/ARS";
                    break;
                case 2:
                    dupla = "ARS/USD";
                    break;
                case 3:
                    dupla = "USD/BRL";
                    break;
                case 4:
                    dupla = "BRL/USD";
                    break;
                case 5:
                    dupla = "USD/COP";
                    break;
                case 6:
                    dupla = "COP/BRL";
                    break;
                case 7:
                    System.out.println("Saindo");
                    continue;
                default:
                    System.out.println("opção inválida");
                    break;
            }

            Moeda moeda = api.pegarTaxaDeCambio(dupla);


            System.out.println("Qual o valor em "+ moeda.getBase() + "?");
            Scanner scanner2 = new Scanner(System.in);
            double valorEntrada = scanner2.nextDouble();

            double valorCambio = moeda.getValor();

            ConversorDeMoeda conversor = new ConversorDeMoeda();
            double total = conversor.converter(valorEntrada, valorCambio);

            System.out.println("Valor "  + valorEntrada  + "["+moeda.getBase()+ "]" + " corresponde a " + total +"["+moeda.getTarget()+"]");
        }

    }
}
