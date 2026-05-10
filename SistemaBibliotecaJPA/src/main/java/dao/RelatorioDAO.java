package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class RelatorioDAO {
    private Connection conectar() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/biblioteca";
        return DriverManager.getConnection(url, "postgres", "postgres");
    }

    public void livrosMaisEmprestados() {
        String sql = "SELECT livro_id, COUNT(*) AS total FROM emprestimo GROUP BY livro_id ORDER BY total DESC";
        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long livroId = rs.getLong("livro_id");
                long total = rs.getLong("total");
                System.out.println("Livro ID: " + livroId + " | Total: " + total);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    public void emprestimosPorMembro() {
        String sql = "SELECT membro_id, COUNT(*) AS total FROM emprestimo GROUP BY membro_id ORDER BY total DESC";

        try (Connection conn = conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long membroId = rs.getLong("membro_id");
                long total = rs.getLong("total");
                System.out.println("Membro: " + membroId + "| Total: " + total);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
