package buscacep;

import util.BuscadorCep;

public class AppEnderecoCep {

    public static void main(String[] args) {
        String cep = "93315130";
        BuscadorCep op = new BuscadorCep();
        op.encontraCep(cep);
        
    }
    
}