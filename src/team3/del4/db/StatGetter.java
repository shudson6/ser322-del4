package team3.del4.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatGetter extends DBHandler {
    protected StatGetter() throws SQLException {
        super();
    }

    public List<String> getPositions() {
        try (Statement s = getStatement()) {
            ResultSet rs = s.executeQuery("select position from position;");
            ArrayList<String> list = new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getString("position"));
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return List.of();
        }
    }
}
