import java.awt.event.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

public class TelaCadastro {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Sistema VIP Ultimate - Edição Banco de Dados");
        janela.setSize(400, 400);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        JLabel rotuloNome = new JLabel("Nome do VIP:");
        rotuloNome.setBounds(20, 20, 200, 30);
        JTextField campoNome = new JTextField();
        campoNome.setBounds(20, 50, 250, 30);
        JLabel rotuloIdade = new JLabel("Idade:");
        rotuloIdade.setBounds(20, 90, 200, 30);
        JTextField campoIdade = new JTextField();
        campoIdade.setBounds(20, 120, 100, 30);
        JLabel rotuloCEP = new JLabel("CEP (Somente números):");
        rotuloCEP.setBounds(20, 160, 200, 30);
        JTextField campoCEP = new JTextField();
        campoCEP.setBounds(20, 190, 150, 30);
        JButton botaoAdicionar = new JButton("Salvar no Banco");
        botaoAdicionar.setBounds(20, 250, 150, 40);
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String idadeString = campoIdade.getText();
                String cep = campoCEP.getText();
                String enderecoFormatado = "Endereço não encontrado";
                try {
                    String url = "https://viacep.com.br/ws/" + cep + "/json/";
                    HttpClient cliente = HttpClient.newHttpClient();
                    HttpRequest pedido = HttpRequest.newBuilder().uri(URI.create(url)).build();
                    HttpResponse<String> bandeja = cliente.send(pedido, HttpResponse.BodyHandlers.ofString());
                    String json = bandeja.body();
                    String rua = json.split("\"logradouro\": \"")[1].split("\"")[0];
                    String bairro = json.split("\"bairro\": \"")[1].split("\"")[0];
                    String uf = json.split("\"uf\": \"")[1].split("\"")[0];
                    enderecoFormatado = rua + " (" + bairro + " - " + uf + ")";
                } catch (Exception erroInternet) {
                    System.out.println("Erro de conexão ou CEP inválido.");
                }
                try {
                    String urlBanco = "jdbc:sqlite:banco_vip.db";
                    Connection conexao = DriverManager.getConnection(urlBanco);
                    String sql = "INSERT INTO convidados (nome, idade, endereco) VALUES (?, ?, ?)";
                    PreparedStatement comando = conexao.prepareStatement(sql);
                    comando.setString(1, nome);
                    comando.setInt(2, Integer.parseInt(idadeString));
                    comando.setString(3, enderecoFormatado);
                    comando.executeUpdate();
                    conexao.close();

                } catch (Exception erroBanco) {
                    System.out.println("❌ Erro no Banco: " + erroBanco.getMessage());
                }
                String mensagemFinal = "✅ Salvo no SQLite com Sucesso!\n\nNome: " + nome + "\nIdade: " + idadeString + " anos\nEndereço: " + enderecoFormatado;
                JOptionPane.showMessageDialog(null, mensagemFinal);
                campoNome.setText("");
                campoIdade.setText("");
                campoCEP.setText("");
            }
        });

        janela.add(rotuloNome);
        janela.add(campoNome);
        janela.add(rotuloIdade);
        janela.add(campoIdade);
        janela.add(rotuloCEP);
        janela.add(campoCEP);
        janela.add(botaoAdicionar);

        janela.setVisible(true);
    }
}
