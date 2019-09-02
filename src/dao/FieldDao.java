package dao;

import data.Farm;
import data.Field;
import data.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FieldDao {

    public void add(Field field){
        try(Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("insert into field values (?, ?, ?, ?, ?)");
            statement.setObject(1, field.getId());
            statement.setString(2, field.getName());
            statement.setDouble(3, field.getSquare());
            statement.setDate(4, field.getSowingDate());
            statement.setObject(5, field.getFarmId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public List<Field> getAll() {
        try ( Connection connection = ConnectionManager.getInstance().getConnection() ) {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from field");
            List<Field> list = new ArrayList<>();
            while ( resultSet.next() ) {
                Field field = new Field(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("field_name"),
                        resultSet.getInt("square"),
                        resultSet.getDate("sowing_date"),
                        UUID.fromString(resultSet.getString("farm_id"))
                        );
                list.add(field);
            }
            return list;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void delete(Field field){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete from field where id = ?");
            statement.setObject(1, field.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public void update(Field field){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement  = connection.prepareStatement("update field set " +
                    "field_name = ?, square = ?, sowing_date = ?, farm_id = ? where id = ?");
            statement.setString(1, field.getName());
            statement.setInt(2, field.getSquare());
            statement.setDate(3, field.getSowingDate());
            statement.setObject(4, field.getFarmId());
            statement.setObject(5, field.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

}
