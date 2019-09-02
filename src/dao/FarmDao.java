package dao;

import data.Farm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FarmDao {

    public void add(Farm farm) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into farm values (?, ?, ?, ?, ?)");
            preparedStatement.setObject(1, farm.getId()!=null?farm.getId():UUID.randomUUID());
            preparedStatement.setString(2, farm.getName());
            preparedStatement.setString(3, farm.getOwner());
            preparedStatement.setDouble(4, farm.getxCoord());
            preparedStatement.setDouble(5, farm.getyCoord());
            preparedStatement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public List<Farm> getAll(){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            ResultSet resultSet = connection.createStatement().executeQuery("select * from farm");
            List<Farm> list = new ArrayList<>();
            while ( resultSet.next() ){
                Farm farm = new Farm(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getString("owner"),
                        resultSet.getDouble("coord_x"),
                        resultSet.getDouble("coord_y")
                );
                list.add(farm);
            }
            return list;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void delete(UUID id) {
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete from farm where id = ?");
            statement.setObject(1, id);
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public void update(Farm farm){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement  = connection.prepareStatement("update farm set " +
                    "name = ?, owner = ?, coord_x = ?, coord_y = ? where id = ?");

            statement.setString(1, farm.getName());
            statement.setString(2, farm.getOwner());
            statement.setDouble(3, farm.getxCoord());
            statement.setDouble(4, farm.getyCoord());
            statement.setObject(5, farm.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }
}
