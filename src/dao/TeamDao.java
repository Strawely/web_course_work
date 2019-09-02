package dao;

import data.Job;
import data.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamDao {
    public void add(Team team){
        try( Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("insert into team values (?, ?, ?)");
            statement.setObject(1, team.getId());
            statement.setString(2, team.getName());
            statement.setInt(3, team.getTechnics());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public List<Team> getAll() {
        try ( Connection connection = ConnectionManager.getInstance().getConnection() ) {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from team");
            List<Team> list = new ArrayList<>();
            while ( resultSet.next() ) {
                Team team = new Team();
                team.setId(UUID.fromString(resultSet.getString("id")));
                team.setName(resultSet.getString("team_name"));
                team.setTechnics(resultSet.getInt("technics"));
                list.add(team);
            }
            return list;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void delete(Team team){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete from team where id = ?");
            statement.setObject(1, team.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public void update(Team team){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement  = connection.prepareStatement("update team set team_name = ?, technics = ? where id = ?");
            statement.setObject(3, team.getId());
            statement.setString(1, team.getName());
            statement.setInt(2, team.getTechnics());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }
}
