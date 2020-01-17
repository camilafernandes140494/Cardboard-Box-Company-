package cardboardboxcompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardboardBoxCompany {

    public static void main(String[] args) throws IOException, SQLException {
       
        BufferedReader dados = new BufferedReader(new InputStreamReader(System.in));
        
        String origem, destino, tipoTransp, prioridade,  transporte, tempo;
        Integer distancia = null;
        int valor;
        float precoFinal;
        
        origem = "";
        destino = "";
        tipoTransp = "";
        prioridade = "";
        
         System.out.println("*************************** Cardboard Box Company ***************************" );

        while(origem.isEmpty())
        {
            System.out.println("Entre com a origem:");
            origem = dados.readLine();
        }
        while(destino.isEmpty())
        {
            System.out.println("Entre com o destino:");
            destino = dados.readLine();
        }

        while(distancia == null)
        {
         System.out.println("Entre com a distância:");
         distancia = Integer.parseInt(dados.readLine());
        }
        
        while(prioridade.isEmpty())
        {
            System.out.println("Entre com a prioridade :");
            prioridade = dados.readLine(); 
        }
                
        System.out.println("Entre com o tipo de transporte:");
        tipoTransp = dados.readLine();
        
         Connection c = conexao.Conexao.getConnection();
         System.out.println("Conexão aberta!");
         String sql = "SELECT * FROM `transportadora1`";
        
        Statement stmt = c.createStatement();
        ResultSet rs;
        
        rs = stmt.executeQuery(sql);
        
         while ( rs.next() ) {
                 transporte = rs.getString("idTipoTransporte");
                 valor = rs.getInt("valor");
                 tempo = rs.getString("tempo");

                System.out.println(transporte);
                System.out.println(valor);
                System.out.println(tempo);
         precoFinal = (distancia*valor)/10;
         System.out.println("Tranportadora 1 - R$ "+ precoFinal);
        }

            c.close();     
        
    }
    
    
}
